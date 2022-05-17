import java.lang.Math.pow

/*

Weekly Coding Challenge:
        Pls mention the link to your solution in the comments section not later than Friday morning.

        1) Sum Lists: You have two numbers represented by a linked list, where each node contains a single
        digit. The digits are stored in reverse order, such that the 1 's digit is at the head of the list. Write a
        function that adds the two numbers and returns the sum as a linked list.

        EXAMPLE
        Input: (7-> 1 -> 6) + (5 -> 9 -> 2).That is,617 + 295.
        Output: 2 -> 1 -> 9. That is, 912.

        FOLLOW UP
                Suppose the digits are stored in forward order. Repeat the above problem.
        Input: (6 -> 1 -> 7) + (2 -> 9 -> 5).That is,617 + 295.
        Output: 9 -> 1 -> 2. That is, 912.

        2) Stack Min: How would you design a stack which, in addition to push and pop, has a function min which returns the minimum element? Push, pop and min should all operate in 0(1) time.
 */
fun main() {


        val list1 = LinkedList<Int>()
        val list2 = LinkedList<Int>()
        list1.push(4).push(6).push(2).push(1)
        list2.push(1).push(1).push(1)
        println("Forward link addition e.g")
        addNumForward(list1, list2)


        println()
        println("Reverse link addition e.g")
        addNumReverse(list1, list2)


        println()
        println("Stack Min Popping")
        println(list1)
        stackMin(list1)
        list1.pop()
        println(list1)
        stackMin(list1)
        list1.pop()
        println(list1)
        stackMin(list1)


}

fun stackMin(list: LinkedList<Int>){
        if(!list.isEmpty()){
        println("Minimum = ${list.min()}")
        }else{
                println("List is empty")
        }
}

fun addNumForward(list1: LinkedList<Int>, list2:LinkedList<Int>){

        val sum = linkNumForward(list1) + linkNumForward(list2)
        println("($list1) + ($list2) = $sum")

        constructLink(sum)

}

fun linkNumForward(list: LinkedList<Int>):Int{
        var decimal = 0
        var sum = 0.0
        var tail = list.tail
        while(tail!=null){
                sum += tail.value.toDouble() * pow(10.0, decimal.toDouble())
                 tail = tail.previous
                decimal++
        }
        return sum.toInt()
}


fun addNumReverse(list1: LinkedList<Int>, list2:LinkedList<Int>){
        val sum = linkNumReverse(list1) + linkNumReverse(list2)
        println("($list1) + ($list2) = $sum")
        constructLink(sum)

}

fun linkNumReverse(list: LinkedList<Int>):Int{
        var decimal = 0
        var sum = 0.0
        var head = list.head
        while(head!=null){
                sum += head.value.toDouble() * pow(10.0, decimal.toDouble())
                head = head.next
                decimal++
        }
        return sum.toInt()
}

fun constructLink(num:Int){
      var  list =  LinkedList<Int>()
        val str = num.toString()
        str.forEach {
                list.append(it.digitToInt())

        }
        println(list)
}
/*
        val list0 = LinkedList<Int>() // No intersection or circular list
        val list1 = LinkedList<Int>() // List one for intersection
        val list2 = LinkedList<Int>() // List two for intersection
        val list3 =  LinkedList<Int>() // List three for loopDetection
        val node = Node(-50000) // -50000 is the test case for both intersected node && circular node
        val node1 = Node(-50000) // -50000 is the test case for both intersected node && circular node

        //default case no circular or intersection
        list0.append(11).append(12).append(13).append(14).append(15)

        //test list for intersection
        list1.append(1).append(2).append(3).append(4).append(node).append(-1).append(-2) //test list for intersection

        //test list for intersection
        list2.append(5).append(6).append(7).append(node)

        //test list for circular
        list3.append(1).append(2).append(3).append(node1).append(5).append(6).append(node1)

        println("List 0 = $list0")
        println("List 1 = $list1")
        println("List 2 = $list2")

        //list 3 display is hard coded in order to save time.
        println("List 3 = 1 -> 2 -> 3 -> -50000 -> 5 -> 6 -> -50000")
        println()
        //println("List 3 = $list0")

        /*
        Intersections
        TEST CASE INTERSECTING NODE HAS VALUE OF -50000
        */

        //intersection test (FALSE)
        println("Intersection list0 & list1 (INTERSECTION = False)")
        intersectCheck(list0, list1)
        println()

        //Intersection test (TRUE)
        println("Intersection list1 & list2 (Intersection case = True)")
        intersectCheck(list1, list2)
        println()

/*
        Loop Detection
        TEST CASE LOOP NODE HAS VALUE OF -50000
*/

        //Circular loop (FALSE)
        println("Circular list0 (Circular case  = False)")
        loopCheck(list=list0)
        println()

        //circular loop (TRUE)
        println("Circular list3 (Circular case = True)")
        loopCheck(list=list3)
        */


fun <T> intersection(list1: LinkedList<T>, list2:LinkedList<T>) : MutableList<Int>{

        val LMap = HashMap<Int, Int>()
        var intersectionIndex:MutableList<Int> =  mutableListOf()  // intersect index

        // add all of list 1 to map, use node as key
        var currentL1Node = list1.head
        var list1Index = 0
        while (currentL1Node != null) {
                LMap[System.identityHashCode(currentL1Node)] = list1Index
                list1Index++
                currentL1Node = currentL1Node.next
        }

        //map look up, if key-value pair is already established then there is an intersection
        var currentL2Node = list2.head
        var list2Index= 0
        while (currentL2Node != null) {

                //intersect found, add k,j pair
                if( LMap[System.identityHashCode(currentL2Node)] != null)
                {
                        println("Intersect Found object reference ID ${System.identityHashCode(currentL2Node)}")
                            intersectionIndex.add(LMap[System.identityHashCode(currentL2Node)]!!)
                            intersectionIndex.add(list2Index)
                        return intersectionIndex
                }
                list2Index++
                currentL2Node = currentL2Node.next
        }
        return intersectionIndex
}

fun <T> loopDetection(list:LinkedList<T>) : Node<T>?{

        val LMap = HashMap<Int, Int>()

        var currentNode = list.head
        while (currentNode != null) {
                val hashCode = System.identityHashCode(currentNode)
                when (LMap[hashCode])
                {
                        null -> LMap[hashCode] = 0
                        else -> {
                                println("Circular List Found!")
                                println("Node Obj ID $hashCode")
                                return currentNode
                        }
                }

                currentNode = currentNode.next
        }

     println("This is not a Circular List")
        return null

}

fun intersectCheck(list1:LinkedList<Int>, list2:LinkedList<Int>){
        val intersectBase = intersection(list1 = list1, list2 = list2)


        if(intersectBase.isEmpty()){
                println("No intersection Found")
        }else{
                println("Intersection Found At:\n List 1 index = ${intersectBase.first()} \n List 2 index = ${intersectBase.last()} ")
        }

}

fun loopCheck(list:LinkedList<Int>){
        val loop = loopDetection(list)
        if(loop != null)
        {
                println("Circular Node value ${loop.value}")
        }

}