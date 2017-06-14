package com.ivanleoncz.android_dnssl;

import android.util.Log;

import org.json.JSONObject;

/**
 * Created by ivanleon on 13/06/17.
 */

class JsonParser {

    private String json;
    private JSONObject jo;

    String username;

    JsonParser(String json) {
        this.json = json;
    }

    void parser() {
        try {
            jo = new JSONObject(json);
            username = (String) jo.get("Name");
            Log.d("JsonParser","returning string:" + username);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
