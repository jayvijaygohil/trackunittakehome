package com.jayvijay.mobilestore.ui.orders

import android.view.View
import android.widget.FrameLayout
import android.widget.TextView
import com.airbnb.epoxy.AfterPropsSet
import com.airbnb.epoxy.CallbackProp
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
    @EpoxyAttribute(EpoxyAttribute.Option.DoNotHash)
    var onOrderClickListener: View.OnClickListener? = null
        @CallbackProp set

    override fun bind(holder: OrderHolder) {
        super.bind(holder)
        holder.orderRoot.setOnClickListener(onOrderClickListener)
        holder.orderTitleTextView.text = "Order No: ${orderId}"
    }
}

class OrderHolder : KotlinEpoxyHolder() {
    val orderTitleTextView by bind<TextView>(R.id.tv_order_title)
    val orderRoot by bind<FrameLayout>(R.id.item_order_root)
}