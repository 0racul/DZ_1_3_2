
fun howMuch(paymentType: String = "vk", previousPayments: Int = 0, currentPayment: Int): Int{

    var previousPaymentsCents = 0

    if (previousPayments != 0) {
        previousPaymentsCents = previousPayments * 100
    }

    val currentPaymentCents = currentPayment * 100


    var commission = 0

    when (paymentType) {

        in "vk", "master", "maestro" -> {

            commission = 0

            if (paymentType == "master" && paymentType == "maestro") {

                if (currentPaymentCents >= 300__00) {
                    commission = 0
                }

                if ((currentPaymentCents + previousPaymentsCents) >= 75_000_00) {
                    commission = 0

                }
            }
            else if (paymentType == "vk" || currentPaymentCents >= 15_000_00) {
                commission = -1
            }
        }

        in "visa", "mir" -> {

            commission = (currentPaymentCents / 100 * 0.75).toInt()

            if (commission <= 3500) {
                commission = 3500

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