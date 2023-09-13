package com.example.testapp040923.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testapp040923.R

@Composable
fun Screen4(
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row (
                    modifier = Modifier
                        .padding(16.dp)
                        .size(94.dp, 94.dp)
                        .clip(shape = RoundedCornerShape(90))
                        .background(colorResource(id = R.color.GrayFigma)),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                        ){
                    Image(
                        painterResource(id = R.drawable.party_popper),
                        contentDescription = null,
                        modifier = Modifier
                            .size(44.dp,44.dp)
                    )
                }

                Text(
                    modifier = Modifier
                        .padding(16.dp),
                    text = "Ваш заказ принят в работу",
                    style = TextStyle(
                        fontSize = 22.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        modifier = Modifier
                            .padding(16.dp),
                        text = "Подтверждение заказа №104893 может занять некоторое время " +
                                "(от 1 часа до суток). Как только мы получим ответ от туроператора," +
                                " вам на почту придет уведомление.",
                        style = TextStyle(
                            fontSize = 16.sp,
                            color = Color.Gray
                        ),
                        textAlign = TextAlign.Center
                    )
                }

            }
            Box(
                modifier = Modifier
                    .fillMaxWidth(),
                contentAlignment = Alignment.BottomCenter
            ) {
                Button(
                    onClick = { onClick() },
                    modifier = Modifier
                        .padding(16.dp)
                        .size(343.dp, 48.dp),
                    //  .align(Alignment.BottomCenter) // Размещаем кнопку внизу
                    //  .padding(16.dp), // Добавляем отступ снизу, если нужно
                    shape = RoundedCornerShape(15.dp),
                    colors = ButtonDefaults.buttonColors(colorResource(id = R.color.blueFigma)) // Замените на нужный цвет
                ) {
                    Text(
                        text = "Супер!",
                        color = Color.White
                    )
                }
            }


        }

    }
}