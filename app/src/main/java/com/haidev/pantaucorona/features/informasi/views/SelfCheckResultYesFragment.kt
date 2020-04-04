package com.haidev.pantaucorona.features.informasi.views


import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.haidev.pantaucorona.R
import kotlinx.android.synthetic.main.fragment_self_check_result_yes.*

class SelfCheckResultYesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_self_check_result_yes, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnBackSelfResultYes.setOnClickListener {
            activity?.finish()
        }

        btnBackToHomeYes.setOnClickListener {
            activity?.finish()
        }

        btnReplayYes.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.toCheckAgainYes, null)
        }

        btnIsolasi.setOnClickListener {
            startActivity(Intent(context, IsolasiActivity::class.java))
        }


        btnCallNumber.setOnClickListener {
            val returnIntent = Intent()
            returnIntent.putExtra("result", "Hey, I received your intent!")
            activity?.setResult(Activity.RESULT_OK, returnIntent)
            activity?.finish()
        }
    }
}
