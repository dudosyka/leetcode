class RandomizedSet() {
    val items = mutableListOf<Int>()
    val values = mutableMapOf<Int, Int>()

    fun insert(v: Int): Boolean {
        if (values[v] == null) {
            items.add(v)
            values[v] = items.lastIndex
            return true;
        }
        return false

    }

    fun remove(v: Int): Boolean {
        val index = values[v]
        if (index == null) return false;

        val lastItem = items.last()
        items[index] = lastItem
        values[lastItem] = index

        items.removeLast()

        values.remove(v)

        return true
    }

    fun getRandom(): Int {
        return items.random()
    }

}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * var obj = RandomizedSet()
 * var param_1 = obj.insert(`val`)
 * var param_2 = obj.remove(`val`)
 * var param_3 = obj.getRandom()
 */