package com.example.a2_project_mvvm.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.a2_project_mvvm.R
import com.example.a2_project_mvvm.model.Article

class ArticleAdapter(val articles: List<Article>, val onDelete: (Article )-> Unit): RecyclerView.Adapter<ArticleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.article_layout, parent, false)

        return ArticleViewHolder(view)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val article = articles[position]
        holder.name.text = article.name
        holder.btn.setOnClickListener{onDelete(article) }
    }

    override fun getItemCount(): Int {
        return articles.size
    }
}