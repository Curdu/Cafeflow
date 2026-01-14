package com.curdu.cafeflow.a_views

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.curdu.cafeflow.b_viewmodels.LoginVM
import com.curdu.cafeflow.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding : ActivityLoginBinding
    private val loginViewModel : LoginVM by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        Thread.sleep(3000)
        installSplashScreen()


        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.loginButton.setOnClickListener {
            val nom = binding.usuariLoginEditText.text.toString()
            val contrasenya = binding.contrasenyaLoginEditText.text.toString()
            try {
                val usuari = loginViewModel.iniciarSessio(this,nom, contrasenya)
                val intent = Intent(this, MenuActivity::class.java)
                intent.putExtra("usuari_actiu", usuari)
                Log.println(Log.INFO, "Login", "Usuari $nom ha iniciat sessió correctament")
                Toast.makeText(this, "S'ha iniciat la sessió correctament", Toast.LENGTH_LONG).show()
                startActivity(intent)
            }catch (e : RuntimeException) {
                Log.println(Log.INFO, "Login", e.message.toString())
            }
        }

        binding.linkRegistrarText.setOnClickListener {
            val intent = Intent(this, RegistreActivity::class.java)
            startActivity(intent)
        }
    }
}