package com.example.kotchaphanmuangsan.json;

import android.app.Activity;
import android.os.Bundle;
import android.util.JsonWriter;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.io.OutputStreamWriter;

public class MainActivity extends Activity {

    Button btnWrite;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnWrite = (Button)findViewById(R.id.btnWrite);
        btnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    JsonWriter jsonWriter = new JsonWriter(
                            new OutputStreamWriter(openFileOutput("data.json" , MODE_PRIVATE)));

                    try{
                        jsonWriter.setIndent("  ");

                        jsonWriter.beginObject();
                        jsonWriter.name("name");
                        jsonWriter.value("Kocthaphan");
                        jsonWriter.name("name");
                        jsonWriter.value("kotchaphan.m@kkumail.com");
                        jsonWriter.endObject();
                    }finally {
                        jsonWriter.close();
                    }
                }catch (IOException ex){
                    ex.printStackTrace();
                }
            }
        });

    }

}
