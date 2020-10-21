package demo;

import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode(0);
        ListNode newNode = listNode;
        int decade = 0;
        while (l1 != null || l2 != null) {
            int x = l1 != null ? l1.getVal() : 0;
            int y = l2 != null ? l2.getVal() : 0;
            int sum = decade + x + y;
            newNode.setNext(new ListNode(sum % 10));
            newNode = newNode.getNext();
            decade = sum / 10;
            if (l1 != null) {
                l1 = l1.getNext();
            }
            if (l2 != null) {
                l2 = l2.getNext();
            }
        }
        if (decade > 0) {
            newNode.setNext(new ListNode(decade));
        }
        return listNode.getNext();
    }

    public static ListNode addTwoNumbersV2(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode(0);
        ListNode newNode = listNode;
        int decade = 0;
        while (l1 != null || l2 != null) {
            int x = l1 != null ? l1.getVal() : 0;
            int y = l2 != null ? l2.getVal() : 0;
            int sum = decade + x + y;
            newNode.setNext(new ListNode(sum % 10));
            newNode = newNode.getNext();
            decade = sum / 10;
            if (l1 != null) {
                l1 = l1.getNext();
            }
            if (l2 != null) {
                l2 = l2.getNext();
            }
        }
        if (decade > 0) {
            newNode.setNext(new ListNode(decade));
        }
        return listNode.getNext();
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else if (p.getVal() != q.getVal()) {
            return false;
        }
        return isSameTree(p.getLeft(), q.getLeft()) && isSameTree(p.getRight(), q.getRight());
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
                newNode.setNext(new ListNode(0));
                newNode = newNode.getNext();
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
                newNode.setNext(new ListNode(num33 % 10));
                newNode = newNode.getNext();
                s = num33 / 10;
                j++;
                if (s == 0 && j >= stringBuffer2.length()) {
                    break;
                }
            }
            list.add(listNode.getNext());
        }
        ListNode listNode = list.get(0);
        for (int n = 1; n < list.size(); n++) {
            listNode = addTwoNumbersV2(listNode, list.get(n));
        }
        String num = "";
        while (listNode != null) {
            num += listNode.getNext();
            listNode = listNode.getNext();
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
            int x = l1 != null ? l1.getVal() : Integer.MAX_VALUE;
            int y = l2 != null ? l2.getVal() : Integer.MAX_VALUE;
            if (x < y) {
                newNode.setNext(new ListNode(x));
                newNode = newNode.getNext();


                l1 = l1.getNext();
            } else {
                newNode.setNext(new ListNode(y));
                newNode = newNode.getNext();
                l2 = l2.getNext();
            }
        }
        return listNode.getNext();
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
        return Math.abs(height(root.getLeft()) - height(root.getRight())) <= 1 && isBalanced(root.getLeft()) && isBalanced(root.getRight());
    }

    private static int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(height(root.getLeft()), height(root.getRight())) + 1;
    }


    public TreeNode sortedListToBST(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        ListNode listNode = head;
        while (listNode != null) {
            list.add(listNode);
            listNode = listNode.getNext();
        }
        return middle(list);
    }

    public static TreeNode middle(List<ListNode> list) {
        if (list.isEmpty()) {
            return null;
        }
        if (list.size() == 1) {
            return new TreeNode(list.get(0).getVal());
        }
        int len = list.size();
        TreeNode treeNode = new TreeNode(list.get(len / 2).getVal());
        treeNode.setLeft(middle(list.subList(0, len / 2)));
        treeNode.setRight(middle(list.subList(len / 2 + 1, len)));
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
        if (root.getLeft() == null && root.getRight() == null) {
            return 1;
        }
        //2.如果左孩子和由孩子其中一个为空，那么需要返回比较大的那个孩子的深度
        int m1 = minDepth(root.getLeft());
        int m2 = minDepth(root.getRight());
        //这里其中一个节点为空，说明m1和m2有一个必然为0，所以可以返回m1 + m2 + 1;
        if (root.getLeft() == null || root.getRight() == null) {
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
            stringBuffer.append(root.getVal());
            if (root.getLeft() == null && root.getRight() == null) {
                list.add(stringBuffer.toString());
            } else {
                stringBuffer.append("->");
                dfs(root.getLeft(), stringBuffer.toString());
                dfs(root.getRight(), stringBuffer.toString());
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
                sum += temp.getVal();
                //把下一层的所有非空节点加入队列
                if (null != temp.getLeft()) queue.offer(temp.getLeft());
                if (null != temp.getRight()) queue.offer(temp.getRight());
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
            mapSum.put(count, mapSum.get(count) + root.getVal());
        } else {
            mapSum.put(count, root.getVal());
        }

        if (root.getLeft() != null) dfs(root.getLeft(), count + 1, mapCount, mapSum);
        if (root.getRight() != null) dfs(root.getRight(), count + 1, mapCount, mapSum);
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
        helper(list, root.getLeft());
        //把当前节点加入到集合中
        list.add(root.getVal());
        //遍历当前节点的右子树
        helper(list, root.getRight());
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
                root = root.getLeft();
            }
            //出栈，这时候root就是最左子节点
            root = stack.pop();
            //然后把最左子节点加入到集合中
            list.add(root.getVal());
            //最后再访问他的右子节点
            root = root.getRight();
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
     * <p>
     * 我们可以顺着方法二的思路继续优化下去：
     * <p>
     * 如果一个空白格只有唯一的数可以填入，也就是其对应的 bb 值和 b-1b−1 进行按位与运算后得到 00（即 bb 中只有一个二进制位为 11）。此时，我们就可以确定这个空白格填入的数，而不用等到递归时再去处理它。
     * 这样一来，我们可以不断地对整个数独进行遍历，将可以唯一确定的空白格全部填入对应的数。随后我们再使用与方法二相同的方法对剩余无法唯一确定的空白格进行递归 + 回溯。
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

    /**
     * 翻转二叉树，递归调用方式
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        TreeNode treeNode;
        treeNode = root.getLeft();
        root.setLeft(root.getRight());
        root.setRight(treeNode);
        if (root.getLeft() != null) invertTree(root.getLeft());
        if (root.getRight() != null) invertTree(root.getRight());
        return root;
    }

    /**
     * DFS 栈
     */
    public TreeNode invertTree2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if (cur == null) {
                continue;
            }
            TreeNode temp = cur.getLeft();
            cur.setLeft(cur.getRight());
            cur.setRight(temp);

            stack.push(cur.getRight());
            stack.push(cur.getLeft());
        }
        return root;
    }

    /**
     * BFS 队列
     */
    public TreeNode invertTree3(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur == null) {
                continue;
            }
            TreeNode temp = cur.getLeft();
            cur.setLeft(cur.getRight());
            cur.setRight(temp);

            queue.offer(cur.getLeft());
            queue.offer(cur.getRight());
        }
        return root;
    }

    int[] result = new int[2];
    int doubleRoot = 0;
    int[] hadRoot;
    int[][] rootResult = new int[2][2];

    /**
     * 冗余连接 II
     **/
    public int[] findRedundantDirectedConnection(int[][] edges) {
        hadRoot = new int[edges.length + 1];
        int[] father = new int[edges.length + 1];
        for (int i = 0; i < father.length; i++) {
            father[i] = i;
        }

        for (int[] edge : edges) {
            hadRoot[edge[1]]++;
            if (hadRoot[edge[1]] == 2) {
                doubleRoot = edge[1];
                rootResult[1] = edge;
            } else {
                union(father, edge[1], edge[0]);
            }
        }
        if (doubleRoot != 0) {
            for (int[] edge : edges) {
                if (edge[1] == doubleRoot) {
                    rootResult[0] = edge;
                    break;
                }
            }
            int root = 0;
            for (int i = 1; i < father.length; i++) {
                if (root == 0) {
                    root = findXFather(father, i);
                }
                if (root != findXFather(father, i)) {
                    return rootResult[0];
                }
            }
            return rootResult[1];
        }
        return result;
    }

    public int findXFather(int[] father, int x) {
        while (father[x] != x) {
            father[x] = father[father[x]];
            x = father[x];
        }
        return x;
    }

    public void union(int[] father, int x, int y) {
        int xFather = findXFather(father, x);
        int yFather = findXFather(father, y);
        if (xFather != yFather) {
            father[xFather] = yFather;
        } else {
            result[0] = y;
            result[1] = x;
        }
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        // 排序（升序或者降序都可以），排序是剪枝的前提
        Arrays.sort(nums);

        boolean[] used = new boolean[len];
        // 使用 Deque 是 Java 官方 Stack 类的建议
        Deque<Integer> path = new ArrayDeque<>(len);
        dfs(nums, len, 0, used, path, res);
        return res;
    }

    private static void dfs(int[] nums, int len, int depth, boolean[] used, Deque<Integer> path, List<List<Integer>> res) {
        //栈内数量为总数数量，返回组合
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < len; ++i) {
            if (used[i]) {
                continue;
            }

            // 剪枝条件：i > 0 是为了保证 nums[i - 1] 有意义
            // 写 !used[i - 1] 是因为 nums[i - 1] 在深度优先遍历的过程中刚刚被撤销选择
            /*
                剪枝:
                    1、当前元素 被使用过
                    2、当前元素 和 前一个元素相同(排序保证相同元素排在一起)，
                        且 前一个元素 没有被使用过(保证重复元素只按照一个顺序被遍历，防止 重复排列)
             */
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }

            path.addLast(nums[i]);
            used[i] = true;

            dfs(nums, len, depth + 1, used, path, res);
            // 回溯部分的代码，和 dfs 之前的代码是对称的
            used[i] = false;
            path.removeLast();
        }
    }

    // 中序遍历，将右侧大数相加累加至左侧，因二叉树特性，右侧节点所有数大于必然大于左侧节点所有数
    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            convertBST(root.getRight());
            sum += root.getVal();
            root.setVal(sum);
            convertBST(root.getLeft());
        }
        return root;
    }

    public static boolean exist(char[][] board, String word) {
        if (board.length == 0 || word.length() == 0) {
            return true;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (seek(board, word, 0, i, j)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private static boolean seek(char[][] board, String word, int i, int x, int y) {
        //如果，字符串全部验证完毕，则完成寻找，返回true
        if (i == word.length()) {
            return true;
        }
        //如果，x，y超出边界，说明无路可走，返回false；
        if (x < 0 || y < 0 || x >= board.length || y >= board[x].length || board[x][y] != word.charAt(i)) {
            return false;
        }
        //如果，x，y坐标上的字符与word上的对应，则继续向下寻找i++
        i++;
        //记录当前坐标，并修改为'.'，防止重复使用
        char c = board[x][y];
        board[x][y] = '.';
        boolean b = seek(board, word, i, x, y - 1)
                || seek(board, word, i, x, y + 1)
                || seek(board, word, i, x - 1, y)
                || seek(board, word, i, x + 1, y);
        //递归结束，还原坐标原字符，防止重新使用
        board[x][y] = c;
        return b;
    }

    /**
     * 监控二叉树
     */
    int resultNum = 0;

    public int minCameraCover(TreeNode root) {
        if (dfs(root) == 1) {
            resultNum++;
        }
        return resultNum;
    }

    //0:可被观测但无监控，上一层节点为1
    //1：不可被观测到，上一层节点为2
    //2：有摄像机，上一层节点为0
    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftStatus = dfs(root.getLeft()), rightStatus = dfs(root.getRight());
        if (leftStatus == 1 || rightStatus == 1) {
            resultNum++;
            return 2;
        } else if (leftStatus == 2 || rightStatus == 2) {
            return 0;
        } else {
            return 1;
        }
    }


    /**
     * 方法一 ：合并二叉树
     * 新建二叉树t，将t1和t2合并到t上
     *
     * @param t1
     * @param t2
     */
    static TreeNode t = new TreeNode();

    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        } else if (t2 == null) {
            return t1;
        }
        dfs(t, t1, t2);
        return t;
    }

    private static void dfs(TreeNode t, TreeNode t1, TreeNode t2) {
        t.setVal(((t1 == null) ? 0 : t1.getVal()) + ((t2 == null) ? 0 : t2.getVal()));
        if ((t1 != null && t1.getLeft() != null) || (t2 != null && t2.getLeft() != null)) {
            t.setLeft(new TreeNode());
            dfs(t.getLeft(), t1 == null ? null : t1.getLeft(), t2 == null ? null : t2.getLeft());
        }
        if ((t1 != null && t1.getRight() != null) || (t2 != null && t2.getRight() != null)) {
            t.setRight(new TreeNode());
            dfs(t.getRight(), t1 == null ? null : t1.getRight(), t2 == null ? null : t2.getRight());
        }
    }

    /**
     * 方法二 ：合并二叉树
     * 以t1为主干，将t2合并到t1的对应位置
     *
     * @param t1
     * @param t2
     * @return
     */
    public static TreeNode mergeTrees2(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        } else if (t2 == null) {
            return t1;
        }
        t1.setLeft(mergeTrees2(t1.getLeft(), t2.getLeft()));
        t2.setRight(mergeTrees2(t1.getRight(), t2.getRight()));
        t1.setVal(t1.getVal() + t2.getVal());
        return t1;
    }

    private TreeNode pre = null;    // 前驱节点
    //    private int[] result;   // 结果数组
    private int resultCount = 0;    // 结果个数
    private int maxCount = 0;   // 众数数量
    private int currCount = 0;  // 当前重复的数的数量

    public int[] findMode(TreeNode root) {
        findAndFill(root);  // 第一轮，查询 “众数个数”
        // 复位
        this.pre = null;
        this.result = new int[this.resultCount];    // 初始化数组
        this.resultCount = 0;
        this.currCount = 0;
        findAndFill(root);  // 第二轮，填充 众数
        return this.result;
    }

    /**
     * 中根序 遍历 目标二叉树<br/>
     */
    private void findAndFill(TreeNode root) {
        if (root == null) {
            return;
        }

        findAndFill(root.getLeft()); // 递归遍历 左子树
        if (this.pre != null && this.pre.getVal() == root.getVal()) { // 与前一个节点的值相等
            this.currCount++;
        } else {
            this.currCount = 1;  // 若 不相等，则 刷新currCount
        }

        if (this.currCount > this.maxCount) {   // 当前最大数 > 最大众数数
            this.maxCount = this.currCount;
            this.resultCount = 1;
        } else if (this.currCount == this.maxCount) {   // 当前最大数 == 最大众数数
            if (this.result != null) {
                this.result[this.resultCount] = root.getVal();
            }
            this.resultCount++;  // 使 指针向后移动，便于下次录入
        }

        // 进行下轮遍历
        this.pre = root;
        findAndFill(root.getRight());    // 递归遍历 右子树
    }

    Map<Integer, Integer> buildTreeMap = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        //为了和105、889题目结构一致都利用HashMap方便查找节点位置（索引）
        //我们利用中序来区分左右子数
        for (int i = 0; i < inorder.length; i++) {
            buildTreeMap.put(inorder[i], i);
        }
        return helper(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    private TreeNode helper(int[] in, int[] post, int inL, int inR, int postL, int postR) {
        if (inL > inR)  //说明数组无效
            return null;

        TreeNode root = new TreeNode(post[postR]);//利用后序的最后一个节点创建新的树的根节点
        int postRootVal = post[postR];    //后序遍历的最后一个节点post_last_node
        int inMid = buildTreeMap.get(postRootVal); //后序遍历节点post_last_node在中序遍历中的位置（利用map直接以O(1)的复杂度取出索引）
        int inLeftNum = inMid - inL;        //中序遍历的左子树的个数
        /*
            中序左子树的范围说明:
                从中序第一个节点开始，到后序遍历的最后一个节点在中序遍历位置的前一个节点结束 inL,inMid-1
            中序右子树的范围说明:
                从后序遍历的最后一个节点在中序遍历位置的后一个节点开始，到中序的最后一个位置结束 inMid+1,inR
            后序左子树的范围说明:
                从后序的第一个的节点开始，到第一个节点+左子树的个数-1结束 postL,postL+inLeftNum-1
            后序右子树的范围说明:
                从后序的第一个节点+左子树的个数开始，到到后序的最后一个位置-1结束 postL+inLeftNum,postR-1

            中序左子树的范围[inL,inMid-1] 后序左子树的范围[postL,postL+inLeftNum-1]
            中序右子树的范围[inMid+1,inR] 后序右子树的范围[postL+inLeftNum,postR-1]
        */

        root.setLeft(helper(in, post, inL, inMid - 1, postL, postL + inLeftNum - 1));//递归构建左子树
        root.setRight(helper(in, post, inMid + 1, inR, postL + inLeftNum, postR - 1));//递归构建右子树
        return root;
    }

    /**
     * 二叉搜索树的最近公共祖先
     * 根据二叉树左小右大规则，判断两个数是左节点还是右节点
     * 如果两个节点分开左右节点，必然是该节点为最近父节点
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (true) {
            if (p.getVal() < root.getVal() && q.getVal() < root.getVal()) {
                root = root.getLeft();
            } else if (p.getVal() > root.getVal() && q.getVal() > root.getVal()) {
                root = root.getRight();
            } else {
                return root;
            }
        }
    }

    static List<List<Integer>> lists;

    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        lists = new ArrayList<List<Integer>>();
        if (root == null || sum <= 0)
            return lists;
        dfs(new ArrayList<>(), root, sum);
        return lists;
    }

    private static void dfs(List<Integer> list, TreeNode root, int surplus) {
        //判断当前是否为null，如果为null，不进行计算
        if (root == null)
            return;
        //将需要计算数值先加入集合list
        list.add(root.getVal());
        //如果剩余为0，将集合list加入总集合lists中，返回并删除集合list中的自己
        if (surplus - root.getVal() == 0) {
            lists.add(new ArrayList<>(list));
            list.remove(list.size() - 1);
            return;
        }
        //如果剩余值小于0，说明计算不合适，并且自己的子节点为null，删除自身
        else if ((surplus - root.getVal() < 0) || (root.getLeft() == null && root.getRight() == null)) {
            list.remove(list.size() - 1);
            return;
        }
        //当前剩余值大于0，并且子节点存在，需继续进行计算
        dfs(list, root.getLeft(), surplus - root.getVal());
        dfs(list, root.getRight(), surplus - root.getVal());
        //计算完之后，删除自身，查找更多数值组合可能
        list.remove(list.size() - 1);
    }

    /**
     * 回溯，往下减（一）
     *
     * @param root
     * @param sum
     * @return
     */
    public List<List<Integer>> pathSum2(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, sum, new ArrayList<>(), result);
        return result;
    }

    /**
     * 回溯，往下减（一）
     *
     * @param root
     * @param sum
     * @param list
     * @param result
     */
    public void dfs(TreeNode root, int sum, List<Integer> list,
                    List<List<Integer>> result) {
        //如果节点为空直接返回
        if (root == null)
            return;
        //把当前节点值加入到list中
        list.add(new Integer(root.getVal()));
        //如果到达叶子节点，就不能往下走了，直接return
        if (root.getLeft() == null && root.getRight() == null) {
            //如果到达叶子节点，并且sum等于叶子节点的值，说明我们找到了一组，
            //要把它放到result中
            if (sum == root.getVal())
                result.add(new ArrayList(list));
            //注意别忘了把最后加入的结点值给移除掉，因为下一步直接return了，
            //不会再走最后一行的remove了，所以这里在rerurn之前提前把最后
            //一个结点的值给remove掉。
            list.remove(list.size() - 1);
            //到叶子节点之后直接返回，因为在往下就走不动了
            return;
        }
        //如果没到达叶子节点，就继续从他的左右两个子节点往下找，注意到
        //下一步的时候，sum值要减去当前节点的值
        dfs(root.getLeft(), sum - root.getVal(), list, result);
        dfs(root.getRight(), sum - root.getVal(), list, result);
        //我们要理解递归的本质，当递归往下传递的时候他最后还是会往回走，
        //我们把这个值使用完之后还要把它给移除，这就是回溯
        list.remove(list.size() - 1);
    }

    /**
     * 回溯，往下累加（一）
     *
     * @param root
     * @param sum
     * @return
     */
    public List<List<Integer>> pathSum3(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, sum, 0, new ArrayList<>(), result);
        return result;
    }

    /**
     * 回溯，往下累加（二）
     *
     * @param root
     * @param sum
     * @param toal
     * @param list
     * @param result
     */
    public void dfs(TreeNode root, int sum, int toal, List<Integer> list,
                    List<List<Integer>> result) {
        //如果节点为空直接返回
        if (root == null)
            return;
        //把当前节点值加入到list中
        list.add(new Integer(root.getVal()));
        //没往下走一步就要计算走过的路径和
        toal += root.getVal();
        //如果到达叶子节点，就不能往下走了，直接return
        if (root.getLeft() == null && root.getRight() == null) {
            //如果到达叶子节点，并且sum等于toal，说明我们找到了一组，
            //要把它放到result中
            if (sum == toal)
                result.add(new ArrayList(list));
            //注意别忘了把最后加入的结点值给移除掉，因为下一步直接return了，
            //不会再走最后一行的remove了，所以这里在rerurn之前提前把最后
            //一个结点的值给remove掉。
            list.remove(list.size() - 1);
            //到叶子节点之后直接返回，因为在往下就走不动了
            return;
        }
        //如果没到达叶子节点，就继续从他的左右两个子节点往下找
        dfs(root.getLeft(), sum, toal, list, result);
        dfs(root.getRight(), sum, toal, list, result);
        //我们要理解递归的本质，当递归往下传递的时候他最后还是会往回走，
        //我们把这个值使用完之后还要把它给移除，这就是回溯
        list.remove(list.size() - 1);
    }

    public static Node2 connect(Node2 root) {
        if (root == null)
            return root;
        //cur我们可以把它看做是每一层的链表
        Node2 cur = root;
        while (cur != null) {
            //遍历当前层的时候，为了方便操作在下一层前面添加一个哑结点（注意这里是访问当前层的节点，然后把下一层的节点串起来）
            Node2 dummy = new Node2(0);
            //pre表示访下一层节点的前一个节点
            Node2 pre = dummy;
            //然后开始遍历当前层的链表
            while (cur != null) {
                if (cur.getLeft() != null) {
                    //如果当前节点的左子节点不为空，就让pre节点的next指向他，也就是把它串起来
                    pre.setNext(cur.getLeft());
                    //然后再更新pre
                    pre = pre.getNext();
                }
                //同理参照左子树
                if (cur.getRight() != null) {
                    pre.setNext(cur.getRight());
                    pre = pre.getNext();
                }
                //继续访问这样行的下一个节点
                cur = cur.getNext();
            }
            //把下一层串联成一个链表之后，让他赋值给cur，后续继续循环，直到cur为空为止
            cur = dummy.getNext();
        }
        return root;
    }

    /**
     * 二叉树的后序遍历
     *
     * @param root
     * @return
     */
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList();
        afterSequence(list, root);
        return list;

    }

    /**
     * 后序遍历输出list--递归算法
     *
     * @param list
     * @param root
     */
    public static void afterSequence(List<Integer> list, TreeNode root) {
        //终止条件
        if (root == null)
            return;
        //遍历当前节点的左子树
        afterSequence(list, root.getLeft());
        //遍历当前节点的右子树
        afterSequence(list, root.getRight());
        //把当前节点加入到集合中
        list.add(root.getVal());
    }

    /**
     * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
     *
     * @param x
     * @return
     */
    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        List<Integer> list = new ArrayList<>();
        int y = x;
        while (y > 0) {
            int a = y % 10;
            y /= 10;
            list.add(a);
        }
        for (int i = 0, j = list.size() - 1; i < j; i++, j--) {
            if (list.get(i) != list.get(j)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 拥有最多糖果的孩子
     * 给你一个数组 candies 和一个整数 extraCandies ，其中 candies[i] 代表第 i 个孩子拥有的糖果数目。
     **/
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int x = 0;
        for (int i : candies) {
            if (i > x)
                x = i;
        }
        List<Boolean> list = new ArrayList<>();
        for (int i : candies) {
            if (i + extraCandies >= x)
                list.add(true);
            else
                list.add(false);
        }
        return list;
    }

    /**
     * 二叉搜索树中的插入操作
     *
     * @param root
     * @param val
     * @return
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (val < root.getVal()) {
            if (root.getLeft() == null)
                root.setLeft(new TreeNode(val));
            else
                insertIntoBST(root.getLeft(), val);
        } else {
            if (root.getRight() == null)
                root.setRight(new TreeNode(val));
            else
                insertIntoBST(root.getRight(), val);
        }
        return root;
    }

    /**
     * 左旋转字符串
     *
     * @param s
     * @param n
     * @return
     */
    public static String reverseLeftWords(String s, int n) {
        String substring = s.substring(0, n);
        String substring1 = s.substring(n, s.length());
        return substring1 + substring;
    }

    /**
     * 重新排列数组--1
     *
     * @param nums
     * @param n
     * @return
     */
    public int[] shuffle(int[] nums, int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0, j = n; j < nums.length; i++, j++) {
            list.add(nums[i]);
            list.add(nums[j]);

        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * 重新排列数组--2
     *
     * @param nums
     * @param n
     * @return
     */
    public int[] shuffle2(int[] nums, int n) {
        int[] ints = new int[nums.length];
        for (int i = 0, j = n, k = 0; j < nums.length; i++, j++, k += 2) {
            ints[k] = nums[i];
            ints[k + 1] = nums[j];
        }
        return ints;
    }

    /**
     * 删除中间节点
     *
     * @param node 当前需删除节点
     */
    public void deleteNode(ListNode node) {
        node.setVal(node.getNext().getVal());
        node.setNext(node.getNext());
    }

    /**
     * 数组异或操作
     *
     * @param n
     * @param start
     * @return
     */
    public int xorOperation(int n, int start) {
        int end = 0;
        for (int i = 0; i < n; i++) {
            end ^= start + 2 * i;
        }
        return end;
    }

    /**
     * 猜数字
     *
     * @param guess
     * @param answer
     * @return
     */
    public int game(int[] guess, int[] answer) {
        int count = 0;
        for (int i = 0; i < guess.length; i++) {
            if (guess[i] == answer[i]) {
                count++;
            }
        }
        return count;
    }

    /**
     * 宝石与石头
     *
     * @param J
     * @param S
     * @return
     */
    public int numJewelsInStones(String J, String S) {
        int count = 0;
        for (int i = 0, j = 0; i < J.length(); i++) {
            for (j = 0; j < S.length(); j++) {
                if (J.charAt(i) == S.charAt(j)) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 快慢指针解决
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null)
            return false;
        //快慢两个指针
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.getNext() != null) {
            //慢指针每次走一步
            slow = slow.getNext();
            //快指针每次走两步
            fast = fast.getNext().getNext();
            //如果相遇，说明有环，直接返回true
            if (slow == fast)
                return true;
        }
        //否则就是没环
        return false;
    }

    /**
     * 判断重复路线
     *
     * @param head
     * @return
     */
    public boolean hasCycle2(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            //如果重复出现说明有环
            if (set.contains(head))
                return true;
            //否则就把当前节点加入到集合中
            set.add(head);
            head = head.getNext();
        }
        return false;
    }

    /**
     * 判断重复出现第一次的节点
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            //如果重复出现说明有环
            if (set.contains(head))
                return head;
            //否则就把当前节点加入到集合中
            set.add(head);
            head = head.getNext();
        }
        return null;
    }

    /**
     * 利用快慢指针，得出入环节点
     *
     * @param head
     * @return
     */
    public ListNode detectCycle2(ListNode head) {
        ListNode fast = head, slow = head;
        while (true) {
            //如果为null，无闭环，返回null
            if (fast == null || fast.getNext() == null) return null;
            //快慢指针，快指针每次走两步，慢指针每次走一步
            fast = fast.getNext().getNext();
            slow = slow.getNext();
            if (fast == slow) break;
        }
        fast = head;
        //两相遇指针，一个从头结点开始，一个从相遇点开始每次走一步，直到再次相遇为止
        while (slow != fast) {
            slow = slow.getNext();
            fast = fast.getNext();
        }
        return fast;
    }

    private int min = Integer.MAX_VALUE;
    private TreeNode treeNode;

    /**
     * 二叉搜索树的最小绝对差
     *
     * @param root
     * @return
     */
    public int getMinimumDifference(TreeNode root) {
        theSmallestDifference(root);
        return min;
    }

    public void theSmallestDifference(TreeNode root) {
        //边界结束条件
        if (root == null)
            return;
        //左子节点
        theSmallestDifference(root.getLeft());
        //对当前节点操作
        if (treeNode != null)
            this.min = Math.min(this.min, root.getVal() - treeNode.getVal());
        treeNode = root;
        //右子节点
        theSmallestDifference(root.getRight());
    }

    /**
     * 两两交换链表中的节点--递归算法
     *
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.getNext() == null) {
            return head;
        }
        ListNode newHead = head.getNext();
        head.setNext(swapPairs(newHead.getNext()));
        newHead.setNext(head);
        return newHead;
    }

    /**
     * 两两交换链表中的节点--双指针算法
     *
     * @param head
     * @return
     */
    public ListNode swapPairs2(ListNode head) {
        //至少含有两个节点，否则不能进行两两互换
        if (head == null || head.getNext() == null) {
            return head;
        }
        ListNode listNode1 = head, listNode2 = head.getNext();
        ListNode newHead = listNode2;
        while (true) {
            //前两个互换
            listNode1.setNext(listNode2.getNext());
            listNode2.setNext(listNode1);
            //判断后两个节点是否存在，不存在则结束互换
            if (listNode1.getNext() == null || listNode1.getNext().getNext() == null) {
                break;
            }
            //记录一下，否则执行“串起来”后无法让p1，p2指向两个新的待交换节点”串起来”分别指向两个新的待交换节点
            ListNode temp = listNode1.getNext();
            listNode1.setNext(listNode1.getNext().getNext());
            listNode1.setNext(temp);
            listNode2.setNext(temp.getNext());

        }

        return newHead;
    }

    /**
     * 查找常用字符
     *
     * @param A
     * @return
     */
    public static List<String> commonChars(String[] A) {
        List<Map<Character, Integer>> list = new ArrayList<>();
        for (String str : A) {
            Map<Character, Integer> map = new HashMap();
            for (int i = 0; i < str.length(); i++) {
                if (!map.containsKey(str.charAt(i))) {
                    map.put(str.charAt(i), 1);
                } else {
                    map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
                }
            }
            list.add(map);
        }

        List<String> strings = new ArrayList<>();
        for (char c : list.get(0).keySet()) {
            int num = list.get(0).get(c);
            boolean b = true;
            for (int i = 1; i < list.size(); i++) {
                if (list.get(i).containsKey(c)) {
                    num = Math.min(list.get(i).get(c), num);
                } else {
                    b = false;
                    break;
                }
            }
            if (b) {
                while (num > 0) {
                    strings.add(String.valueOf(c));
                    num--;
                }
            }
        }
        return strings;
    }

    /**
     * 查找常用字符--优化时间，优化内存占用
     *
     * @param A
     * @return
     */
    public static List<String> commonChars2(String[] A) {
        int[] ints = getCs(A[0]);
        for (int i = 1; i < A.length; i++) {
            int[] newInt = getCs(A[i]);
            for (int j = 0; j < ints.length; j++) {
                if (ints[j] > newInt[j]) {
                    ints[j] = newInt[j];
                }
            }
        }
        List<String> list = new ArrayList<>();
        int m = 0;
        for (int i : ints) {
            if (i != 0) {
                while (i > 0) {
                    list.add(Character.toString((char) ('a' + m)));
                    i--;
                }
            }
            m++;
        }
        return list;
    }

    private static int[] getCs(String s) {
        int[] cs = new int[26];

        for (char c : s.toCharArray()) {
            cs[c - 'a']++;
        }

        return cs;
    }

    /**
     * 填充每个节点的下一个右侧节点指针 II -- 递归调用
     *
     * @param root
     * @return
     */
    public Node connect(Node root) {
        dfs(root, null);
        return root;
    }

    private void dfs(Node curr, Node next) {
        if (curr == null)
            return;
        curr.setNext(next);
        dfs(curr.getLeft(), curr.getRight());
        dfs(curr.getRight(), curr.getNext() == null ? null : curr.getNext().getRight());
    }

    /**
     * 有序数组的平方
     *
     * @param A
     * @return
     */
    public int[] sortedSquares(int[] A) {
        for (int i = 0; i < A.length; i++) {
            A[i] *= A[i];
        }
        Arrays.sort(A);
        return A;
    }

    /**
     * 比较含退格的字符串
     *
     * @param S
     * @param T
     * @return
     */
    public static boolean backspaceCompare(String S, String T) {
        String s = "", t = "";
        for (int i = 0; i < S.length(); i++) {
            if ('#' == S.charAt(i)) {
                s = s.length() - 1 < 0 ? s : s.substring(0, s.length() - 1);
                continue;
            }
            s += S.charAt(i);
        }
        for (int i = 0; i < T.length(); i++) {
            if ('#' == T.charAt(i)) {
                t = t.length() - 1 < 0 ? t : t.substring(0, t.length() - 1);
                continue;
            }
            t += T.charAt(i);
        }
        return s.equals(t);
    }

    /**
     * 重排链表
     *
     * @param head
     */
    public static void reorderList(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.getVal());
            head = head.getNext();
        }
        ListNode newNode = new ListNode(0);
        head = newNode;
        for (int i = 0, j = list.size() - 1; i <= j; i++, j--) {
            if (i != j) {
                newNode.setNext(new ListNode(list.get(i)));
                newNode = newNode.getNext();
                newNode.setNext(new ListNode(list.get(j)));
                newNode = newNode.getNext();
            } else {
                newNode.setNext(new ListNode(list.get(i)));
            }
        }
        head = head.getNext();
        System.out.println(ListNode.listNodeToString(head));
        return;
    }

    /**
     * 长按键入
     *
     * @param name
     * @param typed
     * @return
     */
    public static boolean isLongPressedName(String name, String typed) {
        int i = 0, j = 0;
        while (j < typed.length()) {
            if (i < name.length() && name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;
            } else if (j > 0 && typed.charAt(j) == typed.charAt(j - 1)) {
                j++;
            } else {
                return false;
            }
        }
        return i == name.length();
    }

    public static void main(String[] args) throws IOException {
        System.out.println(isLongPressedName("alex", "aaleelx"));
    }

}


