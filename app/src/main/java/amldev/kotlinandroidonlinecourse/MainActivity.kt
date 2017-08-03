package amldev.kotlinandroidonlinecourse

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toast("Anartz")
        println("3 * 2 = ${getDuplicateInt(3)}")
        variableExamples()
    }
    /*
    Funcions Parte 1
     */
    private fun toast (name: String) {
        Toast.makeText(this, "Hola $name", Toast.LENGTH_LONG).show()
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
