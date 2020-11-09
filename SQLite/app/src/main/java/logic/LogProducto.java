package logic;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import dbm.DB_SQLite;
import model.Producto;

public class LogProducto {


    public static void insertProducto(Context context, Producto producto) {

        DB_SQLite db = new DB_SQLite(context);
        SQLiteDatabase conn = db.getWritableDatabase();
        String sql = "INSERT INTO PRODUCTO (id,nombre, precio, idseccion)" +
                " VALUES (" + producto.getId()+",'"+ producto.getNombre()+"',"+ producto.getPrecio()+","+ producto.getSeccion()+")";
        conn.execSQL(sql);
        conn.close();

    }

    public static List<Producto> ListaProducto(Context context) {

        List<Producto> lista = new ArrayList<>();
        DB_SQLite db = new DB_SQLite(context);
        SQLiteDatabase conn = db.getReadableDatabase();
        String sql = "SELECT * FROM PRODUCTO ORDER BY nombre ASC";

        Cursor cursor = conn.rawQuery(sql, null);
        if(cursor.getCount()>0){

            cursor.moveToFirst();
            do{
                Long dataId = cursor.getLong(cursor.getColumnIndex("id"));
                String dataNombre = cursor.getString(cursor.getColumnIndex("nombre"));
                Double dataPrecio = cursor.getDouble(cursor.getColumnIndex("precio"));
                Long dataIdSeccion = cursor.getLong(cursor.getColumnIndex("idseccion"));

                lista.add(new Producto(dataId,dataNombre,dataPrecio,dataIdSeccion));

            }while(cursor.moveToNext());

        }

        cursor.close();
        conn.close();
        return lista;
    }
}
