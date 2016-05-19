package com.extremeboredom.mvptestingexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CalculatorActivity extends AppCompatActivity implements CalculatorView{

    @BindView(R.id.answer)
    TextView answer;

    @BindView(R.id.numA)
    EditText numA;

    @BindView(R.id.numB)
    EditText numB;

    @BindView(R.id.submit)
    Button submit;

    MathPresenter mathPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mathPresenter = new MathPresenter(this, new MathService());
    }

    @OnClick(R.id.submit)
    void submitClicked(){
        mathPresenter.onSubmitClicked();

    }

    @Override
    public int getNumB() {
        return Integer.valueOf(numB.getText().toString());
    }

    @Override
    public void showError(int resId) {
        answer.setError(getString(resId));
    }

    @Override
    public int getNumA() {
        return Integer.valueOf(numA.getText().toString());
    }

    @Override
    public void showResult(float i) {
        answer.setText("Quotient is "+i);
    }
}
