package com.alsalilweb.androiddeveloper.eqrawaertaqe;


import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.NotificationCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.RemoteViews;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.content.Context.NOTIFICATION_SERVICE;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_Rate extends Fragment implements AdapterView.OnItemSelectedListener {

    NotificationCompat.Builder builder;
    NotificationManager notificationManager;
    int notification_id;
    RemoteViews remoteViews;
    Context context;

    View MyView;
    Spinner spinner;
    RatingBar ratingBar;
    Button ok;
    public Fragment_Rate() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        MyView = inflater.inflate(R.layout.fragment_fragment__rate, container, false);

        context = getActivity();
        notificationManager = (NotificationManager) getActivity().getSystemService(NOTIFICATION_SERVICE);
        remoteViews = new RemoteViews(getActivity().getPackageName(),R.layout.custom_notification1);
        notification_id = (int)System.currentTimeMillis();

        ratingBar = ( RatingBar) MyView.findViewById(R.id.ratingBar);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Toast.makeText(getActivity(), " You Choose : " + (int) rating + " Stars",Toast.LENGTH_LONG).show();
            }
        });

        // Spinner element
        spinner = (Spinner) MyView.findViewById(R.id.spinner);

        // Spinner click listener
        spinner.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("إختار دورك");
        categories.add("شيخ");
        categories.add("مستخدم");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);

        ok = (Button)MyView.findViewById(R.id.ok);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final ProgressDialog progDailog = new ProgressDialog(getActivity());
                progDailog.setTitle("جاري التقييم");
                progDailog.setIcon(R.drawable.logo);
                progDailog.setMessage("من فضلك انتظر قليلا ..... ");
                progDailog.setProgress(0);
                progDailog.setMax(10);
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        int progress = 0;
                        while (progress <= 10) {
                            try {
                                progDailog.setProgress(progress);
                                progress++;
                                Thread.sleep(100);
                            } catch (Exception e) {

                            }
                        }
                        progDailog.dismiss();
                    }
                });
                thread.start();
                progDailog.show();


                Intent intent = new Intent(context, Fragment_Rate.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(context,0,intent,0);
                builder = new NotificationCompat.Builder(context);
                builder.setSmallIcon(R.drawable.star).setAutoCancel(true)
                        .setCustomBigContentView(remoteViews).setContentIntent(pendingIntent);
                notificationManager.notify(notification_id, builder.build());

                MediaPlayer mediaPlayer = MediaPlayer.create(getActivity(),R.raw.notification);
                mediaPlayer.start();

/*
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setMessage(" تم تقييم بنجاح ")
                        .setNegativeButton(" موافق ", null)
                        .create()
                        .show();
*/
            }
        });




        return MyView;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item

        if (item == "تلميذ"){
            android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(getActivity());
            builder.setTitle("تنبيه");
            builder.setMessage("سيتم إرسال الرسالة علي انك تلميذ");
            builder.setNegativeButton("موافق",null);
            android.support.v7.app.AlertDialog alertDialog = builder.create();
            alertDialog.show();

        }else if (item == "معلم"){
            android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(getActivity());
            builder.setTitle("تنبيه");
            builder.setMessage("سيتم إرسال الرسالة علي انك معلم");
            builder.setNegativeButton("موافق",null);
            android.support.v7.app.AlertDialog alertDialog = builder.create();
            alertDialog.show();
        }
    }
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("التقييم ");
    }

}
