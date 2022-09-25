package pl.pjwstk.cw13;

public class Account {
    double balance;
    double dailyDebet;
    double credit;
    DebetCard debetCard;
    CreditCard creditCard;

    public Account(double balance, double dailyDebet, double credit, DebetCard debetCard, CreditCard creditCard) {
        this.balance = balance;
        this.dailyDebet = dailyDebet;
        this.credit = credit;
        this.debetCard = debetCard;
        this.creditCard = creditCard;
    }

    public double getBalance() {
        return balance;
    }

    public double getDailyDebet() {
        return dailyDebet;
    }

    public double getCredit() {
        return credit;
    }

    public DebetCard getDebetCard() {
        return debetCard;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    @Override
    public String toString() {
        return "Account{" +
                "balance=" + balance +
                ", dailyDebet=" + dailyDebet +
                ", credit=" + credit +
                ", debetCard=" + debetCard +
                ", creditCard=" + creditCard +
                '}';
    }
}
