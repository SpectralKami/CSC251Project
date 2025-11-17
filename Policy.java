/*
 * This is a policy class that will model an insurance policy for one person
 * This will include  
 * Policy
 *  Number; Policy Name; First & Last Name; Age; Smoking Status; Height; Weight - Class fields
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

    // === Policy Informaiton====
    private int policyNumber;
    private String providerName;
    private PolicyHolder holder;

    // === Static Field Prices ===
    //Base Cost
    static int Base_Ammount = 600;
    static double Smoker_Fee = 100.0;
    static double Age_Fee = 50.0;

    private static int policyCount = 0;

    /**
     * @param NoArg constructor
     */
    public Policy()
    {
        holder = new PolicyHolder();
        policyNumber = 0;
        providerName = "";
        policyCount++;
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
        holder = new PolicyHolder(first_name, last_name, age, smoker, height, weight);
        policyNumber = Policy_Number;
        providerName = Provider_Name;
        policyCount++;
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

    //==== Getter Methods ====

    /**
     * gets the policy number
     * @return Policy_Number
     */
    public int getPolicyNumber() { return policyNumber; }

    /**
     * gets the Provider Name
     * @return providerName
     */
    public String getProviderName() { return providerName; }

    /**
     * Gets a copy of the PolicyHolder object (to prevent security holes)
     * @return policyHolder
     */
    public PolicyHolder getPolicyHolder()
    {
        return new PolicyHolder(holder.getFirstName(), holder.getLastName(), holder.getAge(),
                                holder.getSmokerStatus(), holder.getHeight(), holder.getWeight());
    }


    /**
     * Gets the policy holders BMI Fee
     *  BMI = (Weight[pound] * 703) / (Height^2[inch])
     * @return PolicyHolderBMI (Body Mass Index)
     */
    public double getBMIFee()
    {
        double BMI = holder.getBMI();
        return (BMI > 35) ? ((BMI - 35) * 20) : 0.0; 
    }

    /**
     * Gets the static count of Policy Objects created
     * @return policyCount
     */
    public static int getPolicyCount() { return policyCount; }

    /**
     * Returns the total policy price
     */
    public double getPolicyPrice()
    {
        //running toatl
        double total = 0.0;

        //Adding base cost 
        total += Base_Ammount;

        //Getting user information
        double BMI = holder.getBMI();
        int age = holder.getAge();
        boolean smoker = holder.getSmokerStatus();


        //Adding BMI Fees if applicable 
        //BMI fee - if applicable
        if(BMI > 35) total += getBMIFee(); 

        //Age fee - if applicable
        if(age > 50) total += Age_Fee;

        //Smoker fee - if applicable
        if(smoker) total += Smoker_Fee;
        
        
        return total;
    }

    // === Holder === Update Fields
    public void updateHolderField(String field, String value)
    {
        if(field == null) throw new IllegalArgumentException("Field Required");
        switch(field.toLowerCase())
        {
            case "firstname":
            case "first name":
                holder.setFirstName(value);
                break;
        
            case "lastname":
            case "last name":
                holder.setLastName(value);
                break;
        
        
            case "age":
                try{
                    int age = Integer.parseInt(value);
                    if (age < 0) throw new IllegalArgumentException("age must be >= 0");
                    holder.setAge(age);
                }catch(NumberFormatException e)
                {
                    throw new IllegalArgumentException("Invalid age: " + value, e);
                }
                break;
        
        
            case "height":
                try {
                    double height = Double.parseDouble(value);
                    if (height <= 0) throw new IllegalArgumentException("height must be > 0");
                    holder.setHeight(height);
                } catch (Exception e) {
                    throw new IllegalArgumentException("invalid height" + value, e);
                }
                break;
        
        
            case "weight":
                try {
                    double weight = Double.parseDouble(value);
                    if(weight <= 0) throw new IllegalArgumentException("weight must be >0");
                    holder.setWeight(weight);
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("invalid weight: " + value, e);
                }
                break;
        
        
            case "smoker":
            case "isSmoker":
                String string = value.trim().toLowerCase();
                boolean isSmoker = (string.equals("true") || string.equals("yes") || string.startsWith("s"));
                holder.isSmoker(isSmoker);
                break;
            default:
                throw new IllegalArgumentException("unkown field: " + field);
        }
    }

}