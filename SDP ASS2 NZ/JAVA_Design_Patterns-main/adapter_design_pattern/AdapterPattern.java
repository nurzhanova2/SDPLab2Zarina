package adapter_design_pattern;
// Интерфейс для веб-драйвера
//Паттерн Adapter позволяет интерфейсу класса работать с другим интерфейсом, который он не поддерживает.
//Он предоставляет прослойку, которая переводит вызовы методов в формат, понятный целевому объекту.
interface WebDriver
{
	public void getElement(); // Метод для получения элемента
	public void selectElement(); // Метод для выбора элемента
}

// Класс для ChromeDriver, реализующий интерфейс WebDriver
class ChromeDriver implements WebDriver
{
	@Override
	public void getElement()
	{
		System.out.println("Get element from ChromeDriver");
	}

	@Override
	public void selectElement()
	{
		System.out.println("Select element from ChromeDriver");
	}
}

// Класс IEDriver, не имплементирующий интерфейс WebDriver
class IEDriver
{
	public void findElement()
	{
		System.out.println("Find element from IEDriver");
	}

	public void clickElement()
	{
		System.out.println("Click element from IEDriver");
	}
}

// Адаптер для IEDriver, реализующий интерфейс WebDriver
class WebDriverAdapter implements WebDriver
{
	IEDriver ieDriver;

	public WebDriverAdapter(IEDriver ieDriver)
	{
		this.ieDriver = ieDriver;
	}

	@Override
	public void getElement()
	{
		ieDriver.findElement();
	}

	@Override
	public void selectElement()
	{
		ieDriver.clickElement();
	}
}

// Главный класс с методом main
public class AdapterPattern
{
	public static void main(String[] args)
	{
		// Использование ChromeDriver
		ChromeDriver chromeDriver = new ChromeDriver();
		chromeDriver.getElement();
		chromeDriver.selectElement();

		// Использование IEDriver
		IEDriver ieDriver = new IEDriver();
		ieDriver.findElement();
		ieDriver.clickElement();

		// Использование адаптера для IEDriver как WebDriver
		WebDriver webDriver = new WebDriverAdapter(ieDriver);
		webDriver.getElement();
		webDriver.selectElement();
	}
}