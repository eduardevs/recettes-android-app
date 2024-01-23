package com.example.a2_project_mvvm.view

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import androidx.recyclerview.widget.RecyclerView
import com.example.a2_project_mvvm.R
import com.example.a2_project_mvvm.model.Article
import com.example.a2_project_mvvm.view.adapters.ArticleAdapter
import com.example.a2_project_mvvm.view_model.ArticlesViewModel

class MainActivity : AppCompatActivity() {

    lateinit var articleAdapter: ArticleAdapter
    lateinit var textField: EditText

    lateinit var recyclerView: RecyclerView // this replace the line below MVVM
    //var articles:MutableList<Article> = mutableListOf(Article("tesd"))


    val viewModel = ArticlesViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // - here we replaced articles by viewModel
        //1. //1. articleAdapter = ArticleAdapter(articles = viewModel.articles.value, onDelete = {delete(it)})
        //* 2.

        recyclerView = findViewById(R.id.recycler)
        createOrUpdateAdapter()
        textField = findViewById(R.id.addTF)
        //recyclerView.adapter = articleAdapter
        val addButton: Button = findViewById(R.id.addButton)

        addButton.setOnClickListener {add()}
    }

    fun createOrUpdateAdapter() {
        if(viewModel.articles.value == null) return

        articleAdapter = ArticleAdapter(articles = viewModel.articles.value!!, onDelete = {})
        recyclerView.adapter = articleAdapter
        recyclerView.adapter?.notifyDataSetChanged()
    }


    fun add() {
        closeKeyboard()
        if(textField.text.isEmpty()) return
        val newArticle = Article(textField.text.toString())
       // articles.add(newArticle)
        textField.setText("")

        recyclerView.adapter?.notifyDataSetChanged()
    }


    fun delete(article: Article) {
      //  articles.remove(article)
        recyclerView.adapter?.notifyDataSetChanged()
    }

    // TO CLOSE KEYBOARD
    fun closeKeyboard() {
        if(currentFocus != null) {
            val manager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            manager.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
            textField.clearFocus()
        }
    }
}