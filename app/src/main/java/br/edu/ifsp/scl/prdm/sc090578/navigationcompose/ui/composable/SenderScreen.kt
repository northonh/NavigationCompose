package br.edu.ifsp.scl.prdm.sc090578.navigationcompose.ui.composable

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.edu.ifsp.scl.prdm.sc090578.navigationcompose.ui.theme.NavigationComposeTheme

@Composable
fun SenderScreen(textReceived: String = "", modifier: Modifier, onSendClick: (String) -> Unit) {
    var textToSend by remember { mutableStateOf(textReceived) }
    Column(modifier = modifier.fillMaxWidth()) {
        OutlinedTextField(
            value = textToSend,
            onValueChange = { textToSend = it },
            label = { Text("Text to send") },
            modifier = Modifier.fillMaxWidth()
        )
        Button(
            onClick = {
                onSendClick(textToSend)
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Send")
        }
    }
}

@Preview(
    name = "Light mode",
    showBackground = true,
    uiMode = UI_MODE_NIGHT_NO
)
@Preview(
    name = "Dark mode",
    showBackground = true,
    uiMode = UI_MODE_NIGHT_YES
)
@Composable
fun SenderScreenPreview() {
    NavigationComposeTheme {
        Surface {
            SenderScreen(
                modifier = Modifier,
                onSendClick = {}
            )
        }
    }
}
