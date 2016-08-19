package com.example.daggersimple;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by evin on 4/28/16.
 */
@Module
public class SharedModule {

    String mBaseUrl;

    // Constructor needs one parameter to instantiate.
    public SharedModule(String baseUrl) {
        this.mBaseUrl = baseUrl;
    }

    // Dagger will only look for methods annotated with @Provides
    @Provides
    @Singleton
    // Application reference must come from AppModule.class
    SharedPreferences providesSharedPreferences(Application application) {
        return PreferenceManager.getDefaultSharedPreferences(application);
    }
    @Provides
    @Singleton
        // Application reference must come from AppModule.class
    OkHttpClient providesOkHttpClient() {
        return new OkHttpClient();
    }
    @Provides
    @Singleton
        // Application reference must come from AppModule.class
    Request providesOkHttpClientRequest() {
        return  new Request.Builder()
                .url("http://google.com")
                .build();
    }
}