package com.sickfar.faccad.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 *
 * @author sickfar
 */
public class AnnotationHelper {

    public static Method[] getAnnotatedMethods(Object watcher, Class<? extends Annotation> annotationClass) {
        ArrayList<Method> annotatedMethods = new ArrayList<Method>();
        for (Method method : watcher.getClass().getMethods()) {
            if (method.getAnnotation(annotationClass) != null && method.getReturnType() == Void.TYPE && method.getParameterTypes().length == 0)
                annotatedMethods.add(method);
        }
        return annotatedMethods.toArray(new Method[annotatedMethods.size()]);
    }

}
