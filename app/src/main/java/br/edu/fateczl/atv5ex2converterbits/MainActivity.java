/*
@author:<Matheus Augusto Marti>
*/

package br.edu.fateczl.atv5ex2converterbits;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText etNumeroBits;
    private Spinner spUnidade;
    private TextView tvRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etNumeroBits = findViewById(R.id.etNumeroBits);
        spUnidade = findViewById(R.id.spUnidade);
        tvRes = findViewById(R.id.tvRes);
        Button btnConverter = findViewById(R.id.btnConverter);
        preencherSpinner();
        btnConverter.setOnClickListener(op -> converter());
    }

    private void preencherSpinner() {
        List<String> lista = new ArrayList<>();
        lista.add("Bytes");
        lista.add("KB");
        lista.add("MB");
        lista.add("GB");
        lista.add("TB");

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, lista);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spUnidade.setAdapter(adapter);
    }

    private void converter() {
        String unidade = (String) spUnidade.getSelectedItem();
        double numBits = Double.parseDouble((etNumeroBits.getText().toString()));
        double res = 0;
        String resultado = "";
        switch (unidade){
            case "Bytes":
                res = numBits / 8;
                resultado = "Resultado: " + res + " bytes";
                tvRes.setText(resultado);
                break;
            case "KB":
                res = numBits / 8000;
                resultado = "Resultado: " + res + " KB";
                tvRes.setText(resultado);
                break;
            case "MB":
                res = numBits / 8000000;
                resultado = "Resultado: " + res + " MB";
                tvRes.setText(resultado);
                break;
            case "GB":
                res = numBits / 8000000000.0;
                resultado = "Resultado: " + res + " GB";
                tvRes.setText(resultado);
                break;
            case "TB":
                res = numBits / 8000000000000.0;
                resultado = "Resultado: " + res + " TB";
                tvRes.setText(resultado);
                break;
        }

    }
}