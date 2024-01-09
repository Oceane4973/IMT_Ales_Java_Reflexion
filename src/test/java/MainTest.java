import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.example.*;
import org.objectweb.asm.*;
import java.sql.SQLException;

public class MainTest {

    @Test
    public void testPersistence() {
        /*Club club = new Club();
        club.setFabricant(“un nom");
                club.setPoids(10.3);

        EntityManagerImpl em = new EntityManagerImpl();
        em.persist(club);*/
    }

    @Test
    public void testFind() throws SQLException {
        /*
        Club club = = new Club();
        club.setFabricant(“un  nom");
                club.setPoids(10.3);

        EntityManagerImpl em = new EntityManagerImpl();
        Club trouve = em.<Club> find(Club.class, club.getId());
        Assert.assertEquals(club.getFabricant(), trouve.getFabricant());*/
    }
}
