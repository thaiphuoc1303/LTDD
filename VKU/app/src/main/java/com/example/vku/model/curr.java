package com.example.vku.model;

public class curr {
    private String async;
    private int error;
    private String message;
    private String request_id;

    public curr(String async, int error, String message, String request_id) {
        this.async = async;
        this.error = error;
        this.message = message;
        this.request_id = request_id;
    }

    public String getAsync() {
        return async;
    }

    public void setAsync(String async) {
        this.async = async;
    }

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRequest_id() {
        return request_id;
    }

    public void setRequest_id(String request_id) {
        this.request_id = request_id;
    }
}
