import java.nio.file.Paths
import java.sql.Connection
import java.sql.DriverManager

class SQLiteSource(dbfile: String) : DataSource {

    private var conn : Connection? = null

    init {
        val dbpath = Paths.get(dbfile).toAbsolutePath()
        val url = "jdbc:sqlite:${dbpath}"
        conn = DriverManager.getConnection(url)
        println("Connected to database: $dbpath")
    }

    private fun loadEmployees(employeeData: EmployeeData) {
        val statement = conn?.createStatement()
        val result = statement?.executeQuery("select * from employees")
        if (result != null) {
            while (result.next()) {
                employeeData.addEmployee(result.getString(1), result.getString(2), result.getInt(3))
            }
        }
    }

    override fun load(data: Data) {
        if (data is EmployeeData) {
            loadEmployees(data)
        }
    }
}