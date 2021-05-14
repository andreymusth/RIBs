package com.badoo.ribs.sandbox.rib.tabs

import com.badoo.ribs.builder.SimpleBuilder
import com.badoo.ribs.core.modality.BuildParams

class TabsBuilder : SimpleBuilder<Tabs>() {

    override fun build(buildParams: BuildParams<Nothing?>): Tabs {
        val customisation = buildParams.getOrDefault(Tabs.Customisation())
        val interactor = TabsInteractor(buildParams)

        return node(
            buildParams = buildParams,
            customisation = customisation,
            interactor = interactor
        )
    }

    private fun node(
        buildParams: BuildParams<Nothing?>,
        customisation: Tabs.Customisation,
        interactor: TabsInteractor
    ) = TabsNode(
        buildParams = buildParams,
        viewFactory = customisation.viewFactory(null),
        plugins = listOf(
            interactor
        )
    )
}
