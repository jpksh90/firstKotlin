class EmployeeData(private val db: DataSource) : Data {
    private var employees : MutableList<Employee> = mutableListOf<Employee>()

    init {
        db.load(this)
    }

    fun addEmployee(firstname: String, lastname: String, age: Int) {
        employees.add(Employee(firstname, lastname, age))
    }

    override fun show() {
        employees.forEach(Employee::show)
    }
}