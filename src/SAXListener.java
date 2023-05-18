
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 * Clase que implementa un oínte SAX para procesar o documento XML de Harry
 * Potter.
 *
 * @author Miguel Bastos Gándara.
 */
public class SAXListener extends DefaultHandler {

    private ArrayList<Materia> materias;
    private ArrayList<Personaxe> personaxes;

    private Personaxe currentPerson;
    private Materia currentMateria;
    private String personOrAnimal;
    private String currentTag;

    /**
     * Constructor de la clase SAXListener.
     */
    public SAXListener() {
        this.materias = new ArrayList<>();
        this.personaxes = new ArrayList<>();
    }

    /**
     * Devuelve las materias del XML.
     *
     * @return Materias del XML.
     */
    public ArrayList<Materia> getMaterias() {
        return materias;
    }

    /**
     * Deuvelve los personajes del XML.
     *
     * @return Personajes del XML.
     */
    public ArrayList<Personaxe> getPersonaxes() {
        return personaxes;
    }

    /**
     * Método que lee cada etiqueta de apertura del XML.
     *
     * @param uri Espacio de nombres.
     * @param localName Nombre local.
     * @param qName Nombre de la etiqueta.
     * @param attributes Atributos de la etiqueta.
     * @throws SAXException Excepción que arroja.
     */
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("personaxe")) {
            currentTag = qName;
            personOrAnimal = qName;
            currentPerson = new Personaxe();
            personaxes.add(currentPerson);
            currentPerson.setTipo(attributes.getValue("tipo"));
        } else if (qName.equals("nome") && personOrAnimal.equals("personaxe")) {
            currentTag = qName;
        } else if (qName.equals("hogwarts")) {
            currentTag = qName;
            currentPerson.setHogwarts(new Hogwarts());
            currentPerson.getHogwarts().setCasa(attributes.getValue("casa"));
            currentPerson.getHogwarts().setPosto(attributes.getValue("posto"));
        } else if (qName.equals("codigo")) {
            currentTag = qName;
        } else if (qName.equals("curso") && personOrAnimal.equals("personaxe")) {
            currentTag = qName;
        } else if (qName.equals("quidditch")) {
            currentTag = qName;
        } else if (qName.equals("caracteristicas")) {
            currentTag = qName;
        } else if (qName.equals("mascota")) {
            currentTag = qName;
            currentPerson.setMascota(new Mascota());
            currentPerson.getMascota().setAnimal(attributes.getValue("animal"));
            if (attributes.getValue("idade") != null) {
                currentPerson.getMascota().setIdade(Integer.parseInt(attributes.getValue("idade")));
            }
        } else if (qName.equals("protagonista")) {
            currentPerson.setProtagonista(Boolean.parseBoolean(attributes.getValue("valor")));
        } else if (qName.equals("materia")) {
            currentTag = qName;
            personOrAnimal = qName;
            currentMateria = new Materia();
            materias.add(currentMateria);
            currentMateria.setCodigo(attributes.getValue("codigo"));
        } else if (qName.equals("nome") && personOrAnimal.equals("materia")) {
            currentTag = qName;
        } else if (qName.equals("curso") && personOrAnimal.equals("materia")) {
            currentTag = qName;
        } else if (qName.equals("docente")) {
            currentTag = qName;
        } else if (qName.equals("alumno")) {
            currentTag = qName;
        }
    }

    /**
     * Método que lee cada etiqueta de cierre del XML.
     *
     * @param uri Espacio de nombres.
     * @param localName Nombre local.
     * @param qName Nombre de la etiqueta.
     * @throws SAXException Excepción que arroja.
     */
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
    }

    /**
     * Método que lee y procesa el contenido de cada etiqueta del XML.
     *
     * @param ch Caracteres del conetnido de la etiqueta.
     * @param start Donde empieza el contenido.
     * @param length Longitud del contenido.
     * @throws SAXException Excepción que arroja.
     */
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String aux = new String(ch, start, length).trim();
        if (aux.length() > 0) {
            if (currentTag.equals("nome") && personOrAnimal.equals("personaxe")) {
                currentPerson.setNome(aux);
            } else if (currentTag.equals("codigo")) {
                currentPerson.getHogwarts().setCodigo(aux);
            } else if (currentTag.equals("curso") && personOrAnimal.equals("personaxe")) {
                currentPerson.getHogwarts().setCurso(Integer.parseInt(aux));
            } else if (currentTag.equals("quidditch")) {
                currentPerson.getHogwarts().setQuidditch(aux);
            } else if (currentTag.equals("caracteristicas")) {
                currentPerson.setCaracteristicas(aux);
            } else if (currentTag.equals("mascota")) {
                currentPerson.getMascota().setNome(aux);
            } else if (currentTag.equals("nome") && personOrAnimal.equals("materia")) {
                currentMateria.setNome(aux);
            } else if (currentTag.equals("curso") && personOrAnimal.equals("materia")) {
                currentMateria.setCurso(Integer.parseInt(aux));
            } else if (currentTag.equals("docente")) {
                Personaxe docente = new Personaxe();
                docente.setNome(aux);
                currentMateria.setDocente(docente);
            } else if (currentTag.equals("alumno")) {
                for (int i = 0; i < personaxes.size(); i++) {
                    if (personaxes.get(i).getHogwarts() != null && personaxes.get(i).getHogwarts().getCodigo().equals(aux)) {
                        Personaxe alumno = personaxes.get(i);
                        currentMateria.getAlumnos().add(alumno);
                    }
                }
            }
        }
    }

    /**
     * Método que manda un aviso de fallo en el procesamiento del XML.
     *
     * @param e Excepción que arroja.
     * @throws SAXException Excepción que arroja.
     */
    @Override
    public void warning(SAXParseException e) throws SAXException {
        System.out.println("Aviso: " + e.getMessage());
    }

    /**
     * Método que avisa de un error en el procesamiento del XML.
     *
     * @param e Excepción que arroja.
     * @throws SAXException Excepción que arroja.
     */
    @Override
    public void error(SAXParseException e) throws SAXException {
        String message = "Erro: " + e.getMessage();
        throw new SAXException(message);
    }

    /**
     * Método que avisa de un error fatal en el procesamiento del XML.
     *
     * @param e Excepción que arroja.
     * @throws SAXException Excepción que arroja.
     */
    @Override
    public void fatalError(SAXParseException e) throws SAXException {
        String message = "Erro grave: " + e.getMessage();
        throw new SAXException(message);
    }

}
