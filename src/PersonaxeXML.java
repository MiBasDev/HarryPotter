
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 * Clase que procesa o documento XML para crear a estrutura de personaxes e
 * materias.
 *
 * @author Miguel Bastos Gándara.
 */
public class PersonaxeXML {

    private ArrayList<Personaxe> personaxes;
    private ArrayList<Materia> materias;
    private boolean usingSchema;

    /**
     * Constructor da clase PersonaxesXML.
     */
    public PersonaxeXML() {
        personaxes = new ArrayList<>();
        materias = new ArrayList<>();
    }

    /**
     * Método que obtén a lista de personaxes que teñen posto de profesor.
     *
     * @return Lista de personaxes que teñen posto de profesor.
     */
    public ArrayList<Personaxe> getTeachers() {
        ArrayList<Personaxe> teachers = new ArrayList<>();
        for (int i = 0; i < personaxes.size(); i++) {
            if (!personaxes.get(i).getHogwarts().getPosto().equals("alumnado")) {
                teachers.add(personaxes.get(i));
            }
        }
        return teachers;
    }

    /**
     * Método que obtén a lista de personaxes que teñen posto de alumno.
     *
     * @return Lista de personaxes que teñen posto de alumno.
     */
    public ArrayList<Personaxe> getStudents() {
        ArrayList<Personaxe> students = new ArrayList<>();
        for (int i = 0; i < personaxes.size(); i++) {
            if (personaxes.get(i).getHogwarts().getPosto().equals("alumnado")) {
                students.add(personaxes.get(i));
            }
        }
        return students;
    }

    /**
     * Método que procesa o documento XML do ficheiro File con DOM, e
     * establecendo os atributos para validar o documento se o valor do atributo
     * usingSchema vale true.
     *
     * @param file Documento XML.
     * @return Documento coa estrutura do XML cargada.
     * @throws ParserConfigurationException Excepción que arroja.
     * @throws SAXException Excepción que arroja.
     * @throws IOException Excepción que arroja.
     */
    private Document readXMLDocument(File file) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        // Lectura do documento XML con DOM
        Document doc = builder.parse(file);
        return doc;
    }

    /**
     * Método que obtén unha personaxe da lista de personaxes cun código de
     * Hogwarts.
     *
     * @param code Código do personaxe.
     * @return Personaxe da lista de personaxes cun código de Hogwarts.
     */
    private Personaxe findByCode(String code) {
        Personaxe personaxe = null;
        for (int i = 0; i < personaxes.size(); i++) {
            if (personaxes.get(i).getHogwarts().getCodigo().equals(code)) {
                personaxe = personaxes.get(i);
            }
        }
        return personaxe;
    }

    /**
     * Método que crea un obxecto Personaxe a partir da información que colga do
     * nodo recibido como parámetro.
     *
     * @param node Nodo do que recibir o parámetro.
     * @return Personaxe a partir da información que colga do nodo recibido como
     * parámetro.
     */
    private Personaxe createPersonaxe(Node node) {
        Personaxe personaxe = new Personaxe();
        personaxe.setTipo(node.getAttributes().getNamedItem("tipo").getNodeValue());
        for (int i = 0; i < node.getChildNodes().getLength(); i++) {
            personaxe.setNome(node.getChildNodes().item(i).getNodeValue());
            personaxe.getHogwarts().setCasa(node.getChildNodes().item(i).getAttributes().getNamedItem("casa").getNodeValue());
            personaxe.getHogwarts().setPosto(node.getChildNodes().item(i).getAttributes().getNamedItem("posto").getNodeValue());
            for (int j = 0; j < node.getChildNodes().item(i).getChildNodes().getLength(); j++) {
                personaxe.getHogwarts().setCodigo(node.getChildNodes().item(i).getChildNodes().item(j).getNodeValue());
                personaxe.getHogwarts().setCurso(Integer.parseInt(node.getChildNodes().item(i).getChildNodes().item(j).getNodeValue()));
                personaxe.getHogwarts().setQuidditch(node.getChildNodes().item(i).getChildNodes().item(j).getNodeValue());
            }
            personaxe.setCaracteristicas(node.getChildNodes().item(i).getNodeValue());
            personaxe.getMascota().setAnimal(node.getChildNodes().item(i).getAttributes().getNamedItem("animal").getNodeValue());
            personaxe.getMascota().setIdade(Integer.parseInt(node.getChildNodes().item(i).getAttributes().getNamedItem("idade").getNodeValue()));
            personaxe.getMascota().setNome(node.getChildNodes().item(i).getNodeValue());
            personaxe.setProtagonista(Boolean.parseBoolean(node.getChildNodes().item(i).getAttributes().getNamedItem("valor").getNodeValue()));
        }
        return personaxe;
    }

    /**
     * Mñetodo que crea un obxecto Materia a partir da información que colga do
     * nodo recibido como parámetro.
     *
     * @param node Nodo do que recibir o parámetro.
     * @return Materia a partir da información que colga do nodo recibido como
     * parámetro.
     */
    private Materia createMateria(Node node) {
        Materia materia = new Materia();
        materia.setCodigo(node.getAttributes().getNamedItem("codigo").getNodeValue());
        for (int i = 0; i < node.getChildNodes().getLength(); i++) {
            materia.setNome(node.getChildNodes().item(i).getNodeValue());
            materia.setCurso(Integer.parseInt(node.getChildNodes().item(i).getNodeValue()));
            Personaxe docente = null;
            for (int j = 0; j < personaxes.size(); j++) {
                if (personaxes.get(j).getNome().equals(node.getChildNodes().item(i).getNodeValue())) {
                    docente = personaxes.get(j);
                }
            }
            materia.setDocente(docente);
            ArrayList alumnado = new ArrayList();
            for (int j = 0; j < personaxes.size(); j++) {
                if (personaxes.get(j).getNome().equals(node.getChildNodes().item(i).getNodeValue())) {
                    alumnado.add(personaxes.get(j));
                }
                i++;
            }
            materia.setAlumnos(alumnado);
        }
        return materia;
    }

    /**
     * Método que carga nos atributos "personaxes" e "materias" as listas con
     * toda a información que se atopa no documento XML almacenado no ficheiro
     * recibido como parámetro.
     *
     * @param file Documento XML.
     * @throws ParserConfigurationException Excepción que arroja.
     * @throws SAXException Excepción que arroja.
     * @throws IOException Excepción que arroja.
     */
    public void loadPersonaxes(File file) throws ParserConfigurationException, SAXException, IOException {
        Document doc = readXMLDocument(file);
        // Obtemos os nodos fillos do elemento raíz
        NodeList list = doc.getDocumentElement().getChildNodes();
        for (int i = 0; i < list.getLength(); i++) {
            if (list.item(i).getNodeType() == Node.ELEMENT_NODE) {
                Element e = (Element) list.item(i);
                if (e.getNodeName().equals("personaxe")) {
                    Personaxe personaxe = createPersonaxe(e);
                    personaxes.add(personaxe);
                } else if (e.getNodeName().equals("materia")) {
                    Materia materia = createMateria(e);
                    materias.add(materia);
                }
            }
        }

    }
}
