package com.haidev.pantaucorona.features.bantuan.views


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.haidev.pantaucorona.R
import com.haidev.pantaucorona.features.bantuan.adapters.ItemBantuanAdapter
import com.haidev.pantaucorona.features.bantuan.models.BantuanModel
import kotlinx.android.synthetic.main.fragment_bantuan.*

/**
 * A simple [Fragment] subclass.
 */
class BantuanFragment : Fragment() {

    private val listBantuan = ArrayList<BantuanModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_bantuan, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvBantuan.setHasFixedSize(true)
        rvBantuan.isNestedScrollingEnabled = false
        listBantuan.addAll(getListBantuan())
        showRecyclerList()
    }

    fun getListBantuan(): ArrayList<BantuanModel> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataPhone = resources.getStringArray(R.array.data_phone)
        val dataPhoto = resources.getStringArray(R.array.data_photo)

        val list = ArrayList<BantuanModel>()
        for (position in dataName.indices) {
            val hero = BantuanModel(
                dataName[position],
                dataPhoto[position],
                dataPhone[position]
            )
            list.add(hero)
        }
        return list
    }

    private fun showRecyclerList() {
        rvBantuan.layoutManager = LinearLayoutManager(context)
        val listHeroAdapter = ItemBantuanAdapter(listBantuan)
        rvBantuan.adapter = listHeroAdapter
    }
}
