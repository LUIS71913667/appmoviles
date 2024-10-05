package com.example.app_web1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivyLogin extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activy_login);

        // Inicializar las vistas
        initializeViews();

        // Ajustar los insets para las barras del sistema
        adjustSystemBars();

        // Configurar el botón de login
        configureLoginButton();
    }

    private void initializeViews() {
        usernameEditText = findViewById(R.id.username);
        passwordEditText = findViewById(R.id.password);
    }

    private void adjustSystemBars() {
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void configureLoginButton() {
        Button loginButton = findViewById(R.id.login_button);
        loginButton.setOnClickListener(v -> validateLogin());
    }

    private void validateLogin() {
        String username = usernameEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        if (username.isEmpty() || password.isEmpty()) {
            Toast.makeText(MainActivyLogin.this, "Por favor, ingresa el nombre de usuario y la contraseña", Toast.LENGTH_SHORT).show();
        } else {
            // Iniciar sesión o realizar alguna acción
            Toast.makeText(MainActivyLogin.this, "Iniciando sesión...", Toast.LENGTH_SHORT).show();
            // Iniciar una nueva actividad si es necesario
            startNextActivity();
        }
    }

    private void startNextActivity() {
        Intent intent = new Intent(MainActivyLogin.this, MainActivity2.class);
        startActivity(intent);
    }
}
