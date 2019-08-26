package com.battistradadeveloper.yasmotor.Helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.battistradadeveloper.yasmotor.Model.DataModel;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static String DATABASE = "Buyer.db"; //Nama Database
    public static String TABLE ="buyertable"; //Nama Tabel
    public static String COLUMN_ID = "id";
    public static String NAME ="name"; //Nama Kolom Nama
    public static String EMAIL ="email";//Nama Kolom Email
    public static String TYPE = "type"; //Nama Kolom type
    public static String NUMBER ="number"; //Nama Kolom nomor hp
    public static String SUM ="sum"; //Nama kolom jumlah nominal

    String br;

    public DatabaseHelper(Context context) {
        super(context, DATABASE, null, 1);
    }

    // FUNGSI UNTUK MEMBUAT DATABASENYA
    @Override
    public void onCreate(SQLiteDatabase db) {
        br = "CREATE TABLE "+TABLE+"("
                + COLUMN_ID + "INTEGER PRIMARY KEY," + NAME + " TEXT, "
                + EMAIL + " TEXT," + TYPE + " TEXT, " +NUMBER+ " TEXT, "
                + SUM + " TEXT);";
        db.execSQL(br);
    }

    // FUNGSI UNTUK MENGECEK DATABASE ADA ATAU TIDAK.
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE);
        onCreate(db);
    }

    // FUNGSI UNTUK TAMBAH DATA
    public void insertdata(DataModel dataModel){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues= new ContentValues();
        contentValues.put(NAME, dataModel.getName());
        contentValues.put(EMAIL, dataModel.getEmail());
        contentValues.put(TYPE, dataModel.getType());
        contentValues.put(NUMBER, dataModel.getNumber());
        contentValues.put(SUM, dataModel.getSum());

        db.insert(TABLE,null,contentValues);
        db.close();
    }

    //Fungsi untuk ambil 1 data pembelian
    public DataModel getModel(int id_model){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE, new String[]{COLUMN_ID, NAME, EMAIL, TYPE, NUMBER, SUM},
                COLUMN_ID + "=?", new String[]{String.valueOf(id_model)},
                null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        DataModel model = new DataModel(cursor.getString(1),cursor.getString(2),
                cursor.getString(3),cursor.getString(4), cursor.getString(5));
        return model;
    }

    //Fungsi untuk mengambil Semua data Pembelian
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
            dataModel.setSum("Rp. "+sum);
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

    // FUNGSI UNTUK MENGHAPUS SEMUA DATA Pembelian
    public void hapusSemuaDataPembelian(){
        SQLiteDatabase db = this.getWritableDatabase();

        db.execSQL("DELETE FROM " + TABLE);
    }

    // FUNGSI UNTUK MENGHAPUS DATA Pembelian
    public void deleteitem(DataModel dataModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE, COLUMN_ID + " = ?",
                new String[]{String.valueOf(dataModel.getId())});
        db.close();
    }
}