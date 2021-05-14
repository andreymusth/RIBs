package com.badoo.ribs.sandbox.rib.tabs_container

import com.badoo.ribs.clienthelper.connector.Connectable
import com.badoo.ribs.clienthelper.connector.NodeConnector
import com.badoo.ribs.core.modality.BuildParams
import com.badoo.ribs.core.plugin.Plugin
import com.badoo.ribs.rx2.workflows.RxWorkflowNode
import com.badoo.ribs.sandbox.rib.tabs_container.TabsContainer.Input
import com.badoo.ribs.sandbox.rib.tabs_container.TabsContainer.Output

class TabsContainerNode internal constructor(
    buildParams: BuildParams<*>,
    plugins: List<Plugin> = emptyList(),
    connector: NodeConnector<Input, Output> = NodeConnector()
) : RxWorkflowNode<TabsContainerView>(
    buildParams = buildParams,
    viewFactory = null,
    plugins = plugins
), TabsContainer, Connectable<Input, Output> by connector