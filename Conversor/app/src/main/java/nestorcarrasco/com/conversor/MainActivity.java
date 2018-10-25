package nestorcarrasco.com.conversor;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import clases.Conversor;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText edtDolar;
    Button   btnConvertir;
    Button   btnLimpiar;
    TextView txvResultado;
    Double   valorCambio;
    String fecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtDolar     = (EditText) findViewById(R.id.edt_dolar);
        btnConvertir = (Button)   findViewById(R.id.btn_convertir);
        btnLimpiar   = (Button)   findViewById(R.id.btn_limpiar);
        txvResultado = (TextView) findViewById(R.id.txv_resultado);

        btnConvertir.setOnClickListener(this);
        btnLimpiar.setOnClickListener(this);
        obtenerTasaDeCambio();
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btn_convertir:
                btnConvertir();
                break;
            case R.id.btn_limpiar:
                btnLimpiar();
                break;
        }
    }


    public void btnConvertir(){

        double dolar = Double.parseDouble(edtDolar.getText().toString());

        Conversor conversor = new Conversor();

        conversor.setDolar(dolar);
        conversor .setTasaDeCambio(valorCambio);

        double pesosChilenos = conversor.convertir();

        txvResultado.setText(pesosChilenos + " Pesos Chilenos");
    }


    public void btnLimpiar(){

        edtDolar.setText(null);
        txvResultado.setText(null);
    }


    public void obtenerTasaDeCambio(){

        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
        Date date = new Date();

        fecha = dateFormat.format(date);
        String url ="https://mindicador.cl/api/dolar/" + fecha;

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject respuestaJson = new JSONObject(response);
                            JSONArray arrayJson = respuestaJson.getJSONArray("serie");
                            JSONObject contenidoJson = arrayJson.getJSONObject(0);
                            String valor = contenidoJson.getString("valor");
                            valorCambio = Double.parseDouble(valor);
                            Context context = getApplicationContext();
                            Toast toast = Toast.makeText(context,"Tasa de cambio: " + valorCambio, Toast.LENGTH_SHORT);
                            toast.show();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                txvResultado.setText("¡Esto no esta resultando!");
            }
        });

        // Add the request to the RequestQueue.
        queue.add(stringRequest);
    }
}
