package com.alsalilweb.androiddeveloper.eqrawaertaqe;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import co.mobiwise.materialintro.shape.Focus;
import co.mobiwise.materialintro.shape.FocusGravity;
import co.mobiwise.materialintro.shape.ShapeType;
import co.mobiwise.materialintro.view.MaterialIntroView;

public class Home extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    android.support.v4.app.Fragment[] fragments;
    String[] fragmentTAGS;
    String[] titles;
    public static int numberOfSwra = 0, currentTimeMillis = 0;
    int position = 10;

    private ConnectivityManager connectivityManager;
    private NetworkInfo networkInfo = null;

    public Home() {
        fragments = new android.support.v4.app.Fragment[]{new Fragment_Moshaf(), new Fragment_MoshafRead(), new Fragment_Azkar(), new Fragment_VoiceMail(), new Fragment_Rate()};
        fragmentTAGS = new String[]{"fragment1_tag", "fragment2_tag", "fragment3_tag", "fragment4_tag", "fragment5_tag"};
        titles = new String[]{"تلاوات وشيوخ", "القرآن الكريم", "فتاوى", "الرسائل الصوتيه", "Youtube","التقييم"};
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        connectivityManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        networkInfo = connectivityManager.getActiveNetworkInfo();
        getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_RTL);

        Fragment_Moshaf fragment = new Fragment_Moshaf();
        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.commit();


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
                new MaterialIntroView.Builder(this)
                .enableDotAnimation(true)
                .enableIcon(false)
                .setFocusGravity(FocusGravity.RIGHT)
                .setFocusType(Focus.MINIMUM)
                .setDelayMillis(300)
                .enableFadeAnimation(true)
                .performClick(true).setShape(ShapeType.CIRCLE)
                .setInfoText("قائمة البرنامج   ")
                .setTarget(toolbar)
                .setUsageId("intro_card25") //THIS SHOULD BE UNIQUE ID
                .show();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            //super.onBackPressed();
            Out();

        }
    }
    private void Out(){
        AlertDialog.Builder builder = new AlertDialog.Builder(Home.this);
        builder.setTitle("انذار الخروج");
        builder.setMessage("هل تريد الخروج ؟ ");
        builder.setPositiveButton("نعم", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        builder.setNegativeButton("لا", null);
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();



        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.moshaf) {
            position = 0;
        } else if (id == R.id.moshafread) {
            position = 1;
        } else if (id == R.id.sound_mail) {
            position = 3;
        } else if (id == R.id.rate) {
            position = 4;
        } else if (id == R.id.logout) {
            AlertDialog.Builder builder = new AlertDialog.Builder(Home.this);
            builder.setTitle("انذار الخروج");
            builder.setMessage("هل تريد الخروج ؟ ");
            builder.setPositiveButton("نعم", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            builder.setNegativeButton("لا", null);
            AlertDialog alertDialog = builder.create();
            alertDialog.show();

        } else if (id == R.id.fatawa) {

            position = 2;
        } else if (id == R.id.youtube_view) {

            if (isConnected(this)) {
                Intent newAct = new Intent(this, YoutubeActivity.class);
                startActivity(newAct);
            } else {
                Toast.makeText(this, "No Internet Connection !", Toast.LENGTH_SHORT).show();
            }
            position = 7;
        }
        if (position < 7) {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);

            if (getSupportFragmentManager().findFragmentByTag(fragmentTAGS[position]) == null) {
                fragmentTransaction.add(R.id.fragment_container, fragments[position], fragmentTAGS[position]);

            }
            for (int i = 0; i < fragments.length; i++) {
                if (i == position) {
                        fragmentTransaction.show(fragments[i]);
                        setTitle(titles[i]);
                    } else {
                        if (getSupportFragmentManager().findFragmentByTag(fragmentTAGS[position]) != null) {
                            fragmentTransaction.hide(fragments[i]);
                        }
                    }
                }

            fragmentTransaction.commit();


        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public static boolean isConnected(Context context) {
        ConnectivityManager
                cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null
                && activeNetwork.isConnectedOrConnecting();
    }

}
