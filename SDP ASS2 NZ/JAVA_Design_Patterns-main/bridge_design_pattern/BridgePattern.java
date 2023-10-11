package bridge_design_pattern;

// Паттерн Bridge разделяет абстракцию и реализацию,
// позволяя им изменяться независимо друг от друга. Это позволяет легко расширять и изменять систему.
abstract class TV
{
    Remote remote;
    TV(Remote r)
    {
        this.remote = r;
    }
    abstract void on(); // Метод для включения ТВ
    abstract void off(); // Метод для выключения ТВ
}

// Класс Sony, наследующий абстрактный класс ТВ
class Sony extends TV
{
    Remote remoteType;
    Sony(Remote r)
    {
        super(r);
        this.remoteType = r;
    }

    public void on()
    {
        System.out.print("Sony TV ON: ");
        remoteType.on();
    }

    public void off()
    {
        System.out.print("Sony TV OFF: ");
        remoteType.off();
    }
}

// Класс Philips, наследующий абстрактный класс ТВ
class Philips extends TV
{
    Remote remoteType;
    Philips(Remote r)
    {
        super(r);
        this.remoteType = r;
    }

    public void on()
    {
        System.out.print("Philips TV ON: ");
        remoteType.on();
    }

    public void off()
    {
        System.out.print("Philips TV OFF: ");
        remoteType.off();
    }
}

// Интерфейс для пульта дистанционного управления
interface Remote
{
    public void on(); // Метод для включения
    public void off(); // Метод для выключения
}

// Старый пульт
class OldRemote implements Remote
{
    @Override
    public void on()
    {
        System.out.println("ON with Old Remote");
    }

    @Override
    public void off()
    {
        System.out.println("OFF with old Remote");
    }
}

// Новый пульт
class NewRemote implements Remote
{
    @Override
    public void on()
    {
        System.out.println("ON with New Remote");
    }

    @Override
    public void off()
    {
        System.out.println("OFF with New Remote");
    }
}

// Главный класс с методом main
public class BridgePattern
{
    public static void main(String[] args)
    {
        TV sonyOldRemote = new Sony(new OldRemote());
        sonyOldRemote.on();
        sonyOldRemote.off();
        System.out.println();

        TV sonyNewRemote = new Sony(new NewRemote());
        sonyNewRemote.on();
        sonyNewRemote.off();
        System.out.println();

        TV philipsOldRemote = new Philips(new OldRemote());
        philipsOldRemote.on();
        philipsOldRemote.off();
        System.out.println();

        TV philipsNewRemote = new Philips(new NewRemote());
        philipsNewRemote.on();
        philipsNewRemote.off();
    }
}
