package model;

import model.enums.Gender;

public class Person {
    private long Personid;
    private String Personname;
    private  int Personage;
    private Gender Persongender;

    public Person(long personid, String personname, int personage, Gender persongender) {
        Personid = personid;
        Personname = personname;
        Personage = personage;
        Persongender = persongender;
    }


    public long getPersonid() {
        return Personid;
    }

    public void setPersonid(long personid) {
        Personid = personid;
    }

    public String getPersonname() {
        return Personname;
    }

    public void setPersonname(String personname) {
        Personname = personname;
    }

    public int getPersonage() {
        return Personage;
    }

    public void setPersonage(int personage) {
        Personage = personage;
    }

    public Gender getPersongender() {
        return Persongender;
    }

    public void setPersongender(Gender persongender) {
        Persongender = persongender;
    }

    @Override
    public String toString() {
        return "🟢Person🟢" +
                "Personid=" + Personid +"\n"+
                "Personname=" + Personname + "\n"+
                "Personage=" + Personage +"\n"+
                "Persongender=" + Persongender +"\n"
                ;
    }
}
