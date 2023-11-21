package com.alejandro.combatepokemon.pokemon1;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.alejandro.combatepokemon.R;

public class pokemon1View extends Fragment {
    private EditText vidaPokemon;
    private EditText ataquePokemon;
    private EditText defensaPokemon;
    private EditText ataqueEspecialPokemon;
    private EditText defensaEspecialPokemon;
    private Button next;
    private Pokemon1ViewModel pokemon1ViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        configView();
    }

    private void configView() {
        vidaPokemon = findViewById(R.id.vidaPokemonInput);
        ataquePokemon = findViewById(R.id.ataquePokemonInput);
        defensaPokemon = findViewById(R.id.defensaPokemonInput);
        ataqueEspecialPokemon = findViewById(R.id.ataqueEspecialPokemonInput);
        defensaEspecialPokemon = findViewById(R.id.defensaEspecialPokemonInput);
        next = findViewById(R.id.buttonNext);
    }
}
