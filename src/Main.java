import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.FileWriter;
import java.security.KeyException;
import java.text.NumberFormat.Style;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        HashMap<Integer, Household> households = new HashMap<>();

        Boolean loopBoolean = true;
        char choice;

        choice = scanner.nextLine().charAt(0);

        System.out.println(" Choose The Action You Want To Perform \n "
                + "A - To Add a HouseHold \n"
                + "B - To Add a Recycling Event\n"
                + "C - To Save The Data\n"
                + "D - To Display All \n"
                + "E - To Generate reports\n"

        );

        int idcounter = 0;
        while (loopBoolean) {

            switch (choice) {
                case 'a':
                case 'A':

                try {
                    System.out.println("Enter The Name");
                    String name = scanner.nextLine();
                    System.out.println("Enter The Address");
                    String address = scanner.nextLine();
                    idcounter++;
                    if (households.containsKey(idcounter)) {
                        throw new KeyException("The Key (ID) is Duplicated");
                    }
                    Household household = new Household(idcounter, name, address, LocalDateTime.now());
                    households.put(idcounter, household);

                 
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

                    break;
                case 'b':
                case 'B':
                    try {
                        System.out.println("Enter The Household ID To Assign The Event To");
                        int id = Integer.parseInt(scanner.nextLine());

                        System.out.println("Enter The Material Type");
                        String materialType = scanner.nextLine();

                        System.out.println("Enter The Weight in kilograms");
                        int weightInKG = Integer.parseInt(scanner.nextLine());
                        if (weightInKG < 0) {
                            throw new InputMismatchException("The Input Is Negetive");
                        }

                        System.out.println("Enter The Date of recycling");
                        LocalDate dateOfRecycling = LocalDate.parse(scanner.nextLine());

                        double ecoPoints = weightInKG * 10;

                        RecyclingEvent recyclingevent = new RecyclingEvent(materialType, weightInKG, dateOfRecycling,
                                ecoPoints);

                        Household eventAssignedHousehold = households.get(id);

                        eventAssignedHousehold.recyclingevents.add(recyclingevent);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                case 'c':
                case 'C':
                    try {
                        FileWriter filewriter = new FileWriter("RecycleData.txt");

                        for (Household householdLoop : households.values()) {
                            filewriter.write("ID = " + householdLoop.getId() +
                                    "\nName = " + householdLoop.getName() +
                                    "\nAddress =" + householdLoop.getAddress() +
                                    "\nJoining Date = " + householdLoop.getJoiningDate());
                            int recyclingCounter = 0;

                            for (RecyclingEvent re : householdLoop.recyclingevents) {
                                filewriter.write(householdLoop.getName() + "Recycling Record \n"
                                        + "\n " + recyclingCounter + " . "
                                        + "Material Type = " + re.materialtype
                                        + "\n Weight in KG" + re.weight
                                        + "\n Date of Recycling " + re.dateofrecycling
                                        + "\n Points Earnedd" + re.pointsearned

                                );
                            }

                        }
                        filewriter.close();

                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'd':
                case 'D':

                    for (Household householdLoop : households.values()) {
                        System.out.println("ID = " + householdLoop.getId() +
                                "\nName = " + householdLoop.getName() +
                                "\nAddress =" + householdLoop.getAddress() +
                                "\nJoining Date = " + householdLoop.getJoiningDate() +
                                "\nTotal Points Earned = " + householdLoop.calulateTotalWeight());
                        int recyclingCounter = 0;

                        for (RecyclingEvent re : householdLoop.recyclingevents) {
                            System.out.println(householdLoop.getName() + "Recycling Record \n"
                                    + "\n " + recyclingCounter + " . "
                                    + "\n Material Type = " + re.materialtype
                                    + "\n Weight in KG" + re.weight
                                    + "\n Date of Recycling " + re.dateofrecycling
                                    + "\n Points Earnedd" + re.pointsearned);
                        }
                    }
                    break;

                case 'E':
                case 'e':

                    Household highestHousehold = null;
                    double highestHouseholdPoints = 0;

                    for (Household x : households.values()) {

                        double totalPoints = x.recyclingevents.stream()
                                .mapToDouble(z -> z.getPointsearned())
                                .sum();

                        if (highestHousehold == null || totalPoints > highestHouseholdPoints) {
                            highestHousehold = x;
                            highestHouseholdPoints = totalPoints;
                        }
                    }

                    if (highestHousehold != null) {
                        System.out.println("Household with the highest total points:");
                        System.out.println("ID = " + highestHousehold.getId());
                        System.out.println("Name = " + highestHousehold.getName());
                        System.out.println("Total Points = " + highestHouseholdPoints);
                    } else {
                        System.out.println("No households available.");
                    }

                default:
                    break;
            }

        }

        scanner.close();
    }
}