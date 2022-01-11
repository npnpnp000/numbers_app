package com.numbergrid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.numbergrid.adapter.NumberAdapter
import com.numbergrid.databinding.ActivityMainBinding
import androidx.recyclerview.widget.GridLayoutManager
import com.numbergrid.ViewModel.NumbersViewModel
import com.numbergrid.model.NumberModel


class MainActivity : AppCompatActivity() {

    private lateinit var NumbersVM: NumbersViewModel
    private lateinit var binding: ActivityMainBinding
    private lateinit var recyclerView_adapter: NumberAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // get ViewModel
        NumbersVM = ViewModelProvider(this)[NumbersViewModel::class.java]

        setNumberRecyclerView()

        ObserverOfChange()
    }

    private fun ObserverOfChange() {

        NumbersVM.getNumbers().observe(this,  object  : Observer<ArrayList<NumberModel?>>{
            override fun onChanged(list: ArrayList<NumberModel?>?) {

                setRecyclerViewAdapter(list!!)

            }
        })

    }

    private fun setNumberRecyclerView() {

        recyclerView_adapter = NumberAdapter(this)

        binding.numberRcv.layoutManager =
            GridLayoutManager(this, 3)

        setRecyclerViewAdapter(arrayListOf())

        NumbersVM.searchNumber()

    }

    // function to set the data of the RecyclerView
    private fun setRecyclerViewAdapter(list: ArrayList<NumberModel?>) {
        binding.numberRcv.adapter = recyclerView_adapter // set new Adapter
        recyclerView_adapter.setData(list)               // add the new data
    }
}