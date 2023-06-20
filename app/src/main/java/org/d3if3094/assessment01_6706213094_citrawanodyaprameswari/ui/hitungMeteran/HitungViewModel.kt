package org.d3if3094.assessment01_6706213094_citrawanodyaprameswari.ui.hitungMeteran

import android.text.TextUtils
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.d3if3094.assessment01_6706213094_citrawanodyaprameswari.R
import org.d3if3094.assessment01_6706213094_citrawanodyaprameswari.model.HasilTarif
import org.d3if3094.assessment01_6706213094_citrawanodyaprameswari.model.KategoriMeteran

class HitungViewModel  : ViewModel() {
    private val hasilHitung = MutableLiveData?<Hasil?>()

    fun hitung(tarif: Float, R1: )

    fun hitung()
        private fun getKategori(tarif: Float, R1: Boolean, R2: Boolean): KategoriMeteran {
        val kategori = if (R1) {
            when {
                tarif < 50000 -> KategoriMeteran.IRIT
                tarif >= 100000 -> KategoriMeteran.NORMAL
                else -> KategoriMeteran.BOROS
            }
        } else if (R2) {
            when {
                tarif < 70000 -> KategoriMeteran.IRIT
                tarif >= 150000 -> KategoriMeteran.NORMAL
                else -> KategoriMeteran.BOROS
            }
        } else {
            when {
                tarif < 100000 -> KategoriMeteran.IRIT
                tarif >= 170000 -> KategoriMeteran.NORMAL
                else -> KategoriMeteran.BOROS
            }
        }
        return kategori
    }

    fun getHasilTarif(): ListData<HasilTarif> {


        fun scheduleUpdater(app: Application) {
            val request = OneTimeWorkRequestBuilder<UpdateWorker>()
                .setInitialDelay(1, TimeUnit.MINUTES)
                .build()
            WorkManager.getInstance(app).enqueueUniqueWork(
                UpdateWorker.WORK_NAME,
                ExistingWorkPolicy.REPLACE,
                request
            )
        }

    }

}