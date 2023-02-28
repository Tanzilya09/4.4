package com.example.a43.ui.adapters

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.a43.databinding.ItemBinding
import com.example.a43.interfaces.OnClickItem
import com.example.a43.model.NoteModel

class NoteAppAdapter (
    private var list: ArrayList<NoteModel>,
    private val onLongClickItem: OnClickItem
) :
    RecyclerView.Adapter<NoteAppAdapter.NotAppViewHolder>() {

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: ArrayList<NoteModel>) {
        this.list = list
        notifyDataSetChanged()
    }

    inner class NotAppViewHolder(private val binding: ItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(noteModel: NoteModel) {
            binding.tvItemOne.text = noteModel.line
            binding.tvItemTime.text = noteModel.number
            binding.tvItemNumber.text = noteModel.time
            binding.cardView.setCardBackgroundColor(Color.parseColor(noteModel.color))
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotAppViewHolder {
        return NotAppViewHolder(
            ItemBinding.inflate(LayoutInflater.from(parent.context),
            parent,
            false))
    }

    override fun onBindViewHolder(holder: NotAppViewHolder, position: Int) {
        holder.onBind(list[position])

        holder.itemView.setOnLongClickListener {
            onLongClickItem.onLongClick(list[position])
            true
        }
    }

    override fun getItemCount(): Int = list.size

}