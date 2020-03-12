package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.math.BigDecimal;

public class InfoActivity extends AppCompatActivity {
    private TextView v1,v2,v3,v4,v5,v6,v7;
    private  Float height_cm;
    private Float height_m;
    private Float weight;
    private double result,result_last;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        initA();
        Intent ins = getIntent();
        Bundle bu = ins.getExtras();
        User u1=(User)bu.getSerializable("Data");
        String name=u1.getName();
        String gender=u1.getGender();
        String age=u1.getAge();
        height_cm=Float.parseFloat(u1.getHeight());
        height_m=height_cm/100;
        weight=Float.parseFloat(u1.getWeight());
        result=weight/ Math.pow(height_m,2);
        //保留double小数位为一位，四舍五入
        BigDecimal bd = new BigDecimal(result);
        result_last = bd.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
        String  standard= u1.getStandard();
        if("中国参考标准".equals( standard )){
            ChinaBMI(result_last);
        }else if("WHO 标准".equals( standard )){
            WhoStandBMI(result_last);
        }else{
            AsiaBMI(result_last);
        }
        v1.setText(name);
        v2.setText(gender);
        v3.setText(age);
        v4.setText(Float.toString( height_cm ));
        v5.setText(Float.toString( weight ));
        v6.setText( Double.toString( result_last ) );



    }

    public void initA() {
        v1 = (TextView) findViewById(R.id.name);
        v2 = (TextView) findViewById(R.id.gender);
        v3 = (TextView) findViewById(R.id.age);
        v4 = (TextView) findViewById(R.id.height);
        v5 = (TextView) findViewById(R.id.weight);
        v6 = (TextView) findViewById(R.id.result_bmi);
        v7=(TextView) findViewById(R.id.result_body);

    }


    private void ChinaBMI(double BMI) {
        if (BMI < 18.5) {
            v7.setText( "偏瘦" );
        } else if (BMI <= 23.9 && BMI >= 18.5) {
            v7.setText( "正常" );
        } else if (BMI == 24) {
            v7.setText( "超重" );
        } else if (BMI <= 26.9 && BMI > 24) {
            v7.setText( "偏胖" );
        } else if (BMI <= 29.9 && BMI >= 27) {
            v7.setText( "肥胖" );
        } else if (BMI >= 30) {
            v7.setText( "重度肥胖" );
        }
    }
    public void WhoStandBMI(double BMI) {
        if (BMI < 18.5) {
            v7.setText( "偏瘦" );
        } else if (BMI <= 24.9 && BMI >= 18.5) {
            v7.setText( "正常" );
        } else if (BMI == 25.0) {
            v7.setText( "超重" );
        } else if (BMI <= 29.9 && BMI > 25) {
            v7.setText( "偏胖" );
        } else if (BMI <= 34.9 && BMI >=30.0) {
            v7.setText( "肥胖" );
        } else if (BMI <=39.9&&BMI>= 35) {
            v7.setText( "重度肥胖" );
        }else if (BMI >= 40.0) {
            v7.setText( "极度肥胖" );
        }
    }
    private void AsiaBMI(double BMI) {
        if (BMI < 18.5) {
            v7.setText( "偏瘦" );
        } else if (BMI <= 22.9 && BMI >= 18.5) {
            v7.setText( "正常" );
        } else if (BMI == 23.0) {
            v7.setText( "超重" );
        } else if (BMI <= 24.9 && BMI > 23) {
            v7.setText( "偏胖" );
        } else if (BMI <= 29.9 && BMI >= 25) {
            v7.setText( "肥胖" );
        } else if (BMI >= 30) {
            v7.setText( "重度肥胖" );
        }
    }


}
