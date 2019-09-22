package ericdiaz.program.topviewsightseeingcodingchallenge.view

import android.Manifest.permission.ACCESS_FINE_LOCATION
import android.content.Intent
import android.content.pm.PackageManager.PERMISSION_GRANTED
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat.requestPermissions
import androidx.core.content.ContextCompat.checkSelfPermission

class PermissionActivity : AppCompatActivity() {

    private val permissionRequestId = 23

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        checkLocationPermission()
    }

    private fun checkLocationPermission() {
        if (checkSelfPermission(this, ACCESS_FINE_LOCATION) == PERMISSION_GRANTED) {
            startWeatherActivity()
        } else {
            requestPermissions(
                this,
                arrayOf(ACCESS_FINE_LOCATION),
                permissionRequestId
            )
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if ((grantResults.isNotEmpty()) && grantResults[0] == PERMISSION_GRANTED) {
            startWeatherActivity()
        }
        finish()
    }

    private fun startWeatherActivity() {
        startActivity(Intent(this, WeatherActivity::class.java))
        finish()
    }
}