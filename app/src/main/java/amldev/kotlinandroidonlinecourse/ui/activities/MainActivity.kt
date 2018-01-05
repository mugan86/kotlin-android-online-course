package amldev.kotlinandroidonlinecourse.ui.activities

import amldev.kotlinandroidonlinecourse.R
import amldev.kotlinandroidonlinecourse.data.Filter
import amldev.kotlinandroidonlinecourse.data.MediaProvider
import amldev.kotlinandroidonlinecourse.domain.models.MediaItem
import amldev.kotlinandroidonlinecourse.ui.adapters.MediaAdapter
import amldev.kotlinandroidonlinecourse.ui.interfaces.Logger
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.coroutines.experimental.bg
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity(), Logger {

    // create an adapter using GetMedia.kt data (root/data/GetMedia.kt)
    // Usar lambdas en el Adapter para mostrar lo que se ha declarado en dicha lambda (usando
    // la desestructurando la declaración mediaItem)
    val adapter = MediaAdapter { navigateToDetailItem(it)  }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadList()
    }

    private fun loadList() {

        // 1. set adapter (initialize before in top)
        recycler.adapter = adapter

        // 2. set item animator to DefaultAnimator
        recycler.itemAnimator = DefaultItemAnimator()

        loadFilterData(Filter.None())
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        // Aquí se filtran los cambios según nuestra selección
        val filter: Filter = when (item.itemId) {
            R.id.filter_all -> Filter.None()
            R.id.filter_videos -> Filter.ByType(MediaItem.Type.VIDEO)
            R.id.filter_audio -> Filter.ByType(MediaItem.Type.AUDIO)
            else -> Filter.None()
        }

        // Cargar los datos teniendo en cuenta el filtro
        loadFilterData(filter)

        return super.onOptionsItemSelected(item)
    }

    private fun loadFilterData(filter: Filter) {
        // Aquí se filtran los cambios según nuestra selección

        async(UI) {
            val cats = bg {MediaProvider.dataSync("cats")}
            val nature = bg {MediaProvider.dataSync( "nature")}
            recycler.scrollToPosition(0)
            adapter.items = when (filter) {
                is Filter.None -> cats.await() + nature.await()
                is Filter.ByType -> (cats.await() + nature.await()).filter { it.type == filter.type }
            }
        }
    }

    private fun navigateToDetailItem(item: MediaItem) {
        startActivity<DetailActivity>((DetailActivity.ID to item.id))
    }
}
