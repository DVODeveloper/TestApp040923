package com.example.testapp040923.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testapp040923.R

@Composable
fun UserList(
    onClick: () -> Unit
) {
    val users = remember { mutableStateListOf<PersonItems>() }


    LazyColumn(
        modifier = Modifier
            .clip(shape = RoundedCornerShape(12.dp))
//        contentPadding = PaddingValues(16.dp)
    ) {
        item {
            HotelTopInfo()
            FlyInfo()
            CustomerInfo()
        }
        itemsIndexed(users) { index, user ->
            UserCard(
                user = user,
                list = NumberTourist().listTourist[index]
            )
        }

        if (users.size < 10) { // Проверяем, что количество элементов < 10
            item {

                Card(
                    shape = RoundedCornerShape(12.dp),
                    elevation = CardDefaults.cardElevation(4.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 6.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start,
                        modifier = Modifier.background(Color.White)
                    ) {
                        Text(
                            "Добавить туриста",
                            modifier = Modifier
                                .padding(
                                    start = 16.dp,
                                    end = 16.dp,
                                    top = 3.dp,
                                    bottom = 3.dp
                                )
                                .weight(1f),
                            style = TextStyle(
                                Color.Black,
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 22.sp
                            ),

                            )

                        IconButton(
                            modifier = Modifier.padding(end =16.dp),
                            onClick = {

                            if (users.size < 10) { // Проверяем еще раз перед добавлением
                                users.add(PersonItems("", ""))
                            }

                        }) {
                            Image(
                                painterResource(id = R.drawable.icon_plus),
                                contentDescription = null
                            )
                        }
                    }
                }
                Column(
                    modifier = Modifier
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    BottomInfo()
                }

                Button(
                    onClick = { onClick() },
                    modifier = Modifier
                        .padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
                        .width(343.dp)
                        .height(48.dp),
                    shape = RoundedCornerShape(15.dp),
                    colors = ButtonDefaults.buttonColors(colorResource(id = R.color.blueFigma)),

                    ) {
                    Text(
                        text = "Оплатить 198 036 ₽",
                        color = Color.White
                    )
                }
            }
        }
    }
}

@Composable
fun BottomInfo() {
    Row(
        modifier = Modifier
            .padding(
                start = 16.dp,
                end = 16.dp,
                top = 3.dp,
                bottom = 3.dp
            )
    ) {
        Text(
            text = "Тур",
            modifier = Modifier.weight(1f),
            style = TextStyle(
                fontSize = 16.sp,
                color = Color.Gray,
            )
        )
        Text(
            text = "186 600 ₽",
            style = TextStyle(
                fontSize = 19.sp,
                color = Color.Black,
            )
        )
    }

    Row(
        modifier = Modifier
            .padding(
                start = 16.dp,
                end = 16.dp,
                top = 3.dp,
                bottom = 3.dp
            )
    ) {
        Text(
            text = "Топливный сбор",
            modifier = Modifier.weight(1f),
            style = TextStyle(
                fontSize = 16.sp,
                color = Color.Gray,
            )
        )
        Text(
            text = "9 300 ₽",
            style = TextStyle(
                fontSize = 19.sp,
                color = Color.Black,
            )
        )
    }

    Row(
        modifier = Modifier
            .padding(
                start = 16.dp,
                end = 16.dp,
                top = 3.dp,
                bottom = 3.dp
            )
    ) {
        Text(
            text = "Сервисный сбор",
            modifier = Modifier.weight(1f),
            style = TextStyle(
                fontSize = 16.sp,
                color = Color.Gray,
            )
        )
        Text(
            text = "2 136 ₽",
            style = TextStyle(
                fontSize = 19.sp,
                color = Color.Black,
            )
        )
    }

    Row(
        modifier = Modifier
            .padding(
                start = 16.dp,
                end = 16.dp,
                top = 3.dp,
                bottom = 3.dp
            )
    ) {
        Text(
            text = "К оплате",
            modifier = Modifier.weight(1f),
            style = TextStyle(
                fontSize = 16.sp,
                color = Color.Gray,
            )
        )
        Text(
            text = "198 036 ₽",
            style = TextStyle(
                fontSize = 19.sp,
                color = colorResource(id = R.color.blueFigma),
            )
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomerInfo() {
    Card(
        modifier = Modifier
            .padding(top = 6.dp)
            .background(Color.White)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(4.dp),

        ) {
        Column(
            modifier = Modifier
                .background(Color.White)
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            var textNumberPhone by rememberSaveable(stateSaver = TextFieldValue.Saver) {
                mutableStateOf(TextFieldValue("+7 (951) 555-99-00", TextRange(0, 0),))
            }
            var textEmail by rememberSaveable(stateSaver = TextFieldValue.Saver) {
                mutableStateOf(TextFieldValue("examplemail.000@mail.ru", TextRange(0, 0)))
            }
            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Информация о покупателе",
                    modifier = Modifier
                        .padding(bottom = 16.dp),
                    style = TextStyle(
                        fontSize = 22.sp, color = Color.Black,
                        fontWeight = FontWeight.SemiBold
                    )
                )
            }

            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 3.dp, bottom = 3.dp)
                    .clip(shape = RoundedCornerShape(12.dp)),
                value = textNumberPhone,
                onValueChange = { textNumberPhone = it },
                label = { Text("Номер телефона", fontSize = 14.4.sp) }
            )

            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(12.dp)),
                value = textEmail,
                onValueChange = { textEmail = it },
                label = { Text("Почта",fontSize = 14.4.sp) }
            )
            Text(
                modifier = Modifier
                    .padding(top = 5.dp),
                text = "Эти данные никому не передаются. " +
                        "После оплаты мы вышли чек на указанный вами номер и почту",
                style = TextStyle(
                    fontSize = 14.sp,
                    color = Color.Gray
                )
            )
        }
    }
}

@Preview
@Composable
fun FlyInfo() {
    Card(
        elevation = CardDefaults.cardElevation(4.dp),
        modifier = Modifier.padding(top = 6.dp)
    ) {
        Column(
            modifier = Modifier
                .background(Color.White)
                .padding(16.dp)
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(12.dp))
        ) {
            Row(
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Вылет из",
                    modifier = Modifier
                        .weight(1f),
                    style = TextStyle(color = Color.Gray, fontSize = 16.sp)
                )
                Text(
                    text = "Санкт-Петербург",
                    modifier = Modifier
                        .weight(1f),
                    style = TextStyle(color = Color.Black, fontSize = 16.sp)
                )
            }

            Row(
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Страна, город",
                    modifier = Modifier
                        .weight(1f),
                    style = TextStyle(color = Color.Gray, fontSize = 16.sp)
                )
                Text(
                    text = "Египет, Хургада",
                    modifier = Modifier
                        .weight(1f),
                    style = TextStyle(color = Color.Black, fontSize = 16.sp)
                )
            }

            Row(
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Даты",
                    modifier = Modifier
                        .weight(1f),
                    style = TextStyle(color = Color.Gray, fontSize = 16.sp)
                )
                Text(
                    text = "19.09.2023 – 27.09.2023",
                    modifier = Modifier
                        .weight(1f),
                    style = TextStyle(color = Color.Black, fontSize = 16.sp)
                )
            }

            Row(
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Кол-во ночей",
                    modifier = Modifier
                        .weight(1f),
                    style = TextStyle(color = Color.Gray, fontSize = 16.sp)
                )
                Text(
                    text = "7 ночей",
                    modifier = Modifier
                        .weight(1f),
                    style = TextStyle(color = Color.Black, fontSize = 16.sp)
                )
            }

            Row(
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Отель",
                    modifier = Modifier
                        .weight(1f),
                    style = TextStyle(color = Color.Gray, fontSize = 16.sp)
                )
                Text(
                    text = "Steigenberger Makadi",
                    modifier = Modifier
                        .weight(1f),
                    style = TextStyle(color = Color.Black, fontSize = 16.sp)
                )
            }

            Row(
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Номер",
                    modifier = Modifier
                        .weight(1f),
                    style = TextStyle(color = Color.Gray, fontSize = 16.sp)
                )
                Text(
                    text = "Стандартный с видом на бассейн или сад",
                    modifier = Modifier
                        .weight(1f),
                    style = TextStyle(color = Color.Black, fontSize = 16.sp)
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Питание",
                    modifier = Modifier
                        .weight(1f),
                    style = TextStyle(color = Color.Gray, fontSize = 16.sp)
                )
                Text(
                    text = "Все включено",
                    modifier = Modifier
                        .weight(1f),
                    style = TextStyle(color = Color.Black, fontSize = 16.sp)
                )
            }
        }
    }

}

@Preview
@Composable
fun HotelTopInfo() {
    Card(
        elevation = CardDefaults.cardElevation(4.dp),
       // modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 4.dp)
    ) {
        Column(
            modifier = Modifier
                .background(Color.White)
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Box (
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(5.dp))
                    ){
                Row(
                    modifier = Modifier
                        .background(color = colorResource(R.color.yellow_star))
                        .width(149.dp)
                        .height(29.dp),
                    verticalAlignment = Alignment.CenterVertically

                ) {
                    Image(
                        painterResource(id = R.drawable.icon_star),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(5.dp)
                    )
                    Text(
                        text = "5 Превосходно",
                        style = TextStyle(
                            color = colorResource(R.color.yellow_star_text),
                            fontSize = 16.sp
                        )
                    )
                }
            }

            Row (
                modifier = Modifier
                    .padding(bottom = 6.dp)
                    ) {
                Text(
                    modifier = Modifier
                        .padding(top = 5.dp),
                    text = "Steigenberger Makadi",
                    style = TextStyle(
                        fontSize = 22.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                )
            }
            Row {
                Text(
                    modifier = Modifier
                        .padding(top = 5.dp, bottom = 5.dp),
                    text = "Madinat Makadi, Safaga Road, Makadi Bay, Египет",
                    style = TextStyle(
                        fontSize = 14.sp,
                        color = colorResource(id = R.color.blueFigma)
                    )
                )
            }

        }

    }
}