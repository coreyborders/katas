/**
 * I generally don't make my own exceptions, and just throw a standard or prebuilt message.
 * I think the point of custom exceptions is 1) you want to pass more / different info the the guy who catches the method
 * or 2) you want to handle exceptions differently depending on their type
 * In this case (and in most cases these days), you probably don't care about the typing / handling of these errors,
 * so I would just use the base class.
 *
 * That said, having different types like this can simply be a nice readability add.
 */
class TooEarlyException(message: String) : Exception(message)

class TooLateException(message: String) : Exception(message)

class InvalidTimeException(message: String) : Exception(message)
