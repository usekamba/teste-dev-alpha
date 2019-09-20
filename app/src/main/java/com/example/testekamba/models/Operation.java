package com.example.testekamba.models;

public class Operation {


    private int imgResource;
    private String operationName;

    public Operation(int imgResource, String operationName) {
        this.imgResource = imgResource;
        this.operationName = operationName;
    }

    public int getImgResource() {
        return imgResource;
    }

    public String getOperationName() {
        return operationName;
    }

    public void setImgResource(int imgResource) {
        this.imgResource = imgResource;
    }

    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }
}
