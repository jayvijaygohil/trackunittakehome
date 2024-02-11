package com.jayvijay.mobilestore.ui.orders

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import com.jayvijay.mobilestore.R
import com.jayvijay.mobilestore.databinding.FragmentOrdersBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.orbitmvi.orbit.viewmodel.observe

class OrdersFragment : Fragment() {
    private var _binding: FragmentOrdersBinding? = null
    private val viewModel: OrdersViewModel by viewModel()

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOrdersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.observe(
            lifecycleOwner = viewLifecycleOwner,
            state = ::render,
            sideEffect = ::handleSideEffect
        )

        viewModel.loadOrders()
    }

    private fun render(state: OrderState) {
        when (state.status) {
            is OrderStatus.Loading -> {
                binding.loading.isVisible = true
                binding.recyclerviewOrders.isVisible = false
            }

            is OrderStatus.Empty -> {
                binding.loading.isVisible = false
                binding.recyclerviewOrders.isVisible = false
            }

            is OrderStatus.Success -> {
                binding.loading.isVisible = false
                binding.recyclerviewOrders.isVisible = true
                binding.recyclerviewOrders.withModels {
                    state.status.data.forEach { order ->
                        orderViewHolder {
                            id(order.hashCode())
                            orderId(order.orderId)
                        }
                    }

                }
            }
        }
    }

    private fun handleSideEffect(sideEffect: OrderSideEffect) {
        when (sideEffect) {
            is OrderSideEffect.RetryToast -> showRetrySnackBar()
        }
    }

    private fun showRetrySnackBar() {
        val snackbar = Snackbar.make(binding.root, R.string.empty_error, Snackbar.LENGTH_INDEFINITE)
        snackbar
            .setAction(R.string.empty_error_action) {
                viewModel.loadOrders()
                snackbar.dismiss()
            }.show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}