fun main(args: Array<String>) {
    println("Reading from sample.txt")
    var employeeDao = EmployeeDao(CSVSource<EmployeeDao>("sample.txt"))
    employeeDao.show()
    println()
    employeeDao = EmployeeDao(SQLiteSource<EmployeeDao>("emp.db"))
    employeeDao.show()
}
