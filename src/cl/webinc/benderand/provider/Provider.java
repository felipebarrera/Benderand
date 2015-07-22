
package cl.webinc.benderand.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import cl.webinc.benderand.datos.Database;
import cl.webinc.benderand.util.GetType;
import cl.webinc.benderand.util.Uris;

public class Provider  extends ContentProvider 
{
	private Database mOpenHelper;
	private static final UriMatcher sUriMatcher;
	private static final String TAG = "Provider";
	private static final CursorDB cursorDb = new CursorDB();
	@Override
	public boolean onCreate() 
	{
		mOpenHelper = Database.getinstance(getContext());
		mOpenHelper.getWritableDatabase();
		Log.e(TAG, "ONCREATE.............");
		return true;
	}
	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) 
	{
		Log.e(TAG, "provider cursorDb.cursor");
		Cursor c = cursorDb.cursor(uri, projection, selection, selectionArgs, sortOrder, getContext());
		return c;
	}
	@Override
	public String getType(Uri uri) 
	{
		Log.e(TAG, "GETTYPE.............");
		return GetType.getType(sUriMatcher.match(uri));
	}
	@Override
	public Uri insert(Uri uri, ContentValues initialValues) 
	{
		Log.e(TAG, "INSERT............." + uri);
        InsertDB insertDB = new InsertDB();
        Uri respuestaUri = insertDB.insert(uri, initialValues, getContext());
        return respuestaUri;
	}
	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) 
	{
		Log.e(TAG, "INSERT............." + uri);
		DeleteDB deleteDB = new DeleteDB();
        int respuesta = deleteDB.delete(uri, selection, selectionArgs, getContext());
        return respuesta;
	}
	@Override
	public int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) 
	{
		Log.e(TAG, "INSERT............." + uri);
		UpdateDB updateDB = new UpdateDB();
        int respuesta = updateDB.update(uri, values, selection, selectionArgs, getContext());
        return respuesta;
	}
	
	
	static 
	{
		sUriMatcher = Uris.Creauri();
	}
}