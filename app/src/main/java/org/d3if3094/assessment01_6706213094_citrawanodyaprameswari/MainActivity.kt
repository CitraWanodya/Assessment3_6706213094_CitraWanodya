package org.d3if3094.assessment01_6706213094_citrawanodyaprameswari

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Toast
import org.d3if3094.assessment01_6706213094_citrawanodyaprameswari.databinding.ActivityMainBinding

abstract class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnHitung.setOnClickListener {
            hitunganTarif()
        }
    }
    private fun hitunganTarif() {
        Log.d("MainActivity", "Tombol diklik!")
        val nama = binding.edNapel.toString()
        if (TextUtils.isEmpty(nama)) {
            Toast.makeText(this, R.string.nama_invalid, Toast.LENGTH_LONG).show()
            return
        }
        val edBulanlalu
        val edBulanini
        val getPembayaran
        val pemakaian = edBulanlalu - edBulanini
        val pembayaran = getPembayaran(tipe)
        binding.pemakaianTextView.text = "Pemakaian: {pemakaian}"
        binding.pembayaranTextView.text = "Pembayaran: {pembayaran}"

        private fun getPembayaran(pemakaian)
        val tipe = binding.edTipe.toString()
            Toast.makeText(this, "Tipe tidak boleh kosong.", Toast.LENGTH_LONG).show()
        if(tipe.equals("R1")){
            val tarif = 300
            val beban = 20000
        }else if(tipe.equals("R2")){
            val tarif = 450
            val beban = 25000
        }else if(tipe.equals("R3")){
            val tarif = 600
            val beban = 30000
        }
    }

}