package com.ashok.simplemvp.others;

import com.google.common.base.MoreObjects;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Ashok on 20/04/17.
 */

public class Model implements Serializable {

    @SerializedName("login")
    String loginName;

    @SerializedName("html_url")
    String url;

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("Login", loginName)
                .add("Url", url)
                .toString();
    }
}
