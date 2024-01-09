package org.example;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOClub extends DAO<Club> {
    @Override
    public Club find(long id) {
        Club club = null;
        try {
            ResultSet result = this.connect
                    .createStatement(
                            ResultSet.TYPE_SCROLL_INSENSITIVE,
                            ResultSet.CONCUR_READ_ONLY
                    ).executeQuery(
                            "SELECT * FROM club WHERE club_id = " + id
                    );
            if(result.first())
                club = new Club(
                        id,
                        result.getInt("club_version"),
                        result.getString("club_fabricant"),
                        result.getDouble("club_poids")
                );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return club;
    }

    @Override
    public Club create(Club obj) {
        try {
            ResultSet result = this.connect
                    .createStatement(
                            ResultSet.TYPE_SCROLL_INSENSITIVE,
                            ResultSet.CONCUR_UPDATABLE
                    ).executeQuery(
                            "SELECT NEXTVAL('club_club_id_seq') as id"
                    );
            if(result.first()){
                long id = result.getLong("id");
                PreparedStatement prepare = this.connect
                        .prepareStatement(
                                "INSERT club (club_id, club_version, club_fabricant, club_poids) VALUES(?, ?, ?, ?)"
                        );
                prepare.setLong(1, id);
                prepare.setInt(2, obj.getVersion());
                prepare.setString(2, obj.getFabricant());
                prepare.setDouble(2, obj.getPoids());

                prepare.executeUpdate();
                obj = this.find(id);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return obj;
    }

    @Override
    public Club update(Club obj) {
        try{
            this.connect
                    .createStatement(
                            ResultSet.TYPE_SCROLL_INSENSITIVE,
                            ResultSet.CONCUR_UPDATABLE
                    ).executeUpdate(
                            "UPDATE club SET club_version = '" + obj.getVersion() + "',"+
                                    " club_fabricant = '" + obj.getFabricant() + "',"+
                                    " club_poids = '" + obj.getPoids() + "'"+
                                    " WHERE club_id = " + obj.getId()
                    );

            obj = this.find(obj.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return obj;
    }

    @Override
    public void delete(Club obj) {
        try {
            this.connect
                    .createStatement(
                            ResultSet.TYPE_SCROLL_INSENSITIVE,
                            ResultSet.CONCUR_UPDATABLE
                    ).executeUpdate(
                            "DELETE FROM club WHERE club_id = " + obj.getId()
                    );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
