package com.example.novelistdifutil.utils

import androidx.recyclerview.widget.DiffUtil
import com.example.novelistdifutil.data.Novelist

class NovelistDifUtil(val old: List<Novelist>, val new: List<Novelist>) : DiffUtil.Callback() {

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return old[oldItemPosition].id == new[newItemPosition].id
    }

    override fun getOldListSize(): Int {
     return old.size
    }

    override fun getNewListSize(): Int {
       return new.size
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
       return old[oldItemPosition].id == new[newItemPosition].id && old[oldItemPosition].name == new[newItemPosition].name &&
               old[oldItemPosition].year == new[newItemPosition].year && old[oldItemPosition].link == new[newItemPosition].link
    }
}