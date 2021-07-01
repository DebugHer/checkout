package com.klasha.klasha_checkout.utils


import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.util.Log
import android.widget.Toast

object Utils {
    fun showToast(message : String, context : Context){
        Toast.makeText(context, message,Toast.LENGTH_LONG).show()
    }

    fun String.logError(activity: String) {
        Log.e("APP ERROR $activity : ",this)
    }

    fun hasNetwork(context: Context): Boolean? {
        var isConnected: Boolean? = false // Initial Value
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork: NetworkInfo? = connectivityManager.activeNetworkInfo
        if (activeNetwork != null && activeNetwork.isConnected)
            isConnected = true
        return isConnected
    }

    /**
     * Checks that a number is valid according to the
     * [Luhn algorithm](https://en.wikipedia.org/wiki/Luhn_algorithm)
     *
     * @param number to be checked
     * @return true if valid
     */
    fun isValidLuhnNumber(number: String): Boolean {
        try { // Verify that string contains only numbers
            val parsed = number.toLong()
        } catch (e: Exception) {
            e.printStackTrace()
            return false
        }
        val reversedNumber = StringBuffer(number).reverse().toString()
        val reversedCharArray = reversedNumber.toCharArray()
        var luhnSum = 0
        // Double the value of every second digit from the right
        run {
            var index = 1
            while (index < number.length) {
                var doubleResult =
                    Character.getNumericValue(reversedCharArray[index]) * 2
                if (doubleResult > 9) { // If result has double digits, sum digits
                    doubleResult = 1 + (doubleResult - 10)
                }
                reversedCharArray[index] = Character.forDigit(doubleResult, 10)
                index += 2
            }
        }
        // Sum all digits
        for (index in 0 until number.length) {
            luhnSum += Character.getNumericValue(reversedCharArray[index])
        }
        // For valiid Luhn number, sum result should be a multiple of 10
        return luhnSum % 10 == 0
    }

    private const val SECOND_MILLIS = 1000
    private const val MINUTE_MILLIS = 60 * SECOND_MILLIS
    private const val HOUR_MILLIS = 60 * MINUTE_MILLIS
    private const val DAY_MILLIS = 24 * HOUR_MILLIS


    fun getTimeAgo(time: Long): String? {
        var time = time
        if (time < 1000000000000L) {
            // if timestamp given in seconds, convert to millis
            time *= 1000
        }
        val now: Long = System.currentTimeMillis()
        if (time > now || time <= 0) {
            return ""
        }
        val diff = now - time
        return if (diff < MINUTE_MILLIS) {
            "just now"
        } else if (diff < 2 * MINUTE_MILLIS) {
            "a minute ago"
        } else if (diff < 50 * MINUTE_MILLIS) {
            "${diff / MINUTE_MILLIS} minutes ago"
        } else if (diff < 90 * MINUTE_MILLIS) {
            "an hour ago"
        } else if (diff < 24 * HOUR_MILLIS) {
            "${diff / HOUR_MILLIS} hours ago"
        } else if (diff < 48 * HOUR_MILLIS) {
            "yesterday"
        } else {
            "${diff / DAY_MILLIS} days ago"
        }
    }
}