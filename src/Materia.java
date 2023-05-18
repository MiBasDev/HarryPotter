
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 * Clase que implementa unha materia que se imparte en Hogwarts.
 *
 * @author Miguel Bastos Gándara.
 */
public class Materia {

    private String codigo;
    private String nome;
    private int curso;
    private Personaxe docente;
    private ArrayList<Personaxe> alumnos;

    /**
     * Constructor de la clase Materia.
     *
     * @param codigo Código de la materia.
     * @param nome Nombre de la materia.
     * @param curso Curso en el que se imparte la materia.
     * @param docente Profesor que imparte la materia.
     * @param alumnos Alumnos matriculados en la materia.
     */
    public Materia(String codigo, String nome, int curso, Personaxe docente, ArrayList<Personaxe> alumnos) {
        this.codigo = codigo;
        this.nome = nome;
        this.curso = curso;
        this.docente = docente;
        this.alumnos = alumnos;
    }

    /**
     * Constructor de la clase Materia.
     */
    public Materia() {
        alumnos = new ArrayList<>();
    }

    /**
     * Devuelve el código de la materia.
     *
     * @return Código de la materia.
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Cambia el código de la materia.
     *
     * @param codigo Código de la materia.
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * Devuelve el nombre de la materia.
     *
     * @return Nombre de la materia.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Cambia el nombre de la materia.
     *
     * @param nome Nombre de la materia.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Devuelve el curso en el que se imparte la materia.
     *
     * @return Curso en el que se imparte la materia.
     */
    public int getCurso() {
        return curso;
    }

    /**
     * Camiba el curso en el que se imparte la materia.
     *
     * @param curso Curso en el que se imparte la materia.
     */
    public void setCurso(int curso) {
        this.curso = curso;
    }

    /**
     * Devuelve el profesor que imparte la materia.
     *
     * @return Profesor que imparte la materia.
     */
    public Personaxe getDocente() {
        return docente;
    }

    /**
     * Cambia el profesor que imparte la materia.
     *
     * @param docente Profesor que imparte la materia.
     */
    public void setDocente(Personaxe docente) {
        this.docente = docente;
    }

    /**
     * Devuelve los alumnos matriculados en la materia.
     *
     * @return Alumnos matriculados en la materia.
     */
    public ArrayList<Personaxe> getAlumnos() {
        return alumnos;
    }

    /**
     * Cambia los alumnos matriculados en la materia.
     *
     * @param alumnos Alumnos matriculados en la materia.
     */
    public void setAlumnos(ArrayList<Personaxe> alumnos) {
        this.alumnos = alumnos;
    }

}
