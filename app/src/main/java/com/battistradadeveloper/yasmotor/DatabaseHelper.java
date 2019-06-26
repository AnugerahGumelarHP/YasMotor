package com.battistradadeveloper.yasmotor;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static String DATABASE = "Buyer.db";
    public static String TABLE ="buyertable";
    public static String NAME ="name";
    public static String EMAIL ="email";
    public static String TYPE = "type";
    public static String NUMBER ="number";
    public static String SUM ="sum";

    String br;

    public DatabaseHelper(Context context) {
        super(context, DATABASE, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        br = "CREATE TABLE "+TABLE+"("+NAME+ " Text, "+EMAIL+ " Text,"+TYPE+ " Text, "+NUMBER+ " Text, "+SUM+ " Text);";
        db.execSQL(br);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE+" ;");
    }


    public void insertdata(String name,String email,String type,String number, String sum){
        System.out.print("Hello "+br);
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();

        contentValues.put(NAME, name);
        contentValues.put(EMAIL, email);
        contentValues.put(TYPE, type);
        contentValues.put(NUMBER, number);
        contentValues.put(SUM, sum);
        db.insert(TABLE,null,contentValues);

    }

    public List<DataModel> getdata(){
        // DataModel dataModel = new DataModel();
        List<DataModel> data=new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from "+TABLE+" ;",null);
        StringBuffer stringBuffer = new StringBuffer();
        DataModel dataModel = null;
        while (cursor.moveToNext()) {
            dataModel= new DataModel();
            String name = cursor.getString(cursor.getColumnIndexOrThrow("name"));
            String email = cursor.getString(cursor.getColumnIndexOrThrow("email"));
            String type = cursor.getString(cursor.getColumnIndexOrThrow("type"));
            String number = cursor.getString(cursor.getColumnIndexOrThrow("number"));
            String sum = cursor.getString(cursor.getColumnIndexOrThrow("sum"));
            dataModel.setName(name);
            dataModel.setEmail(email);
            dataModel.setType(type);
            dataModel.setNumber(number);
            dataModel.setSum(sum);
            stringBuffer.append(dataModel);
            // stringBuffer.append(dataModel);
            data.add(dataModel);
        }

        for (DataModel mo:data ) {
            Log.i("Hellomo",""+mo.getName());
        }
        //

        return data;
    }

}