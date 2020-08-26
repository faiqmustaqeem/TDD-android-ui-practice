package com.example.tddpractice

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tddpractice.adpter.ItemsAdapter
import com.example.tddpractice.databinding.ActivityMainBinding
import com.example.tddpractice.model.ItemModel

class MainActivity : AppCompatActivity(), MainPresenter.View {

    lateinit var presenter: MainPresenter
    lateinit var adapter: ItemsAdapter

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        presenter = MainPresenter(this)
        setupUI()

        binding.btnAdd.setOnClickListener {
            presenter.addItem(binding.edittext.text.toString())
        }

    }

    fun setupUI(){
        adapter= ItemsAdapter()
        binding.recycleview.layoutManager = LinearLayoutManager(this)
        binding.recycleview.adapter = adapter
    }

    override fun showErrorToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun clearTextArea() {
        binding.edittext.text.clear()
    }

    override fun updateList(list: List<ItemModel>) {
        adapter.setData(list)
    }
}