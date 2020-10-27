package com.example.colordescriptions;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner;
    private TextView textView;
    private String colorDescriptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textViewDescriptionColor);
        spinner = findViewById(R.id.spinner);

        if (savedInstanceState != null){
            colorDescriptions = savedInstanceState.getString("colorDescription");
            textView.setText(colorDescriptions);
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putString("colorDescription", colorDescriptions);
        super.onSaveInstanceState(outState);
    }

    public void onClickBtn(View view) {
        int selectedColorPosition = spinner.getSelectedItemPosition();
        colorDescriptions = getDescriptionColor(selectedColorPosition);
        textView.setText(colorDescriptions);
    }

    private String getDescriptionColor(int position){
        String[] arrayColorDescription = getResources().getStringArray(R.array.color_description);
        return arrayColorDescription[position];
    }
}