package com.jayvijay.mobilestore.ui.orderdetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.jayvijay.mobilestore.databinding.FragmentOrderDetailBinding

class OrderDetailFragment : Fragment() {
    private var _binding: FragmentOrderDetailBinding? = null
    private val binding get() = _binding!!

    private val args: OrderDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOrderDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerviewOrders.withModels {
            args.OrderItem.items.forEach { item ->
                orderItemViewHolder {
                    id(item.hashCode())
                    itemName(item.name)
                    itemPrice(item.price)
                }
            }
        }
    }
}