package com.jayvijay.mobilestore.ui.orders

import android.widget.TextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.jayvijay.mobilestore.R
import com.jayvijay.mobilestore.ui.base.KotlinEpoxyHolder

@EpoxyModelClass
abstract class OrderViewHolder: EpoxyModelWithHolder<OrderHolder>() {
    override fun getDefaultLayout(): Int = R.layout.item_order
    override fun shouldSaveViewState(): Boolean = true

    @EpoxyAttribute lateinit var orderId: String

    override fun bind(holder: OrderHolder) {
        super.bind(holder)

        holder.orderTitleTextView.text = "Order No: ${orderId}"
    }
}

class OrderHolder : KotlinEpoxyHolder() {
    val orderTitleTextView by bind<TextView>(R.id.tv_order_title)
}