package com.alejandro.combatepokemon;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.alejandro.combatepokemon.databinding.FragmentAgregarPokemonBinding;
import com.alejandro.combatepokemon.pokemon.Pokemon;
import com.alejandro.combatepokemon.pokemon.PokemonViewModel;


public class AgregarPokemon extends Fragment {

    private FragmentAgregarPokemonBinding binding;
    private Pokemon pokemon;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_agregar_pokemon, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        NavController navController = NavHostFragment.findNavController(this);

        final PokemonViewModel pokemonViewModel = new ViewModelProvider(this).get(PokemonViewModel.class);

        binding.buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean error = false;

                if (binding.nombreInput.getText().toString().isEmpty()) {
                    binding.nombreInput.setError("El nombre es requerido");
                    error = true;
                }
                try {
                    Integer.parseInt(binding.vidaInput.getText().toString());
                } catch (NumberFormatException e) {
                    binding.vidaInput.setError("La vida debe ser un número");
                    error = true;
                }
                try{
                    Integer.parseInt(binding.ataqueInput.getText().toString());
                }catch (Exception e){
                    error = true;
                    binding.ataqueInput.setError("El ataque debe ser un numero");
                }
                try {
                    Integer.parseInt(binding.defensaInput.getText().toString());
                }catch (Exception e){
                    error = true;
                    binding.defensaInput.setError("La defensa debe ser un numero");
                }
                try{
                    Integer.parseInt(binding.ataqueEInput.getText().toString());
                }catch (Exception e){
                    error = true;
                    binding.ataqueEInput.setError("El ataque especial debe ser un numero");
                }
                try {
                    Integer.parseInt(binding.defensaEInput.getText().toString());
                }catch (Exception e){
                    error = true;
                    binding.defensaEInput.setError("La defensa especial debe ser un numero");
                }

                if (!error) {
                    pokemon = new Pokemon(
                            binding.nombreInput.getText().toString(),
                            Integer.parseInt(binding.vidaInput.getText().toString()),
                            Integer.parseInt(binding.ataqueInput.getText().toString()),
                            Integer.parseInt(binding.defensaInput.getText().toString()),
                            Integer.parseInt(binding.ataqueInput.getText().toString()),
                            Integer.parseInt(binding.defensaEInput.getText().toString())
                    );
                }

                pokemonViewModel.errorNombre.observe(getViewLifecycleOwner(), s -> {
                    if (s != null) {
                        binding.nombreInput.setError(s);
                    } else {
                        binding.nombreInput.setError(null);
                    }
                });

                pokemonViewModel.errorVida.observe(getViewLifecycleOwner(), integer -> {
                    if(integer != null){
                        binding.vidaInput.setError("La vida debe estar entre 0 y 999");
                    }else{
                        binding.vidaInput.setError(null);
                    }
                });

                pokemonViewModel.errorAtaque.observe(getViewLifecycleOwner(), integer -> {
                    if(integer != null){
                        binding.ataqueInput.setError("El ataque debe estar entre 0 y 999");
                    }else{
                        binding.ataqueInput.setError(null);
                    }
                });

                pokemonViewModel.errorDefensa.observe(getViewLifecycleOwner(), integer -> {
                    if(integer != null){
                        binding.defensaInput.setError("La defensa debe estar entre 0 y 999");
                    }else{
                        binding.defensaInput.setError(null);
                    }
                });

                pokemonViewModel.errorAtaqueEspecial.observe(getViewLifecycleOwner(), integer -> {
                    if(integer != null){
                        binding.ataqueEInput.setError("El ataque especial debe estar entre 0 y 999");
                    }else{
                        binding.ataqueEInput.setError(null);
                    }
                });

                pokemonViewModel.errorDefensaEspecial.observe(getViewLifecycleOwner(), integer -> {
                    if(integer != null){
                        binding.defensaEInput.setError("La defensa especial debe estar entre 0 y 999");
                    }else{
                        binding.defensaEInput.setError(null);
                    }
                });

                PokemonViewModel.pokemon1.observe(getViewLifecycleOwner(), pokemon -> Toast.makeText(getContext(), "Pokemon 1 creado", Toast.LENGTH_SHORT).show());

                PokemonViewModel.pokemon2.observe(getViewLifecycleOwner(), pokemon -> Toast.makeText(getContext(), "Pokemon 2 creado", Toast.LENGTH_SHORT).show());

            }

            public void limpiarParametros(){
                binding.nombreInput.setText("");
                binding.vidaInput.setText("");
                binding.ataqueInput.setText("");
                binding.defensaInput.setText("");
                binding.ataqueEInput.setText("");
                binding.defensaEInput.setText("");
            }
        });
    }
}