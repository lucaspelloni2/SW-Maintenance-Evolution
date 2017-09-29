package Exercise_1;

import Utilities.FileReader;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ex1_Main {

    public static void main(String[] args) {

        final String ORACLE_PATH = "/Users/LuckyP/Desktop/UZH/Master/Software Maintenance and Evolution/Coding/SW-Maintenance-Evolution/src/Exercise_1/Easy_Clinic_Data/oracle/UC_CC.txt";
        List<String> oracle = FileReader.readFile(ORACLE_PATH);


        Map <String, List<ClassDescription>> results = new HashMap<>();

        final int[] totalNumberOfCorrectLinks = {0};


        // Step 1: extract from dataset which use cases are really linked to which class description according to the oracle
        oracle.forEach(line -> {
            String newLine = line.replace(".txt", "").replace(":", " ");
            String[] ids = newLine.split("\\s");
            List<ClassDescription> realLinkedClassDesciprtions = new ArrayList<>();
            String useCaseId = ids[0];
            for (int i = 0; i < ids.length; i++) {
                if (i != 0) {
                    realLinkedClassDesciprtions.add(new ClassDescription(ids[i]));
                    totalNumberOfCorrectLinks[0]++;
                }
            }

            UseCase useCase = new UseCase(useCaseId, realLinkedClassDesciprtions);
            results.put(useCaseId, realLinkedClassDesciprtions);
        });

        System.out.println("Total number of correct links: " + totalNumberOfCorrectLinks[0]);

        // Step 2: Calculate recall & precision for each ranked_list
        final String RANKED_LIST_55_PATH = "/Users/LuckyP/Desktop/UZH/Master/Software Maintenance and Evolution/Coding/SW-Maintenance-Evolution/src/Exercise_1/Easy_Clinic_Data/rankedlists/ranked_list55.txt";
        final String RANKED_LIST_65_PATH = "/Users/LuckyP/Desktop/UZH/Master/Software Maintenance and Evolution/Coding/SW-Maintenance-Evolution/src/Exercise_1/Easy_Clinic_Data/rankedlists/ranked_list65.txt";
        final String RANKED_LIST_75_PATH = "/Users/LuckyP/Desktop/UZH/Master/Software Maintenance and Evolution/Coding/SW-Maintenance-Evolution/src/Exercise_1/Easy_Clinic_Data/rankedlists/ranked_list75.txt";


        List<String> rankedList = FileReader.readFile(RANKED_LIST_55_PATH);
        final int[] numberOfLinkedDocuments = {0};


        rankedList.forEach(line -> {
            final boolean[] areReallyLinked = {false};
            String newLine = line.replace(".txt", "");
            String[] temp = newLine.split(",");
            String useCaseSourceId = temp[0];
            String classDescTargetId = temp[1];

            List<ClassDescription> realLinkedClassDesc = results.get(useCaseSourceId);

            if (realLinkedClassDesc != null) {
                realLinkedClassDesc.forEach(cDesc -> {
                    if (cDesc.getId().equals(classDescTargetId)) {
                        numberOfLinkedDocuments[0]++;
                    }
                });
            }

        });

        System.out.println("Ranked List size: " +rankedList.size());
        System.out.println("Total number of linked documents " + numberOfLinkedDocuments[0]);
        System.out.println("Precision " );
        System.out.println("Recall ");





    }
}
