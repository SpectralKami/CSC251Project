public class PolicyHolder 
{
    // ==== Personal Information ====
    private String firstName;
    private String lastName;
    private int age;

    // ==== Medical Information ====
    private boolean isSmoker;
    private double height;
    private double weight;

    public PolicyHolder(String first_name, String last_name, int age, 
        boolean smoker, double height, double weight)
    {
        this.firstName = first_name;
        this.lastName = last_name;
        this.age = age;
        this.isSmoker = smoker;
        this.height = height;
        this.weight = weight;
    }
    public PolicyHolder()
    {
        this.firstName = "";
        this.lastName = "";
        this.age = 0;
        this.isSmoker = false; 
        this.height = 0.0;
        this.weight = 0.0;
    }

    // ==== Setter Methods for all fields ====

    /**
     * Sets the first name of the person
     * @param firstName
     */
    public void setFirstName(String First_Name) { this.firstName = First_Name; }

        /**
     * Sets the last name of the person
     * @param lastName
     */
    public void setLastName(String Last_Name) { this.lastName = Last_Name; }

        /**
     * Sets the age of the person
     * @param age 
     */
    public void setAge(int age) { this.age = age; }

        /**
     * Sets the smoking smoking habbits of the person
     * @param isSmoker 
     */
    public void isSmoker(boolean isSmoker) { this.isSmoker = isSmoker; }

        /**
     * Sets the height of the policy holder
     * @param height
     */
    public void setHeight(double height) { this.height = height; }

        /**
     * Sets the weight of the polciy Holder
     * @param weight
     */
    public void setWeight(double weight) { this.weight = weight; }

    //==== Getter Methods ====

    /**
     * Gets the First name of the policy holder
     * @return firstName
     */
    public String getFirstName() { return firstName; }

    /**
     * gets the last name of the person
     * @return lastName
     */
    public String getLastName() { return lastName; }


    /**
     * gets the age of the person
     * @return age 
     */
    public int getAge() { return age; }

    /**
     * gets the height of the policy holder
     * @return height
     */
    public double getHeight() { return height; }

    /**
     * gets the weight of the polciy Holder
     * @return weight
     */
    public double getWeight() { return weight; }

    // ==== Dependent Classes ====
        /**
     * Gets the policy holders BMI based on input
     *  BMI = (Weight[pound] * 703) / (Height^2[inch])
     * @return PolicyHolderBMI (Body Mass Index)
     */
    public double getBMI() { return (weight * 703) / Math.pow(height, 2.0); }

    /**
     * gets the smoking smoking habbits of the person
     * @return isSmoker 
     */
    public boolean getSmokerStatus() { return isSmoker; }

    /**
     * Get Status  in Stirng form
     * @return toString isSmoker
     */
    public String toStringIsSmoker()
    {
        if(isSmoker) return "smoker";
        return "non-smoker";
    }
    public String toString()
    {
        return String.format("Policyholder's First Name: %s\n\n" 
                    + "PolicyHolder's Last Name: %s\n\n"
                    +"PolicyHolder's Age: %d\n\n"
                    +"Policyholder's Smoking Status (Y/N): %s\n\n"
                    +"Policholder's Height: %.1f inches\n\n"
                    +"Policholder's Weight: %.1f pounds\n\n"
                    +"Policyholder's BMI: %.2f\n\n",
                    firstName,
                    lastName,
                    age,
                    toStringIsSmoker(),
                    height,
                    weight,
                    getBMI());
    }

}
