package com.badoo.ribs.sandbox.rib.tabs_container

import androidx.lifecycle.Lifecycle
import com.badoo.mvicore.android.lifecycle.createDestroy
import com.badoo.mvicore.android.lifecycle.startStop
import com.badoo.ribs.clienthelper.interactor.Interactor
import com.badoo.ribs.core.Node
import com.badoo.ribs.core.modality.BuildParams
import com.badoo.ribs.routing.source.backstack.BackStack
import com.badoo.ribs.routing.source.backstack.operation.replace
import com.badoo.ribs.sandbox.rib.tabs.Tabs
import com.badoo.ribs.sandbox.rib.tabs_container.routing.TabsContainerRouter.Configuration
import io.reactivex.functions.Consumer

internal class TabsContainerInteractor(
    buildParams: BuildParams<*>,
    private val backStack: BackStack<Configuration>,
) : Interactor<TabsContainer, TabsContainerView>(
    buildParams = buildParams
) {

    override fun onCreate(nodeLifecycle: Lifecycle) {
        nodeLifecycle.createDestroy {
        }
    }

    override fun onViewCreated(view: TabsContainerView, viewLifecycle: Lifecycle) {
        viewLifecycle.startStop {
        }
    }

    override fun onChildBuilt(child: Node<*>) {
        child.lifecycle.createDestroy {
            when (child) {
                is Tabs -> bind(child.output to tabsOutputConsumer)
            }
        }
    }

    private val tabsOutputConsumer = Consumer<Tabs.Output> {
        when (it) {
            is Tabs.Output.Tab1Clicked -> {
                if (backStack.activeConfiguration is Configuration.Content.FirstTab) {

                } else {
                    backStack.replace(Configuration.Content.FirstTab)
                }
            }
            is Tabs.Output.Tab2Clicked -> {
                if (backStack.activeConfiguration is Configuration.Content.SecondTab) {

                } else {
                    backStack.replace(Configuration.Content.SecondTab)
                }
            }
        }
    }
}
