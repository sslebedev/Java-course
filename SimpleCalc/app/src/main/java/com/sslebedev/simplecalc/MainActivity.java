package com.sslebedev.simplecalc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Calculator calculator = new Calculator(new Calculator.OnChangedListener() {
            @Override
            public void OnChanged(Calculator calculator) {
                System.out.println("OnChanged");
                EditText et = (EditText) findViewById(R.id.etCurValue);
                et.setText(calculator.currentNumber.value, TextView.BufferType.EDITABLE);

                TextView tv = (TextView) findViewById(R.id.tvPreHistory);
                tv.setText((calculator.prevNumber != null ? calculator.prevNumber.value + " " : "") +
                (calculator.operationBinary != null ? calculator.operationBinary.toString() : ""));
            }
        });

        Button b = (Button) findViewById(R.id.button0);
        b.setOnClickListener(calculator.currentNumber);
        b = (Button) findViewById(R.id.button1);
        b.setOnClickListener(calculator.currentNumber);
        b = (Button) findViewById(R.id.button2);
        b.setOnClickListener(calculator.currentNumber);
        b = (Button) findViewById(R.id.button3);
        b.setOnClickListener(calculator.currentNumber);
        b = (Button) findViewById(R.id.button4);
        b.setOnClickListener(calculator.currentNumber);
        b = (Button) findViewById(R.id.button5);
        b.setOnClickListener(calculator.currentNumber);
        b = (Button) findViewById(R.id.button6);
        b.setOnClickListener(calculator.currentNumber);
        b = (Button) findViewById(R.id.button7);
        b.setOnClickListener(calculator.currentNumber);
        b = (Button) findViewById(R.id.button8);
        b.setOnClickListener(calculator.currentNumber);
        b = (Button) findViewById(R.id.button9);
        b.setOnClickListener(calculator.currentNumber);
        b = (Button) findViewById(R.id.button0);
        b.setOnClickListener(calculator.currentNumber);
        b = (Button) findViewById(R.id.buttonDot);
        b.setOnClickListener(calculator.currentNumber);
        b = (Button) findViewById(R.id.buttonClr);
        b.setOnClickListener(calculator);
    }


    static class Calculator implements View.OnClickListener{

        public interface OnChangedListener {
            void OnChanged(Calculator calculator);
        }

        private OnChangedListener onChangedListener;
        Number currentNumber = new Number();
        Number prevNumber = null;
        OperationBinary operationBinary = null;

        public Calculator(OnChangedListener onChangedListener) {
            this.onChangedListener = onChangedListener;
            Clear();
        }

        public Calculator() {
            this(null);
        }

        public void Clear() {
            if (currentNumber.isEmpty()) {
                prevNumber = null;
            } else {
                currentNumber.Clear();
            }
            if (onChangedListener != null) {
                onChangedListener.OnChanged(this);
            }
        }

        @Override
        public void onClick(View v) {
            assert (v instanceof Button);
            String s = ((Button) v).getText().toString();
            if (s.compareTo("C") == 0) {
                Clear();
            }
        }

        class Number implements View.OnClickListener, Cloneable {
            String value;

            Number() {
                Clear();
            }

            public void Clear() {
                value = "0";
            }

            public boolean isEmpty() {
                return value.compareTo("0") == 0;
            }

            @Override
            public void onClick(View v) {
                assert(v instanceof Button);
                String s = ((Button) v).getText().toString();
                if (value.compareTo("0") == 0) {
                    value = "";
                }
                if (s.compareTo(".") == 0) {
                    if (value.contains(".")) {
                        return;
                    }
                }
                value = value.concat(s);

                System.out.println(value);

                if (onChangedListener != null) {
                    onChangedListener.OnChanged(Calculator.this);
                }
            }

            public Double toDouble() {
                String s = value;
                if (s.endsWith(".")) {
                    s = s.replace(".", "");
                }
                return Double.parseDouble(s);
            }
        }

        enum OperationBinary implements View.OnClickListener{
            ADD("+") {
                @Override
                double Apply(double a, double b) {
                    return a + b;
                }
            },
            SUB("-") {
                @Override
                double Apply(double a, double b) {
                    return a - b;
                }
            },
            MUL("*") {
                @Override
                double Apply(double a, double b) {
                    return a * b;
                }
            },
            DIV("/") {
                @Override
                double Apply(double a, double b) {
                    return a / b;
                }
            };

            String op;

            OperationBinary(String operation) {
                op = operation;
            }

            @Override
            public String toString() {
                return op;
            }

            abstract double Apply(double a, double b);

            @Override
            public void onClick(View v) {
                //if ()
            }
        }
    }
}
