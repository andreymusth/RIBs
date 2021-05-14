package com.badoo.ribs.sandbox.rib.tabs_container.routing

import android.os.Parcelable
import com.badoo.ribs.core.modality.BuildParams
import com.badoo.ribs.routing.Routing
import com.badoo.ribs.routing.resolution.ChildResolution.Companion.child
import com.badoo.ribs.routing.resolution.Resolution
import com.badoo.ribs.routing.router.Router
import com.badoo.ribs.routing.source.RoutingSource
import com.badoo.ribs.routing.source.RoutingSource.Companion.permanent
import com.badoo.ribs.routing.transition.handler.TransitionHandler
import com.badoo.ribs.sandbox.rib.tabs_container.routing.TabsContainerRouter.Configuration
import kotlinx.android.parcel.Parcelize

class TabsContainerRouter internal constructor(
    buildParams: BuildParams<*>,
    routingSource: RoutingSource<Configuration>,
    private val builders: TabsContainerChildBuilders,
    transitionHandler: TransitionHandler<Configuration>? = null
) : Router<Configuration>(
    buildParams = buildParams,
    routingSource = routingSource + permanent(Configuration.Permanent.Tabs),
    transitionHandler = transitionHandler
) {
    sealed class Configuration : Parcelable {

        sealed class Permanent : Configuration() {

            @Parcelize
            object Tabs : Permanent()
        }

        sealed class Content : Configuration() {
            @Parcelize
            object Default : Content()

            @Parcelize
            object FirstTab : Content()

            @Parcelize
            object SecondTab : Content()
        }

    }

    override fun resolve(routing: Routing<Configuration>): Resolution =
        with(builders) {
            when (val configuration = routing.configuration) {
                is Configuration.Permanent.Tabs -> child { tabsBuilder.build(it) }
                is Configuration.Content.FirstTab -> child { firstTabBuilder.build(it) }
                is Configuration.Content.SecondTab -> child { secondTabBuilder.build(it) }
                is Configuration.Content.Default -> Resolution.noop()
            }
        }
}

