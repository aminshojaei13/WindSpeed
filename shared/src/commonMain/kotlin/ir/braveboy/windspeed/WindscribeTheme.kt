/*
package ir.braveboy.windspeed

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

object WindscribeTheme {
    val DarkGray = Color(0xFF1F2937)
    val MediumGray = Color(0xFF374151)
    val LightGray = Color(0xFF4B5563)
    val Blue = Color(0xFF2563EB)
    val White = Color(0xFFFFFFFF)
    val LightText = Color(0xFFD1D5DB)
    val DarkText = Color(0xFF1F2937)

    private val DarkColorScheme = darkColorScheme(
        primary = Blue,
        onPrimary = White,
        secondary = LightGray,
        onSecondary = White,
        background = DarkGray,
        onBackground = LightText,
        surface = MediumGray,
        onSurface = LightText
    )

    private val LightColorScheme = lightColorScheme(
        primary = Blue,
        onPrimary = White,
        secondary = LightGray,
        onSecondary = DarkText,
        background = White,
        onBackground = DarkText,
        surface = Color(0xFFF3F4F6),
        onSurface = DarkText
    )

    @Composable
    fun WindscribeTheme(
        darkTheme: Boolean = isSystemInDarkTheme(),
        content: @Composable () -> Unit
    ) {
        // You can customize these further if needed
        val Typography = MaterialTheme.typography
        val Shapes = MaterialTheme.shapes
        val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

        MaterialTheme(
            colorScheme = colorScheme,
            typography = Typography,
            shapes = Shapes,
            content = content
        )
    }
}*/
