package com.example.autohyphenation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.Hyphens
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.autohyphenation.ui.theme.AutoHyphenationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AutoHyphenationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AutoHyphenation(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
private fun AutoHyphenation(modifier: Modifier = Modifier) {
    Text(
        text = stringResource(R.string.test),
        style = TextStyle(fontSize = 80.sp, hyphens = Hyphens.Auto),
        color = Color.Black,
        modifier = modifier
            .width(400.dp)
            .height(150.dp),
        maxLines = 4,
    )
}

@Preview(device = Devices.PHONE)
@Composable
private fun AutoHyphenationPreview() {
    AutoHyphenationTheme {
        AutoHyphenation()
    }
}