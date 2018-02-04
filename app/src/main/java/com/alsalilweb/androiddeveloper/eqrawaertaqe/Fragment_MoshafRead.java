package com.alsalilweb.androiddeveloper.eqrawaertaqe;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.joanzapata.pdfview.PDFView;

import co.mobiwise.materialintro.shape.Focus;
import co.mobiwise.materialintro.shape.FocusGravity;
import co.mobiwise.materialintro.view.MaterialIntroView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_MoshafRead extends Fragment {
    public PDFView pdfView = null;
    View MyView;

    public Fragment_MoshafRead() {
        // Required empty public constructor
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        try {
            pdfView = (PDFView) getView().findViewById(R.id.pdfview);
            pdfView.fromAsset("quran.pdf").swipeVertical(true).load();

            Spinner spinner = (Spinner) getView().findViewById(R.id.planets_spinner);
            // Create an ArrayAdapter using the string array and a default spinner layout
            final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                    R.array.Quran_array, android.R.layout.simple_spinner_item);
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            // Apply the adapter to the spinner
            spinner.setAdapter(adapter);
            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    ((TextView) parent.getChildAt(0)).setGravity(Gravity.CENTER);
                    String item= (String) parent.getSelectedItem();

                    switch (item){
                        case "الفاتحة":
                            pdfView.jumpTo(0);
                            break;
                        case "البقرة":
                            pdfView.jumpTo(2);
                            break;
                        case "آل عمران":
                            pdfView.jumpTo(45);
                            break;
                        case "النساء":
                            pdfView.jumpTo(69);
                            break;
                        case "المآئدة":
                            pdfView.jumpTo(95);
                            break;
                        case "الأنعام":
                            pdfView.jumpTo(115);
                            break;
                        case "الأعراف":
                            pdfView.jumpTo(136);
                            break;
                        case "الأنفال":
                            pdfView.jumpTo(160);
                            break;
                        case "التوبة":
                            pdfView.jumpTo(169);
                            break;
                        case "يونس":
                            pdfView.jumpTo(187);
                            break;
                        case "هود":
                            pdfView.jumpTo(199);
                            break;
                        case "يوسف":
                            pdfView.jumpTo(212);
                            break;
                        case "الرعد":
                            pdfView.jumpTo(225);
                            break;
                        case "إبراهيم":
                            pdfView.jumpTo(231);
                            break;
                        case "الحجر":
                            pdfView.jumpTo(237);
                            break;
                        case "النحل":
                            pdfView.jumpTo(242);
                            break;
                        case "الإسراء":
                            pdfView.jumpTo(255);
                            break;
                        case "الكهف":
                            pdfView.jumpTo(266);
                            break;
                        case "مريم":
                            pdfView.jumpTo(277);
                            break;
                        case "طـه":
                            pdfView.jumpTo(284);
                            break;
                        case "الأنبياء":
                            pdfView.jumpTo(294);
                            break;
                        case "الحج":
                            pdfView.jumpTo(302);
                            break;
                        case "المؤمنون":
                            pdfView.jumpTo(311);
                            break;
                        case "النور":
                            pdfView.jumpTo(319);
                            break;
                        case "الفرقان":
                            pdfView.jumpTo(329);
                            break;
                        case "الشعراء":
                            pdfView.jumpTo(335);
                            break;
                        case "النمل":
                            pdfView.jumpTo(345);
                            break;
                        case "القصص":
                            pdfView.jumpTo(354);
                            break;
                        case "العنكبوت":
                            pdfView.jumpTo(364);
                            break;
                        case "الروم":
                            pdfView.jumpTo(371);
                            break;
                        case "لقمان":
                            pdfView.jumpTo(377);
                            break;
                        case "السجدة":
                            pdfView.jumpTo(381);
                            break;
                        case "الأحزاب":
                            pdfView.jumpTo(383);
                            break;
                        case "سبأ":
                            pdfView.jumpTo(393);
                            break;
                        case "فاطر":
                            pdfView.jumpTo(399);
                            break;
                        case "يس":
                            pdfView.jumpTo(404);
                            break;
                        case "الصافات":
                            pdfView.jumpTo(410);
                            break;
                        case "ص":
                            pdfView.jumpTo(417);
                            break;
                        case "الزمر":
                            pdfView.jumpTo(422);
                            break;
                        case "غافر":
                            pdfView.jumpTo(431);
                            break;
                        case "فصلت":
                            pdfView.jumpTo(439);
                            break;
                        case "الشورى":
                            pdfView.jumpTo(445);
                            break;
                        case "الزخرف":
                            pdfView.jumpTo(451);
                            break;
                        case "الدخان":
                            pdfView.jumpTo(457);
                            break;
                        case "الجاثية":
                            pdfView.jumpTo(460);
                            break;
                        case "الأحقاف":
                            pdfView.jumpTo(464);
                            break;
                        case "محمد":
                            pdfView.jumpTo(468);
                            break;
                        case "الفتح":
                            pdfView.jumpTo(472);
                            break;
                        case "الحجرات":
                            pdfView.jumpTo(477);
                            break;
                        case "ق":
                            pdfView.jumpTo(479);
                            break;
                        case "الذاريات":
                            pdfView.jumpTo(482);
                            break;
                        case "الطور":
                            pdfView.jumpTo(485);
                            break;
                        case "النجم":
                            pdfView.jumpTo(487);
                            break;
                        case "القمر":
                            pdfView.jumpTo(490);
                            break;
                        case "الرحمن":
                            pdfView.jumpTo(493);
                            break;
                        case "الواقعة":
                            pdfView.jumpTo(496);
                            break;
                        case "الحديد":
                            pdfView.jumpTo(499);
                            break;
                        case "المجادلة":
                            pdfView.jumpTo(504);
                            break;
                        case "الحشر":
                            pdfView.jumpTo(507);
                            break;
                        case "الممتحنة":
                            pdfView.jumpTo(510);
                            break;
                        case "الصف":
                            pdfView.jumpTo(513);
                            break;
                        case "الجمعة":
                            pdfView.jumpTo(515);
                            break;
                        case "المنافقون":
                            pdfView.jumpTo(516);
                            break;
                        case "التغابن":
                            pdfView.jumpTo(518);
                            break;
                        case "الطلاق":
                            pdfView.jumpTo(520);
                            break;
                        case "التحريم":
                            pdfView.jumpTo(522);
                            break;
                        case "الملك":
                            pdfView.jumpTo(524);
                            break;
                        case "القلم":
                            pdfView.jumpTo(526);
                            break;
                        case "الحاقة":
                            pdfView.jumpTo(529);
                            break;
                        case "المعارج":
                            pdfView.jumpTo(531);
                            break;

                        case "نوح":
                            pdfView.jumpTo(533);
                            break;

                        case "الجن":
                            pdfView.jumpTo(534);
                            break;

                        case "المزمل":
                            pdfView.jumpTo(537);
                            break;

                        case "المدثر":
                            pdfView.jumpTo(538);
                            break;

                        case "القيامة":
                            pdfView.jumpTo(540);
                            break;

                        case "الإنسان":
                            pdfView.jumpTo(542);
                            break;

                        case "المرسلات":
                            pdfView.jumpTo(544);
                            break;

                        case "النبأ":
                            pdfView.jumpTo(545);
                            break;

                        case "النازعات":
                            pdfView.jumpTo(547);
                            break;

                        case "عبس":
                            pdfView.jumpTo(548);
                            break;

                        case "التكوير":
                            pdfView.jumpTo(550);
                            break;

                        case "الإنفطار":
                            pdfView.jumpTo(551);
                            break;

                        case "المطففين":
                            pdfView.jumpTo(552);
                            break;

                        case "الإنشقاق":
                            pdfView.jumpTo(553);
                            break;

                        case "البرج":
                            pdfView.jumpTo(554);
                            break;

                        case "الطارق":
                            pdfView.jumpTo(555);
                            break;

                        case "الأعلى":
                            pdfView.jumpTo(556);
                            break;

                        case "الغاشية":
                            pdfView.jumpTo(556);
                            break;

                        case "الفجر":
                            pdfView.jumpTo(557);
                            break;

                        case "البلد":
                            pdfView.jumpTo(559);
                            break;

                        case "الشمس":
                            pdfView.jumpTo(559);
                            break;

                        case "الليل":
                            pdfView.jumpTo(560);
                            break;

                        case "الضحى":
                            pdfView.jumpTo(561);
                            break;

                        case "الشرح":
                            pdfView.jumpTo(561);
                            break;

                        case "التين":
                            pdfView.jumpTo(562);
                            break;


                        case "العلق":
                            pdfView.jumpTo(562);
                            break;


                        case "القدر":
                            pdfView.jumpTo(563);
                            break;


                        case "البيِّنة":
                            pdfView.jumpTo(563);
                            break;


                        case "الزلزلة":
                            pdfView.jumpTo(564);
                            break;


                        case "العاديات":
                            pdfView.jumpTo(565);
                            break;


                        case "القارعة":
                            pdfView.jumpTo(565);
                            break;


                        case "التكاثر":
                            pdfView.jumpTo(565);
                            break;


                        case "العصر":
                            pdfView.jumpTo(566);
                            break;


                        case "الهمزة":
                            pdfView.jumpTo(566);
                            break;


                        case "الفيل":
                            pdfView.jumpTo(566);
                            break;


                        case "قريش":
                            pdfView.jumpTo(567);
                            break;


                        case "الماعون":
                            pdfView.jumpTo(567);
                            break;


                        case "الكوثر":
                            pdfView.jumpTo(567);
                            break;


                        case "الكافرون":
                            pdfView.jumpTo(568);
                            break;


                        case "النصر":
                            pdfView.jumpTo(568);
                            break;


                        case "المسد":
                            pdfView.jumpTo(568);
                            break;



                        case "الإخلاص":
                            pdfView.jumpTo(569);
                            break;



                        case "الفلق":
                            pdfView.jumpTo(569);
                            break;



                        case "الناس":
                            pdfView.jumpTo(569);
                            break;

                    }

                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            } );


            new MaterialIntroView.Builder(getActivity())
                    .enableDotAnimation(true)
                    .enableIcon(false)
                    .setFocusGravity(FocusGravity.CENTER)
                    .setFocusType(Focus.MINIMUM)
                    .setDelayMillis(0)
                    .enableFadeAnimation(true)
                    .performClick(false)
                    .setInfoText("من هنا تقدر تختار السوره     ")
                    .setTarget(spinner)
                    .setUsageId("intro_card2") //THIS SHOULD BE UNIQUE ID
                    .show();


        }catch (Exception e){
            Log.e("Fragment_MoshafRead",e.getMessage());
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        MyView = inflater.inflate(R.layout.fragment_fragment__moshaf_read, container, false);
        return MyView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("القرأن الكريم");
    }

}
