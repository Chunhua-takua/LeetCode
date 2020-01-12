import java.util.ArrayList;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        ArrayList<Integer> resultP = new ArrayList<>();
        preorder(p, resultP);

        for (Integer i : resultP) {
            System.out.print(i + " ");
        }
        System.out.println();

        ArrayList<Integer> resultQ = new ArrayList<>();
        preorder(q, resultQ);

        for (Integer i : resultQ) {
            System.out.print(i + " ");
        }
        System.out.println();

        // Compare resultP & resultQ
        return compare(resultP, resultQ);
    }

    boolean compare(ArrayList<Integer> resultP, ArrayList<Integer> resultQ) {
        if (resultP.size() != resultQ.size()) {
            System.out.println("line45 false");
            return false;
        }

        int size = resultP.size();
        for (int i = 0; i < size; ++i) {
            if (resultP.get(i) == null && resultQ.get(i) == null) {
                continue;
            }
            else if (resultP.get(i) == null || resultQ.get(i) == null) {
                System.out.println("line54 false");
                return false;
            }

            // 注意：两个对象的比较一定要用 equals 方法
            if (!resultP.get(i).equals(resultQ.get(i))) {
                System.out.println("line59 false, i = " + i + ", numP = " + resultP.get(i)
                + ", numQ = " + resultQ.get(i));
                return false;
            }
        }

        return true;
    }

    void preorder(TreeNode root, ArrayList<Integer> result) {
        if (root == null) {
            result.add(null);
            return;
        }

        visit(root, result);

        preorder(root.left, result);
        preorder(root.right, result);
    }

    void visit(TreeNode root, ArrayList<Integer> result) {
        if (root == null) {
            result.add(null);
            return;
        }

        result.add(root.val);
    }
}

class Test {
    public static void main(String[] args) {
        Solution s = new Solution();


        // t1
        TreeNode r1 = new TreeNode(11211);
        TreeNode l = new TreeNode(2);
//        TreeNode r = new TreeNode(3);

        r1.left = l;
//        r1.right = r;

        // t2
        TreeNode r2 = new TreeNode(1);
//        TreeNode l1 = new TreeNode(2);
        TreeNode right1 = new TreeNode(2);

//        r2.left = l1;
        r2.right = right1;


        boolean result = s.isSameTree(r1, r1);
        System.out.println(result);
    }
}