package com.sickfar.faccad.tests;

import com.sickfar.faccad.annotation.Module;
import com.sickfar.faccad.annotation.NoPossibleUpdateMethodsAnnotatedException;
import com.sickfar.faccad.annotation.Update;
import com.sickfar.faccad.core.Core;
import com.sickfar.faccad.core.CoreDelegate;
import com.sickfar.faccad.documentation.AbstractProjectDocumentation;
import com.sickfar.faccad.module.AbstractModule;
import com.sickfar.faccad.module.ModuleException;
import com.sickfar.faccad.project.Project;
import org.junit.Test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author sickfar
 */
public class CoreModuleTest {

    @Test
    public void coreModuleTest() throws Exception {
        Core core = Core.getInstance();
        AbstractModule abstractModuleInstance = core.getModuleInstance(TestModule.class);
        System.out.println(abstractModuleInstance.getModuleID());
        try {
            TestModule.newInstance();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        Map<String, Class<? extends AbstractModule>> mapping = new HashMap<>();
        mapping.put("TEST", TestModule.class);
        mapping.put("TTTT", TestModule.class);
        Project<TestDocumentation> project = new Project(new File("TestFacCAD"));
        project.create(TestDocumentation.class, mapping);
        core.getProjectManager().addProject(project);
    }

    @Module(steps = {"COMMON"}, documentations = {AbstractProjectDocumentation.class})
    public static class TestModule extends AbstractModule {

        public static TestModule newInstance() throws IllegalAccessException {
            return new TestModule();
        }

        public TestModule() throws IllegalAccessException {
            super();
        }

        @Override
        public String getModuleID() {
            test();
            return "Test AbstractModule";  //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public Object request(Map<String, String> request) {
            return "HELLLOOOOOO";
        }

        public void test() {
            new TestWatcher();
        }
    }

    public static class TestWatcher {

        public TestWatcher() {
            try {
                CoreDelegate.getInstance().getModuleInstance(TestModule.class).registerWatcher(this);
            } catch (NoPossibleUpdateMethodsAnnotatedException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            } catch (ModuleException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }

        @Update
        public void testUpdate() {
            System.out.println("Update called");
        }

    }

    private static class TestDocumentation extends AbstractProjectDocumentation {

        @Override
        public String[] getSteps() {
            return new String[]{"TEST"};
        }

        @Override
        public String getDescription() {
            return "Test";
        }
    }

    public static void clear() {
        new File("/home/sickfar/TestFacCAD").delete();
    }

}
