package com.badoo.ribs.sandbox.rib.tabs

import androidx.lifecycle.Lifecycle
import com.badoo.mvicore.android.lifecycle.startStop
import com.badoo.mvicore.binder.using
import com.badoo.ribs.clienthelper.interactor.Interactor
import com.badoo.ribs.core.modality.BuildParams

internal class TabsInteractor(
    buildParams: BuildParams<*>
) : Interactor<Tabs, TabsView>(
    buildParams = buildParams
) {

    override fun onViewCreated(view: TabsView, viewLifecycle: Lifecycle) {
        viewLifecycle.startStop {
            bind(view to rib.output using ViewEventToOutput)
        }
    }

    private object ViewEventToOutput : (TabsView.Event) -> Tabs.Output {
        override fun invoke(event: TabsView.Event): Tabs.Output =
            when (event) {
                is TabsView.Event.Tab1Clicked -> Tabs.Output.Tab1Clicked
                is TabsView.Event.Tab2Clicked -> Tabs.Output.Tab2Clicked
            }
    }
}