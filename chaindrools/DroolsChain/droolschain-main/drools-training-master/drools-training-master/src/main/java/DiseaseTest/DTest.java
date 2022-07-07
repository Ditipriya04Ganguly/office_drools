package DiseaseTest;

import model.Location;
import model.Patient;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieSession;

import java.time.LocalDate;
import java.util.*;

public class DTest {
    public static void main(String[] args) {
        try {

            KieSession ksession = KieServices.Factory.get().getKieClasspathContainer().newKieSession("diseaserules");
            HashMap<String, String> codesDates = new HashMap<String, String>();
            codesDates.put("R13.1","2022.06.01");
            codesDates.put("R13.19","2022.01.14");
            codesDates.put("R13.12","2022.02.26");
            codesDates.put("R13.13","2022.04.09");
            codesDates.put("R13.14","2022.03.10");
            

            
            Patient p= new Patient("R13.1","Active", LocalDate.of(2022,06,01));
            ksession.insert(p);
            ksession.fireAllRules();
            ksession.dispose();
            System.out.println();

        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
}
