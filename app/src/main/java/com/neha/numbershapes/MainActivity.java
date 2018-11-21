package com.neha.numbershapes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    class Number {

        int number = 0;

        private boolean isSquareNumber() {
            // 1 4 9 16
            double squareRootNumber = Math.sqrt(number);

            return squareRootNumber == Math.floor(squareRootNumber);

            /*if (squareRootNumber == Math.floor(squareRootNumber)) {
                return true;
            } else {
                return false;
            }*/
        }

        private boolean isTriangularNumber() {
            // 1 3 6 10
            int triangularNumber = 1;

            int incrementNumber = 2;

            while (triangularNumber < number) {

                System.out.println(triangularNumber);

                triangularNumber = triangularNumber + incrementNumber;

                incrementNumber++;
            }

            return triangularNumber == number;

            /*if (triangularNumber == number) {
                return true;
            } else {
                return false;
            }*/
        }
    }

    public void onButtonClick(View view) {

        String msg = " ";
        EditText numberEditText = (EditText) findViewById(R.id.numberEditText);

        if(numberEditText.getText().toString().isEmpty()) {

           msg = "Please enter the number";

        }else {

            Number num = new Number();

            num.number = Integer.parseInt(numberEditText.getText().toString());

            if (num.isSquareNumber()) {

                if (num.isTriangularNumber()) {

                    msg = num.number + " is both triangular number and square number! ";

                } else {

                    msg = num.number + " is a square number, but not a triangular number. ";
                }

            } else {

                if (num.isTriangularNumber()) {

                    msg = num.number + " is a triangular number, but not a square number! ";

                } else {

                    msg = num.number + " is neither a square nor triangular number. ";
                }

            }
        }
        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
