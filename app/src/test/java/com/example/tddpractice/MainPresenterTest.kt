package com.example.tddpractice

import com.example.tddpractice.model.ItemModel
import com.nhaarman.mockitokotlin2.argumentCaptor
import com.nhaarman.mockitokotlin2.never
import junit.framework.Assert.assertEquals
import org.junit.Test
import org.mockito.ArgumentMatchers
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.verify


@Suppress("UNCHECKED_CAST")
class MainPresenterTest : BaseTest() {
    @Mock
    lateinit var view: MainPresenter.View

    @InjectMocks
    lateinit var presenter: MainPresenter

    @Test
    fun `item should add in list and notify after adding`() {
        presenter.addItem("item")

        verify(view).clearTextArea()
        argumentCaptor<List<ItemModel>>().apply {
            verify(view).updateList(capture())
            assertEquals("item", allValues[0][0].itemName)
        }
    }

    @Test
    fun `item should not add in list if blank and view shouldnt be notified`() {
        presenter.addItem(" ")

        verify(view, never()).clearTextArea()
        argumentCaptor<List<ItemModel>>().apply {
            verify(view, never()).updateList(ArgumentMatchers.anyList())
        }
    }


}