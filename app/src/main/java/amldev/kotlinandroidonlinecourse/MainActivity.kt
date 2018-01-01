package amldev.kotlinandroidonlinecourse

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.*
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager

class MainActivity : AppCompatActivity(), Logger {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Usando una variable de otro fichero que no está en ninguna clase
        println(myVar)

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
        changeStartMsg(text, yourName)

        /***************************************************
         * String templates, añade un EditText y vete modificando el mensaje del toas
         * introduciendo nuevos valores
         */

        val editTextView = findViewById(R.id.inputValueEditText) as EditText
        editTextView.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {
                if (editTextView.length() > 6) {
                    toast(editTextView.text.toString())
                    changeStartMsg(text, editTextView.text.toString())
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

        val clearTextButton = findViewById(R.id.clearTextButton) as ImageButton

        clearTextButton.setOnClickListener {
            editTextView.text.clear()
            d("Clear value!!!")
        }

        //Hace la llamada a la función test del fichero amldev.kotlinandroidonlinecourse.Test.kt
        test()

        loadList()
    }

    private fun loadList() {
        val recyclerView = findViewById(R.id.recycler) as RecyclerView


        val itemsData = listOf<MediaItem>(
                MediaItem("Hesian: Zerotik", "https://i.ytimg.com/vi/E2lD-vp7n-I/maxresdefault.jpg", "G5SWPS9po74"),
                MediaItem("Rev Theory - Hell Yeah", "https://i.ytimg.com/vi/XGLvPYexRJ4/maxresdefault.jpg", "7LuSP4QaXiQ"),
                MediaItem("En Tol Sarmiento - Ametsetan", "http://entolsarmiento.com/wp-content/uploads/2014/11/portada.jpg", "LtDx3hb-KwI"),
                MediaItem("Hesian: Zerotik", "https://i.ytimg.com/vi/E2lD-vp7n-I/maxresdefault.jpg", "G5SWPS9po74"),
                MediaItem("Rev Theory - Hell Yeah", "https://i.ytimg.com/vi/XGLvPYexRJ4/maxresdefault.jpg", "7LuSP4QaXiQ"),
                MediaItem("En Tol Sarmiento - Ametsetan", "http://entolsarmiento.com/wp-content/uploads/2014/11/portada.jpg", "LtDx3hb-KwI"))


        // 2. set layoutManger
        recyclerView.layoutManager = LinearLayoutManager(this)
        // 3. create an adapter
        val mAdapter = MediaAdapter(itemsData)
        // 4. set adapter
        recyclerView.adapter = mAdapter
        // 5. set item animator to DefaultAnimator
        recyclerView.itemAnimator = DefaultItemAnimator()
    }
    /*
    Funcions Parte 1
     */
    private fun toast (name: String) {
        // String templates - Uso en un string
        Toast.makeText(this, "Hola $name, ¿Qué tal estás?", Toast.LENGTH_LONG).show()
    }

    private fun changeStartMsg(text: TextView, yourName: String) {
        text.text = "Hello $yourName"
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

interface Logger {
    val tag: String
        get() = javaClass.simpleName

    fun d(message: String) = Log.d(tag, message)
}
