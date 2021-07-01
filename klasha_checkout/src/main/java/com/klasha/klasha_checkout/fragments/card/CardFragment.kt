package com.klasha.klasha_checkout.fragments.card

import android.app.ProgressDialog
import android.content.res.Resources.NotFoundException
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.klasha.klasha_checkout.R
import com.klasha.klasha_checkout.validators.*
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class CardFragment : Fragment(), View.OnClickListener, View.OnFocusChangeListener {
    private var v: View? = null
    // TODO: Rename and change types of parameters
    var param1: String? = null
    var param2: String? = null
    var cardNoTv: TextInputEditText? = null
    var cardExpiryTil: TextInputLayout? = null
    var cardExpiryTv: TextInputEditText? = null
    var cvvTil: TextInputLayout? = null
    var cvvTv: TextInputEditText? = null
    var emailTil: TextInputLayout? = null
    var cardNoTil: TextInputLayout? = null
    var emailEt: TextInputEditText? = null
    val progessDialog: ProgressDialog? = null
    var amountTil: TextInputLayout? = null
    var amountEt: TextInputEditText? = null
    var payButton: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_card, container, false)
        initializeViews()
        setListeners()
        return v;
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CardFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    private fun initializeViews() {
        cardExpiryTil = v?.findViewById(R.id.klasha_cardExpiryTil)
        cardExpiryTv = v?.findViewById(R.id.klasha_cardExpiryTv)
        payButton = v?.findViewById(R.id.klasha_payButton)
        cardNoTil = v?.findViewById(R.id.klasha_cardNoTil)
        amountTil = v?.findViewById(R.id.klasha_amountTil)
        emailTil = v?.findViewById(R.id.klasha_emailTil)
        cardNoTv = v?.findViewById(R.id.klasha_cardNoTv)
        amountEt = v?.findViewById(R.id.klasha_amountEt)
        emailEt = v?.findViewById(R.id.klasha_emailEt)
        cvvTil = v?.findViewById(R.id.klasha_cvvTil)
        cvvTv = v?.findViewById(R.id.klasha_cvvTv)
    }

    private fun setListeners() {
        cardExpiryTv?.addTextChangedListener(ExpiryWatcher())
        payButton?.setOnClickListener(this)
        cardExpiryTv?.onFocusChangeListener = this
        cardNoTv?.onFocusChangeListener = this
        amountEt?.onFocusChangeListener = this
        emailEt?.onFocusChangeListener = this
        cvvTv?.onFocusChangeListener = this
    }


    private inner class ExpiryWatcher : TextWatcher {

        private val calendar: Calendar
        private val simpleDateFormat: SimpleDateFormat
        private var lastInput = ""
        override fun beforeTextChanged(
            charSequence: CharSequence,
            i: Int,
            i1: Int,
            i2: Int
        ) {
        }

        override fun onTextChanged(
            charSequence: CharSequence,
            i: Int,
            i1: Int,
            i2: Int
        ) {
        }

        override fun afterTextChanged(editable: Editable) {
            val input = editable.toString()
            val cardExpiryToSet: String = cardExpiryTv?.text.toString() + "/"
            try {
                calendar.time = simpleDateFormat.parse(input)
            } catch (e: ParseException) {
                if (editable.length == 2 && !lastInput.endsWith("/")) {
                    val month = input.toInt()
                    if (month <= 12) {
                        cardExpiryTv?.setText(cardExpiryToSet)
                        cardExpiryTv?.setSelection(cardExpiryTv?.text.toString().length)
                    } else {
                        cardExpiryTv?.setText(resources.getString(R.string.defaultCardExpiry))
                        cardExpiryTv?.setSelection(cardExpiryTv?.text.toString().length)
                    }
                } else if (editable.length == 2 && lastInput.endsWith("/")) {
                    try {
                        val month = input.toInt()
                        if (month <= 12) {
                            cardExpiryTv?.setText(cardExpiryTv?.text.toString().substring(0, 1))
                            cardExpiryTv?.setSelection(cardExpiryTv?.text.toString().length)
                        } else {
                            cardExpiryTv?.setText(resources.getString(R.string.defaultCardExpiry))
                            cardExpiryTv?.setSelection(cardExpiryTv?.text.toString().length)
                        }
                    } catch (ex: NumberFormatException) {
                        cardExpiryTv?.setText(input.replace("/", ""))
                        cardExpiryTv?.setSelection(cardExpiryTv?.text.toString().length)
                    } catch (ex: NotFoundException) {
                        ex.printStackTrace()
                    }
                } else if (editable.length == 1) {
                    val month = input.toInt()
                    if (month > 1) {
                        cardExpiryTv?.setText("0" + cardExpiryTv?.text.toString() + "/")
                        cardExpiryTv?.setSelection(cardExpiryTv?.text.toString().length)
                    }
                }
            }
            lastInput = cardExpiryTv?.text.toString()
        }

        init {
            calendar = Calendar.getInstance()
            simpleDateFormat = SimpleDateFormat("MM/yy")
        }
    }

    override fun onClick(view: View?) {
        val i = view?.id
        if (i == R.id.klasha_payButton) {
            clearErrors()
            collectData()
        }
    }

    private fun collectData() {
        val isAmountValid: Boolean = AmountValidator().isAmountValid(amountEt?.text.toString())
        val isEmailValid: Boolean = EmailValidator().isEmailValid(emailEt?.text.toString())
        val isCVVValid: Boolean = CvvValidator().isCvvValid(cvvTv?.text.toString())
        val isCardExpiryValid: Boolean = CardExpiryValidator().isCardExpiryValid(cardExpiryTv?.text.toString())
        val isCardNoValid: Boolean = CardNoValidator().isCardNoStrippedValid(cardNoTv?.text.toString())
        if (!isAmountValid) {
            amountTil?.error = "Kindly enter a valid amount"
        }

        if (!isEmailValid) {
            emailTil?.error = "Kindly enter a valid email"
        }

        if (!isCVVValid) {
            cvvTil?.error = "CVV is incorrect"
        }

        if (!isCardExpiryValid) {
            cardExpiryTil?.error = "Card expiry is incorrect"
        }

        if (!isCardNoValid) {
            cardNoTil?.error = "Card number is incorrect"
        }

        //make request here.

    }

    private fun clearErrors() {
        cardExpiryTil!!.isErrorEnabled = false
        cardNoTil!!.isErrorEnabled = false
        amountTil!!.isErrorEnabled = false
        emailTil!!.isErrorEnabled = false
        cvvTil!!.isErrorEnabled = false
        cardExpiryTil!!.error = null
        amountTil!!.error = null
        emailTil!!.error = null
        cardNoTil!!.error = null
        cvvTil!!.error = null
    }

    override fun onFocusChange(view: View, hasFocus: Boolean) {
        val i = view.id
        var fieldName = ""
        when (i) {
            R.id.klasha_cvvTv -> {
                fieldName = "CVV"
            }
            R.id.klasha_amountEt -> {
                fieldName = "Amount"
            }
            R.id.klasha_emailEt -> {
                fieldName = "Email"
            }
            R.id.klasha_cardNoTv -> {
                fieldName = "Card Number"
            }
            R.id.klasha_cardExpiryTv -> {
                fieldName = "Card Expiry"
            }
        }
        if (hasFocus) {

        }
    }
}