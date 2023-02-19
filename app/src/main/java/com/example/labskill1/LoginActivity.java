package com.example.labskill1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText usernameET, passwordET;
    Button loginBtn, cancelBtn;
    TextView registerTV, forgotPwdTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameET = (EditText) findViewById(R.id.usernameET);
        passwordET = (EditText) findViewById(R.id.passwordET);
        loginBtn = (Button) findViewById(R.id.loginBtn);
        cancelBtn = (Button) findViewById(R.id.cancelBtn);
        registerTV = (TextView) findViewById(R.id.registerTV);
        forgotPwdTV = (TextView) findViewById(R.id.forgotPwdTV);

        loginBtn.setOnClickListener(new ProcessClick());
        cancelBtn.setOnClickListener(new ProcessClick());
    }

    public void login(){
        String username = usernameET.getText().toString();
        String password = passwordET.getText().toString();

        if ((!username.isEmpty()) && (!password.isEmpty())) {
            if ((username.equals("admin")) && (password.equals("admin"))) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(getApplicationContext(), "Invalid username or password", Toast.LENGTH_LONG).show();
            }
        }
    }

    class ProcessClick implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.loginBtn: login();
                                    break;
                case R.id.cancelBtn:finish();
                                    break;
            }
        }
    }
}