package com.godsonpeya.swipeiteminlist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.godsonpeya.swipeiteminlist.ui.theme.SwipeItemInListTheme
import kotlin.math.roundToInt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SwipeItemInListTheme {
                val list = listOf("Ana", "God", "Olo", "Don")
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize()) {
                    LazyColumn(content = {

                        items(list) {
                            ListItemRow(it)
                        }
                    })

                }
            }
        }
    }

}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun ListItemRow(str: String = "") {
    val squareSize = 50.dp
    val swipeableState = rememberSwipeableState(initialValue = 0)
    val sizePx = with(LocalDensity.current) { squareSize.toPx() }
    val anchors = mapOf(0f to 0, sizePx to 1, -sizePx to 2)

    Box(modifier = Modifier
        .fillMaxWidth()
        .clip(RoundedCornerShape(10.dp))
        .swipeable(state = swipeableState, anchors = anchors, thresholds = { _, _ ->
            FractionalThreshold(0.3f)
        }, orientation = Orientation.Horizontal)) {
        Row(horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()) {
            IconButton(onClick = {}, modifier = Modifier.size(50.dp)) {
                Icon(
                    Icons.Filled.Edit,
                    contentDescription = "Edit",
                )
            }

            Spacer(modifier = Modifier.width(10.dp))

            IconButton(onClick = {}, modifier = Modifier.size(50.dp)) {
                Icon(
                    Icons.Filled.Delete,
                    contentDescription = "Delete",
                )
            }
        }
        Card(modifier = Modifier
            .offset {
                IntOffset(swipeableState.offset.value.roundToInt(), 0)
            }
            .fillMaxWidth()
            .border(1.dp, Color.LightGray, RoundedCornerShape(10.dp)),
            elevation = 5.dp,
            shape = RoundedCornerShape(10.dp)) {
            Column(modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = str,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SwipeItemInListTheme {
        ListItemRow("Android")
    }
}