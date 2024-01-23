package com.example.a2_project_mvvm.view.adapters

import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.a2_project_mvvm.R

class ArticleViewHolder (view: View): RecyclerView.ViewHolder(view){
    val name: TextView = view.findViewById(R.id.article_name)
    val btn: ImageButton = view.findViewById(R.id.delete_button)
}