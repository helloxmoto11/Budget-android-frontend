package com.mypilog.presentation_common.util

/**
 * Transforms a String date "9-30-2021" and returns formatted "2021-09-30"
 * @param date the input date
 * @return formatted date "yyyy-MM-dd".
 */
fun convertDate(date: String): String {
    if (!date.matches(Regex("\\d+-\\d+-\\d\\d\\d\\d"))) {
        throw IllegalArgumentException("Invalid input string. Example: \"9-30-2021\"")
    }

    val dateArr = date.split("-")
    val year = dateArr[2]
    val month = if (dateArr[0].length < 2) "0${dateArr[0]}" else dateArr[0]
    val day = if (dateArr[1].length < 2) "0${dateArr[1]}" else dateArr[1]

    return "$year-$month-$day"
}