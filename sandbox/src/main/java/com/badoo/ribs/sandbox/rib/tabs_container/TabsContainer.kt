package com.badoo.ribs.sandbox.rib.tabs_container

import com.badoo.ribs.clienthelper.connector.Connectable
import com.badoo.ribs.core.Rib
import com.badoo.ribs.routing.transition.handler.TransitionHandler
import com.badoo.ribs.core.customisation.RibCustomisation
import com.badoo.ribs.routing.transition.handler.TabSwitcher
import com.badoo.ribs.sandbox.rib.tabs_container.TabsContainer.Input
import com.badoo.ribs.sandbox.rib.tabs_container.TabsContainer.Output
import com.badoo.ribs.sandbox.rib.tabs_container.routing.TabsContainerRouter
import com.badoo.ribs.sandbox.rib.tabs_container.routing.TabsContainerRouter.Configuration.Content

interface TabsContainer : Rib, Connectable<Input, Output> {

    interface Dependency

    sealed class Input

    sealed class Output

    class Customisation(
        val transitionHandler: TransitionHandler<TabsContainerRouter.Configuration> =
            TabSwitcher(
                tabsOrder = listOf(Content.FirstTab, Content.SecondTab)
            )
    ) : RibCustomisation
}
