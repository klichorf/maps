package com.example.mapsgrupo46

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.example.mapsgrupo46.databinding.ActivityMapsBinding

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    private fun marker() {
        val ubicacion = LatLng(12.5203006, 122.0116874)
        val marker: MarkerOptions = MarkerOptions().position(ubicacion).title("san andres")
        mMap.addMarker(marker)
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(ubicacion, 14f), 5000, null)
        mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE)

    }


    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap


        // Add a marker in bogota and move the camera
        val bogota = LatLng(4.6534649, -74.0836453)
        mMap.addMarker(MarkerOptions().position(bogota).title("city bogota"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(bogota))


        // Add a marker in universidad caldas and move the camera
        val universidadcaldas = LatLng(5.0556, -75.4938881)
        mMap.addMarker(MarkerOptions().position(universidadcaldas).title("universidad caldas"))
        // mMap.moveCamera(CameraUpdateFactory.newLatLng(universidadcaldas))


        marker()

    }
}