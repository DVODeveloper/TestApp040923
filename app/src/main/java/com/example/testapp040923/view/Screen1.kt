package com.example.testapp040923.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import com.example.testapp040923.R
import com.example.testapp040923.Screen1Model


@OptIn(ExperimentalCoilApi::class)
@Composable
fun Screen1(
    onClick: () -> Unit,
    currentInfoScreen1: MutableState<Screen1Model>
) {

    Column(
        modifier = Modifier
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        Row (
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ){
            Text(
                text = "Отель",
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(bottom = 16.dp)
            )
        }
        Card(
            modifier = Modifier
                .size(343.dp, 257.dp)
                .clip(shape = RoundedCornerShape(12.dp))
        ) {
            Image(
                modifier=Modifier
                    .fillMaxSize(),
                painter = rememberAsyncImagePainter(currentInfoScreen1.value.image_urls1),
                contentDescription = null,
            )
        }


        Box(
            modifier = Modifier
                .clip(shape = RoundedCornerShape(5.dp))
        ) {
            Row(
                modifier = Modifier
                    .padding(top = 16.dp)
                    .background(color = colorResource(R.color.yellow_star))
                    .width(149.dp)
                    .height(29.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start

            ) {
                Image(
                    painterResource(id = R.drawable.icon_star),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(5.dp)
                )
                Text(
                    text = "5 Превосходно",
                    style = TextStyle(color = colorResource(R.color.yellow_star_text))
                )
            }
        }
        Row (
            modifier = Modifier
                .fillMaxWidth()
                ) {
            Text(
                modifier = Modifier
                    .padding(top = 5.dp),
                text = "${currentInfoScreen1.value.name}",
                style = TextStyle(
                    fontSize = 22.sp,
                    fontWeight = FontWeight.SemiBold
                )
            )
        }
        Row (
            modifier = Modifier
                .fillMaxWidth()
        ){
            Text(
                modifier = Modifier
                    .padding(top = 5.dp, bottom = 5.dp),
                text = "${currentInfoScreen1.value.adress}",
                style = TextStyle(
                    fontSize = 14.sp,
                    color = colorResource(id = R.color.blueFigma)
                )
            )
        }

        Row(
            verticalAlignment = Alignment.Bottom,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "от ${currentInfoScreen1.value.minimal_price} ₽",
                fontSize = 30.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(end = 16.dp)
            )
            Text(
                text = "${currentInfoScreen1.value.price_for_it}",
                color = Color.Gray,
                fontSize = 16.sp
            )
        }
        Column(
            modifier = Modifier
        ) {
            Text(
                text = "Об отеле",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(16.dp)
            )
            Row  {
                Text(
                    modifier = Modifier
                        .padding(end = 16.dp, bottom = 16.dp),
                    text = "3-я линия",
                    style = TextStyle(
                        fontSize = 16.sp,
                        color = Color.Gray
                    )
                )
                Text(
                    modifier = Modifier
                        .padding(end = 16.dp, bottom = 16.dp),
                    text = "Платный Wi-Fi в фойе",
                    style = TextStyle(
                        fontSize = 16.sp,
                        color = Color.Gray
                    )
                )
            }
            Row  {
                Text(
                    modifier = Modifier
                        .padding(end = 16.dp, bottom = 16.dp),
                    text = "30 км до аэропорта",
                    style = TextStyle(
                        fontSize = 16.sp,
                        color = Color.Gray
                    )
                )
                Text(
                    modifier = Modifier
                        .padding(end = 16.dp, bottom = 16.dp),
                    text = "1 км до пляжа",
                    style = TextStyle(
                        fontSize = 16.sp,
                        color = Color.Gray
                    )
                )
            }
            Text(
                modifier = Modifier,
                text = "Отель VIP-класса с собственными гольф полями. Высокий уровнь сервиса. " +
                        "Рекомендуем для респектабельного отдыха. Отель принимает гостей от 18 лет!",
                style = TextStyle(
                    fontSize = 16.sp,
                    color = Color.Black
                )
            )
        }
        Column (
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
                ) {
            Row (
                verticalAlignment = Alignment.CenterVertically
                    ) {
                Image(
                    painterResource(id = R.drawable.emojihappy),
                    contentDescription = null
                )
                Column (
                    modifier = Modifier
                        .padding(start = 16.dp, bottom = 16.dp, top = 16.dp)
                        .weight(1f)
                        ){
                    Text(text = "Удобства")
                    Text(text = "Самое необходимое")
                }
                Image(painterResource(id = R.drawable.icons), contentDescription = null)
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Image(painterResource(id = R.drawable.vector_line_56), contentDescription = null )
            }
            Row (
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painterResource(id = R.drawable.ticksquare),
                    contentDescription = null
                )
                Column (
                    modifier = Modifier
                        .padding(start = 16.dp, bottom = 16.dp, top = 16.dp)
                        .weight(1f)
                ){
                    Text(text = "Что включено")
                    Text(text = "Самое необходимое")
                }
                Image(painterResource(id = R.drawable.icons), contentDescription = null)
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Image(painterResource(id = R.drawable.vector_line_56), contentDescription = null )
            }

            Row (
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painterResource(id = R.drawable.closesquare),
                    contentDescription = null
                )
                Column (
                    modifier = Modifier
                        .padding(start = 16.dp, bottom = 16.dp, top = 16.dp)
                        .weight(1f)
                ){
                    Text(text = "Что не включено")
                    Text(text = "Самое необходимое")
                }
                Image(painterResource(id = R.drawable.icons), contentDescription = null)
            }
        }

        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Button(
                onClick = { onClick() },
                modifier = Modifier
                    .size(343.dp,48.dp),
                shape = RoundedCornerShape(15.dp),
                colors = ButtonDefaults.buttonColors(colorResource(id = R.color.blueFigma)),

                ) {
                Text(
                    text = "К выбору номера",
                    color = Color.White
                )
            }
        }
    }
}

