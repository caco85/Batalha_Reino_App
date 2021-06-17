package com.example.batalha_reino_app.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "Este é o mago, vindo do reino de fogo usa sua magia firebolt para tira dano " +
                "do alvo, e tem a magia escudo arcano para sua melhor defesa"

    }
    val txtcharsInfoRight : LiveData<String> = _text


    private val _text2 = MutableLiveData<String>().apply {
        value = "Este é o Guerreiro, vindo do reino de gelo usa sua espada com golpes ferozes " +
                "capaz de quebra a armadura do alvo."
    }
    val txtcharsInfoLeft: LiveData<String> = _text2
}