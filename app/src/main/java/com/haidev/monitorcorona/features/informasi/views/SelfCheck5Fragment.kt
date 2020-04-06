package com.haidev.monitorcorona.features.informasi.views


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.haidev.monitorcorona.R
import kotlinx.android.synthetic.main.fragment_self_check5.*

class SelfCheck5Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_self_check5, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnBackSelf5.setOnClickListener {
            activity?.finish()
        }

        btnNoSelf5.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.toResultNo5, null)
        }

        btnYesSelf5.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.toResultYes5, null)
        }

    }
}
