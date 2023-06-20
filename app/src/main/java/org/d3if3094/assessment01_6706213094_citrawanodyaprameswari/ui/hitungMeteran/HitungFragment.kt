package org.d3if3094.assessment01_6706213094_citrawanodyaprameswari.ui.hitungMeteran

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import org.d3if3094.assessment01_6706213094_citrawanodyaprameswari.MainActivity
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
        binding.btnHitung.setOnClickListener { HasilTarif() }
        viewModel.getHasilTarif().observe(requireActivity(), { showResult(it)
        viewModel.scheduleUpdater(requireActivity().application)
        }
    }
    viewModel.scheduleUpdater(requireActivity().application)

    private fun updateProgress(status: ApiStatus){
        when(status){
            ApiStatus.LOADING -> {
                binding.progressBar.visibility = View.VISIBLE
            }
            ApiStatus.SUCCESS -> {
                binding.progressBar.visibility = View.GONE

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                    requestNotificationPermission()
                }
            }
            ApiStatus.FAILED -> {
                binding.progressBar.visibility = View.GONE
                binding.networkError.visibility = View.VISIBLE
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    private fun requestNotificationPermission(){
        if(ActivityCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.POST_NOTIFICATIONS
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                ActivityCompat.requestPermissions(
                    requireActivity(),
                    arrayOf(Manifest.permission.POST_NOTIFICATIONS),
                    MainActivity.PERMISSION_REQUEST_CODE
                )
            }
        }
    }
}