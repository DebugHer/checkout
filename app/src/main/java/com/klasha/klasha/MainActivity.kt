package com.klasha.klasha

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.klasha.klasha_checkout.KlashaLandingActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startActivity(Intent(this, KlashaLandingActivity::class.java))
    }
}
