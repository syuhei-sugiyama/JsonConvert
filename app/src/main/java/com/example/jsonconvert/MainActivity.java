package com.example.jsonconvert;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private TextView jsonDisplayArea = null;
    private EditText jsonKey = null;
    private EditText jsonValue = null;
    private Button accumulationBtn = null;
    private Button showBtn = null;
    private Map<String, String> map = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jsonDisplayArea = findViewById(R.id.jsondisplayArea);
        jsonKey = findViewById(R.id.key);
        jsonValue = findViewById(R.id.value);
        accumulationBtn = findViewById(R.id.accumulation);
        showBtn = findViewById(R.id.show);
        map = new HashMap<>();
    }

    public void accumulation(View view) {
        // 蓄積ボタン押下時処理
        map.put(jsonKey.getText().toString(), jsonValue.getText().toString());
        jsonKey.setText("");
        jsonValue.setText("");
    }

    public void show(View view) {
        // 表示ボタン押下時処理
        JSONObject jsonObject = new JSONObject();
        for (Map.Entry<String, String> entry : map.entrySet()){
            try {
                jsonObject.put(entry.getKey(), entry.getValue());
            } catch (JSONException e){
                e.printStackTrace();
            }
        }
        try {
            String jsonString = jsonObject.toString(4);
            jsonDisplayArea.setText(jsonString);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        jsonKey.setText("");
        jsonValue.setText("");
    }
}