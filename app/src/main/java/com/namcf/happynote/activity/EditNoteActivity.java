package com.namcf.happynote.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.namcf.happynote.R;

/**
 * Created by admin on 4/25/2017.
 */

public class EditNoteActivity extends Activity {

    static String CLASS_NAME = "EditNoteActivity";

    ImageView btnDeleteAlarm,btnBack;
    Spinner spnDay, spnTime;
    EditText edtTitle, edtNote;
    TextView btnAlarm;

    boolean onAlarm = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_edit);

        this.init();

    }

    public void init() {
        btnDeleteAlarm = (ImageView) findViewById(R.id.btnDeleteAlarm);
        btnBack = (ImageView) findViewById(R.id.btnBack);

        spnDay = (Spinner) findViewById(R.id.spnDay);
        spnTime = (Spinner) findViewById(R.id.spnTime);

        edtNote = (EditText) findViewById(R.id.edtNote);
        edtTitle = (EditText) findViewById(R.id.edtTitle);

        btnDeleteAlarm = (ImageView) findViewById(R.id.btnDeleteAlarm);
        btnDeleteAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                offAlarm();
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnAlarm = (TextView) findViewById(R.id.btnAlarm);
        btnAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onAlarm();
            }
        });
    }

    public void onAlarm() {
        DBG("onClickAlarm");
        btnAlarm.setVisibility(View.GONE);
        spnDay.setVisibility(View.VISIBLE);
        spnTime.setVisibility(View.VISIBLE);
        btnDeleteAlarm.setVisibility(View.VISIBLE);
    }

    public void offAlarm() {
        btnAlarm.setVisibility(View.VISIBLE);
        spnDay.setVisibility(View.GONE);
        spnTime.setVisibility(View.GONE);
        btnDeleteAlarm.setVisibility(View.GONE);
    }


    public void DBG(String str) {
        Log.d(CLASS_NAME, str);
    }
}
