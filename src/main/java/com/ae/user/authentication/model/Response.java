package com.ae.user.authentication.model;

import java.util.List;

public class Response<T> {

    private Integer code;
    private String message;
    private List<T> results;

    public Response(Integer code, String message, List<T> results) {
        this.code = code;
        this.message = message;
        this.results = results;
    }

    public Response() {
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<T> getResults() {
        return results;
    }

    public void setResults(List<T> results) {
        this.results = results;
    }
}
