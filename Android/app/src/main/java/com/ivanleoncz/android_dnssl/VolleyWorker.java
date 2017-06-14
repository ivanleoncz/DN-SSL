package com.ivanleoncz.android_dnssl;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

class VolleyWorker {

    private Context ctx;
    private String username;
    private String password;
    private RequestQueue requestQueue;
    private String toastError = "Network Timeout...";

    VolleyWorker(Context context, String usernameStr, String passwordStr) {
        ctx = context;
        username = usernameStr;
        password = passwordStr;
        requestQueue = Volley.newRequestQueue(ctx);
    }

    interface LoginCallback {
        void onSuccess(String result);
    }

    void login(final LoginCallback loginCallback){

        final String url = "http://192.168.1.68:5000/login";

        // beginning of the request --->
        StringRequest postLogin = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        loginCallback.onSuccess(response);
                        Log.d("VolleyWorker","Request OK! ");
                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                        Toast.makeText(ctx,toastError,Toast.LENGTH_LONG).show();
                        Log.d("VolleyWorker","Request NOK... ");
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

        }; // <--- enf of the request

        try {
            requestQueue.add(postLogin);
        } catch (Exception e) {
            Log.d("VolleryWorker","failed to add request");
            e.printStackTrace();
        }
    }


}
