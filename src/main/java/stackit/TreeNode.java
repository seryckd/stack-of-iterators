package stackit;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class TreeNode<T> {

    T data_;
    TreeNode<T> parent_;
    List<TreeNode<T>> children_;

    public TreeNode(T data) {
        parent_ = null;
        data_ = data;
        children_ = new LinkedList<>();
    }

    public TreeNode<T> addChild(T child) {
        TreeNode<T> childNode = new TreeNode<>(child);
        childNode.parent_ = this;
        children_.add(childNode);
        return childNode;
    }

    public TreeNode<T> addLeaf(T child) {
        addChild(child);
        return this;
    }

    public T data() {
        return data_;
    }

    public Iterator<TreeNode<T>> children() {
        return children_.iterator();
    }

    public TreeNode<T> parent() {
        return parent_;
    }

    @Override
    public String toString() {
        return String.format("data:%s parent:%s",
                data_.toString(),
                parent_ == null ? "<none>" : parent_.data_.toString());
    }

    static class TreeNodeBuilder<T> {

        TreeNode<T> rootNode_;
        TreeNode<T> currentNode_;

        public TreeNodeBuilder(T root) {
            rootNode_ = new TreeNode<T>(root);
            currentNode_ = rootNode_;
        }

        public TreeNodeBuilder<T> leaf(T leaf) {
            currentNode_.addChild(leaf);
            return this;
        }

        public TreeNodeBuilder<T> child(T child) {
            currentNode_ = currentNode_.addChild(child);
            return this;
        }

        public TreeNodeBuilder<T> end() {
            currentNode_ = currentNode_.parent();
            return this;
        }

        public TreeNode<T> build() {
            return rootNode_;
        }
    }
}
