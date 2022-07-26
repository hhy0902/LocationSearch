package org.techtown.locationsearch

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.techtown.locationsearch.databinding.ViewholderSearchResultItemBinding
import org.techtown.locationsearch.model.SearchResultEntity

class SearchRecyclerAdapter : RecyclerView.Adapter<SearchRecyclerAdapter.ViewHolder>() {

    private var searchResultList : List<SearchResultEntity> = listOf()
    private lateinit var searchResultClickListener : (SearchResultEntity) -> Unit

    inner class ViewHolder(val binding : ViewholderSearchResultItemBinding, val searchResultClickListener : (SearchResultEntity) -> Unit) : RecyclerView.ViewHolder(binding.root) {

        fun bind(data : SearchResultEntity) = with(binding) {
            textTextView.text = data.name
            subtextTextView.text = data.fullAdress
        }

        fun bindViews(data: SearchResultEntity) {
            binding.root.setOnClickListener {
                searchResultClickListener(data)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ViewholderSearchResultItemBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return ViewHolder(view, searchResultClickListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(searchResultList.get(position))
        holder.bindViews(searchResultList.get(position))
    }

    override fun getItemCount(): Int = searchResultList.size

    fun setSearchResultList(searchResultList: List<SearchResultEntity>, searchResultClickListener : (SearchResultEntity) -> Unit) {
        this.searchResultList = searchResultList
        this.searchResultClickListener = searchResultClickListener

    }

}