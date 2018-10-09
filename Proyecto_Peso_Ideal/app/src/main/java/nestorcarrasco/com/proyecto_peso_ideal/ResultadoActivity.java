package nestorcarrasco.com.proyecto_peso_ideal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import logica.Examen;

public class ResultadoActivity extends AppCompatActivity {

    TextView txvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        txvResultado = (TextView) findViewById(R.id.txv_resultado);

        Intent intento = getIntent();

        Bundle datosRecibidos = intento.getExtras();

        Examen examen = new Examen();

        int    edadRecibido       = datosRecibidos.getInt("p_edad");
        int    pesoActualRecibido = datosRecibidos.getInt("p_peso_actual");
        String nombreRecibido     = datosRecibidos.getString("p_nombre");
        examen.setEdad(edadRecibido);
        examen.setPesoActual(pesoActualRecibido);
        examen.setNombre(nombreRecibido);


        txvResultado.setText(nombreRecibido + ", estas "+ examen.desidirEstadoPeso() + "!!");
    }
}


