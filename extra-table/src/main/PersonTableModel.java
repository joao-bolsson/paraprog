package main;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author João Bolsson (joaobolsson@animati.com.br)
 * @since 2017, 06 Jun.
 */
public class PersonTableModel extends AbstractTableModel {

    private final List<Person> lines;

    private final String[] columns = new String[]{"Nome", "Telefone", "Idade"};

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
     * Default construct to build the model (with no lines).
     */
    public PersonTableModel() {
        lines = new ArrayList<>();
    }

    /**
     * Construct to build the model.
     *
     * @param lines Pre defined lines.
     */
    public PersonTableModel(final List<Person> lines) {
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
            default:
                throw new UnsupportedOperationException("Value not found.");
        }
    }

}
