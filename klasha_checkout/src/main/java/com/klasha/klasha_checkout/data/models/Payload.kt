//package com.klasha.klasha_checkout.data.models
//
//import java.util.*
//
//class Payload {
//    var is_permanent: Boolean? = null
//    var duration: Int? = null
//    var frequency: Int? = null
//    var is_ussd = false
//    var orderRef: String? = null
//    var is_barter: String? = null
//    var card_hash: String? = null
//
//    var cardBIN: String? = null
//    var isIs_us_bank_charge = false
//        private set
//    private var is_saved_card_charge = false
//    var is_uk_bank_charge = false
//        private set
//    var remember_device_mobile_key: String? = null
//    var device_key: String? = null
//    var otp: String? = null
//
//    // Constructor for saved card charge
//    constructor(
//        meta: MutableList<Meta?>?,
//        subaccounts: List<SubAccount>,
//        narration: String,
//        PBFPubKey: String,
//        IP: String,
//        lastname: String,
//        firstname: String,
//        currency: String,
//        country: String,
//        amount: String,
//        email: String,
//        device_fingerprint: String,
//        txRef: String,
//        is_saved_card_charge: Boolean,
//        phonenumber: String?
//    ) {
//        var meta: MutableList<Meta?>? = meta
//        this.narration = narration
//        pBFPubKey = PBFPubKey
//        iP = IP
//        this.subaccounts = subaccounts
//        this.lastname = lastname
//        this.firstname = firstname
//        this.currency = currency
//        this.country = country
//        this.amount = amount
//        this.email = email
//        this.device_fingerprint = device_fingerprint
//        this.txRef = txRef
//        this.is_saved_card_charge = is_saved_card_charge
//        this.phonenumber = phonenumber
//        if (meta == null) {
//            meta = ArrayList<Meta?>()
//        }
//        meta.add(Meta("sdk", "android"))
//        this.meta = meta
//    }
//
//    var remember_device_email: String? = null
//    var charge_type: String? = null
//
//    var bVN: String? = null
//
//    var is_remembered: String? = null
//    var payment_plan: String? = null
//
//    var is_mpesa: String? = null
//    var is_mpesa_lipa: String? = null
//
//    constructor(
//        meta: MutableList<Meta?>?,
//        subaccounts: List<SubAccount>,
//        narration: String,
//        expirymonth: String?,
//        PBFPubKey: String,
//        IP: String,
//        lastname: String,
//        firstname: String,
//        currency: String,
//        country: String,
//        amount: String,
//        email: String,
//        expiryyear: String?,
//        cvv: String?,
//        device_fingerprint: String,
//        cardno: String?,
//        txRef: String
//    ) {
//        var meta: MutableList<Meta?>? = meta
//        this.narration = narration
//        this.expirymonth = expirymonth
//        pBFPubKey = PBFPubKey
//        iP = IP
//        this.subaccounts = subaccounts
//        this.lastname = lastname
//        this.firstname = firstname
//        this.currency = currency
//        this.country = country
//        this.amount = amount
//        this.email = email
//        this.expiryyear = expiryyear
//        this.cvv = cvv
//        this.device_fingerprint = device_fingerprint
//        this.cardno = cardno
//        this.txRef = txRef
//        if (meta == null) {
//            meta = ArrayList<Meta?>()
//        }
//        meta.add(Meta("sdk", "android"))
//        this.meta = meta
//    }
//
//    var billingcity: String? = null
//    var billingaddress: String? = null
//    var billingstate: String? = null
//    var billingcountry: String? = null
//
//    constructor(
//        meta: MutableList<Meta?>?,
//        subaccounts: List<SubAccount>,
//        narration: String,
//        IP: String,
//        accountnumber: String?,
//        accountbank: String?,
//        lastname: String,
//        firstname: String,
//        currency: String,
//        country: String,
//        amount: String,
//        email: String,
//        device_fingerprint: String,
//        txRef: String,
//        PBFPubKey: String,
//        billingaddress: String?,
//        billingcity: String?,
//        billingstate: String?,
//        billingzip: String?,
//        billingcountry: String?
//    ) {
//        var meta: MutableList<Meta?>? = meta
//        this.narration = narration
//        iP = IP
//        this.accountnumber = accountnumber
//        this.accountbank = accountbank
//        this.lastname = lastname
//        this.firstname = firstname
//        this.currency = currency
//        this.country = country
//        this.amount = amount
//        this.email = email
//        this.device_fingerprint = device_fingerprint
//        this.txRef = txRef
//        pBFPubKey = PBFPubKey
//        this.billingaddress = billingaddress
//        this.billingstate = billingstate
//        this.billingcity = billingcity
//        this.billingcountry = billingcountry
//        this.billingzip = billingzip
//        this.subaccounts = subaccounts
//        if (meta == null) {
//            meta = ArrayList<Meta?>()
//        }
//        meta.add(Meta("sdk", "android"))
//        this.meta = meta
//    }
//
//    constructor(
//        phonenumber: String?,
//        meta: MutableList<Meta?>?,
//        subaccounts: List<SubAccount>,
//        narration: String,
//        IP: String,
//        lastname: String,
//        firstname: String,
//        currency: String,
//        country: String,
//        amount: String,
//        email: String,
//        device_fingerprint: String,
//        txRef: String,
//        PBFPubKey: String
//    ) {
//        var meta: MutableList<Meta?>? = meta
//        this.meta = meta
//        this.subaccounts = subaccounts
//        this.narration = narration
//        iP = IP
//        this.phonenumber = phonenumber
//        this.lastname = lastname
//        this.firstname = firstname
//        this.currency = currency
//        this.country = country
//        this.amount = amount
//        this.email = email
//        this.device_fingerprint = device_fingerprint
//        this.txRef = txRef
//        pBFPubKey = PBFPubKey
//        if (meta == null) {
//            meta = ArrayList<Meta?>()
//        }
//        meta.add(Meta("sdk", "android"))
//        this.meta = meta
//    }
//
//    constructor(
//        meta: MutableList<Meta?>?,
//        subaccounts: List<SubAccount>,
//        narration: String,
//        IP: String,
//        accountnumber: String?,
//        accountbank: String?,
//        lastname: String,
//        firstname: String,
//        currency: String,
//        country: String,
//        amount: String,
//        email: String,
//        device_fingerprint: String,
//        txRef: String,
//        PBFPubKey: String,
//        bvn: String?,
//        is_us_bank_charge: Boolean
//    ) {
//        var meta: MutableList<Meta?>? = meta
//        this.meta = meta
//        this.subaccounts = subaccounts
//        this.narration = narration
//        iP = IP
//        this.accountnumber = accountnumber
//        this.accountbank = accountbank
//        this.lastname = lastname
//        this.firstname = firstname
//        this.currency = currency
//        this.country = country
//        this.amount = amount
//        this.email = email
//        this.device_fingerprint = device_fingerprint
//        this.txRef = txRef
//        pBFPubKey = PBFPubKey
//        bVN = bvn
//        isIs_us_bank_charge = is_us_bank_charge
//        if (meta == null) {
//            meta = ArrayList<Meta?>()
//        }
//        meta.add(Meta("sdk", "android"))
//        this.meta = meta
//    }
//
//    var passcode: String? = null
//
//    var token: String? = null
//
//    fun getMeta(): List<Meta?>? {
//        return meta
//    }
//
//    fun setMeta(meta: List<Meta?>?) {
//        this.meta = meta
//    }
//
//    fun setPin(pin: String?) {
//        this.pin = pin
//    }
//
//    private var pin: String? = null
//    private val redirect_url: String = RaveConstants.RAVE_3DS_CALLBACK
//
//    fun setSECKEY(SECKEY: String?) {
//        this.SECKEY = SECKEY
//    }
//
//    var SECKEY: String? = null
//    var pBFSecKey: String? = null
//    @SerializedName("suggested_auth")
//    private var suggestedAuth: String? = null
//    private var meta: List<Meta?>?
//    private var subaccounts: List<SubAccount>
//
//    var billingzip: String? = null
//
//    var is_mobile_money_franco = false
//    var payment_type: String? = null
//
//    private var is_sa_call_pay: String? = null
//        set
//
//    var phonenumber: String? = null
//    var narration: String
//
//    fun setIs_internet_banking(is_internet_banking: String?) {
//        this.is_internet_banking = is_internet_banking
//    }
//
//    private var is_internet_banking: String? = null
//    var expirymonth: String? = null
//    var pBFPubKey: String
//    var iP: String
//    var accountnumber: String? = null
//    var accountname: String? = null
//
//    var accountbank: String? = null
//    var lastname: String
//    var firstname: String
//    var currency: String
//    var country: String
//    var amount: String
//    var email: String
//    var expiryyear: String? = null
//    var cvv: String? = null
//    var device_fingerprint: String
//    var cardno: String? = null
//    var txRef: String
//
//    fun setSuggestedAuth(suggestedAuth: String?) {
//        this.suggestedAuth = suggestedAuth
//    }
//
//    override fun toString(): String {
//        return "ClassPojo [expirymonth = " + expirymonth + ", PBFPubKey = " + pBFPubKey + ", IP = " + iP + ", lastname = " + lastname + ", firstname = " + firstname + ", currency = " + currency + ", country = " + country + ", amount = " + amount + ", email = " + email + ", expiryyear = " + expiryyear + ", cvv = " + cvv + ", device_fingerprint = " + device_fingerprint + ", cardno = " + cardno + ", txRef = " + txRef + "]"
//    }
//
//    var is_mobile_money_gh: String? = null
//    var is_mobile_money_ug: String? = null
//    fun setNetwork(network: String?) {
//        this.network = network
//    }
//
//    var network: String? = null
//    var voucher: String? = null
//    fun setVoucher(voucher: String?) {
//        this.voucher = voucher
//    }
//
//    fun setIs_mobile_money_gh(is_mobile_money_gh: String?) {
//        this.is_mobile_money_gh = is_mobile_money_gh
//    }
//
//    fun setIs_mobile_money_ug(is_mobile_money_ug: String?) {
//        this.is_mobile_money_ug = is_mobile_money_ug
//    }
//
//    fun setIs_us_bank_charge(is_us_bank_charge: Boolean) {
//        isIs_us_bank_charge = is_us_bank_charge
//    }
//
//    var is_bank_transfer = false
//
//    fun setIs_bank_transfer(is_bank_transfer: Boolean) {
//        this.is_bank_transfer = is_bank_transfer
//    }
//
//    fun setIs_uk_bank_charge2(is_uk_bank_charge2: Boolean) {
//        is_uk_bank_charge = is_uk_bank_charge2
//    }
//}