package com.example.crud

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.example.crud.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var viewModel: GuestFromViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(GuestFromViewModel::class.java)

        binding.buttoncreate.setOnClickListener(this)
    }

    fun clearEdit(){

        binding.editname.text = null
        binding.editprice.text = null
        binding.editstock.text = null
        binding.editcategory.text = null

    }

    override fun onClick(v: View) {
        if (v.id == R.id.buttoncreate) {
            val name = binding.editname.text.toString()
            val price = binding.editprice.text.toString()
            val stock = binding.editstock.text.toString()
            val category = binding.editcategory.text.toString()

            val model = GuestModel(0, name, price, stock, category)
            viewModel.insert(model)
             clearEdit()

        }
    }
}
