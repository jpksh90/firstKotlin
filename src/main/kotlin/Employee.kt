data class Employee(val firstname: String, val lastname: String, val age: Int) {
    private val separator = ":"

    private fun formatheader(header: String): String {
        return String.format("%-15s$separator", header)
    }

    fun show() {
        println(formatheader("First Name") + firstname)
        println(formatheader("Last Name") + lastname)
        println(formatheader("Age") + age)
        println()
    }
}