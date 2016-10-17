package com.fiap.mob.pizzabut;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, AdapterView.OnItemSelectedListener {

    // interface => say the rules => CONTRACT

    /**
     * 1. Interface
     * 2. Set listener
     * 3. Implement 1.
     */

    private RadioGroup rg;
    private CheckBox chkBorda;
    private Spinner spinPaymentMethods;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rg = (RadioGroup) findViewById(R.id.radiopizzaGroup);
        chkBorda = (CheckBox) findViewById(R.id.checkBordaRecheada);
        spinPaymentMethods = (Spinner) findViewById(R.id.payment_spinner);

        // 2. hey app, start listening any check changes...
        rg.setOnCheckedChangeListener(this); // this => this activity
        spinPaymentMethods.setOnItemSelectedListener(this);
    }

    /**
     * Calculates total's pizza price
     */

    public void calc(View v) {
        int selectedPizzaFlavour = rg.getCheckedRadioButtonId();
        int total = 0;

        if (selectedPizzaFlavour == R.id.btnMussarela) {
            total = 10;
        } else {
            if (selectedPizzaFlavour == R.id.btnCalabresa) {
                total = 15;
            } else {
                total = 20; // calabresa
            }

            if (chkBorda.isChecked()) {
                total += 5;
            }
        }

        Toast.makeText(this, "Total: R$" + total, Toast.LENGTH_LONG).show();

    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {

        // Log.i("I variable is " + i);

        if (i == R.id.btnMussarela) {
            chkBorda.setChecked(false);
            chkBorda.setEnabled(false);
        } else {
            chkBorda.setEnabled(true);
        }

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long l) {
        Object selectedPayment = parent.getItemAtPosition(pos);
        Toast.makeText(this, "You've selected " + selectedPayment, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        Toast.makeText(this, "There is nothing selected", Toast.LENGTH_LONG).show();
    }
}
