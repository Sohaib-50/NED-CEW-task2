package com.example.cewtask2cs_1909619079;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    EditText website_editText;
    EditText location_editText;
    Button open_website_btn;
    Button open_location_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        website_editText = findViewById(R.id.et_openWeb);
        location_editText = findViewById(R.id.et_openLocation);
        open_website_btn = findViewById(R.id.btn_openWeb);
        open_location_btn = findViewById(R.id.btn_openLocation);


        open_website_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String website_input = website_editText.getText().toString();

                // Validate input
                if (website_input.equals(""))
                {
                    Toast.makeText(MainActivity.this, "Please enter a website.", Toast.LENGTH_SHORT).show();
                }
                else if (!validWebsite(website_input))
                {
                    Toast.makeText(MainActivity.this, "Please enter a valid website", Toast.LENGTH_SHORT).show();
                }
                else  // valid url entered
                {
                    Intent website_intent = new Intent(Intent.ACTION_VIEW, Uri.parse(website_input));
                    startActivity(website_intent);
                }
            }

        });

        open_location_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String location_input = location_editText.getText().toString();
                if (location_input.equals(""))
                {
                    Toast.makeText(MainActivity.this, "Please enter a location.", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Intent map_intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=" + location_input));
                    startActivity(map_intent);
                }
            }
        });

    }

    private boolean validWebsite(String website) {
        // Check if website is valid (using Regex)
        String url_regex = "(http://|https://)(www.)?([a-zA-Z0-9]+).[a-zA-Z0-9]*.[a-z]{3}.?([a-z]+)?";
        Pattern pattern = Pattern.compile(url_regex);
        Matcher matcher = pattern.matcher(website);
        return matcher.matches();
    }
}