package com.haidev.monitorcorona.features.informasi.views


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.haidev.monitorcorona.R
import kotlinx.android.synthetic.main.fragment_self_check1.*

class SelfCheck1Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_self_check1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnBackSelf1.setOnClickListener {
            activity?.finish()
        }

        btnNoSelf1.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.toSelfCheck2, null)
        }

        btnYesSelf1.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.toResultYes1, null)
        }

    }


}
