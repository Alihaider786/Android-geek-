package invader.nomi.geek.sqliteapp;

import android.database.Cursor;

/**
 * Created by GEO on 2/18/2017.
 */
public interface FetchDataBaseInterface {

    void getFetchingResponse(Cursor cursor,boolean success);
}
