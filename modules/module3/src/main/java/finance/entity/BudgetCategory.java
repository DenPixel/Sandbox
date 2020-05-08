package finance.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "budget_categories")
public class BudgetCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "income", nullable = false)
    private Boolean income;

    @ManyToMany
    @JoinTable(name = "budget_cat_transaction",
            joinColumns = @JoinColumn(name = "budget_cat_id"),
            inverseJoinColumns = @JoinColumn(name = "transaction_id")
    )
    private final Set<Transaction> transactions = new HashSet<>();


    public BudgetCategory() {
    }

    public BudgetCategory(String name, Boolean income) {
        this.name = name;
        this.income = income;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getIncome() {
        return income;
    }

    public void setIncome(Boolean income) {
        this.income = income;
    }

    public Set<Transaction> getTransactions() {
        return transactions;
    }

    public void addTransaction(Transaction transaction){
        this.transactions.add(transaction);
    }
}
