package com.klasha.klasha_checkout.data

//package com.klasha.klasha_checkout.data
//
//class PayloadBuilder {
//    var expirymonth: String? = null
//        private set
//    var pbfPubKey: String? = null
//        private set
//    var ip: String? = null
//        private set
//    var lastname: String? = null
//        private set
//    var firstname: String? = null
//        private set
//    var currency = "NGN"
//        private set
//    var country = "NG"
//        private set
//    var amount: String? = null
//        private set
//    var email: String? = null
//        private set
//    var expiryyear: String? = null
//        private set
//    var cvv: String? = null
//        private set
//    var device_fingerprint: String? = null
//        private set
//    var cardno: String? = null
//        private set
//    var payment_plan: String? = null
//        private set
//    var network: String? = null
//        private set
//    var bvn: String? = null
//        private set
//    var voucher: String? = null
//        private set
//    var otp: String? = null
//        private set
//    var isPreAuth = false
//        private set
//    var isIs_us_bank_charge = false
//        private set
//    var isIs_bank_transfer = false
//        private set
//    var isIs_saved_card_charge = false
//        private set
//    var permanent = false
//        private set
//    var frequency = 0
//        private set
//    var duration = 0
//        private set
//
//    fun setIs_mobile_money_gh(is_mobile_money_gh: String?): PayloadBuilder {
//        this.is_mobile_money_gh = is_mobile_money_gh
//        return this
//    }
//
//    fun setIs_mobile_money_ug(is_mobile_money_ug: String?): PayloadBuilder {
//        this.is_mobile_money_ug = is_mobile_money_ug
//        return this
//    }
//
//    private var is_mobile_money_rwf: String? = null
//    fun setIs_bank_transfer(is_bank_transfer: Boolean): PayloadBuilder {
//        isIs_bank_transfer = is_bank_transfer
//        return this
//    }
//
//    var is_mobile_money_gh: String? = null
//        private set
//    var is_mobile_money_ug: String? = null
//        private set
//
//    fun setIs_mobile_money_rwf(is_mobile_money_rwf: String?): PayloadBuilder {
//        this.is_mobile_money_rwf = is_mobile_money_rwf
//        return this
//    }
//
//    var phonenumber: String? = null
//        private set
//    var txRef: String? = null
//        private set
//    var meta = ""
//        private set
//    var subAccounts = ""
//        private set
//
//    fun setCustomer_phone(customer_phone: String?): PayloadBuilder {
//        this.customer_phone = customer_phone
//        return this
//    }
//
//    var customer_phone: String? = null
//        private set
//    var narration: String? = null
//        private set
//    var pin: String? = null
//        private set
//    var accountbank: String? = null
//        private set
//    var accountnumber: String? = null
//        private set
//    var accountname: String? = null
//        private set
//
//    fun setAccountnumber(accountnumber: String?): PayloadBuilder {
//        this.accountnumber = accountnumber
//        return this
//    }
//
//    fun setAccountbank(accountbank: String?): PayloadBuilder {
//        this.accountbank = accountbank
//        return this
//    }
//
//    fun setPin(pin: String?): PayloadBuilder {
//        this.pin = pin
//        return this
//    }
//
//    fun setExpirymonth(expirymonth: String?): PayloadBuilder {
//        this.expirymonth = expirymonth
//        return this
//    }
//
//    fun setVoucher(voucher: String?): PayloadBuilder {
//        this.voucher = voucher
//        return this
//    }
//
//    fun setPBFPubKey(pbfPubKey: String?): PayloadBuilder {
//        this.pbfPubKey = pbfPubKey
//        return this
//    }
//
//    fun setIP(ip: String?): PayloadBuilder {
//        this.ip = ip
//        return this
//    }
//
//    fun setBVN(bvn: String?): PayloadBuilder {
//        this.bvn = bvn
//        return this
//    }
//
//    fun setLastname(lastname: String?): PayloadBuilder {
//        this.lastname = lastname
//        return this
//    }
//
//    fun setFirstname(firstname: String?): PayloadBuilder {
//        this.firstname = firstname
//        return this
//    }
//
//    fun setIsPreAuth(isPreAuth: Boolean): PayloadBuilder {
//        this.isPreAuth = isPreAuth
//        return this
//    }
//
//    fun setIsUsBankCharge(is_us_bank_charge: Boolean): PayloadBuilder {
//        isIs_us_bank_charge = is_us_bank_charge
//        return this
//    }
//
//    fun setCurrency(currency: String): PayloadBuilder {
//        this.currency = currency
//        return this
//    }
//
//    fun setPhonenumber(phonenumber: String?): PayloadBuilder {
//        this.phonenumber = phonenumber
//        return this
//    }
//
//    fun setCountry(country: String): PayloadBuilder {
//        this.country = country
//        return this
//    }
//
//    fun setAmount(amount: String?): PayloadBuilder {
//        this.amount = amount
//        return this
//    }
//
//    fun setEmail(email: String?): PayloadBuilder {
//        this.email = email
//        return this
//    }
//
//    fun setExpiryyear(expiryyear: String?): PayloadBuilder {
//        this.expiryyear = expiryyear
//        return this
//    }
//
//    fun setCvv(cvv: String?): PayloadBuilder {
//        this.cvv = cvv
//        return this
//    }
//
//    fun setPaymentPlan(payment_plan: String?): PayloadBuilder {
//        this.payment_plan = payment_plan
//        return this
//    }
//
//    fun setDevice_fingerprint(device_fingerprint: String?): PayloadBuilder {
//        this.device_fingerprint = device_fingerprint
//        return this
//    }
//
//    fun setCardno(cardno: String?): PayloadBuilder {
//        this.cardno = cardno
//        return this
//    }
//
//    fun setTxRef(txRef: String?): PayloadBuilder {
//        this.txRef = txRef
//        return this
//    }
//
//    fun setAccountname(accountname: String?): PayloadBuilder {
//        this.accountname = accountname
//        return this
//    }
//
//    fun createPayload(): Payload {
//        val metaObj: List<Meta> = Utils.pojofyMetaString(meta)
//        val subaccountsObj: List<SubAccount> =
//            Utils.pojofySubaccountString(subAccounts)
//        val payload = Payload(
//            metaObj, subaccountsObj, narration, expirymonth,
//            pbfPubKey, ip, lastname,
//            firstname, currency, country,
//            amount, email, expiryyear,
//            cvv, device_fingerprint,
//            cardno, txRef
//        )
//        if (payment_plan != null) {
//            payload.setPayment_plan(payment_plan)
//        }
//        if (isPreAuth) {
//            payload.setCharge_type("preauth")
//        }
//        return payload
//    }
//
//    fun setMeta(meta: String): PayloadBuilder {
//        this.meta = meta
//        return this
//    }
//
//    fun setSubAccount(subAccounts: String): PayloadBuilder {
//        this.subAccounts = subAccounts
//        return this
//    }
//
//    fun setNarration(narration: String?): PayloadBuilder {
//        this.narration = narration
//        return this
//    }
//
//    fun setNetwork(network: String?): PayloadBuilder {
//        this.network = network
//        return this
//    }
//
//    fun setOtp(otp: String?): PayloadBuilder {
//        this.otp = otp
//        return this
//    }
//
//    fun setIs_saved_card_charge(is_saved_card_charge: Boolean): PayloadBuilder {
//        isIs_saved_card_charge = is_saved_card_charge
//        return this
//    }
//
//    fun setIsPermanent(permanent: Boolean): PayloadBuilder {
//        this.permanent = permanent
//        return this
//    }
//
//    fun setfrequency(frequency: Int): PayloadBuilder {
//        this.frequency = frequency
//        return this
//    }
//
//    fun setDuration(duration: Int): PayloadBuilder {
//        this.duration = duration
//        return this
//    }
//}