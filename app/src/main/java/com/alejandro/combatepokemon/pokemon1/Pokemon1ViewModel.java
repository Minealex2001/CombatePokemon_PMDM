package com.alejandro.combatepokemon.pokemon1;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

public class Pokemon1ViewModel extends AndroidViewModel {

    MutableLiveData<String> nombrePokemon = new MutableLiveData<>();
    MutableLiveData<Integer> vidaPokemon = new MutableLiveData<>();
    MutableLiveData<Integer> AtaquePokemon = new MutableLiveData<>();
    MutableLiveData<Integer> DefensaPokemon = new MutableLiveData<>();
    MutableLiveData<Integer> AtaqueEspecialPokemon = new MutableLiveData<>();
    MutableLiveData<Integer> DefensaEspecialPokemon = new MutableLiveData<>();
    int vidaMaximaPokemon = 999;
    int ataquesMaximoPokemon = 999;
    int defensaMaximaPokemon = 999;
    int ataquesEspecialesMaximoPokemon = 999;
    int defensaEspecialesMaximoPokemon = 999;
    int minimoPokemon = 0;
    public Pokemon1ViewModel(@NonNull Application application) {
        super(application);
    }
}
