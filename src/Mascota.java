/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * CLase que implementa os datos dunha personaxe en Hogwarts.
 *
 * @author Miguel Bastos Gándara.
 */
public class Mascota {

    private String animal;
    private String nome;
    private int idade;

    /**
     * Constructor de la clase mascota.
     *
     * @param animal Tipo de animal.
     * @param nome Nombre de la mascota.
     * @param idade Edad de la mascota.
     */
    public Mascota(String animal, String nome, int idade) {
        this.animal = animal;
        this.nome = nome;
        this.idade = idade;
    }

    /**
     * Constructor de la clase mascota.
     */
    public Mascota() {

    }

    /**
     * Devuelve el tipo de animal.
     *
     * @return Tipo de animal.
     */
    public String getAnimal() {
        return animal;
    }

    /**
     * Cambia el tipo de animal.
     *
     * @param animal Tipo de animal.
     */
    public void setAnimal(String animal) {
        this.animal = animal;
    }

    /**
     * Devuelve el nombre de la mascota.
     *
     * @return Nombre de la mascota.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Cambia el nombre de la mascota.
     *
     * @param nome Nombre de la mascota.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Devuelve la edad de la mascota.
     *
     * @return Edad de la mascota.
     */
    public int getIdade() {
        return idade;
    }

    /**
     * Cambia la edad de la mascota.
     *
     * @param idade Edad de la mascota.
     */
    public void setIdade(int idade) {
        this.idade = idade;
    }

}
