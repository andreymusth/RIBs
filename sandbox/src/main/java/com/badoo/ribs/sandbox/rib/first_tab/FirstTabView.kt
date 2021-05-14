package com.badoo.ribs.sandbox.rib.first_tab

import android.graphics.Color
import android.view.ViewGroup
import android.widget.FrameLayout
import com.badoo.ribs.core.view.AndroidRibView
import com.badoo.ribs.core.view.RibView
import com.badoo.ribs.core.view.ViewFactory
import com.badoo.ribs.core.view.ViewFactoryBuilder

interface FirstTabView : RibView {

    interface Factory : ViewFactoryBuilder<Nothing?, FirstTabView>
}


class FirstTabViewImpl private constructor(
    override val androidView: ViewGroup
) : AndroidRibView(),
    FirstTabView {

    class Factory(
    ) : FirstTabView.Factory {
        override fun invoke(deps: Nothing?): ViewFactory<FirstTabView> = ViewFactory {
            FirstTabViewImpl(
                FrameLayout(it.parent.context).apply {
                    setBackgroundColor(Color.BLUE)
                    layoutParams = FrameLayout.LayoutParams(
                        FrameLayout.LayoutParams.MATCH_PARENT,
                        1000
                    )
                }
            )
        }
    }
}
