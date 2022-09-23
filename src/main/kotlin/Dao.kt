interface Dao<T> {
    fun show()
    fun all() : MutableList<T>
}