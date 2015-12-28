package com.sickfar.faccad.documentation.machining;

import com.sickfar.faccad.documentation.AbstractProjectDocumentation;

import static com.sickfar.faccad.documentation.machining.ProcessMachiningTechnologyStep.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author sickfar
 */
public class ProcessMachiningTechnologyDocumentation extends AbstractProjectDocumentation {

    private final String[] steps = {DETAIL, BILLET, OPERATIONS, MACHINING_CALCULATION, EQUIPMENT_SELECTION, ROUTE_MAP, TRANSPORT, LAYOUT, LAYOUT_CALCULATION};

    @Override
    public String[] getSteps() {
        return steps;
    }

    @Override
    public String getDescription() {
        return "Machining process technology";
    }
}
