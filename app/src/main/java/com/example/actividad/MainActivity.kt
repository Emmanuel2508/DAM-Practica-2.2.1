package com.example.actividad

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.AlarmClock
import android.provider.CalendarContract
import android.provider.CalendarContract.Events
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddLink
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Image
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.actividad.ui.theme.ActividadTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    private val TAG = "MainActivity"
    private var keepSplash = true
    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        splashScreen.setKeepOnScreenCondition { keepSplash }
        lifecycleScope.launch{
            delay(3000)
            keepSplash = false
        }
        super.onCreate(savedInstanceState)
        ShowToast("Funcion onCreate()")
        enableEdgeToEdge()
        setContent {
            ActividadTheme {
                ViewContainer()
            }
        }
    }
    override fun onStart(){
        super.onStart()
        ShowToast("Funcion Onstart()")
    }

    fun ShowToast(message: String){
        val toast = Toast.makeText(
            this,
            message,
            Toast.LENGTH_LONG
        )
        toast.show()
        Log.i(TAG, message)
    }
}

// device = "spec:width=411dp,height=891dp,orientation=landscape"
// @Preview(showBackground = true,
   //  locale = "fr-rFR")
@Composable
fun ContentView() {
    var counter by rememberSaveable { mutableStateOf(0) }
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red)
    ) {
        item {
            Image(
                painter = painterResource(
                    id = R.drawable.wallpaper
                ),
                contentDescription = "Ilustracion de Android",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp)
            )

            Row(modifier = Modifier.padding(top = 2.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.ic_android_black_24dp,),
                    contentDescription = "Android",
                    modifier = Modifier
                        .clickable { counter++ }
                        .padding(start = 12.dp)
                )
                Text(
                    text = counter.toString(),
                    fontSize = 20.sp,
                    color = Color.White,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }

            Text(
                text = stringResource(R.string.materia),
                fontSize = 24.sp,
                color = Color.White,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )

            Text(
                text = stringResource(R.string.nombre),
                fontSize = 20.sp,
                color = Color.White,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )

            Text(
                text = stringResource(R.string.apellido),
                fontSize = 20.sp,
                color = Color.White,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )

            LazyRow(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                item {
                    Image(
                        modifier = Modifier
                            .size(200.dp)
                            .fillMaxWidth()
                            .height(100.dp)
                            .padding(5.dp),
                        painter = painterResource(R.drawable._1_sm),
                        contentDescription = "Mobile Apps"
                    )
                    Image(
                        modifier = Modifier
                            .size(200.dp)
                            .fillMaxWidth()
                            .height(100.dp)
                            .padding(5.dp),
                        painter = painterResource(R.drawable._2_sm),
                        contentDescription = "Mobile Apps"
                    )
                    Image(
                        modifier = Modifier
                            .size(200.dp)
                            .fillMaxWidth()
                            .height(100.dp)
                            .padding(5.dp),
                        painter = painterResource(R.drawable._3_sm),
                        contentDescription = "Mobile Apps"
                    )
                    Image(
                        modifier = Modifier
                            .size(200.dp)
                            .fillMaxWidth()
                            .height(100.dp)
                            .padding(5.dp),
                        painter = painterResource(R.drawable._4_sm),
                        contentDescription = "Mobile Apps"
                    )
                    Image(
                        modifier = Modifier
                            .size(200.dp)
                            .fillMaxWidth()
                            .height(100.dp)
                            .padding(5.dp),
                        painter = painterResource(R.drawable._5_sm),
                        contentDescription = "Mobile Apps"
                    )
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Preview(
   // device = "spec:width=411dp,height=891dp,orientation=portrait",
    locale = "es-rMX",
    showBackground = true
)
@Composable
fun ViewContainer(){
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.title))},
                colors = TopAppBarColors(
                    containerColor = MaterialTheme.colorScheme
                        .secondary,
                    titleContentColor = Color.White,
                    scrolledContainerColor = Color.White,
                    navigationIconContentColor = Color.White,
                    actionIconContentColor = Color.White,
                    subtitleContentColor = Color.White,
                ),
                navigationIcon = {
                    IconButton(
                        onClick = {}
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = stringResource(R.string.back_btn),
                            tint = Color.White
                        )
                    }
                },
                actions ={
                    IconButton(onClick = {openWebScreen(context)}) {
                        Icon(
                            imageVector = Icons.Default.AddLink,
                            contentDescription = "Marcar como favorito",
                            tint = Color.White
                        )
                    }
                    IconButton(onClick = {Navegador(context)}) {
                        Icon(
                            imageVector=Icons.Default.Share,
                            contentDescription = "Compartir",
                            tint = Color.White
                        )
                    }
                    DropDownMenu()
                }
            )
        },
        bottomBar = {
            BottomAppBar(
                containerColor = MaterialTheme.colorScheme.secondary,
                contentColor = MaterialTheme.colorScheme.secondary
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    text = stringResource(R.string.bottom_app_bar),
                    color = Color.White,
                    fontSize = 18.sp,
                )
            }
        },
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState )
        },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                text = { Text("Show snackbar") },
                icon = { Icon(Icons.Filled.Image, contentDescription = "" )},
                onClick = {
                    scope.launch {
                        snackbarHostState.showSnackbar("Snackbar")
                    }
                }
            )
        }
    ) { ContentView()}

}

@Composable
fun DropDownMenu() {
    val context = LocalContext.current
    var expanded by remember { mutableStateOf(false) }
    Box {
        IconButton(onClick = { expanded = true }) {
            Icon(
                imageVector = Icons.Default.MoreVert,
                contentDescription = stringResource(R.string.options_menu),
                tint= Color.White
            )
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            DropdownMenuItem(
                text = { Text(stringResource(R.string.calendario)) },
                onClick = { CrearEvento(context)
                    expanded = false
                },
                leadingIcon = {
                    Icon(Icons.Default.Person, contentDescription = null)
                }
            )

            DropdownMenuItem(
                text = { Text(stringResource(R.string.alarma)) },
                onClick = { CrearAlarma(context)
                    expanded = false
                },
                leadingIcon = {
                    Icon(Icons.Default.Settings, contentDescription = null)
                }
            )

            HorizontalDivider()

            DropdownMenuItem(
                text = { Text(stringResource(R.string.archivos)) },
                onClick = { VerArchivos(context)
                    expanded = false
// Acción para Cerrar sesión
                },
                leadingIcon = {
                    Icon(Icons.Default.ExitToApp, contentDescription = null)
                }
            )
        }
    }
}

fun openWebScreen(context: Context){
    try{
        val url = Uri.parse("https://aguascalientes.tecnm.mx/")
        val intent = Intent(Intent.ACTION_VIEW, url)
        context.startActivity(intent)
    } catch (e: Exception){
        Toast.makeText(context,"Escoge un navegador",
            Toast.LENGTH_LONG).show()
    }
}

fun CrearAlarma(context: Context){
    try {
        val intent = Intent(AlarmClock.ACTION_SET_ALARM).apply {
            putExtra(AlarmClock.EXTRA_HOUR, 7)
            putExtra(AlarmClock.EXTRA_MINUTES, 30)
        }
        context.startActivity(intent)
    } catch (e: Exception){
        Toast.makeText(context, "Error",
            Toast.LENGTH_LONG).show()
    }
}

fun CrearEvento(context: Context){
    try{
        val intent = Intent(Intent.ACTION_INSERT).apply {
            data = Events.CONTENT_URI
            putExtra(Events.TITLE, "Dia de las madres")
            putExtra(CalendarContract.EXTRA_EVENT_ALL_DAY, true)
        }
        context.startActivity(intent)
    } catch (e: Exception) {
        Toast.makeText(context, "Error",
            Toast.LENGTH_LONG).show()
    }
}

fun VerArchivos(context: Context){
    try {
        val intent = Intent(Intent.ACTION_GET_CONTENT).apply {
            type = "*/*"
        }
        context.startActivity(intent)
    } catch (e: Exception) {
        Toast.makeText(context, "Error",
            Toast.LENGTH_LONG).show()
    }
}

fun Navegador(context: Context){
    val intent = Intent(context, SecondActivity::class.java)
    context.startActivity(intent)
}






