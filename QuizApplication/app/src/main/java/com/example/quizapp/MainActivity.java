package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    int flag = 0;
    TextView textView;
    Button submit, next;
    RadioGroup radioGroup;
    RadioButton radioButton, radioButton2, radioButton3, selected;
    ArrayList<String> rightAnswers;

    String questions[] = {
            "Q 1 - By default the members of the structure are __________.",
            "Q 2 - What is meant by template parameter?",
            "Q 3 - Which parameter is legal for non-type template?",
            "Q 4 - What is other name of full specialization?",
            "Q 5 - How many bits of memory needed for internal representation of a class?"
    };

    String options[] = {
            "Public", "Private", "Protected",
            "It can be used to pass a type as argument", "It can be used to evaluate a type.", "None of the mentioned",
            "Object", "Class", "None",
            "Explicit specialization", "Implicit specialization", "Function overloading template",
            "No need", "1", "2"
    };

    String answers[] = {
            "Private",
            "It can be used to pass a type as argument",
            "None",
            "Implicit specialization",
            "No need"
    };

    public void initializeData()
    {
        textView.setText(questions[flag]);
        radioButton.setText(options[flag * 3]);
        radioButton2.setText(options[(flag * 3) + 1]);
        radioButton3.setText(options[(flag * 3) + 2]);
    }

    void setRightAnswers()
    {
        if(radioGroup.getCheckedRadioButtonId()==-1)
            rightAnswers.set(flag, "Not Selected");
        else {
            int selectedId = radioGroup.getCheckedRadioButtonId();
            selected = (RadioButton) findViewById(selectedId);

            rightAnswers.set(flag, selected.getText().toString());
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rightAnswers = new ArrayList<String>(5);
        submit=(Button)findViewById(R.id.submit);
        next=(Button)findViewById(R.id.next);
        textView=(TextView) findViewById(R.id.textView);

        radioGroup=(RadioGroup)findViewById(R.id.radioGroup);
        radioButton=(RadioButton)findViewById(R.id.radioButton);
        radioButton2=(RadioButton)findViewById(R.id.radioButton2);
        radioButton3=(RadioButton)findViewById(R.id.radioButton3);

        for (int i = 0; i < 5; i++)
        {
            rightAnswers.add("");
        }
        initializeData();

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(flag == 4)
                {
                    ;
                }
                else {
                    setRightAnswers();
                    flag++;
                    initializeData();
                }

            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setRightAnswers();

                int ans = 0;
                for (int i = 0; i < 5; i ++) {
                    if (answers[i].equals(rightAnswers.get(i)))
                        ans++;
                }
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("Result", ans);
                startActivity(intent);
            }
        });
    }
}