package com.example.s15003.pbl_loginapplication;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

//　サンプルデータベース処理。後で消す・ω・（chack）

public class data extends Activity implements View.OnClickListener {

    static final String TAG = "MainActivity";

    private SQLiteDatabase mDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // DBオープン処理
        SampleSQLiteOpenHelper hlpr = new SampleSQLiteOpenHelper(getApplicationContext());
        mDb = hlpr.getWritableDatabase();

        // ボタンのリスナー登録
        Button btnRegister = (Button)findViewById(R.id.button);
        btnRegister.setOnClickListener(this);
    }

    /**
     * ボタンを押すたびにデータ追加と全データ取得を行う
     * 取得したデータはLogCatに吐くようにしてる・・・・はず！！
     */
    @Override
    public void onClick(View v) {

        // テーブルにデータ追加
        if(v.getId() == R.id.button) {
            // ContentValuesにデータを格納
            ContentValues values = new ContentValues();
            values.put("data", 12345);
            // データの挿入
            mDb.insert("sample_table", null, values);

            // データ挿入にはexecSQL()メソッドも使用可能
            // mDb.execSQL("insert into sample_table(data)values(12345);");
        }

        // テーブルからデータ取得
        Cursor cursor = mDb.query(
                "sample_table", new String[] {"_id", "data"},
                null, null, null, null, "_id DESC");
        // 参照先を一番始めに
        boolean isEof = cursor.moveToFirst();
        while(isEof) {
            Log.d(TAG, "" + cursor.getInt(cursor.getColumnIndex("data")));
            isEof = cursor.moveToNext();
        }
        cursor.close();
    }
}

/**
 * SQLiteOpenHelperのサブクラスSampleSQLiteOpenHelperの実装
 */
class SampleSQLiteOpenHelper extends SQLiteOpenHelper {

    static final String DB_NAME = "sqlite_sample.db";
    static final int DB_VERSION = 1;

    static final String CREATE_TABLE =  "create table sample_table ( " +
            "_id integer primary key autoincrement, " +
            "data integer not null );";

    static final String DROP_TABLE = "drop table sample_table;";

    public SampleSQLiteOpenHelper(Context c) {
        super(c, DB_NAME, null, DB_VERSION);
    }

    /**
     * データベースファイル初回使用時に実行される処理
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        // テーブル作成のクエリを発行
        db.execSQL(CREATE_TABLE);
    }

    /**
     * データベースのバージョンアップ時に実行される処理
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // テーブルの破棄と再作成
        db.execSQL(DROP_TABLE);
        onCreate(db);
    }
}