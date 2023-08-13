import android.view.View
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView

actual fun getPlatformName(): String = "Android"

@Composable
fun MainView() = App()

@Composable
actual fun PlatformView(modifier: Modifier) {
    val context = LocalContext.current
    val view = remember { View(context) }
    AndroidView(
        modifier = modifier,
        factory = { view }
    )
}