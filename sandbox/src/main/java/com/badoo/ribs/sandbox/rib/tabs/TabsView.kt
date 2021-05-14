package com.badoo.ribs.sandbox.rib.tabs

import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import com.badoo.ribs.core.customisation.inflate
import com.badoo.ribs.core.view.AndroidRibView
import com.badoo.ribs.core.view.RibView
import com.badoo.ribs.core.view.ViewFactory
import com.badoo.ribs.core.view.ViewFactoryBuilder
import com.badoo.ribs.sandbox.R
import com.badoo.ribs.sandbox.rib.tabs.TabsView.Event
import com.jakewharton.rxrelay2.PublishRelay
import io.reactivex.ObservableSource

interface TabsView : RibView, ObservableSource<Event> {

    sealed class Event {

        object Tab1Clicked : Event()
        object Tab2Clicked : Event()
    }

    interface Factory : ViewFactoryBuilder<Nothing?, TabsView>
}


class TabsViewImpl private constructor(
    override val androidView: ViewGroup,
    private val events: PublishRelay<Event> = PublishRelay.create()
) : AndroidRibView(),
    TabsView,
    ObservableSource<Event> by events {

    class Factory(
        @LayoutRes private val layoutRes: Int = R.layout.rib_tabs
    ) : TabsView.Factory {
        override fun invoke(deps: Nothing?): ViewFactory<TabsView> = ViewFactory {
            TabsViewImpl(
                it.parent.inflate(layoutRes)
            )
        }
    }

    private val tab1: View = findViewById<View>(R.id.tab1).apply {
        setOnClickListener {
            events.accept(Event.Tab1Clicked)
        }
    }
    private val tab2: View = findViewById<View>(R.id.tab2).apply {
        setOnClickListener {
            events.accept(Event.Tab2Clicked)
        }
    }
}
