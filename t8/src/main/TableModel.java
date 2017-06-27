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

    private final List<Field> lines;
    
    private final String[] columns = new String[]{"Nome", "Tipo"};

    /**
     * Column that the person name will be showed.
     */
    public static final int INDEX_NAME = 0;

    /**
     * Column that the person phone will be showed.
     */
    public static final int INDEX_TYPE = 1;

    /**
     * Index to get the person object in row.
     */
    public static final int INDEX_FIELD = -1;

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
    public TableModel(final List<Field> lines) {
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
        Field field = lines.get(rowIndex);
        switch (columnIndex) {
            case INDEX_NAME:
                return field.getName();

            case INDEX_TYPE:
                return field.getType().toString();

            case INDEX_FIELD:
                return field;
            default:
                throw new UnsupportedOperationException("Value not found.");
        }
    }

    /**
     * Gets the field in model by identifier.
     *
     * @param id Identifier.
     * @return True if the object exists in model, else null.
     */
    public Field getPerson(final String id) {
        Iterator<Field> iterator = lines.iterator();
        while (iterator.hasNext()) {
            Field person = iterator.next();
            if (person.getId().equals(id)) {
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
    public void add(final Field person) {
        lines.add(person);
    }

    /**
     * Verifies if this model contains the person.
     *
     * @param person Person to verify.
     * @return If person is already in model - true, else false.
     */
    public boolean containsPerson(final Field person) {
        return lines.contains(person);
    }

}
