package com.example.app_web1;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Calendar;

public class MainActivityReserViajes extends AppCompatActivity {

    private EditText etNombre;
    private EditText etDestino;
    private TextView tvFechaInicio;
    private TextView tvFechaFin;
    private EditText etNumPersonas;
    private Button btnReservar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_reser_viajes);

        // Asignar las vistas a las variables
        etNombre = findViewById(R.id.et_nombre);
        etDestino = findViewById(R.id.et_destino);
        tvFechaInicio = findViewById(R.id.tv_fecha_inicio);
        tvFechaFin = findViewById(R.id.tv_fecha_fin);
        etNumPersonas = findViewById(R.id.et_num_personas);
        btnReservar = findViewById(R.id.btn_reservar);

        // Listener para el botón de reservar
        btnReservar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener los valores de los campos
                String nombre = etNombre.getText().toString();
                String destino = etDestino.getText().toString();
                String fechaInicio = tvFechaInicio.getText().toString();
                String fechaFin = tvFechaFin.getText().toString();
                String numPersonas = etNumPersonas.getText().toString();

                // Validar los campos
                if (nombre.isEmpty() || destino.isEmpty() || fechaInicio.isEmpty() || fechaFin.isEmpty() || numPersonas.isEmpty()) {
                    Toast.makeText(MainActivityReserViajes.this, "Por favor, llena todos los campos", Toast.LENGTH_SHORT).show();
                } else {
                    // Aquí podrías enviar los datos a un servidor o guardar la reserva
                    Toast.makeText(MainActivityReserViajes.this, "Reserva confirmada para " + numPersonas + " personas.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Listener para la selección de fecha de inicio
        tvFechaInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener la fecha actual
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);

                // Crear un DatePickerDialog
                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivityReserViajes.this,
                        (view, selectedYear, selectedMonth, selectedDay) -> {
                            // Formatear y mostrar la fecha seleccionada
                            tvFechaInicio.setText(selectedDay + "/" + (selectedMonth + 1) + "/" + selectedYear);
                        }, year, month, day);

                // Mostrar el diálogo
                datePickerDialog.show();
            }
        });

        // Listener para la selección de fecha de fin
        tvFechaFin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener la fecha actual
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);

                // Crear un DatePickerDialog
                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivityReserViajes.this,
                        (view, selectedYear, selectedMonth, selectedDay) -> {
                            // Formatear y mostrar la fecha seleccionada
                            tvFechaFin.setText(selectedDay + "/" + (selectedMonth + 1) + "/" + selectedYear);
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
