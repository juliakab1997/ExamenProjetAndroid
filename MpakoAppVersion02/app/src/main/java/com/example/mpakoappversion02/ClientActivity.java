package com.example.mpakoappversion02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ClientActivity extends AppCompatActivity {
    private TextView InfosUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client);

        InfosUser = findViewById(R.id.idTemp);

        Bundle bundle = getIntent().getExtras();
        String UserName = bundle.getString("EmailClient");
        String PasswordUser = bundle.getString("PasswordClient");

        InfosUser.setText("User name: "+UserName+"  Password: "+PasswordUser);
    }
}