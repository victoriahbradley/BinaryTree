import java.util.ArrayList;
import java.util.*;

/**
 * An Integer Binary Search Tree
 * @author: Your Name Here
 * @version: Date
 */

public class BST {
    private BSTNode root;

    public BSTNode getRoot() {
        return this.root;
    }

    public void setRoot(BSTNode root) {
        this.root = root;
    }

    /**
     * Sets up a binary search tree
     * with some default values
     */
    public void setupTestData() {
        this.root = new BSTNode(10);
        this.root.setLeft(new BSTNode(5));
        this.root.setRight(new BSTNode((15)));
        this.root.getLeft().setLeft(new BSTNode(3));
        this.root.getLeft().setRight(new BSTNode(9));
    }

    /**
     * Prints the provided ArrayList of nodes
     * in the form node1-node2-node3
     * @param nodes ArrayList of BSTNodes
     */
    public static void printNodes(ArrayList<BSTNode> nodes) {
        for(int i=0; i<nodes.size()-1; i++) {
            System.out.print(nodes.get(i) + "-");
        }
        System.out.println(nodes.get(nodes.size()-1));
    }

    /**
     * A function that searches for a value in the tree
     * @param val integer value to search for
     * @return true if val is in the tree, false otherwise
     */
    public boolean search(int val) {
        // TODO: Complete the search function
        ArrayList<BSTNode> treeOrder = new ArrayList<BSTNode>();
        treeOrder = getInorder();
        for (int i = 0; i < treeOrder.size(); i++)
        {
            for (BSTNode node : treeOrder)
            {
                if (val == node.getVal())
                {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @return ArrayList of BSTNodes in inorder
     */

    // inorder = left, root, right
    public ArrayList<BSTNode> getInorder() {
        // TODO: Complete inorder traversal
        Stack<BSTNode> order = new Stack<BSTNode>();
        ArrayList<BSTNode> finalOrder = new ArrayList<BSTNode>();
        if (root == null)
        {
            return finalOrder;
        }
        BSTNode currentRoot = root;
        order.push(currentRoot);
        while (!order.isEmpty())
        {
            while (currentRoot != null)
            {
                order.push(currentRoot);
                currentRoot = currentRoot.getLeft();
            }

            currentRoot = order.pop();
            finalOrder.add(currentRoot);

            currentRoot = currentRoot.getRight();

        }
        return finalOrder;
    }

    /**
     * @return ArrayList of BSTNodes in preorder
     */

    // preorder = root, left, right
    public ArrayList<BSTNode> getPreorder() {
        // TODO: Complete preorder traversal
        Stack<BSTNode> order = new Stack<BSTNode>();
        ArrayList<BSTNode> finalOrder = new ArrayList<BSTNode>();
        if (root == null)
        {
            return finalOrder;
        }
        BSTNode currentRoot = root;
        order.push(currentRoot);

        while (!order.isEmpty())
        {
            currentRoot = order.pop();
            finalOrder.add(currentRoot);

            if (currentRoot.getRight() != null)
            {
                order.push(currentRoot.getRight());
            }
            if (currentRoot.getLeft() != null)
            {
                order.push(currentRoot.getLeft());
            }
            while (currentRoot != null)
            {
                order.push(currentRoot);
                currentRoot = currentRoot.getLeft();
            }

            currentRoot = order.pop();
            finalOrder.add(currentRoot);

            currentRoot = currentRoot.getRight();

        }
        return finalOrder;
    }

    /**
     * @return ArrayList of BSTNodes in postorder
     */

    // postorder = left, right, root
    public ArrayList<BSTNode> getPostorder() {
        // TODO: Complete postorder traversal
        Stack<BSTNode> order = new Stack<BSTNode>();
        ArrayList<BSTNode> finalOrder = new ArrayList<BSTNode>();
        if (root == null)
        {
            return finalOrder;
        }
        BSTNode currentRoot = root;
        order.push(currentRoot);

        while (!order.isEmpty())
        {
            currentRoot = order.pop();
            finalOrder.add(currentRoot);

            if (currentRoot.getLeft() != null)
            {
                order.push(currentRoot.getRight());
            }
            if (currentRoot.getRight() != null)
            {
                order.push(currentRoot.getLeft());
            }
            while (currentRoot != null)
            {
                order.push(currentRoot);
                currentRoot = currentRoot.getLeft();
            }

            currentRoot = order.pop();
            finalOrder.add(currentRoot);

            currentRoot = currentRoot.getRight();

        }
        return finalOrder;
    }

    /**
     * Inserts the given integer value to the tree
     * if it does not already exist. Modifies the
     * root instance variable to be the root of the new modified tree.
     * @param val The value ot insert
     */
    public void insert(int val) {
        // TODO: Complete insert
        ArrayList<BSTNode> tree = getInorder();
        for (BSTNode node : tree)
        {
            if(node.getVal() > val)
            {
                BSTNode newN = node;
                tree.add(newN);
            }
        }

    }

    /**
     * Determines if the current BST is
     * a valid BST.
     * @return true if valid false otherwise
     */
    public boolean isValidBST() {
        // TODO: Optional Challenge!
        return false;
    }

    public static void main(String[] args) {
        // Tree to help you test your code
        BST tree = new BST();
        tree.setupTestData();

        System.out.println("\nSearching for 15 in the tree");
        System.out.println(tree.search(15));

        System.out.println("\nSearching for 22 in the tree");
        System.out.println(tree.search(22));

        System.out.println("\nPreorder traversal of binary tree is");
        ArrayList<BSTNode> sol = tree.getPreorder();
        printNodes(sol);

        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);

        System.out.println("\nPostorder traversal of binary tree is");
        sol = tree.getPostorder();
        printNodes(sol);

        tree.insert(8);
        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);
    }
}
