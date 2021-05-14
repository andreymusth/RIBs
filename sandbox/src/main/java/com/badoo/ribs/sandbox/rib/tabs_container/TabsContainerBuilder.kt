@file:SuppressWarnings("LongParameterList")

package com.badoo.ribs.sandbox.rib.tabs_container

import com.badoo.ribs.builder.SimpleBuilder
import com.badoo.ribs.core.modality.BuildParams
import com.badoo.ribs.routing.source.RoutingSource
import com.badoo.ribs.routing.source.backstack.BackStack
import com.badoo.ribs.sandbox.rib.tabs_container.routing.TabsContainerChildBuilders
import com.badoo.ribs.sandbox.rib.tabs_container.routing.TabsContainerRouter
import com.badoo.ribs.sandbox.rib.tabs_container.routing.TabsContainerRouter.Configuration

class TabsContainerBuilder : SimpleBuilder<TabsContainer>() {

    override fun build(buildParams: BuildParams<Nothing?>): TabsContainer {
        val connections = TabsContainerChildBuilders()
        val customisation = buildParams.getOrDefault(TabsContainer.Customisation())
        val backStack = backStack(buildParams)
        val interactor = interactor(
            buildParams = buildParams,
            backStack = backStack
        )
        val router = router(
            buildParams = buildParams,
            routingSource = backStack,
            builders = connections,
            customisation = customisation
        )

        return node(
            buildParams = buildParams,
            interactor = interactor,
            router = router
        )
    }

    private fun backStack(buildParams: BuildParams<*>) =
        BackStack<Configuration>(
            buildParams = buildParams,
            initialConfiguration = Configuration.Content.Default
        )

    private fun interactor(
        buildParams: BuildParams<*>,
        backStack: BackStack<Configuration>,
    ) = TabsContainerInteractor(
        buildParams = buildParams,
        backStack = backStack
    )

    private fun router(
        buildParams: BuildParams<*>,
        routingSource: RoutingSource<Configuration>,
        builders: TabsContainerChildBuilders,
        customisation: TabsContainer.Customisation
    ) = TabsContainerRouter(
        buildParams = buildParams,
        builders = builders,
        routingSource = routingSource,
        transitionHandler = customisation.transitionHandler
    )

    private fun node(
        buildParams: BuildParams<*>,
        interactor: TabsContainerInteractor,
        router: TabsContainerRouter
    ) = TabsContainerNode(
        buildParams = buildParams,
        plugins = listOf(
            interactor,
            router
        )
    )
}
