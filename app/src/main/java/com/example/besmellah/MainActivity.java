package com.example.besmellah;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void Buttontapped(View view) {
        EditText txtUsername=findViewById(R.id.txtUsername);
        EditText txtPassword=findViewById(R.id.txtPassword);
        String Username=txtUsername.getText().toString();
        String Password=txtPassword.getText().toString();
        Gonnect.getData("http://spneshaei.com/mil/getEmails.php?username="
                        + Username + "&password=" + Password, this, new Gonnect.ResponseSuccessListener() {
                    @Override
                    public void responseRecieved(String response) {
                        if(response.equals("invalid-user")){
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(MainActivity.this,"invalid-user", Toast.LENGTH_LONG).show();
                                }
                            });
                        }else {
                            ArrayList<Email> NewEmails =new Gson().fromJson(response,new TypeToken<ArrayList<Email>>(){}.getType());
                            Email.getAllEmails().clear();
                            Email.getAllEmails().addAll(NewEmails);
                            Intent intent= new Intent(MainActivity.this,EmailListActivity.class);
                            startActivity(intent);

                        }

                    }
                },
                new Gonnect.ResponseFailureListener() {
                    @Override
                    public void responseFailed(IOException exception) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(MainActivity.this,"Error in Loading", Toast.LENGTH_LONG).show();


                            }
                        });

                    }
                }
        );
    }
}