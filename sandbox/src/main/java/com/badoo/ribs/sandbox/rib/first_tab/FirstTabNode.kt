package com.badoo.ribs.sandbox.rib.first_tab

import com.badoo.ribs.clienthelper.connector.Connectable
import com.badoo.ribs.clienthelper.connector.NodeConnector
import com.badoo.ribs.core.modality.BuildParams
import com.badoo.ribs.core.plugin.Plugin
import com.badoo.ribs.core.view.ViewFactory
import com.badoo.ribs.rx2.workflows.RxWorkflowNode
import com.badoo.ribs.sandbox.rib.first_tab.FirstTab.Input
import com.badoo.ribs.sandbox.rib.first_tab.FirstTab.Output

class FirstTabNode internal constructor(
    buildParams: BuildParams<*>,
    viewFactory: ViewFactory<FirstTabView>,
    plugins: List<Plugin> = emptyList(),
    connector: NodeConnector<Input, Output> = NodeConnector()
) : RxWorkflowNode<FirstTabView>(
    buildParams = buildParams,
    viewFactory = viewFactory,
    plugins = plugins
), FirstTab, Connectable<Input, Output> by connector {

}
