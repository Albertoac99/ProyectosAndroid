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
        String sql = "INSERT INTO PRODUCTO ( nombre,precio,proveedor,fragil,opcion,ciudad,estrellas)" +
                " VALUES ('" + producto.getNombre()+"',"+ Integer.parseInt(producto.getPrecio())+","
                +producto.getEstrellas()+","+ fragilEntrada(producto) +"," +producto.getEnvoltorio()+
                ","+producto.getCiudad()+","+ producto.getProveedor()+")";
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
                String dataNombre = cursor.getString(cursor.getColumnIndex("nombre"));
                int dataPrecio = cursor.getInt(cursor.getColumnIndex("precio"));
                int dataProveedor = cursor.getInt(cursor.getColumnIndex("proveedor"));
                boolean dataFragil = fragilSalida(cursor);
                int dataEnvoltorio = cursor.getInt(cursor.getColumnIndex("envoltorio"));
                int dataCiudad = cursor.getInt(cursor.getColumnIndex("ciudad"));
                float dataEstrellas = cursor.getFloat(cursor.getColumnIndex("estrellas"));

                lista.add(new Producto(dataNombre,""+dataPrecio,dataEstrellas,dataFragil,dataEnvoltorio,dataCiudad,dataProveedor));

            }while(cursor.moveToNext());

        }

        cursor.close();
        conn.close();
        return lista;
    }

    private static boolean fragilSalida(Cursor cursor) {

        if(cursor.getInt(cursor.getColumnIndex("fragil"))==1){
            return true;
        }
        else{
            return false;
        }
    }

    private static int fragilEntrada(Producto producto) {

        if (producto.isFragil()){
            return 1;
        }

        else{
            return 2;
        }

    }
}
