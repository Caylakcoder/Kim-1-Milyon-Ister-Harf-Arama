package com.denemeler.harfsayar;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Iller iller;
    private int toplamHarfSayısı;
    EditText harfEditText;
    Button harfAraButton;
    TextView sonucTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        harfEditText = findViewById(R.id.harfEditText);
        harfAraButton = findViewById(R.id.harfAraButton);
        sonucTextView = findViewById(R.id.sonucTextView);
        iller = new Iller();
        toplamHarfSayısı = 0;

        harfAraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String arananHarf = harfEditText.getText().toString().toLowerCase().trim().substring(0, 1);

                toplamHarfSayısı = 0;

                List<String> illerListesi = iller.getIller();

                for (String il : illerListesi) {
                    for (char harf : il.toLowerCase().toCharArray()) {
                        if (harf == arananHarf.charAt(0)) {
                            toplamHarfSayısı++;
                        }
                    }
                }
                sonucTextView.setText("Türkiye'nin 81 ilinde aradığın '" + arananHarf + "' harfi toplamda " + toplamHarfSayısı + " kez geçiyor.");
            }
        });
    }
}