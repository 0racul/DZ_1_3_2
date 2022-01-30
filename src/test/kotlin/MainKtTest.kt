import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun howMuch_vk_zero_commission() {

        val payment = 500
        val paymentType = "vk"
        val previousPayments = 1500

        val expectedCommission = 0

        val commission = howMuch(paymentType, previousPayments, payment)

        assertEquals(expectedCommission, commission)

    }

    @Test
    fun howMuch_vk_denied_limit_month() {


        //sdf
        val payment = 500
        val paymentType = "vk"
        val previousPayments = 1500000

        val expectedCommission = -1

        val commission = howMuch(paymentType, previousPayments, payment)

        assertEquals(expectedCommission, commission)

    }

    @Test
    fun howMuch_vk_denied_limit_payment() {

        val payment = 1500000
        val paymentType = "vk"
        val previousPayments = 0

        val expectedCommission = -1

        val commission = howMuch(paymentType, previousPayments, payment)

        assertEquals(expectedCommission, commission)

    }

    @Test
    fun howMuch_maestro_zero_commission() {

        val payment = 301
        val paymentType = "maestro"
        val previousPayments = 74_698

        val expectedCommission = 0

        val commission = howMuch(paymentType, previousPayments, payment)

        assertEquals(expectedCommission, commission)

    }

    @Test
    fun howMuch_maestro_normal_commission() {

        val payment = 200
        val paymentType = "maestro"
        val previousPayments = 75_000

        val expectedCommission = 2120

        val commission = howMuch(paymentType, previousPayments, payment)

        assertEquals(expectedCommission, commission)

    }

    @Test
    fun howMuch_visa_minimal_commission() {

        val payment = 3000
        val paymentType = "visa"
        val previousPayments = 0

        val expectedCommission = 35_00

        val commission = howMuch(paymentType, previousPayments, payment)

        assertEquals(expectedCommission, commission)

    }

    @Test
    fun howMuch_visa_normal_commission() {

        val payment = 10000
        val paymentType = "visa"
        val previousPayments = 0

        val expectedCommission = 75_00

        val commission = howMuch(paymentType, previousPayments, payment)

        assertEquals(expectedCommission, commission)

    }

    @Test
    fun howMuch_mir_minimal_commission() {

        val payment = 3000
        val paymentType = "mir"
        val previousPayments = 0

        val expectedCommission = 35_00

        val commission = howMuch(paymentType, previousPayments, payment)

        assertEquals(expectedCommission, commission)

    }

    @Test
    fun howMuch_mir_normal_commission() {

        val payment = 10000
        val paymentType = "mir"
        val previousPayments = 0

        val expectedCommission = 75_00

        val commission = howMuch(paymentType, previousPayments, payment)

        assertEquals(expectedCommission, commission)

    }

}