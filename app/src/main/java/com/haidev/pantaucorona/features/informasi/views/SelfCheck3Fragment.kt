package com.haidev.pantaucorona.features.informasi.views


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.haidev.pantaucorona.R
import kotlinx.android.synthetic.main.fragment_self_check3.*

class SelfCheck3Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_self_check3, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnBackSelf3.setOnClickListener {
            activity?.finish()
        }

        btnNoSelf3.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.toSelfCheck4, null)
        }

        btnYesSelf3.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.toResultYes3, null)
        }

    }
}
