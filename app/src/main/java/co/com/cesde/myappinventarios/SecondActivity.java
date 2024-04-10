package co.com.cesde.myappinventarios;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {

    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        spinner = findViewById(R.id.spinner2);

        // Lista de elementos para el spinner
        List<String> spinnerItems = new ArrayList<>();
        spinnerItems.add("INICIO");
        spinnerItems.add("USUARIOS");
        spinnerItems.add("CLIENTES");
        spinnerItems.add("CATEGORIAS");
        spinnerItems.add("MARCAS");
        spinnerItems.add("PROVEEDORES");
        spinnerItems.add("PRODUCTOS");
        spinnerItems.add("COMPRAS");
        spinnerItems.add("VENTAS");

        // Adaptador para el spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, spinnerItems);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Asignar el adaptador al spinner
        spinner.setAdapter(adapter);

        // Listener para el spinner
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                if (selectedItem.equals("USUARIOS")) {
                    Intent intent = new Intent(SecondActivity.this, Usuarios.class);
                    startActivity(intent);
                }
                // Puedes agregar más condiciones para otras opciones del spinner aquí
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // No se utiliza en este caso
            }
        });
    }
}

