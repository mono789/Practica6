package com.juan.prac6;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by juan on 25/10/17.
 */

public class PrestamosSQLiteHelper extends SQLiteOpenHelper {

    String DATA_BASE_NAME="PrestamosBD";
    int DATA_VERSION=1;
    String sqlcreate="CREATE TABLE prestamos("+
            "id     TEXT,"+ //0
            "nombre TEXT,"+//1
            "telefono   TEXT,"+//2
            "nombrelib   TEXT,"+//3
            "autor  TEXT)";//4

    public PrestamosSQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sqlcreate);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS prestamos");
        db.execSQL(sqlcreate);

    }
}
