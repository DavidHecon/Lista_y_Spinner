package com.example.lista_y_spinner

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var spinner: Spinner
    private lateinit var textView: TextView
    private lateinit var translateButton: Button
    private var languages = arrayOf("México", "EUA", "China", "Rusia", "Corea", "Alemania", "Francia", "Holanda")
    private var selectedLanguage: String = "México" // Idioma por defecto

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        spinner = findViewById(R.id.spinner)
        textView = findViewById(R.id.textView)
        translateButton = findViewById(R.id.translate_button)

        val itemsAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, languages)
        spinner.adapter = itemsAdapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
                // No hacer nada si no se selecciona ningún idioma
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                selectedLanguage = languages[position]
            }
        }

        translateButton.setOnClickListener {
            val welcomeMessage = getWelcomeMessage(selectedLanguage)
            textView.text = getSelectMessage(selectedLanguage)
            showWelcomeDialog(welcomeMessage)
            // Traducir el texto del botón
            translateButton.text = getTranslateButtonText(selectedLanguage)
        }
    }

    private fun getWelcomeMessage(language: String): String {

        return when (language) {
            "México" -> "Bienvenido"
            "EUA" -> "Welcome!"
            "China" -> "欢迎!"
            "Rusia" -> "Добро пожаловать!"
            "Corea" -> "환영합니다!"
            "Alemania" -> "Willkommen!"
            "Francia" -> "Bienvenue!"
            "Holanda" -> "Welkom!"
            else -> "Bienvenido!" // Por defecto, inglés
        }
    }

    private fun getSelectMessage(language: String): String {
        return when (language) {
            "México" -> "¡Selecciona tu idioma!"
            "EUA" -> "Select your language!"
            "China" -> "选择您的语言!"
            "Rusia" -> "Выберите ваш язык!"
            "Corea" -> "언어를 선택하세요!"
            "Alemania" -> "Wählen Sie Ihre Sprache!"
            "Francia" -> "Sélectionnez votre langue!"
            "Holanda" -> "Selecteer uw taal!"
            else -> "¡Selecciona tu idioma!" // Por defecto, inglés
        }
    }

    private fun getTranslateButtonText(language: String): String {

        return when (language) {
            "México" -> "Traducir"
            "EUA" -> "Translate"
            "China" -> "翻译"
            "Rusia" -> "Перевод"
            "Corea" -> "번역"
            "Alemania" -> "Übersetzen"
            "Francia" -> "Traduire"
            "Holanda" -> "Vertalen"
            else -> "Traducir" // Por defecto, inglés
        }
    }

    private fun getTranslateEnlas(language: String): String {

        return when (language) {
            "México" -> "Continuar"
            "EUA" -> "Ok"
            "China" -> "翻译"
            "Rusia" -> "Перевод"
            "Corea" -> "번역"
            "Alemania" -> "Übersetzen"
            "Francia" -> "Traduire"
            "Holanda" -> "Vertalen"
            else -> "Continuar" // Por defecto, inglés
        }
    }

    private fun showWelcomeDialog(message: String) {
        AlertDialog.Builder(this)
            .setMessage(message)
            .setPositiveButton(getTranslateEnlas(selectedLanguage), null)
            .show()
    }


}