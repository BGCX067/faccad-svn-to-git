package com.sickfar.faccad.annotation;

import com.sickfar.faccad.documentation.AbstractProjectDocumentation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created with IntelliJ IDEA.
 *
 * @author sickfar
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Module {

    String[] steps();

    Class<? extends AbstractProjectDocumentation>[] documentations();

}
