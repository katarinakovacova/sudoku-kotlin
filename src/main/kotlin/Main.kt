fun main(args: Array<String>) {
    val sudoku = Sudoku()
    var count = 0
    while (true) {
        try {
            sudoku.makePuzzle()
            break
        } catch (e: Exception) {
            count++
        }
    }
    println("Number of failed attempts: $count")
    sudoku.showPuzzle()
}