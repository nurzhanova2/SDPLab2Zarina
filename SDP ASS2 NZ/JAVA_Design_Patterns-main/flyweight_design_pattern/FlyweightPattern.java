// Паттерн Flyweight позволяет эффективно разделять общие данные между множеством подобных объектов.
//Вместо хранения одинаковых данных в каждом объекте, используется общий объект для этих данных.
package flyweight_design_pattern;
import java.util.HashMap;
import java.util.Random;

interface Employee
{
  public void assignSkill(String skill); // Назначить навык
  public void task(); // Выполнить задачу
}

// Конкретный класс разработчика
class Developer implements Employee
{
  private final String JOB;
  private String skill;

  public Developer()
  {
    JOB = "Fix the issue"; // Определение задачи
  }

  @Override
  public void assignSkill(String skill)
  {
    this.skill = skill; // Назначение навыка
  }

  @Override
  public void task()
  {
    System.out.println("Developer with skill: " + this.skill + " with Job: " + JOB);
    // Выполнение задачи
  }
}

// Конкретный класс тестировщика
class Tester implements Employee
{
  private final String JOB;
  private String skill;

  public Tester()
  {
    JOB = "Test the issue"; // Определение задачи
  }

  @Override
  public void assignSkill(String skill)
  {
    this.skill = skill; // Назначение навыка
  }

  @Override
  public void task()
  {
    System.out.println("Tester with Skill: " + this.skill + " with Job: " + JOB);
    // Выполнение задачи
  }
}

// Фабрика сотрудников
class EmployeeFactory
{
  private static HashMap<String, Employee> m = new HashMap<String, Employee>();

  // Получение сотрудника по типу
  public static Employee getEmployee(String type)
  {
    Employee p = null;
    if(m.get(type) != null)
    {
      p = m.get(type); // Если сотрудник уже существует, возвращаем его
    }
    else
    {
      switch(type)
      {
        case "Developer":
          System.out.println("Developer Created");
          p = new Developer(); // Создание нового разработчика
          break;
        case "Tester":
          System.out.println("Tester Created");
          p = new Tester(); // Создание нового тестировщика
          break;
        default:
          System.out.println("No Such Employee"); // Ошибка, если такой сотрудник не существует
      }

      m.put(type, p); // Добавляем сотрудника в кэш
    }
    return p;
  }
}

public class FlyweightPattern
{
  private static String employeeType[] = {"Developer", "Tester"}; // Виды сотрудников
  private static String skills[] = {"Java", "C++", ".Net", "Python"}; // Навыки

  public static void main(String[] args)
  {
    for(int i = 0; i < 10; i++)
    {
      Employee e = EmployeeFactory.getEmployee(getRandEmployee());
      e.assignSkill(getRandSkill());
      e.task();
    }
  }

  // Получение случайного типа сотрудника
  public static String getRandEmployee()
  {
    Random r = new Random();
    int randInt = r.nextInt(employeeType.length);
    return employeeType[randInt];
  }

  // Получение случайного навыка
  public static String getRandSkill()
  {
    Random r = new Random();
    int randInt = r.nextInt(skills.length);
    return skills[randInt];
  }
}