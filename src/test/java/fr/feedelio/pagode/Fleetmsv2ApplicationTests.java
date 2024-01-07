package fr.feedelio.pagode;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import fr.feedelio.pagode.archives.models.Document;
import fr.feedelio.pagode.archives.repositories.DocumentRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class Fleetmsv2ApplicationTests {

    @Autowired
    private DocumentRepository documentRepository;

    @Autowired
    private TestEntityManager testEntityManager; // Utiliser TestEntityManager

    @Test
    @Rollback(false)
    void testInsertDocument() throws IOException {
        File file = new File("C:\\Données\\OneDrive\\Images\\OIP.jpg");

        Document document = new Document();
        document.setName(file.getName());

        byte[] bytes = Files.readAllBytes(file.toPath());
        document.setContent(bytes);
        document.setSize((long) bytes.length);
        document.setUploadTime(new Date());

        Document savedDoc = documentRepository.save(document); // Insère le document dans la base de données

        // Utiliser TestEntityManager pour rechercher l'entité dans la base de données
        Document existDoc = testEntityManager.find(Document.class, savedDoc.getId());

        // Ajouter une valeur de référence pour la taille du fichier
        long fileSize = bytes.length;

        // Utiliser assertThat pour vérifier l'égalité de la taille
        assertThat(existDoc.getSize()).isEqualTo(fileSize);
    }
}
