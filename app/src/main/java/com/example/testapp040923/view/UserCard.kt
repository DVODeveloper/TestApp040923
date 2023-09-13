package com.example.testapp040923.view

import android.graphics.Paint.Align
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testapp040923.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserCard(
    user: PersonItems,
    list: String
) {
    var expanded by remember { mutableStateOf(false) }

    var textName by rememberSaveable(stateSaver = TextFieldValue.Saver) {
        mutableStateOf(TextFieldValue("", TextRange(0, 7)))
    }
    var textSurName by rememberSaveable(stateSaver = TextFieldValue.Saver) {
        mutableStateOf(TextFieldValue("", TextRange(0, 7)))
    }

    Card(
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        modifier = Modifier
            .padding(
                top = 3.dp,
                bottom = 3.dp
            )
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .background(Color.White)
                .padding(start = 16.dp, end = 16.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Text(
                    text = "$list турист",
                    modifier = Modifier
                        .padding(
                            end = 16.dp,
                            top = 3.dp,
                            bottom = 3.dp
                        )
                        .weight(1f),
                    style = TextStyle(
                        Color.Black,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 22.sp
                    )
                )
                IconButton(
                    modifier = Modifier,
                    onClick = { expanded = !expanded }
                ) {
                    Image(
                        painterResource(
                            id = if (expanded) {
                                R.drawable.icon_close_card
                            } else {
                                R.drawable.icon_open_card
                            }
                        ),
                        contentDescription = null
                    )
                }
            }

            if (expanded) {
                Spacer(modifier = Modifier.height(16.dp))

                TextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 3.dp, bottom = 3.dp)
                        .clip(shape = RoundedCornerShape(12.dp)),
                    value = textName,
                    onValueChange = { newText -> textName = newText },
                    label = { Text("Имя") }
                )

                TextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 3.dp, bottom = 3.dp)
                        .clip(shape = RoundedCornerShape(12.dp)),
                    value = textSurName,
                    onValueChange = { newText -> textSurName = newText },
                    label = { Text("Фамилия") }
                )
            }
        }
    }
}

