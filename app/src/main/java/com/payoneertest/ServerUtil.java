package com.payoneertest;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class ServerUtil {
    public static final String BASE_URL = "https://raw.githubusercontent.com/optile/checkout-android/develop/shared-test/lists/";

    public static final String NETWORK_LOST_ERROR_MESSAGE = "Network connection lost, could not process request. Please check your connection and try again.";
    public static final String DEFAULT_ERROR_MESSAGE = "Unable to connect to the server at this moment, Please try again.";
    public static final String NETWORK_ERROR_MESSAGE = "Error communicating with the server. Please try again.";


    public static boolean isNetworkUnavailable(Context context){
        ConnectivityManager connectivityManager = (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo == null || !activeNetworkInfo.isConnected();
    }

}
