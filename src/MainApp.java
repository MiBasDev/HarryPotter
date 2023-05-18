
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 * Clase que contén o método "main()", e que procesa o contido dun ficheiro XML
 * de Harry Potter e o mostra pola consola.
 *
 * @author Miguel Bastos Gándara.
 */
public class MainApp {

    private SAXListener parseXMLDocument() throws ParserConfigurationException, SAXException {
        // Creamos o obxecto oínte
        SAXListener listener = new SAXListener();;
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            // Establecemos estas propidades para validar o documento XML
            factory.setNamespaceAware(true);
            factory.setValidating(true);
            SAXParser parser = factory.newSAXParser();
            // Esta propiedade só a establecemos se validamos o documento cun esquema
            parser.setProperty("http://java.sun.com/xml/jaxp/properties/schemaLanguage",
                    "http://www.w3.org/2001/XMLSchema");
            // Ficheiro a procesar
            File XMLfile = new File("potter.xml");
            // Lanzamos o proceso de parseo
            parser.parse(XMLfile, listener);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            System.out.println("Erro ao procesar o documento XML: " + e.getMessage());
        }
        return listener;
    }

    private void showContent(SAXListener listener) {
        for (Personaxe personaxe : listener.getPersonaxes()) {
            System.out.println("Personaxe: " + personaxe.getNome());
            System.out.println("- Tipo: " + personaxe.getTipo());
            if (personaxe.getHogwarts() != null) {
                System.out.println("- Datos de Hogwarts: ");
                System.out.println("\t" + "- Casa: " + personaxe.getHogwarts().getCasa());
                System.out.println("\t" + "- Posto: " + personaxe.getHogwarts().getPosto());
                System.out.println("\t" + "- Código: " + personaxe.getHogwarts().getCodigo());
                System.out.println("\t" + "- Curso: " + personaxe.getHogwarts().getCurso());
                if (personaxe.getHogwarts().getQuidditch() != null) {
                    System.out.println("\t" + "- Quidditch: " + personaxe.getHogwarts().getQuidditch());
                }
            }
            System.out.println("- Caraterísticas: " + personaxe.getCaracteristicas());
            if (personaxe.getMascota() != null) {
                System.out.println("- Mascota: ");
                System.out.println("\t" + "- Animal: " + personaxe.getMascota().getAnimal());
                System.out.println("\t" + "- Idade: " + personaxe.getMascota().getIdade());
                System.out.println("\t" + "- Nome: " + personaxe.getMascota().getNome());
            }
            System.out.println("");
            System.out.println("-------------------------------------------------");
            System.out.println("");
        }
        if (listener.getMaterias() != null) {
            int count = listener.getMaterias().size();
            for (Materia materia : listener.getMaterias()) {
                System.out.println("Materia: " + materia.getNome());
                System.out.println("- Curso: " + materia.getCurso());
                System.out.println("- Docente: " + materia.getDocente().getNome());
                System.out.println("- Alumnado: ");
                for (int i = 0; i < materia.getAlumnos().size(); i++) {
                    System.out.println("\t" + "- " + materia.getAlumnos().get(i).getNome());
                }
                count--;
                if (count > 0) {
                    System.out.println("");
                    System.out.println("-------------------------------------------------");
                    System.out.println("");
                }
            }
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        /* Set the GTK+ look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("GKT+".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameHogwarts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        MainApp app = new MainApp();
        SAXListener listener;
        PersonaxeXML personaxe = new PersonaxeXML();
        File file = new File("potter.xml");
        try {
            personaxe.loadPersonaxes(file);
//        try {
//            listener = app.parseXMLDocument();
//            app.showContent(listener);
//        } catch (ParserConfigurationException | SAXException ex) {
//            System.out.println("Error al procesar el documento: " + ex.getMessage());
//        }
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
