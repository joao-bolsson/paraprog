package main;

import java.util.Objects;

/**
 *
 * @author João Bolsson (joaobolsson@animati.com.br)
 * @since 2017, 27 Jun.
 */
public class Field {

    /**
     * Modifiers.
     */
    public enum TYPE {
        /**
         * Strings representing modifiers.
         */
        TEXT("text");

        @Override
        public String toString() {
            return keyType;
        }
        private final String keyType;

        TYPE(final String key) {
            keyType = key;
        }

        /**
         * Looks for a modifier with string parameter.
         *
         * @param value string for find.
         * @return MODIFIER with string value
         */
        public static TYPE lookup(final String value) {
            TYPE[] allModifiers = TYPE.values();
            for (TYPE allModifier : allModifiers) {
                if (value.equals(allModifier.toString())) {
                    return allModifier;
                }
            }
            return null;
        }
    }

    private TYPE type;

    private String name, label;

    public TYPE getType() {
        return type;
    }

    /**
     * Sets the input type.
     *
     * @param type Input type to set.
     */
    public void setType(final TYPE type) {
        this.type = type;
    }

    /**
     * @return Input name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the input name.
     *
     * @param name Name to set to this input.
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * @return Input label.
     */
    public String getLabel() {
        return label;
    }

    /**
     * Sets a label to the input.
     *
     * @param label Input label.
     */
    public void setLabel(final String label) {
        this.label = label;
    }

    /**
     * Creates a field object.
     *
     * @param type Input type.
     * @param name Input name.
     * @param label Input label.
     */
    public Field(final TYPE type, final String name, final String label) {
        this.type = type;
        this.name = name;
        this.label = label;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.type);
        hash = 97 * hash + Objects.hashCode(this.name);
        hash = 97 * hash + Objects.hashCode(this.label);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof Field)) {
            return false;
        }

        final Field field = (Field) obj;
        
        return this.name.equals(field.name) && this.label.equals(field.label) && this.type.equals(field.type);
    }

}
