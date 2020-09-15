package demo;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i == j) {
                    continue;
                }
                if (nums[i] + nums[j] == target) {
                    int[] ints = new int[2];
                    ints[0] = i;
                    ints[1] = j;
                    return ints;
                }
            }
        }
        return null;
    }

    public static List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> list = new ArrayList<>();
        String pingjie = "";
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i == j) {
                    continue;
                }
                pingjie = words[i] + words[j];
                int m = 0, n = pingjie.length() - 1;
                for (; m < n; m++, n--) {
                    if (pingjie.charAt(m) != pingjie.charAt(n)) {
                        break;
                    }
                }
                if (m > n || words[i] == "" || words[j] == "") {
                    ArrayList<Integer> integers = new ArrayList<>();
                    integers.add(i);
                    integers.add(j);
                    list.add(integers);
                }
            }
        }
        return list;
    }

    public static class ListNode {

        int val;

        ListNode next;

        ListNode() {
        }

        ListNode(int x) {
            val = x;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode(0);
        ListNode newNode = listNode;
        int decade = 0;
        while (l1 != null || l2 != null) {
            int x = l1 != null ? l1.val : 0;
            int y = l2 != null ? l2.val : 0;
            int sum = decade + x + y;
            newNode.next = new ListNode(sum % 10);
            newNode = newNode.next;
            decade = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (decade > 0) {
            newNode.next = new ListNode(decade);
        }
        return listNode.next;
    }

    public static ListNode addTwoNumbersV2(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode(0);
        ListNode newNode = listNode;
        int decade = 0;
        while (l1 != null || l2 != null) {
            int x = l1 != null ? l1.val : 0;
            int y = l2 != null ? l2.val : 0;
            int sum = decade + x + y;
            newNode.next = new ListNode(sum % 10);
            newNode = newNode.next;
            decade = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (decade > 0) {
            newNode.next = new ListNode(decade);
        }
        return listNode.next;
    }

    public static class
    TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        int max = 1;
        int x = 0;
        for (int i = 0, j = 0; i < s.length(); i++) {
            String sum = String.valueOf(s.charAt(i));
            boolean b = true;
            for (j = i; j < s.length(); j++) {
                if (i == j) {
                    continue;
                }
                if (sum.contains(String.valueOf(s.charAt(j)))) {
                    break;
                }
                sum += String.valueOf(s.charAt(j));
            }
            System.out.printf(String.valueOf(i));
            System.out.printf(String.valueOf(j));
            System.out.println();
            x = j - i;
            max = Math.max(x, max);
        }
        return max;
    }

    public static int countBinarySubstrings(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        } else if (s.length() <= 2) {
            return 1;
        }
        int[] ints = new int[s.length()];
        char c = s.charAt(0);
        int length = s.length();
        for (int i = 0, j = 0, k = 0; i < length; i++) {
            if (c == s.charAt(i)) {
                k++;

            } else {
                ints[j] = k;
                j++;
                k = 1;
                c = s.charAt(i);
            }

            if (i == s.length() - 1) {
                ints[j] = k;
            }
        }
        int count = 0;
        int j = ints[0];
        for (int i : ints) {
            count += Math.min(j, i);
            j = i;
        }
        return count -= ints[0];
    }

    class Foo {
        public int count = 0;

        public Foo() {

        }

        public void first(Runnable printFirst) throws InterruptedException {

            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            count++;
            printFirst.notify();
        }

        public void second(Runnable printSecond) throws InterruptedException {
            if (count != 1) {
                printSecond.wait();
            }
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            count++;
            printSecond.notify();
        }

        public void third(Runnable printThird) throws InterruptedException {
            if (count != 2) {
                printThird.wait();
            }
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
            count++;
            printThird.notify();
        }
    }

    int m, n;

    public void solve(char[][] board) {
        n = board.length;
        if (n == 0) {
            return;
        }
        m = board[0].length;
        for (int i = 0; i < n; i++) {
            dfs(board, i, 0);
            dfs(board, i, m - 1);
        }
        for (int i = 1; i < m - 1; i++) {
            dfs(board, 0, i);
            dfs(board, n - 1, i);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void dfs(char[][] board, int x, int y) {
        if (x < 0 || x >= n || y < 0 || y >= m || board[x][y] != 'O') {
            return;
        }
        board[x][y] = 'A';
        dfs(board, x + 1, y);
        dfs(board, x - 1, y);
        dfs(board, x, y + 1);
        dfs(board, x, y - 1);
    }

    public static void chaoJiMaLi() {
        System.out.println("                ********");
        System.out.println("               ************");
        System.out.println("               ####....#.");
        System.out.println("             #..###.....##....");
        System.out.println("             ###.......######              ###            ###");
        System.out.println("                ...........               #...#          #...#");
        System.out.println("               ##*#######                 #.#.#          #.#.#");
        System.out.println("            ####*******######             #.#.#          #.#.#");
        System.out.println("           ...#***.****.*###....          #...#          #...#");
        System.out.println("           ....**********##.....           ###            ###");
        System.out.println("           ....****    *****....");
        System.out.println("             ####        ####");
        System.out.println("           ######        ######");
        System.out.println("##############################################################");
        System.out.println("#...#......#.##...#......#.##...#......#.##------------------#");
        System.out.println("###########################################------------------#");
        System.out.println("#..#....#....##..#....#....##..#....#....#####################");
        System.out.println("##########################################    #----------#");
        System.out.println("#.....#......##.....#......##.....#......#    #----------#");
        System.out.println("##########################################    #----------#");
        System.out.println("#.#..#....#..##.#..#....#..##.#..#....#..#    #----------#");
        System.out.println("##########################################    ############");
    }

    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraph(Node node) {
        if (node == null) {
            return node;
        }

        HashMap<Node, Node> visited = new HashMap();

        // 将题目给定的节点添加到队列
        LinkedList<Node> queue = new LinkedList<Node>();
        queue.add(node);
        // 克隆第一个节点并存储到哈希表中
        visited.put(node, new Node(node.val, new ArrayList()));

        // 广度优先搜索
        while (!queue.isEmpty()) {
            // 取出队列的头节点
            Node n = queue.remove();
            // 遍历该节点的邻居
            for (Node neighbor : n.neighbors) {
                if (!visited.containsKey(neighbor)) {
                    // 如果没有被访问过，就克隆并存储在哈希表中
                    visited.put(neighbor, new Node(neighbor.val, new ArrayList()));
                    // 将邻居节点加入队列中
                    queue.add(neighbor);
                }
                // 更新当前节点的邻居列表
                visited.get(n).neighbors.add(visited.get(neighbor));
            }
        }

        return visited.get(node);
    }

    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for (int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static int[][] stringToInt2dArray(String input) {
//        JsonArray jsonArray = JsonArray.readFrom(input);
//        if (jsonArray.size() == 0) {
//            return new int[0][0];
//        }

//        int[][] arr = new int[jsonArray.size()][];
//        for (int i = 0; i < arr.length; i++) {
//            JsonArray cols = jsonArray.get(i).asArray();
//            arr[i] = stringToIntegerArray(cols.toString());
//        }
        return null;
    }

    public static String treeNodeToString(TreeNode root) {
        if (root == null) {
            return "[]";
        }

        String output = "";
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (node == null) {
                output += "null, ";
                continue;
            }

            output += String.valueOf(node.val) + ", ";
            nodeQueue.add(node.left);
            nodeQueue.add(node.right);
        }
        return "[" + output.substring(0, output.length() - 2) + "]";
    }

    public static String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        } else if (s.length() == 1) {
            return s;
        }

        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = longCount(s, i, i);
            int len2 = longCount(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    public static int longCount(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    public static String multiply(String num1, String num2) {
        if (num1 == null || num2 == null || num1.isEmpty() || num2.isEmpty()) {
            return "";
        } else if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        StringBuffer stringBuffer1 = new StringBuffer(num1).reverse();
        StringBuffer stringBuffer2 = new StringBuffer(num2).reverse();

        if (stringBuffer1.length() > stringBuffer2.length()) {
            return addTwoString(stringBuffer2, stringBuffer1);
        } else {
            return addTwoString(stringBuffer1, stringBuffer2);
        }
    }

    public static String addTwoString(StringBuffer stringBuffer1, StringBuffer stringBuffer2) {
        List<ListNode> list = new ArrayList<>();
        for (int i = 0; i < stringBuffer1.length(); i++) {
            int j = 0, k = i;
            Integer s = 0;
            ListNode listNode = new ListNode(0);
            ListNode newNode = listNode;
            while (k > 0) {
                newNode.next = new ListNode(0);
                newNode = newNode.next;
                k--;
            }
            while (true) {
                Integer num11 = 0;
                Integer num22 = 0;
                Integer num33 = 0;
                if (j < stringBuffer2.length()) {
                    num11 = Integer.valueOf(stringBuffer2.substring(j, j + 1));
                    num22 = Integer.valueOf(stringBuffer1.substring(i, i + 1));
                }
                num33 = num11 * num22 + s;
                newNode.next = new ListNode(num33 % 10);
                newNode = newNode.next;
                s = num33 / 10;
                j++;
                if (s == 0 && j >= stringBuffer2.length()) {
                    break;
                }
            }
            list.add(listNode.next);
        }
        ListNode listNode = list.get(0);
        for (int n = 1; n < list.size(); n++) {
            listNode = addTwoNumbersV2(listNode, list.get(n));
        }
        String num = "";
        while (listNode != null) {
            num += listNode.val;
            listNode = listNode.next;
        }
        return new StringBuffer(num).reverse().toString();
    }

    public static boolean isValid(String s) {
        if (s == null || s.isEmpty()) {
            return false;
        } else if (s.length() % 2 == 1) {
            return false;
        } else if (s.length() == 2) {
            if ('(' == s.charAt(0) && ')' == s.charAt(1)) {
                return true;
            } else if ('[' == s.charAt(0) && ']' == s.charAt(1)) {
                return true;
            } else if ('{' == s.charAt(0) && '}' == s.charAt(1)) {
                return true;
            }
        }
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                if (stack.isEmpty() || !stack.peek().equals(map.get(s.charAt(i)))) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }
        return stack.isEmpty();
    }

    public static int intReverse(int x) {
        long result = 0;
        while (x != 0) {
            result = (result * 10) + (x % 10);
            x = x / 10;
        }
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) result;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode();
        ListNode newNode = listNode;
        while (l1 != null || l2 != null) {
            int x = l1 != null ? l1.val : Integer.MAX_VALUE;
            int y = l2 != null ? l2.val : Integer.MAX_VALUE;
            if (x < y) {
                newNode.next = new ListNode(x);
                newNode = newNode.next;


                l1 = l1.next;
            } else {
                newNode.next = new ListNode(y);
                newNode = newNode.next;
                l2 = l2.next;
            }
        }
        return listNode.next;
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return null;
        }
        List<List<Integer>> list = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if ((nums[i] + nums[j] + nums[k]) == 0) {
                        List<Integer> integerList = new ArrayList<>();
                        integerList.add(nums[i]);
                        integerList.add(nums[j]);
                        integerList.add(nums[k]);
                        set.add(integerList);
                    }
                }
            }
        }
        list.addAll(set);
        return list;
    }

    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private static int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(height(root.left), height(root.right)) + 1;
    }

    public static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }

        String[] parts = input.split(",");
        String item = parts[0];
        int i = Integer.parseInt(!"null".equals(item) ? item : "0");
        TreeNode root;
        if (i == 0) {
            root = new TreeNode();
        } else {
            root = new TreeNode(i);
        }
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }

    public TreeNode sortedListToBST(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        ListNode listNode = head;
        while (listNode != null) {
            list.add(listNode);
            listNode = listNode.next;
        }
        return middle(list);
    }

    public static TreeNode middle(List<ListNode> list) {
        if (list.isEmpty()) {
            return null;
        }
        if (list.size() == 1) {
            return new TreeNode(list.get(0).val);
        }
        int len = list.size();
        TreeNode treeNode = new TreeNode(list.get(len / 2).val);
        treeNode.left = middle(list.subList(0, len / 2));
        treeNode.right = middle(list.subList(len / 2 + 1, len));
        return treeNode;
    }

    /**
     * @Author DukeWei
     * @Description 字符串中包含多少回文子串
     * @Date 2020/8/19 15:37
     **/
    public static int countSubstrings(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        } else if (s.length() == 1) {
            return 1;
        }

        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += countPalindrome(s, i, i);
            count += countPalindrome(s, i, i + 1);
        }
        return count;
    }

    public static int countPalindrome(String s, int i, int j) {
        int count = 0;
        int start = i, end = j;
        while (start >= 0 && end < s.length()) {
            if (s.charAt(start) == s.charAt(end)) {
                count++;
                start--;
                end++;
            } else {
                break;
            }
        }
        return count;
    }

    static int[] dirX = {0, 1, 0, -1, 1, 1, -1, -1};
    static int[] dirY = {1, 0, -1, 0, 1, -1, 1, -1};

    public static char[][] updateBoard(char[][] board, int[] click) {
        int x = click[0];
        int y = click[1];
        if (board[x][y] == 'M') {
            board[x][y] = 'X';
            return board;
        }
        updateBoard(board, x, y);
        return board;
    }

    public static void updateBoard(char[][] board, int x, int y) {
        int count = 0;
        for (int i = 0; i < dirX.length; i++) {
            int tx = x + dirX[i];
            int ty = y + dirY[i];
            if (tx < 0 || ty < 0 || tx >= board.length || ty >= board[0].length) {
                continue;
            }
            if (board[tx][ty] == 'M') {
                count++;
            }
        }
        if (count > 0) {
            board[x][y] = (char) (count + '0');
        } else {
            board[x][y] = 'B';
            for (int i = 0; i < 8; ++i) {
                int tx = x + dirX[i];
                int ty = y + dirY[i];
                if (tx < 0 || ty < 0 || tx >= board.length || ty >= board[0].length) {
                    continue;
                }
                if (board[tx][ty] != 'E') {
                    continue;
                }
                updateBoard(board, tx, ty);
            }
        }
    }

    public static int minDepth(TreeNode root) {
        if (root == null) return 0;
        //这道题递归条件里分为三种情况
        //1.左孩子和有孩子都为空的情况，说明到达了叶子节点，直接返回1即可
        if (root.left == null && root.right == null) {
            return 1;
        }
        //2.如果左孩子和由孩子其中一个为空，那么需要返回比较大的那个孩子的深度
        int m1 = minDepth(root.left);
        int m2 = minDepth(root.right);
        //这里其中一个节点为空，说明m1和m2有一个必然为0，所以可以返回m1 + m2 + 1;
        if (root.left == null || root.right == null) {
            return m1 + m2 + 1;
        }

        //3.最后一种情况，也就是左右孩子都不为空，返回最小深度+1即可
        return Math.min(m1, m2) + 1;
    }

//    public static void main(String[] args) {
//        TreeNode treeNode = new TreeNode(1);
//        treeNode.right = new TreeNode(2);
//        System.out.println(minDepth(treeNode));
//    }

//    public static int minDepth(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//
//        if (root.left == null && root.right == null) {
//            return 1;
//        }
//
//        int min_depth = Integer.MAX_VALUE;
//        if (root.left != null) {
//            min_depth = Math.min(minDepth(root.left), min_depth);
//        }
//        if (root.right != null) {
//            min_depth = Math.min(minDepth(root.right), min_depth);
//        }
//
//        return min_depth + 1;
//    }

    /**
     * @Author DukeWei
     * @Description 运行时间过长
     * @Date 2020/8/24 9:44
     **/
    public static boolean repeatedSubstringPatternError(String s) {
        if (s == null || s.length() == 1) {
            return false;
        }
        for (int i = 1; i < s.length(); i++) {
            String[] split = s.split(s.substring(i));
            if (split.length == 0) {
                return true;
            }
        }
        return false;
    }

    public static boolean repeatedSubstringPattern(String s) {
        return (s + s).indexOf(s, 1) != s.length();
    }


    public static List<List<Integer>> res = new ArrayList<List<Integer>>();
    public static List<Integer> temp = new ArrayList<>();

    public static List<List<Integer>> findSubsequences(int[] nums) {
        if (nums == null) {
            return null;
        }
        dfs(0, Integer.MIN_VALUE, nums);
        return res;
    }

    private static void dfs(int curIndex, int preValue, int[] nums) {
        if (curIndex >= nums.length) {  // 遍历结束
            if (temp.size() >= 2) {
                res.add(new ArrayList<>(temp));
            }
            return;
        }

        if (nums[curIndex] >= preValue) {   // 将当前元素加入，并向后遍历
            temp.add(nums[curIndex]);
            dfs(curIndex + 1, nums[curIndex], nums);
            temp.remove(temp.size() - 1);
        }
        if (nums[curIndex] != preValue) {   // 不遍历 重复元素
            dfs(curIndex + 1, preValue, nums);  // 将下一个元素加入，并向后遍历
        }
    }

    public static List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return list;
        }
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        if (digits.length() == 1) {
            String charAt = map.get(digits.charAt(0));
            for (int i = 0; i < charAt.length(); i++) {
                list.add(charAt.substring(i, i + 1));
            }
            return list;
        }
        String charAt = map.get(digits.charAt(0));
        for (int i = 0; i < charAt.length(); i++) {
            list.add(charAt.substring(i, i + 1));
        }
        int i = 1;
        while (i < digits.length()) {
            list = letterCombinations(list, map.get(digits.charAt(i)));
            i++;
        }
        return list;
    }

    public static List<String> letterCombinations(List<String> list, String s) {
        List<String> newList = new ArrayList<>();
        for (String str : list) {
            for (int i = 0; i < s.length(); i++) {
                newList.add(str + s.substring(i, i + 1));
            }
        }
        return newList;
    }

    public static boolean judgeCircle(String moves) {
        if (moves == null || moves.length() == 0) {
            return true;
        }
        int[] coordinate = {0, 0};
        for (int i = 0; i < moves.length(); i++) {
            String str = moves.substring(i, i + 1);
            switch (str) {
                case "R":
                    coordinate[0] += 1;
                    break;
                case "L":
                    coordinate[0] -= 1;
                    break;
                case "U":
                    coordinate[1] += 1;
                    break;
                case "D":
                    coordinate[1] -= 1;
                    break;
            }
        }
        if (coordinate[0] == 0 && coordinate[1] == 0) {
            return true;
        }
        return false;
    }

    public static boolean judgeCircle2(String moves) {
        if (moves == null || moves.length() == 0) {
            return true;
        }
        Map<Character, Integer> map = new HashMap<>();
        map.put('U', 0);
        map.put('D', 0);
        map.put('R', 0);
        map.put('L', 0);
        Integer conut = 0;
        for (int i = 0; i < moves.length(); i++) {
            conut = map.get(moves.charAt(i));
            map.put(moves.charAt(i), ++conut);
        }
        return (map.get('U') - map.get('D')) == 0 && (map.get('R') - map.get('L')) == 0;
    }

    boolean[] vis;
    int numCount;

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        vis = new boolean[n];
        numCount = 1;
        vis[0] = true;
        dfs(rooms, 0);
        return numCount == n;
    }

    private void dfs(List<List<Integer>> rooms, int i) {
        List<Integer> integerList = rooms.get(i);
        for (Integer integer : integerList) {
            if (!vis[integer]) {
                vis[integer] = true;
                numCount++;
                dfs(rooms, integer);
            }
        }
    }

    public static boolean PredictTheWinner(int[] nums) {
        if (nums.length < 1) {
            return true;
        }
        int start = 0, end = nums.length - 1;

        return PredictTheWinner(nums, start, end) >= 0;
    }

    private static int PredictTheWinner(int[] nums, int start, int end) {
        if (start > end) {
            return 0;
        }
        int countLeft = nums[start] - PredictTheWinner(nums, start + 1, end);
        int countRight = nums[end] - PredictTheWinner(nums, start, end - 1);
        return Math.max(countLeft, countRight);
    }

    public boolean isNumber(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        try {
            s.trim();
            Integer.valueOf(s);
            Double.valueOf(s);
            return true;
        } catch (Exception e) {
            Map[] states = {
                    // 0.
                    new HashMap<Character, Integer>() {{
                        put(' ', 0);
                        put('s', 1);
                        put('d', 2);
                        put('.', 4);
                    }},
                    // 1.
                    new HashMap<Character, Integer>() {{
                        put('d', 2);
                        put('.', 4);
                    }},
                    // 2.
                    new HashMap<Character, Integer>() {{
                        put('d', 2);
                        put('.', 3);
                        put('e', 5);
                        put(' ', 8);
                    }},
                    // 3.
                    new HashMap<Character, Integer>() {{
                        put('d', 3);
                        put('e', 5);
                        put(' ', 8);
                    }},
                    // 4.
                    new HashMap<Character, Integer>() {{
                        put('d', 3);
                    }},
                    // 5.
                    new HashMap<Character, Integer>() {{
                        put('s', 6);
                        put('d', 7);
                    }},
                    // 6.
                    new HashMap<Character, Integer>() {{
                        put('d', 7);
                    }},
                    // 7.
                    new HashMap<Character, Integer>() {{
                        put('d', 7);
                        put(' ', 8);
                    }},
                    // 8.
                    new HashMap<Character, Integer>() {{
                        put(' ', 8);
                    }}
            };
            int p = 0;
            char t;
            for (char c : s.toCharArray()) {
                if (c >= '0' && c <= '9') {
                    t = 'd';
                } else if (c == '+' || c == '-') {
                    t = 's';
                } else if (c == 'e' || c == 'E') {
                    t = 'e';
                } else if (c == '.' || c == ' ') {
                    t = c;
                } else {
                    t = '?';
                }
                if (!states[p].containsKey(t)) {
                    return false;
                }
                p = (int) states[p].get(t);
            }
            return p == 2 || p == 3 || p == 7 || p == 8;
        }
    }

    public int[] runningSum(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            nums[i] = sum;
        }
        return nums;
    }

    public static int numIdenticalPairs(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }
        }
        return count;
    }

//    public List<List<String>> solveNQueens(int n) {
//        if (n == 0) {
//            return new ArrayList<>();
//        }
//        Map<Integer, String> mapi = new HashMap<>();
//        Map<Integer, String> mapj = new HashMap<>();
//        List<List<String>> lists = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            List<String> list = new ArrayList<>();
//            for (int j = 0; j < n; j++) {
//                if (!mapi.containsKey(i) && !mapj.containsKey(j)) {
//                    mapi.put(i, "Q");
//                    mapj.put(j, "Q");
//                    list.add("Q");
//                } else {
//                    list.add(".");
//                }
//            }
//            lists.add(list);
//        }
//        return lists;
//    }

    public List<List<String>> solveNQueens(int n) {
        char[][] chess = new char[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                chess[i][j] = '.';
        List<List<String>> res = new ArrayList<>();
        solve(res, chess, 0);
        return res;
    }

    private void solve(List<List<String>> res, char[][] chess, int row) {
        if (row == chess.length) {
            res.add(construct(chess));
            return;
        }
        for (int col = 0; col < chess.length; col++) {
            if (valid(chess, row, col)) {
                chess[row][col] = 'Q';
                solve(res, chess, row + 1);
                chess[row][col] = '.';
            }
        }
    }

    //row表示第几行，col表示第几列
    private boolean valid(char[][] chess, int row, int col) {
        //判断当前列有没有皇后,因为他是一行一行往下走的，
        //我们只需要检查走过的行数即可，通俗一点就是判断当前
        //坐标位置的上面有没有皇后
        for (int i = 0; i < row; i++) {
            if (chess[i][col] == 'Q') {
                return false;
            }
        }
        //判断当前坐标的右上角有没有皇后
        for (int i = row - 1, j = col + 1; i >= 0 && j < chess.length; i--, j++) {
            if (chess[i][j] == 'Q') {
                return false;
            }
        }
        //判断当前坐标的左上角有没有皇后
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chess[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    //把数组转为list
    private List<String> construct(char[][] chess) {
        List<String> path = new ArrayList<>();
        for (int i = 0; i < chess.length; i++) {
            path.add(new String(chess[i]));
        }
        return path;
    }

    static List<String> list = new ArrayList<>();

    public static List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return null;
        }
        dfs(root, "");
        return list;
    }

    public static void dfs(TreeNode root, String paths) {
        if (root != null) {
            StringBuffer stringBuffer = new StringBuffer(paths);
            stringBuffer.append(root.val);
            if (root.left == null && root.right == null) {
                list.add(stringBuffer.toString());
            } else {
                stringBuffer.append("->");
                dfs(root.left, stringBuffer.toString());
                dfs(root.right, stringBuffer.toString());
            }
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        //创建Map，存放数值，及对应数值数量
        Map<Integer, Integer> occurrences = new HashMap<Integer, Integer>();
        for (int num : nums) {
            occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
        }

        // int[] 的第一个元素代表数组的值，第二个元素代表了该值出现的次数
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] m, int[] n) {
                return m[1] - n[1];
            }
        });
        //遍历Map
        for (Map.Entry<Integer, Integer> entry : occurrences.entrySet()) {
            int num = entry.getKey(), count = entry.getValue();
            //判断队列是否满队
            if (queue.size() == k) {
                //满队，并进行出现次数比较替换
                if (queue.peek()[1] < count) {
                    queue.poll();
                    queue.offer(new int[]{num, count});
                }
            } else {
                //不满队
                queue.offer(new int[]{num, count});
            }
        }
        int[] ret = new int[k];
        for (int i = 0; i < k; ++i) {
            ret[i] = queue.poll()[0];
        }
        return ret;
    }

    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public static List<List<Integer>> combine(int n, int k) {
        List<Integer> temp = new ArrayList<Integer>();
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // 初始化
        // 将 temp 中 [0, k - 1] 每个位置 i 设置为 i + 1，即 [0, k - 1] 存 [1, k]
        // 末尾加一位 n + 1 作为哨兵
        for (int i = 1; i <= k; ++i) {
            temp.add(i);
        }
        temp.add(n + 1);

        int j = 0;
        while (j < k) {
            ans.add(new ArrayList<Integer>(temp.subList(0, k)));
            j = 0;
            // 寻找第一个 temp[j] + 1 != temp[j + 1] 的位置 t
            // 我们需要把 [0, t - 1] 区间内的每个位置重置成 [1, t]
            while (j < k && temp.get(j) + 1 == temp.get(j + 1)) {
                temp.set(j, j + 1);
                ++j;
            }
            // j 是第一个 temp[j] + 1 != temp[j + 1] 的位置
            temp.set(j, temp.get(j) + 1);
        }
        return ans;
    }

//    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
//        List<List<Integer>> result = new ArrayList<>();
//        backtrack(result, new ArrayList<>(), candidates, target, 0);
//        return result;
//    }
//
//    private static void backtrack(List<List<Integer>> result, List<Integer> cur, int candidates[], int target, int start) {
//        if (target == 0) {
//            //找到了一组，添加到集合中
//            result.add(new ArrayList<>(cur));
//            return;
//        }
//        //相当于遍历N叉树的子节点
//        for (int i = start; i < candidates.length; i++) {
//            //如果当前节点大于target我们就不要选了
//            if (target < candidates[i])
//                continue;
//            //由于在java中List是引用传递，所以这里要重新创建一个
//            List<Integer> list = new ArrayList<>(cur);
//            list.add(candidates[i]);
//            backtrack(result, list, candidates, target - candidates[i], i);
//        }
//    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        getResult(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private static void getResult(List<List<Integer>> result, List<Integer> cur, int candidates[], int target, int start) {
        if (target == 0) {
            result.add(new ArrayList<>(cur));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (target < candidates[i])
                continue;
            //选择当前节点，类似于从当前节点开始往下遍历
            cur.add(candidates[i]);
            getResult(result, cur, candidates, target - candidates[i], i);
            //回到当前节点的时候我们把当前节点给移除,
            // 然后通过循环走同一层的其他节点。
            //举个例子，比如上面图中，最开始的时候
            // 我们先选择2，然后沿着这个分支走下去，
            //当回到当前分支的时候我们把2给移除，然后
            // 选择同一层的下一个3，沿着这个节点
            //分支走下去……
            cur.remove(cur.size() - 1);
        }
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        //将数组进行排序，方便去除重复项
        Arrays.sort(candidates);
        getResult2(result, new ArrayList<>(), candidates, target, 0);
        //返回List中去掉重复项
        return result.stream().distinct().collect(Collectors.toList());
    }

    private static void getResult2(List<List<Integer>> result, List<Integer> cur, int candidates[], int target, int start) {
        if (target == 0) {
            result.add(new ArrayList<>(cur));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (target < candidates[i])
                continue;
            //选择当前节点，类似于从当前节点开始往下遍历
            cur.add(candidates[i]);
            //i+1：不获取当前位置的数值，当前位置数值不在重复使用
            getResult2(result, cur, candidates, target - candidates[i], i + 1);
            //删除上一节点数值，重新进行添加计算是否等于target
            cur.remove(cur.size() - 1);
        }
    }

    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        int candidates[] = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        //将数组进行排序，方便去除重复项
        getResult3(result, new ArrayList<>(), candidates, k, n, 0);
        //返回List中去掉重复项
        return result.stream().distinct().collect(Collectors.toList());
    }

    private static void getResult3(List<List<Integer>> result, List<Integer> cur, int candidates[], int k, int target, int start) {
        //当差等0，且所加数个数等于k时添加其元素
        if (target == 0 && cur.size() == k) {
            result.add(new ArrayList<>(cur));
            return;
        }
        //当差等于零或者加数个数达到三个时，不需要再寻找加数，
        else if (target == 0 || cur.size() >= k) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (target < candidates[i])
                continue;
            //选择当前节点，类似于从当前节点开始往下遍历
            cur.add(candidates[i]);
            //i+1：不获取当前位置的数值，当前位置数值不在重复使用
            getResult3(result, cur, candidates, k, target - candidates[i], i + 1);
            //删除上一节点数值，重新进行添加计算是否等于target
            cur.remove(cur.size() - 1);
        }
    }

    /**
     * 利用队列先进先出的策略，BFS：广度优先搜索，按照层级进行队列添加，再根据每层进行平均值计算
     **/
    public static List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        //使用队列保存上一层节点，方便进行下一层的遍历；
        //先进先出，确保上层节点一定比下层节点先遍历
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int size;
        TreeNode temp;
        Double sum;

        //队列为空，说明上层所有节点都没有叶子节点，遍历完毕
        while (!queue.isEmpty()) {
            //重置sum，确保本次计算为当前层级的节点综合
            sum = 0.0;
            //重置size，确保本次for循环的是同一层的所有节点
            size = queue.size();
            for (int i = 1; i <= size; i++) {
                //取当前队列中首个节点
                temp = queue.poll();
                sum += temp.val;
                //把下一层的所有非空节点加入队列
                if (null != temp.left) queue.offer(temp.left);
                if (null != temp.right) queue.offer(temp.right);
            }
            result.add(sum / size);
        }
        return result;
    }

    public static List<Double> averageOfLevels2(TreeNode root) {
        List<Double> result = new ArrayList<>();
        Map<Integer, Integer> mapCount = new HashMap<>();
        Map<Integer, Integer> mapSum = new HashMap<>();

        dfs(root, 1, mapCount, mapSum);
        Double sum;
        int size = mapCount.size();
        for (int i = 1; i <= size; i++) {
            sum = Double.valueOf(mapSum.get(i) / mapCount.get(i));
            NumberFormat nf = NumberFormat.getNumberInstance();
            nf.setMaximumFractionDigits(2);
            result.add(Double.valueOf(nf.format(sum)));
        }
        return result;
    }

    private static void dfs(TreeNode root, int count, Map<Integer, Integer> mapCount, Map<Integer, Integer> mapSum) {
        if (root == null) {
            return;
        }
        //判断是否层级首次进行计数操作
        if (mapCount.containsKey(count)) {
            mapCount.put(count, mapCount.get(count) + 1);
        } else {
            mapCount.put(count, 1);
        }
        //判断是否层级首次进行求和操作
        if (mapSum.containsKey(count)) {
            mapSum.put(count, mapSum.get(count) + root.val);
        } else {
            mapSum.put(count, root.val);
        }

        if (root.left != null) dfs(root.left, count + 1, mapCount, mapSum);
        if (root.right != null) dfs(root.right, count + 1, mapCount, mapSum);
    }

    /**
     * 给定一个二叉树，返回它的中序 遍历。
     * 使用递归进行中序调用
     * 二叉树遍历，根据前中后序，三种方式进行遍历
     * 前：根左右
     * 中：左根右
     * 后：左右根
     **/
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList();
        helper(list, root);
        return list;
    }

    public static void helper(List<Integer> list, TreeNode root) {
        //终止条件
        if (root == null)
            return;
        //遍历当前节点的左子树
        helper(list, root.left);
        //把当前节点加入到集合中
        list.add(root.val);
        //遍历当前节点的右子树
        helper(list, root.right);
    }

    /**
     * 给定一个二叉树，返回它的中序 遍历。
     * 使用栈原理进行先进后出的方式进行遍历
     **/
    public List<Integer> inorderTraversal2(TreeNode root) {
        //list存储结果的
        List<Integer> list = new ArrayList<>();
        //栈存储结点的
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.empty()) {
            //找当前节点的左子节点，一直找下去，直到为空为止
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            //出栈，这时候root就是最左子节点
            root = stack.pop();
            //然后把最左子节点加入到集合中
            list.add(root.val);
            //最后再访问他的右子节点
            root = root.right;
        }
        return list;
    }

    private static int[] line = new int[9];
    private static int[] column = new int[9];
    private static int[][] block = new int[3][3];
    private static boolean valid = false;
    private static List<int[]> spaces = new ArrayList<int[]>();

    /**
     * 方法三：枚举优化
     * 思路与算法
     *
     * 我们可以顺着方法二的思路继续优化下去：
     *
     * 如果一个空白格只有唯一的数可以填入，也就是其对应的 bb 值和 b-1b−1 进行按位与运算后得到 00（即 bb 中只有一个二进制位为 11）。此时，我们就可以确定这个空白格填入的数，而不用等到递归时再去处理它。
     * 这样一来，我们可以不断地对整个数独进行遍历，将可以唯一确定的空白格全部填入对应的数。随后我们再使用与方法二相同的方法对剩余无法唯一确定的空白格进行递归 + 回溯。
     *
     **/
    public static void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] != '.') {
                    int digit = board[i][j] - '0' - 1;
                    flip(i, j, digit);
                }
            }
        }

        while (true) {
            boolean modified = false;
            for (int i = 0; i < 9; ++i) {
                for (int j = 0; j < 9; ++j) {
                    if (board[i][j] == '.') {
                        int mask = ~(line[i] | column[j] | block[i / 3][j / 3]) & 0x1ff;
                        if ((mask & (mask - 1)) == 0) {
                            int digit = Integer.bitCount(mask - 1);
                            flip(i, j, digit);
                            board[i][j] = (char) (digit + '0' + 1);
                            modified = true;
                        }
                    }
                }
            }
            if (!modified) {
                break;
            }
        }

        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] == '.') {
                    spaces.add(new int[]{i, j});
                }
            }
        }

        dfs(board, 0);
    }

    public static void dfs(char[][] board, int pos) {
        if (pos == spaces.size()) {
            valid = true;
            return;
        }

        int[] space = spaces.get(pos);
        int i = space[0], j = space[1];
        int mask = ~(line[i] | column[j] | block[i / 3][j / 3]) & 0x1ff;
        for (; mask != 0 && !valid; mask &= (mask - 1)) {
            int digitMask = mask & (-mask);
            int digit = Integer.bitCount(digitMask - 1);
            flip(i, j, digit);
            board[i][j] = (char) (digit + '0' + 1);
            dfs(board, pos + 1);
            flip(i, j, digit);
        }
    }

    public static void flip(int i, int j, int digit) {
        line[i] ^= (1 << digit);
        column[j] ^= (1 << digit);
        block[i / 3][j / 3] ^= (1 << digit);
    }

    public static void main(String[] args) throws IOException {
        char[][] chars = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'},{
            '6', '.', '.', '1', '9', '5', '.', '.', '.'},{'.', '9', '8', '.', '.', '.', '.', '6', '.'},{
            '8', '.', '.', '.', '6', '.', '.', '.', '3'},{'4', '.', '.', '8', '.', '3', '.', '.', '1'},{
            '7', '.', '.', '.', '2', '.', '.', '.', '6'},{'.', '6', '.', '.', '.', '.', '2', '8', '.'},{
            '.', '.', '.', '4', '1', '9', '.', '.', '5'},{'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        solveSudoku(chars);
        System.out.println();
    }

}


