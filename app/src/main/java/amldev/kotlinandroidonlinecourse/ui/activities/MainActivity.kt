package amldev.kotlinandroidonlinecourse.ui.activities

import amldev.kotlinandroidonlinecourse.R
import amldev.kotlinandroidonlinecourse.data.getMediaItemsData
import amldev.kotlinandroidonlinecourse.extensions.toast
import amldev.kotlinandroidonlinecourse.ui.adapters.MediaAdapter
import amldev.kotlinandroidonlinecourse.ui.interfaces.Logger
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), Logger {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toast("Load Media Items!!")
        loadList()
    }

    private fun loadList() {
        // 1. set layoutManger
        recycler.layoutManager = LinearLayoutManager(this)
        // 2. create an adapter using GetMedia.kt data (root/data/GetMedia.kt)
        val mAdapter = MediaAdapter(getMediaItemsData())
        // 3. set adapter
        recycler.adapter = mAdapter
        // 4. set item animator to DefaultAnimator
        recycler.itemAnimator = DefaultItemAnimator()
    }
}
