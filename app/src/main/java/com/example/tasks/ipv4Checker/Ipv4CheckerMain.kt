package com.example.tasks.ipv4Checker

fun main(){

    test(
        "If given a valid IPv4 address, it should return true.",
        result = isValidIPv4Address( address= "192.168.0.1"),
        correctResult = true
    )

    test(
        "If given a valid IPv4 address, it should return true.",
        result = isValidIPv4Address( address= "255.255.255.255"),
        correctResult = true
    )

    test(
        "If the address consists of only three numeric segments, it should return false.",
        result = isValidIPv4Address( address= "192.168.1"),
        correctResult = false
    )

    test(
        "If any address segment is out of range, it should return false.",
        result = isValidIPv4Address( address= "192.168.1.256"),
        correctResult = false
    )

    test(
        "If a segment has a leading zero, it should return false.",
        result = isValidIPv4Address( address= "192.168.01.1"),
        correctResult = false
    )

    test(
        "If the address contains more than three dots, it should return false.",
        result = isValidIPv4Address( address= "192.168.1.1."),
        correctResult = false
    )

    test(
        "If the address contains invalid characters, it should return false.",
        result = isValidIPv4Address( address= "192.168@1.1"),
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