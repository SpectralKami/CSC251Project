/*
 * This is a policy class that will model an insurance policy for one person
 * This will include  
 * Policy
 * 
 * No arg Constructor 
 * arg Constructor
 * 
 * Each field will have both a getter and setter method
 * 
 * Method that calculates and returns the BMI
 *  BMI = (Weight[pound] * 703) / (Height^2[inch])
 * 
 * Base - 600
 * age 50> additional 75 fee
 * isSmoker additional 100 fee
 * BMI 35> additional fee -
 *  - AddFee = (BMI - 35) * 20 {20 per index over 35}
 * 
 * AVOID STALE DATA (BMI)
 */
import java.util.Scanner;
public class Policy
{
    //Creating the Scanner class as a field object 
    Scanner scnr = new Scanner(System.in);

    // ==== Personal Information ====
    private String firstName;
    private String lastName;
    private int age;
    
    // ==== Medical Information ====
    private boolean isSmoker;
    private double height;
    private double weight;

    // === Policy Informaiton====
    private int policyNumber;
    private String providerName;

    /**
     * @param NoArg constructor
     */
    public Policy()
    {
        firstName = "";
        lastName = "";
        age = 0;
        isSmoker = false;
        height = 0.0;
        weight = 0.0;
        policyNumber = 0;
        providerName = "";
    }

    /**
     * ArgConstructor
     * @param firstName
     * @param lastName
     * @param age
     * @param isSmoker
     * @param height
     * @param weight
     * @param policyNumber 
     * @param providerName
     */
    public Policy(String first_name, String last_name, int age, 
        boolean smoker, double height, double weight, 
        int Policy_Number, String Provider_Name)
    {
        firstName = first_name;
        lastName = last_name;
        this.age = age;
        isSmoker = smoker;
        this.height = height;
        this.weight = weight;
        policyNumber = Policy_Number;
        providerName = Provider_Name;
    }

    // ==== Setter Methods for all fields ====

    /**
     * 
     * @param Policy_Numer
     */
    public void setProviderName(String Provider_Name)
    {
        this.providerName = Provider_Name;
    }

    /**
     * Sets the policy number
     * @param policyNumber
     */
    public void setPolicyNumber(int Policy_Numer)
    {
        this.policyNumber = Policy_Numer;
    }

    /**
     * Sets the first name of the person
     * @param firstName
     */
    public void setFirstName(String First_Name)
    {
        this.firstName = First_Name;
    }

    /**
     * Sets the last name of the person
     * @param lastName
     */
    public void setLastName(String Last_Name)
    {
        this.lastName = Last_Name;
    }

    /**
     * Sets the age of the person
     * @param age 
     */
    public void setAge(int age)
    {
        this.age = age;
    }

    /**
     * Sets the smoking smoking habbits of the person
     * @param isSmoker 
     */
    public void isSmoker(boolean isSmoker)
    {
        this.isSmoker = isSmoker;
    }

    /**
     * Sets the height of the policy holder
     * @param height
     */
    public void setHeight(double height)
    {
        this.height = height;
    }

    /**
     * Sets the weight of the polciy Holder
     * @param weight
     */
    public void setWeight(double weight)
    {
        this.weight = weight;
    }


    //==== Getter Methods ====

    /**
     * gets the policy number
     * @return Policy_Number
     */
    public int getPolicyNumber()
    {
        return policyNumber;
    }

    /**
     * gets the Provider Name
     * @return providerName
     */
    public String getProviderName()
    {
        return providerName;
    }

    /**
     * Gets the First name of the policy holder
     * @return firstName
     */
    public String getFirstName()
    {
        return firstName;
    }

    /**
     * gets the last name of the person
     * @return lastName
     */
    public String getLastName()
    {
        return lastName;
    }

    /**
     * gets the age of the person
     * @return age 
     */
    public int getAge()
    {
        return age;
    }

    /**
     * gets the smoking smoking habbits of the person
     * @return isSmoker 
     */
    public String getSmokerStatus()
    {
        if(isSmoker) return "smoker";
        return "non-smoker";
    }

    /**
     * gets the height of the policy holder
     * @return height
     */
    public double getHeight()
    {
        return height;
    }

    /**
     * gets the weight of the polciy Holder
     * @return weight
     */
    public double getWeight()
    {
        return weight;
    }

    // ==== Dependent Classes ====


    /**
     * Gets the policy holders BMI based on input
     *  BMI = (Weight[pound] * 703) / (Height^2[inch])
     * @return PolicyHolderBMI (Body Mass Index)
     */
    public double getBMI()
    {
        return (weight * 703) / Math.pow(height, 2.0);
    }

    /**
     * Gets the policy holders BMI Fee
     *  BMI = (Weight[pound] * 703) / (Height^2[inch])
     * @return PolicyHolderBMI (Body Mass Index)
     */
    public double getBMIFee()
    {
        if(getBMI() > 35) return (getBMI() - 35) * 20; 
        return 0.0;
    }

    /**
     * Returns the total policy price
     */
    public double getPolicyPrice()
    {
        //running toatl
        double total = 0.0;

        //Base Cost
        int Base_Ammount = 600;

        //Static Fee Prices
        double Smoker_Fee = 100.0;
        double Age_Fee = 50.0;

        //Adding base cost 
        total += Base_Ammount;

        //Adding BMI Fees if applicable 
        if(getBMI() > 35) total += getBMIFee(); 

        //Looking for fees
        if(age > 50) total += Age_Fee;

        //Looking if Smoker fees are applicable
        if(isSmoker) total += Smoker_Fee;
        
        
        return total;
    }
}