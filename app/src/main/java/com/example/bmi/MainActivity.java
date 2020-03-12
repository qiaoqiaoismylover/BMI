package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private EditText et1, et2, et3,et4;
    private RadioGroup rg;
    private Spinner sp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inintA();
    }
    public void inintA() {
        final String[] str = this.getResources().getStringArray(R.array.standard);//获取values中String.xml中的字符数组
        sp = (Spinner) findViewById(R.id.sp1);
        et1 = (EditText) findViewById(R.id.editText1);
        et2 = (EditText) findViewById(R.id.editText2);
        et3 = (EditText) findViewById(R.id.editText3);
        et4 = (EditText) findViewById(R.id.editText4);
        rg = (RadioGroup) findViewById(R.id.sex);
        ArrayAdapter<String> ada = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, str);
        sp.setAdapter(ada);
    }



    public void doSubmit(View V) {

        String sex = null;
        for (int i = 0; i < rg.getChildCount(); i++) {
            RadioButton b = (RadioButton) rg.getChildAt(i);
            if (b.isChecked()) {
                sex = b.getText().toString();
            }
        }


        Intent intent = new Intent(this,InfoActivity.class);
        Bundle bu = new Bundle();
        User u1=new User();
        u1.setName(et1.getText().toString());
        u1.setGender(sex);
        u1.setAge(et2.getText().toString());
        u1.setHeight(et3.getText().toString());
        u1.setWeight(et4.getText().toString());
        u1.setStandard(sp.getSelectedItem().toString());
        bu.putSerializable("Data",u1);
        intent.putExtras(bu);
        startActivity(intent);

    }

}
