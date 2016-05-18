package com.example.llw.demo_listview_listview;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by llw on 2016/5/17.
 */
public class Model extends AsyncTask<String, Void, String> {
    private static final String TAG = "Model";
    public String srt = "https://www.baidu.com/";
    StringBuilder stringbulider = null;
    public URL url = null;
    public HttpURLConnection httpURLConnection = null;
    public String sr = null;
    public RequestQueue requestQueue;
    public StringRequest stringRequest = null;

    public Context context;
    public MainActivity mainActivity;

    public Callback callback;

    public Model(Callback callback) {
        this.callback = callback;
        this.context = (Context) callback;

    }


    @Override
    protected String doInBackground(String... params) {
        requestQueue = Volley.newRequestQueue(context);
        stringRequest = new StringRequest(params[0], new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                Log.e(TAG, "onResponse: " + s);
                callback.back(s);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        });

        requestQueue.add(stringRequest);
        return null;
    }
}
