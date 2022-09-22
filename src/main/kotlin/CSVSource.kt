import java.io.File

class CSVSource(val filename: String) : DataSource {

    private fun loadEmployees(employeeData: EmployeeData) {
        File(filename).forEachLine {
            val record = it.split("|")
            employeeData.addEmployee(record[0], record[1], record[2].toInt())
        }
    }

    override fun load(data: Data) {
        if (data is EmployeeData) {
            loadEmployees(data)
        }
    }


}