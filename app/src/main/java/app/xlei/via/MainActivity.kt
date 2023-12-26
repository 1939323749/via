package app.xlei.via

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import app.xlei.via.ui.theme.ViaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        when (intent?.action) {
            Intent.ACTION_VIEW -> {
                intent.data?.let {
                    val shareIntent = Intent(Intent.ACTION_SEND)
                    shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
                    shareIntent.setType(intent.type)
                    shareIntent.putExtra(Intent.EXTRA_STREAM, it)
                    shareIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    startActivity(Intent.createChooser(shareIntent,null))
                }
            }
            else -> {
                finish()
            }
        }
        setContent {
            ViaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column {
                        Spacer(modifier = Modifier.weight(1f))
                        Text(
                            text = "via",
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally)
                        )
                        Spacer(modifier = Modifier.weight(1f))
                    }
                }
            }
        }
    }

}