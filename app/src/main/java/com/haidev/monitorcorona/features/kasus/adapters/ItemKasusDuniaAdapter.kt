package com.haidev.monitorcorona.features.kasus.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.haidev.monitorcorona.R
import com.haidev.monitorcorona.databinding.ItemKasusDuniaBinding
import com.haidev.monitorcorona.features.kasus.models.KasusDuniaAttributes
import com.haidev.monitorcorona.features.kasus.viewmodels.ItemKasusDuniaViewModel

class ItemKasusDuniaAdapter(
    private val context: Context,
    private var listKasus: MutableList<KasusDuniaAttributes>
) :
    RecyclerView.Adapter<ItemKasusDuniaAdapter.ItemKasusViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ItemKasusViewHolder {
        val binding: ItemKasusDuniaBinding =
            DataBindingUtil.inflate(
                LayoutInflater.from(context),
                R.layout.item_kasus_dunia,
                parent,
                false
            )
        return ItemKasusViewHolder(
            binding
        )
    }

    override fun getItemCount(): Int {
        return listKasus.size
    }

    override fun onBindViewHolder(holder: ItemKasusViewHolder, position: Int) {
        val fixPosition = holder.adapterPosition
        holder.bindBinding(listKasus[fixPosition])
    }

    class ItemKasusViewHolder(val binding: ItemKasusDuniaBinding) :
        RecyclerView.ViewHolder(binding.root) {

        private lateinit var viewModel: ItemKasusDuniaViewModel

        fun bindBinding(model: KasusDuniaAttributes) {
            viewModel =
                ItemKasusDuniaViewModel(
                    model
                )
            binding.itemKasusDunia = viewModel
            binding.executePendingBindings()
        }

    }
}