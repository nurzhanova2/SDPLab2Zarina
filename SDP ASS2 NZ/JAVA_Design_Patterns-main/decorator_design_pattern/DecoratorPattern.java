package decorator_design_pattern;
// Паттерн Decorator позволяет динамически добавлять новую
// функциональность существующим объектам без изменения их структуры.
//Это достигается созданием нового класса-декоратора, который оборачивает оригинальный объект.
interface Dress
{
	public void assemble();
}

// Базовый наряд
class BasicDress implements Dress
{
	@Override
	public void assemble()
	{
		System.out.println("Basic Dress Features");
	}
}

// Декоратор для наряда
class DressDecorator implements Dress
{
	protected Dress dress;
	public DressDecorator(Dress c)
	{
		this.dress = c;
	}

	@Override
	public void assemble()
	{
		this.dress.assemble();
	}
}

// Конкретный наряд: Повседневный стиль
class CasualDress extends DressDecorator
{
	public CasualDress(Dress c)
	{
		super(c);
	}

	@Override
	public void assemble()
	{
		super.assemble();
		System.out.println("Adding Casual Dress Features");
	}
}

// Конкретный наряд: Спортивный стиль
class SportyDress extends DressDecorator
{
	public SportyDress(Dress c)
	{
		super(c);
	}

	@Override
	public void assemble()
	{
		super.assemble();
		System.out.println("Adding Sporty Dress Features");
	}
}

// Конкретный наряд: Праздничный стиль
class FancyDress extends DressDecorator
{
	public FancyDress(Dress c)
	{
		super(c);
	}

	@Override
	public void assemble()
	{
		super.assemble();
		System.out.println("Adding Fancy Dress Features");
	}
}

public class DecoratorPattern
{
	public static void main(String[] args)
	{
		// Создание различных комбинаций нарядов и их ассемблирование
		Dress sportyDress = new SportyDress(new BasicDress());
		sportyDress.assemble();
		System.out.println();

		Dress fancyDress = new FancyDress(new BasicDress());
		fancyDress.assemble();
		System.out.println();

		Dress casualDress = new CasualDress(new BasicDress());
		casualDress.assemble();
		System.out.println();

		Dress sportyFancyDress = new SportyDress(new FancyDress(new BasicDress()));
		sportyFancyDress.assemble();
		System.out.println();

		Dress casualFancyDress = new CasualDress(new FancyDress(new BasicDress()));
		casualFancyDress.assemble();
	}
}