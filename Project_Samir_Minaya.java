/*
 * Samir Minaya Paulino
 * CSC251-N801 Advanced Java
 * 
 * Demo Class
 * Will ask the user for the insurance policy information and access 
 *  the Policy.java class to create a policy object and store user information
 *  on it
 */
//Scanner class import to read user input
import java.util.Scanner;
public class Project_Samir_Minaya 
{
    public static void main(String[] args)
    {
        //Scanner class
        Scanner scnr = new Scanner(System.in);

        //Creating an instance of the policy class
        Policy policy = new Policy();

        //Asks user for policy number
        System.out.print("\n\nPlease enter the Policy Number: ");
        policy.setPolicyNumber(scnr.nextInt());
        scnr.nextLine();

        //Asks for provider name
        System.out.print("\nPlease enter the Provider Name: ");
        policy.setProviderName(scnr.nextLine());

        //Asks for Policyholders first name
        System.out.print("\nPlease enter the Policyholder’s First Name: ");
        policy.setFirstName(scnr.next());

        //Asks for the Policy Holders last name
        System.out.print("\nPlease enter the Policyholder’s Last Name: ");
        policy.setLastName(scnr.next());

        //Asks for Policy Holders age
        System.out.print("\nPlease enter the Policyholder’s Age: ");
        policy.setAge(scnr.nextInt());
        scnr.nextLine();

        //Asks for Policy Holders smoking status
        System.out.print("\nPlease enter the Policyholder’s" +
            "Smoking Status (smoker/non-smoker): ");
        String smokingStatus = scnr.nextLine();

        //Using boolean values for better management
        if(Character.toLowerCase(smokingStatus.charAt(0)) == 'n') //assuming first letter n means non smoker
        policy.isSmoker(false); 
        
        else
        policy.isSmoker(true);

        //asks user for Policy Holders height
        System.out.print("\nPlease enter the Policyholder’s Height (in inches): ");
        policy.setHeight(scnr.nextDouble());

        //Asks user for Policy Holders weight
        System.out.print("\nPlease enter the Policyholder’s Weight (in pounds): ");
        policy.setWeight(scnr.nextDouble());

        //Calling the method that prints all information
        printPolicyInformation(policy);
    }    

    public static void printPolicyInformation(Policy policy)
    {
        for(int i = 0; i < 60; ++i)
        System.out.print("-");
        System.out.printf("\n%s %d\n\n", "Policy Number: ", policy.getPolicyNumber());

        System.out.printf("%s %s \n\n", "Provider Name: ", policy.getProviderName());

        System.out.printf("%s %s \n\n", "Policyholder’s First Name: ", policy.getFirstName());

        System.out.printf("%s %s \n\n", "Policyholder’s Last Name: ", policy.getLastName());

        System.out.printf("%s %d \n\n", "Policyholder’s Age: ", policy.getAge());

        System.out.printf("%s %s \n\n", "Policyholder’s Smoking Status: ", policy.getSmokerStatus());

        System.out.printf("%s %.1f inches\n\n", "Policyholder’s Height: ", policy.getHeight());

        System.out.printf("%s %.1f pounds\n\n", "Policyholder’s Weight: ", policy.getWeight());

        System.out.printf("%s %.2f \n\n", "Policyholder’s BMI: ", policy.getBMI());

        System.out.printf("%s $%.2f \n\n", "Policy Price: ", policy.getPolicyPrice());
    }
}
