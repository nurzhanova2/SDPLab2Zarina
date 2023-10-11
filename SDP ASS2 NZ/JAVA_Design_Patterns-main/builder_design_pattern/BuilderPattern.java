package builder_design_pattern;
// Паттерн Builder позволяет конструировать сложные объекты,
//разделяя процесс пошагового построения от представления конечного объекта.
class Vehicle
{
  private String engine;
  private int wheel;
  private int airbags;

  // Геттеры
  public String getEngine()
  {
    return this.engine;
  }

  public int getWheel()
  {
    return this.wheel;
  }

  public int getAirbags()
  {
    return this.airbags;
  }

  // Приватный конструктор с использованием вложенного класса Builder
  private Vehicle(VehicleBuilder builder)
  {
    this.engine = builder.engine;
    this.wheel = builder.wheel;
    this.airbags = builder.airbags;
  }

  // Вложенный класс Builder
  public static class VehicleBuilder
  {
    private String engine;
    private int wheel;
    private int airbags;

    // Конструктор Builder с обязательными параметрами
    public VehicleBuilder(String engine, int wheel)
    {
      this.engine = engine;
      this.wheel = wheel;
    }

    // Метод для установки необязательного параметра
    public VehicleBuilder setAirbags(int airbags)
    {
      this.airbags = airbags;
      return this;
    }

    // Метод для построения объекта Vehicle
    public Vehicle build()
    {
      return new Vehicle(this);
    }
  }
}

public class BuilderPattern
{
  public static void main(String[] args)
  {
    // Использование Builder для создания объектов Vehicle
    Vehicle car = new Vehicle.VehicleBuilder("1500cc", 4).setAirbags(4).build();
    Vehicle bike = new Vehicle.VehicleBuilder("250cc", 2).build();

    // Вывод информации о созданных транспортных средствах
    System.out.println(car.getEngine());
    System.out.println(car.getWheel());
    System.out.println(car.getAirbags());

    System.out.println(bike.getEngine());
    System.out.println(bike.getWheel());
    System.out.println(bike.getAirbags());
  }
}