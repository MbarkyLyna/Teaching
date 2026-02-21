package tn.esprit.spring;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ModuleBusiness {

    private static List<Module> modules;
    private BusinessUI businessUI = new BusinessUI();

    public ModuleBusiness() {
        modules = new ArrayList<>();

        modules.add(new Module("M101", "Algorithms", 3, 30,
                Module.TypeModule.PROFESSIONNEL,
                businessUI.getByCode(1)));

        modules.add(new Module("M102", "Databases", 2, 20,
                Module.TypeModule.PROFESSIONNEL,
                businessUI.getByCode(1)));

        modules.add(new Module("M201", "Communication", 1, 15,
                Module.TypeModule.TRANSVERSAL,
                businessUI.getByCode(2)));
    }

    public boolean addModule(Module module) {
        int code = module.getTeachingUI().getCode();
        TeachingUI teachingUI = businessUI.getByCode(code);
        if (teachingUI != null) {
            module.setTeachingUI(teachingUI);
            return modules.add(module);
        }
        return false;
    }

    public Module getModuleByCode(String code) {
        for (Module m : modules) {
            if (m.getMatricule().equals(code)) {
                return m;
            }
        }
        return null;
    }

    public List<Module> getModulesByType(Module.TypeModule type) {
        List<Module> result = new ArrayList<>();
        for (Module m : modules) {
            if (m.getTypeM() == type) {
                result.add(m);
            }
        }
        return result;
    }

    public boolean updateModule(String code, Module updatedModule) {
        for (int i = 0; i < modules.size(); i++) {
            if (modules.get(i).getMatricule().equals(code)) {
                modules.set(i, updatedModule);
                return true;
            }
        }
        return false;
    }

    public boolean deleteModule(String code) {
        Iterator<Module> iterator = modules.iterator();
        while (iterator.hasNext()) {
            Module m = iterator.next();
            if (m.getMatricule().equals(code)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    public List<Module> getAllModules() {
        return modules;
    }

    public List<Module> getModulesByTeachingUnit(TeachingUI teachingUI) {
        List<Module> result = new ArrayList<>();
        for (Module m : modules) {
            if (m.getTeachingUI() != null &&
                    m.getTeachingUI().getCode() == teachingUI.getCode()) {
                result.add(m);
            }
        }
        return result;
    }
}