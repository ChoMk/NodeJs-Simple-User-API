package com.mksoft.a0714userinsertanduserdeleteproject.Repository;


import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;


import com.mksoft.a0714userinsertanduserdeleteproject.App;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executor;

import javax.inject.Inject;
import javax.inject.Singleton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@Singleton
public class APIRepo {

    private final ApiService webservice;

    @Inject
    public APIRepo(ApiService webservice) {
        Log.d("testResultRepo", "make it!!!");
        this.webservice = webservice;

    }
    public void deletUser(String id){
        webservice.deleteUser(id).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(App.context, "network err", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(response.body().equals("success")){
                    Toast.makeText(App.context, "deleteUser", Toast.LENGTH_SHORT).show();

                }else{
                    Toast.makeText(App.context, "deleteFail", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.d("test0714",t.toString());
                Toast.makeText(App.context, "network err", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void getUser(String id, final TextView textView){
        webservice.getUser(id).enqueue(new Callback<UserData>() {
            @Override
            public void onResponse(Call<UserData> call, Response<UserData> response) {
                Log.d("test0714", response.body().toString());
                if(!response.isSuccessful()){
                    Toast.makeText(App.context, "network err", Toast.LENGTH_SHORT).show();
                    return;
                }
                textView.setText("");
                textView.append(response.body().toString()+"\n");
            }

            @Override
            public void onFailure(Call<UserData> call, Throwable t) {
                textView.setText("network err");
                Log.d("test0714", t.toString());
                Toast.makeText(App.context, "network err", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void getUsers(final TextView textView){
        webservice.getUsers().enqueue(new Callback<List<UserData>>() {
            @Override
            public void onResponse(Call<List<UserData>> call, Response<List<UserData>> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(App.context, "network err", Toast.LENGTH_SHORT).show();
                    return;
                }
                textView.setText("");
                for(int i =0; i<response.body().size(); i++){
                    textView.append(response.body().get(i).toString()+"\n");
                }

            }

            @Override
            public void onFailure(Call<List<UserData>> call, Throwable t) {
                textView.setText("network err");
                Log.d("test0714", t.toString());
                Toast.makeText(App.context, "network err", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void insertUser(UserData userData){
        webservice.postUser(userData).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.d("test0714", response.body());
                if(!response.isSuccessful()){
                    Toast.makeText(App.context, "network err", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(response.body().equals( "success")){
                    Toast.makeText(App.context, "insertUser", Toast.LENGTH_SHORT).show();

                }else{
                    Toast.makeText(App.context, "insertFail", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.d("test0714", t.toString());
                Toast.makeText(App.context, "network err", Toast.LENGTH_SHORT).show();
            }
        });
    }


}
