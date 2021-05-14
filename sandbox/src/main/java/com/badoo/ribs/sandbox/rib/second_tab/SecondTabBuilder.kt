package com.badoo.ribs.sandbox.rib.second_tab

import com.badoo.ribs.builder.SimpleBuilder
import com.badoo.ribs.core.modality.BuildParams


class SecondTabBuilder : SimpleBuilder<SecondTab>() {

    override fun build(buildParams: BuildParams<Nothing?>): SecondTab {
        val customisation = buildParams.getOrDefault(SecondTab.Customisation())

        return node(
            buildParams = buildParams,
            customisation = customisation
        )
    }

    private fun node(
        buildParams: BuildParams<Nothing?>,
        customisation: SecondTab.Customisation
    ) = SecondTabNode(
            buildParams = buildParams,
            viewFactory = customisation.viewFactory(null),
            plugins = emptyList()
        )
}
