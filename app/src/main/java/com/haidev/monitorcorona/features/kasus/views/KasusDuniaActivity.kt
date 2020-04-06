package com.haidev.monitorcorona.features.kasus.views

import android.os.Bundle
import android.os.Handler
import android.view.MenuItem
import android.view.View
import android.view.WindowManager
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.haidev.monitorcorona.R
import com.haidev.monitorcorona.databinding.ActivityKasusDuniaBinding
import com.haidev.monitorcorona.features.kasus.adapters.ItemKasusDuniaAdapter
import com.haidev.monitorcorona.features.kasus.models.KasusDuniaAttributes
import com.haidev.monitorcorona.features.kasus.models.KasusDuniaModel
import com.haidev.monitorcorona.features.kasus.viewmodels.KasusDuniaViewModel
import kotlinx.android.synthetic.main.activity_kasus_dunia.*
import kotlinx.android.synthetic.main.bottomsheet_provinsi.view.close
import kotlinx.android.synthetic.main.bottomsheet_reload.view.*
import retrofit2.HttpException
import java.text.DecimalFormat
import javax.net.ssl.HttpsURLConnection

class KasusDuniaActivity : AppCompatActivity() {

    private lateinit var kasusDuniaBinding: ActivityKasusDuniaBinding
    private lateinit var vmKasusDunia: KasusDuniaViewModel

    private lateinit var adapterRecycler: ItemKasusDuniaAdapter
    private var listKasusDunia: MutableList<KasusDuniaAttributes> = mutableListOf()

    var dialogLoad: android.app.AlertDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        kasusDuniaBinding = DataBindingUtil.setContentView(this, R.layout.activity_kasus_dunia)
        vmKasusDunia = ViewModelProvider(this).get(KasusDuniaViewModel::class.java)
        kasusDuniaBinding.kasusDunia = vmKasusDunia

        initToolbar()
        initRecyclerView()
        getData()
        vmKasusDunia.kasusDuniaResponse.observe(this, Observer {
            onGetData(it)
        })

        vmKasusDunia.errorKasusDunia.observe(this, Observer {
            onErrorData(it)
        })

        kasusDuniaBinding.btnBackKasusDunia.setOnClickListener {
            finish()
        }
    }

    private fun initToolbar() {
        setSupportActionBar(toolbarKasusDunia)

        var isShow = true
        var scrollRange = -1
        appBarKasusDunia.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { barLayout, verticalOffset ->
            if (scrollRange == -1) {
                scrollRange = barLayout?.totalScrollRange!!
            }
            if (scrollRange + verticalOffset == 0) {
                collapsing_toolbar.title = "Kasus COVID-19 Global"
                supportActionBar?.setDisplayHomeAsUpEnabled(true)
                toolbarKasusDunia.setNavigationIcon(R.drawable.ic_arrow_24dp)
                isShow = true
            } else if (isShow) {
                collapsing_toolbar.title = " "
                supportActionBar?.setDisplayHomeAsUpEnabled(false)
                isShow = false
            }
        })
    }

    fun getData() {
        val builder = android.app.AlertDialog.Builder(this)
        val dialogView = layoutInflater.inflate(R.layout.progress_dialog, null)
        val message = dialogView.findViewById<TextView>(R.id.txtProgressBar)
        message.text = "Loading. . ."
        builder.setView(dialogView)
        builder.setCancelable(false)
        dialogLoad = builder.create()
        dialogLoad!!.show()
        vmKasusDunia.getDataKasusDunia()
    }

    private fun initRecyclerView() {
        val lManager = LinearLayoutManager(this)
        kasusDuniaBinding.rvKasusDunia.layoutManager = lManager
        kasusDuniaBinding.rvKasusDunia.setHasFixedSize(true)

    }

    private fun onGetData(it: MutableList<KasusDuniaModel>?) {
        dialogLoad?.dismiss()
        listKasusDunia.clear()
        var totalKasusDunia = 0

        for (i in it?.indices!!) {
            listKasusDunia.add(it[i].attributes)
            totalKasusDunia += it[i].attributes.deaths + it[i].attributes.confirmed + it[i].attributes.recovered
        }

        Handler().postDelayed({
            if (::adapterRecycler.isInitialized) {
                adapterRecycler.notifyDataSetChanged()
            } else {
                adapterRecycler = ItemKasusDuniaAdapter(this, listKasusDunia)
                kasusDuniaBinding.rvKasusDunia.adapter = adapterRecycler
            }
            kasusDuniaBinding.progressBarKasus.visibility = View.GONE
        }, 0)

        val formatter = DecimalFormat("#,###,###")
        val jumlahKasusDunia = formatter.format(totalKasusDunia)
        kasusDuniaBinding.tvTotalKasus.text = jumlahKasusDunia
    }

    private fun onErrorData(it: Throwable?) {
        dialogLoad?.dismiss()
        if (it is HttpException) {
            when (it.code()) {
                HttpsURLConnection.HTTP_BAD_REQUEST -> {
                    onReloadData("Sepertinya ada kendala nih, kamu bisa coba lagi")
                }
                HttpsURLConnection.HTTP_FORBIDDEN -> {
                    onReloadData("Sepertinya ada kendala nih, kamu bisa coba lagi")
                }
                HttpsURLConnection.HTTP_INTERNAL_ERROR -> {
                    onReloadData("Sepertinya ada kendala nih, kamu bisa coba lagi")
                }
                else -> {
                    onReloadData("Sepertinya ada kendala nih, kamu bisa coba lagi")
                }
            }
        }
        onReloadData("Coba cek internet kamu, masih nyambung ga?")
    }

    fun onReloadData(message: String) {
        val view = layoutInflater.inflate(R.layout.bottomsheet_reload, null)
        val dialog = BottomSheetDialog(this, R.style.BaseBottomSheetDialog)
        view.close.setOnClickListener {
            dialog.dismiss()
        }

        view.btnReload.setOnClickListener {
            dialog.dismiss()
            getData()
        }

        view.tvMessageReload.text = message

        dialog.setContentView(view)
        dialog.show()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}
