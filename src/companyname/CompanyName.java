package companyname;
/*Write a java program to sort and filter a list of company names
. Program should accept company names and return a filtered list of names based on input
. Filtering can be partial or by complete names
. Filtering should not be case sensitive
. Ignore white spaces while filtering
. Program allows for sorting the list of company names in alphabetical and reverse alphabetical order.
*/


import java.util.*;
import java.util.stream.Stream;

public class CompanyName {
    public static void inputNSortCompanyName() {
        Scanner scanner1 = new Scanner(System.in);
        int k = 1;
        do {
            System.out.print("How many company's name you want to input?: ");
            try {
                int numberOfCompany = scanner1.nextInt();
                if (numberOfCompany > 1) {
                    k = 1;
                    String[] companyNameArray = new String[numberOfCompany];
                    Scanner scanner2 = new Scanner(System.in);
                    for (int i = 0; i < companyNameArray.length; i++) {
                        System.out.print("Enter " + (i + 1) + " company's name please: ");
                        companyNameArray[i] = scanner2.nextLine().trim();
                    }
                    System.out.print("\nEnter company name(partial/full) to search: ");
                    Scanner scanner3 = new Scanner(System.in);
                    String searchOption = scanner3.nextLine();
                    int matchCount = 0;
                    for (int i = 0; i < companyNameArray.length; i++) {
                        if (companyNameArray[i].toLowerCase().contains(searchOption.trim().toLowerCase())) {
                            System.out.println(companyNameArray[i]);
                            matchCount++;
                        }
                    }
                    if (matchCount == 0) {
                        System.out.println("\nCompany name not found, containing '" + searchOption + "' in the list");
                    }
                    Scanner scanner4 = new Scanner(System.in);
                    int sortType = 1;
                    do {
                        System.out.println("\nHow do you want to sort the company names?");
                        System.out.println("Alphabetical = 1, and Reverse Alphabetical = 2");
                        System.out.print("Choose option please (1/2): ");
                        sortType = scanner4.nextInt();
                        if ((sortType > 0) && (sortType <= 2)) {
                            switch (sortType) {
                                case 1:
                                    companyNameArray = Stream.of(companyNameArray).sorted().toArray(String[]::new);
                                    System.out.println();
                                    System.out.println("Company names in alphabetical order...");
                                    System.out.println(Arrays.toString(companyNameArray));
                                    break;
                                case 2:
                                    //CASE_INSENSETIVE_ORDER is a static field of String class of type Comparator. it contains the compare() method
                                    Arrays.sort(companyNameArray, Collections.reverseOrder(String.CASE_INSENSITIVE_ORDER));
                                    System.out.println();
                                    System.out.println("Company names in reverse alphabetical order...");
                                    System.out.println(Arrays.toString(companyNameArray));
                                    break;
                                default:
                                    break;
                            }
                        } else
                            System.out.println("\nChoose anyone from given two options please");

                    } while ((sortType < 1) || (sortType > 2));//correct condition, result is perfect

                } else {
                    k = 2;
                    System.out.println("Enter a valid number more then 1 please");
                }
            } catch (Exception e) {
                System.out.println("\nPlease enter whole number only");
                System.out.println("Re-run the program please");
            }

        } while (k > 1);
    }

    public static void main(String[] args) {
        inputNSortCompanyName();
    }
}

