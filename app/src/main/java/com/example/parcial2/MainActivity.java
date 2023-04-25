package com.example.parcial2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private EditText emailText;
    private EditText passwordText;
    private Button btnLogin;
    private Button testBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DialogError dialogError = new DialogError();

        String testEmail = "test@example";
        String testPassword = "123";

        emailText = findViewById(R.id.emailText);
        passwordText = findViewById(R.id.passwordText);
        btnLogin = findViewById(R.id.btnLogin);

        testBtn = findViewById(R.id.testBTN);

        testBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DashboardView.class);
                startActivity(intent);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailText.getText().toString().trim();
                String password = passwordText.getText().toString().trim();

                if(testEmail.equals(email) &&  testPassword.equals(password)) {
                    //here nav to the dashboard
                    Intent intent = new Intent(MainActivity.this, DashboardView.class);
                    intent.putExtra("userEmail", email);
                    startActivity(intent);
                } else {
                    dialogError.show(getSupportFragmentManager(), "invalid");
                }
            }
        });
    }
}