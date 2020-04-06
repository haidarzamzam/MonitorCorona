package com.haidev.monitorcorona.features.informasi.views


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.haidev.monitorcorona.R
import kotlinx.android.synthetic.main.fragment_self_check4.*

class SelfCheck4Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_self_check4, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnBackSelf4.setOnClickListener {
            activity?.finish()
        }

        btnNoSelf4.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.toSelfCheck5, null)
        }

        btnYesSelf4.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.toResultYes4, null)
        }

    }
}
