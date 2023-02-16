package org.example.class_and_interface;

public final class Student extends User implements Person {
    private String idenZalKn;
    private String groupNumber;

    public Wallet getWallet() {
        return wallet;
    }

    private Wallet wallet;
    public Student(String idenZalKn, String name, String email, String groupNumber) {
        super(name, email);
        this.idenZalKn = idenZalKn;
        this.groupNumber = groupNumber;
        wallet = new Wallet(1000.0);
    }

    public String getIdenZalKn() {
        return idenZalKn;
    }

    public void setIdenZalKn(String idenZalKn) {
        this.idenZalKn = idenZalKn;
    }

   public String getGroupNumber() {
        return groupNumber;
    }
   public void setGroupNumber(String groupNumber) {
        this.groupNumber = groupNumber;
    }

   public Double howMuchMoneyLeft() {
       return wallet.amount;
   }

    public void drinkCoffee(Double sum) {
        if ((wallet.amount - sum) > 0) {
            wallet.amount = wallet.amount - sum;
        } else {
            throw new IllegalArgumentException("not enough money");
        }
    }

    @Override
    public String greeting() {
        return "Hey dude!";
    }

    private class Wallet {
        private Double amount;

       public Wallet(Double amount) {
           this.amount = amount;
       }
   }
}
