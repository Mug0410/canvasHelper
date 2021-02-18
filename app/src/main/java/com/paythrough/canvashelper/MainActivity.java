package com.paythrough.canvashelper;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.canvaslib.SignatureCreate;

public class MainActivity extends AppCompatActivity {
    private LinearLayout signatureCapture;
    private SignatureCreate mSignature;
    private Button save, clear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSignature = new SignatureCreate(this, null);
        mSignature.setBackgroundColor(Color.WHITE);

        signatureCapture = (LinearLayout) findViewById(R.id.linearLayout1);
        signatureCapture.addView(mSignature, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

        save = findViewById(R.id.save);

        clear = findViewById(R.id.clear);

        clear.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                mSignature.clear();
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                    save.setDrawingCacheEnabled(true);
                    mSignature.save(signatureCapture);
                    mSignature.clear();
                    Toast.makeText(getApplicationContext(), "Successfully Saved", Toast.LENGTH_SHORT).show();

            }
        });
    }
}