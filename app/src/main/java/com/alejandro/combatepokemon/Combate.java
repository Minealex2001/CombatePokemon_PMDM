package com.alejandro.combatepokemon;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.alejandro.combatepokemon.databinding.FragmentCombateBinding;
import com.alejandro.combatepokemon.pokemon.PokemonViewModel;


public class Combate extends Fragment {
    private FragmentCombateBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentCombateBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final PokemonViewModel pokemonViewModel = new ViewModelProvider(this).get(PokemonViewModel.class);

        if (PokemonViewModel.pokemon1.getValue() != null && PokemonViewModel.pokemon2.getValue() != null){
            PokemonViewModel.pokemon1.observe(getViewLifecycleOwner(), pokemon -> {
                binding.primerPokemon.setText(pokemon.toString());
            });
            PokemonViewModel.pokemon2.observe(getViewLifecycleOwner(), pokemon -> {
                binding.segundoPokemon.setText(pokemon.toString());
            });
            binding.combatir.setOnClickListener(v -> pokemonViewModel.combatir());
            pokemonViewModel.pokemonAtaca.observe(getViewLifecycleOwner(), pokemonAtaca -> {
                if (pokemonAtaca){
                    binding.primerPokemon.setText(PokemonViewModel.pokemon1.getValue().toString());
                    binding.segundoPokemon.setText(PokemonViewModel.pokemon2.getValue().toString());
                }
            });
            pokemonViewModel.batallaTerminada.observe(getViewLifecycleOwner(), batallaTerminada -> {
                if (batallaTerminada){
                    Toast.makeText(getContext(), "Batalla terminada", Toast.LENGTH_SHORT).show();
                }
            });

        }else{
            binding.primerPokemon.setVisibility(View.GONE);
            binding.segundoPokemon.setVisibility(View.GONE);
            binding.combatir.setVisibility(View.GONE);
            Toast.makeText(getContext(), "No hay pokemons, vuelve y crealos", Toast.LENGTH_SHORT).show();
        }
    }
}