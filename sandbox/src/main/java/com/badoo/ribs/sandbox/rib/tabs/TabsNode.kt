package com.badoo.ribs.sandbox.rib.tabs

import com.badoo.ribs.core.modality.BuildParams
import com.badoo.ribs.core.plugin.Plugin
import com.badoo.ribs.core.view.ViewFactory
import com.badoo.ribs.rx2.clienthelper.connector.Connectable
import com.badoo.ribs.rx2.clienthelper.connector.NodeConnector
import com.badoo.ribs.rx2.workflows.RxWorkflowNode
import com.badoo.ribs.sandbox.rib.tabs.Tabs.Input
import com.badoo.ribs.sandbox.rib.tabs.Tabs.Output

class TabsNode internal constructor(
    buildParams: BuildParams<*>,
    viewFactory: ViewFactory<TabsView>,
    plugins: List<Plugin> = emptyList(),
    connector: NodeConnector<Input, Output> = NodeConnector()
) : RxWorkflowNode<TabsView>(
    buildParams = buildParams,
    viewFactory = viewFactory,
    plugins = plugins
), Tabs, Connectable<Input, Output> by connector