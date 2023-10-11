// Паттерн Observer позволяет объектам оповещать других объектов
//об изменениях в своем состоянии. Это способ реализации подписки на события.
// когда один пользователь отправляет сообщение, все подписанные на него пользователи должны получить это сообщение.
package observer_design_pattern;
import java.util.ArrayList;
import java.util.List;

// Интерфейс субъекта
interface Subject
{
    void register(Observer obj);   // Регистрация наблюдателя
    void unregister(Observer obj); // Отмена регистрации наблюдателя
    void notifyObservers();       // Уведомление наблюдателей о изменении
}

// Класс субъекта, который реализует интерфейс Subject
class DeliveryData implements Subject
{
    private List<Observer> observers; // Список наблюдателей
    private String location;         // Местоположение посылки

    // Конструктор
    public DeliveryData()
    {
        this.observers = new ArrayList<>();
    }

    // Регистрация наблюдателя
    @Override
    public void register(Observer obj)
    {
        observers.add(obj);
    }

    // Отмена регистрации наблюдателя
    @Override
    public void unregister(Observer obj)
    {
        observers.remove(obj);
    }

    // Уведомление всех наблюдателей о изменении
    @Override
    public void notifyObservers()
    {
        for(Observer obj : observers)
        {
            obj.update(location);
        }
    }

    // Метод, который изменяет местоположение и уведомляет наблюдателей
    public void locationChanged()
    {
        this.location = getLocation();
        notifyObservers();
    }

    // Метод для получения местоположения (заглушка)
    public String getLocation()
    {
        return "YPlace";
    }
}

// Интерфейс наблюдателя
interface Observer
{
    public void update(String location); // Метод для обновления информации
}

// Конкретный наблюдатель (продавец)
class Seller implements Observer
{
    private String location; // Местоположение

    // Метод для обновления информации
    @Override
    public void update(String location)
    {
        this.location = location;
        showLocation();
    }

    // Вывод текущего местоположения
    public void showLocation()
    {
        System.out.println("Notification at Seller - Current Location: " + location);
    }
}
//
// Конкретный наблюдатель (пользователь)
class   User implements Observer
{
    private String location; // Местоположение

    // Метод для обновления информации
    @Override
    public void update(String location)
    {
        this.location = location;
        showLocation();
    }

    // Вывод текущего местоположения
    public void showLocation()
    {
        System.out.println("Notification at User - Current Location: " + location);
    }
}

// Конкретный наблюдатель (центр по обработке посылок)
class DeliveryWarehouseCenter implements Observer
{
    private String location; // Местоположение

    // Метод для обновления информации
    @Override
    public void update(String location)
    {
        this.location = location;
        showLocation();
    }

    // Вывод текущего местоположения
    public void showLocation()
    {
        System.out.println("Notification at Warehouse - Current Location: " + location);
    }
}

public class ObserverPattern
{
    public static void main(String[] args)
    {
        DeliveryData topic = new DeliveryData();

        Observer obj1 = new Seller();
        Observer obj2 = new User();
        Observer obj3 = new DeliveryWarehouseCenter();

        // Регистрация наблюдателей
        topic.register(obj1);
        topic.register(obj2);
        topic.register(obj3);

        // Изменение местоположения и уведомление наблюдателей
        topic.locationChanged();

        // Отмена регистрации наблюдателя obj3
        topic.unregister(obj3);

        System.out.println();

        // Изменение местоположения и уведомление оставшихся наблюдателей
        topic.locationChanged();
    }
}
