package com.example.mymap

//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import com.google.android.gms.maps.CameraUpdateFactory
//import com.google.android.gms.maps.GoogleMap
//import com.google.android.gms.maps.OnMapReadyCallback
//import com.google.android.gms.maps.SupportMapFragment
//import com.google.android.gms.maps.model.LatLng
//
//class MainActivity : AppCompatActivity(), OnMapReadyCallback {
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        val mapFragment =supportFragmentManager.findFragmentById(R.id.map_fragment) as SupportMapFragment
//        mapFragment.getMapAsync(this)
//    }
//
//    override fun onMapReady(p0: GoogleMap) {
//        val myPos = LatLng(29.3, 12.2)
//        p0.moveCamera(CameraUpdateFactory.newLatLng(myPos))
//    }
//}



//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import com.google.android.gms.maps.GoogleMap
//import com.google.android.gms.maps.OnMapReadyCallback
//import com.google.android.gms.maps.SupportMapFragment
//import com.google.android.gms.maps.model.LatLng
//import com.google.android.gms.maps.model.MarkerOptions
//
//class MainActivity : AppCompatActivity(), OnMapReadyCallback {
//    private var map: GoogleMap? = null
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        val mapFragment = supportFragmentManager.findFragmentById(R.id.map_fragment) as? SupportMapFragment
//        mapFragment?.getMapAsync(this)
//    }
//
//    override fun onMapReady(googleMap: GoogleMap) {
//        map = googleMap
//
//        val newYorkLocation = LatLng(25.913345, 84.932746) // Coordinates for central India
//
//        val newYorkMarkerOptions = MarkerOptions()
//            .position(newYorkLocation)
//            .title("New York City")
//            .snippet("The Big Apple")
//
//        map?.addMarker(newYorkMarkerOptions)
//
//        val customLatitude = 25.913345 // Replace with your desired latitude
//        val customLongitude = 84.932746 // Replace with your desired longitude
//        val customMarkerLocation =
//            LatLng(customLatitude, customLongitude) // Desired custom marker location
//
//        val customMarkerOptions = MarkerOptions()
//            .position(customMarkerLocation)
//            .title("Rahul Ranjan") // Set a title for the marker (optional)
//            .snippet("my location") // Set additional text (optional)
//
//        map?.addMarker(customMarkerOptions)
//    }
//}

//import android.annotation.SuppressLint
//import android.content.pm.PackageManager
//import android.graphics.Color
//import android.location.Location
//import android.os.Bundle
//import android.widget.ImageButton
//import android.widget.PopupMenu
//import androidx.appcompat.app.AppCompatActivity
//import androidx.core.app.ActivityCompat
//import com.google.android.gms.location.FusedLocationProviderClient
//import com.google.android.gms.location.LocationServices
//import com.google.android.gms.maps.CameraUpdateFactory
//import com.google.android.gms.maps.GoogleMap
//import com.google.android.gms.maps.OnMapReadyCallback
//import com.google.android.gms.maps.SupportMapFragment
//import com.google.android.gms.maps.model.LatLng
//import com.google.android.gms.maps.model.MarkerOptions
//import com.google.android.gms.maps.model.PolylineOptions
//
//class MainActivity : AppCompatActivity(), OnMapReadyCallback {
//    private var map: GoogleMap? = null
//    private lateinit var fusedLocationClient: FusedLocationProviderClient
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
//
//        val mapFragment =
//            supportFragmentManager.findFragmentById(R.id.map_fragment) as? SupportMapFragment
//        mapFragment?.getMapAsync(this)
//
//        val mapOptionButton: ImageButton = findViewById(R.id.mapOptionsMenu)
//        val popupMenu = PopupMenu(this, mapOptionButton)
//        popupMenu.menuInflater.inflate(R.menu.menu, popupMenu.menu)
//        popupMenu.setOnMenuItemClickListener { menuItem ->
//            changeMap(menuItem.itemId)
//            true
//        }
//        mapOptionButton.setOnClickListener {
//            popupMenu.show()
//        }
//
//        // Check for location permissions
//        if (ActivityCompat.checkSelfPermission(
//                this,
//                android.Manifest.permission.ACCESS_FINE_LOCATION
//            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
//                this,
//                android.Manifest.permission.ACCESS_COARSE_LOCATION
//            ) != PackageManager.PERMISSION_GRANTED
//        ) {
//            // Request location permissions if not granted
//            ActivityCompat.requestPermissions(
//                this,
//                arrayOf(
//                    android.Manifest.permission.ACCESS_FINE_LOCATION,
//                    android.Manifest.permission.ACCESS_COARSE_LOCATION
//                ),
//                1
//            )
//        } else {
//            // If permissions are already granted, request location updates
//            requestLocationUpdates()
//        }
//    }
//
//    private fun requestLocationUpdates() {
//        if (ActivityCompat.checkSelfPermission(
//                this,
//                android.Manifest.permission.ACCESS_FINE_LOCATION
//            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
//                this,
//                android.Manifest.permission.ACCESS_COARSE_LOCATION
//            ) != PackageManager.PERMISSION_GRANTED
//        ) {
//            // Handle the case where permissions are not granted
//            return
//        }
//
//        fusedLocationClient.lastLocation.addOnSuccessListener { location: Location? ->
//            location?.let {
//                // Move the camera to the current location
//                val currentLatLng = LatLng(it.latitude, it.longitude)
//                map?.moveCamera(CameraUpdateFactory.newLatLngZoom(currentLatLng, 15f))
//
//                // Add a marker for the current location
//                map?.addMarker(
//                    MarkerOptions()
//                        .position(currentLatLng)
//                        .title("Your Location")
//                )
//            }
//        }
//    }
//
//    private fun changeMap(itemId: Int) {
//        when (itemId) {
//            R.id.normal_map -> map?.mapType = GoogleMap.MAP_TYPE_NORMAL
//            R.id.hybrid_map -> map?.mapType = GoogleMap.MAP_TYPE_HYBRID
//            R.id.satellite_map -> map?.mapType = GoogleMap.MAP_TYPE_SATELLITE
//            R.id.terrain_map -> map?.mapType = GoogleMap.MAP_TYPE_TERRAIN
//        }
//    }
//
//    @SuppressLint("MissingPermission")
//    override fun onMapReady(googleMap: GoogleMap) {
//        map = googleMap
//
//        // Enable the "My Location" layer on the map
//        map?.isMyLocationEnabled = true
//
//        val newYorkLocation = LatLng(25.9164442, 84.9194509) // Coordinates for central India
//
//        val newYorkMarkerOptions = MarkerOptions()
//            .position(newYorkLocation)
//            .title("Shekhpura")
//            .snippet("The Big Village")
//
//        map?.addMarker(newYorkMarkerOptions)
//
//        val customLatitude = 25.9744139 // Replace with your desired latitude
//        val customLongitude = 84.9272511 // Replace with your desired longitude
//        val customMarkerLocation = LatLng(customLatitude, customLongitude) // Desired custom marker location
//
//        val customMarkerOptions = MarkerOptions()
//            .position(customMarkerLocation)
//            .title("Rahul Ranjan") // Set a title for the marker (optional)
//            .snippet("my location Shekhpura") // Set additional text (optional)
//
//        map?.addMarker(customMarkerOptions)
//
//        val polylineOptions = PolylineOptions()
//            .add(newYorkLocation, customMarkerLocation)
//            .color(Color.RED) // Set color of the polyline
//            .width(5f) // Set width of the polyline
//
//        map?.addPolyline(polylineOptions)
//    }
//}
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.graphics.Color
import android.location.Address
import android.location.Geocoder
import android.location.Location
import android.os.Bundle
import android.widget.ImageButton
import android.widget.PopupMenu
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.PolylineOptions
import java.io.IOException
import java.util.Locale

class MainActivity : AppCompatActivity(), OnMapReadyCallback {

    private var map: GoogleMap? = null
    private var fusedLocationClient: FusedLocationProviderClient? = null
    private var marker: Marker? = null

    companion object {
        private const val LOCATION_PERMISSION_REQUEST_CODE = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as? SupportMapFragment
        mapFragment?.getMapAsync(this)

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)

        val searchView = findViewById<SearchView>(R.id.searchView)

        val mapOptionButton: ImageButton = findViewById(R.id.mapOptionsMenu)
        val popupMenu = PopupMenu(this, mapOptionButton)
        popupMenu.menuInflater.inflate(R.menu.menu, popupMenu.menu)
        popupMenu.setOnMenuItemClickListener { menuItem ->
            changeMap(menuItem.itemId)
            true
        }
        mapOptionButton.setOnClickListener {
            popupMenu.show()
        }

        searchView.setOnQueryTextListener(object :
            androidx.appcompat.widget.SearchView.OnQueryTextListener,
            SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                val location = searchView.query.toString()

                if (location.isNotEmpty()) {
                    val geocoder = Geocoder(this@MainActivity)
                    try {
                        val addressList = geocoder.getFromLocationName(location, 1)
                        if (addressList != null && addressList.isNotEmpty()) {
                            val address = addressList[0]
                            val latLng = LatLng(address.latitude, address.longitude)

                            if (marker == null) {
                                marker = map?.addMarker(MarkerOptions().position(latLng).title(location))
                            } else {
                                marker?.position = latLng
                                marker?.title = location
                            }

                            map?.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 10f))
                        }
                    } catch (e: IOException) {
                        e.printStackTrace()
                    }
                }
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                return false
            }
        })
    }

    @SuppressLint("MissingPermission")
    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap
        val newYorkLocation = LatLng(25.9164442, 84.9194509) // Coordinates for central India
//        val newYorkLocation = LatLng(25.967356, 84.980635)
        val myCity = LatLng(26.014166, 84.924893)
        val someOtherLocation = LatLng(25.95, 84.95)

        val locationList = arrayListOf(newYorkLocation, myCity, someOtherLocation)

        for (i in locationList) {
            val address = getAddress(i)
            val locationName = if (address != null) {
                address.getAddressLine(0)
            } else {
                "Unknown Location"
            }
            val markerOption = MarkerOptions().position(i).title(locationName)
            map?.addMarker(markerOption)
        }

        if (ActivityCompat.checkSelfPermission(
                this,
                android.Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            map?.isMyLocationEnabled = true
            fusedLocationClient?.lastLocation?.addOnSuccessListener { location: Location? ->
                location?.let {
                    val currentLatLng = LatLng(it.latitude, it.longitude)
                    val currentMarkerOptions = MarkerOptions()
                        .position(currentLatLng)
                        .title("Your Location")
                        .snippet("Live Location")

                    map?.addMarker(currentMarkerOptions)
                    map?.moveCamera(CameraUpdateFactory.newLatLngZoom(currentLatLng, 15f))

                    drawPolylines(*locationList.toTypedArray(), currentLatLng)
                }
            }
        } else {
            ActivityCompat.requestPermissions(
                this, arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),
                LOCATION_PERMISSION_REQUEST_CODE
            )
        }
    }



    private fun drawPolylines(vararg locations: LatLng) {
        for (i in 0 until locations.size - 1) {
            val start = locations[i]
            val end = locations[i + 1]

            val polylineOptions = PolylineOptions()
                .add(start, end)
                .color(Color.RED)
                .width(5f)

            map?.addPolyline(polylineOptions)
        }
    }

    private fun changeMap(itemId: Int) {
        when (itemId) {
            R.id.normal_map -> map?.mapType = GoogleMap.MAP_TYPE_NORMAL
            R.id.hybrid_map -> map?.mapType = GoogleMap.MAP_TYPE_HYBRID
            R.id.satellite_map -> map?.mapType = GoogleMap.MAP_TYPE_SATELLITE
            R.id.terrain_map -> map?.mapType = GoogleMap.MAP_TYPE_TERRAIN
        }
    }
    private fun getAddress(latLng: LatLng): Address? {
        val geocoder = Geocoder(this, Locale.getDefault())
        try {
            val addresses = geocoder.getFromLocation(latLng.latitude, latLng.longitude, 1)
            if (addresses != null && addresses.isNotEmpty()) {
                return addresses[0]
            }
        }
        catch (e: IOException) {
            e.printStackTrace()
        }
        return null
        }
}