package com.sslebedev.chat;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private static final int LOGIN_RESULT_CODE = 0;

    private String Login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(this, LoginActivity.class);
        startActivityForResult(intent, LOGIN_RESULT_CODE);
        Button buttonSend = (Button) findViewById(R.id.buttonSend);
        buttonSend.setOnClickListener(new OnButtonSendClickListener());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case LOGIN_RESULT_CODE:
                if (resultCode != RESULT_OK) {
                    break;
                }
                Login = (String) data.getExtras().get("LOGIN");
                setTitle(Login);
                break;
        }
    }

    protected class OnButtonSendClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            EditText editText = (EditText) findViewById(R.id.etMessage);
            editText.setText("");
            editText.clearFocus();
        }
    }
}
