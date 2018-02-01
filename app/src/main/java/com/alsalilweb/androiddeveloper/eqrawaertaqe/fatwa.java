package com.alsalilweb.androiddeveloper.eqrawaertaqe;


import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class fatwa extends Fragment {
    View myView;
    TextView textView;

    public fatwa() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        myView = inflater.inflate(R.layout.fragment_fatwa, container, false);
        WebView webView = (WebView)myView.findViewById(R.id.webView5);
        textView = (TextView)myView.findViewById(R.id.text2);
       if(isConnected(getActivity())) {
           webView.getSettings().setJavaScriptEnabled(true);
           webView.loadUrl("https://fatwa.islamonline.net/");
       }else {
           webView.setVisibility(View.INVISIBLE);
           textView.setVisibility(View.VISIBLE);
       }
        return myView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("فتاوى");
    }

    public static boolean isConnected(Context context) {
        ConnectivityManager
                cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null
                && activeNetwork.isConnectedOrConnecting();
    }

}
