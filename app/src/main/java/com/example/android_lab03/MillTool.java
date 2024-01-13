package com.example.android_lab03;

public class MillTool {
    private String name;
    private String type;
    private int size;
    private String material;

    public MillTool(String name, String type, int size, String material){
        this.name = name;
        this.type = type;
        this.size = size;
        this.material = material;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }

    public String getMaterial() {
        return material;
    }
    public void setMaterial(String material) {
        this.material = material;
    }
}
