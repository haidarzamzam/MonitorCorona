package com.haidev.monitorcorona.features.bantuan.adapters

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.haidev.monitorcorona.R
import com.haidev.monitorcorona.features.bantuan.models.BantuanModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_layout_bantuan.view.*


class ItemBantuanAdapter(private val listBantuan: ArrayList<BantuanModel>) :
    RecyclerView.Adapter<ItemBantuanAdapter.ItemBantuanViewHolder>() {

    class ItemBantuanViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(bantuanModel: BantuanModel) {
            with(itemView) {
                Picasso.get().load(bantuanModel.photo).into(itemView.ivLogoBantuan)

                itemView.tvNameBantuan.text = bantuanModel.name
                itemView.tvNoBantuan.setText(bantuanModel.phone)

                itemView.btnHubungiBantuan.setOnClickListener {
                    val intent = Intent(Intent.ACTION_DIAL)
                    intent.data = Uri.parse("tel:${bantuanModel.phone}")
                    context.startActivity(intent)
                }

                itemView.btnSalinBantuan.setOnClickListener {
                    val clipboard =
                        it.context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                    val myClip = ClipData.newPlainText("label", bantuanModel.phone)
                    clipboard.setPrimaryClip(myClip)
                    Toast.makeText(it.context, "No bantuan sudah tersalin", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemBantuanViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_layout_bantuan, parent, false)
        return ItemBantuanViewHolder(view)
    }

    override fun getItemCount(): Int = listBantuan.size

    override fun onBindViewHolder(holder: ItemBantuanViewHolder, position: Int) {
        holder.bind(listBantuan[position])
    }

}