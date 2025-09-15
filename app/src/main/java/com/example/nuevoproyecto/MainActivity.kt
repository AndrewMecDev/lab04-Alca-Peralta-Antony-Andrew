package com.example.nuevoproyecto

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyApp() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("✨ Controladores y Contenedores", fontSize = 20.sp, fontWeight = FontWeight.Bold) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF6A5ACD), // violeta
                    titleContentColor = Color.White
                )
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            //Estoy añadiendo un comentario para el paso 5 - Andrew
            // ---------- Contenedores ----------
            item {
                Text("📦 Contenedores", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
            }

            item {
                LazyRow {
                    items(5) { index ->
                        Card(
                            Modifier
                                .padding(9.dp)
                                .size(80.dp)
                                .background(Color(0xFFEADDFF)),
                            colors = CardDefaults.cardColors(containerColor = Color(0xFFB39DDB))
                        ) {
                            Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                                Text("Item $index", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                            }
                        }
                    }
                }
            }

            item { Spacer(Modifier.height(20.dp)) }

            item {
                Text("⭐ Box y Column anidada", fontWeight = FontWeight.SemiBold, fontSize = 16.sp)
            }

            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(120.dp)
                        .background(Color(0xFF80CBC4)),
                    contentAlignment = Alignment.Center
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text("Soy una Column dentro de un Box", color = Color.Black, fontWeight = FontWeight.Bold)
                        Text("Perfecto para organizar contenido centrado", fontSize = 14.sp)
                    }
                }
            }

            item { Spacer(Modifier.height(24.dp)) }

            // ---------- Controles ----------
            item {
                Text("🎛 Controles", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
            }

            item { ControlCheckboxDemo() }
            item { Spacer(Modifier.height(12.dp)) }
            item { ControlRadioButtonDemo() }
            item { Spacer(Modifier.height(12.dp)) }
            item { ControlSwitchDemo() }
            item { Spacer(Modifier.height(12.dp)) }
            item { ControlSliderDemo() }
            item { Spacer(Modifier.height(12.dp)) }
            item { ControlTextFieldDemo() }
            item { Spacer(Modifier.height(12.dp)) }
            item { ControlButtonDemo() }
        }
    }
}

// -------- Controles básicos ----------

@Composable
fun ControlCheckboxDemo() {
    var checked by remember { mutableStateOf(false) }
    Row(verticalAlignment = Alignment.CenterVertically) {
        Checkbox(checked = checked, onCheckedChange = { checked = it }, colors = CheckboxDefaults.colors(checkedColor = Color.Red))
        Text("Checkbox seleccionado: $checked")
    }
}

@Composable
fun ControlRadioButtonDemo() {
    var selected by remember { mutableStateOf(false) }
    Row(verticalAlignment = Alignment.CenterVertically) {
        RadioButton(selected = selected, onClick = { selected = !selected })
        Text("RadioButton activo: $selected")
        Spacer(Modifier.width(16.dp))
    }
}

@Composable
fun ControlSwitchDemo() {
    var isOn by remember { mutableStateOf(false) }
    Row(verticalAlignment = Alignment.CenterVertically) {
        Switch(checked = isOn, onCheckedChange = { isOn = it })
        Text("Switch encendido: $isOn")
        Spacer(Modifier.width(16.dp))
    }
}

@Composable
fun ControlSliderDemo() {
    var value by remember { mutableFloatStateOf(0f) }
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Slider(value = value, onValueChange = { value = it })
        Text("Valor del Slider: ${"%.2f".format(value)}")
    }
}

@Composable
fun ControlTextFieldDemo() {
    var text by remember { mutableStateOf("") }
    OutlinedTextField(value = text, onValueChange = { text = it }, label = { Text("Ingrese texto") })
}

@Composable
fun ControlButtonDemo() {
    Button(onClick = {}, colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6A5ACD)), modifier = Modifier.padding(8.dp)) {
        Text("Presioname", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 16.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApp()
}
