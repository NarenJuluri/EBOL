package biz.njdart.ebol;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    EditText shpNumTxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Button Action

        Button shpBtn = (Button) findViewById(R.id.shpBtn);
        shpBtn.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View view) {
               //Variable to hold shipment number"
               //String shpnum;
               shpNumTxt = (EditText) findViewById(R.id.shpNumTxt) ;
               float shpnum = Float.parseFloat(shpNumTxt.getText().toString());
               String shipmentNumber = shpNumTxt.getText().toString();
               GlobalData globalData = ((GlobalData)getApplicationContext());
                globalData.setGlobalVarValue(shipmentNumber);


               // shpnum = (String) shpNumTxt.getText();
               Intent intent    = new Intent(getApplicationContext(), DelvlistActivity.class);
            //   intent.putExtra("shpnum" , shpnum);
               startActivity(intent);
                                      }
                                  }




        );

    }
}
