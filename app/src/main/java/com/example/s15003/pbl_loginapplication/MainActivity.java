package com.example.s15003.pbl_loginapplication;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.util.Log;
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

    }


    public void sendMessage(View view) {

        final EditText edittext;
        Button bt = (Button)findViewById(R.id.button);
        bt.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                //パスワード処理。ここに後でデータを持ってくる。後で消すかもぬ。
                }


        });

        // ボタンクリック時に実行される
        // 引数のViewはクリックされたボタンのViewオブジェクトでｓ
        final EditText editText = (EditText) findViewById(R.id.editText);
        final EditText editText2 = (EditText) findViewById(R.id.editText2);
        CharSequence message = editText.getText();
        CharSequence message2 = editText2.getText();

        if (TextUtils.isEmpty(message) || TextUtils.isEmpty(message2)) {
            // 未入力の場合の処理でｓ！
            message = "未入力の部分があります";
            Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();



        }


    }


}