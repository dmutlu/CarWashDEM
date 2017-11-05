package edu.umbc.dmutlu1.carwashdem;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;

import java.text.NumberFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity
{
    private final double extPrice = 10.99;
    private final double extIntPrice = 15.99;
    private final double extPriceDiscount = 8.99;
    private final double extIntPriceDiscount = 12.99;
    private int washes;
    private double custPrice;
    private String carWash;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RadioButton radioExt = findViewById(R.id.radioExtOnly);
        final RadioButton radioExtInt = findViewById(R.id.radioExtInt);
        final EditText numWash = findViewById(R.id.editText);
        Resources res = getResources();
        Button calcBtn = findViewById(R.id.button);
        NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.getDefault());

        calcBtn.setOnClickListener(v -> {
            final TextView output = findViewById(R.id.textOut);

            if (numWash.getText().toString().isEmpty())
            {
                washes = 0;
            }
            else
            {
                washes = Integer.parseInt(numWash.getText().toString());
                carWash = res.getQuantityString(R.plurals.outputs, washes, washes);
            }

            if (washes == 0)
            {
                myToast();
            }
            else if (radioExt.isChecked())
            {
                if (washes < 12)
                {
                    custPrice = washes * extPrice;
                    myToast();
                }

                else
                {
                    custPrice = washes * extPriceDiscount;
                }

                output.setVisibility(1);
                output.setText(currency.format(custPrice) + carWash);

            }
            else if (radioExtInt.isChecked())
            {
                if (washes < 12)
                {
                    custPrice = washes * extIntPrice;
                    myToast();
                }

                else
                {
                    custPrice = washes * extIntPriceDiscount;
                }

                output.setVisibility(1);
                output.setText(currency.format(custPrice) + carWash);
            }
        });
    }

    private void myToast()
    {
        Context context = getApplicationContext();
        CharSequence text = getString(R.string.toast);
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}