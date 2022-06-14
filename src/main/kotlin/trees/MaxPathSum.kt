package trees

class Tree(var data: Int, var left: Tree? = null, var right: Tree? = null)

class SumNodes(var sum: Int = 0)

fun maxSumHelper(root: Tree?, sum: SumNodes): Int{
    if (root == null){
        return 0
    }
    val leftSum = maxSumHelper(root.left, sum)
    val rightSum = maxSumHelper(root.right, sum)
    val t = root.data + Math.max(leftSum, rightSum)
    val temp = Math.max(t, root.data+leftSum+rightSum)
    sum.sum = Math.max(temp, sum.sum)
    return t
}

fun maxSum(root: Tree):Int{
    val sum = SumNodes()
    maxSumHelper(root, sum)
    return sum.sum
}

fun main(){
    val t1 = Tree(10)
    val t2 = Tree(50)
    val t3 = Tree(60)
    val t4 = Tree(70)
    val t5 = Tree(20)
    val t6 = Tree(40)
    val t7 = Tree(90)
    val t9 = Tree(80)
    val t10 = Tree(30)
    val t11 = Tree(36)
    t1.left = t2
    t1.right = t3
    t2.left = t4
    t2.right = t5
    t4.left = t6
    t5.left = t7
    t5.right = t9
    t7.left = t10
    t7.right = t11
    println(maxSum(t1))
}

