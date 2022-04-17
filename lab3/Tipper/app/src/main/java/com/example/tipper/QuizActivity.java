package com.example.tipper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
    private TextView msgIfYouNotAnswered;
    private Button btnPreviousQuestion;
    private Button btnClearAction;
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
        msgIfYouNotAnswered = (TextView) findViewById(R.id.msgIfYouNotAnswered);
        btnPreviousQuestion = (Button) findViewById(R.id.btnPreviousQuestion);
        btnClearAction = (Button) findViewById(R.id.btnClearAction);
        btnNextQuestion = (Button) findViewById(R.id.btnNextQuestion);

        printQuestion(counter);

        btnPreviousQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btnFirstAnswer.isSelected()
                        || btnSecondAnswer.isSelected()
                        || btnThirdAnswer.isSelected()
                        || btnFourthAnswer.isSelected()) {
                    if (counter > 0) {
                        counter = counter - 1;
                        printQuestion(counter);
                    }
                } else {
                    msgIfYouNotAnswered.setText(R.string.errorNotSelectedAnswer);
                }

            }
        });

        btnClearAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cleanAction();
            }
        });

        btnNextQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btnFirstAnswer.isSelected()
                        || btnSecondAnswer.isSelected()
                        || btnThirdAnswer.isSelected()
                        || btnFourthAnswer.isSelected()) {
                    if(counter < 5) {
                        counter = counter + 1;
                        printQuestion(counter);
                    } else if(counter == 5) {
                        OpenMainMenuActivityOnButtonClick();
                    }
                } else {
                    msgIfYouNotAnswered.setText(R.string.errorNotSelectedAnswer);
                }
            }
        });
    }

    private void buttonsVisible() {
        if(counter == 5) {
            btnNextQuestion.setText(R.string.nameOfBtnLastQuestion);
        } else {
            btnNextQuestion.setText(R.string.nameOfBtnNextQuiz);
        }
        if(counter == 0) {
            btnPreviousQuestion.setVisibility(View.INVISIBLE);
        } else {
            btnPreviousQuestion.setVisibility(View.VISIBLE);
        }
    }

    private void cleanAction(){
        btnFirstAnswer.setBackgroundResource(R.color.color_answer_button);
        btnSecondAnswer.setBackgroundResource(R.color.color_answer_button);
        btnThirdAnswer.setBackgroundResource(R.color.color_answer_button);
        btnFourthAnswer.setBackgroundResource(R.color.color_answer_button);
        btnFirstAnswer.setSelected(false);
        btnSecondAnswer.setSelected(false);
        btnThirdAnswer.setSelected(false);
        btnFourthAnswer.setSelected(false);
        msgIfYouNotAnswered.setText("");
    }

    private void OpenMainMenuActivityOnButtonClick() {
        Intent mainMenuActivity = new Intent(this, MainMenuActivity.class);
        startActivity(mainMenuActivity);
    }

    private void printQuestion(int numb) {
        cleanAction();
        buttonsVisible();

        final Quiz q = quizList.get(numb);
        txtQuestion.setText(q.getQuestion());
        btnFirstAnswer.setText(q.getFirstAnswer());
        btnSecondAnswer.setText(q.getSecondAnswer());
        btnThirdAnswer.setText(q.getThirdAnswer());
        btnFourthAnswer.setText(q.getFourthAnswer());
        txtQuestionCounter.setText("Question " + ++numb + "/6");

        btnFirstAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!btnFirstAnswer.isSelected()
                        && !btnSecondAnswer.isSelected()
                        && !btnThirdAnswer.isSelected()
                        && !btnFourthAnswer.isSelected()) {
                            btnFirstAnswer.setSelected(true);
                            if (btnFirstAnswer.getText().equals(q.getCorrectAnswer()))
                                btnFirstAnswer.setBackgroundResource(R.color.color_correct_answer);
                            else
                                btnFirstAnswer.setBackgroundResource(R.color.color_incorrect_answer);
                }
            }
        });

        btnSecondAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!btnFirstAnswer.isSelected()
                        && !btnSecondAnswer.isSelected()
                        && !btnThirdAnswer.isSelected()
                        && !btnFourthAnswer.isSelected()) {
                    btnSecondAnswer.setSelected(true);
                    if (btnSecondAnswer.getText().equals(q.getCorrectAnswer()))
                        btnSecondAnswer.setBackgroundResource(R.color.color_correct_answer);
                    else
                        btnSecondAnswer.setBackgroundResource(R.color.color_incorrect_answer);
                }
            }
        });

        btnThirdAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!btnFirstAnswer.isSelected()
                        && !btnSecondAnswer.isSelected()
                        && !btnThirdAnswer.isSelected()
                        && !btnFourthAnswer.isSelected()) {
                    btnThirdAnswer.setSelected(true);
                    if (btnThirdAnswer.getText().equals(q.getCorrectAnswer()))
                        btnThirdAnswer.setBackgroundResource(R.color.color_correct_answer);
                    else
                        btnThirdAnswer.setBackgroundResource(R.color.color_incorrect_answer);
                }
            }
        });

        btnFourthAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!btnFirstAnswer.isSelected()
                        && !btnSecondAnswer.isSelected()
                        && !btnThirdAnswer.isSelected()
                        && !btnFourthAnswer.isSelected()) {
                    btnFourthAnswer.setSelected(true);
                    if (btnFourthAnswer.getText().equals(q.getCorrectAnswer()))
                        btnFourthAnswer.setBackgroundResource(R.color.color_correct_answer);
                    else
                        btnFourthAnswer.setBackgroundResource(R.color.color_incorrect_answer);
                }
            }
        });
    }

}