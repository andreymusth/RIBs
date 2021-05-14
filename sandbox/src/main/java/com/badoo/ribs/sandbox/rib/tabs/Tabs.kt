package com.badoo.ribs.sandbox.rib.tabs

import com.badoo.ribs.rx2.clienthelper.connector.Connectable
import com.badoo.ribs.core.Rib
import com.badoo.ribs.core.customisation.RibCustomisation

interface Tabs : Rib, Connectable<Tabs.Input, Tabs.Output> {

    sealed class Input

    sealed class Output {
        object Tab1Clicked : Output()
        object Tab2Clicked : Output()
    }

    class Customisation(
        val viewFactory: TabsView.Factory = TabsViewImpl.Factory()
    ) : RibCustomisation
}
