package com.sathish.juspaysafe.code.example

object Constants {
    val URL = "https://www.billdesk.com/pgidsk/wap/vodafonetup/vodafonechordiantconfirm.jsp"
    val POST_DATA = "Pre_bonuscards1\$hdnAccessfee=1.00&" +
            "Pre_bonuscards1\$hdnBenefit=Talktime of Rs.7.9&" +
            "Pre_bonuscards1\$hdnChannelId=RECHARGE&" +
            "Pre_bonuscards1\$hdnCircleId=&" +
            "Pre_bonuscards1\$hdnMRP=10.00&" +
            "Pre_bonuscards1\$hdnMobileNumber=9585532274&" +
            "Pre_bonuscards1\$hdnServiceTax=12.36&" +
            "Pre_bonuscards1\$hdnTalktime=7.90&" +
            "Pre_bonuscards1\$hdnaction=confirm_etopup&" +
            "Pre_bonuscards1\$hdnairtime=0.00&" +
            "Pre_bonuscards1\$hdnmsg=9585532274|10.00|0.00|1.00|12.36|Talktime of Rs.7.9|kar|RECHARGE|7.90|20140505170308|2144186221&" +
            "Pre_bonuscards1\$txtDenom=10&" +
            "Pre_bonuscards1\$txtmobileNo=9585532274&" +
            "__EVENTARGUMENT=&" +
            "__EVENTTARGET=&" +
            "__EVENTVALIDATION=/wEWCwLtyvX4DgLB39rQDgLIkufkCALl1YjvDALGn/GnAwKc6s+nCALI1fSCCQLI1bjxDgLI1czMBwLJgK/wCgKuwITEBoKlRHFTXgI5XV82o1qSAOneVyq1"

    val MERCHANT_ID = "godel_integ_demo"
    val CLIENT_ID = "godel_integ_demo_fl"
    val DISPLAY_NOTE = "This text would be shown on top"
    val REMARKS = "This text would be filled on bank page"
    val AMOUNT = 10
    val CUSTOMER_PHONE_NUMBER = "9585532274"

    val transactionId: String
        get() {
            val random = Math.random() * 100000
            return random.toString()
        }
}
