package model;

import model.enums.Gender;

public class Animal {
    private long Animalid;
    private String Animalname;
    private  int Animalage;
    private Gender Animalgender;

    public Animal(long animalid, String animalname, int animalage, Gender animalgender) {
        Animalid = animalid;
        Animalname = animalname;
        Animalage = animalage;
        Animalgender = animalgender;
    }



    public long getAnimalid() {
        return Animalid;
    }

    public void setAnimalid(long animalid) {
        Animalid = animalid;
    }

    public String getAnimalname() {
        return Animalname;
    }

    public void setAnimalname(String animalname) {
        Animalname = animalname;
    }

    public int getAnimalage() {
        return Animalage;
    }

    public void setAnimalage(int animalage) {
        Animalage = animalage;
    }

    public Gender getAnimalgender() {
        return Animalgender;
    }

    public void setAnimalgender(Gender animalgender) {
        Animalgender = animalgender;
    }

    @Override
    public String toString() {
        return "🟢 Animal🟢"+"\n"+
                "Animalid=" + Animalid +"\n"+
                "Animalname='" + Animalname + "\n"+
                "Animalage=" + Animalage +"\n"+
                "Animalgender=" + Animalgender+ "\n";
    }
}
