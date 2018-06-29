package com.amjoey.tcpseverrelay2ch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import simpletcp.*;

public class MainActivity extends AppCompatActivity {
    public static final int TCP_PORT = 21111;

    private SimpleTcpServer simpleTcpServer;

    private ToggleButton tButton1,tButton2;
    private TextView txtOutput1,txtOutput2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tButton1 =(ToggleButton) findViewById(R.id.tgButton1);
        tButton2 =(ToggleButton) findViewById(R.id.tgButton2);

        SimpleTcpClient.send("UPDATE\r\n", "192.168.1.42", TCP_PORT, new SimpleTcpClient.SendCallback() {
            public void onUpdated(String tag) {
                Toast.makeText(getApplicationContext(), tag , Toast.LENGTH_SHORT).show();
                String[] arr_state = tag.split(",");
                if(arr_state[1].equals("1")){
                    tButton1.setChecked(true);

                }else if(arr_state[1].equals("0")){
                    tButton1.setChecked(false);

                }
                if(arr_state[2].equals("1")){
                    tButton2.setChecked(true);

                }else if(arr_state[2].equals("0")){
                    tButton2.setChecked(false);

                }
            }
            public void onSuccess(String tag) {
                Toast.makeText(getApplicationContext(), "onSuccess", Toast.LENGTH_SHORT).show();
            }
            public void onFailed(String tag) {
                Toast.makeText(getApplicationContext(), "onFailed", Toast.LENGTH_SHORT).show();
            }
        }, "TAG");

        tButton1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // Send message and waiting for callback
                    SimpleTcpClient.send("OUTPUT1ON\r\n", "192.168.1.42", TCP_PORT, new SimpleTcpClient.SendCallback() {
                        public void onUpdated(String tag) {
                            Toast.makeText(getApplicationContext(), "onUpdated", Toast.LENGTH_SHORT).show();
                        }
                        public void onSuccess(String tag) {
                            Toast.makeText(getApplicationContext(), "onSuccess", Toast.LENGTH_SHORT).show();
                        }
                        public void onFailed(String tag) {
                            Toast.makeText(getApplicationContext(), "onFailed", Toast.LENGTH_SHORT).show();
                        }
                    }, "TAG");
                } else {
                    // Send message and waiting for callback
                    SimpleTcpClient.send("OUTPUT1OFF\r\n", "192.168.1.42", TCP_PORT, new SimpleTcpClient.SendCallback() {
                        public void onUpdated(String tag) {
                            Toast.makeText(getApplicationContext(), "onUpdated", Toast.LENGTH_SHORT).show();
                        }
                        public void onSuccess(String tag) {
                            Toast.makeText(getApplicationContext(), "onSuccess", Toast.LENGTH_SHORT).show();
                        }
                        public void onFailed(String tag) {
                            Toast.makeText(getApplicationContext(), "onFailed", Toast.LENGTH_SHORT).show();
                        }
                    }, "TAG");
                }
            }
        });

        tButton2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // Send message and waiting for callback
                    SimpleTcpClient.send("OUTPUT2ON\r\n", "192.168.1.42", TCP_PORT, new SimpleTcpClient.SendCallback() {
                        public void onUpdated(String tag) {
                            Toast.makeText(getApplicationContext(), "onUpdated", Toast.LENGTH_SHORT).show();
                        }
                        public void onSuccess(String tag) {
                            Toast.makeText(getApplicationContext(), "onSuccess", Toast.LENGTH_SHORT).show();
                        }
                        public void onFailed(String tag) {
                            Toast.makeText(getApplicationContext(), "onFailed", Toast.LENGTH_SHORT).show();
                        }
                    }, "TAG");
                } else {
                    // Send message and waiting for callback
                    SimpleTcpClient.send("OUTPUT2OFF\r\n", "192.168.1.42", TCP_PORT, new SimpleTcpClient.SendCallback() {
                        public void onUpdated(String tag) {
                            Toast.makeText(getApplicationContext(), "onUpdated", Toast.LENGTH_SHORT).show();
                        }
                        public void onSuccess(String tag) {
                            Toast.makeText(getApplicationContext(), "onSuccess", Toast.LENGTH_SHORT).show();
                        }
                        public void onFailed(String tag) {
                            Toast.makeText(getApplicationContext(), "onFailed", Toast.LENGTH_SHORT).show();
                        }
                    }, "TAG");
                }
            }
        });

    }
}
