// Паттерн Prototype позволяет создавать новые объекты путем копирования существующих объектов (прототипов).
package prototype_design_pattern;

import java.util.ArrayList;
import java.util.List;

// Класс, представляющий транспортные средства
class Vehicle implements Cloneable
{
  private List<String> vehicleList;

  // Конструктор без аргументов
  public Vehicle()
  {
    this.vehicleList = new ArrayList<String>();
  }

  // Конструктор с передачей списка
  public Vehicle(List<String> list)
  {
    this.vehicleList = list;
  }

  // Метод для заполнения списка транспортными средствами
  public void insertData()
  {
    vehicleList.add("Honda amaze");
    vehicleList.add("Audi A4");
    vehicleList.add("Hyundai Creta");
    vehicleList.add("Maruti Baleno");
    vehicleList.add("Renault Duster");
  }

  // Метод для получения списка транспортных средств
  public List<String> getVehicleList()
  {
    return this.vehicleList;
  }

  // Метод клонирования объекта
  @Override
  public Object clone() throws CloneNotSupportedException
  {
    List<String> tempList = new ArrayList<String>();

    for(String s : this.getVehicleList())
    {
      tempList.add(s);
    }

    return new Vehicle(tempList);
  }
}

public class PrototypePattern
{
  public static void main(String[] args) throws CloneNotSupportedException
  {
    // Создание объекта a и заполнение данными
    Vehicle a = new Vehicle();
    a.insertData();

    // Клонирование объекта a в объект b
    Vehicle b = (Vehicle) a.clone();
    List<String> list = b.getVehicleList();

    // Добавление нового транспортного средства к списку в объекте b
    list.add("Honda new Amaze");

    // Вывод списка из объектов a и b
    System.out.println(a.getVehicleList());
    System.out.println(list);

    // Удаление элемента "Audi A4" из списка в объекте b
    b.getVehicleList().remove("Audi A4");

    // Вывод списков из объектов a и b после изменения
    System.out.println(list);
    System.out.println(a.getVehicleList());
  }
}
