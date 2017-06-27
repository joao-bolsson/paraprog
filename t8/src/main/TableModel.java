package main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author João Bolsson (joaobolsson@animati.com.br)
 * @since 2017, 06 Jun.
 */
public class TableModel extends AbstractTableModel {

    private final List<Person> lines;
    
    private final String[] columns = new String[]{"Nome", "Telefone", "Idade", "CPF"};

    /**
     * Column that the person name will be showed.
     */
    public static final int INDEX_NAME = 0;

    /**
     * Column that the person phone will be showed.
     */
    public static final int INDEX_PHONE = 1;

    /**
     * Column that the person age will be showed.
     */
    public static final int INDEX_AGE = 2;

    /**
     * Column to show the person identifier.
     */
    public static final int INDEX_CPF = 3;

    /**
     * Index to get the person object in row.
     */
    public static final int INDEX_PERSON = -1;

    /**
     * Default construct to build the model (with no lines).
     */
    public TableModel() {
        lines = new ArrayList<>();
    }

    /**
     * Construct to build the model.
     *
     * @param lines Pre defined lines.
     */
    public TableModel(final List<Person> lines) {
        this.lines = lines;
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    @Override
    public int getRowCount() {
        return lines.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Person person = lines.get(rowIndex);
        switch (columnIndex) {
            case INDEX_NAME:
                return person.getName();

            case INDEX_PHONE:
                return person.getPhone();

            case INDEX_AGE:
                return person.getAge();

            case INDEX_PERSON:
                return person;

            case INDEX_CPF:
                return person.getCPF();
            default:
                throw new UnsupportedOperationException("Value not found.");
        }
    }

    /**
     * Gets the person in model by identifier.
     *
     * @param cpf Person identifiers (CPF field).
     * @return The person object if exists in model, else null.
     */
    public Person getPerson(final String cpf) {
        Iterator<Person> iterator = lines.iterator();
        while (iterator.hasNext()) {
            Person person = iterator.next();
            if (person.getCPF().equals(cpf)) {
                return person;
            }
        }
        return null;
    }

    /**
     * Add a person to this model.
     *
     * @param person Person to add.
     */
    public void addPerson(final Person person) {
        lines.add(person);
    }

    /**
     * Verifies if this model contains the person.
     *
     * @param person Person to verify.
     * @return If person is already in model - true, else false.
     */
    public boolean containsPerson(final Person person) {
        return lines.contains(person);
    }

}
