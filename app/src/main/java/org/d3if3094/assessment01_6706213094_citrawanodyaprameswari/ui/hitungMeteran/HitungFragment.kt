package org.d3if3094.assessment01_6706213094_citrawanodyaprameswari.ui.hitungMeteran

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import org.d3if3094.assessment01_6706213094_citrawanodyaprameswari.databinding.ActivityMainBinding
import org.d3if3094.assessment01_6706213094_citrawanodyaprameswari.databinding.FragmentHitungBinding
import org.d3if3094.assessment01_6706213094_citrawanodyaprameswari.model.HasilTarif


class HitungFragment : Fragment() {
    private lateinit var binding: FragmentHitungBinding
    private val viewModel: HitungViewModel by lazy {
        ViewModelProvider(requireActivity())[HitungViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHitungBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.button.setOnClickListener { HasilTarif() }
        viewModel.getHasilTarif().observe(requireActivity(), { showResult(it)
    }
}