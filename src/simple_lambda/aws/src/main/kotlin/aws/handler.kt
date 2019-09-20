package aws

import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.RequestHandler

class MarcoRequest {
    lateinit var name: String
}

data class PoloResponse(val name: String)

class MarcoPoloHandler : RequestHandler<MarcoRequest, PoloResponse> {
    override fun handleRequest(input: MarcoRequest?, context: Context?): PoloResponse =
        PoloResponse(
                name = "MarcoPolo ${input?.name}"
        )
}
