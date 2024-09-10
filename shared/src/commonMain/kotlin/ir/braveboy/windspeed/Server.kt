/*
package ir.braveboy.windspeedimport androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ir.partsofware.sam.android.R
import ir.partsofware.sam.android.WindscribeTheme

data class Location(
    val name: String,
    val flag: String,
    val protocol: String,
    val port: String,
    val operator: String,
)

data class Operator(
    val name: String,
    val flag: String? = null
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WindscribeUI() {
    var isSelected by remember { mutableStateOf("MTN") }
    val modalBottomSheetState = rememberModalBottomSheetState()
    var showSheet by remember { mutableStateOf(false) }

    val locations = remember {
        listOf(
            Location(
                "Best Location",
                flag = "🇺🇸",
                protocol = "WStunnel",
                port = "443",
                operator = "MCI"
            ),
            Location("Tirana Besa ", "🇦🇱", protocol = "WStunnel", port = "443", operator = "MTN"),
            Location("Argentina", "🇦🇷", protocol = "UDP", port = "1192", operator = "MTN"),
            Location("Australia", "🇦🇺", protocol = "Stealth", port = "123", operator = "MTN"),
            Location("Austria", "🇦🇹", protocol = "WStunnel", port = "443", operator = "MCI"),
            Location("Belgium", "🇧🇪", protocol = "Stealth", port = "143", operator = "MCI"),
            Location("Bosnia", "🇧🇦", protocol = "WStunnel", port = "443", operator = "MCI")
        )
    }

    val operators = remember {
        listOf(
            Operator("MTN"),
            Operator("MCI"),
            Operator("MOK"),
            Operator("SHT"),
            Operator("MOB"),
        )
    }

    AnimatedVisibility(showSheet) {
        ModalBottomSheet(
            onDismissRequest = {
                showSheet = false
            },
            sheetState = modalBottomSheetState,
            dragHandle = { BottomSheetDefaults.DragHandle() },
        ) {

        }
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(WindscribeTheme.DarkGray)
            .padding(horizontal = 16.dp)
    ) {
        // Header
        val gradientColors = listOf(Color(0xFF1A2634), Color(0xFF131E29))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth(.8F)
                    .height(56.dp)
                    .padding(end = 42.dp)
                    .clip(RoundedCornerShape(bottomEnd = 70.dp))
                    .background(
                        Brush.verticalGradient(gradientColors)
                    )
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "WindSpeed",
                        color = Color.White,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 1.sp
                    )
                    Spacer(Modifier.weight(1f))
                    // You can add additional icons or elements here if needed
                }
            }
            Image(
                painter = painterResource(R.drawable.ic_wind_speed),
                contentDescription = ""
            )
        }

        Spacer(Modifier.height(16.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            LazyRow(horizontalArrangement = Arrangement.SpaceBetween) {
                items(operators) {
                    Text(
                        it.name,
                        modifier = Modifier
                            .padding(end = 16.dp)
                            .clip(RoundedCornerShape(4.dp))
                            .background(if (isSelected == it.name) WindscribeTheme.LightGray else WindscribeTheme.DarkGray)
                            .border(
                                1.dp,
                                shape = MaterialTheme.shapes.medium,
                                color = WindscribeTheme.MediumGray
                            )
                            .clickable { isSelected = it.name }
                            .padding(horizontal = 16.dp, vertical = 8.dp),
                        color = WindscribeTheme.LightText,
                        fontSize = 14.sp
                    )
                }
            }
        }

        Spacer(Modifier.height(16.dp))

        // Location Selector
        Box(modifier = Modifier.fillMaxSize()) {
            Surface(
                modifier = Modifier.fillMaxWidth(),
                color = WindscribeTheme.MediumGray,
                shape = MaterialTheme.shapes.small
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            "Locations",
                            color = WindscribeTheme.LightText,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium
                        )
                        Icon(
                            painter = painterResource(id = R.drawable.ic_location),
                            contentDescription = "",
                            tint = WindscribeTheme.LightText
                        )
                    }

                    Spacer(Modifier.height(16.dp))
                    LazyColumn {
                        items(locations.filter { it.operator == isSelected }) { location ->
                            LocationItem(location)
                        }
                    }
                }
            }

            Button(
                modifier = Modifier
                    .padding(vertical = 16.dp)
                    .fillMaxWidth()
                    .height(55.dp)
                    .clip(MaterialTheme.shapes.medium)
                    .align(Alignment.BottomCenter),
                colors = ButtonDefaults.buttonColors(Color.Green),
                shape = RoundedCornerShape(16.dp),
                onClick = {
                    showSheet = showSheet.not()
                }
            ) {
                Text(
                    "Add Available Locations",
                    color = WindscribeTheme.DarkGray,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}

@Composable
fun LocationItem(location: Location) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp, horizontal = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            location.flag,
            modifier = Modifier.padding(end = 12.dp),
            fontSize = 18.sp
        )
        Text(
            location.name,
            color = WindscribeTheme.LightText,
            fontSize = 18.sp
        )

        Spacer(modifier = Modifier.weight(1F))

        Text(
            "${location.protocol} / ${location.port}",
            color = WindscribeTheme.LightText,
            fontSize = 12.sp
        )

        Spacer(Modifier.width(8.dp))

        AnimatedVisibility(location.port == "443") {
            Icon(
                painter = painterResource(id = R.drawable.ic_anti_censorship),
                contentDescription = "",
                tint = Color.Green
            )
        }
    }
}*/
