data class Node<T>(var value: T, var next: Node<T>? = null) {

    //override tostring method
    override fun toString(): String {
        return if (next != null) {
            "$value -> ${next.toString()}"
        } else {
            "$value"
        }
    }


}