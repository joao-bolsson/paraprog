package main;

/**
 * Class that defines a person.
 *
 * @author João Bolsson (joaobolsson@animati.com.br)
 * @since 2017, 06 Jun.
 */
public class Person {

    private String name, phone;

    private final String cpf;

    private int age;

    /**
     * Default construct to create a person.
     *
     * @param name Person name.
     * @param phone Person phone.
     * @param age Person age.
     * @param cpf Person CPF. As id.
     */
    public Person(final String name, final String phone, final int age, final String cpf) {
        this.name = name;
        this.phone = phone;
        this.age = age;
        this.cpf = cpf;
    }

    /**
     * @return Person name.
     */
    public String getName() {
        return name;
    }

    /**
     * Change the person name.
     *
     * @param name Name to change.
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * @return Person phone.
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Change the person phone.
     *
     * @param phone Phone to change.
     */
    public void setPhone(final String phone) {
        this.phone = phone;
    }

    /**
     * @return Person age.
     */
    public int getAge() {
        return age;
    }

    /**
     * Grow old the person.
     */
    public void growOld() {
        age++;
    }

    public String getCPF() {
        return cpf;
    }

}
