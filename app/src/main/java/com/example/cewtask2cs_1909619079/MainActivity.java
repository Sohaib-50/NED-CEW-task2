package com.example.cewtask2cs_1909619079;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText etOpenLink ;
    Button btnOpenLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etOpenLink = (EditText) findViewById(R.id.et_openWeb);
        btnOpenLink = (Button) findViewById(R.id.btn_openWeb);

        btnOpenLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String link = etOpenLink.getText().toString();
                Uri uri = Uri.parse(link) ;
                Intent intent = new Intent(Intent.ACTION_VIEW,uri);
            }
        });
    }
}