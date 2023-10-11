// Паттерн Proxy предоставляет заместителя для другого объекта для контроля доступа к нему.
package proxy_design_pattern;

// Интерфейс, описывающий операцию выполнения запроса в базе данных
interface DatabaseExecuter
{
	public void executeDatabase(String query) throws Exception;
}

// Реализация интерфейса DatabaseExecuter
class DatabaseExecuterImpl implements DatabaseExecuter
{
	@Override
	public void executeDatabase(String query) throws Exception
	{
		System.out.println("Going to execute Query: " + query);
	}
}

// Прокси-класс, управляющий доступом к базе данных
class DatabaseExecuterProxy implements DatabaseExecuter
{
	boolean ifAdmin;
	DatabaseExecuterImpl dbExecuter;

	public DatabaseExecuterProxy(String name, String passwd)
	{
		// Проверка, является ли пользователь администратором
		if(name.equals("Admin") && passwd.equals("Admin@123"))
		{
			ifAdmin = true;
		}
		dbExecuter = new DatabaseExecuterImpl();
	}

	@Override
	public void executeDatabase(String query) throws Exception
	{
		if(ifAdmin)
		{
			// Если пользователь администратор, прокси передает запрос на выполнение
			dbExecuter.executeDatabase(query);
		}
		else
		{
			// Если пользователь не администратор
			if(query.equals("DELETE"))
			{
				// Генерация исключения при попытке выполнить DELETE
				throw new Exception("DELETE not allowed for non-admin user");
			}
			else
			{
				// В противном случае прокси передает запрос на выполнение
				dbExecuter.executeDatabase(query);
			}
		}
	}
}

public class ProxyPattern
{
	public static void main(String[] args) throws Exception
	{
		// Создание прокси с разными уровнями доступа и запросами
		DatabaseExecuter nonAdminExecuter = new DatabaseExecuterProxy("NonAdmin", "Admin@123");
		nonAdminExecuter.executeDatabase("DELEE"); // Возможно, опечатка, должно быть DELETE

		DatabaseExecuter nonAdminExecuterDELETE = new DatabaseExecuterProxy("NonAdmin", "Admin@123");
		nonAdminExecuterDELETE.executeDatabase("DELETE");

		DatabaseExecuter adminExecuter = new DatabaseExecuterProxy("Admin", "Admin@123");
		adminExecuter.executeDatabase("DELETE");
	}
}
