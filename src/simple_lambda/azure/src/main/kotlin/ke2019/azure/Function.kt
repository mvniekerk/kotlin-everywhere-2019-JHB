package ke2019.azure

import java.util.*
import com.microsoft.azure.functions.*
import com.microsoft.azure.functions.annotation.*

class MarcoRequest {
    lateinit var name: String
}

data class PoloResponse(val name: String)

class Function {

    @FunctionName("MarcoPolo")
    fun run(
            @HttpTrigger(
                    name = "req",
                    methods = [HttpMethod.POST],
                    authLevel = AuthorizationLevel.ANONYMOUS
            ) request: HttpRequestMessage<Optional<MarcoRequest>>,
            context: ExecutionContext): HttpResponseMessage {

        request.body?.let {
            return request
                    .createResponseBuilder(HttpStatus.OK)
                    .body(PoloResponse(name = "MarcoPolo2 ${it.get().name}"))
                    .build()
        }

        return request
                .createResponseBuilder(HttpStatus.BAD_REQUEST)
                .body("Please pass a name on the query string or in the request body")
                .build()
    }
}
