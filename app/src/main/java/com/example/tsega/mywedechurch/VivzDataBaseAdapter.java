package com.example.tsega.mywedechurch;

import android.app.Notification;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v4.app.NotificationCompat;
import android.content.ContentValues;
import static android.R.id.message;


import layout.MainFragment;

import static android.R.id.message;
import static android.os.FileObserver.CREATE;


/**
 * Created by tsega on 28-Nov-17.
 */
public class VivzDataBaseAdapter {

    VivzHelper helper;
    public VivzDataBaseAdapter(Context context){
        //TODO Auto-generated constructor stub
        helper=new VivzHelper(context);

    }
 public long insertData(String Church_NAME,  String Church_Location, String Email, String Phone_no, String Website)
 {
     SQLiteDatabase db=helper.getWritableDatabase();
     ContentValues contentValues=new ContentValues();
     contentValues.put(VivzHelper.Church_NAME, Church_NAME);
     contentValues.put(VivzHelper.Church_Location, Church_Location);
     //contentValues.put(VivzHelper.Church_Image, Image);
     contentValues.put(VivzHelper.Email, Email);
     contentValues.put(VivzHelper.Phone_no, Phone_no);
     contentValues.put(VivzHelper.Website, Website);
     long id=db.insert(VivzHelper.TABEL_NAME, null, contentValues);
     db.close();
     return id;

 }

   static class VivzHelper extends SQLiteOpenHelper {

        private static final String DATABASE_NAME = "wedechurch_Database";
        private static final String TABEL_NAME = "wedechurch_Tabel";
        private static final int DATABASE_VERTION = 7;
        private static final String UID = "_id";
        private static final String Church_NAME = "NAME";
        private static final String Church_Location = "Location";
        private static final String Church_Image = "Image";
        private static final String Email = "Email";
        private static final String Phone_no = "Phone_No";
        private static final String Website = "Website";
        private static final String CREATE_TABLE = "CREATE TABEL " + TABEL_NAME + " (" + UID + " INTEGER PRIMERY KEY AUTOINCREMENT, " + Church_NAME + " VARCHAR(255)," +
                "" + Church_Location + "VARCHAR(255)," + Church_Image + "blob," + Email + "VARCHAR(255)," + Phone_no + "VARCHAR(255)," + Website + "VARCHAR(255))";
        private static final String DROP_TABLE = "DROP TABELIF EXISTS" + TABEL_NAME + "";
        private Context context;

       // public void VivzHelper() {

       // }

        public VivzHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERTION);
            this.context = context;
            Message.message(context,"constructor called");
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            //CREATE TABEL WEDECHURCH (_id INTEGER PRIMERY KEY AUTOINCREMENT, Name VARCHAR(255));
            try {
                db.execSQL(CREATE_TABLE);
               Message.message(context, "onCreate called");
            } catch (SQLException e) {
                Message.message(context, "" + e);
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            try {
                db.execSQL(DROP_TABLE);
               Message.message(context, "onUpgrade called");

                onCreate(db);
            } catch (SQLException e) {
              //  Message.Message(context, "" + e);

            }


        }
    }
}