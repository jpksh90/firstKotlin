import java.nio.file.Paths
import java.sql.Connection
import java.sql.DriverManager

class SQLiteSource<T>(dbfile: String) : DataSource<T> {

    private var conn : Connection? = null

    init {
        val dbpath = Paths.get(dbfile).toAbsolutePath()
        val url = "jdbc:sqlite:${dbpath}"
        conn = DriverManager.getConnection(url)
        println("Connected to database: $dbpath")
    }

    private fun loadEmployees(employeeDao: EmployeeDao) {
        val statement = conn?.createStatement()
        val result = statement?.executeQuery("select * from employees")
        if (result != null) {
            while (result.next()) {
                val emp = Employee(result.getString(1), result.getString(2), result.getInt(3))
                employeeDao.save(emp)
            }
        }
    }

    override fun load(data: Dao<T>) {
        if (data is EmployeeDao) {
            loadEmployees(data)
        }
    }

    private fun updateEmployee(employeeDao: EmployeeDao) {
        val statement = conn?.createStatement()
        println("not implemented")
    }

    override fun update(data: Dao<T>) {
        TODO("Not yet implemented")
    }
}