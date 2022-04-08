package edu.tcu.cs.hogwartsartifactsonline.datainitializer;

import edu.tcu.cs.hogwartsartifactsonline.dao.ArtifactDao;
import edu.tcu.cs.hogwartsartifactsonline.dao.UserDao;
import edu.tcu.cs.hogwartsartifactsonline.dao.WizardDao;
import edu.tcu.cs.hogwartsartifactsonline.domain.Artifact;
import edu.tcu.cs.hogwartsartifactsonline.domain.User;
import edu.tcu.cs.hogwartsartifactsonline.domain.Wizard;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DBDataInitializer implements CommandLineRunner {

    private ArtifactDao artifactDao;
    private WizardDao wizardDao;
    private UserDao userDao;

    public DBDataInitializer(ArtifactDao artifactDao, WizardDao wizardDao, UserDao userDao) {
        this.artifactDao = artifactDao;
        this.wizardDao = wizardDao;
        this.userDao = userDao;
    }

    @Override
    public void run(String... args) throws Exception {
        Artifact a1 = new Artifact();
        a1.setId("1250808601736515584");
        a1.setName("Deluminator");
        a1.setDescription("a device invented by Dumbledore");
        a1.setImageURL("imageUrl");

        Artifact a2 = new Artifact();
        a2.setId("1250808601736515585");
        a2.setName("Invisibility Cloak");
        a2.setDescription("used to make the wearer invisible");
        a2.setImageURL("imageUrl");

        Artifact a3 = new Artifact();
        a3.setId("1250808601736515586");
        a3.setName("Elder Wand");
        a3.setDescription("known throughout history as the Deathstick");
        a3.setImageURL("imageUrl");

        Artifact a4 = new Artifact();
        a4.setId("1250808601736515587");
        a4.setName("The Marauder's Map");
        a4.setDescription("A magical map of Hogwarts");
        a4.setImageURL("imageUrl");

        Artifact a5 = new Artifact();
        a5.setId("1250808601736515588");
        a5.setName("The Sword of Gryffindor");
        a5.setDescription("a goblin-made sword");
        a5.setImageURL("imageUrl");

        Artifact a6 = new Artifact();
        a6.setId("1250808601736515589");
        a6.setName("Resurrection Stone");
        a6.setDescription("allows the holder to bring back deceased");
        a6.setImageURL("imageUrl");

        Wizard w1 = new Wizard();
        w1.setName("Albus Dumbledore");
        w1.addArtifact(a1);
        w1.addArtifact(a3);

        Wizard w2 = new Wizard();
        w2.setName("Harry Potter");
        w2.addArtifact(a2);
        w2.addArtifact(a4);

        Wizard w3 = new Wizard();
        w3.setName("Neville Longbottom");
        w3.addArtifact(a5);

        wizardDao.save(w1);
        wizardDao.save(w2);
        wizardDao.save(w3);
        artifactDao.save(a6);

        User u1 = new User();
        u1.setUsername("john");
        u1.setPassword("$267432");
        u1.setEnabled(true);
        u1.setRoles("admin");

        User u2 = new User();
        u2.setUsername("eric");
        u2.setPassword("67373");
        u2.setEnabled(true);
        u2.setRoles("user");

        User u3 = new User();
        u3.setUsername("tom");
        u3.setPassword("$2u19u4rei");
        u3.setEnabled(false);
        u3.setRoles("user");

        userDao.save(u1);
        userDao.save(u2);
        userDao.save(u3);
    }
}
