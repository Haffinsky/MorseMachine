package com.example.rafal.morsemachine;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static com.example.rafal.morsemachine.InputConventer.LOG_TAG;
import static com.example.rafal.morsemachine.InputConventer.convertInput;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private EditText editText;
    View view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editText = (EditText) findViewById(R.id.editText);
        button = (Button) findViewById(R.id.sendInputButton);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.toString().trim().length() > 0) {
                    button.setEnabled(true);
                } else {
                    button.setEnabled(false);
                }
            }
            @Override
            public void afterTextChanged(Editable s) {}

        });
        convertToMorse(view);
    }


    public void convertToMorse(View view){
        editText = (EditText) findViewById(R.id.editText);
        String input = editText.getText().toString();
        InputConventer inputConventer = new InputConventer();
        inputConventer.convertInput(input);
        editText.setText("");
            }
        }

