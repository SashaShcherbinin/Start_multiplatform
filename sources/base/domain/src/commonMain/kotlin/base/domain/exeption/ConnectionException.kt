package base.domain.exeption

/*
 * Signals that can not reach server because of internet connection
 */
class ConnectionException(systemMessage: String? = null, cause: Throwable? = null) :
    Exception(systemMessage, cause)
