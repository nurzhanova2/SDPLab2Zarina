package composite_design_pattern;
// Паттерн Composite позволяет сгруппировать множество объектов в древовидную
// структуру для работы с ними как с одним объектом. Этот паттерн используется, когда клиент должен
//  работать с индивидуальными объектами и их композициями в едином интерфейсе.
import java.util.ArrayList;
import java.util.List;

// Абстрактный класс для счета
abstract class Account
{
  public abstract float getBalance();
}

// Конкретный класс для депозитного счета
class DepositeAccount extends Account
{
  private String accountNo;
  private float accountBalance;

  public DepositeAccount(String accountNo, float accountBalance)
  {
    super();
    this.accountNo = accountNo;
    this.accountBalance = accountBalance;
  }

  public float getBalance()
  {
    return accountBalance;
  }
}

// Конкретный класс для сберегательного счета
class SavingAccount extends Account
{
  private String accountNo;
  private float accountBalance;

  public SavingAccount(String accountNo, float accountBalance)
  {
    super();
    this.accountNo = accountNo;
    this.accountBalance = accountBalance;
  }

  public float getBalance()
  {
    return accountBalance;
  }
}

// Композитный класс для сбора нескольких счетов
class CompositeAccount extends Account
{
  private float totalBalance;
  private List<Account> accountList = new ArrayList<Account>();

  public float getBalance()
  {
    totalBalance = 0;
    for (Account f : accountList)
    {
      totalBalance = totalBalance + f.getBalance();
    }
    return totalBalance;
  }

  public void addAccount(Account acc)
  {
    accountList.add(acc);
  }

  public void removeAccount(Account acc)
  {
    accountList.add(acc);
  }
}

public class CompositePattern
{
  public static void main(String[] args)
  {
    CompositeAccount component = new CompositeAccount();

    // Добавление нескольких счетов
    component.addAccount(new DepositeAccount("DA001", 100));
    component.addAccount(new DepositeAccount("DA002", 150));
    component.addAccount(new SavingAccount("SA001", 200));

    // Получение общего баланса
    float totalBalance = component.getBalance();
    System.out.println("Total Balance : " + totalBalance);
  }
}
