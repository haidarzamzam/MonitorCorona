package com.haidev.monitorcorona.features.informasi.views


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.haidev.monitorcorona.R
import kotlinx.android.synthetic.main.fragment_self_check_result_no.*

class SelfCheckResultNoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_self_check_result_no, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnBackSelfResultNo.setOnClickListener {
            activity?.finish()
        }

        btnBackToHomeNo.setOnClickListener {
            activity?.finish()
        }

        btnReplayNo.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.toCheckAgainNo, null)
        }

        btnLihatPetunjuk.setOnClickListener {
            startActivity(Intent(context, KenaliActivity::class.java))
        }
    }
}
