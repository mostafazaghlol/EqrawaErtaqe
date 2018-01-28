package com.example.androiddeveloper.eqrawaertaqe;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;


/**
 * A simple {@link Fragment} subclass.
 */
public class fatwa extends Fragment {
    View myView;

    public fatwa() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        myView = inflater.inflate(R.layout.fragment_fatwa, container, false);
        WebView webView = (WebView)myView.findViewById(R.id.webView5);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://fatwa.islamonline.net/");

        return myView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("فتاوى");
    }

}
