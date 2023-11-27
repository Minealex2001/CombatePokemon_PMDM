package com.alejandro.combatepokemon;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alejandro.combatepokemon.databinding.FragmentInicioBinding;
import com.alejandro.combatepokemon.pokemon.PokemonViewModel;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Inicio extends Fragment {

    private FragmentInicioBinding binding;

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_inicio, container, false);
    }

    @Override
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        NavController navHostFragment = NavHostFragment.findNavController(this);

        final PokemonViewModel pokemonViewModel = new ViewModelProvider(this).get(PokemonViewModel.class);

        binding.agregarPokemon.setOnClickListener(view12 -> navHostFragment.navigate(R.id.agregarPokemon));

        binding.comenzarCombate.setOnClickListener(view1 -> navHostFragment.navigate(R.id.comenzarCombate));
    }
}