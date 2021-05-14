package com.badoo.ribs.sandbox.rib.tabs_container

import android.view.ViewGroup
import com.badoo.ribs.core.Node
import com.badoo.ribs.core.view.RibView
import com.badoo.ribs.core.view.AndroidRibView
import com.badoo.ribs.sandbox.R
import com.badoo.ribs.sandbox.rib.first_tab.FirstTab
import com.badoo.ribs.sandbox.rib.second_tab.SecondTab
import com.badoo.ribs.sandbox.rib.tabs.Tabs

interface TabsContainerView : RibView


class TabsContainerViewImpl constructor(
    override val androidView: ViewGroup,
) : AndroidRibView(),
    TabsContainerView {

    private val tabsContainer: ViewGroup = findViewById<ViewGroup>(R.id.tabs_root)
    private val tabsContentContainer: ViewGroup = findViewById<ViewGroup>(R.id.tabs_content_root)

    override fun attachChild(child: Node<*>, subtreeOf: Node<*>) {
        val target = getParentViewForSubtree(child, subtreeOf)
        child.onCreateView(this)
        child.view?.let { target.addView(it.androidView) }
        child.onAttachToView()
        child.plugins<AndroidViewLifecycleAware>().forEach {
            it.onAttachToView(target)
        }
    }

    override fun detachChild(child: Node<*>, subtreeOf: Node<*>) {
        val target = getParentViewForSubtree(child, subtreeOf)
        child.view?.let { target.removeView(it.androidView) }
        child.onDetachFromView()
        child.plugins<AndroidViewLifecycleAware>().forEach {
            it.onDetachFromView(target)
        }
    }

    private fun getParentViewForSubtree(child: Node<*>, subtreeOf: Node<*>): ViewGroup =
        when (child) {
            is Tabs -> tabsContainer
            is FirstTab,
            is SecondTab -> tabsContentContainer
            else -> super.getParentViewForSubtree(subtreeOf)
        }
}
