package com.joblogic.todoapp.feature.call

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.joblogic.todoapp.core.model.Call

/**
 * Created by TC on 04/03/2023.
 */

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CallCard(
    call: Call
) {
    Card(
        onClick = {},
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(10.dp),
        backgroundColor = Color.White,
        elevation = 8.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            CallName(name = call.name)

            Spacer(modifier = Modifier.height(10.dp))

            CallNumber(number = call.number)
        }
    }
}

@Composable
fun CallName(
    name: String?
) {
    val name = "${stringResource(id = R.string.text_name)}: ${name.orEmpty()}"
    Text(
        text = name,
        color = Color.Black,
        fontSize = 16.sp,
        maxLines = 1
    )
}

@Composable
fun CallNumber(
    number: String?
) {
    val number = "${stringResource(id = R.string.text_number)}: ${number.orEmpty()}"
    Text(
        text = number,
        color = Color.Black,
        fontSize = 16.sp,
        maxLines = 1
    )
}

@Preview
@Composable
fun CallNamePreview() {
    CallName(name = "Eden Hazard")
}

@Preview
@Composable
fun CallNumberPreview() {
    CallNumber(number = "012345678")
}

@Preview
@Composable
fun CallCardPreview() {
    CallCard(call = Call(
        id = null,
        name = "Eden Hazard",
        number = "012345678"
    ))
}