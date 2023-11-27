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
/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Inicio} factory method to
 * create an instance of this fragment.
 */
public class Inicio extends Fragment {
    private FragmentInicioBinding binding;

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return (binding = FragmentInicioBinding.inflate(inflater, container, false)).getRoot();
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