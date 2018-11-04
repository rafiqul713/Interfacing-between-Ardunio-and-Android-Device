package com.example.rafiqul.arduniocontroller;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.io.OutputStream;
import java.util.UUID;

public class Second_Activity extends Activity {
    ToggleButton t0,t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13;
    Button send;
    EditText editText;
    BluetoothAdapter bluetoothAdapter=null;
    BluetoothSocket bluetoothSocket=null;
    OutputStream outputStream=null;
    //Media Access Control Address(MAC) of Bluetooth Devie
    String MAC_ADDRESS_OF_DEVICE=null;

    //Set Universal Unique Identifier
    final UUID uuid= UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");

    //Initialize Button and EditText ID
    void initialize_Button_AND_EditText_ID(){
        send= (Button) findViewById(R.id.SENDbutton);
        editText= (EditText) findViewById(R.id.editTextSend);
    }

    // Initialize Toggle Button ID
    void initialize_toggle_ID()
    {
        t0= (ToggleButton) findViewById(R.id.toggleButton0);
        t1= (ToggleButton) findViewById(R.id.toggleButton1);
        t2= (ToggleButton) findViewById(R.id.toggleButton2);
        t3= (ToggleButton) findViewById(R.id.toggleButton3);
        t4= (ToggleButton) findViewById(R.id.toggleButton4);
        t5= (ToggleButton) findViewById(R.id.toggleButton5);
        t6= (ToggleButton) findViewById(R.id.toggleButton6);
        t7= (ToggleButton) findViewById(R.id.toggleButton7);
        t8= (ToggleButton) findViewById(R.id.toggleButton8);
        t9= (ToggleButton) findViewById(R.id.toggleButton9);
        t10=(ToggleButton) findViewById(R.id.toggleButton10);
        t11= (ToggleButton) findViewById(R.id.toggleButton11);
        t12= (ToggleButton) findViewById(R.id.toggleButton12);
        t13= (ToggleButton) findViewById(R.id.toggleButton13);

    }


    //Method to Send Command
    void send_Command(String command)
    {
        byte[] buffer= command.getBytes();
        try{
            outputStream.write(buffer);
        }
        catch (Exception e)
        {
            Toast.makeText(getApplicationContext(),"ERROR! Device is not Found",Toast.LENGTH_LONG).show();
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_);
        //Initialize View
        initialize_toggle_ID();
        initialize_Button_AND_EditText_ID();

        //get Bluetooth Adapter Value
        bluetoothAdapter= BluetoothAdapter.getDefaultAdapter();


        //Check Device Support Bluetooth or Not Support Bluetooth
        //If Device Does not Support Bluetooth
        if(bluetoothAdapter==null)
        {
            Toast.makeText(getApplicationContext(),"Device Does not Support Bluetooth",2000).show();
            finish();
        }

        //If Device Support Bluetooth
        else
        {
            //If Bluetooth is ON
            if(bluetoothAdapter.isEnabled())
            {
                // Bluetooth is ON, so need not Turn ON bluetooth
            }
            // If Bluetooth is OFF then Turn ON Bluetooth
            else
            {
                Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                //startActivityForResult() method return result from Another Activity
                startActivityForResult(intent,1);
            }
        }


        //Add Action Listener for Toogle Button

        t0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(t0.isChecked())
                {


                    send_Command("01");
                }

                else
                {
                    //OFF
                    send_Command("00");
                }

            }
        });

        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (t1.isChecked()) {
                    send_Command("11");


                } else {
                    send_Command("10");


                }
            }
        });

        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (t2.isChecked()) {
                    send_Command("21");


                } else {
                    send_Command("20");


                }

            }
        });

        t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (t3.isChecked()) {
                    send_Command("31");

                } else {
                    send_Command("30");


                }
            }
        });

        t4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (t4.isChecked()) {
                    send_Command("41");


                } else {
                    send_Command("40");


                }

            }
        });

        t5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (t5.isChecked()) {
                    send_Command("51");


                } else {
                    send_Command("50");


                }
            }
        });

        t6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (t6.isChecked()) {
                    send_Command("a"); //61


                } else {
                    send_Command("b"); //60


                }
            }
        });

        t7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (t7.isChecked()) {
                    send_Command("71");


                } else {
                    send_Command("70");


                }
            }
        });

        t8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (t8.isChecked()) {
                    send_Command("81");


                } else {
                    send_Command("80");


                }
            }
        });

        t9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(t9.isChecked())
                {
                    send_Command("91");


                }
                else
                {
                    send_Command("90");


                }
            }
        });


        t10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(t10.isChecked())
                {
                    send_Command("101");


                }
                else
                {
                    send_Command("100");


                }
            }
        });

        t11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(t11.isChecked())
                {
                    send_Command("111");


                }
                else
                {
                    send_Command("110");


                }
            }
        });

        t12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(t12.isChecked())
                {
                    send_Command("121");


                }
                else
                {
                    send_Command("120");


                }
            }
        });

        t13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(t13.isChecked())
                {
                    send_Command("131");


                }
                else
                {
                    send_Command("130");


                }
            }
        });



    }


    public void onResume(){

        super.onResume();
        //get MAC address of another Device from Previous Activity
        Intent getIntentFromPreviousActivity=getIntent();
        MAC_ADDRESS_OF_DEVICE = getIntentFromPreviousActivity.getStringExtra(Device_List.TAG_NAME);

        // Set Up Pointer to the another  Device from My Device
        BluetoothDevice anotherDevice= bluetoothAdapter.getRemoteDevice(MAC_ADDRESS_OF_DEVICE);

        //Create Bluetooth Socket for Communcation

        try{
            bluetoothSocket = anotherDevice.createRfcommSocketToServiceRecord(uuid);
        }
        catch(Exception e){

        }

        //Establish Connection
        try{
            bluetoothSocket.connect();
        }
        catch(Exception e){
            try{
                //If Problem Occur then Close the Bluetooth Socket
                bluetoothSocket.close();
            }

            catch(Exception f){

            }
        }


        // Create Data Stream so that we can Send Command
        try {

            outputStream= bluetoothSocket.getOutputStream();
        }
        catch(Exception e){

        }
    }


}
