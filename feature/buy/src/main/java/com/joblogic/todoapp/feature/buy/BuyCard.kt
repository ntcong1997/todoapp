package com.joblogic.todoapp.feature.buy

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
import com.joblogic.todoapp.core.model.Buy

/**
 * Created by TC on 04/03/2023.
 */

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BuyCard(
    buy: Buy
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
            BuyName(name = buy.name)

            Spacer(modifier = Modifier.height(10.dp))

            BuyPrice(price = buy.price)

            Spacer(modifier = Modifier.height(10.dp))

            BuyQuantity(quantity = buy.quantity)
        }
    }
}

@Composable
fun BuyName(
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
fun BuyPrice(
    price: Long?
) {
    val price = "${stringResource(id = R.string.text_price)}: ${price ?: ""}"
    Text(
        text = price,
        color = Color.Black,
        fontSize = 16.sp,
        maxLines = 1
    )
}

@Composable
fun BuyQuantity(
    quantity: Int?
) {
    val quantity = "${stringResource(id = R.string.text_quantity)}: ${quantity ?: ""}"
    Text(
        text = quantity,
        color = Color.Black,
        fontSize = 16.sp,
        maxLines = 1
    )
}

@Preview
@Composable
fun BuyNamePreview() {
    BuyName(name = "Eden Hazard")
}

@Preview
@Composable
fun BuyPricePreview() {
    BuyPrice(price = 2000)
}

@Preview
@Composable
fun BuyQuantityPreview() {
    BuyQuantity(quantity = 5)
}

@Preview
@Composable
fun BuyCardPreview() {
    BuyCard(buy = Buy(
        id = null,
        name = "Eden Hazard",
        price = 2000,
        quantity = 5
    ))
}