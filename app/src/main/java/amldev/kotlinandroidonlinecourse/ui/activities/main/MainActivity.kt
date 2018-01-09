package amldev.kotlinandroidonlinecourse.ui.activities.main

import amldev.kotlinandroidonlinecourse.R
import amldev.kotlinandroidonlinecourse.data.Filter
import amldev.kotlinandroidonlinecourse.domain.models.MediaItem
import amldev.kotlinandroidonlinecourse.extensions.app
import amldev.kotlinandroidonlinecourse.extensions.hide
import amldev.kotlinandroidonlinecourse.extensions.show
import amldev.kotlinandroidonlinecourse.ui.activities.detail.DetailActivity
import amldev.kotlinandroidonlinecourse.ui.activities.main.di.MainModule
import amldev.kotlinandroidonlinecourse.ui.adapters.MediaAdapter
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainPresenter.View {

    @Inject lateinit var presenter: MainPresenter

    val adapter = MediaAdapter { itemClicked(it) }
    val component by lazy { app.component.plus(MainModule(this)) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        component.inject(this)

        recycler.adapter = adapter
        presenter.onCreate()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val filter = when (item.itemId) {
            R.id.filter_all -> Filter.None()
            R.id.filter_audio -> Filter.ByType(MediaItem.Type.AUDIO)
            R.id.filter_videos -> Filter.ByType(MediaItem.Type.VIDEO)
            else -> null
        }

        filter?.let {
            presenter.filterClicked(filter)
            return true
        }

        return super.onOptionsItemSelected(item)
    }

    private fun itemClicked(item: MediaItem) {
        presenter.itemClicked(item)
    }

    override fun updateData(media: List<MediaItem>) {
        adapter.items = media
    }

    override fun showProgress() = progress.show()
    override fun hideProgress() = progress.hide()
    override fun navigateTo(id: Long) = startActivity<DetailActivity>(DetailActivity.EXTRA_ID to id)
}