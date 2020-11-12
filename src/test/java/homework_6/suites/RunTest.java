package homework_6.suites;

import homework_6.base.BaseTest;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;
import org.junit.platform.runner.JUnitPlatform;

@RunWith(JUnitPlatform.class)
@SelectPackages({"homework_6.task_*"})
public class RunTest {
}
