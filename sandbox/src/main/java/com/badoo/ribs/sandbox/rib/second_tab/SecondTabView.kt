package com.badoo.ribs.sandbox.rib.second_tab

import android.graphics.Color
import android.view.ViewGroup
import android.widget.FrameLayout
import com.badoo.ribs.core.view.AndroidRibView
import com.badoo.ribs.core.view.RibView
import com.badoo.ribs.core.view.ViewFactory
import com.badoo.ribs.core.view.ViewFactoryBuilder

interface SecondTabView : RibView {

    interface Factory : ViewFactoryBuilder<Nothing?, SecondTabView>
}


class SecondTabViewImpl private constructor(
    override val androidView: ViewGroup,
) : AndroidRibView(),
    SecondTabView {

    class Factory : SecondTabView.Factory {
        override fun invoke(deps: Nothing?): ViewFactory<SecondTabView> = ViewFactory {
            SecondTabViewImpl(
                FrameLayout(it.parent.context).apply {
                    setBackgroundColor(Color.GREEN)
                    layoutParams = FrameLayout.LayoutParams(
                        FrameLayout.LayoutParams.MATCH_PARENT,
                        1000
                    )
                }
            )
        }
    }
}
