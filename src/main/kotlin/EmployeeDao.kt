class EmployeeDao(db: DataSource) : Dao<Employee> {
    private var employees : MutableList<Employee> = mutableListOf()

    init {
        db.load(this)
    }

    fun save(employee: Employee) {
        employees.add(employee)
    }

    override fun show() {
        employees.forEach(Employee::show)
    }

    override fun all() = this.employees
}