interface DataSource<T> {
    fun load(data: Dao<T>)
    fun update(data: Dao<T>)
}