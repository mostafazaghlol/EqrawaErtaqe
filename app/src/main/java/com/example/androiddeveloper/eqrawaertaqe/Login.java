package com.example.androiddeveloper.eqrawaertaqe;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
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

public class Login extends Activity {

    EditText etUsername,etPassword;
    TextView view_new;
    Button btnLogin;
    String username,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = (EditText)findViewById(R.id.username);
        etPassword = (EditText)findViewById(R.id.password);
        btnLogin = (Button) findViewById(R.id.login);

        view_new = (TextView)findViewById(R.id.signup);

        view_new.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(Login.this, SignUp.class);
                startActivity(registerIntent);
                finish();
            }
        });
     /*   view_forget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent1 = new Intent(Login.this, Forget_pass.class);
                Login.this.startActivity(registerIntent1);
            }
        });
*/
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
                final ProgressDialog progDailog = new ProgressDialog(Login.this);
                progDailog.setTitle("جاري تحميل الدخول");
                progDailog.setIcon(R.drawable.logo);
                progDailog.setMessage("من فضلك انتظر قليلا ..... ");
                progDailog.setProgress(0);
                progDailog.setMax(10);
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        int progress = 0;
                        while (progress <= 20) {
                            try {
                                progDailog.setProgress(progress);
                                progress++;
                                Thread.sleep(200);
                            } catch (Exception e) {

                            }
                        }
                        progDailog.dismiss();
                    }
                });
                thread.start();
                progDailog.show();
            }
        });
    }
    public void register(){
        intialize();
        if(!validate()) {

        }
        else {
            onSignInSuccess();
        }

    }
    public void onSignInSuccess(){
        // Response received from the server
        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");

                    if (success) {
                        Toast.makeText(Login.this, "تم تسجيل الدخول بنجاح ......",Toast.LENGTH_LONG).show();

                        String usermail = jsonResponse.getString("User_email");
                        Intent intent3 = new Intent(Login.this, Home.class);
                        intent3.putExtra("User_name", username);
                        intent3.putExtra("User_email", usermail);
                        Login.this.startActivity(intent3);

                    } else {
                        AlertDialog.Builder builder = new AlertDialog.Builder(Login.this);
                        builder.setMessage("لم يتم تسجيل الدخول ..... !!")
                                .setNegativeButton("Retry", null)
                                .create()
                                .show();
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };

        LoginRequest loginRequest = new LoginRequest(username, password, responseListener);
        RequestQueue queue = Volley.newRequestQueue(Login.this);
        queue.add(loginRequest);
    }

    public boolean validate(){
        boolean valid = true;
        if(username.isEmpty()){
            etUsername.setError("قم بكتابة الاسم");
            valid = false;
        }
        if(password.isEmpty()){
            etPassword.setError("قم بكتابة كلمة المرور");
            valid = false;
        }

        return  valid;
    }

    public void intialize(){
        username = etUsername.getText().toString().trim();
        password = etPassword.getText().toString().trim();
    }
}

