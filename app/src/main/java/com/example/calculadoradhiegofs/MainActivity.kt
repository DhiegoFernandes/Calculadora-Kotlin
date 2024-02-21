package com.example.calculadoradhiegofs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.calculadoradhiegofs.databinding.ActivityMainBinding
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

            binding.radioGroup.setOnCheckedChangeListener { _, checkedId ->

                binding.btnCalcular.setOnClickListener{
                    val n1 = binding.editTxt1.text.toString().toDouble()//pega numero 1
                    val n2 = binding.editTxt2.text.toString().toDouble()

                when (checkedId){
                    binding.rdbSoma.id ->{
                        soma(n1, n2)
                    }
                    binding.rdbDivisao.id ->{
                        divisao(n1, n2)
                    }
                    binding.rdbMultiplicacao.id ->{
                        multiplicacao(n1, n2)
                    }
                    binding.rdbSubtracao.id ->{
                        subtracao(n1, n2)
                    }
                }
            }
        }

    }

    private fun soma(n1 :Double, n2: Double){
        var resultado = n1 + n2
        binding.txtResultado.text = resultado.toString()
    }

    private fun divisao(n1 :Double, n2: Double){
        if (n2 == 0.0){ //0.0 não pode, porém 0.1 pode
            Toast.makeText(this, "Não pode dividir por 0!", Toast.LENGTH_LONG).show()
        } else{
            var resultado = n1 / n2
            binding.txtResultado.text = resultado.toString()
        }

    }

    private fun multiplicacao(n1: Double, n2: Double){
        var resultado = n1 * n2
        binding.txtResultado.text = resultado.toString()
    }

    private fun subtracao(n1: Double, n2: Double){
        var resultado = n1 - n2
        binding.txtResultado.text = resultado.toString()
    }

}