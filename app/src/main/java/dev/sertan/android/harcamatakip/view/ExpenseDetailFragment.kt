package dev.sertan.android.harcamatakip.view

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.google.android.material.transition.MaterialContainerTransform
import dagger.hilt.android.AndroidEntryPoint
import dev.sertan.android.harcamatakip.R
import dev.sertan.android.harcamatakip.databinding.FragmentDetailExpenseBinding
import dev.sertan.android.harcamatakip.view.base.BaseFragment
import dev.sertan.android.harcamatakip.viewmodel.ExpenseDetailViewModel

@AndroidEntryPoint
class ExpenseDetailFragment :
    BaseFragment<FragmentDetailExpenseBinding>(R.layout.fragment_detail_expense) {

    private val viewModel: ExpenseDetailViewModel by viewModels()
    private val args: ExpenseDetailFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedElementEnterTransition = MaterialContainerTransform().apply {
            duration = resources.getInteger(R.integer.duration_motion_m).toLong()
            scrimColor = Color.TRANSPARENT
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
        binding.expense = args.expense
    }
}
