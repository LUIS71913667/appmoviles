package com.example.app_web1;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Calendar;

public class MainActivityReserRestaurante extends AppCompatActivity {

    private EditText etNombre;
    private EditText etCorreo;
    private TextView tvFecha;
    private EditText etNumPersonas;
    private Button btnReservar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_reser_restaurante);

        // Asignar las vistas a las variables
        etNombre = findViewById(R.id.et_nombre);
        etCorreo = findViewById(R.id.et_correo);
        tvFecha = findViewById(R.id.tv_fecha);
        etNumPersonas = findViewById(R.id.et_num_personas);
        btnReservar = findViewById(R.id.btn_reservar);

        // Listener para el botón de reservar
        btnReservar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener los valores de los campos
                String nombre = etNombre.getText().toString();
                String correo = etCorreo.getText().toString();
                String fecha = tvFecha.getText().toString();
                String numPersonas = etNumPersonas.getText().toString();

                // Validar los campos
                if (nombre.isEmpty() || correo.isEmpty() || fecha.isEmpty() || numPersonas.isEmpty()) {
                    Toast.makeText(MainActivityReserRestaurante.this, "Por favor, llena todos los campos", Toast.LENGTH_SHORT).show();
                } else {
                    // Aquí podrías enviar los datos a un servidor o guardar la reserva
                    Toast.makeText(MainActivityReserRestaurante.this, "Reserva confirmada para " + numPersonas + " personas.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Listener para la selección de fecha
        tvFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener la fecha actual
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);

                // Crear un DatePickerDialog
                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivityReserRestaurante.this,
                        (view, selectedYear, selectedMonth, selectedDay) -> {
                            // Formatear y mostrar la fecha seleccionada
                            tvFecha.setText(selectedDay + "/" + (selectedMonth + 1) + "/" + selectedYear);
                        }, year, month, day);

                // Mostrar el diálogo
                datePickerDialog.show();
            }
        });

        // Ajustes para sistema de insets (barra de estado, navegación, etc.)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
