package com.example.testapp040923

import Screen3
import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.testapp040923.ui.theme.TestApp040923Theme
import com.example.testapp040923.view.Screen1
import com.example.testapp040923.view.Screen2
import com.example.testapp040923.view.Screen2Model
import com.example.testapp040923.view.Screen4
import org.json.JSONObject
import java.util.ArrayList

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var titleValue by remember {
                mutableStateOf("")
            }
            var showTopAppBar by remember {
                mutableStateOf(true)
            }

            
            val navHostController = rememberNavController()


            TestApp040923Theme {

                val screen1List = remember {
                    mutableStateOf(listOf<Screen1Model>())
                }

                val currentInfoScreen1 = remember {
                    mutableStateOf(Screen1Model(
                        "",
                        "",
                        0,
                        "",
                        0,
                        "",
                        "",
                        "",
                        ""

                    ))
                }


                getData(this,screen1List, currentInfoScreen1)


//                val screen2List = remember {
//                    mutableStateOf(listOf<Screen2Model>())
//                }
//                val currentInfoScreen2 = remember {
//                    mutableStateOf(Screen2Model(
//                        "",
//                        0,
//                        "",
//                        "",
//                        ""
//                    ))
//                }
//                getData2(this,screen2List,currentInfoScreen2)

                Scaffold(
                    modifier = Modifier.background(Color.White),

                    topBar = {
                        if (showTopAppBar) {
                            TopAppBar(
                                title = {
                                    Box(
                                        contentAlignment = Alignment.Center,
                                        modifier = Modifier.fillMaxWidth()
                                    ) {
                                        Text(
                                            text = titleValue,
                                            textAlign = TextAlign.Center
                                        )
                                    }

                                },
                                navigationIcon = {
                                    IconButton(onClick = { navHostController.popBackStack() }) {
                                        Icon(
                                            painterResource(id = R.drawable.arrowback),
                                            contentDescription = null
                                        )
                                    }
                                },
                                actions = {
                                    Spacer(modifier = Modifier.size(55.dp))
                                }
                            )
                        } else {
                            null
                        }
                    }
                ) {




                    NavHost(
                        navController = navHostController,
                        startDestination = "screen_1"
                    ) {
                        composable("screen_1") {
                            Screen1(
                                onClick = { navHostController.navigate("screen_2") },
                                currentInfoScreen1 = currentInfoScreen1
                            )
                            showTopAppBar = false
                        }
                        composable("screen_2") {
                            Screen2 (
                                onClick = { navHostController.navigate("screen_3") }
                               // currentInfoScreen2 = currentInfoScreen2
                            )
                            showTopAppBar = true
                            titleValue = "Steigenberger Makadi"

                        }
                        composable("screen_3") {
                            Screen3 {
                                navHostController.navigate("screen_4")
                            }
                            showTopAppBar = true
                            titleValue = "Бронирование"

                        }
                        composable("screen_4") {
                            Screen4 {
                                navHostController.navigate("screen_1") {
                                    popUpTo("screen_1") {
                                        inclusive = true
                                    }
                                }
                            }
                            showTopAppBar = true
                            titleValue = "Заказ оплачен"
                        }

                    }
                }

            }
        }
    }
}


//Получение данных для второго экрана

private fun getData2(
    context: Context,
    screen2List: MutableState<List<Screen2Model>>,
    currentInfoScreen2: MutableState<Screen2Model>
) {
    val url = "https://run.mocky.io/v3/f9a38183-6f95-43aa-853a-9c83cbb05ecd"

    val queue = Volley.newRequestQueue(context)
    val sRequest = StringRequest(
        Request.Method.GET,
        url,
        {
                response ->
            val list = getDataScreen2(response)
            currentInfoScreen2.value = list[0]
            screen2List.value = list
        },
        {
            Log.d("MyLog","VolleyError: $it")
        }
    )
    queue.add(sRequest)
}

private fun getDataScreen2(response: String): List<Screen2Model>{
    if (response.isEmpty()) return listOf()

    val list = ArrayList<Screen2Model>()

    val mainObject = JSONObject(response)
    val name = mainObject.getString("name")

    list.add(
        Screen2Model(
         //   mainObject.getInt("id"),
            name,
            mainObject.getInt("price"),
            mainObject.getString("price_per"),
            mainObject.getJSONArray("peculiarities").getString(0),
            mainObject.getJSONArray("image_urls").getString(0)
        )
    )
    return list
}

//Получение данных для первого экрана
private fun getData(
    context: Context,
    screen1List: MutableState<List<Screen1Model>>,
    currentInfoScreen1: MutableState<Screen1Model>
) {
    val url = "https://run.mocky.io/v3/35e0d18e-2521-4f1b-a575-f0fe366f66e3"

    val queue = Volley.newRequestQueue(context)
    val sRequest = StringRequest(
        Request.Method.GET,
        url,
        {
            response ->
            val list = getDataScreen1(response)
            currentInfoScreen1.value = list[0]
           screen1List.value = list
        },
        {
            Log.d("MyLog","VolleyError: $it")
        }
    )
    queue.add(sRequest)
}

private fun getDataScreen1(response: String): List<Screen1Model>{
    if (response.isEmpty()) return listOf()

    val list = ArrayList<Screen1Model>()

    val mainObject = JSONObject(response)
    val name = mainObject.getString("name")

    list.add(
        Screen1Model(
            name,
            mainObject.getString("adress"),
            mainObject.getInt("minimal_price"),
            mainObject.getString("price_for_it"),
            mainObject.getInt("rating"),
            mainObject.getString("rating_name"),
            mainObject.getJSONArray("image_urls").getString(0),
            mainObject.getJSONArray("image_urls").getString(1),
            mainObject.getJSONArray("image_urls").getString(2)
        )
    )
    return list
}

