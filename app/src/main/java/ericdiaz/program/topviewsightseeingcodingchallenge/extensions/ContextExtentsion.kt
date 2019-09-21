package ericdiaz.program.topviewsightseeingcodingchallenge.extensions

import android.content.Context
import android.location.Location
import android.net.ConnectivityManager
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.OnSuccessListener

fun Context.getLocation(
    onSuccessListener: OnSuccessListener<Location>,
    onFailureListener: OnFailureListener
) {
    val client: FusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)

    client.lastLocation
        .addOnSuccessListener(onSuccessListener)
        .addOnFailureListener(onFailureListener)
}

fun Context.isNetworkConnected(): Boolean {
    val connectivityManager: ConnectivityManager =
        this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    val activeNetworkInfo = connectivityManager.activeNetworkInfo

    return activeNetworkInfo != null && activeNetworkInfo.isConnected

}