
package com.payoneertest.model;

import com.google.gson.annotations.Expose;

@SuppressWarnings("unused")
public class Status {

    @Expose
    private String code;
    @Expose
    private String reason;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

}
