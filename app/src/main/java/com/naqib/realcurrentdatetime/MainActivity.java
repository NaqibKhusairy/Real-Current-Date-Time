package com.naqib.realcurrentdatetime;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    TextView jam , min , sec , tarikh ,hr , mm , sc , bd1 , bd2;
    Timer timer;
    Calendar calendar;
    SimpleDateFormat date , time , minute , second;
    String j , m , s , t , Hr , Mm , Sc , bd;

    @SuppressLint("SimpleDateFormat")
    public void updateClock() {
        Hr = "JAM";
        Mm = "MINIT";
        Sc = "SAAT";
        bd = ":";

        calendar = Calendar.getInstance();
        date = new SimpleDateFormat("dd/MM/yyyy");
        time = new SimpleDateFormat("HH");
        minute = new SimpleDateFormat("mm");
        second = new SimpleDateFormat("ss");

        t = date.format(calendar.getTime());
        j = time.format(calendar.getTime());
        m = minute.format(calendar.getTime());
        s = second.format(calendar.getTime());

        tarikh.setText(t);
        jam.setText(j);
        min.setText(m);
        sec.setText(s);
        hr.setText(Hr);
        mm.setText(Mm);
        sc.setText(Sc);
        bd1.setText(bd);
        bd2.setText(bd);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        jam = findViewById(R.id.jam);
        min = findViewById(R.id.min);
        sec = findViewById(R.id.sec);
        tarikh = findViewById(R.id.tarikh);
        hr = findViewById(R.id.hr);
        mm = findViewById(R.id.mm);
        sc = findViewById(R.id.sc);
        bd1 = findViewById(R.id.bd1);
        bd2 = findViewById(R.id.bd2);

        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(() -> updateClock());
            }
        }, 0, 1000);
    }
}