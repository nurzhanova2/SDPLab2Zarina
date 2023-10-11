//Паттерн Singleton обеспечивает, что у класса есть только один экземпляр, и предоставляет глобальную точку доступа к этому экземпляру.
package singleton_design_pattern;

// Одиночка с жадной инициализацией
// экземпляр класса создается немедленно, как только класс загружается в память, даже если он не будет использоваться сразу.
class SingletonEagar
{
  private static SingletonEagar instance = new SingletonEagar();

  private SingletonEagar()
  {

  }

  // Метод для получения единственного экземпляра
  public static SingletonEagar getInstance()
  {
    return instance;
    // instance создается и инициализируется немедленно при загрузке класса
  }
}

// Одиночка с отложенной инициализацией (ленивая инициализация)
//  означает, что экземпляр класса создается только тогда, когда он действительно нужен, а не немедленно при загрузке класса.
class Singleton
{
  private static Singleton instance;

  // Приватный конструктор
  private Singleton()
  {

  }

  // Метод для получения единственного экземпляра
  public static Singleton getInstance()
  {
    if(instance == null)
    {
      instance = new Singleton();
    }
    return instance;
  }
}

// Одиночка с синхронизированным методом (ленивая инициализация)
// Это означает, что если getInstance() вызывается впервые, то instance создается.
// Если getInstance() вызывается повторно, то возвращается ранее созданный instance.
class SingletonSynchronizedMethod
{
  private static SingletonSynchronizedMethod instance;

  // Приватный конструктор
  private SingletonSynchronizedMethod()
  {

  }

  // Метод для получения единственного экземпляра (с синхронизацией)
  public static synchronized SingletonSynchronizedMethod getInstance()
  {
    if(instance == null)
    {
      instance = new SingletonSynchronizedMethod();
    }
    return instance;
  }
}

// Одиночка с двойной проверкой (ленивая инициализация)
class SingletonSynchronized
{
  private static SingletonSynchronized instance;

  // Приватный конструктор
  private SingletonSynchronized()
  {

  }

  // Метод для получения единственного экземпляра (с двойной проверкой)
  public static SingletonSynchronized getInstance()
  {
    if(instance == null)
    {
      synchronized (SingletonSynchronized.class)
      {
        if(instance == null)
        {
          instance = new SingletonSynchronized();
        }
      }
    }
    return instance;
  }
}

public class SingletonPattern
{
  public static void main(String[] args)
  {
    SingletonSynchronized instance = SingletonSynchronized.getInstance();
    System.out.println(instance);
    SingletonSynchronized instance1 = SingletonSynchronized.getInstance();
    System.out.println(instance1);
  }
}
