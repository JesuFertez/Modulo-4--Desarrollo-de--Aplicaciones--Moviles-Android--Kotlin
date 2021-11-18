package com.example.sharedpreferences

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sharedpreferences.databinding.ActivityMainBinding


private lateinit var binding: ActivityMainBinding
private lateinit var sharedPreferences: SharedPreferences

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        initSharedPreferences()
        setupClicListener()
        loadDefaultValues()
        mostrarvalores()
    }

    private fun mostrarvalores() {
        binding.run {

            var valorEntero = edtNumEntero.text
            var valorDecimal = edtDecimal.text
            var valorTexto = edtTexto.text

            tvMuestraEntero.setText("Valor entero almacenado : $valorEntero ")
            tvMuestraDecimal.setText("valor decimal Almacenado : $valorDecimal")
            tvMuestraTexto.setText("Texto almacenado : $valorTexto")
        }

    }

    private fun initSharedPreferences() {
        sharedPreferences = getSharedPreferences(
            SHARED_PREF_NAME,
            Context.MODE_PRIVATE
        )
    }

    private fun setupClicListener() {
        binding.run {
            btnGuardar.setOnClickListener {
                saveValues()
            }
            btnBorrar.setOnClickListener {
                deleteValues()
            }
        }
    }

    private fun loadDefaultValues() {
        val numeroEntero = sharedPreferences.getInt(NUMERO_ENTERO_KEY, 0)
        val numeroDecimal = sharedPreferences.getFloat(NUMERO_DECIMAL_KEY, 0.0f)
        val texto = sharedPreferences.getString(TEXTO_KEY, "")
        val switchValue = sharedPreferences.getBoolean(SWITCH_KEY, false)

        binding.edtNumEntero.setText(numeroEntero.toString())
        binding.edtDecimal.setText(numeroDecimal.toString())
        binding.switch1.isChecked = switchValue
        binding.edtTexto.setText(texto)

        mostrarvalores()
    }

    private fun deleteValues() {
        sharedPreferences.edit()
            .putString(TEXTO_KEY, "")
            .putInt(NUMERO_ENTERO_KEY, 0)
            .putFloat(NUMERO_DECIMAL_KEY, 0.0f)
            .putBoolean(SWITCH_KEY, false)
            .apply()
        loadDefaultValues()
        mostrarvalores()
    }

    private fun saveValues() {
        sharedPreferences.edit()
            .putString(TEXTO_KEY, binding.edtTexto.text.toString())
            .putInt(NUMERO_ENTERO_KEY, binding.edtNumEntero.text.toString().toInt())
            .putFloat(NUMERO_DECIMAL_KEY, binding.edtDecimal.text.toString().toFloat())
            .putBoolean(SWITCH_KEY, binding.switch1.isChecked)
            .apply()
        mostrarvalores()
    }


    companion object {
        private const val SHARED_PREF_NAME = "settings"
        private const val NUMERO_ENTERO_KEY = "numero-entero"
        private const val NUMERO_DECIMAL_KEY = "numero-decimal"
        private const val TEXTO_KEY = "texto"
        private const val SWITCH_KEY = "switch"
    }


}
