package com.example.clase11_6

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.Manifest
import android.content.pm.PackageManager
import android.location.Location
import android.widget.TextView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices

//import com.google.android.gms.location.FusedLocationProviderClient
//import com.google.android.gms.location.LocationServices

class MainActivity : AppCompatActivity() {

    private lateinit var fusedLocationClient: FusedLocationProviderClient // Cliente de ubicación
    private lateinit var txtLocation: TextView // Texto para mostrar la ubicación
    private lateinit var btnLocation: Button // Botón para obtener ubicación

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicializar elementos de la UI
        txtLocation = findViewById(R.id.txtLocation)
        btnLocation = findViewById(R.id.btnLocation)

        // Inicializar el cliente de ubicación
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)

        // Evento del botón para obtener ubicación
        btnLocation.setOnClickListener {
            getLocation()
        }
    }

    private fun getLocation() {
        // Verificar si los permisos están otorgados
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
            != PackageManager.PERMISSION_GRANTED) {

            // Solicitar permisos si no están concedidos
            ActivityCompat.requestPermissions(this,
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), 1)
            return
        }

        // Obtener la última ubicación conocida
        fusedLocationClient.lastLocation.addOnSuccessListener { location: Location? ->
            if (location != null) {
                val latitud = location.latitude
                val longitud = location.longitude

                // Mostrar la ubicación en el TextView
                txtLocation.text = "Latitud: $latitud\nLongitud: $longitud"
            } else {
                txtLocation.text = "No se pudo obtener la ubicación"
            }
        }
    }
}
