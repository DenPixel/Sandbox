package finance.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "amount_of_money")
    private Integer amountOfMoney;

    @OneToMany(mappedBy = "account")
    private final Set<Transaction> transactions = new HashSet<>();

    public Account() {
    }

    public Account(User user) {
        this.user = user;
        user.addAccount(this);
    }

    public Account(User user, Integer amountOfMoney) {
        this.user = user;
        user.addAccount(this);
        this.amountOfMoney = amountOfMoney;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getAmountOfMoney() {
        return amountOfMoney;
    }

    public void setAmountOfMoney(Integer amountOfMoney) {
        this.amountOfMoney = amountOfMoney;
    }

    public void addAmountOfMoney(Integer amountOfMoney) {
        this.amountOfMoney += amountOfMoney;
    }

    public Set<Transaction> getTransactions() {
        return transactions;
    }

    public void addTransaction(Transaction transaction){
        this.transactions.add(transaction);
    }
}
