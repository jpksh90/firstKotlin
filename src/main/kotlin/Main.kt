fun main(args: Array<String>) {
    println("Reading from sample.txt")
    var employeeData = EmployeeData(CSVSource("sample.txt"))
    employeeData.show()
    println()
    employeeData = EmployeeData(SQLiteSource("emp.db"))
    employeeData.show()
}
