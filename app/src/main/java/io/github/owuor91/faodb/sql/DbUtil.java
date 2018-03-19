package io.github.owuor91.faodb.sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by johnowuor on 19/03/2018.
 */

public class DbUtil extends SQLiteOpenHelper {
  private static final int DATABASE_VERSION = 1;
  private static final String DATABASE_NAME = DbConstants.DB_NAME;

  public DbUtil(Context context) {
    super(context, DbConstants.DB_NAME, null, DATABASE_VERSION);
  }

  @Override public void onCreate(SQLiteDatabase sqLiteDatabase) {
    sqLiteDatabase.execSQL(DbConstants.CREATE_TABLE);
  }

  @Override public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    sqLiteDatabase.execSQL(DbConstants.DROP_TABLE + DbConstants.TABLE_NAME);
    onCreate(sqLiteDatabase);
  }

  public long addFarmer(Farmer farmer) {
    SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

    ContentValues contentValues = new ContentValues();
    contentValues.put(DbConstants.NAME, farmer.getName());
    contentValues.put(DbConstants.AGE, farmer.getAge());
    contentValues.put(DbConstants.ACRES, farmer.getAcres());
    contentValues.put(DbConstants.LOCATION, farmer.getLocation());

    long insert = sqLiteDatabase.insert(DbConstants.TABLE_NAME, null, contentValues);
    sqLiteDatabase.close();
    return insert;
  }

  public List<Farmer> getAllFarmers() {
    List<Farmer> farmerList = new ArrayList<>();

    String query = DbConstants.SELECT_ALL + DbConstants.TABLE_NAME;

    SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
    Cursor cursor = sqLiteDatabase.rawQuery(query, null);

    if (cursor.moveToFirst()) {
      do {
        Farmer farmer = new Farmer();
        farmer.setId(cursor.getInt(cursor.getColumnIndex(DbConstants.ID)));
        farmer.setName(cursor.getString(cursor.getColumnIndex(DbConstants.NAME)));
        farmer.setAge(cursor.getInt(cursor.getColumnIndex(DbConstants.AGE)));
        farmer.setAcres(cursor.getFloat(cursor.getColumnIndex(DbConstants.ACRES)));
        farmer.setLocation(cursor.getString(cursor.getColumnIndex(DbConstants.LOCATION)));

        farmerList.add(farmer);
      } while (cursor.moveToNext());
    }

    sqLiteDatabase.close();
    return farmerList;
  }

  public int updateFarmer(Farmer farmer) {
    SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

    ContentValues contentValues = new ContentValues();
    contentValues.put(DbConstants.NAME, farmer.getName());
    contentValues.put(DbConstants.AGE, farmer.getAge());
    contentValues.put(DbConstants.ACRES, farmer.getAcres());
    contentValues.put(DbConstants.LOCATION, farmer.getLocation());

    return sqLiteDatabase.update(DbConstants.TABLE_NAME, contentValues, DbConstants.FARMER_ID_WHERE_CLAUSE,
        new String[] { String.valueOf(farmer.getId()) });
  }
}
