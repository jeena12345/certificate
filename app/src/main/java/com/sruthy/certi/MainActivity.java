package com.sruthy.certi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity{

    //View Objects
    private Button buttonScan;
    private TextView textViewName, textViewAddress;
    TextView txt;
    TextView txt2;
    TextView txt3;

    //qr code scanner object
    private IntentIntegrator qrScan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       txt=findViewById(R.id.phoneno);
       txt2=findViewById(R.id.cert_url);
     txt3=findViewById(R.id.reg_no);
        //View objects


        //intializing scan object
        qrScan = new IntentIntegrator(this);
        qrScan.initiateScan();
        //attaching onclick listener

    }

    //Getting the scan results
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            //if qrcode has nothing in it
            if (result.getContents() == null) {
                Toast.makeText(this, "Result Not Found", Toast.LENGTH_LONG).show();
            } else {
                //if qr contains data

            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

}
