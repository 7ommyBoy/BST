1.) https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/TreeMap.html
Class TreeMap <K, V>

2.) Link = https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/

/** LeetCode 108. Convert Sorted Array to Binary Search Tree
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        //This checks if the length of the array is zero. 
        //If so it will return null since there is nothing in the array
        if(nums.length == 0) return null;
        // The helper method ("constructTreeFromArray"), 
        // recursively constructs the binary search tree.
        // Passing in the array "nums", the left index "0", and the right index "nums.length-1"
        return constructTreeFromArray(nums, 0, nums.length-1);
    }
        // This method takes an integer array "nums", and two integer indices "left" and "right" as input.
    public TreeNode constructTreeFromArray(int[] nums, int left, int right) {
        //(Line 1)Checks if left index is greater than the right index indcating that there is no more elements to process.
        if (left > right) return null;
        // (Line 2) This will caculate the midpoint of the subarray by adding left index to the differnece between the right and left indicies, divided by 2.
        int midpoint = left + (right-left) / 2;
        // (Line 3)We create a new "TreeNode" object "node" with a vlue of "nums[midpoint]". 
        // (Line 3)This is the value at the midpoint of the subarray.
        TreeNode node = new TreeNode(nums[midpoint]);
        // (Line 4) This calls the recursive method to construct the left subtree of the "node", passing in the input array "nums",
        // (Line 4) the left index "left" and the right new index "midpoint - 1"
        node.left = constructTreeFromArray(nums, left, midpoint-1);
        // (Line 5) This calls the recursive method to construct the right subtree of the "node", passing in the input array "nums",
        // (Line 5) the new left index "midpoint + 1" and the right index "right".
        node.right = constructTreeFromArray(nums, midpoint+1, right);
        // (Line 6) Returns "node", which is the root of the subtree.
        return node;
    }
}
// Example: nums = [1, 2, 3, 4, 5]
// (Line 3)
// Side Notes: The midpoint of the subarray as (left + right) / 2, which is (0 + 4) / 2 = 2. 
// The midpoint is 2, so the value at index 2 of the array, which is 3, becomes the root of the subtree.


//Other Notes: Recursion works by breaking the problem down into smaller and smaller subproblems, 
// until a base case is reached where there are no more elements to process. 
