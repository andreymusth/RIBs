package com.badoo.ribs.sandbox.rib.second_tab

import com.badoo.ribs.clienthelper.connector.Connectable
import com.badoo.ribs.core.Rib
import com.badoo.ribs.core.customisation.RibCustomisation
import com.badoo.ribs.sandbox.rib.second_tab.SecondTab.Input
import com.badoo.ribs.sandbox.rib.second_tab.SecondTab.Output

interface SecondTab : Rib, Connectable<Input, Output> {

    interface Dependency

    sealed class Input

    sealed class Output

    class Customisation(
        val viewFactory: SecondTabView.Factory = SecondTabViewImpl.Factory()
    ) : RibCustomisation
}
