package com.mypilog.presentation_common.util

import junit.framework.Assert.assertEquals
import org.junit.Assert
import org.junit.Test



class DateConverterKtTest {


    @Test
    fun `test date converter throws illegal argument exception when given invalid date`() {

        val invalidDate = "sep30,2020"
        Assert.assertThrows(IllegalArgumentException::class.java) {
            convertDate(invalidDate)
        }
    }

    @Test
    fun `test converter returns formatted date`() {
        val testCase1 = "9-30-2020"
        val result1 = "2020-09-30"

        val testCase2 = "10-2-2021"
        val result2 = "2021-10-02"

        assertEquals(result1, convertDate(testCase1))
        assertEquals(result2, convertDate(testCase2))
    }
}