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
import java.util.ArrayList;
import java.io.*;
public class Project_Samir_Minaya 
{
    public static void main(String[] args) throws IOException
    {
        //ArrayList to store all Policy Objects
        ArrayList<Policy> policies = new ArrayList<Policy>();

        //Variable to count smokers and non smokers
        int smokerCount = 0;
        int nonSmokerCount = 0;

        //Open the PolicyyInformation.txt file
        File file = new File("PolicyInformation.txt");
        Scanner inputFile = new Scanner(file);

        //Read the file until there is no more lines
        while(inputFile.hasNextLine())
        {
            //Read policy information in order
            int policyNumber = inputFile.nextInt();
            inputFile.nextLine(); //Consume the remaining newline

            String providerName = inputFile.nextLine();
            String firstName = inputFile.nextLine();
            String lastName = inputFile.nextLine();
            int age = inputFile.nextInt();
            inputFile.nextLine(); //Consume the remaining newline

            String smokingStatus = inputFile.nextLine();
            boolean isSmoker = (Character.toLowerCase(smokingStatus.charAt(0)) == 's');

            double height = inputFile.nextDouble();
            double weight = inputFile.nextDouble();

            //Skip blank line if there is one
            if(inputFile.hasNextLine())
                inputFile.nextLine();

            //Create a new Policy object with the read information
            Policy policy = new Policy(firstName, lastName, age, isSmoker, height, weight, policyNumber, providerName);

            //Add the policy object to the ArrayList
            policies.add(policy);

            //Count smokers and non-smokers
            if(isSmoker)
                smokerCount++;
            else
                nonSmokerCount++;
        }

        //Close the input file
        inputFile.close();

        //Display information for each policy
        for(int i = 0; i < policies.size(); i++)
        {
            System.out.println(policies.get(i)); //Prints the toString method
            System.out.println(); //Indentation
        }

        //Display the counts
        System.out.println("There were " + Policy.getPolicyCount() + "Policy objects created.");
        System.out.println("The number of policies with a smoker is: " + smokerCount);
        System.out.println("The number of policies with a non-smoker is:" + nonSmokerCount);
    }    
}
