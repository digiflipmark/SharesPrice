package com.investing.market.ui

import android.annotation.SuppressLint
import android.graphics.Color
import android.icu.text.NumberFormat
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.investing.market.R
import com.investing.market.data.obj.Coins
import java.util.*

class StockAdapter() :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    val data: MutableList<Coins> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return StockHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.stock_item, parent, false)
        )
    }

    @SuppressLint("SetTextI18n", "ResourceType")
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        val stockHolder = holder as StockHolder
        stockHolder.tv_symbol.text = data[position].symbol
        stockHolder.tv_comnay.text = data[position].identifier

        val format =
            NumberFormat.getCurrencyInstance(Locale("en", "IN")).format(data[position].lastPrice)
        stockHolder.tv_open.text = format.toString()
        stockHolder.tv_change.text =
            "" + roundTheNumber(data[position].change as Double) + "(" + data[position].pChange.toString() + "%" + ")"

        holder.tv_change.setTextColor(
            if (roundTheNumber(data[position].change as Double).contains("-")) {
                Color.parseColor("#FF0000")
            } else {
                Color.parseColor("#32CD32")
            }
        )

        holder.tv_change.setTextColor(
            if (data[position].pChange.toString().contains("-")) {
                Color.parseColor("#FF0000")
            } else {
                Color.parseColor("#32CD32")
            }
        )


    }


    override fun getItemCount(): Int {
        return data.size
    }


    private var itemClickListener: ((data: Coins) -> Unit)? = null

    fun setOnClick(itemClickListener: ((data: Coins) -> Unit)) {
        this.itemClickListener = itemClickListener
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addiItem(list: List<Coins>) {
        data.addAll(list)
        notifyDataSetChanged()
    }

    inner class StockHolder(view: View) : RecyclerView.ViewHolder(view) {

        val tv_symbol = view.findViewById<TextView>(R.id.tv_symbol)
        val tv_comnay = view.findViewById<TextView>(R.id.tv_comnay)
        val tv_open = view.findViewById<TextView>(R.id.tv_open)
        val tv_change = view.findViewById<TextView>(R.id.tv_change)
    }

    private fun roundTheNumber(numInDouble: Double): String {

        return "%.2f".format(numInDouble)

    }
}