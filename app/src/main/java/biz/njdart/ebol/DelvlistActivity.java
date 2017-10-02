package biz.njdart.ebol;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class DelvlistActivity extends AppCompatActivity {


    String[] DELIVERIES = { "80007084" , "80000106" , "80007085" , "80009123"};
    TextView shpNumD;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delvlist);

        float shpnum = getIntent().getFloatExtra("shpnum", 0 );


        GlobalData globalData = ((GlobalData)getApplicationContext());
        String shipmentNumber= globalData.getGlobalVarValue();


        shpNumD = (TextView) findViewById(R.id.shpNumD);
       // shpNumD.setText(Float.toString(shpnum));
        shpNumD.setText(shipmentNumber);
//        shpnum = getIntent().getStringExtra("shpnum" );

       Button signBtn = (Button)findViewById(R.id.signBtn);

        ListView listView   = (ListView) findViewById(R.id.listView);

       CustomAdapter customAdapter = new CustomAdapter();
       listView.setAdapter(customAdapter);

       listView.setClickable(true);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                String  delvNumb ;
                String  extPDF = ".pdf";
                delvNumb = DELIVERIES[position];
                String SAMPLE_FILE = delvNumb+extPDF ;
                Intent intent    = new Intent(getApplicationContext(), ViewPDFActivity.class);
               intent.putExtra("SAMPLE_FILE" , SAMPLE_FILE);

                startActivity(intent);

            }
        });
        signBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent    = new Intent(getApplicationContext(), SignActivity.class);
                 startActivity(intent);
            }
        });

    }




      public class  CustomAdapter    extends BaseAdapter {



        @Override
        public int getCount() {
            return DELIVERIES.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            convertView =  getLayoutInflater().inflate(R.layout.delvlist , null);
            TextView delvnumTxt = (TextView) convertView.findViewById(R.id.delvnumTxt);
            delvnumTxt.setText(DELIVERIES[position]);

            return convertView;
        }


    }




}
