package com.georgebrown.lab3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button activity_btn, web_btn, map_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        activity_btn = findViewById(R.id.activity_btn);
        web_btn = findViewById(R.id.web_btn);
        map_btn = findViewById(R.id.map_btn);

        activity_btn.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(),
                    SecondActivity.class);
            startActivity(intent);
        });

        web_btn.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("http://georgebrown.ca"));
            startActivity(intent);
        });

        map_btn.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("geo:43.6761356, -79.4130149?q=" + Uri.encode("restaurants")));
            startActivity(intent);
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        switch (id){
            case R.id.activity_item:
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                startActivity(intent);
                return true;
            default:return super.onOptionsItemSelected(item);
        }


    }
}
