class LinkedList<T> {

     var head: Node<T>? = null
     var tail: Node<T>? = null
     //val map = LinkedHashMap<Int, Int>()
     var size = 0
    val list = mutableListOf<Int>()

    fun isEmpty(): Boolean {
        return size == 0
    }

    //print entire linkedlist
    override fun toString(): String {
        if (isEmpty()) {
            return "Empty list"
        } else {
            return head.toString()
        }
    }

    //add to front of linked list
    fun push(value: T) : LinkedList<T>{
        var new = Node(value = value, next = head)
        if(head != null){
            head!!.previous = new
        }
        head = new
        if (tail == null) {
            tail = head
            if(value is Int) {
                list.add(value)
            }
        }
        if(value is Int){
            if(value < list.last()){
                list.add(value)
            }
        }
//        if(value < (min?.value)){
//
//        }
        size++
        return this
    }

    fun pop() : LinkedList<T>{
        if(head?.value is Int){
            if(head!!.value == list.last()){
                list.removeLast()
            }
        }
       head = head?.next
        head?.previous = null
        size--

        return this
    }

    fun min(): Int?{
        return list.last()

    }

    //tail insertion
    fun append(value: T) : LinkedList<T>{
        // 1
        if (isEmpty()) {
            push(value)
            return this
        }
        // 2
        var new = Node(value = value, previous = tail)
        tail?.next = new

        // 3
        tail = tail?.next
        size++
        return this
    }
/*
    fun append(node: Node<T>) : LinkedList<T>{
        // 1
        if (isEmpty()) {
           println("List is empty, cannot append node")
        }
        // 2
        tail?.next = node

        // 3
        tail = tail?.next
        size++
        return this
    }

    //find the node to insert
    fun nodeAt(index: Int): Node<T>? {
        // 1
        var currentNode = head
        var currentIndex = 0

        // 2
        while (currentNode != null && currentIndex < index) {
            currentNode = currentNode.next
            currentIndex++
        }

        return currentNode
    }

    //insert
    fun insert(value: T, afterNode: Node<T>): Node<T> {
        // 1
        if (tail == afterNode) {
            append(value)
            return tail!!
        }
        // 2
        val newNode = Node(value = value, next = afterNode.next)
        // 3
        afterNode.next = newNode
        size++
        return newNode
    }
*/
}