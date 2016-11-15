package com.aykuttasil.imageupload.rest.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by aykutasil on 14.11.2016.
 */

public class BaseRestResponse {

    @SerializedName("success")
    @Expose
    private String Success;

    @SerializedName("status")
    @Expose
    private String Status;


    public String getSuccess() {
        return Success;
    }

    public void setSuccess(String success) {
        Success = success;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }
}
