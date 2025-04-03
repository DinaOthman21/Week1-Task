package com.example.tasks.sudokuChecker

fun main(){

    test(
        "If given a valid Sudoku, it should return true." , // not complete
        result = sudokuChecker(
            sudokuInput= arrayOf(
                charArrayOf('5','3','-','-','7','-','-','-','-') ,
                charArrayOf('6','-','-','1','9','5','-','-','-') ,
                charArrayOf('-','9','8','-','-','-','-','6','-') ,
                charArrayOf('8','-','-','-','6','-','-','-','3') ,
                charArrayOf('4','-','-','8','-','3','-','-','1') ,
                charArrayOf('7','-','-','-','2','-','-','-','6') ,
                charArrayOf('-','6','-','-','-','-','2','8','-') ,
                charArrayOf('-','-','-','4','1','9','-','-','5') ,
                charArrayOf('-','-','-','-','8','-','-','4','9')
            )
        ) ,
        correctResult = true
    )

    test(
        "If a Sudoku contains duplicate numbers in a row, it should return false." ,
        result = sudokuChecker(
            sudokuInput= arrayOf(
                charArrayOf('5','3','-','-','7','-','-','-','-') ,
                charArrayOf('6','-','-','1','9','5','-','-','-') ,
                charArrayOf('-','9','8','-','-','-','-','6','-') ,
                charArrayOf('8','-','-','-','6','-','-','-','3') ,
                charArrayOf('4','-','-','8','-','3','-','-','1') ,
                charArrayOf('7','-','-','-','2','-','-','-','6') ,
                charArrayOf('-','6','-','-','-','-','2','8','-') ,
                charArrayOf('-','-','-','4','1','9','-','-','5') ,
                charArrayOf('-','5','-','-','8','-','5','7','9') // duplicate 5 in last row
            )
        ),
        correctResult = false
    )

    test(
        "If a Sudoku contains duplicate numbers in a column, it should return false." ,
        result = sudokuChecker(
            sudokuInput= arrayOf(
                charArrayOf('5','3','-','-','7','-','-','-','-') ,
                charArrayOf('6','-','-','1','9','5','-','-','-') ,
                charArrayOf('-','9','8','-','-','-','-','6','-') ,
                charArrayOf('8','-','-','-','6','-','-','-','3') ,
                charArrayOf('4','-','-','8','-','3','-','-','1') ,
                charArrayOf('7','-','-','-','2','-','-','-','6') ,
                charArrayOf('-','6','-','-','-','-','2','8','-') ,
                charArrayOf('-','-','-','4','1','9','-','-','5') ,
                charArrayOf('5','-','-','-','8','-','-','7','9')  // duplicate 5 in the first column
            )
        ),
        correctResult = false
    )

    test(
        "If given a valid 4×4 Sudoku, it should return true." , //complete
        result = sudokuChecker(
            sudokuInput= arrayOf(
                charArrayOf('1','2','3','4') ,
                charArrayOf('3','4','1','2') ,
                charArrayOf('2','1','4','3') ,
                charArrayOf('4','3','2','1')
            )
        ),
        correctResult = true
    )

    test(
        "If given an empty Sudoku, it should return true." ,
        result = sudokuChecker(
            sudokuInput= arrayOf(
                charArrayOf('-','-','-','-'),
                charArrayOf('-','-','-','-'),
                charArrayOf('-','-','-','-'),
                charArrayOf('-','-','-','-')
            )
        ),
        correctResult = true
    )

    test(
        "If there is a duplicate in a subgrid, it should return false.",
        result = sudokuChecker(
            sudokuInput = arrayOf(
                charArrayOf('5', '3', '9', '-', '7', '-', '-', '-', '-'), // duplicate in Top-Right subgrid (9)
                charArrayOf('-', '-', '-', '1', '9', '5', '-', '-', '-'),
                charArrayOf('-', '9', '8', '-', '-', '-', '-', '6', '-'),
                charArrayOf('8', '-', '-', '-', '6', '-', '-', '-', '3'),
                charArrayOf('4', '-', '-', '8', '-', '3', '-', '-', '1'),
                charArrayOf('7', '-', '-', '-', '2', '-', '-', '-', '6'),
                charArrayOf('-', '6', '-', '-', '-', '-', '2', '8', '-'),
                charArrayOf('-', '-', '-', '4', '1', '9', '-', '-', '5'),
                charArrayOf('-', '-', '-', '-', '8', '-', '-', '7', '9')
            )
        ),
        correctResult = false
    )

}


fun <T> test(name: String, result: T, correctResult: T) {
    if (result == correctResult) {
        println("Success - $name")
    } else {
        println("Failed - $name")
    }
}