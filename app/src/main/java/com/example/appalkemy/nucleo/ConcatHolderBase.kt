package com.example.appalkemy.nucleo

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class ConcatHolderBase<T>(itemView:View):RecyclerView.ViewHolder(itemView) {
    abstract fun bindeo(adapter:T)
}