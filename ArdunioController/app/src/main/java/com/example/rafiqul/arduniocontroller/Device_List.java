package com.example.rafiqul.arduniocontroller;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Set;

public class Device_List extends AppCompatActivity {
    static String TAG_NAME;
    ListView listView;
    BluetoothAdapter bluetoothAdapter;
    ArrayAdapter<String>arrayAdapter;
{

        }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device__list);
        listView=(ListView)findViewById(R.id.listViewPairedDevice);
        arrayAdapter= new ArrayAdapter<String>(this,R.layout.name_of_device);

        // Add Item Listener for ListView
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Get MAC address

                String information= ((TextView) view).getText().toString();
                String mac= information.substring(information.length() - 17);
                Intent nextActivity= new Intent(Device_List.this,Second_Activity.class);
                nextActivity.putExtra(TAG_NAME,mac);
                startActivity(nextActivity);
            }
        });

        listView.setAdapter(arrayAdapter);




    }

    public void onResume(){
        super.onResume();

        //Check Device Support Bluetooth or Not Support Bluetooth
        //If Device Does not Support Bluetooth
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if(bluetoothAdapter==null)
        {
            Toast.makeText(getApplicationContext(), "Device Does not Support Bluetooth", 2000).show();
            finish();
        }

        //If Device Support Bluetooth
        else
        {
            //If Bluetooth is turn OFF then Turn ON the Bluetooth
            if(!bluetoothAdapter.isEnabled())
            {
                Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                //startActivityForResult() method return result from Another Activity
                startActivityForResult(intent,1);
            }

        }

        arrayAdapter.clear();
        bluetoothAdapter= BluetoothAdapter.getDefaultAdapter();
        // Get a set of Currently Paired Device

        Set<BluetoothDevice> pairedDevice=bluetoothAdapter.getBondedDevices();

        //If Found Paired Device
        if(pairedDevice.size()>0)
        {
            for(BluetoothDevice device:pairedDevice)
            {
                arrayAdapter.add(device.getName()+"\n"+device.getAddress());
            }
        }
        else
        {
            arrayAdapter.add("Does not Found any Bluetooth Device");
        }


    }


}
