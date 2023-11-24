package com.alejandro.combatepokemon.pokemon;


import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PokemonViewModel extends ViewModel {

    MutableLiveData<String> nombrePokemon;
    MutableLiveData<Integer> vidaPokemon;
    MutableLiveData<Integer> ataquePokemon;
    MutableLiveData<Integer> defensaPokemon;
    MutableLiveData<Integer> ataqueEspecialPokemon;
    MutableLiveData<Integer> defensaEspecialPokemon;
    int vidaMaximaPokemon = 999;
    int ataquesMaximoPokemon = 999;
    int defensaMaximaPokemon = 999;
    int ataquesEspecialesMaximoPokemon = 999;
    int defensaEspecialesMaximoPokemon = 999;
    int minimoPokemon = 0;
    public PokemonViewModel() {
        nombrePokemon = new MutableLiveData<>();
        vidaPokemon = new MutableLiveData<>();
        ataquePokemon = new MutableLiveData<>();
        defensaPokemon = new MutableLiveData<>();
        ataqueEspecialPokemon = new MutableLiveData<>();
        defensaEspecialPokemon = new MutableLiveData<>();
    }

    public void setNombrePokemon(String nombrePokemon) {
        this.nombrePokemon.setValue(nombrePokemon);
    }
}
