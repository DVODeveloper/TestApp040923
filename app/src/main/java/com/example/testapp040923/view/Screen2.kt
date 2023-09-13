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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.testapp040923.R
import com.example.testapp040923.Screen1Model


@Composable
fun Screen2(
    onClick: () -> Unit,
    //currentInfoScreen2: MutableState<Screen2Model>
) {

    Column(
        modifier = Modifier
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {

        Card(
            modifier = Modifier
                .padding(top = 50.dp)
                .size(343.dp, 257.dp)
                .clip(shape = RoundedCornerShape(12.dp))
        ) {
//            Image(
//                modifier = Modifier
//                    .fillMaxSize(),
//                painter = rememberAsyncImagePainter(currentInfoScreen2.value.image_urls),
//                contentDescription = null,
//            )
        }
        Text(
            text = "currentInfoScreen2.value.name",
            fontSize = 22.sp,
            fontWeight = FontWeight.SemiBold
        )
        Column {
            Row(
                modifier = Modifier
                    .padding(top = 16.dp)
            ) {
                Text(
                    modifier = Modifier
                        .padding(end = 16.dp, bottom = 16.dp),
                    text = "currentInfoScreen2.value.peculiarities",
                    style = TextStyle(
                        fontSize = 16.sp,
                        color = Color.Gray
                    )
                )
                Text(
                    modifier = Modifier
                        .padding(end = 16.dp, bottom = 16.dp),
                    text = "Кондиционер",
                    style = TextStyle(
                        fontSize = 16.sp,
                        color = Color.Gray
                    )
                )
            }

            Box(
                modifier = Modifier
                    .size(192.dp, 29.dp)
                    .clip(shape = RoundedCornerShape(5.dp))
                    .background(colorResource(id = R.color.blueFigma_10percent))
            ) {
                Row (
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,

                        ) {
                    Text(
                        modifier = Modifier
                            .padding(start = 8.dp),
                        text = "Подробнее о номере",
                        style = TextStyle(
                            fontSize = 15.sp,
                            color = colorResource(id = R.color.blueFigma)
                        )
                    )
                    Image(painterResource(id = R.drawable.icon_right), contentDescription = null)
                }
            }
        }
        Row(
            verticalAlignment = Alignment.Bottom,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, bottom = 16.dp)
        ) {
            Text(
                text = "186 600 ₽",
                fontSize = 30.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(end = 16.dp)
            )
            Text(
                text = "за 7 ночей с перелётом",
                color = Color.Gray,
                fontSize = 16.sp
            )
        }

        Button(
            onClick = { onClick() },
            modifier = Modifier
                .size(343.dp,48.dp),
            shape = RoundedCornerShape(15.dp),
            colors = ButtonDefaults.buttonColors(colorResource(id = R.color.blueFigma)),

            ) {
            Text(
                text = "Выбрать номер",
                color = Color.White
            )
        }

    }

}


@Composable
fun ImagesForScreen2() {
    val imageList = listOf(
        R.drawable.imagescreen2,
        R.drawable.imagescreen2_2,
        R.drawable.imagescreen2_3
    )
    ImageCarousel(images = imageList)
}

@Composable
fun ImageCarousel(images: List<Int>) {
    LazyRow {
        items(images) { imageRes ->
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .width(375.dp)
                    .height(539.dp)
                    .clip(shape = RoundedCornerShape(12.dp))
                    .padding(8.dp)
            )

        }
    }
}