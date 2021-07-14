package com.samba.squareoff.recycler_view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.samba.squareoff.R
import com.samba.squareoff.databinding.ItemFollowChessBinding
import com.samba.squareoff.recycler_view.model.RvModel

class RvAdapter(private val response: List<RvModel>) : RecyclerView.Adapter<RvAdapter.RvViewHolder>() {

    class RvViewHolder(val itemBinding: ItemFollowChessBinding) : RecyclerView.ViewHolder(itemBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RvViewHolder {
        return RvViewHolder(DataBindingUtil.inflate(
            LayoutInflater.from(parent.context), R.layout.item_follow_chess, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RvViewHolder, position: Int) {
        holder.itemBinding.model = response[position]
    }

    override fun getItemCount(): Int {
        print("Hello google ${response.size}")
        return response.size
    }
}