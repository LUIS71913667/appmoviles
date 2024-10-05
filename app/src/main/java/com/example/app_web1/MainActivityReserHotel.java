package com.example.app_web1;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Calendar;

public class MainActivityReserHotel extends AppCompatActivity {

    private EditText etNombre, etCorreo, etNumeroHabitacion;
    private TextView tvFecha;
    private Button btnReservar;
    private Calendar calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Habilitar Edge-to-Edge UI
        EdgeToEdge.enable(this);

        // Cargar el diseño XML
        setContentView(R.layout.activity_main_reser_hotel);

        // Ajuste de las barras del sistema
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Inicializar las vistas
        etNombre = findViewById(R.id.et_nombre);
        etCorreo = findViewById(R.id.et_correo);
        etNumeroHabitacion = findViewById(R.id.et_numero_habitacion);
        tvFecha = findViewById(R.id.tv_fecha);
        btnReservar = findViewById(R.id.btn_reservar);

        // Inicializar el calendario para la selección de fecha
        calendar = Calendar.getInstance();

        // Listener para seleccionar la fecha
        tvFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePicker();
            }
        });

        // Listener para el botón de reservar
        btnReservar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmarReserva();
            }
        });
    }

    // Método para mostrar el selector de fecha
    private void showDatePicker() {
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                // Actualizar el TextView con la fecha seleccionada
                tvFecha.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
            }
        }, year, month, day);
        datePickerDialog.show();
    }

    // Método para confirmar la reserva
    private void confirmarReserva() {
        // Obtener los valores de los campos
        String nombre = etNombre.getText().toString();
        String correo = etCorreo.getText().toString();
        String fecha = tvFecha.getText().toString();
        String numeroHabitacion = etNumeroHabitacion.getText().toString();

        // Validar que todos los campos estén completos
        if (nombre.isEmpty() || correo.isEmpty() || fecha.isEmpty() || numeroHabitacion.isEmpty()) {
            Toast.makeText(MainActivityReserHotel.this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show();
        } else {
            // Lógica para manejar la reserva (envío de datos a un servidor, etc.)
            Toast.makeText(MainActivityReserHotel.this, "Reserva realizada con éxito", Toast.LENGTH_SHORT).show();
        }
    }
}
