package com.sickfar.faccad.core.db;

import com.sickfar.faccad.logging.Log;
import org.sqlite.JDBC;

import java.io.File;
import java.io.IOException;
import java.sql.*;

public class DatabaseManager {
    static {
        try {
            DriverManager.registerDriver(new JDBC());
        } catch (SQLException e) {
            Log.error("Error registering driver", e);
        }
    }

    public static final String CONNECTION_PREFIX = "jdbc:sqlite";
    public static final String DB_NAME = "settings/common.fcd";
    public static final String SETTINGS_TABLE_NAME = "SETTINGS";
    public static final String SETTING_GROUPS_TABLE_NAME = "SETTING_GROUPS";
    public static final String STATE_TABLE_NAME = "STATES";

    private static DatabaseManager instance = null;

    public static DatabaseManager getInstance() throws SQLException {
        if (instance == null) instance = new DatabaseManager();
        return instance;
    }

    {
        File dbFile = new File(DB_NAME);
        if (!dbFile.exists()) {
            try {
                new File("settings").mkdir();
                dbFile.createNewFile();
            } catch (IOException e) {
                Log.error("Error creating database file", e);
            }
        }
    }

    private Connection db;

    private DatabaseManager() throws SQLException {
        db = DriverManager.getConnection(CONNECTION_PREFIX + ":" + DB_NAME);
        Statement st = db.createStatement();
        st.execute("PRAGMA foreign_keys = ON");
        st.close();
        checkAndCreateTables();
    }
    private final String USER = System.getProperty("user.name");

    private final PreparedStatement GET_PROPERTY_BY_GR_ID_ST = db.prepareStatement("SELECT VALUE FROM " + SETTINGS_TABLE_NAME + " WHERE USER = '" + USER + "' AND GROUP_ID = ? AND KEY = ?");

    private void checkAndCreateTables() throws SQLException {
        Statement st = db.createStatement();
        try {
            if (!isTableExists(SETTING_GROUPS_TABLE_NAME)) {
                String sql = "CREATE TABLE " + SETTING_GROUPS_TABLE_NAME + " (" +
                        "GROUP_ID INTEGER PRIMARY KEY NOT NULL, PARENT_GROUP_ID REFERENCES " + SETTING_GROUPS_TABLE_NAME + "(GROUP_ID), NAME TEXT NOT NULL, DESCR TEXT, ICON BLOB" +
                        ")";
                st.execute(sql);
            }
            if (!isTableExists(SETTINGS_TABLE_NAME)) {
                String sql = "CREATE TABLE " + SETTINGS_TABLE_NAME + " (" +
                        "USER TEXT, GROUP_ID INTEGER REFERENCES " + SETTING_GROUPS_TABLE_NAME + "(GROUP_ID), KEY TEXT, VALUE TEXT" +
                        ")";
                st.execute(sql);
            }
            if (!isTableExists(STATE_TABLE_NAME)) {
                String sql = "CREATE TABLE " + STATE_TABLE_NAME + " (" +
                        "CLASS TEXT, FIELD TEXT, VALUE TEXT" +
                        ")";
                st.execute(sql);
            }
        } finally {
            st.close();
        }
    }

    private boolean isTableExists(String table) throws SQLException {
        String sql = "SELECT name FROM sqlite_master WHERE type='table' AND name='" + table + "'";
        Statement st = db.createStatement();
        try {
            return st.executeQuery(sql).next();
        } finally {
            st.close();
        }
    }

    public Connection getConnection() {
        return db;
    }

    public String getSettingByKeyAndGroupID(String key, Integer groupID) throws SQLException, NoSuchValueException {
        GET_PROPERTY_BY_GR_ID_ST.setInt(1, groupID);
        GET_PROPERTY_BY_GR_ID_ST.setString(2, key);
        ResultSet resultSet = GET_PROPERTY_BY_GR_ID_ST.executeQuery();
        if (!resultSet.next()) throw new NoSuchValueException("Result set is empty");
        return resultSet.getString("VALUE");
    }

}
