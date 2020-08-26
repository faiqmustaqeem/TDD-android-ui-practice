package com.example.tddpractice.adpter

import android.app.Application
import android.content.Context
import android.view.LayoutInflater
import androidx.test.core.app.ApplicationProvider
import com.example.tddpractice.RoboElectricBaseTest
import com.example.tddpractice.databinding.RowItemBinding
import com.example.tddpractice.model.ItemModel
import junit.framework.TestCase
import org.junit.Before
import org.junit.Test

class ItemsAdapterTest : RoboElectricBaseTest() {
    private lateinit var adapter: ItemsAdapter

    @Before
    fun setup() {
        adapter = ItemsAdapter()
        adapter.setData(data)
    }

    @Test
    fun testAdapterSize() {
        TestCase.assertTrue(adapter.itemCount == data.size)
    }

    @Test
    fun testOnBindViewHolder() {
        val inflater: LayoutInflater =
            ApplicationProvider.getApplicationContext<Application>()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        val binding = RowItemBinding.inflate(inflater, null, false)

        val holder = ItemsAdapter.ItemViewHolder(binding)

        adapter.onBindViewHolder(holder, 0)

        TestCase.assertTrue(holder.binding.name.text == data[0].itemName)
    }

    val data = listOf(ItemModel("test item"))
}