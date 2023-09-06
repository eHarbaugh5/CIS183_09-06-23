package com.example.textboxessarrays;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btn_j_addResturaunt;
    Button btn_j_pickResturaunt;
    EditText tb_j_newResturaunt;
    TextView txt_j_resturaunt;
    TextView txt_j_errorNoResturaunt;
    int count = 0;
    int randomPos;

    private String[] resturaunts = new String[6];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_j_addResturaunt = findViewById(R.id.btn_v_add);
        btn_j_pickResturaunt = findViewById(R.id.btn_v_find);
        tb_j_newResturaunt = findViewById(R.id.tb_v_newResturaunt);
        txt_j_resturaunt = findViewById(R.id.txt_v_resturaunt);
        txt_j_errorNoResturaunt = findViewById(R.id.txt_v_errorNoResturaunt);

        //  testing to make sure I can edit the text view
        txt_j_resturaunt.setText("Hello");

        addResturauntButtonEvent();
        pickResturauntButtonEvent();



    }

    public void addResturauntButtonEvent()
    {
        btn_j_addResturaunt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {



                //Log.d("Add", "Add button pressed");
                //  Check to see if the array is full
                if (checkArrayFull())
                {
                    //  do something so the user cannot add more resturaunts
                    txt_j_errorNoResturaunt.setText("List is full. Click find resturaunt");
                    txt_j_errorNoResturaunt.setVisibility(View.VISIBLE);
                }
                else
                {
                    //Log.d("here",tb_j_newResturaunt.getText().toString());
                    //  if not full add resturaunt to array
                    //  get the value from the edit text and convert to string
                    //  strings are compared in java using .equals
                    if (!tb_j_newResturaunt.getText().toString().equals(""))
                    {
                        //  add to array
                        resturaunts[count] = tb_j_newResturaunt.getText().toString();
                        count++;
                        //  clear textbox
                        tb_j_newResturaunt.setText("");
                        //  make error mesage not visible
                        txt_j_errorNoResturaunt.setVisibility(View.INVISIBLE);
                    }
                    else
                    {
                        //  error: enter a resturaunt
                        //  make error not visible
                        txt_j_errorNoResturaunt.setVisibility(View.VISIBLE);
                    }
                }

            }
        });
    }
    public void pickResturauntButtonEvent()
    {
        btn_j_pickResturaunt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                //Log.d("Pick","Pick button pressed");
                //displayResturaunts();
                randomPos = (int) (Math.random() * count);
                //Log.d("random: " ,randomPos + "");
                txt_j_resturaunt.setText(resturaunts[randomPos]);

            }
        });
    }

    public boolean checkArrayFull()
    {
        //Log.d("Length",resturaunts.length + "");
        if(count < 6)
        {
            return false;
        }
        else
        {
            return true;
        }

    }

    public void displayResturaunts()
    {

        for (int i = 0; i < count; i++)
        {
            //  only display if there is something stored in the array at position i
            if (resturaunts[i] != null)
            {
                Log.d("Resturaunt: ", resturaunts[i]);
            }
        }

    }


}