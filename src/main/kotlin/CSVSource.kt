import java.io.File

class CSVSource<T>(val filename: String) : DataSource {

    private fun loadEmployees(employeeDao: EmployeeDao) {
        File(filename).forEachLine {
            val record = it.split("|")
            employeeDao.save(Employee(record[0], record[1], record[2].toInt()))
        }
    }

    override fun load(data: Dao<T>) {
        if (data is EmployeeDao) {
            loadEmployees(data)
        }
    }

    private fun writeEmployee(employeeDao: EmployeeDao) {
        val file = File(filename)
        employeeDao.all().forEach {
            q -> file.writeText("${q.firstname}|${q.lastname}|${q.age}")
        }
    }

    override fun update(data: Dao<T>) {
        if (data is EmployeeDao)
            writeEmployee(data)
    }


}