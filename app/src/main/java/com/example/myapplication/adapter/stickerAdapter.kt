//package com.example.myapplication.adapter
//
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.recyclerview.widget.DiffUtil
//import androidx.recyclerview.widget.ListAdapter
//import androidx.recyclerview.widget.RecyclerView
//import androidx.recyclerview.widget.RecyclerView.ViewHolder
//import com.example.myapplication.model.sticker
//import com.example.myapplication.ViewHolderStickerBinding
//import com.squareup.picasso.Picasso
//
//
//class StickerAdapter : ListAdapter<sticker, StickerAdapter.StickerViewHolder>(
//
//
//    object : DiffUtil.ItemCallback<sticker>() {
//        override fun areItemsTheSame(oldItem: sticker, newItem: sticker): Boolean {
//            return oldItem == newItem
//        }
//
//        override fun areContentsTheSame(oldItem: sticker, newItem: sticker): Boolean {
//            return oldItem.id == newItem.id
//        }
//
//    }
//
//) {
//
//////
//
//    class StickerViewHolder(val itemBinding: ViewHolderBinding) : RecyclerView.ViewHolder(itemBinding.root) {
//
//        fun bind(province: sticker) {
//            Picasso.get().load(province.imageUrl).into(itemBinding.imgProvince)
//            itemBinding.txtName.text = sticker.name
//        }
//
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StickerViewHolder {
//        val layoutInflater = LayoutInflater.from(parent.context)
//        val binding = ViewHolderStickerBinding.inflate(layoutInflater, parent, false)
//        return StickerViewHolder(binding)
//    }
//
//    override fun onBindViewHolder(holder: StickerViewHolder, position: Int) {
//        val item = getItem(position)
//        holder.bind(item)
//    }
//}