package com.example.android_lab03;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import android.database.sqlite.SQLiteDatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;


import com.example.android_lab03.databinding.ActivityMainBinding;

import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private DbHelper dbHelper = new DbHelper(this);
    private SQLiteDatabase db;
    private ActivityMainBinding binding;
    public static final String LOG_TAG = "My_log";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(R.layout.fragment_first);

        db = dbHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();

        ListView listView = (ListView) findViewById(R.id.list_item);
        List<MillTool> listTool = getList();
        MillToolAdapter adapter = new MillToolAdapter(this, listTool);
        listView.setAdapter(adapter);

        EditText nameEdit = findViewById(R.id.nameInput);
        EditText typeEdit = findViewById(R.id.typeInput);
        EditText sizeEdit = findViewById(R.id.sizeInput);
        EditText materialEdit = findViewById(R.id.matInput);

        Button button = findViewById(R.id.button_push_to_list);

        button.setOnClickListener(view12 -> {
            cv.put("name", nameEdit.getText().toString());
            cv.put("tooltype", typeEdit.getText().toString());
            cv.put("size", Integer.valueOf(sizeEdit.getText().toString()));
            cv.put("material", materialEdit.getText().toString());

            long rowID = db.insert("tool", null, cv);
            Log.d(LOG_TAG, "row inserted, ID: " + rowID);
            clearForm();
            adapter.notifyDataSetChanged();
        });
    }

    private void clearForm() {
        EditText e = findViewById(R.id.nameInput);
        e.getText().clear();
        e = findViewById(R.id.typeInput);
        e.getText().clear();
        e = findViewById(R.id.sizeInput);
        e.getText().clear();
        e = findViewById(R.id.matInput);
        e.getText().clear();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    private List<MillTool> getList(){
        List<MillTool> tools = new ArrayList<>();
        Log.d(LOG_TAG, "------ Rows in tool--------");
        Cursor c = db.query("tool", null,null,null, null, null,null);

        if (c.moveToFirst()){
            int idColIndex = c.getColumnIndex("id");
            int nameColIndex = c.getColumnIndex("name");
            int typeColIndex = c.getColumnIndex(("tooltype"));
            int sizeColIndex = c.getColumnIndex(("size"));
            int materialColIndex = c.getColumnIndex(("material"));

            do {
                tools.add(new MillTool(
                        c.getString(nameColIndex),
                        c.getString(typeColIndex),
                        c.getInt(sizeColIndex),
                        c.getString(materialColIndex)));
                Log.d(LOG_TAG,"name: " + c.getString(nameColIndex)
                        + ", type: " + c.getString(typeColIndex)
                        + ", size: " + c.getInt(sizeColIndex)
                        + ", material: " + c.getString(materialColIndex));
            } while (c.moveToNext());


        }else{
            Log.d(LOG_TAG, "0 rows");
        }

        return tools;
    }
}