package homework_5.task_1.suites;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectPackages({"homework_5.task_1.mult","homework_5.task_1.sum"})
public class SumAndMultTestSuite {
}
