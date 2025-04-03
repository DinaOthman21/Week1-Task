package com.example.tasks.ipv4Checker

fun main(){

}

fun isValidIPv4Address(address:String) : Boolean{
    val segments : List<String> = address.split(".")
    return checkSegmentCount(segments) &&
            checkEachSegment(segments)
}


fun checkSegmentCount(segments: List<String>): Boolean {
    return segments.size == 4
}


fun checkEachSegment(segments: List<String>): Boolean {
    for (segment in segments) {
        if (!isValidSegment(segment)) {
            return false
        }
    }
    return true
}


fun isValidSegment(segment: String): Boolean {
    if (segment.isEmpty() || segment.length > 3) return false
    if (!segment.all { it.isDigit() }) return false
    if (segment.length > 1 && segment.startsWith("0")) return false

    val num = segment.toInt()
    return num in 0..255
}








