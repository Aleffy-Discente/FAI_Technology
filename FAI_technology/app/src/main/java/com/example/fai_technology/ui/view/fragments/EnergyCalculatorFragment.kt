package com.example.fai_technology.ui.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fai_technology.databinding.FragmentEnergyCalculatorBinding

class EnergyCalculatorFragment : Fragment() {

    private lateinit var binding: FragmentEnergyCalculatorBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentEnergyCalculatorBinding.inflate(inflater, container, false)

        binding.btnCalcular.setOnClickListener {
            val potencia = binding.etPotencia.text.toString().toDoubleOrNull() ?: 0.0
            val horasDia = binding.etHorasDia.text.toString().toDoubleOrNull() ?: 0.0
            val diasMes = binding.etDiasMes.text.toString().toDoubleOrNull() ?: 0.0
            val tarifa = binding.etTarifa.text.toString().toDoubleOrNull() ?: 0.0

            val consumoKwh = (potencia * horasDia * diasMes) / 1000
            val custo = consumoKwh * tarifa

            binding.tvResultado.text = String.format("Custo mensal: R$ %.2f", custo)
        }

        return binding.root
    }
}
