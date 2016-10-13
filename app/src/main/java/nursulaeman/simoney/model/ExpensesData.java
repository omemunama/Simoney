package nursulaeman.simoney.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.types.DateLongType;
import com.j256.ormlite.field.types.DateTimeType;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by nur on 13/10/16.
 */

@DatabaseTable(tableName = "expenses")
public class ExpensesData {

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField
    private String description;

    @DatabaseField
    private long amount;

    @DatabaseField
    private DateLongType date;

    @DatabaseField
    private DateTimeType created_at;

    @DatabaseField
    private DateTimeType update_at;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public DateLongType getDate() {
        return date;
    }

    public void setDate(DateLongType date) {
        this.date = date;
    }

    public DateTimeType getCreated_at() {
        return created_at;
    }

    public void setCreated_at(DateTimeType created_at) {
        this.created_at = created_at;
    }

    public DateTimeType getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(DateTimeType update_at) {
        this.update_at = update_at;
    }
}
