package com.example.parcial2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;

public class DashboardView extends AppCompatActivity {
    private TextView user;
    private Button btnMapa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_view);

        user = findViewById(R.id.userEmail);
        String email = getIntent().getStringExtra("userEmail");
        user.setText(email);

        btnMapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //here nav to the map view
                Intent intent = new Intent(DashboardView.this, MapsActivity.class);
                startActivity(intent);
            }
        });
    }
}