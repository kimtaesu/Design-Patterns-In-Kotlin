import java.util.*
import javax.swing.tree.TreeNode

fun <T> TreeNode.findParentOfType(clazz: Class<T>): T? {
    var p = parent
    while (p != null && !clazz.isInstance(p)) {
        p = p.parent
    }
    @Suppress("UNCHECKED_CAST")
    return p as T?
}

fun main(ar: Array<String>) {
    val treeNode: TreeNode? = null
    treeNode?.findParentOfType(MyTreeNode::class.java)
}

class MyTreeNode : TreeNode {
    override fun isLeaf(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getChildCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getParent(): TreeNode {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getChildAt(childIndex: Int): TreeNode {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getIndex(node: TreeNode?): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getAllowsChildren(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun children(): Enumeration<*> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}

