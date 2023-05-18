/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * Clase que implementa unha personaxe da película.
 *
 * @author Miguel Bastos Gándara.
 */
public class Personaxe {

    private String tipo;
    private String nome;
    private String caracteristicas;
    private Hogwarts hogwarts;
    private Mascota mascota;
    private boolean protagonista;

    /**
     * Constructor de la clase Personaxe.
     *
     * @param tipo Tipo de personaje.
     * @param nome Nombre del personaje.
     * @param caracteristicas Características del personaje.
     * @param hogwarts Qué hace dentro de hogwarts.
     * @param mascota Mascota del personaje.
     * @param protagonista True si protagonista, false si no.
     */
    public Personaxe(String tipo, String nome, String caracteristicas, Hogwarts hogwarts, Mascota mascota, boolean protagonista) {
        this.tipo = tipo;
        this.nome = nome;
        this.caracteristicas = caracteristicas;
        this.hogwarts = hogwarts;
        this.mascota = mascota;
        this.protagonista = protagonista;
    }

    /**
     * Constructor de la clase Personaxe.
     */
    public Personaxe() {
    }

    /**
     * Devuelve el tipo de personaje.
     *
     * @return Tipo de personaje.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Cambia el tipo de personaje.
     *
     * @param tipo Tipo de personaje.
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Devuelve el nombre del personaje.
     *
     * @return Nombre del personaje.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Cambia el nombre del personaje.
     *
     * @param nome Nombre del personaje.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Devuelve las características del personaje.
     *
     * @return Características del personaje.
     */
    public String getCaracteristicas() {
        return caracteristicas;
    }

    /**
     * Cambia las características del personaje.
     *
     * @param caracteristicas Características del personaje.
     */
    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    /**
     * Devuelve qué hace dentro de hogwarts.
     *
     * @return Qué hace dentro de hogwarts.
     */
    public Hogwarts getHogwarts() {
        return hogwarts;
    }

    /**
     * Cambia qué hace dentro de hogwarts.
     *
     * @param hogwarts Qué hace dentro de hogwarts.
     */
    public void setHogwarts(Hogwarts hogwarts) {
        this.hogwarts = hogwarts;
    }

    /**
     * Devuelve la mascota del personaje.
     *
     * @return Mascota del personaje.
     */
    public Mascota getMascota() {
        return mascota;
    }

    /**
     * Camiba la mascota del personaje.
     *
     * @param mascota Mascota del personaje.
     */
    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    /**
     * Deuvel true si protagonista, false si no.
     *
     * @return True si protagonista, false si no.
     */
    public boolean isProtagonista() {
        return protagonista;
    }

    /**
     * Cambia true si protagonista, false si no.
     *
     * @param protagonista True si protagonista, false si no.
     */
    public void setProtagonista(boolean protagonista) {
        this.protagonista = protagonista;
    }

}
