package com.example.batalha_reino_app.ui.battle

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BattleViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "O mago perde -6 de hp."

    }
    val wizardLostHp : LiveData<String> = _text


    private val _text2 = MutableLiveData<String>().apply {
        value = "O guerreiro perde -6 de hp."
    }
    val warriorLostHp: LiveData<String> = _text2


    private val _text3 = MutableLiveData<String>().apply {
        value = "Essa rodada houve um empate."
    }
    val draw: LiveData<String> = _text3

    private val _text4 = MutableLiveData<String>().apply {
        value = "O mago venceu!."
    }
    val winWiz: LiveData<String> = _text4

    private val _text5 = MutableLiveData<String>().apply {
        value = "O Guerreiro venceu!."
    }
    val winWar: LiveData<String> = _text5

    private val _text6 = MutableLiveData<String>().apply {
        value = "Partida reiniciar!."
    }
    val restart: LiveData<String> = _text6
}