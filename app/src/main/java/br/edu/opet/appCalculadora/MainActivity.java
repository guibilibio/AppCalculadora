package br.edu.opet.appCalculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private String operadores;
    private double operador1;
    private double operador2;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Números
        Button buttonNum1 = (Button) findViewById(R.id.buttonNum1);
        Button buttonNum2 = (Button)  findViewById(R.id.buttonNum2);
        Button buttonNum3 = (Button) findViewById(R.id.buttonNum3);
        Button buttonNum4 = (Button) findViewById(R.id.buttonNum4);
        Button buttonNum5 = (Button) findViewById(R.id.buttonNum5);
        Button buttonNum6 = (Button) findViewById(R.id.buttonNum6);
        Button buttonNum7 = (Button) findViewById(R.id.buttonNum7);
        Button buttonNum8 = (Button) findViewById(R.id.buttonNum8);
        Button buttonNum9 = (Button) findViewById(R.id.buttonNum9);
        Button buttonNum0 = (Button) findViewById(R.id.buttonNum0);

        // Operações
        Button buttonSub = (Button) findViewById(R.id.buttonSub);
        Button buttonSoma = (Button) findViewById(R.id.buttonSoma);
        Button buttonResult = (Button) findViewById(R.id.buttonResult);

        //Clean
        Button buttonLimpa = (Button) findViewById(R.id.buttonClean);

        // Números listers
        buttonNum1.setOnClickListener(this);
        buttonNum2.setOnClickListener(this);
        buttonNum3.setOnClickListener(this);
        buttonNum4.setOnClickListener(this);
        buttonNum5.setOnClickListener(this);
        buttonNum6.setOnClickListener(this);
        buttonNum7.setOnClickListener(this);
        buttonNum8.setOnClickListener(this);
        buttonNum9.setOnClickListener(this);
        buttonNum0.setOnClickListener(this);

        //Operadores listers
        buttonSub.setOnClickListener(this);
        buttonSoma.setOnClickListener(this);
        buttonResult.setOnClickListener(this);

        //Botão limpar
        buttonLimpa.setOnClickListener(this);
    }

    private void teclado(int leNum){

        TextView result = (TextView) findViewById(R.id.tvResultado);

        if(result.getText().toString().trim().equals("0.0")){
            limpador();
            result.setText(result.getText().toString() + String.valueOf(leNum));
        }else{
            result.setText(result.getText().toString() + String.valueOf(leNum));
        }
    }

    private void operacoes(String operadores){

        TextView result = (TextView) findViewById(R.id.tvResultado);

        this.operadores = operadores;

        if(operadores == "+"){
            operador1 = Double.parseDouble(result.getText().toString().trim());
            limpador();
        }else if(operadores == "-"){
            operador1 = Double.parseDouble(result.getText().toString().trim());
            limpador();
        }
    }

    @Override

    public void onClick(View v) {

        switch (v.getId()){

            case R.id.buttonNum0:
                teclado(0);
                break;
            case R.id.buttonNum1:
                teclado(1);
                break;
            case R.id.buttonNum2:
                teclado(2);
                break;

            case R.id.buttonNum3:
                teclado(3);
                break;
            case R.id.buttonNum4:
                teclado(4);
                break;
            case R.id.buttonNum5:
                teclado(5);
                break;
            case R.id.buttonNum6:
                teclado(6);
                break;

            case R.id.buttonNum7:
                teclado(7);
                break;
            case R.id.buttonNum8:
                teclado(8);
                break;

            case R.id.buttonNum9:
                teclado(9);
                break;

            case R.id.buttonClean:
                limpador();

           case R.id.buttonResult:
               resultado();
                break;
            case R.id.buttonSoma:
                operacoes("+");
                break;

            case R.id.buttonSub:
                operacoes("-");
                break;
        }
    }

    private void limpador(){
        TextView result = (TextView) findViewById(R.id.tvResultado);
        result.setText("");
    }

    private void resultado(){

        TextView result = (TextView) findViewById(R.id.tvResultado);

        if(!result.getText().toString().trim().equals("")){
            if(operadores=="+"){
                operador2 = operador1 + Double.parseDouble(result.getText().toString().trim());

            }else if(operadores == "-"){
                operador2 = operador1 - Double.parseDouble(result.getText().toString().trim());
            }
        }else {
            operador2 = 0;
        }
        result.setText(String.valueOf(operador2));
    }
}
