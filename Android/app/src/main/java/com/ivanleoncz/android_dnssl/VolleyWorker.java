package com.ivanleoncz.android_dnssl;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

class VolleyWorker {

    private String username;
    private String password;

    private RequestQueue requestQueue;

    VolleyWorker(String usernameStr, String passwordStr) {
        username = usernameStr;
        password = passwordStr;
    }

    interface LoginCallback {
        void onSuccess(String result);
    }

    void login(final LoginCallback loginCallback){

        final String url = "http://192.168.100.17:5000/login";

        // beginning of the request --->
        StringRequest postLogin = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        loginCallback.onSuccess(response);
                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                    }
                }) { // post parameters
                    @Override
                    protected Map<String, String> getParams()
                    {
                        Map<String, String> params = new HashMap<>();
                            params.put("username", username);
                            params.put("password", password);
                        return params;
                    }

        };
        // <--- enf of the request

        try {
            requestQueue.add(postLogin);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
