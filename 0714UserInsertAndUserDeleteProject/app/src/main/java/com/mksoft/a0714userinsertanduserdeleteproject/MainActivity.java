package com.mksoft.a0714userinsertanduserdeleteproject;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.mksoft.a0714userinsertanduserdeleteproject.Repository.APIRepo;
import com.mksoft.a0714userinsertanduserdeleteproject.Repository.UserData;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

public class MainActivity extends AppCompatActivity implements HasSupportFragmentInjector {

    @Inject
    APIRepo apiRepo;

    @Inject
    DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector;
    @Override
    public DispatchingAndroidInjector<Fragment> supportFragmentInjector() {
        return dispatchingAndroidInjector;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.configureDagger();
        init();
    }

    private void configureDagger(){
        AndroidInjection.inject(this);
    }//주입
    EditText insertID;
    EditText insertName;
    EditText insertAge;
    Button insertButton;
    UserData userData = new UserData();

    EditText deleteID;
    Button deleteButton;

    EditText searchID;
    Button searchIDButton;
    TextView searchResult;
    Button getUsersButton;
    TextView userInfo;

    void init(){

        insertID = findViewById(R.id.insert_id_edit);
        insertName = findViewById(R.id.insert_name_edit);
        insertAge = findViewById(R.id.insert_age_edit);
        insertButton = findViewById(R.id.insert_user);
        insertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = "";
                String name = "";
                String age = "";
                id = insertID.getText().toString();
                name = insertName.getText().toString();
                age = insertAge.getText().toString();
                if(id.length()==0 || name.length() ==0 || age.length()==0){
                    Toast.makeText(getApplicationContext(), "empty",Toast.LENGTH_SHORT).show();
                    return;
                }
                userData.setAge(Integer.parseInt(age));
                userData.setName(name);
                userData.setId(id);
                apiRepo.insertUser(userData);
            }
        });

        deleteID = findViewById(R.id.delete_id_edit);
        deleteButton = findViewById(R.id.delete_user);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = "";
                id = deleteID.getText().toString();
                if(id.length() == 0){
                    Toast.makeText(getApplicationContext(), "empty",Toast.LENGTH_SHORT).show();
                    return;
                }
                apiRepo.deletUser(id);
            }
        });

        searchID = findViewById(R.id.search_id_edit);
        searchIDButton = findViewById(R.id.search_user);
        searchIDButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = "";
                id = searchID.getText().toString();
                if(id.length() == 0){
                    Toast.makeText(getApplicationContext(), "empty",Toast.LENGTH_SHORT).show();
                    return;
                }
                Log.d("test0714", id);
                apiRepo.getUser(id, searchResult);
            }
        });

        userInfo = findViewById(R.id.user_list);
        getUsersButton = findViewById(R.id.all_view_user);
        searchResult = findViewById(R.id.user_result);
        getUsersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                apiRepo.getUsers(userInfo);
            }
        });

    }




}
