package dev.sertan.android.harcamatakip.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class BaseAdapter<D : Any, VB : ViewBinding> :
    RecyclerView.Adapter<BaseAdapter.ViewHolder<VB>>() {

    var data: List<D>
        get() = asyncListDiffer.currentList
        set(value) = asyncListDiffer.submitList(value)

    override fun getItemCount(): Int = data.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder<VB> =
        ViewHolder(getBinding(parent))

    private val asyncListDiffer = getListDiffer()

    private fun getListDiffer() = AsyncListDiffer(this, diffCallback)

    private fun getBinding(parent: ViewGroup): VB {
        val inflater = LayoutInflater.from(parent.context)
        return DataBindingUtil.inflate(inflater, getLayoutID(), parent, false)
    }

    abstract val diffCallback: DiffUtil.ItemCallback<D>

    @LayoutRes
    abstract fun getLayoutID(): Int

    class ViewHolder<VB : ViewBinding>(val binding: VB) : RecyclerView.ViewHolder(binding.root)
}