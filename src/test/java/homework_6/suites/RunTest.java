package homework_6.suites;

import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;
import org.junit.platform.runner.JUnitPlatform;

@RunWith(JUnitPlatform.class)
@SelectPackages({"homework_6.task_*"})
public class RunTest {
}
