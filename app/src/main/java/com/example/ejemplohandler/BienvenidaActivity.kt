package com.example.ejemplohandler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ejemplohandler.databinding.ActivityBienvenidaBinding
import com.example.ejemplohandler.databinding.ActivityMainBinding

class BienvenidaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBienvenidaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBienvenidaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //Si esta pantalla ha sifo lanzada producto de una intención
        // en un objeto llamado intenet queda ese registro para ser utilizado
        val mensaje = """
            El texto es: ${intent.getStringExtra("texto")},
            el número es ${intent.getIntExtra("valor",0)}
        """.trimIndent()
        binding.txtResultado.text = mensaje
    }
}