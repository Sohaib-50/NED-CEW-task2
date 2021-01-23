package com.example.cewtask2cs_1909619079;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    TextView website_txtview;
    TextView location_txtview;
    Button open_website_btn;
    Button open_location_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        website_txtview = findViewById(R.id.accelerate);
        location_txtview = findViewById(R.id.accelerate);
        open_website_btn = findViewById(R.id.accelerate);
        open_location_btn = findViewById(R.id.accelerate);

        open_website_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String website_input = website_txtview.getText().toString();

                // Validate input
                if (website_input.equals(""))
                {
                    Toast.makeText(MainActivity.this, "Please enter a website.", Toast.LENGTH_SHORT).show();
                }
                else if (!validWebsite(website_input))
                {
                    Toast.makeText(MainActivity.this, "Invalid input.", Toast.LENGTH_SHORT).show();
                }
                else  // valid url entered
                {
                    String url = "https://" + website_input;

                    Intent website_intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    startActivity(website_intent);
                }
            }

            open_location_btn.setOnclic
        });

    }

    private boolean validWebsite(String website) {
        // Check if website is valid (using Regex)
        String url_regex = "[-a-zA-Z0-9@:%._\\+~#=]{1,256}\\.[a-zA-Z0-9()]{1,6}\\b([-a-zA-Z0-9()@:%_\\+.~#?&//=]*)";
        Pattern pattern = Pattern.compile(url_regex);
        Matcher matcher = pattern.matcher(website);
        return matcher.matches();
    }
}