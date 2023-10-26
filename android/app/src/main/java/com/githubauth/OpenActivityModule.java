package com.githubauth;

import android.content.Intent;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.google.firebase.auth.FirebaseAuth;

public class OpenActivityModule extends ReactContextBaseJavaModule {
    public OpenActivityModule (ReactApplicationContext reactContext){
        super(reactContext);
    }

    @NonNull
    @Override
    public String getName() {
        return "OpenActivity";
    }

    @ReactMethod
    public void open(Callback callback){
        Intent intent = new Intent(getCurrentActivity(),MainActivity2.class);
        getCurrentActivity().startActivity(intent);

        callback.invoke("Hello");
    }
    @ReactMethod
    public void getEmail(Callback callback){
        try {
            callback.invoke(FirebaseAuth.getInstance().getCurrentUser().getEmail().toString());
        }catch (Exception e){
            callback.invoke("Reauthenticate to verify it's you!!");
        }

    }
}
