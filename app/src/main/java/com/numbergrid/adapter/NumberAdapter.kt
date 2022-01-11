package com.numbergrid.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.numbergrid.databinding.NumberCard180Binding
import com.numbergrid.databinding.NumberCardDefBinding
import com.numbergrid.model.NumberModel


class NumberAdapter(val context: Context) : RecyclerView.Adapter<NumberAdapter.ViewHolder>() {


    private var list = arrayListOf<NumberModel?>()
    private val VIEW_TYPE_ITEM = 0
    private val VIEW_TYPE_LOADING = 1

    fun setData(newItems: ArrayList<NumberModel?>) {
        list = newItems
        notifyDataSetChanged()
    }

    inner class ViewHolder(val binding: ViewBinding, itemView: View,val  viewType_insedr: Int) :
        RecyclerView.ViewHolder(itemView) {

        lateinit var  number_card_txt : TextView


        fun bind(numberModel: NumberModel) {

            if(viewType_insedr == 0){
                Log.e("viewType "+viewType_insedr,"binding")
                number_card_txt = (binding as NumberCardDefBinding).numberCardTxt
            }else{
                Log.e("viewType "+viewType_insedr,"binding180")
                number_card_txt = (binding as NumberCard180Binding).numberCardTxt
            }
            number_card_txt.text = numberModel.number.toString()
            val root = binding.root


        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View?
//        val binding = NumberCardDefBinding.inflate(LayoutInflater.from(context), parent, false)
//        val binding_180 = NumberCard180Binding.inflate(LayoutInflater.from(context), parent, false)
         var binding: ViewBinding
        if(viewType == 0){

            binding = NumberCardDefBinding.inflate(LayoutInflater.from(context), parent, false)
            Log.e("viewType_first "+viewType,"binding")
        }else{
            binding = NumberCard180Binding.inflate(LayoutInflater.from(context), parent, false)
            Log.e("viewType_first "+viewType,"binding180")
        }
         view = binding.root
        return ViewHolder(binding, view, viewType)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (list[position] != null) {
            holder.bind(list[position]!!)
        }

    }

    override fun getItemViewType(position: Int): Int {
        return if (list[position]?.isEqual == true) VIEW_TYPE_LOADING else VIEW_TYPE_ITEM
    }


}




