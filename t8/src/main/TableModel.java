package main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author João Bolsson (joaobolsson@animati.com.br)
 * @since 2017, 06 Jun.
 */
public class TableModel extends AbstractTableModel {

    private final List<Field> lines;

    private final String[] columns = new String[]{"Label", "Nome", "Tipo", "ID"};

    private static final String MAIN_NODE = "Generator";

    public static final int INDEX_LABEL = 0, INDEX_NAME = 1, INDEX_TYPE = 2, INDEX_ID = 3, INDEX_FIELD = -1;

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
            case INDEX_LABEL:
                return field.getLabel();

            case INDEX_ID:
                return field.getId();

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

    /**
     * Method to export the created project.
     *
     * @param path Path to save the file.
     */
    public void exportProject(final String path) {
        try {
            Writer w = new OutputStreamWriter(new FileOutputStream(path), "UTF-8");
            try (BufferedWriter out = new BufferedWriter(w)) {
                out.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
                out.write("<" + MAIN_NODE + ">");

                for (Field field : lines) {
                    String strNode = "<" + field.getId() + ">";
                    strNode += "<type>" + field.getType().toString() + "</type>";
                    strNode += "<label>" + field.getLabel() + "</label>";
                    strNode += "<name>" + field.getName() + "</name>";

                    strNode += "</" + field.getId() + ">";
                    out.write(strNode);
                }

                out.write("</" + MAIN_NODE + ">");
            }
        } catch (final IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    /**
     * Method to import shortcuts preferences.
     *
     * @param path Path to the file with preferences.
     */
    public void importPreferences(final String path) {
        try {
            File fXmlFile = new File(path);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();
            String nodeName = doc.getDocumentElement().getNodeName();
            if (!nodeName.equals(MAIN_NODE)) {
                return;
            }
            if (doc.getDocumentElement().hasChildNodes()) {
                NodeList childNodes = doc.getDocumentElement().getChildNodes();
                ArrayList<Field> project = new ArrayList<>();
                for (int i = 0; i < childNodes.getLength(); i++) {
                    Node nodeField = childNodes.item(i);
                    String id = nodeField.getNodeName();

                    Field field = new Field(Field.TYPE.TEXT, id, "", id);
                    NodeList attributes = nodeField.getChildNodes();
                    for (int j = 0; j < attributes.getLength(); j++) {
                        Node attr = attributes.item(j);
                        switch (attr.getNodeName()) {
                            case "type":
                                Field.TYPE type = Field.TYPE.lookup(attr.getTextContent());
                                field.setType(type);
                                break;
                            case "label":
                                field.setLabel(attr.getTextContent());
                                break;
                            case "name":
                                field.setName(attr.getTextContent());
                                break;
                            default:
                                break;
                        }
                    }
                    project.add(field);
                }
                if (project.size() > 0) {
                    lines.clear();
                    lines.addAll(project);
                    fireTableDataChanged();
                }
            }
        } catch (ParserConfigurationException | SAXException | IOException | DOMException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

}
