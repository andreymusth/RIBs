package com.badoo.ribs.sandbox.rib.first_tab

import com.badoo.ribs.clienthelper.connector.Connectable
import com.badoo.ribs.core.Rib
import com.badoo.ribs.core.customisation.RibCustomisation
import com.badoo.ribs.sandbox.rib.first_tab.FirstTab.Input
import com.badoo.ribs.sandbox.rib.first_tab.FirstTab.Output

interface FirstTab : Rib, Connectable<Input, Output> {

    interface Dependency

    sealed class Input

    sealed class Output

    class Customisation(
        val viewFactory: FirstTabView.Factory = FirstTabViewImpl.Factory()
    ) : RibCustomisation
}
