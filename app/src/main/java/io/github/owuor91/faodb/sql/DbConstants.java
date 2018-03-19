package io.github.owuor91.faodb.sql;

/**
 * Created by johnowuor on 19/03/2018.
 */

public class DbConstants {
  public static final String DROP_TABLE = "DROP TABLE IF EXISTS ";
  public static final String DB_NAME = "farmers_db";
  public static final String TABLE_NAME = "farmers";
  public static final String ID = "id";
  public static final String NAME = "name";
  public static final String AGE = "age";
  public static final String ACRES = "acres";
  public static final String LOCATION = "location";

  public static final String CREATE_TABLE = "CREATE TABLE "+ DbConstants.TABLE_NAME + "("
      + DbConstants.ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
      + DbConstants.NAME + " TEXT, "
      + DbConstants.AGE + " INTEGER, "
      + DbConstants.ACRES + " NUMERIC, "
      + DbConstants.LOCATION + " TEXT"
      + ")";
  public static final String SELECT_ALL = "SELECT * FROM ";

  public static final String FARMER_ID_WHERE_CLAUSE = "id = ?";
}
