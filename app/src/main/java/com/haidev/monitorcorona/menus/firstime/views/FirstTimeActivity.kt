package com.haidev.monitorcorona.menus.firstime.views

import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.haidev.monitorcorona.R
import com.haidev.monitorcorona.main.views.MainActivity
import com.haidev.monitorcorona.preferences.AppModel
import com.haidev.monitorcorona.preferences.AppPreference
import kotlinx.android.synthetic.main.activity_first_time.*
import kotlinx.android.synthetic.main.bottomsheet_provinsi.view.*

class FirstTimeActivity : AppCompatActivity() {

    private lateinit var mAppPreference: AppPreference
    private lateinit var appModel: AppModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_first_time)

        mAppPreference = AppPreference(this)
        appModel = mAppPreference.getPref()

        btnPilihLokasi.setOnClickListener {
            val view = layoutInflater.inflate(R.layout.bottomsheet_provinsi, null)
            val dialog = BottomSheetDialog(this, R.style.BaseBottomSheetDialog)
            view.close.setOnClickListener {
                dialog.dismiss()
            }

            val data =
                arrayOf(
                    "Maluku Utara",
                    "Maluku",
                    "Sulawesi Barat",
                    "Kepulauan Bangka Belitung",
                    "Papua Barat",
                    "Sulawesi Utara",
                    "Kalimantan Utara",
                    "Nusa Tenggara Barat",
                    "Sumatera Selatan",
                    "Jambi",
                    "Sulawesi Tenggara",
                    "Sulawesi Tengah",
                    "Riau",
                    "Kalimantan Selatan",
                    "Aceh",
                    "Kepulauan Riau",
                    "Kalimantan Tengah",
                    "Lampung",
                    "Sumatera Barat",
                    "Papua",
                    "Kalimantan Barat",
                    "Sumatera Utara",
                    "Kalimantan Timur",
                    "Daerah Istimewa Yogyakarta",
                    "Bali",
                    "Sulawesi Selatan",
                    "Jawa Tengah",
                    "Jawa Timur",
                    "Banten",
                    "Jawa Barat",
                    "DKI Jakarta"
                )
            view.numberPicker.minValue = 1
            view.numberPicker.maxValue = data.size
            view.numberPicker.displayedValues = data
            view.numberPicker.value = data.size

            view.btnTerapkan.setOnClickListener {
                finish()

                appModel.location = data[view.numberPicker.value - 1].toString()
                mAppPreference.setPref(appModel)

                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                dialog.dismiss()
            }
            dialog.setContentView(view)
            dialog.show()
        }

        btnLewatiLokasi.setOnClickListener {
            finish()
            appModel.location = "DKI Jakarta"
            mAppPreference.setPref(appModel)
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}