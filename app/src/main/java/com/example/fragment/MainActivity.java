
package com.example.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements ListFrag.ItemSelected {

    TextView txtDetails;
    String [] desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtDetails = findViewById(R.id.txtDetails);

        desc = getResources().getStringArray(R.array.descriptions);

//        if phone is in potrait mode
        if (findViewById(R.id.layout_portrait) != null){
            FragmentManager manager = getSupportFragmentManager();

            manager.beginTransaction()
                    .hide(manager.findFragmentById(R.id.detailFrag))
                    .show(manager.findFragmentById(R.id.listFrag))
                    .commit();
        }

//        if phone is in landscape mode
        if (findViewById(R.id.layout_land) != null){
            FragmentManager manager = getSupportFragmentManager();

            manager.beginTransaction()
                    .show(manager.findFragmentById(R.id.listFrag))
                    .show(manager.findFragmentById(R.id.detailFrag))
                    .commit();
        }
    }

    @Override
    public void onItemSelected(int index) {
        txtDetails.setText(desc[index]);

        if (findViewById(R.id.layout_portrait) != null){
            FragmentManager manager = getSupportFragmentManager();

            manager.beginTransaction()
                    .show(manager.findFragmentById(R.id.detailFrag))
                    .hide(manager.findFragmentById(R.id.listFrag))
                    .addToBackStack(null)
                    .commit();
        }
    }
}
