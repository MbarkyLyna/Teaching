package tn.esprit.spring;

import java.util.ArrayList;
import java.util.List;


public class BusinessUI {


    private static List<TeachingUI> units = new ArrayList<>();


    static {
        units.add(new TeachingUI(1, "Informatique", "Mme Maroua Douiri", 6, 1));
        units.add(new TeachingUI(2, "Mathématiques", "Mme Ines ElMejid", 5, 1));
        units.add(new TeachingUI(3, "Physique", "Mme Sarra Abidi", 4, 2));
    }


    public List<TeachingUI> getAll() {
        return units;
    }


    public TeachingUI getByCode(int code) {
        return units.stream()
                .filter(u -> u.getCode() == code)
                .findFirst()
                .orElse(null);
    }


    public static void add(TeachingUI unit) {
        units.add(unit);
    }


    public boolean update(int code, TeachingUI updated) {
        TeachingUI existing = getByCode(code);
        if (existing != null) {
            existing.setDomain(updated.getDomain());
            existing.setHead(updated.getHead());
            existing.setCredits(updated.getCredits());
            existing.setSemester(updated.getSemester());
            return true;
        }
        return false;
    }


    public boolean delete(int code) {
        return units.removeIf(u -> u.getCode() == code);
    }
}