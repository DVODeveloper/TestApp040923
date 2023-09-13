//package com.example.testapp040923.navigation
//
//import androidx.compose.runtime.Composable
//import androidx.navigation.NavHostController
//import androidx.navigation.compose.NavHost
//import androidx.navigation.compose.composable
//
//@Composable
//fun AppNavGraph(
//    navHostController: NavHostController,
//    screen1Content: @Composable () -> Unit,
//    screen2Content: @Composable () -> Unit,
//    screen3Content: @Composable () -> Unit,
//    screen4Content: @Composable () -> Unit
//){
//    NavHost(
//        navController = navHostController,
//        startDestination = ScreensRoute.Screen1.route
//    ) {
//        composable(ScreensRoute.Screen1.route) {
//            screen1Content()
//        }
//        composable(ScreensRoute.Screen2.route) {
//            screen2Content()
//        }
//        composable(ScreensRoute.Screen3.route) {
//            screen3Content()
//        }
//        composable(ScreensRoute.Screen4.route) {
//            screen4Content()
//        }
//    }
//}