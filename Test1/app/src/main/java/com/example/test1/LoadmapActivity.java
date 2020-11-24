package com.example.test1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import net.daum.mf.map.api.MapPoint;
import net.daum.mf.map.api.MapReverseGeoCoder;
import net.daum.mf.map.api.MapView;
public class LoadmapActivity extends AppCompatActivity {

//    MapReverseGeoCoder reverseGeoCoder = new MapReverseGeoCoder("LOCAL_API_KEY", mapPoint, reverseGeoCodingResultListener, contextActivity); reverseGeoCoder.startFindingAddress();

    EditText loc_text;
    Button btn_search;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loadmap);

        MapView mapView = new MapView(this);


        InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);



        ViewGroup mapViwContainer = findViewById(R.id.map_view);
        mapViwContainer.addView(mapView);

        loc_text = findViewById(R.id.loc_text);
        btn_search = findViewById(R.id.btn_search);


        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String S_loc_text = loc_text.getText().toString();
                if(S_loc_text == null || S_loc_text.length() ==0){
                    Toast.makeText(LoadmapActivity.this, "장소 및 주소를 입력하세요.", Toast.LENGTH_SHORT).show();
                }
                imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);




                MapPoint.GeoCoordinate geoCoordinate = mapView.getMapCenterPoint().getMapPointGeoCoord();
                double latitude = geoCoordinate.latitude;
                double longtitude = geoCoordinate.longitude;
                int radius = 10000;
                int page = 1;
                String apikey = "78d6c22bcc19fbe7a3877a12161322fe";



            }
        });


    }
}
