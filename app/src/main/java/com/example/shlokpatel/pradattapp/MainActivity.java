package com.example.shlokpatel.pradattapp;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText phoneEdit,messageEdit;
    Button submitBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        phoneEdit=findViewById(R.id.phone_edit);
        messageEdit=findViewById(R.id.message_edit);
        submitBtn=findViewById(R.id.submit_btn);
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String toNumber =phoneEdit.getText().toString();
                String message=messageEdit.getText().toString();
                try {
                    Uri uri = Uri.parse("whatsapp://send?phone=+91" + toNumber + "&text=" + message);
                    Intent i = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(i);
                }
                catch (ActivityNotFoundException e){
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), "WhatsApp not installed.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
