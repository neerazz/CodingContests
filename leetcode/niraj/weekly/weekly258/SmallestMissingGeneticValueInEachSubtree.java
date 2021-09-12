package weekly.weekly258;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

/**
 * Created on:  Sep 11, 2021
 * Ref:
 */
public class SmallestMissingGeneticValueInEachSubtree {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(smallestMissingValueSubtree(new int[]{-1, 0, 1, 0, 3, 3}, new int[]{5, 4, 6, 2, 1, 3})));
        System.out.println(Arrays.toString(smallestMissingValueSubtree(new int[]{-1,2,3,0,2,4,1}, new int[]{2,3,4,5,6,7,8})));
    }

    public static int[] smallestMissingValueSubtree(int[] parents, int[] nums) {
        int len = parents.length;
        Node[] nodes = new Node[len];
        for (int i = 0; i < len; i++) {
            nodes[i] = new Node(null, nums[i], i);
        }
        for(int i=0;i<len; i++){
//            link parents
            Node par = parents[i] == -1 ? null: nodes[parents[i]];
            if(par != null){
                par.deps.add(nodes[i]);
            }
        }
        int[] result = new int[len];
        dfs(nodes[0], result);
        return result;
    }

    private static TreeSet<Integer> dfs(Node node, int[] result) {
        TreeSet<Integer> cur = new TreeSet<>();
        if(node == null) return cur;
        for (Node dep : node.deps) {
            cur.addAll(dfs(dep, result));
        }
        cur.add(node.val);
        result[node.idx] = missing(cur);
        return cur;
    }

    private static int missing(TreeSet<Integer> set) {
        Integer first = set.first();
        if (first > 1) return 1;
        Integer last = set.last();
        if (set.size() == last - first + 1) return last + 1;
        for (int i = 1; i < last; i++) {
            if (!set.contains(i)) return i;
        }
        return Integer.MAX_VALUE;
    }

    static class Node {
        Node parent;
        List<Node> deps = new ArrayList<>();
        int val, idx;

        public Node(Node parent, int val, int idx) {
            this.parent = parent;
            this.val = val;
            this.idx = idx;
        }
    }
}
