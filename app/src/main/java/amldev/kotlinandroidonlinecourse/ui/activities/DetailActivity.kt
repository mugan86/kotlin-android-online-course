package amldev.kotlinandroidonlinecourse.ui.activities

import amldev.kotlinandroidonlinecourse.R
import amldev.kotlinandroidonlinecourse.data.MediaProvider
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class DetailActivity : AppCompatActivity() {

    companion object {
        val ID = "DetailActivity:id" // Para recuperarlo desde MainActivity
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val id = intent.getIntExtra(ID, -1)

        MediaProvider.dataAsync { media ->
            media.find { it.id == id }?.let { item ->
                // Al ser @Nullable tenemos que añadirle "?"
                supportActionBar?.title = item.title
            }
        }
    }
}
