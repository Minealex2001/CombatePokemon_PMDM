package com.alejandro.combatepokemon.pokemon;

public class PokemonModel {
    interface Callback {
        void cuandoElPokemonEstaCreado(Pokemon pokemon);
        void cuandoHayErrorEnElNombre(String error);
        void cuandoHayErrorEnLaVida(int hpMinima, int hpMaxima);
        void cuandoHayErrorEnElAtaque(int ataqueMinimo, int ataqueMaximo);
        void cuandoHayErrorEnLaDefensa(int defensaMinima, int defensaMaxima);
        void cuandoHayErrorEnElAtaqueEspecial(int ataqueEspecialMinimo, int ataqueEspecialMaximo);
        void cuandoHayErrorEnLaDefensaEspecial(int defensaEspecialMinima, int defensaEspecialMaximo);
        void cuandoEmpiezaCrearPokemon();
        void cuandoTerminaCrearPokemon();
    }


    public void agregarPokemon(Pokemon pokemon, Callback callback){

        callback.cuandoEmpiezaCrearPokemon();

        int hpMinima = 1;
        int ataqueMinimo = 1;
        int defensaMinima = 1;
        int ataqueEspecialMinimo = 1;
        int defensaEspecialMinima = 1;

        int hpMaxima = 999;
        int ataqueMaximo = 999;
        int defensaMaxima = 999;
        int ataqueEspecialMaximo = 999;
        int defensaEspecialMaximo = 999;

        boolean error = false;

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Validaciones
        if(!pokemon.getNombre().matches("[a-zA-Z0-9]*")){
            callback.cuandoHayErrorEnElNombre("El nombre solo puede contener letras y numeros.");
            error = true;
        }else if (pokemon.getNombre().equals("")){
            callback.cuandoHayErrorEnElNombre("El nombre no puede estar vacio.");
            error = true;
        }

        if (pokemon.getHp() < hpMinima || pokemon.getHp() > hpMaxima){
            callback.cuandoHayErrorEnLaVida(hpMinima, hpMaxima);
            error = true;
        }
        if (pokemon.getAtaque() < ataqueMinimo || pokemon.getAtaque() > ataqueMaximo){
            callback.cuandoHayErrorEnElAtaque(ataqueMinimo, ataqueMaximo);
            error = true;
        }
        if (pokemon.getDefensa() < defensaMinima || pokemon.getDefensa() > defensaMaxima){
            callback.cuandoHayErrorEnLaDefensa(defensaMinima, defensaMaxima);
            error = true;
        }
        if (pokemon.getAtaqueEspecial() < ataqueEspecialMinimo || pokemon.getAtaqueEspecial() > ataqueEspecialMaximo){
            callback.cuandoHayErrorEnElAtaqueEspecial(ataqueEspecialMinimo, ataqueEspecialMaximo);
            error = true;
        }
        if (pokemon.getDefensaEspecial() < defensaEspecialMinima || pokemon.getDefensaEspecial() > defensaEspecialMaximo){
            callback.cuandoHayErrorEnLaDefensaEspecial(defensaEspecialMinima, defensaEspecialMaximo);
            error = true;
        }

        if (!error){
            callback.cuandoElPokemonEstaCreado(pokemon);
        }

        callback.cuandoTerminaCrearPokemon();
    }

    public Pokemon combatir (Pokemon pokemonAtaque, Pokemon pokemonDefensa){

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int probabilidadAtaqueEspecial = (int) (Math.random() * 10 + 1);
        int vidaDespuesAtaque = pokemonDefensa.getHp();

        if (probabilidadAtaqueEspecial <= 3) {
            if (pokemonAtaque.getAtaqueEspecial() > pokemonDefensa.getDefensaEspecial()){
                vidaDespuesAtaque = pokemonDefensa.getHp() - (pokemonAtaque.getAtaqueEspecial() - pokemonDefensa.getDefensaEspecial());
            }
        }else{
            if (pokemonAtaque.getAtaque() > pokemonDefensa.getDefensa()){
                vidaDespuesAtaque = pokemonDefensa.getHp() - (pokemonAtaque.getAtaque() - pokemonDefensa.getDefensa());
            }
        }

        if (vidaDespuesAtaque < 0){
            vidaDespuesAtaque = 0;
        }

        return new Pokemon(pokemonDefensa.getNombre(), vidaDespuesAtaque, pokemonDefensa.getAtaque(), pokemonDefensa.getDefensa(), pokemonDefensa.getAtaqueEspecial(), pokemonDefensa.getDefensaEspecial());
    }
}
