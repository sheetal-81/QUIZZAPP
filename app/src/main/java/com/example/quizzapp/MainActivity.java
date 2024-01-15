package com.example.quizzapp;

import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView questionTV,questionNumberTV;
    private Button option1Btn,option2Btn,option3Btn,option4Btn;
    private ArrayList<quizzmodel>quizzmodelArrayList;
    Random random;
    int currentScore=0,questionAttempted=1,currentPos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        questionTV = findViewById(R.id.Question);
        questionNumberTV = findViewById(R.id.attempted);
        option1Btn = findViewById(R.id.option1);
        option2Btn = findViewById(R.id.option2);
        option3Btn = findViewById(R.id.option3);
        option4Btn = findViewById(R.id.option4);
        quizzmodelArrayList = new ArrayList<>();
        random = new Random();
        getQuizz2Question(quizzmodelArrayList);
        currentPos=random.nextInt(quizzmodelArrayList.size());
        setDataToViews(currentPos);
        option1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizzmodelArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option1Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos=random.nextInt(quizzmodelArrayList.size());
                setDataToViews(currentPos);
            }
        });

        option2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizzmodelArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option2Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos=random.nextInt(quizzmodelArrayList.size());
                setDataToViews(currentPos);
            }
        });

        option3Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizzmodelArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option3Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos=random.nextInt(quizzmodelArrayList.size());
                setDataToViews(currentPos);
            }
        });

        option4Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizzmodelArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option4Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos=random.nextInt(quizzmodelArrayList.size());
                setDataToViews(currentPos);
            }
        });

    }
    private void showBottomSheet()
    {
        BottomSheetDialog bottomSheetDialog=new BottomSheetDialog(MainActivity.this);
        View bottomSheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.score_bottom_sheet, null);


        TextView scoreTv=bottomSheetView.findViewById(R.id.idScore);
        Button restartQuizzBtn=bottomSheetView.findViewById(R.id.restart);
        scoreTv.setText("Your Score is \n" +currentScore);
        restartQuizzBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentPos=random.nextInt(quizzmodelArrayList.size());
                setDataToViews(currentPos);
                questionAttempted=1;
                currentScore=0;
                bottomSheetDialog.dismiss();
            }
        });
        bottomSheetDialog.setCancelable(false);
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();
    }

    private void setDataToViews(int currentPos)
    {
        questionNumberTV.setText("Question Attempted : "+questionAttempted);
        if(questionAttempted==10)
        {
            showBottomSheet();
        }
        else
        {
            option1Btn.setText(quizzmodelArrayList.get(currentPos).getOption1());
            option2Btn.setText(quizzmodelArrayList.get(currentPos).getOption2());
            option3Btn.setText(quizzmodelArrayList.get(currentPos).getOption3());
            option4Btn.setText(quizzmodelArrayList.get(currentPos).getOption4());
        }

    }
        private void getQuizz2Question(ArrayList<quizzmodel> quizzmodelArrayList)
        {
            this.quizzmodelArrayList.add(new quizzmodel("what is current version of java ? " ,"8 ","17","21","25","21"));
            this.quizzmodelArrayList.add(new quizzmodel("which language is used in web development ? " ,"HTML & CSS ","Java","Kotlin","Python","HTML & CSS"));
            this.quizzmodelArrayList.add(new quizzmodel("Which is the official ide used for android development ? " ," Intellij idea ","vs code","sublime","Android studio","Android studio"));
            this.quizzmodelArrayList.add(new quizzmodel("Which is the popular javascript library ? " ,"Springboot ","React Js","Dart","Angular","React Js"));
        }
    }
