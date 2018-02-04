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

import com.joanzapata.pdfview.PDFView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_Azkar extends Fragment {
    View myView;
//    TextView textView;
    public PDFView pdfView = null;


    public Fragment_Azkar() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        myView = inflater.inflate(R.layout.fragment_azkar, container, false);
        pdfView = (PDFView) myView.findViewById(R.id.pdfview2);
        pdfView.fromAsset("azkar.pdf").swipeVertical(true).load();
        return myView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("اذكار الصباح والمساء");
    }

    public static boolean isConnected(Context context) {
        ConnectivityManager
                cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null
                && activeNetwork.isConnectedOrConnecting();
    }

}
