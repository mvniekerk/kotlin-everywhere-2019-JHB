external val exports: dynamic

class MarcoRequest {
    lateinit var name: String
}

fun main(args: Array<String>) {
    exports.marcoPolo = { request: dynamic, response: dynamic ->
        val input = request.body.unsafeCast<MarcoRequest>()
        response.status(200).send("MarcoPolo ${input.name}")
    }
}
