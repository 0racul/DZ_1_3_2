
fun howMuch(paymentType: String = "vk", previousPayments: Int = 0, currentPayment: Int): Int{

    var previousPaymentsCents = 0

    if (previousPayments != 0) {
        previousPaymentsCents = previousPayments * 100
    }

    val currentPaymentCents = currentPayment * 100

    var commission = 0

    when (paymentType) {

        in "maestro", "master" -> {

            commission = (currentPaymentCents / 100 * 0.6 + 20_00).toInt()

            if (currentPaymentCents >= 300_00 && ((currentPaymentCents + previousPaymentsCents) <= 75_000_00)){
                commission = 0

            }
        }

        in "visa", "mir" -> {

            commission = (currentPaymentCents / 100 * 0.75).toInt()

            if (commission < 35_00){
                commission = 35_00
            }
        }

        in "vk" -> {

            commission = 0

            if (currentPaymentCents >= 15_000_00 && currentPaymentCents + previousPaymentsCents >= 40_000_00) {
                commission = -1

            }
        }
    }

    return commission

}


fun main(){

    val payment = 500
    val paymentType = "vk"
    val previousPayments = 1500

    val commission = howMuch(paymentType, previousPayments, payment)

    if (commission < 0){

        println("Operation denied, limit is reached")

    }





}