package dbm;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DB_SQLite extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "tienda.sqlite";
    private static final int DATABASE_VERSION = 1;
    private static final String SQL_CREATE_ENTRIES = "" +
            "CREATE TABLE PRODUCTO " +
            "( id            INTEGER PRIMARY KEY AUTOINCREMENT" +
            ", nombre        TEXT" +
            ", precio        INTEGER" +
            ", idseccion     INTEGER" +
            ")";
    private static final String SQL_DELETE_ENTRIES = "" +
            "DROP TABLE IF EXISTS PRODUCTO ";

    public DB_SQLite (Context context){
        super(context,DATABASE_NAME, null, DATABASE_VERSION );
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL(SQL_DELETE_ENTRIES);
    onCreate(db);
    }
}
