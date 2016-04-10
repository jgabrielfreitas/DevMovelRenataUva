package com.uva.renata;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import jgabrielfreitas.sdialog.dialog.SimpleDialog;
import jgabrielfreitas.sdialog.interfaces.DialogCallback;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText aValueEditText;
    EditText bValueEditText;
    EditText cValueEditText;
    Button   calculateButton;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        aValueEditText  = (EditText) findViewById(R.id.aValueEditText);
        bValueEditText  = (EditText) findViewById(R.id.bValueEditText);
        cValueEditText  = (EditText) findViewById(R.id.cValueEditText);
        calculateButton = (Button)   findViewById(R.id.calculateButton);

        calculateButton.setOnClickListener(this);
    }


    public void onClick(View v) {

        // valida o campo A
        if (validateField(aValueEditText) == false) {
            showEmptyEditText("Valor de A é inválido");
            return;
        }

        // valida o campo B
        if (validateField(bValueEditText) == false) {
            showEmptyEditText("Valor de B é inválido");
            return;
        }

        // valida o campo C
        if (validateField(cValueEditText) == false) {
            showEmptyEditText("Valor de C é inválido");
            return;
        }

        double a = Double.parseDouble(aValueEditText.getText().toString());
        double b = Double.parseDouble(bValueEditText.getText().toString());
        double c = Double.parseDouble(cValueEditText.getText().toString());

        Equation equation = new Equation();
        equation.setaValue(a);
        equation.setbValue(b);
        equation.setcValue(c);

        showEmptyEditText(equation.result());
    }

    private boolean validateField(EditText editTextToValidate) {
        return editTextToValidate.getText().toString() != null && editTextToValidate.getText().toString().length() > 0;
    }

    private void showEmptyEditText(String message) {
        new SimpleDialog(this).setMessage(message).setPositiveButtonText("Fechar").setDialogCallback(new DialogCallback() {
            public void onPositiveButton() {}
            public void onNegativeButton() {}
            public void onNeutralButton() {}
        }).create();
    }
}
