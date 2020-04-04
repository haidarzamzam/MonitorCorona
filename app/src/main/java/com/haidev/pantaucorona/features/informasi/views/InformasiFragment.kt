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
import kotlinx.android.synthetic.main.fragment_informasi.*

/**
 * A simple [Fragment] subclass.
 */
class InformasiFragment : Fragment() {

    private val RESULT_CODE = 99

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
            startActivityForResult(intent, RESULT_CODE)
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

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK) {
            Navigation.findNavController(view!!).navigate(R.id.toBantuan, null)
        }
    }

}
