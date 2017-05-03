package com.namcf.happynote.objects;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.namcf.happynote.R;

/**
 * Created by linuxlord on 5/4/17.
 */

public class ToolBarController {

    public static void selectColorLayout(final Activity activity, final MyNote myNote, final LinearLayout liner) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        LayoutInflater inflater = (activity).getLayoutInflater();

        View dialogView = inflater.inflate(R.layout.dialog_color_selection, null);
        builder.setView(dialogView);
        builder.setTitle("Choose Color");
        builder.setCancelable(false);

        View color1 = (View) dialogView.findViewById(R.id.vColor1);
        View color2 = (View) dialogView.findViewById(R.id.vColor2);
        View color3 = (View) dialogView.findViewById(R.id.vColor3);
        View color4 = (View) dialogView.findViewById(R.id.vColor4);

        final AlertDialog alertDialog = builder.create();

        color1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myNote.setColor(R.color.color_1);
                liner.setBackgroundColor(ContextCompat.getColor(activity, myNote.getColor()));
                alertDialog.dismiss();
            }
        });

        color2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myNote.setColor(R.color.color_2);
                liner.setBackgroundColor(ContextCompat.getColor(activity, myNote.getColor()));
                alertDialog.dismiss();
            }
        });

        color3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myNote.setColor(R.color.color_3);
                liner.setBackgroundColor(ContextCompat.getColor(activity, myNote.getColor()));
                alertDialog.dismiss();
            }
        });

        color4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myNote.setColor(R.color.color_4);
                liner.setBackgroundColor(ContextCompat.getColor(activity, myNote.getColor()));
                alertDialog.dismiss();
            }
        });

        alertDialog.show();
    }
}
