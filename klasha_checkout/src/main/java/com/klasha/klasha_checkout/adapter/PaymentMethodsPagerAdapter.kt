package com.klasha.klasha_checkout.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.klasha.klasha_checkout.fragments.BankFragment
import com.klasha.klasha_checkout.fragments.card.CardFragment
import com.klasha.klasha_checkout.fragments.MPesaFragment

class PaymentMethodsPagerAdapter(fragmentManager: FragmentManager) :
    FragmentStatePagerAdapter(fragmentManager) {

    override fun getItem(position: Int): Fragment {
        var fragment: Fragment =
            CardFragment()
        when (position) {
            0 -> fragment =
                CardFragment();
            1 -> fragment = BankFragment()
            2 -> fragment = MPesaFragment()
        }
        return fragment
    }

    override fun getCount(): Int {
        return 3
    }
}