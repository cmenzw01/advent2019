package advent

import java.util.*


class TreeNode<T>(data: T, parent: TreeNode<T>?) {
    var data: T
    val children: MutableList<TreeNode<T>> = ArrayList()
    var parent: TreeNode<T>?

    init {
        this.data = data
        this.parent = parent
    }

    fun addChild(child: TreeNode<T>) {
        child.parent = this
        children.add(child)
    }

    fun addChild(data: T) {
        val newChild = TreeNode(data, this)
        this.addChild(newChild)
    }

    fun addChildren(children: List<TreeNode<T>>) {
        for (t in children) {
            t.parent = this
        }
        this.children.addAll(children)
    }

//    fun getChildren(): List<TreeNode<*>> {
//        return children
//    }

//    fun setParent(parent: TreeNode<T>) {
//        this.parent = parent
//    }
}