package SQLite;

import java.util.ArrayList;

import com.example.parser.History;
import com.example.parser.YeuThich;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper {
	// Khai bao
	private static final int DATABASE_VERSION = 1;
	private static final String DATABASE_NAME = "DB_YEUTHICH.sqlite";

	// Ham dung
	public DatabaseHandler(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(createTableThemYeuThich());
	}

	private String createTableThemYeuThich() {
		String sSQL = "CREATE TABLE tblthemGD (ID_LOAI_GD TEXT , LINK TEXT )";
		return sSQL;
	}

	
	public long addThemYeuThich(YeuThich themGD) {
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put("ID_LOAI_GD", themGD.getTitle());
		values.put("LINK", themGD.getLink());
		
		return (db.insert("tblthemGD", null, values));

	}
	
		public void addthemYeuThich(String title,String link) {
			SQLiteDatabase db = this.getWritableDatabase();
			db.beginTransaction();
			try {
				String sSQL = "insert into tblthemGD(title, link) values('"
						+ title + "','" + link + ")";
				db.execSQL(sSQL);
				// insert rows
				db.setTransactionSuccessful();
			} catch (SQLiteException e2) {
				// report problem
			} finally {
				db.endTransaction();
			}
		}
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		// db.execSQL("DROP TABLE IF EXISTS " + TABLE_HOTEL);

		// Create tables again
		onCreate(db);
	}

}
