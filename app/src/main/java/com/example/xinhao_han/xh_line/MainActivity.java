package com.example.xinhao_han.xh_line;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.xhcharlib.XHData;
import com.example.xhcharlib.XHLineChar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private XHLineChar xhLineChar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        xhLineChar = findViewById(R.id.xhchar);
        xhLineChar.setMaxTable(200.5f);
        xhLineChar.setMinTable(0f);

        ArrayList<XHData> xhData = new ArrayList<>();

        /*xhData.add(new XHData(20,0));
        xhData.add(new XHData(50,80));
        xhData.add(new XHData(60,30));
        xhData.add(new XHData(80,26));
        xhData.add(new XHData(17,26));
        xhData.add(new XHData(80,65));
        xhData.add(new XHData(26,74));
        xhData.add(new XHData(20,86));*/

        xhData.add(new XHData(true,5.5f,"2018/3",Color.parseColor("#dd7e6b")));
        xhData.add(new XHData(true,5.6f,"2018/3",Color.parseColor("#00ffff")));
        xhData.add(new XHData(true,80.5f,"2018/3",Color.parseColor("#6aa84f")));
        xhData.add(new XHData(true,70.5f,"2018/3",Color.parseColor("#cc0033")));
        xhData.add(new XHData(true,200.5f,"2018/3",Color.parseColor("#66ff33")));
        xhData.add(new XHData(true,180.5f,"2018/3",Color.parseColor("#6699ff")));
        xhData.add(new XHData(true,160.5f,"2018/3",Color.parseColor("#3366ff")));
        xhData.add(new XHData(true,140.5f,"2018/3",Color.parseColor("#00ffff")));
        xhData.add(new XHData(true,190.5f,"2018/3",Color.parseColor("#006600")));
        xhData.add(new XHData(true,10.5f,"2018/3",Color.parseColor("#FF83FA")));
        xhData.add(new XHData(true,30.5f,"2018/3",Color.parseColor("#FF3030")));
        xhData.add(new XHData(true,12.5f,"2018/3",Color.parseColor("#FF7F50")));
        xhData.add(new XHData(true,5.5f,"2018/3",Color.parseColor("#EE30A7")));
        xhData.add(new XHData(true,5.6f,"2018/3"));
        xhData.add(new XHData(true,80.5f,"2018/3"));
        xhData.add(new XHData(true,70.5f,"2018/3"));
        xhData.add(new XHData(true,200.5f,"2018/3"));
        xhData.add(new XHData(true,180.5f,"2018/3"));
        xhData.add(new XHData(true,160.5f,"2018/3"));
        xhData.add(new XHData(true,140.5f,"2018/3/15"));
        xhData.add(new XHData(true,190.5f,"2018/3/15"));
        xhData.add(new XHData(true,10.5f,"2018/3/15"));
        xhData.add(new XHData(true,30.5f,"2018/3/15"));
        xhData.add(new XHData(true,12.5f,"2018/3/15"));
        xhData.add(new XHData(true,5.5f,"2018/3/15"));
        xhData.add(new XHData(true,5.6f,"2018/3/15"));
        xhData.add(new XHData(true,80.5f,"2018/3/15"));
        xhData.add(new XHData(true,70.5f,"2018/3/15"));
        xhData.add(new XHData(true,200.5f,"2018/3/15"));
        xhData.add(new XHData(true,180.5f,"2018/3/15"));
        xhData.add(new XHData(true,160.5f,"2018/3/15"));
        xhData.add(new XHData(true,140.5f,"2018/3/15"));
        xhData.add(new XHData(true,190.5f,"2018/3/15"));
        xhData.add(new XHData(true,10.5f,"2018/3/15"));
        xhData.add(new XHData(true,30.5f,"2018/3/15"));
        xhData.add(new XHData(true,12.5f,"2018/3/15"));
        xhData.add(new XHData(true,5.5f,"2018/3/15"));
        xhData.add(new XHData(true,5.6f,"2018/3/15"));
        xhData.add(new XHData(true,80.5f,"2018/3/15"));
        xhData.add(new XHData(true,70.5f,"2018/3/15"));
        xhData.add(new XHData(true,200.5f,"2018/3/15"));
        xhData.add(new XHData(true,180.5f,"2018/3/15"));
        xhData.add(new XHData(true,160.5f,"2018/3/15"));
        xhData.add(new XHData(true,140.5f,"2018/3/15"));
        xhData.add(new XHData(true,190.5f,"2018/3/15"));
        xhData.add(new XHData(true,10.5f,"2018/3/15"));
        xhData.add(new XHData(true,30.5f,"2018/3/15"));
        xhData.add(new XHData(true,12.5f,"2018/3/15"));
        xhData.add(new XHData(true,5.5f,"2018/3/15"));
        xhData.add(new XHData(true,5.6f,"2018/3/15"));
        xhData.add(new XHData(true,80.5f,"2018/3/15"));
        xhData.add(new XHData(true,70.5f,"2018/3/15"));
        xhData.add(new XHData(true,200.5f,"2018/3/15"));
        xhData.add(new XHData(true,180.5f,"2018/3/15"));
        xhData.add(new XHData(true,160.5f,"2018/3/15"));
        xhData.add(new XHData(true,140.5f,"2018/3/15"));
        xhData.add(new XHData(true,190.5f,"2018/3/15"));
        xhData.add(new XHData(true,10.5f,"2018/3/15"));
        xhData.add(new XHData(true,30.5f,"2018/3/15"));
        xhData.add(new XHData(true,12.5f,"2018/3/15"));
        xhData.add(new XHData(true,5.5f,"2018/3/15"));
        xhData.add(new XHData(true,5.6f,"2018/3/15"));
        xhData.add(new XHData(true,80.5f,"2018/3/15"));
        xhData.add(new XHData(true,30.5f,"2018/3/15"));
        xhData.add(new XHData(true,12.5f,"2018/3/15"));
        xhData.add(new XHData(true,5.5f,"2018/3/15"));
        xhData.add(new XHData(true,5.6f,"2018/3/15"));
        xhData.add(new XHData(true,80.5f,"2018/3/15"));
        xhData.add(new XHData(true,70.5f,"2018/3/15"));
        xhData.add(new XHData(true,200.5f,"2018/3/15"));
        xhData.add(new XHData(true,180.5f,"2018/3/15"));
        xhData.add(new XHData(true,160.5f,"2018/3/15"));
        xhData.add(new XHData(true,140.5f,"2018/3/15"));
        xhData.add(new XHData(true,190.5f,"2018/3/15"));
        xhData.add(new XHData(true,10.5f,"2018/3/15"));
        xhData.add(new XHData(true,30.5f,"2018/3/15"));
        xhData.add(new XHData(true,12.5f,"2018/3/15"));
        xhData.add(new XHData(true,5.5f,"2018/3/15"));
        xhData.add(new XHData(true,5.6f,"2018/3/15"));
        xhData.add(new XHData(true,80.5f,"2018/3/15"));
        xhData.add(new XHData(true,70.5f,"2018/3/15"));
        xhData.add(new XHData(true,200.5f,"2018/3/15"));
        xhData.add(new XHData(true,180.5f,"2018/3/15"));
        xhData.add(new XHData(true,160.5f,"2018/3/15"));
        xhData.add(new XHData(true,140.5f,"2018/3/15"));
        xhData.add(new XHData(true,190.5f,"2018/3/15"));
        xhData.add(new XHData(true,10.5f,"2018/3/15"));
        xhData.add(new XHData(true,30.5f,"2018/3/15"));
        xhData.add(new XHData(true,12.5f,"2018/3/15"));
        xhData.add(new XHData(true,5.5f,"2018/3/15"));
        xhData.add(new XHData(true,5.6f,"2018/3/15"));
        xhData.add(new XHData(true,80.5f,"2018/3/15"));




        xhLineChar.setLineHOrLineW(30.3f,90.5f);
        xhLineChar.setDataArray(xhData);
    }
}
