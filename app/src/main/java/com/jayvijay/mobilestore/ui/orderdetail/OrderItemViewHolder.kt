package com.jayvijay.mobilestore.ui.orderdetail

import android.widget.TextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.jayvijay.mobilestore.R
import com.jayvijay.mobilestore.ui.base.KotlinEpoxyHolder

@EpoxyModelClass
abstract class OrderItemViewHolder : EpoxyModelWithHolder<OrderHolder>() {
    override fun getDefaultLayout(): Int = R.layout.item_order_item
    override fun shouldSaveViewState(): Boolean = true

    @EpoxyAttribute
    lateinit var itemName: String

    @EpoxyAttribute
    lateinit var itemPrice: String

    override fun bind(holder: OrderHolder) {
        super.bind(holder)
        holder.itemName.text = itemName
        holder.itemPrice.text = "$ $itemPrice"
    }
}

class OrderHolder : KotlinEpoxyHolder() {
    val itemName by bind<TextView>(R.id.tv_item_name)
    val itemPrice by bind<TextView>(R.id.tv_item_price)
}