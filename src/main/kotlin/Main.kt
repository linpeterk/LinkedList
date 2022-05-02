fun main() {

        //Intersections
        //TEST CASE INTERSECTING NODE HAS VALUE OF -500

        val list1 = LinkedList<Int>() // List one for intersection
        val list2 = LinkedList<Int>() // List two for intersection
        val list3 =  LinkedList<Int>() // List three for loopDetection
        val node = Node(-50000) // Test node for intersection, -5000 is the intersected node

        list1.append(1).append(2).append(3).append(4).append(node).append(-1).append(-2)
        println(list1)

        list2.append(5).append(6).append(7).append(node)
        println(list2)

        val intersect = intersection(list1 = list1, list2 = list2)
        if(intersect.isEmpty()){
                println("No intersection")
        }else{
                println("\nIntersection Found At:\n List 1 index = ${intersect.first()} \n List 2 index = ${intersect.last()} ")
        }
      //  println(intersect)

        println()

        list3.append(1).append(2).append(3).append(node).append(5).append(6).append(node)
        //println(list3)

        //Loop Detection
        val loop = loopDetection(list3)
       if(loop != null)
       {
               println("Circular Node value ${loop.value}")
       }

}

fun intersection(list1:LinkedList<Int>, list2:LinkedList<Int>) : MutableList<Int>{

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

fun loopDetection(list:LinkedList<Int>) : Node<Int>?{

        val LMap = HashMap<Int, Int>()

        var currentNode = list.head
        while (currentNode != null) {
                val hashCode = System.identityHashCode(currentNode)
                when (LMap[hashCode])
                {
                        null -> LMap[hashCode] = 0
                        else -> {
                                println("Circular List Found:")
                                println("Node Obj ID $hashCode")
                                return currentNode
                        }
                }

                currentNode = currentNode.next
        }

     println("This is not a Circular List")
        return null

}