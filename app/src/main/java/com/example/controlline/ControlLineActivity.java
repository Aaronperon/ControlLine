package com.example.controlline;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.controlline.adapter.ControlLineAdapter;
import com.example.controlline.bean.ControlLine;
import com.example.controlline.util.GetSQLite;
import com.example.controlline.util.GetService;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ControlLineActivity extends AppCompatActivity {
    private Spinner yearSpinner,provinceSpinner,categorySpinner,batchSpinner;
    private String[] years = new String[] {"2014","2013","2012","2011","2010"};
    private List<String> provinces = new ArrayList<String>();
    private String [] batches = new String[]{"不限","一本","二本","三本","专科","提前"};
    private String[] categories = new String[]{"不限","文史","理工","综合类","艺术类","体育"};
    private int sourceAreaId,yearId,categoryId,batchId;
    private TextView controlLineTitle;
    private List<ControlLine> controlLineList;
    private ListView controlLineListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        yearSpinner = (Spinner) findViewById(R.id.yearSpinner);
        provinceSpinner = (Spinner) findViewById(R.id.areaSpinner);
        categorySpinner = (Spinner) findViewById(R.id.categorySpinner);
        batchSpinner = (Spinner) findViewById(R.id.batchSpinner);
        controlLineTitle = (TextView) findViewById(R.id.controlLineTitle);
        controlLineListView = (ListView) findViewById(R.id.controlLineList);


        GetSQLite getSQLite = new GetSQLite();
        provinces = getSQLite.setProvince();

        ArrayAdapter<String> provincesAdapter = new ArrayAdapter<String>(
                this,R.layout.spinner_item_year,provinces
        );
        provinceSpinner.setAdapter(provincesAdapter);
        provinceSpinner.setSelection(sourceAreaId);

        ArrayAdapter<String> yearAdapter = new ArrayAdapter<String>(
                this,R.layout.spinner_item_year,years
        );
        yearSpinner.setAdapter(yearAdapter);
        yearSpinner.setSelection(yearId);

        ArrayAdapter<String> categoryAdapter = new ArrayAdapter<String>(
                this,R.layout.spinner_item_category,categories
        );
        categorySpinner.setAdapter(categoryAdapter);
        categorySpinner.setSelection(categoryId);

        ArrayAdapter<String> batchAdapter = new ArrayAdapter<String>(
                this,R.layout.spinner_item_batch,batches
        );
        batchSpinner.setAdapter(batchAdapter);
        batchSpinner.setSelection(batchId);

        GetService getService = new GetService();
        controlLineList = getService.setControlLineList();
        ControlLineAdapter controlLineAdapter = new ControlLineAdapter(this,controlLineList);
        controlLineListView.setAdapter(controlLineAdapter);

        MyItemSelectedListener itemSelectedListener = new MyItemSelectedListener();
        yearSpinner.setOnItemSelectedListener(itemSelectedListener);
        provinceSpinner.setOnItemSelectedListener(itemSelectedListener);
        categorySpinner.setOnItemSelectedListener(itemSelectedListener);
        batchSpinner.setOnItemSelectedListener(itemSelectedListener);
    }


    private class MyItemSelectedListener implements AdapterView.OnItemSelectedListener{
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            switch (parent.getId()){
                case R.id.areaSpinner:
                    sourceAreaId = position;
                    break;

                case R.id.yearSpinner:
                    yearId = position;
                    break;

                case R.id.categorySpinner:
                    categoryId = position;
                    break;

                case R.id.batchSpinner:
                    batchId = position;
                    break;
                default:
                    break;
            }
            controlLineTitle.setText(Html.fromHtml("<font color=red><b>"+provinces.get(sourceAreaId)+"</b></font>地区<font color=blue><b>"+years[yearId]+"</b></font>年省控线"));
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

}