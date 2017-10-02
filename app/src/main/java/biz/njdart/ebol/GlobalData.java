package biz.njdart.ebol;

import android.app.Application;

/**
 * Created by d851095 on 9/14/2017.
 */

public class GlobalData extends Application{

        //Shipment Number
        private String mGlobalVarValue;


        public String getGlobalVarValue() {
            return mGlobalVarValue;
        }

        public void setGlobalVarValue(String str) {
            mGlobalVarValue = str;
        }

    // Delivery Number

        // Declare data
    //Delivery Number
    private  String[] delvNumbers;

    // Get Method for delv Numbers
    public String[] getdelvNumbers() { return delvNumbers;    }


    // Set Method for delv Numbers
    public void setdelvNumbers(String[] str[]) {
        int size = str.length;

        for (int i=0; i<size; i++)
        { delvNumbers[i] = String.valueOf(str[i]);}
    }



    // Class Bol Data storing Delv number and link
    private BolData[] bolData;

    // Get Method for Bol data
    public BolData[] getbolData() { return bolData;    }


    // Set Method for delv Numbers
    public void setBolData(String delv, String bol, String path) {
       BolData[] data = getbolData();
        int size = data.length + 1;

         bolData[size].delvNum = delv ;
         bolData[size].bolLink = bol ;
         bolData[size].bolPath = path ;
    }




}

