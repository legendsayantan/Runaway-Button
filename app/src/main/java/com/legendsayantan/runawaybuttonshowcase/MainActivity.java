package com.legendsayantan.runawaybuttonshowcase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.ColorUtils;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.legendsayantan.runawaybutton.RunawayButton;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RunawayButton runawayButton = findViewById(R.id.button);
        runawayButton.setAnimationTime(150);
        runawayButton.setAnimationDirection(RunawayButton.MOVE_ALL_DIRECTION);
        TextView t = new TextView(getApplicationContext());
        t.setText("INVALID NUMBER.");
        t.setTextColor(ColorUtils.blendARGB(Color.YELLOW,Color.RED,0.5f));
        runawayButton.setOnClickListener(v -> Toast.makeText(getApplicationContext(),"Number valid",Toast.LENGTH_LONG).show());
        EditText editText = findViewById(R.id.editTextTextPersonName);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
            @Override
            public void afterTextChanged(Editable s) {
                runawayButton.setEnabled(s.toString().length()==10);
            }
        });
        runawayButton.setEnabled(editText.getText().toString().length()==10);
        findViewById(R.id.button2).setOnClickListener(v -> {
            runawayButton.setAnimationDirection(RunawayButton.MOVE_UP);
        });
        findViewById(R.id.button3).setOnClickListener(v -> {
            runawayButton.setAnimationDirection(RunawayButton.MOVE_DOWN);
        });
        findViewById(R.id.button4).setOnClickListener(v -> {
            runawayButton.setAnimationDirection(RunawayButton.MOVE_LEFT);
        });
        findViewById(R.id.button5).setOnClickListener(v -> {
            runawayButton.setAnimationDirection(RunawayButton.MOVE_RIGHT);
        });
        findViewById(R.id.button6).setOnClickListener(v -> {
            runawayButton.setAnimationDirection(RunawayButton.MOVE_ALL_DIRECTION);
        });
        findViewById(R.id.button7).setOnClickListener(v -> {
            runawayButton.setAnimationDirection(RunawayButton.MOVE_HORIZONTAL);
        });
        findViewById(R.id.button8).setOnClickListener(v -> {
            runawayButton.setAnimationDirection(RunawayButton.MOVE_VERTICAL);
        });
        findViewById(R.id.button9).setOnClickListener(v -> {
            runawayButton.restorePosition();
        });
        CheckBox c = findViewById(R.id.checkBox);
        c.setOnCheckedChangeListener((buttonView, isChecked) -> {
            runawayButton.setWarningView(isChecked?t:null,findViewById(R.id.parentView));
        });
    }
}