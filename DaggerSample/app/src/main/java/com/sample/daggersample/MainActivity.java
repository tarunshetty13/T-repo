package com.sample.daggersample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.sample.daggersample.component.DaggerVehicleComponent;
import com.sample.daggersample.component.VehicleComponent;

public class MainActivity extends AppCompatActivity {

    Vehicle vehicle;
    private RadioGroup radioBrand;
    private Button btnDisplay;
    private RadioButton radioBrandSelected;
    private ListView mModels;
    private LinearLayout mDetailsLayout;
    private TextView mBrandName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        radioBrand = (RadioGroup) findViewById(R.id.radioBrand);
        btnDisplay = (Button) findViewById(R.id.btnDisplay);
        mModels = (ListView)findViewById(R.id.modellist);
        mDetailsLayout = (LinearLayout)findViewById(R.id.BrandDetails);
        mBrandName = (TextView)findViewById(R.id.brandname);
        btnDisplay.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // get selected radio button from radioGroup
                int selectedId = radioBrand.getCheckedRadioButtonId();

                // find the radiobutton by returned id
                radioBrandSelected = (RadioButton) findViewById(selectedId);
                VehicleComponent component = DaggerVehicleComponent.builder().vehicleModule(new VehicleModule()).build();
                vehicle = component.provideVehicle();
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,
                        android.R.layout.simple_list_item_1, android.R.id.text1, vehicle.getModelList(radioBrandSelected.getText().toString()));
                mDetailsLayout.setVisibility(View.VISIBLE);
                mBrandName.setText(radioBrandSelected.getText().toString());
                mModels.setAdapter(adapter);
            }

        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
