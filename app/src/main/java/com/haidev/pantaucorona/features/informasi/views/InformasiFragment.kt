package com.haidev.pantaucorona.features.informasi.views


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.haidev.pantaucorona.R
import kotlinx.android.synthetic.main.fragment_informasi.*

/**
 * A simple [Fragment] subclass.
 */
class InformasiFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_informasi, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnSelf.setOnClickListener {
            val intent = Intent(context, SelfCheckupActivity::class.java)
            startActivity(intent)
        }

        btnPengobatan.setOnClickListener {
            val intent = Intent(context, IsolasiActivity::class.java)
            startActivity(intent)
        }

        btnKenali.setOnClickListener {
            val intent = Intent(context, KenaliActivity::class.java)
            startActivity(intent)
        }
    }


}
