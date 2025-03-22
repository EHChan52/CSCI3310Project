package edu.cuhk.csci3310project

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import edu.cuhk.csci3310project.ui.theme.CSCI3310ProjectTheme

class MainActivity : ComponentActivity() {

    private val cameraPermission = android.Manifest.permission.CAMERA

    private val requestPermissionLauncher = registerForActivityResult(ActivityResultContracts.RequestPermission()){ isGranted ->
        if(isGranted){

        }
    }

    private fun requestCameraAndStartScanner(){
        if(isPermissionGranted(cameraPermission)){

        }else{
            requestCameraPermission()
        }
    }

    private fun requestCameraPermission(){
        when{
            shouldShowRequestPermissionRationale(cameraPermission) ->{
                cameraPermissionRequest {
                    openPermissionSetting()
                }
            }
            else -> {
                requestPermissionLauncher.launch(cameraPermission)
            }
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CSCI3310ProjectTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }

    @Composable
    fun Greeting(name: String, modifier: Modifier = Modifier) {
        Text(
            text = "Hello $name!",
            modifier = modifier
        )
    }

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        CSCI3310ProjectTheme {
            Greeting("Android")
        }
    }
}