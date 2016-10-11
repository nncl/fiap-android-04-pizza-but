package com.fiap.mob.pizzabut;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    // interface => say the rules => CONTRACT

    /**
     * 1. Interface
     * 2. Set listener
     * 3. Implement 1.
     */

    private RadioGroup rg;
    private CheckBox chkBorda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rg = (RadioGroup) findViewById(R.id.radiopizzaGroup);
        chkBorda = (CheckBox) findViewById(R.id.checkBordaRecheada);

        // 2.
        rg.setOnCheckedChangeListener(this); // this => this activity
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
}
