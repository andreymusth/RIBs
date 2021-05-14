package com.badoo.ribs.sandbox.rib.first_tab

import com.badoo.ribs.builder.SimpleBuilder
import com.badoo.ribs.core.modality.BuildParams

class FirstTabBuilder : SimpleBuilder<FirstTab>() {

    override fun build(buildParams: BuildParams<Nothing?>): FirstTab {
        val customisation = buildParams.getOrDefault(FirstTab.Customisation())

        return node(
            buildParams = buildParams,
            customisation = customisation
        )
    }

    private fun node(
        buildParams: BuildParams<Nothing?>,
        customisation: FirstTab.Customisation
    ) = FirstTabNode(
            buildParams = buildParams,
            viewFactory = customisation.viewFactory(null),
            plugins = emptyList()
        )
}
