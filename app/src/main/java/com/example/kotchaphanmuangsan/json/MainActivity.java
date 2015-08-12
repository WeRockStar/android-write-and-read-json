package com.example.kotchaphanmuangsan.json;

import android.app.Activity;
import android.os.Bundle;
import android.util.JsonReader;
import android.util.JsonWriter;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends Activity {

    Button btnWrite , btnRead;
    TextView txtName , txtValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnWrite = (Button)findViewById(R.id.btnWrite);
        btnRead = (Button)findViewById(R.id.btnRead);
        txtName = (TextView)findViewById(R.id.txtName);
        txtValue = (TextView)findViewById(R.id.txtValue);

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
                        jsonWriter.value("Kocthaphan Muangsan");
                        jsonWriter.name("email");
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

        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    JsonReader jsonReader = new JsonReader(new InputStreamReader((openFileInput("data.json"))));

                    try{
                        jsonReader.beginObject();

                        while (jsonReader.hasNext()){
                            String name = jsonReader.nextName();

                            if("name".equals(name)){
                                txtName.setText(jsonReader.nextString());
                            }else if("email".equals(name)){
                                txtValue.setText(jsonReader.nextString());
                            }else{
                                //Unkhonw attribute
                                jsonReader.skipValue();
                            }
                        }
                    }finally {
                        jsonReader.close();
                    }
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        });

    }

}
