package amldev.kotlinandroidonlinecourse

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toast("Anartz")
    }

    private fun toast (name: String) {
        Toast.makeText(this, "Hola $name", Toast.LENGTH_LONG).show()
    }
}
