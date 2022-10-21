package ch.plebsapps.dynamiccontentexample

import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

val namesList: ArrayList<String> = arrayListOf("Danna", "Michael", "Stefan", "John", "Georgia")

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GreetingsList(names = namesList)
        }
    }
}

@Composable
fun GreetingsList(names: List<String>) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        for (name in names) {
            Greeting(name = name)
        }
        Button(onClick = { namesList.add("New Name") }) {
            Text("Add new name")
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(
        text = "Hello $name!",
        style = MaterialTheme.typography.h4
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GreetingsList(names = namesList)
}