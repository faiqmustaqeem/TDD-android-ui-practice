package com.example.tddpractice

import org.junit.Before
import org.mockito.ArgumentCaptor
import org.mockito.MockitoAnnotations

open class BaseTest {

    @Before
    fun initMocks() {
        MockitoAnnotations.initMocks(this)
    }


    protected fun <T> capture(argumentCaptor: ArgumentCaptor<T>): T = argumentCaptor.capture()
}