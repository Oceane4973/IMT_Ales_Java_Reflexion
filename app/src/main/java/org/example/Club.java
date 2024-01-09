package org.example;

public class Club {

    private long id;
    private int version;
    private String fabricant;
    private Double poids;

    public Club(){}

    public Club(long id, int version, String fabricant, Double poids){
        this.id = id;
        this.version = version;
        this.fabricant = fabricant;
        this.poids = poids;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getFabricant() {
        return fabricant;
    }

    public void setFabricant(String fabricant) {
        this.fabricant = fabricant;
    }

    public Double getPoids() {
        return poids;
    }

    public void setPoids(Double poids) {
        this.poids = poids;
    }

    @Override
    public String toString() {
        return  "*******************************\n" +
                "ID : " + this.id + "\n" +
                "*******************************\n" +
                "VERSION : " + this.version + "\n" +
                "FABRICANT : " + this.fabricant + "\n" +
                "POIDS : " + this.poids + "\n" +
                "*******************************\n";
    }
}
