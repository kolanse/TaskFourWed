package com.example.taskthree

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Switch
import androidx.appcompat.app.AppCompatDelegate

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        /**
         * save the settings of the dark mode by using shared preferences
         */
        val appSettingsPref: SharedPreferences = getSharedPreferences("appSettings", 0)
        val isNightMode: Boolean = appSettingsPref.getBoolean("NightMode", false)
        val sharedPrefEdit: SharedPreferences.Editor = appSettingsPref.edit()


        /**
         * check whether isNightMode is true. if it is enable dark mode else disable it
         */
        if (isNightMode){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        } else{
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }


        /**
         * When the button is clicked if night mode is true disable it and put the value in our shared preferences
         */

        val sw1 = findViewById<Switch>(R.id.switch1)


        // if nightmode is saved, make the checkbox checked
        sw1.isChecked = isNightMode
        sw1.setOnCheckedChangeListener{ _, isChecked ->

            if (!isChecked){
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                sharedPrefEdit.putBoolean("NightMode", false).apply()
            } else{
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                sharedPrefEdit.putBoolean("NightMode", true).apply()
            }

        }





    }
}