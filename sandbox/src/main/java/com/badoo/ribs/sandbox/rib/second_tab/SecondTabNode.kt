package com.badoo.ribs.sandbox.rib.second_tab

import com.badoo.ribs.clienthelper.connector.Connectable
import com.badoo.ribs.clienthelper.connector.NodeConnector
import com.badoo.ribs.core.modality.BuildParams
import com.badoo.ribs.core.plugin.Plugin
import com.badoo.ribs.core.view.ViewFactory
import com.badoo.ribs.rx2.workflows.RxWorkflowNode
import com.badoo.ribs.sandbox.rib.second_tab.SecondTab.Input
import com.badoo.ribs.sandbox.rib.second_tab.SecondTab.Output

class SecondTabNode internal constructor(
    buildParams: BuildParams<*>,
    viewFactory: ViewFactory<SecondTabView>,
    plugins: List<Plugin> = emptyList(),
    connector: NodeConnector<Input, Output> = NodeConnector()
) : RxWorkflowNode<SecondTabView>(
    buildParams = buildParams,
    viewFactory = viewFactory,
    plugins = plugins
), SecondTab, Connectable<Input, Output> by connector
