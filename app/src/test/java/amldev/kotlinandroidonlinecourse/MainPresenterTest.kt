package amldev.kotlinandroidonlinecourse

import amldev.kotlinandroidonlinecourse.domain.models.MediaItem
import amldev.kotlinandroidonlinecourse.extensions.ListenerMediaItems
import amldev.kotlinandroidonlinecourse.ui.activities.main.MainPresenter
import amldev.kotlinandroidonlinecourse.ui.interfaces.Provider
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.argumentCaptor
import com.nhaarman.mockito_kotlin.mock
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

/**
 * Created by Anartz Mugika on 10/1/18.
 */
class MainPresenterTest {

    val view = mock<MainPresenter.View>()
    val provider = mock<Provider>()
    lateinit var presenter: MainPresenter

    @Before
    fun setUp() {
        presenter = MainPresenter(view, provider)
    }

    @Test
    fun providerIsCalledInOnCreate() {
        presenter.onCreate()
        Mockito.verify(provider).dataAsync(any())
    }

    @Test
    fun progressIsShownInOnCreate() {
        presenter.onCreate()
        Mockito.verify(view).showProgress()
    }

    @Test
    fun uiIsUpdatedWithResults() {
        presenter.onCreate()
        val media = mock<List<MediaItem>>()

        argumentCaptor<ListenerMediaItems>().apply {
            Mockito.verify(provider).dataAsync(capture())
            val f = allValues[0]
            f(media)

            Mockito.verify(view).updateData(media)
        }
    }

}