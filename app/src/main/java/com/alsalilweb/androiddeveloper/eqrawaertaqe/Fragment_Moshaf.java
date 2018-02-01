package com.alsalilweb.androiddeveloper.eqrawaertaqe;


import android.app.ProgressDialog;
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
public class Fragment_Moshaf extends Fragment {
    private WebView webView;
    View MyView;
    private TextView textView;
    //ConnectivityManager connectManger = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
    //final NetworkInfo networkInfo = connectManger.getActiveNetworkInfo();

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

        if(isConnected(getActivity())) {
            final ProgressDialog progDailog = new ProgressDialog(getActivity());
            progDailog.setTitle("جاري تحميل الصفحة الرئيسية");
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

        return MyView;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //  textView = (TextView)getActivity().findViewById(R.id.textView);
        webView = (WebView) MyView.findViewById(R.id.webView1);
        textView = (TextView)MyView.findViewById(R.id.text);
        if(isConnected(getActivity())) {
            webView.getSettings().setJavaScriptEnabled(true);
            webView.loadUrl("http://www.quran-now.com/playlist/5539578756726784/%D8%B9%D8%A8%D8%AF-%D8%A7%D9%84%D8%A8%D8%A7%D8%B3%D8%B7-%D8%B9%D8%A8%D8%AF-%D8%A7%D9%84%D8%B5%D9%85%D8%AF-%D8%B1%D9%88%D8%A7%D9%8A%D8%A9-%D9%88%D8%B1%D8%B4");
        }else {
            webView.setVisibility(View.GONE);
            textView.setVisibility(View.VISIBLE);
        }

    }

    public static boolean isConnected(Context context) {
        ConnectivityManager
                cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null
                && activeNetwork.isConnectedOrConnecting();
    }


}
