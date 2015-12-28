package com.sickfar.faccad.documentation.machining;

import com.sickfar.faccad.documentation.AbstractProjectStep;

/**
 * Created with IntelliJ IDEA.
 *
 * @author sickfar
 */
public interface ProcessMachiningTechnologyStep extends AbstractProjectStep {

    public static final Class<ProcessMachiningTechnologyDocumentation> documentationClass = ProcessMachiningTechnologyDocumentation.class;

    public static final String DETAIL = "DETAIL";
    public static final String BILLET = "BILLET";
    public static final String OPERATIONS = "OPERATIONS";
    public static final String MACHINING_CALCULATION = "MACHINING_CALCULATION";
    public static final String EQUIPMENT_SELECTION = "EQUIPMENT_SELECTION";
    public static final String ROUTE_MAP = "ROUTE_MAP";
    public static final String TRANSPORT = "TRANSPORT";
    public static final String LAYOUT = "LAYOUT";
    public static final String LAYOUT_CALCULATION = "LAYOUT_CALCULATION";

}
