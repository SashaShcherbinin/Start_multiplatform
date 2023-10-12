package base.domain.exeption

/*
 * Signals from server with error code and message what you can show to a user
 */
class ServerApiException(
    val code: Int,
    val userMessage: String,
    systemMessage: String
) : Exception(systemMessage)
