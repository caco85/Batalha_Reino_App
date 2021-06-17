package com.example.batalha_reino_app.ui.battle

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.batalha_reino_app.R
import com.example.batalha_reino_app.databinding.BattleFragmentBinding


class BattleFragment : Fragment() {
    companion object {
        fun newInstance() = BattleFragment()
    }
    private lateinit var viewModel: BattleViewModel
    private var _binding: BattleFragmentBinding? = null
    private val binding get() = _binding!!
    private var diceRaf = 0
    private var diceRafTwo = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        binding.btnJogar.setOnClickListener { diceRoll();diceRoll2();fight() }

        diceRoll()
        diceRoll2()
        fight()
        return inflater.inflate(R.layout.battle_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(BattleViewModel::class.java)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    private fun diceRoll() {
        val dice = Dice(6)
        val valueRaffled = dice.play()
        val imageViewDice: ImageView = binding.imgVPlayOne

        val imgDice = when (valueRaffled) {
            1 -> R.drawable.dice_6
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceRaf = valueRaffled
        imageViewDice.setImageResource(imgDice)
    }
    private fun diceRoll2() {
        val dice = Dice(6)
        val valueRaffled = dice.play()
        val imageViewDice: ImageView = binding.imgVDicePlayTwo
        val imgDice = when (valueRaffled) {
            1 -> R.drawable.dice_6
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceRafTwo = valueRaffled
        imageViewDice.setImageResource(imgDice)
    }

    private fun fight(){
        var wizHp  = 15
        var warHp  = 20

        if (diceRaf > diceRafTwo){
            wizHp =- 6
            val textView: TextView = binding.txtVPainel
            viewModel.warriorLostHp.observe(viewLifecycleOwner, Observer {
                textView.text = it
            })
        }else if (diceRafTwo > diceRaf){
            warHp =-6
            val textView: TextView = binding.txtVPainel
            viewModel.wizardLostHp.observe(viewLifecycleOwner, Observer {
                textView.text = it
            })
        }else{
            val textView: TextView = binding.txtVPainel
            viewModel.draw.observe(viewLifecycleOwner, Observer {
                textView.text = it
            })
        }

        if( wizHp <= 0){
            val textView: TextView = binding.txtVPainel
            viewModel.winWar.observe(viewLifecycleOwner, Observer {
                textView.text = it
            })

        }else if ( warHp <= 0){
            val textView: TextView = binding.txtVPainel
            viewModel.winWiz.observe(viewLifecycleOwner, Observer {
                textView.text = it
            })

        }
        //aqui queria atualizar , porem não conseguir achar a função certa de conversão
//        binding.txtVHpOne = wizHp
    }
    private fun restart(){
        val textView: TextView = binding.txtVPainel
        viewModel.restart.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
    }
}

class Dice (val sides: Int) {
    fun play(): Int {
        return (1..sides).random()
    }
}

