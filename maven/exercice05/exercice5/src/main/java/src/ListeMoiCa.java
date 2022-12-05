/**
 * Eric PERRAUD
 * Lauryne GAULTIER
 */

package src;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

import src.src.my.library.*;

public class ListeMoiCa {

    public static void main(String[] args) {

        System.out.println("Processing library03.xml");

        InputStream inputStream = null;

        try {
            inputStream = new FileInputStream("library03.xml");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        Library library = null;

        JAXBContext jaxbContext = null;

        try {
            jaxbContext = JAXBContext.newInstance("my.library");
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            library = (Library) unmarshaller.unmarshal(inputStream);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }

        System.out.println("La base contient "+library.getBook().size()+" livre(s)");
        System.out.println("isbn  disponibilité langue  titre  premier-auteur id nombre-de-personnages");

        List<Book> books = library.getBook();

        for (Book b:books) {
            System.out.println(
                    b.getIsbn() + " " +
                    b.isAvailable() + " " +
                    b.getTitle().getLang() + " " +
                    b.getTitle() + " " +
                    b.getAuthor() + " " +
                    b.getId() + " " +
                    b.getCharacter().size());
        }

    }
}
