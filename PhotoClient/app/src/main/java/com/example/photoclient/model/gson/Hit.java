package com.example.photoclient.model.gson;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Hit {
    @Expose
    @SerializedName("webformatURL")
    public String webformatURL;
}
