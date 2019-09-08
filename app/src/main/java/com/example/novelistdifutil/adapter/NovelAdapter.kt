package com.example.novelistdifutil.adapter

import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.novelistdifutil.R
import com.example.novelistdifutil.data.Novelist
import com.example.novelistdifutil.utils.NovelistDifUtil

class NovelAdapter (val myList: List<Novelist>, val novelistClick: (Novelist) -> Unit) : RecyclerView.Adapter<NovelAdapter.NovelVH>() {

    private var list: MutableList<Novelist> = mutableListOf()

    init {
        list.addAll(myList)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NovelVH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_novelis, parent, false)
        return NovelVH(view)
    }

    override fun getItemCount(): Int {
       return list.size
    }

    override fun onBindViewHolder(holder: NovelVH, position: Int) {

        val novelist = list[position]
        holder.bind(novelist)

        holder.itemView.setOnClickListener {
            novelistClick(novelist)
        }
    }

    fun replaceOldNew(newList: List<Novelist>){
        val difUtil = NovelistDifUtil(list, newList)
        val result = DiffUtil.calculateDiff(difUtil)
        list.clear()
        list.addAll(newList)
        result.dispatchUpdatesTo(this)
    }

    inner class NovelVH(view: View) : RecyclerView.ViewHolder(view){
        val name = view.findViewById<TextView>(R.id.name)
        val year = view.findViewById<TextView>(R.id.year)
        val novelName = view.findViewById<TextView>(R.id.novel)

        fun bind(novel: Novelist){
            name.text = novel.name
            year.text = String.format(year.context.getString(R.string.novel_year), novel.year)
            novelName.text = String.format(novelName.context.getString(R.string.novel), novel.novel)
        }
    }
}