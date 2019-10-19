package com.example.catsapi.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.catsapi.R
import com.example.catsapi.models.All
import com.example.catsapi.models.Cat
import kotlinx.android.synthetic.main.layout_item_cat.view.*

class CatsAdapter(private val cats: List<All>)
    : RecyclerView.Adapter<CatsAdapter.CatViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            = CatViewHolder(
        LayoutInflater.from(parent.context)
        .inflate(R.layout.layout_item_cat, parent, false))

    override fun onBindViewHolder(holder: CatViewHolder, position: Int) {
        holder.bindPlan(cats[position])
    }

    override fun getItemCount() = cats.size

    inner class CatViewHolder(view: View): RecyclerView.ViewHolder(view) {

        fun bindPlan(catInfo: All) {
            itemView.cat_text.text = catInfo.text
//            itemView.title.text = plan.title
//            itemView.content.text = plan.content
//            itemView.priority.text = plan.priority
//            var color = when(plan.priority){
//                "low" -> Color.WHITE
//                "medium" -> Color.YELLOW
//                "high" ->  Color.RED
//                else -> Color.BLACK
//            }
//            itemView.setBackgroundColor(color)
        }
    }
}