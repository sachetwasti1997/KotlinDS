class Solution {
    fun sortedArrayToBST(nums: IntArray): TreeNode? {
        fun recConstruct(nums: IntArray, sIn: Int, eIn: Int): TreeNode?{
            if(sIn > eIn)return null
            val md = sIn + (eIn - sIn)/2
            val root = TreeNode(nums[md])
            root.left = recConstruct(nums, sIn, md - 1)
            root.right = recConstruct(nums, md + 1, eIn)
            return root
        }
        return recConstruct(nums, 0, nums.size-1)
    }
}