package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author João Bolsson (joaobolsson@animati.com.br)
 * @since 2017, 29 Jun.
 */
public class NodeCC {

    private final String name;

    private final Object content;

    private final List<NodeCC> childs = new ArrayList<>();

    /**
     * Creates a node.
     *
     * @param name Node name.
     */
    public NodeCC(final String name) {
        this.name = name;
        content = null;
    }

    /**
     * Creates a node with content.
     *
     * @param name Node name.
     * @param content Node content.
     */
    public NodeCC(final String name, final Object content) {
        this.name = name;
        this.content = content;
    }

    /**
     * Add a child to this node.
     *
     * @param child Child to add.
     */
    public void add(final NodeCC child) {
        childs.add(child);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.name);
        hash = 97 * hash + Objects.hashCode(this.childs);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof NodeCC)) {
            return false;
        }

        final NodeCC node = (NodeCC) obj;
        return node.childs.equals(this.childs) && node.name.equals(this.name);
    }

    private String buildChilds() {
        StringBuilder builder = new StringBuilder();

        for (NodeCC child : childs) {
            builder.append(child.toString());
        }
        return builder.toString();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("<");
        builder.append(name);
        builder.append(">");

        if (content != null) {
            builder.append(content);
        }

        builder.append(buildChilds());

        builder.append("</");
        builder.append(name);
        builder.append(">");

        return builder.toString();
    }

}
