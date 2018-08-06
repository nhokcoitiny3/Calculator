package com.example.nhokc.project1;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.example.nhokc.project1.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    String answer="";
    String result ="";
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        initialize();
    }

    private void initialize() {
        binding.btn0.setOnClickListener(this);
        binding.btn1.setOnClickListener(this);
        binding.btn2.setOnClickListener(this);
        binding.btn3.setOnClickListener(this);
        binding.btn4.setOnClickListener(this);
        binding.btn5.setOnClickListener(this);
        binding.btn6.setOnClickListener(this);
        binding.btn7.setOnClickListener(this);
        binding.btn8.setOnClickListener(this);
        binding.btn9.setOnClickListener(this);
        binding.btnSub.setOnClickListener(this);
        binding.btnSum.setOnClickListener(this);
        binding.btnMulti.setOnClickListener(this);
        binding.btnDiv.setOnClickListener(this);
        binding.btnDel.setOnClickListener(this);
        binding.btnDot.setOnClickListener(this);
        binding.btnC.setOnClickListener(this);
        binding.btnAnswer.setOnClickListener(this);
       }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_0:
                result += binding.btn0.getText().toString();
                binding.txtCalculator.setText(result);
                break;
            case R.id.btn_1:
                result += binding.btn1.getText().toString();
                binding.txtCalculator.setText(result);
                break;
            case R.id.btn_2:
                result += binding.btn2.getText().toString();
                binding.txtCalculator.setText(result);
                break;
            case R.id.btn_3:
                result += binding.btn3.getText().toString();
                binding.txtCalculator.setText(result);
                break;
            case R.id.btn_4:
                result += binding.btn4.getText().toString();
                binding.txtCalculator.setText(result);
                break;
            case R.id.btn_5:
                result += binding.btn5.getText().toString();
                binding.txtCalculator.setText(result);
                break;
            case R.id.btn_6:
                result += binding.btn6.getText().toString();
                binding.txtCalculator.setText(result);
                break;
            case R.id.btn_7:
                result += binding.btn7.getText().toString();
                binding.txtCalculator.setText(result);
                break;
            case R.id.btn_8:
                result += binding.btn8.getText().toString();
                binding.txtCalculator.setText(result);
                break;
            case R.id.btn_9:
                result += binding.btn9.getText().toString();
                binding.txtCalculator.setText(result);
                break;
            case R.id.btn_dot:
                result += binding.btnDot.getText().toString();
                binding.txtCalculator.setText(result);
                break;
            case R.id.btn_sum:
                if (result==""){
                    result=answer+ binding.btnSum.getText().toString();
                    binding.txtCalculator.setText(result);
                }else {
                    result += binding.btnSum.getText().toString();
                    binding.txtCalculator.setText(result);
                }
                break;
            case R.id.btn_sub:
                if (result==""){
                    result=answer+ binding.btnSub.getText().toString();
                    binding.txtCalculator.setText(result);
                }else {
                    result += binding.btnSub.getText().toString();
                    binding.txtCalculator.setText(result);
                }
                break;
            case R.id.btn_div:
                if (result==""){
                    result=answer+ binding.btnDiv.getText().toString();
                    binding.txtCalculator.setText(result);
                }else {
                    result += binding.btnDiv.getText().toString();
                    binding.txtCalculator.setText(result);
                }
                break;
            case R.id.btn_multi:
                if (result==""){
                    result=answer+ binding.btnMulti.getText().toString();
                    binding.txtCalculator.setText(result);

                }else {
                    result += binding.btnMulti.getText().toString();
                    binding.txtCalculator.setText(result);
                }
                break;
            case R.id.btn_del:
                if (result.length()>=2) {
                    result = result.substring(0, result.length() - 1);
                    binding.txtCalculator.setText(result);
                }else {
                    result = "";
                    binding.txtCalculator.setText("0");
                }
                break;

            case R.id.btn_c:
                if (result.length()>=1) {
                    result = "";
                    binding.txtCalculator.setText("0");
                }
                break;
            case R.id.btn_answer:
                if (result!="") {
                    answer = calculator(result);
                    result = "";
                    binding.txtCalculator.setText(answer);
                }
                break;
        }
    }

    private String calculator(String result){
        double answer=0;
        double num1 = 0;
        double num2 = 0;
        char cal = '0';
            for (int i=0;i<result.length();i++){
                if ((result.codePointAt(i) <48 && result.codePointAt(i)!=46) ||result.codePointAt(i) >57){
                    num1= Double.parseDouble(result.substring(0,i));
                    num2= Double.parseDouble(result.substring(i+1,result.length()));
                    cal = result.charAt(i);
                    break;
                }
            }
            switch (cal){
                case '+':
                    answer = num1+num2;
                    break;
                case '-':
                    answer = num1-num2;
                    break;
                case '*':
                    answer = num1*num2;
                    break;
                case '/':
                    answer = num1/num2;
                    break;
                 default:
                     answer= Double.parseDouble(result);
                     break;
            }
        return String.valueOf(answer);
    }
}
