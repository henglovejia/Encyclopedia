package study.examples.network.coroutine

/**
 * Status of [Resource]
 */
enum class Status {
    LOADING, SUCCESS, ERROR
}

/**
 * Wrap response from network or wherever
 */
class Resource<out T> private constructor(
    /**
     * Current status
     */
    val status: Status,
    /**
     * Payload
     */
    val data: T? = null,
    /**
     * Exception for [Status.ERROR]
     */
    val error: Throwable? = null) {
    companion object {
        @JvmStatic
        @JvmOverloads
        fun <T> loading(data: T? = null): Resource<T> {
            return Resource(status = Status.LOADING, data = data)
        }

        @JvmStatic
        @JvmOverloads
        fun <T> success(data: T? = null): Resource<T> {
            return Resource(status = Status.SUCCESS, data = data)
        }

        @JvmStatic
        fun <T> error(error: Throwable): Resource<T> {
            return Resource(status = Status.ERROR, error = error)
        }
    }
}