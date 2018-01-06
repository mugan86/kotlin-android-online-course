package amldev.kotlinandroidonlinecourse.ui.activities

import amldev.kotlinandroidonlinecourse.R
import amldev.kotlinandroidonlinecourse.data.MediaProvider
import amldev.kotlinandroidonlinecourse.domain.models.MediaItem
import amldev.kotlinandroidonlinecourse.extensions.loadImageUrl
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.coroutines.experimental.bg

class DetailActivity : AppCompatActivity() {

    companion object {
        val ID = "DetailActivity:id" // Para recuperarlo desde MainActivity
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val id = intent.getIntExtra(ID, -1)

        //Apply Coroutines
        async(UI) {
            val cats = bg {MediaProvider.dataSync("cats")}
            cats.await().find { it.id == id }?.let { it ->
                // Al ser @Nullable tenemos que añadirle "?"
                supportActionBar?.title = it.title
                detail_thumb.loadImageUrl(it.thumbUrl)
                detail_video_indicator.visibility = when (it.type) {
                    MediaItem.Type.AUDIO -> View.GONE
                    MediaItem.Type.VIDEO -> View.VISIBLE
                }
            }
        }

        // Without use coroutines
        /*MediaProvider.dataAsync { media ->
            media.find { it.id == id }?.let { (_, title, thumbUrl, _, type) ->
                // Al ser @Nullable tenemos que añadirle "?"
                supportActionBar?.title = title
                detail_thumb.loadImageUrl(thumbUrl)
                detail_video_indicator.visibility = when (type) {
                    MediaItem.Type.AUDIO -> View.GONE
                    MediaItem.Type.VIDEO -> View.VISIBLE
                }
            }
        }*/
    }
}
