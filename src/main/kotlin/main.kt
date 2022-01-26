
fun howMuch(paymentType: String = "vk", previousPayments: Int = 0, currentPayment: Int): Int{

    var previousPaymentsCents = 0

    if (previousPayments != 0) {

        previousPaymentsCents = previousPayments * 100
    }

    val currentPaymentCents = currentPayment * 100


    var commision = 0

    when (paymentType) {

        in "vk", "master", "maestro" -> {

            commision = 0

            if (paymentType == "master" && paymentType == "maestro") {

                if (currentPaymentCents >= 300__00) {

                    commision = 0
                }

                if ((currentPaymentCents + previousPaymentsCents) >= 75_000_00) {

                    commision = 0

                }
            }
        }

        in "visa", "mir" -> {

            commision = (currentPaymentCents / 100 * 0.75).toInt()

            if (commision <= 3500) {

                commision = 3500

            }
        }
    }

    if (paymentType == "vk" || currentPaymentCents >= 15_000_00){

        commision = -1

    }

    return commision

}


fun main(){

    val payment = 500
    val paymentType = "vk"
    val previousPayments = 1500

    val commision = howMuch(paymentType, previousPayments, payment)

    if (commision < 0){

        println("Operation denied, limit is reached")

    }





}