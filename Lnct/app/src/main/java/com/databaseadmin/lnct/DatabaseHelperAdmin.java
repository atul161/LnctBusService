package com.databaseadmin.lnct;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelperAdmin extends SQLiteOpenHelper
{

    List busno=new ArrayList();
    List route=new ArrayList();
    public Context context;

    public static final String  DATABASE_NAME="lnct1styear";
    public static final int DATABASE_VERSION=1;
    public static  final String createTable="create table " + TableInfo.TableEntry.TABLE_NAME + " ("
            + TableInfo.TableEntry.BUS_NO +
            " integer primary key ,"+
            TableInfo.TableEntry.ROUTE_DETAILS + " text);";

    //constructor
    public DatabaseHelperAdmin(Context context)
    {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
        this.context=context;
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(createTable);
        Toast.makeText(context, "Table created Succefully", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL(" drop table if exists "+TableInfo.TableEntry.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }



    //insertion
    //Add insertion
    public void addBusDetails(List busno,List routedetails,SQLiteDatabase sqLiteDatabase)
    {

        try {

            for (int i = 0; i < busno.size(); i++) {
                ContentValues contentValues = new ContentValues();
                contentValues.put(TableInfo.TableEntry.BUS_NO, busno.get(i).toString());
                contentValues.put(TableInfo.TableEntry.ROUTE_DETAILS, routedetails.get(i).toString());
                try {
                    sqLiteDatabase.insertOrThrow(TableInfo.TableEntry.TABLE_NAME, null, contentValues);
                    Toast.makeText(context, "Successfully inserted", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(context, "Not Inserted  ", Toast.LENGTH_LONG).show();
                }
            }
        }
        catch(Exception e)
        {
            Toast.makeText(context, "Exception occured", Toast.LENGTH_SHORT).show();
        }

    }



    public Cursor viewBusRouteDetails(SQLiteDatabase sqLiteDatabase)
    {
        String[] projection={TableInfo.TableEntry.BUS_NO, TableInfo.TableEntry.ROUTE_DETAILS};
        Cursor cursor=sqLiteDatabase.query(TableInfo.TableEntry.TABLE_NAME,projection,null,null,null,null,null,null);
        return  cursor;
    }


    public ArrayList<Cursor> getData(String Query){
        //get writable database
        SQLiteDatabase sqlDB = this.getWritableDatabase();
        String[] columns = new String[] { "message" };
        //an array list of cursor to save two cursors one has results from the query
        //other cursor stores error message if any errors are triggered
        ArrayList<Cursor> alc = new ArrayList<Cursor>(2);
        MatrixCursor Cursor2= new MatrixCursor(columns);
        alc.add(null);
        alc.add(null);

        try{
            String maxQuery = Query ;
            //execute the query results will be save in Cursor c
            Cursor c = sqlDB.rawQuery(maxQuery, null);

            //add value to cursor2
            Cursor2.addRow(new Object[] { "Success" });

            alc.set(1,Cursor2);
            if (null != c && c.getCount() > 0) {

                alc.set(0,c);
                c.moveToFirst();

                return alc ;
            }
            return alc;
        } catch(SQLException sqlEx){
            Log.d("printing exception", sqlEx.getMessage());
            //if any exceptions are triggered save the error message to cursor an return the arraylist
            Cursor2.addRow(new Object[] { ""+sqlEx.getMessage() });
            alc.set(1,Cursor2);
            return alc;
        } catch(Exception ex){
            Log.d("printing exception", ex.getMessage());

            //if any exceptions are triggered save the error message to cursor an return the arraylist
            Cursor2.addRow(new Object[] { ""+ex.getMessage() });
            alc.set(1,Cursor2);
            return alc;
        }
    }



}
