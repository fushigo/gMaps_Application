package com.css.google_maps_application;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.AsyncTask;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class GetAddressTask extends AsyncTask<Location, Void, String> {
    private Context mContext;
    private  OnTaskCompleted mListener;

    public GetAddressTask(Context context, OnTaskCompleted listener){
        mContext = context;
        mListener = listener;
    }

    @Override
    protected String doInBackground(Location... locations) {
        Geocoder geocoder = new Geocoder(mContext, Locale.getDefault());
        Location location = locations[0];
        List<Address> addresses = null;
        String result = "";

        try{
            addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
        } catch (IOException e) {
            result = "Service Not Available";
            throw new RuntimeException(e);
        }
        return result;
    }

    interface OnTaskCompleted{
        void onTaskCompleted(String result);
    }
}
