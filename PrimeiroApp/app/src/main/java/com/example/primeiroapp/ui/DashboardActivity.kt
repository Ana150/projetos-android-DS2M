package com.example.primeiroapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.imc.utils.convertBase64ToBitmap
import com.example.primeiroapp.PesoActivity
import com.example.primeiroapp.R
import com.example.primeiroapp.utils.calcularIdade

class DashboardActivity : AppCompatActivity() {
    lateinit var tvNome: TextView
    lateinit var tvProfissao: TextView
    lateinit var tvImc: TextView
    lateinit var tvNcd: TextView
    lateinit var tvPeso: TextView
    lateinit var tvIdade: TextView
    lateinit var tvAltura: TextView
    lateinit var ivPerfil: ImageView
    lateinit var imgNovaPesagem: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        tvNome = findViewById(R.id.tv_dash_nome)
        tvProfissao = findViewById(R.id.tv_dash_profissao)
        tvImc = findViewById(R.id.tv_dash_imc)
        tvNcd = findViewById(R.id.tv_dash_ncd)
        tvPeso = findViewById(R.id.tv_dash_peso)
        tvIdade = findViewById(R.id.tv_dash_idade)
        tvAltura = findViewById(R.id.tv_dash_altura)
        ivPerfil = findViewById(R.id.iv_dash_foto)
        imgNovaPesagem = findViewById(R.id.pesar_agora)

        imgNovaPesagem.setOnClickListener {
            val intent = Intent(this, PesoActivity::class.java)
            startActivity(intent)
        }

        carregarDashboard()
    }

    private fun carregarDashboard() {
        val arquivo = getSharedPreferences("usuario", MODE_PRIVATE)

        tvNome.text = arquivo.getString("nome", "")
        tvProfissao.text = arquivo.getString("profissao", "")
        tvAltura.text = arquivo.getFloat("altura", 0.0f).toString()
        tvIdade.text = calcularIdade(arquivo.getString("dataNacimento", "")!!).toString()

        val bitmap = convertBase64ToBitmap(arquivo.getString("foto", "")!!)
        ivPerfil.setImageBitmap(bitmap)
    }
}