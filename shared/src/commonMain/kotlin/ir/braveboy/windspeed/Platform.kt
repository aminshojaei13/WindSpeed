package ir.braveboy.windspeed

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform