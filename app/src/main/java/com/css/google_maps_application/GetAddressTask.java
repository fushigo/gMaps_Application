package com.css.google_maps_application;

import android.content.Context;
import android.location.Location;
import android.os.AsyncTask;

public class GetAddressTask extends AsyncTask<Location, Void, String> {
    private Context mContext;
    private  OnTaskCompleted mListener;

    public GetAddressTask(Context context, OnTaskCompleted listener){
        mContext = context;
        mListener = listener;
    }

    @Override
    protected String doInBackground(Location... locations) {
        return null;
    }

    interface OnTaskCompleted{
        void onTaskCompleted(String result);
    }
}
