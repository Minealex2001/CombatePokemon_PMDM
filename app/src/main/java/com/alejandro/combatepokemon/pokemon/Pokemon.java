package com.alejandro.combatepokemon.pokemon;

public class Pokemon {
    String nombrePokemon;
    int vidaPokemon;
    int AtaquePokemon;
    int DefensaPokemon;
    int AtaqueEspecialPokemon;
    int DefensaEspecialPokemon;

    public Pokemon(String nombrePokemon, int vidaPokemon, int ataquePokemon, int defensaPokemon, int ataqueEspecialPokemon, int defensaEspecialPokemon) {
        this.nombrePokemon = nombrePokemon;
        this.vidaPokemon = vidaPokemon;
        AtaquePokemon = ataquePokemon;
        DefensaPokemon = defensaPokemon;
        AtaqueEspecialPokemon = ataqueEspecialPokemon;
        DefensaEspecialPokemon = defensaEspecialPokemon;
    }

    public int quitarVida(int danoEnemigo){
        int danoReal = danoEnemigo - DefensaPokemon;
        if(danoReal < 0){
            danoReal = 0;
        }
        int vidaRestante = vidaPokemon - danoReal;
        if(vidaRestante < 0){
            vidaRestante = 0;
        }
        return vidaRestante;
    }

    public int quitarVidaEspecial(int danoEnemigo){
        int danoReal = danoEnemigo - DefensaEspecialPokemon;
        if(danoReal < 0){
            danoReal = 0;
        }
        int vidaRestante = vidaPokemon - danoReal;
        if(vidaRestante < 0){
            vidaRestante = 0;
        }
        return vidaRestante;
    }

    public int probabilidadDeAtaqueEspecial(){
        int probabilidad = (int) (Math.random() * 100);
        return probabilidad;
    }

}
