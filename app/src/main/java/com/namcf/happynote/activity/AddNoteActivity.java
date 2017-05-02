package com.namcf.happynote.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.namcf.happynote.R;
import com.namcf.happynote.objects.MyNote;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by linuxlord on 4/26/17.
 */

public class AddNoteActivity extends FragmentActivity {

    private ImageView btnBack;
    private ImageView btnSave;
    private View noteContent;

    //NoteContent
    private TextView date;
    private EditText edtTitle;
    private EditText edtNote;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        this.init();
        this.initNoteContent();

    }

    public void addNote() {
        MyNote n = new MyNote();
        String title = edtTitle.getText().toString();
        n.setTitle(title.equals("") ? "UnTitle" : title);
        n.setNote(edtNote.getText().toString());
        n.setDate(date.getText().toString());

        MainActivity.addNote(n);
        MainActivity.refreshList();
    }

    public void initNoteContent() {
        noteContent = findViewById(R.id.noteContent);
        date = (TextView) noteContent.findViewById(R.id.tvDate);
        edtTitle = (EditText) noteContent.findViewById(R.id.edtTitle);
        edtNote = (EditText) noteContent.findViewById(R.id.edtNote);

        DateFormat df = new SimpleDateFormat("dd/MM/yyyy, HH:mm");
        String sDate = df.format(Calendar.getInstance().getTime());
        date.setText(sDate);

    }

    public void init() {
        btnBack = (ImageView) findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnSave = (ImageView) findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!checkInput()){
                    return;
                }

                addNote();
                finish();
            }
        });
    }

    public boolean checkInput() {
        if (edtNote.getText().toString().equals("")) {
            Toast.makeText(this, "Chua nhap noi dung!", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

}
