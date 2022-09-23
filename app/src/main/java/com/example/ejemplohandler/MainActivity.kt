package com.example.ejemplohandler

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.ejemplohandler.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var myHandler: Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //Inicializar Handler
        myHandler = Handler(mainLooper)
        binding.btnIniciar.setOnClickListener{
            //pasarPantalla()
            cargarPantalla()
        }
    }

    //Proceso en segundo plano
    private fun cargarPantalla() {
        Thread {
            try {
                for (i in 0 .. 100){
                    Thread.sleep(500)
                    myHandler.post{
                        binding.apply {
                            txtPorcentaje.text = "$i %"
                            pbProgreso.progress = i
                        }
                    }
                }
            }catch (e: InterruptedException){
                e.printStackTrace()
            }
        }.start()
    }

    private fun pasarPantalla() {
        val mensaje = "Texto de Ejemplo"
        val numero = 10
        //Intent o intención para lanzar en la pantalla
        //Los datos se envían a través del archivo temporal llamado Extras
        val intent = Intent(this,BienvenidaActivity::class.java)
        intent.apply {
            putExtra("texto", mensaje)
            putExtra("valor", numero)
        }
        startActivity(intent)
    }
}