package com.example.androiddeveloper.eqrawaertaqe;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class SignUp extends Activity {

    EditText etEmail,etUsername,etPassword;
    Button btnReg;
    String email,username,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        etUsername = (EditText)findViewById(R.id.username);
        etEmail = (EditText)findViewById(R.id.email);
        etPassword = (EditText)findViewById(R.id.password);
        btnReg = (Button) findViewById(R.id.signup);

        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {register();}
        });
    }
    public void register(){
        intialize();
        if(!validate()) {

        }
        else {
            onRegisterSuccess();
        }

    }
    public void onRegisterSuccess(){

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");
                    if (success) {
                        Toast.makeText(SignUp.this, "تم تسجيل البيانات بنجاح ......", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(SignUp.this, Login.class);
                        SignUp.this.startActivity(intent);

                    } else {
                        AlertDialog.Builder builder = new AlertDialog.Builder(SignUp.this);
                        builder.setMessage("لم يتم تسجيل البيانات .... !!")
                                .setNegativeButton("Retry", null)
                                .create()
                                .show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };

        RegisterRequest registerRequest = new RegisterRequest( email, username, password, responseListener);
        RequestQueue queue = Volley.newRequestQueue(SignUp.this);
        queue.add(registerRequest);

    }

    public boolean validate(){
        boolean valid = true;
        if(username.isEmpty()){
            etUsername.setError("قم بكتابة اسم المستخدم");
            valid = false;
        }

        if(email.isEmpty()|| !Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            etEmail.setError("قم بكتابة البريد الإلكتروني");
            valid = false;
        }
        if(password.isEmpty()&&password.length()<8){
            etPassword.setError("قم بكتابة كلمة المرور");
            valid = false;
        }

        return  valid;
    }

    public void intialize(){
        email = etEmail.getText().toString().trim();
        username = etUsername.getText().toString().trim();
        password = etPassword.getText().toString().trim();
    }

}