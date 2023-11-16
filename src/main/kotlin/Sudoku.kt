
class Sudoku {
    private var puzzle = Array(9) { IntArray(9) }
    private fun isElementPresent(puzzle: Array<IntArray>, element: Int, i: Int, j: Int): Boolean {
        // Check if given element is already present in a given row and column.
        for (m in 0..8) {
            if (puzzle[i][m] == element) {
                return true
            }
        }
        for (m in 0..8) {
            if (puzzle[m][j] == element) {
                return true
            }
        }
        return false
    }

    fun makePuzzle() {
        // Try to create a solved sudoku.
        for (i in 0..8) {
            for (j in 0..8) {
                puzzle[i][j] = 0
            }
        }
        var indices: List<Int> = ArrayList(mutableListOf(0, 1, 2))
        for (x in 1..9) {
            for (i in 0..2) {
                for (j in 0..2) {
                    val si = 3 * i
                    val sj = 3 * j
                    indices = indices.shuffled()
                    val rowi: List<Int> = ArrayList(indices)
                    indices = indices.shuffled()
                    val coli: List<Int> = ArrayList(indices)
                    var isElementPlaced = false
                    outerloop@ for (k in 0..2) {
                        for (l in 0..2) {
                            val mi = si + rowi[k]
                            val mj = sj + coli[l]
                            if (puzzle[mi][mj] != 0) {
                                continue
                            }
                            if (!isElementPresent(puzzle, x, mi, mj)) {
                                puzzle[mi][mj] = x
                                isElementPlaced = true
                                break@outerloop
                            }
                        }
                    }
                    if (!isElementPlaced) {
                        throw Exception("Incorrect sudoku")
                    }
                }
            }
        }
    }

    fun showPuzzle() {
        // Show sudoku as a simple 9x9 matrix.
        for (i in 0..8) {
            for (j in 0..8) {
                val number = puzzle[i][j]
                print("$number ")
            }
            print("\n")
        }
    }
}