package org.d3if3094.assessment01_6706213094_citrawanodyaprameswari

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import androidx.navigation.NavController

class MainActivity : AppCompatActivity() {

    companion object {
        const val CHANNEL_ID = "updater"
        const val PERMISSION_REQUEST_CODE = 1

    }

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        val name = getString(R.string.channel_name)
        val importance = NotificationManager.IMPORTANCE_DEFAULT
        val channel = NotificationChannel(CHANNEL_ID, name, importance)
        channel.description = getString(R.string.channel_desc)
        val manager = getSystemService(Context.NOTIFICATION_SERVICE)
                as NotificationManager?
        manager?.createNotificationChannel(channel)
    }
}
override fun onSupportNavigateUp(): Boolean {
    return navController.navigateUp()
}
}

