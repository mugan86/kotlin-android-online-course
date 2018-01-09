package amldev.kotlinandroidonlinecourse.ui.activities.detail

import amldev.kotlinandroidonlinecourse.R
import amldev.kotlinandroidonlinecourse.extensions.app
import amldev.kotlinandroidonlinecourse.extensions.hide
import amldev.kotlinandroidonlinecourse.extensions.loadImageUrl
import amldev.kotlinandroidonlinecourse.extensions.show
import amldev.kotlinandroidonlinecourse.ui.activities.detail.di.DetailModule
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detail.*
import javax.inject.Inject

class DetailActivity : AppCompatActivity(), DetailPresenter.View {

    companion object {
        val EXTRA_ID = "DetailActivity:id" // Para recuperarlo desde MainActivity
    }

    val component by lazy { app.component.plus(DetailModule(this)) }
    @Inject lateinit var presenter: DetailPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        component.inject(this)

        presenter.onCreate(intent.getLongExtra(EXTRA_ID, -1))
    }

    override fun setTitle(title: String) = run { supportActionBar?.title = title }

    override fun setImage(url: String) = detail_thumb.loadImageUrl(url)

    override fun setDetailIndicatorVisible(visible: Boolean) = with(detail_video_indicator) {
        if (visible) {
            show()
        } else {
            hide()
        }
    }
}
