package com.namcf.happynote.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.namcf.happynote.R;
import com.namcf.happynote.adapter.MyViewPagerAdapter;

/**
 * Created by admin on 4/25/2017.
 */

public class EditNoteActivity extends FragmentActivity {

    static String CLASS_NAME = "EditNoteActivity";

    ImageView btnBack, btnNext, btnDelete, btnShare, btnPre;

    ViewPager viewPager;
    MyViewPagerAdapter adapter;

    boolean onAlarm = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_edit);

        this.initViewPager();
        this.init();

    }

    public void initViewPager() {
        Intent mIntent = getIntent();
        int pos = mIntent.getExtras().getInt("position");

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        adapter = new MyViewPagerAdapter(getSupportFragmentManager(), MainActivity.listNote);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(pos);
    }

    public void init() {
        btnBack = (ImageView) findViewById(R.id.btnBack);
        btnNext = (ImageView) findViewById(R.id.btnNext);
        btnDelete = (ImageView) findViewById(R.id.btnDelete);
        btnShare = (ImageView) findViewById(R.id.btnShare);
        btnPre = (ImageView) findViewById(R.id.btnPre);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = viewPager.getCurrentItem();
                if (id == MainActivity.listNote.size() - 1 ){
                    id  = 0;
                }else {
                    id ++;
                }
                viewPager.setCurrentItem(id);
            }
        });

        btnPre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = viewPager.getCurrentItem();
                if (id == 0){
                    id  = MainActivity.listNote.size() - 1 ;
                }else {
                    id --;
                }
                viewPager.setCurrentItem(id);
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = viewPager.getCurrentItem();
                MainActivity.realmController.removeNote(MainActivity.listNote.get(id));
                finish();
            }
        });

        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(EditNoteActivity.this, "Share cai cc", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
