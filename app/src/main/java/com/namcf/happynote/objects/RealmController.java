package com.namcf.happynote.objects;

import android.content.Context;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

/**
 * Created by linuxlord on 5/3/17.
 */

public class RealmController {

    private static String DATA_NAME = "happy_note.realm";
    private Realm mRealm;

    public RealmController(Context context) {
        mRealm = Realm.getInstance(
                new RealmConfiguration.Builder(context)
                        .name(DATA_NAME)
                        .build()
        );
    }

    public void addNote(MyNote mNote) {
        mNote.setId(getId());
        mRealm.beginTransaction();
        mRealm.copyToRealm(mNote);
        mRealm.commitTransaction();
    }

    public void removeNote(final MyNote myNote){
        mRealm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                RealmResults<MyNote> rows = realm.where(MyNote.class)
                        .equalTo(MyNote.KEY_ID, myNote.getId())
                        .findAll();
                rows.clear();
            }
        });

    }

    public RealmResults<MyNote> getData() {
        RealmResults<MyNote> results =
                mRealm.where(MyNote.class).findAll();
        return results;
    }

    public int getId(){
        Number currentIdNum = mRealm.where(MyNote.class).max(MyNote.KEY_ID);
        int nextId;
        if(currentIdNum == null) {
            nextId = 1;
        } else {
            nextId = currentIdNum.intValue() + 1;
        }

        return nextId;
    }
}
