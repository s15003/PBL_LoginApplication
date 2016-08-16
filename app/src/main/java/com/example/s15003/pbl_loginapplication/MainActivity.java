package com.example.s15003.pbl_loginapplication;


import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.view.View.OnClickListener;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyOpenHelper helper = new MyOpenHelper(this);
        final SQLiteDatabase db = helper.getWritableDatabase();

        final EditText idText = (EditText) findViewById(R.id.editText);
        final EditText psText = (EditText) findViewById(R.id.editText2);

        //データを追加するボタンの処理
        Button entryButton = (Button) findViewById(R.id.button2);
        entryButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                String Id = idText.getText().toString();
                String Pass = psText.getText().toString();
                ContentValues insertValues = new ContentValues();
                insertValues.put("Id", Id);
                insertValues.put("Pass", Pass);
                long id = db.insert("person", Id, insertValues);



                // ボタンクリック時に実行される
                // 引数のViewはクリックされたボタンのViewオブジェクトでｓ
                /*final EditText editText = (EditText) findViewById(R.id.editText);
                final EditText editText2 = (EditText) findViewById(R.id.editText2);
                CharSequence message = editText.getText();
                CharSequence message2 = editText2.getText();

                if (TextUtils.isEmpty(message) || TextUtils.isEmpty(message2)) {

                }
                // 未入力の場合の処理でｓ！
                message = "未入力の部分があります";
                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
*/




            }
        });

        //ちゃんとデータをとってるか見るための処理（ホントはログインボタンなのであとで書き直す）
        Button detaBaseButton = (Button) findViewById(R.id.button);
        detaBaseButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v){
                Intent dbIntent = new Intent(MainActivity.this,
                        ShowDataBase.class);
                startActivity(dbIntent);
            }

        });



        //AllDelete(本来ならこのページにいらないがデータがいっぱいいっぱいになるのがいやなので作った)
        //後で消す予定だがアカウント削除の時に使えるかも
        Button deleteAllButton = (Button) findViewById(R.id.button3);
        deleteAllButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                String Id = idText.getText().toString();
                String Pass = psText.getText().toString();

                db.delete("person", null, null);

            }
        });





/*
    public void sendMessage(View view) {

        final EditText edittext;
        Button bt = (Button)findViewById(R.id.button);
        bt.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {

                }

        ;});

        // ボタンクリック時に実行される
        // 引数のViewはクリックされたボタンのViewオブジェクトでｓ
        final EditText editText = (EditText) findViewById(R.id.editText);
        final EditText editText2 = (EditText) findViewById(R.id.editText2);
        CharSequence message = editText.getText();
        CharSequence message2 = editText2.getText();

        if (TextUtils.isEmpty(message) || TextUtils.isEmpty(message2)) {

        }
            // 未入力の場合の処理でｓ！
            message = "未入力の部分があります";
            Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();



        }

*/
    }


}