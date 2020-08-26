package com.example.tddpractice

import com.example.tddpractice.model.ItemModel

class MainPresenter(val view: View) {

    private val list = arrayListOf<ItemModel>()

    fun addItem(value: String) {
        if(value.isNotBlank()){
            list.add(ItemModel(value))
            view.updateList(list)
            view.clearTextArea()
        }
        else{
            view.showErrorToast("Enter valid item name")
        }
    }

    interface View {
        fun updateList(list: List<ItemModel>)
        fun showErrorToast(message: String)
        fun clearTextArea()
    }
}