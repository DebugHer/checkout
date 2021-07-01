import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnFocusChangeListener
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.klasha.klasha_checkout.R

/**
 * A simple [Fragment] subclass.
 */
class OTPFragment : Fragment(),
    View.OnClickListener {
    private var isSavedCardCharge = false
    var otpEt: TextInputEditText? = null
    var otpTil: TextInputLayout? = null
    var chargeMessage: TextView? = null
    var otpButton: Button? = null
    var v: View? = null
    var otp: String? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_o_t_p, container, false)

        initializeViews()
        setChargeMessage()
        setIsSavedCardCharge()
        setListeners()
        return v
    }

    private fun setIsSavedCardCharge() {
        if (arguments != null) {
            if (requireArguments().containsKey(IS_SAVED_CARD_CHARGE)) {
                isSavedCardCharge =
                    requireArguments().getBoolean(IS_SAVED_CARD_CHARGE)
            }
        }
    }

    private fun setListeners() {
        otpButton!!.setOnClickListener(this)
        otpEt!!.onFocusChangeListener = OnFocusChangeListener { view, hasFocus ->
            if (hasFocus) {

            }
        }
    }

    private fun initializeViews() {
        otpTil = v!!.findViewById(R.id.otpTil)
        otpEt = v!!.findViewById(R.id.otpEv)
        otpButton = v!!.findViewById(R.id.otpButton)
        chargeMessage = v!!.findViewById(R.id.otpChargeMessage)
    }

    override fun onClick(view: View) {
        val i = view.id
        if (i == R.id.otpButton) {
            clearErrors()
            otp = otpEt!!.text.toString()
            if (otp!!.length < 1) {
                otpTil!!.error = "Enter a valid one time password"
            } else {
                goBack()
            }
        }
    }

    private fun clearErrors() {
        otpTil!!.isErrorEnabled = false
        otpTil!!.error = null
    }

    private fun setChargeMessage() {
        if (arguments != null) {
            if (requireArguments().containsKey(EXTRA_CHARGE_MESSAGE)) {
                chargeMessage!!.text = requireArguments().getString(EXTRA_CHARGE_MESSAGE)
            }
        }
    }

    fun goBack() {
        val intent = Intent()
        intent.putExtra(EXTRA_OTP, otp)
        //inform onActivityResult of if this is a saved card charge and how to handle.
        intent.putExtra(IS_SAVED_CARD_CHARGE, isSavedCardCharge)
        if (activity != null) {
           // requireActivity().setResult(RESULT_SUCCESS, intent)
           // requireActivity().finish()
        }
    }

    companion object {
        const val EXTRA_OTP = "extraOTP"
        const val IS_SAVED_CARD_CHARGE = "is_saved_card_charge"
        const val EXTRA_CHARGE_MESSAGE = "extraChargeMessage"
    }
}