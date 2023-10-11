package facade_design_pattern;
// Паттерн Facade предоставляет простой интерфейс к сложной системе классов, библиотеке или фреймворку.
import java.sql.Driver;

// Класс для работы с Firefox
class Firefox
{
    public static Driver getFirefoxDriver()
    {
        return null; // Возвращаем null, так как это заглушка для примера
    }

    public static void generateHTMLReport(String test, Driver driver)
    {
        System.out.println("Generating HTML Report for Firefox Driver");
    }

    public static void generateJUnitReport(String test, Driver driver)
    {
        System.out.println("Generating JUNIT Report for Firefox Driver");
    }
}

// Класс для работы с Chrome
class Chrome
{
    public static Driver getChromeDriver()
    {
        return null; // Возвращаем null, так как это заглушка для примера
    }

    public static void generateHTMLReport(String test, Driver driver)
    {
        System.out.println("Generating HTML Report for Chrome Driver");
    }

    public static void generateJUnitReport(String test, Driver driver)
    {
        System.out.println("Generating JUNIT Report for Chrome Driver");
    }
}

// Фасад для упрощения генерации отчетов
class WebExplorerHelperFacade
{
    public static void generateReports(String explorer, String report, String test)
    {
        Driver driver = null;
        switch(explorer)
        {
            case "firefox":
                driver = Firefox.getFirefoxDriver();
                switch(report)
                {
                    case "html":
                        Firefox.generateHTMLReport(test, driver);
                        break;
                    case "junit":
                        Firefox.generateJUnitReport(test, driver);
                        break;
                }
                break;
            case "chrome":
                driver = Chrome.getChromeDriver();
                switch(report)
                {
                    case "html":
                        Chrome.generateHTMLReport(test, driver);
                        break;
                    case "junit":
                        Chrome.generateJUnitReport(test, driver);
                        break;
                }
        }
    }
}

public class FacadePattern
{
    public static void main(String[] args)
    {
        String test = "CheckElementPresent";

        // Генерация отчетов с использованием фасада
        WebExplorerHelperFacade.generateReports("firefox", "html", test);
        WebExplorerHelperFacade.generateReports("firefox", "junit", test);
        WebExplorerHelperFacade.generateReports("chrome", "html", test);
        WebExplorerHelperFacade.generateReports("chrome", "junit", test);
    }
}
