package com.example.androiddeveloper.eqrawaertaqe;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_Profile extends Fragment {

    TextView voicemail, call;
    View MyView;
    public Fragment_Profile() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        MyView = inflater.inflate(R.layout.fragment_fragment__profile, container, false);

        voicemail = (TextView) MyView.findViewById(R.id.voicemail);
        call = (TextView) MyView.findViewById(R.id.call);
        EditText View_name = (EditText)MyView.findViewById(R.id.View_name);
        EditText View_mail = (EditText)MyView.findViewById(R.id.View_mail);

        Intent intent = getActivity().getIntent();
        String username = intent.getStringExtra("User_name");
        String usermail = intent.getStringExtra("User_email");

        View_name.setText(username);
        View_mail.setText(usermail);

        voicemail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setMessage(" من فضلك قم بإختيار رسالة صوتية من القائمة الرئيسية ")
                        .setNegativeButton(" موافق ", null)
                        .create()
                        .show();
            }
        });

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:01010344525"));
                startActivity(callIntent);
            }
        });

        return MyView;
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("الملف الشخصي");
    }

}
