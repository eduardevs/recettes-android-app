package com.example.a2_project_mvvm.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.a2_project_mvvm.model.Article

class ArticlesViewModel: ViewModel() {
    private val _startDatas: List<Article> = mutableListOf(Article("in view model"))
    private val _articles: MutableLiveData<List<Article>> = MutableLiveData(_startDatas)
    // on veut que ceci soit exposé à l'exterieur
    val articles: LiveData<List<Article>>
        get() = _articles

    fun add(name: String) {
        if(name.isEmpty()) return
        // on est different de nul ? { it?
        _articles.value = articles.value.let { it?.plus(Article(name))}
    }

    fun delete(article: Article) {
        val list: MutableList<Article> = _articles.value as MutableList<Article>
        // etant donné qu'elle est inmutable et pas les autres
        list.remove(article)
        // on notifie aux articles que la nouvelle valeur sera egal a lsit
        _articles.value = list
    }
}