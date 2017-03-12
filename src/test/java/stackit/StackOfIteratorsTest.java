package stackit;

import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public class StackOfIteratorsTest {

    @Test
    public void search() throws Exception {

        TreeNode<String> root = new TreeNode.TreeNodeBuilder<>("root")
                .child("1")
                    .leaf("1-1")
                    .leaf("1-2")
                    .leaf("1-3")
                    .end()
                .leaf("2")
                .child("3")
                    .leaf("3-1")
                    .child("3-2")
                        .leaf("3-2-1")
                        .leaf("3-2-2")
                        .end()
                    .leaf("3-3")
                    .end()
                .build();

        StackOfIterators.search(root);
    }

}