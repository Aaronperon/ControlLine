package com.example.controlline.util;

import android.service.controls.Control;

import com.example.controlline.bean.ControlLine;
import java.util.ArrayList;
import java.util.List;

public class GetService {

    private String[] batchString = new String[]{"一本","一本","二本","专科"};
    private int[] scoreString = new int[]{524,526,390,230};
    private int[] yearString = new int[]{2014,2014,2014,2014};


    private String[] categoryString  = new String[]{"理工","文史","理工","文史"};
    private String[] areaNameString = new String[]{"江西","江西","江西","江西"};

    public List<ControlLine> setControlLineList(){
        List<ControlLine> list = new ArrayList<ControlLine>();
        for (int i = 0;i<4;i++){
            ControlLine controlLine = new ControlLine();


            controlLine.setControlYear(yearString[i]);

            controlLine.setCategoryName(categoryString[i]);

            controlLine.setBatchName(batchString[i]);

            controlLine.setControlLine(scoreString[i]);

            controlLine.setAreaName(areaNameString[i]);
            list.add(controlLine);
        }
        return list;
    }
}
