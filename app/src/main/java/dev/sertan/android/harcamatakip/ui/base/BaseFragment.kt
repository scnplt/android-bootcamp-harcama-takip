package dev.sertan.android.harcamatakip.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<VB : ViewBinding> : Fragment() {
    protected var binding: VB? = null
    protected var container: ViewGroup? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        this.container = container
        binding = getViewDataBinding()
        return binding!!.root
    }

    override fun onDestroyView() {
        binding = null
        container = null
        super.onDestroyView()
    }

    abstract fun getViewDataBinding(): VB
}