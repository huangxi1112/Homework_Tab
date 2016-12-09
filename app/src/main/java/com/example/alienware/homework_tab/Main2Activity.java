package com.example.alienware.homework_tab;


import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button button=(Button)findViewById(R.id.button);
        Button button2=(Button)findViewById(R.id.button2);
        final EditText editText=(EditText)findViewById(R.id.editText) ;
        final EditText editText2=(EditText)findViewById(R.id.editText2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=editText2.getText().toString();
                String number=editText.getText().toString();
                if (name.equals("")){

                    AlertDialog.Builder builder=new AlertDialog.Builder(Main2Activity.this);
                    builder.setTitle("提示").setMessage("请至少输入名字").setPositiveButton("确定",null).show();
                }
                else {
                    Manager manager=new Manager(Main2Activity.this);
                    Person person=new Person();
                    person.setName(name);
                    person.setNumber(number);
                    manager.addPerson(person);
                    startActivity(new Intent(Main2Activity.this,MainActivity.class));
                    Main2Activity.this.finish();
                }
            }
        });
    }
}
