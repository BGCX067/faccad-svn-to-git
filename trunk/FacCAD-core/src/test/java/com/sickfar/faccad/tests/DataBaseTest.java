package com.sickfar.faccad.tests;

import com.sickfar.faccad.core.db.DatabaseManager;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: sickfar
 * Date: 24.03.13
 * Time: 16:39
 * To change this template use File | Settings | File Templates.
 */
public class DataBaseTest {

    @Test
    public void testDataBase() throws SQLException {
        ResultSet resultSet = DatabaseManager.getInstance().getConnection().createStatement().executeQuery("SELECT * from sqlite_master");
        while (resultSet.next()) {
            System.out.println(resultSet.getString("name"));
        }

    }

}
