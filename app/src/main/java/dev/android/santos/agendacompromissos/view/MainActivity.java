package dev.android.santos.agendacompromissos.view;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import dev.android.santos.agendacompromissos.R;
import dev.android.santos.agendacompromissos.model.Compromissos;

public class MainActivity extends AppCompatActivity {
    Compromissos compromisso;

    EditText editNome;
    EditText editData;
    EditText editHora;
    EditText editLocal;

    Button btnLimpar;
    Button btnSalvar;
    Button btnFinalizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        compromisso = new Compromissos();
        compromisso.setNome("Encontro amigos");
        compromisso.setData("26/05/2023");
        compromisso.setHora("13:40");
        compromisso.setLocal("Praça Tubal Vilela");

        editNome = findViewById(R.id.editNome);
        editData = findViewById(R.id.editData);
        editHora = findViewById(R.id.editHora);
        editLocal = findViewById(R.id.editLocal);

        btnLimpar = findViewById(R.id.btnLimpar);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnFinalizar = findViewById(R.id.btnFinalizar);

        editNome.setText(compromisso.getNome());
        editData.setText(compromisso.getData());
        editHora.setText(compromisso.getHora());
        editLocal.setText(compromisso.getLocal());

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Dados informados limpados com sucesso !", Toast.LENGTH_LONG).show();
                editNome.setText("");
                editData.setText("");
                editHora.setText("");
                editLocal.setText("");
            }
        });

        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Compromisso realizado !", Toast.LENGTH_LONG).show();
            }
        });

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compromisso.setNome(editNome.getText().toString());
                compromisso.setData(editData.getText().toString());
                compromisso.setHora(editHora.getText().toString());
                compromisso.setLocal(editLocal.getText().toString());

                Toast.makeText(MainActivity.this, "Compromisso salvo !" + compromisso.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }
}