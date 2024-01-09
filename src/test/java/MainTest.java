import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.example.*;
import java.sql.SQLException;

public class MainTest {

    @Test
    public void testPersistence() {
        Club club = new Club();
        club.setFabricant("Adidas");
        club.setPoids(10.3);

        EntityManagerImpl em = new EntityManagerImpl();
        em.persist(club);
    }

    @Test
    public void testFind() throws SQLException {
        Club club = new Club();
        club.setFabricant("Adidas Golf");
        club.setPoids(13.2);

        EntityManagerImpl em = new EntityManagerImpl();
        em.persist(club);

        Club find = (Club) em.<Club> find(Club.class, club.getId());

        Assertions.assertEquals(club.getFabricant(), find.getFabricant());
        Assertions.assertEquals(club.getVersion(), find.getVersion());
        Assertions.assertEquals(club.getPoids(), find.getPoids());
    }

    @Test
    public void testUpdate() throws SQLException {
        Club club_before = new Club();
        club_before.setFabricant("Arccos");
        club_before.setPoids(14.2);

        EntityManagerImpl em = new EntityManagerImpl();
        em.persist(club_before);

        Club club_after = new Club();
        club_after.setId(club_before.getId());
        club_after.setFabricant("Boston");
        club_after.setPoids(13.4);
        club_after.setVersion(2);

        Club merge = (Club) em.<Club> merge(club_after);
        Club find = (Club) em.<Club> find(Club.class, club_before.getId());

        Assertions.assertEquals(find.getFabricant(), club_after.getFabricant());
        Assertions.assertEquals(find.getVersion(), club_after.getVersion());
        Assertions.assertEquals(find.getPoids(), club_after.getPoids());
    }

    @Test
    public void testRemove() throws SQLException {
        Club club = new Club();
        club.setFabricant("Arccos");
        club.setPoids(14.2);

        EntityManagerImpl em = new EntityManagerImpl();
        em.persist(club);
        em.remove(club);

        Club find = (Club) em.<Club> find(Club.class, club.getId());

        Assertions.assertNull(find);
    }
}
