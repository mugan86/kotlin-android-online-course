package amldev.kotlinandroidonlinecourse

import amldev.kotlinandroidonlinecourse.R.id.clearTextButton
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val yourName = "Anartz"
        toast(yourName)
        println("3 * 2 = ${getDuplicateInt(3)}")
        variableExamples()

        /**************************************************
         * Ejercicio variables: Demuestra lo que has aprendido sobre variables.
         * Recupera un TextView y cambia su texto por código.
         ******************************************************/
        //Recuperar el valor del textview que hemos añadido en el layout activity_main
        val text = findViewById(R.id.text) as TextView

        //Asignarle un nuevo valor, cambiando el texto mediante código
        text.text = "Hello $yourName"

        /***************************************************
         * String templates, añade un EditText y vete modificando el mensaje del toas
         * introduciendo nuevos valores
         */

        val editTextView = findViewById(R.id.inputValueEditText) as EditText
        editTextView.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {
                if (editTextView.length() > 6) {
                    toast(editTextView.text.toString())
                }
            }

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                println(editTextView.text)
            }
        })

        val clearTextButton = findViewById(clearTextButton) as ImageButton

        clearTextButton.setOnClickListener {
            editTextView.text.clear()
        }
    }
    /*
    Funcions Parte 1
     */
    private fun toast (name: String) {
        // String templates - Uso en un string
        Toast.makeText(this, "Hola $name, ¿Qué tal estás?", Toast.LENGTH_LONG).show()
    }

    /*
    Funciones - Parte 2

    En esta segunda parte, vas a aprender otras cosas interesantes sobre funciones.

    Verás por ejemplo, que en Kotlin las funciones siempre devuelven un objeto, y cuál es ese objeto que representa el void de Java.

    También descubrirás otra forma muy interesante de definir una función.
     */

    private fun getDuplicateInt(inputNumber: Int) = 2 * inputNumber

    // Variables, diferentes objectos de variable.

    private fun variableExamples() {
        val intBasicWithoutAssignType = 3
        val intBasicWithAssignType : Int = 4
        val longBasicWithoutAssignType = intBasicWithoutAssignType.toLong()
        val longBasicWithAssignType: Long = 4L
        val stringBasicWithoutAssignType = "Hello world!"
        val stringBasicWithAssignType : String = "Test string"

        println("*****************************************************************")
        println("intBasicWithoutAssignType = $intBasicWithoutAssignType")
        println("intBasicWithAssignType = $intBasicWithAssignType")
        println("longBasicWithoutAssignType = $longBasicWithoutAssignType")
        println("longBasicWithAssignType = $longBasicWithAssignType")
        println("stringBasicWithoutAssignType = $stringBasicWithoutAssignType")
        println("stringBasicWithAssignType = $stringBasicWithAssignType")
        println("*****************************************************************")
    }
}
