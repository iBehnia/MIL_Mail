package com.example.besmellah;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SenderActivity extends AppCompatActivity {

    AlertDialog.Builder builder;

    String body;
    String Adress;
    String Subject;
    EditText txtBody;
    EditText txtAdress;
    EditText txtSubject;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sender);
        txtBody = findViewById(R.id.txtBody);
    }

    public void Buttontapped(View view ) {
        body = txtBody.getText().toString();
        if( body.equals("")){
            builder= new AlertDialog.Builder(this);
            builder.setTitle("Error");
            builder.setMessage("Pleas Fill Body");
            builder.show();
        }else {
            Adress=txtAdress.getText().toString();
            Subject=txtSubject.getText().toString();
            Intent intent=new Intent(Intent.ACTION_SEND);
            intent.setType("*/*");
            intent.putExtra(Intent.EXTRA_EMAIL,Adress);
            intent.putExtra(Intent.EXTRA_SUBJECT,Subject);
            intent.putExtra(Intent.EXTRA_TEXT,body);
            startActivity(Intent.createChooser( intent , "Choose an Email client :"));

        }
    }
}