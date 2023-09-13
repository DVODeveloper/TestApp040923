package com.example.testapp040923.navigation

sealed class ScreensRoute (
    val route: String
) {
    object Screen1: ScreensRoute(ROUTE_SCREEN1)
    object Screen2: ScreensRoute(ROUTE_SCREEN2)
    object Screen3: ScreensRoute(ROUTE_SCREEN3)
    object Screen4: ScreensRoute(ROUTE_SCREEN4)

    private companion object {
        const val ROUTE_SCREEN1 = "SCREEN1"
        const val ROUTE_SCREEN2 = "SCREEN2"
        const val ROUTE_SCREEN3 = "SCREEN3"
        const val ROUTE_SCREEN4 = "SCREEN4"
    }
}