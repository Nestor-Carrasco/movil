package nestorcarrasco.com.proyecto_peso_ideal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText edtEdad;
    EditText edtPesoActual;
    EditText edtNombre;
    Button   btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtEdad        = (EditText) findViewById(R.id.edt_edad);
        edtPesoActual  = (EditText) findViewById(R.id.edt_peso_actual);
        edtNombre      = (EditText) findViewById(R.id.edt_nombre);
        btnCalcular    = (Button)   findViewById(R.id.btn_calcular);

        btnCalcular.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        int    edadIngresada       = Integer.parseInt(edtEdad.getText().toString());
        int    pesoActualIngresado = Integer.parseInt(edtPesoActual.getText().toString());
        String nombreIngresado     = edtNombre.getText().toString();

        Intent intento = new Intent(MainActivity.this,ResultadoActivity.class);

        intento.putExtra("p_edad",edadIngresada);
        intento.putExtra("p_peso_actual",pesoActualIngresado);
        intento.putExtra("p_nombre",nombreIngresado);

        startActivity(intento);
    }
}
