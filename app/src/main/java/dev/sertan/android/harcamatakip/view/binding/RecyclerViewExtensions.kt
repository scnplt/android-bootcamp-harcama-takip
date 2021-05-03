package dev.sertan.android.harcamatakip.view.binding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.sertan.android.harcamatakip.view.adapter.HomeAdapter

@BindingAdapter("set_adapter")
fun RecyclerView.adapter(adapter: HomeAdapter) {
    if (layoutManager == null)
        layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    this.adapter = adapter
}