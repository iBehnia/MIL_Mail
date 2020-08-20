package com.example.besmellah;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.yqritc.recyclerviewflexibledivider.HorizontalDividerItemDecoration;

public class EmailListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_list);

        RecyclerView recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new HorizontalDividerItemDecoration.Builder(this).color(Color.CYAN).build());
        EmailAdapter emailAdapter=new EmailAdapter(this,Email.getAllEmails());
        recyclerView.setAdapter(emailAdapter);



    }

    public void Buttontapped(View view) {
        Intent intent=new Intent(this,SenderActivity.class);
        startActivity(intent);
    }
}