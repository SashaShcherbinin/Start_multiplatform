package base.domain.exeption

/*
 * Signals that server is broken, for example 500 error code
 */
class ServerException(systemMessage: String) : Exception(systemMessage)
