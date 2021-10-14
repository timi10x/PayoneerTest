
package com.payoneertest.model;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;

@SuppressWarnings("unused")
public class Networks {

    @Expose
    private ArrayList<Applicable> applicable;

    public ArrayList<Applicable> getApplicable() {
        return applicable;
    }

    public void setApplicable(ArrayList<Applicable> applicable) {
        this.applicable = applicable;
    }

}
