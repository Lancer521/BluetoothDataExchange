package com.tutorial.lancer521.bluetoothdataexchange;

import java.util.ArrayList;
import java.util.Set;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

/**
 * @author Lancer521
 */
public class MainActivityFragment extends Fragment implements View.OnClickListener {

  private Button mPairedButton;
  private Button mTransferButton;
  private ListView mPairedListView;
  private ArrayList<BluetoothDevice> mPairedDevices;
  private ArrayAdapter<String> mArrayAdapter;

  private static BluetoothAdapter BTAdapter;

  public MainActivityFragment() {
  }

  public static MainActivityFragment newInstance(BluetoothAdapter adapter){
    MainActivityFragment fragment = new MainActivityFragment();
    BTAdapter = adapter;
    return fragment;
  }

  @Override
  public void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);
    //TODO: initialize device list
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_main, container, false);
  }

  @Override
  public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    mPairedButton = (Button) view.findViewById(R.id.find_paired_devices_button);
    mTransferButton = (Button) view.findViewById(R.id.begin_data_transfer_button);
    mPairedListView = (ListView) view.findViewById(R.id.paired_devices_listview);

    mPairedButton.setOnClickListener(this);
    mTransferButton.setOnClickListener(this);
    super.onViewCreated(view, savedInstanceState);
  }

  @Override
  public void onClick(View v) {
    switch (v.getId()) {
      case R.id.find_paired_devices_button:
        handlePairedDevicesButton();
        break;
      case R.id.begin_data_transfer_button:
        handleDataTransferButton();
        break;
      default:
        break;
    }
  }

  private void handlePairedDevicesButton() {
//    setPairedDevicesToAdapter();
//    mPairedListView.setVisibility(View.VISIBLE);
//    mPairedListView.setAdapter(mArrayAdapter);
    //TODO: Set an adapter to the ListView
  }

  private void setPairedDevicesToAdapter() {
    Set<BluetoothDevice> devices = BTAdapter.getBondedDevices();
    mArrayAdapter = new ArrayAdapter<>(getContext(), R.layout.fragment_main);
    for(BluetoothDevice device : devices){
      mArrayAdapter.add(device.getName() + device.getAddress());
    }
  }

  private void handleDataTransferButton(){
    Intent intent = new Intent(getContext(), DataTransfer.class);
    //TODO: Pass BTAdapter and other necessary information via putExtra()
    startActivity(intent);
  }
}
