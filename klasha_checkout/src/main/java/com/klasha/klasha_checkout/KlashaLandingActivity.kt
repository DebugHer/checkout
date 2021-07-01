package com.klasha.klasha_checkout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import com.klasha.klasha_checkout.adapter.PaymentMethodsPagerAdapter
import kotlinx.android.synthetic.main.activity_klasha_landing.*


class KlashaLandingActivity : AppCompatActivity() {
    private lateinit var pagerAdapter: PaymentMethodsPagerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_klasha_landing)
        pagerAdapter = PaymentMethodsPagerAdapter(supportFragmentManager)
        pager.adapter = pagerAdapter
        card_btn.performClick()
        card_btn.setOnClickListener {
            pager.currentItem = 0
        }
        bank_btn.setOnClickListener {
            pager.currentItem = 1
        }
        mpesa_btn.setOnClickListener {
            pager.currentItem = 2
        }

        pager.addOnPageChangeListener(object : OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                when (position) {
                    0 -> card_btn.performClick()
                    1 -> bank_btn.performClick()
                    2 -> mpesa_btn.performClick()
                }
            }

            override fun onPageScrollStateChanged(state: Int) {}
        })

    }
}