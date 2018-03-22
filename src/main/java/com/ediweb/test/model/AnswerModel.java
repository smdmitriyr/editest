package com.ediweb.test.model;

public class AnswerModel<T> {

    private T result;
    private String message;

    public AnswerModel(T result, String message) {
        this.result = result;
        this.message = message;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
