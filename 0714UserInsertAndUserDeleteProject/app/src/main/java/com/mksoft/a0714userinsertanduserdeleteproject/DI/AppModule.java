package com.mksoft.a0714userinsertanduserdeleteproject.DI;


import android.app.Application;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mksoft.a0714userinsertanduserdeleteproject.App;
import com.mksoft.a0714userinsertanduserdeleteproject.Repository.APIRepo;
import com.mksoft.a0714userinsertanduserdeleteproject.Repository.ApiService;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class AppModule {



// --- NETWORK INJECTION ---


    @Provides
    Gson provideGson() { return new GsonBuilder().create(); }

    @Provides
    Retrofit provideRetrofit(Gson gson) {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(App.BASE_URL)
                .build();

        return retrofit;
    }

    @Provides
    @Singleton
    ApiService provideApiWebservice(Retrofit restAdapter) {
        return restAdapter.create(ApiService.class);
    }


    // --- REPOSITORY INJECTION ---
    @Provides
    Executor provideExecutor() {
        return Executors.newSingleThreadExecutor();
    }


    @Provides
    @Singleton
    APIRepo provideAPIRepository(ApiService apiService) {
        return new APIRepo(apiService);
    }


}
