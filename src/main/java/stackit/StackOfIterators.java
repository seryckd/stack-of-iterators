package stackit;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Stack;
import java.util.function.Supplier;

public class StackOfIterators {

    // closure to remember where we were in the iterator
    static <T> Supplier<T> make(Iterator<T> i) {
        return () -> i.hasNext() ? i.next() : null;
    }

    public static <N> void search(TreeNode<N> root) {

        Stack<Supplier<TreeNode<N>>> stack = new Stack<>();

        stack.push(make(Collections.singletonList(root).iterator()));

        nextStack:
        while(!stack.empty()) {
            TreeNode<N> treeNode;
            while (!stack.empty() && (treeNode = stack.peek().get()) != null) {

                System.out.println(treeNode);

                stack.push(make(treeNode.children()));
                continue nextStack;
            }
            stack.pop();
        }
    }
}
