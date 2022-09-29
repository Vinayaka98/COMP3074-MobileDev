package com.georgebrown.salarycalc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.button);

        EditText hours_Worked = findViewById(R.id.hoursWorked);

        EditText hourly_Rate = findViewById(R.id.hourlyRate);

        TextView out = findViewById(R.id.output);

        TextView taxOut = findViewById(R.id.taxOutput);

        out.setText(R.string.empty);
        taxOut.setText(R.string.empty);

        btn.setOnClickListener(view -> {
            String workedHours = hours_Worked.getText().toString();
            String rateHourly = hourly_Rate.getText().toString();
            if (workedHours.isEmpty() || rateHourly.isEmpty()){
                workedHours = "0";
                rateHourly ="0";
            }
            float val = Float.parseFloat(workedHours);
            float val2 = Float.valueOf(rateHourly);
            if(val <= 40 ){
                float sal = val * val2;
                float tax = (float) (sal*0.18);
                out.setText("Salary: $"+String.valueOf(sal));
                taxOut.setText("Tax: $"+String.valueOf(tax));
            }else{
                float sal = (float) ((val-40)*val2*1.5+40*val2);
                float tax = (float) (sal * 0.18);
                out.setText("Salary: $"+ String.valueOf(sal));
                taxOut.setText("Tax: $"+String.valueOf(tax));
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        switch (id){
            case R.id.activity_item:
                Intent intent = new Intent(getApplicationContext(), AboutActivity.class);
                startActivity(intent);
                return true;
            default: return super.onOptionsItemSelected(item);
        }
    }
}