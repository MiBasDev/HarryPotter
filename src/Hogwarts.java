/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * Clase que implementa os datos dunha personaxe en Hogwarts.
 *
 * @author Miguel Bastos Gándara.
 */
public class Hogwarts {

    private String casa;
    private String posto;
    private String codigo;
    private String quidditch;
    private int curso;

    /**
     * Constructor de la clase Hogwarts.
     *
     * @param casa Casa de hogwarts.
     * @param posto Puesto en el colegio.
     * @param cogido Código personal en el colegio.
     * @param quidditch Puesto en el equipo de quidditch.
     * @param curso Curso escolar en el que estudia.
     */
    public Hogwarts(String casa, String posto, String cogido, String quidditch, int curso) {
        this.casa = casa;
        this.posto = posto;
        this.codigo = cogido;
        this.quidditch = quidditch;
        this.curso = curso;
    }

    /**
     * Constructor de la clase Hogwarts.
     */
    public Hogwarts() {
    }

    /**
     * Devuelve la casa de hogwarts.
     *
     * @return Casa de hogwarts.
     */
    public String getCasa() {
        return casa;
    }

    /**
     * Cambia la casa de hogwarts.
     *
     * @param casa Casa de hogwarts.
     */
    public void setCasa(String casa) {
        this.casa = casa;
    }

    /**
     * Devuelve el puesto en el colegio.
     *
     * @return Puesto en el colegio.
     */
    public String getPosto() {
        return posto;
    }

    /**
     * Cambia el puesto en el colegio.
     *
     * @param posto Puesto en el colegio.
     */
    public void setPosto(String posto) {
        this.posto = posto;
    }

    /**
     * Devuelve el código personal en el colegio.
     *
     * @return Código personal en el colegio.
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Cambia el código personal en el colegio.
     *
     * @param codigo Código personal en el colegio.
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * Devuelve el puesto en el equipo de quidditch.
     *
     * @return Puesto en el equipo de quidditch.
     */
    public String getQuidditch() {
        return quidditch;
    }

    /**
     * Cambia el puesto en el equipo de quidditch.
     *
     * @param quidditch Puesto en el equipo de quidditch.
     */
    public void setQuidditch(String quidditch) {
        this.quidditch = quidditch;
    }

    /**
     * Devuelve el curso escolar en el que estudia.
     *
     * @return Curso escolar en el que estudia.
     */
    public int getCurso() {
        return curso;
    }

    /**
     * Cambia el curso escolar en el que estudia.
     *
     * @param curso Curso escolar en el que estudia.
     */
    public void setCurso(int curso) {
        this.curso = curso;
    }

}
