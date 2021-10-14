
package com.payoneertest.model;

import com.google.gson.annotations.Expose;

@SuppressWarnings("unused")
public class Style {

    @Expose
    private String language;

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

}
