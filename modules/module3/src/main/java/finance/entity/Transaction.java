package finance.entity;

import javax.persistence.*;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private Account account;

    @Column(name = "date_trns", nullable = false)
    private Instant dateTrans;

    @Column(name = "amount", nullable = false)
    private Integer amount;

    @ManyToMany(mappedBy = "transactions")
    private final Set<BudgetCategory> budCats;

    public Transaction() {

        this.budCats = new HashSet<>();
    }

    public Transaction(Account account, Instant dateTrans) {
        this.account = account;
        this.budCats = new HashSet<>();
        this.dateTrans = dateTrans;
    }

    public Transaction(Account account, Instant dateTrans, Integer amount) {
        this.account = account;
        this.budCats = new HashSet<>();
        this.dateTrans = dateTrans;
        this.amount = amount;
    }

    public Transaction(Account account, Instant dateTrans, Integer amount, Set<BudgetCategory> budCats) {
        this.account = account;
        this.dateTrans = dateTrans;
        this.amount = amount;
        this.budCats = budCats;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Instant getDateTrans() {
        return dateTrans;
    }

    public void setDateTrans(Instant dateTrans) {
        this.dateTrans = dateTrans;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Set<BudgetCategory> getBudgetCategory() {
        return budCats;
    }

    public void addBudgetCategory(BudgetCategory budgetCategory){
        this.budCats.add(budgetCategory);
    }
}
