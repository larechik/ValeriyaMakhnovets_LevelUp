package homework_8.suites;

import homework_7.task_1.Task1Test;
import homework_7.task_2.Task2Test;
import homework_7.task_3.Task3Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectPackages({"homework_8.posts","homework_8.users","homework_8.comments"})
public class Run8Homework {
}
