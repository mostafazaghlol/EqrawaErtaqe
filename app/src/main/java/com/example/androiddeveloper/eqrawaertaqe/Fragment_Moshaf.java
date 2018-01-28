package com.example.androiddeveloper.eqrawaertaqe;


import android.app.ProgressDialog;
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
public class Fragment_Moshaf extends Fragment {
    private WebView webView;
    View MyView;

    public Fragment_Moshaf() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("تلاوات وشيوخ");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        MyView = inflater.inflate(R.layout.fragment_fragment__moshaf, container, false);

//
//        final ProgressDialog progDailog = new ProgressDialog(getActivity());
//        progDailog.setTitle("جاري تحميل الصفحة الرئيسية");
//        progDailog.setIcon(R.drawable.logo);
//        progDailog.setMessage("من فضلك انتظر قليلا ..... ");
//        progDailog.setProgress(0);
//        progDailog.setMax(10);
//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                int progress = 0;
//                while (progress <= 20) {
//                    try {
//                        progDailog.setProgress(progress);
//                        progress++;
//                        Thread.sleep(200);
//                    } catch (Exception e) {
//
//                    }
//                }
//                progDailog.dismiss();

//            }
//        });
//        thread.start();
//        progDailog.show();



        return MyView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        webView = (WebView) MyView.findViewById(R.id.webView1);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("http://www.quran-now.com/playlist/5539578756726784/%D8%B9%D8%A8%D8%AF-%D8%A7%D9%84%D8%A8%D8%A7%D8%B3%D8%B7-%D8%B9%D8%A8%D8%AF-%D8%A7%D9%84%D8%B5%D9%85%D8%AF-%D8%B1%D9%88%D8%A7%D9%8A%D8%A9-%D9%88%D8%B1%D8%B4");


    }

}
