package com.example.androiddeveloper.eqrawaertaqe;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Splash extends Activity {

    private static int Splash_time_out=2000;
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_LTR);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run(){

                Intent homeIntent = new Intent(Splash.this, Main.class);
                startActivity(homeIntent);
                finish();
            }

        }, Splash_time_out);
    }
}
