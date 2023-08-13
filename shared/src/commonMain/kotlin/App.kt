import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun App() {
    MaterialTheme {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.Center) {
                var expanded by remember { mutableStateOf(false) }
                PlatformView(modifier = Modifier.fillMaxSize())
                Row {
                    Button(onClick = { expanded = true }) {
                        Text("Menu over ${getPlatformName()} View")
                    }
                    DropdownMenu(
                        expanded = expanded,
                        onDismissRequest = { expanded = false },
                        content = {
                            DropdownMenuItem(onClick = { expanded = false }) {
                                Text("Item 1")
                            }
                            DropdownMenuItem(onClick = { expanded = false }) {
                                Text("Item 2")
                            }
                        }
                    )
                }
            }
            Divider()
            Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.Center) {
                var expanded by remember { mutableStateOf(false) }
                Row {
                    Button(onClick = { expanded = true }) {
                        Text("Menu not over ${getPlatformName()} View")
                    }
                    DropdownMenu(
                        expanded = expanded,
                        onDismissRequest = { expanded = false },
                        content = {
                            DropdownMenuItem(onClick = { expanded = false }) {
                                Text("Item 1")
                            }
                            DropdownMenuItem(onClick = { expanded = false }) {
                                Text("Item 2")
                            }
                        }
                    )
                }
            }
        }
    }
}

expect fun getPlatformName(): String

@Composable
expect fun PlatformView(modifier: Modifier)