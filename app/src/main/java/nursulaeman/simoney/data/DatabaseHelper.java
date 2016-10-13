package nursulaeman.simoney.data;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import nursulaeman.simoney.R;
import nursulaeman.simoney.model.ExpensesData;
import nursulaeman.simoney.model.IncomeData;

/**
 * Created by nur on 13/10/16.
 */
public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

    private static final String DATABASE_NAME = "simoney.db";
    private static final int DATABASE_VERSION = 1;

    private Dao<IncomeData, Integer> IncomeDao;
    private Dao<ExpensesData, Integer> ExpensesDao;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db, ConnectionSource connectionSource) {
        try {
            Log.i(DatabaseHelper.class.getName(), "onCreate");
            TableUtils.createTable(connectionSource, IncomeData.class);
            TableUtils.createTable(connectionSource, ExpensesData.class);
        } catch (SQLException e) {
            Log.e(DatabaseHelper.class.getName(), "Can't create database", e);
            throw new RuntimeException(e);
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            Log.i(DatabaseHelper.class.getName(), "onUpgrade");
            TableUtils.dropTable(connectionSource, IncomeData.class, true);
            TableUtils.dropTable(connectionSource, ExpensesData.class, true);
            onCreate(db, connectionSource);
        } catch (SQLException e) {
            Log.e(DatabaseHelper.class.getName(), "Can't drop databases", e);
            throw new RuntimeException(e);
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
    }

    public Dao<IncomeData, Integer> getIncomeDao() throws SQLException {
        if (IncomeDao == null) {
            try {
                IncomeDao = getDao(IncomeData.class);
            } catch (java.sql.SQLException e) {
                e.printStackTrace();
            }
        }
        return IncomeDao;
    }

    public Dao<ExpensesData, Integer> getExpensesDao() throws SQLException {
        if (ExpensesDao == null) {
            try {
                ExpensesDao = getDao(ExpensesData.class);
            } catch (java.sql.SQLException e) {
                e.printStackTrace();
            }
        }
        return ExpensesDao;
    }

    @Override
    public void close() {
        super.close();
        IncomeDao = null;
        ExpensesDao = null;
    }

}

