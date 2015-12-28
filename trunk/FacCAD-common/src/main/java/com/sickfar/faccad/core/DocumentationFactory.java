package com.sickfar.faccad.core;

import com.sickfar.faccad.documentation.AbstractProjectDocumentation;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author sickfar
 */
public class DocumentationFactory {
    private static Map<Class<? extends AbstractProjectDocumentation>, AbstractProjectDocumentation> documentations = new HashMap<>();

    private static DocumentationFactory ourInstance = new DocumentationFactory();

    public static DocumentationFactory getInstance() {
        return ourInstance;
    }

    private DocumentationFactory() {
    }

    public void registerDocumentation(Class<? extends AbstractProjectDocumentation> documentation) throws InstantiationException {
        try {
            documentations.put(documentation, documentation.newInstance());
        } catch (IllegalAccessException e) {
            throw new InstantiationException("IllegalAccessException: " + e.getMessage());
        }
    }

    public <T extends AbstractProjectDocumentation> T getDocumentation(Class<T> documentation) {
        return (T) documentations.get(documentation);
    }
}
