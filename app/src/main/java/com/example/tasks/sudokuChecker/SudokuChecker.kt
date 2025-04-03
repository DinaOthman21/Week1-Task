package com.example.tasks.sudokuChecker

import kotlin.math.sqrt

fun main(){

}

fun sudokuChecker(sudokuInput: Array<CharArray>): Boolean {
    return checkInputSize(sudokuInput) &&
            checkCellsValidation(sudokuInput) &&
            checkDuplicatesInRows(sudokuInput) &&
            checkDuplicatesInColumns(sudokuInput) &&
            checkDuplicatesInSubGrids(sudokuInput)
}


fun checkInputSize(sudokuInput: Array<CharArray>) : Boolean{
    val rows = sudokuInput.size
    val columns = sudokuInput[0].size
    if (rows != columns) {
        return false
    }
    for (row in sudokuInput) {
        if (row.size != columns) {
            return false
        }
    }
    return true
}


fun checkCellsValidation(sudokuInput: Array<CharArray>): Boolean {
    val gridSize = sudokuInput.size
    for (row in sudokuInput) {
        for (cell in row) {
            if (!cell.isDigit() && cell != '-') {
                return false
            }

            if (cell.isDigit()) {
                val num = cell.toString().toInt()
                if (num > gridSize || num ==0) {
                    return false
                }
            }
        }
    }
    return true
}


fun checkDuplicatesInRows(sudokuInput: Array<CharArray>): Boolean {
    for (row in sudokuInput) {
        val seen = mutableSetOf<Char>()
        for (cell in row) {
            if (cell != '-' && !seen.add(cell)) {
                return false
            }
        }
    }
    return true
}

fun checkDuplicatesInColumns(sudokuInput: Array<CharArray>): Boolean {
    val rows = sudokuInput.size
    val columns = sudokuInput[0].size

    for (col in 0 until columns) {
        val seen = mutableSetOf<Char>()
        for (row in 0 until rows) {
            val cell = sudokuInput[row][col]
            if (cell != '-' && !seen.add(cell)) {
                return false
            }
        }
    }
    return true
}


fun checkDuplicatesInSubGrids(sudokuInput: Array<CharArray>): Boolean {
    val n = sudokuInput.size
    val subgridSize = sqrt(n.toDouble()).toInt()
    for (i in 0 until n step subgridSize) {
        for (j in 0 until n step subgridSize) {
            val seen = mutableSetOf<Char>()
            for (x in i until i + subgridSize) {
                for (y in j until j + subgridSize) {
                    val cell = sudokuInput[x][y]
                    if (cell != '-' && !seen.add(cell)) {
                        return false
                    }
                }
            }
        }
    }
    return true
}






