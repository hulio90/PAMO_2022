package com.example.tipper;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class QuizActivity extends AppCompatActivity {

    private TextView txtQuestion;
    private Button btnFirstAnswer;
    private Button btnSecondAnswer;
    private Button btnThirdAnswer;
    private Button btnFourthAnswer;
    private TextView txtQuestionCounter;
    private Button btnPreviewQuestion;
    private Button btnNextQuestion;

    private int counter=0;

    Quiz q1 = new Quiz("Przykładem produktu z niskim indeksem glikemicznym jest:",
            "ryż czerwony.",
            "kasza jęczmienna.",
            "banan.",
            "szpinak.",
            "szpinak.");

    Quiz q2 = new Quiz("Do najczęstszych objawów niedoboru witaminy K należy zaliczyć:",
            "nieprawidłowa krzepliwość krwi i związane z nią krwawienia, w tym zagrażająca życiu choroba krwotoczna u noworodków.",
            "długotrwałe gojenie się ran.",
            "krwiomocz.",
            "wszystkie odpowiedzi są prawidłowe.",
            "wszystkie odpowiedzi są prawidłowe.");

    Quiz q3 = new Quiz("Przykładem produktu z wysokim indeksem glikemicznym jest:",
            "migdał.",
            "dynia gotowana.",
            "jabłko duszone.",
            "awokado.",
            "dynia gotowana.");

    Quiz q4 = new Quiz("Ile posiłków dziennie powinno się jeść?",
            "dwa.",
            "trzy.",
            "cztery.",
            "pięć.",
            "pięć.");

    Quiz q5 = new Quiz("Który z posiłków jest najważniejszy?",
            "śniadanie.",
            "drugie śniadanie.",
            "obiad.",
            "kolacja.",
            "śniadanie.");

    Quiz q6 = new Quiz("Co ile godzin powinno się spożywać posiłki?",
            "1-2.",
            "2-3.",
            "3-4.",
            "4-5.",
            "3-4.");

    ArrayList<Quiz> quizList = new ArrayList<Quiz>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        quizList.add(q1);
        quizList.add(q2);
        quizList.add(q3);
        quizList.add(q4);
        quizList.add(q5);
        quizList.add(q6);

        txtQuestion = (TextView) findViewById(R.id.txtQuestion);
        btnFirstAnswer = (Button) findViewById(R.id.btnFirstOption);
        btnSecondAnswer= (Button) findViewById(R.id.btnSecondOption);
        btnThirdAnswer = (Button) findViewById(R.id.btnThirdOption);
        btnFourthAnswer= (Button) findViewById(R.id.btnFourthOption);
        txtQuestionCounter = (TextView) findViewById(R.id.txtQuestionCounter);
        btnPreviewQuestion = (Button) findViewById(R.id.btnPreviewQuestion);
        btnNextQuestion = (Button) findViewById(R.id.btnNextQuestion);

        printQuestion(counter);

        btnNextQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(counter < 5) {
                    counter = counter + 1;
                    printQuestion(counter);
                }
            }
        });

        btnPreviewQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (counter > 0) {
                    counter = counter - 1;
                    printQuestion(counter);
                }
            }
        });

    }

    private void printQuestion(int numb) {
        Quiz q = quizList.get(numb);
        txtQuestion.setText(q.getQuestion());
        btnFirstAnswer.setText(q.getFirstAnswer());
        btnSecondAnswer.setText(q.getSecondAnswer());
        btnThirdAnswer.setText(q.getThirdAnswer());
        btnFourthAnswer.setText(q.getFourthAnswer());
        txtQuestionCounter.setText("Question " + ++numb + "/6");

    }

}