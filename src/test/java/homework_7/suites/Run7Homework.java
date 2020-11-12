package homework_7.suites;

import homework_7.task_1.Task1Test;
import homework_7.task_2.Task2Test;
import homework_7.task_3.Task3Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectClasses({Task1Test.class, Task2Test.class, Task3Test.class})
public class Run7Homework {
}
