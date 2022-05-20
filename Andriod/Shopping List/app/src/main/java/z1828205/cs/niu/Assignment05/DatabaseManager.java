package z1828205.cs.niu.Assignment05;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import java.util.ArrayList;

public class DatabaseManager extends SQLiteOpenHelper
{
    private static final String DATABASE_NAME = "ItemDB",
                                TABLE_NAME = "ITEMS",
                                ID = "id",
                                ITEM = "item";
    private static  final int DATABASE_VERSION = 1;
    private DatabaseManager manager;

    public DatabaseManager(@Nullable Context context)
    {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    // onCreate create the database
    @Override
    public void onCreate(SQLiteDatabase db) {

        String sqlCreate = "create table " + TABLE_NAME + "( " + ID + " integer primary key autoincrement, " + ITEM + " text )";
        db.execSQL(sqlCreate);
    }

    // Refresh the database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sqlDrop = "drop table if exists " + TABLE_NAME;

        db.execSQL(sqlDrop);

        onCreate(db);
    }

    // Insert items into database
    public void insert(Item item)
    {
        SQLiteDatabase database = getWritableDatabase();


        String sqlInsert = "insert into " + TABLE_NAME + " values( null, '" + item.getItem() + "')";

        database.execSQL(sqlInsert);
        database.close();

    }

    // Delete every item from database
    public void deleteAll()
    {
        SQLiteDatabase database = getWritableDatabase();

        String sqlDelete = "delete from " + TABLE_NAME;
        database.execSQL(sqlDelete);

        database.close();


    }

    // Select all the database items
    public ArrayList<Item> selectAll()
    {
        String sqlQuery = "Select * from " + TABLE_NAME;

        SQLiteDatabase database = getWritableDatabase();
        Cursor cursor = database.rawQuery(sqlQuery,null);

        ArrayList<Item> items = new ArrayList<>();

        while(cursor.moveToNext())
        {
            Item currentItem = new Item(Integer.parseInt(cursor.getString(0)),cursor.getString(1));
            items.add(currentItem);
        }
        database.close();

        return items;

    }

    // Delete items based on ID
    public void deleteByID(int id)
    {
        //String with sql command
        String sqlDelete = "delete from " + TABLE_NAME + " where " + ID + " = " + id;

        //Get the database
        SQLiteDatabase database = getWritableDatabase();

        //delete the item from the database
        database.execSQL(sqlDelete);

        //close the database
        database.close();

    }//end deleteByID

    public void updateByID(int currentID, String newItem)
    {
        // Get the database
        SQLiteDatabase database = getWritableDatabase();

        // String object for the sql command
        String sqlUpdate = " update " + TABLE_NAME + " set " + ITEM + " = '" + newItem + "'" + " where " + ID + " = " + currentID;

        // update the database
        database.execSQL(sqlUpdate);

        // close the database
        database.close();



    }// ends updateByID
    public Cursor getAllData()
    {
        SQLiteDatabase database = getWritableDatabase();
        Cursor res = database.rawQuery("select * from " + TABLE_NAME,null);
        return  res;
    }
}
