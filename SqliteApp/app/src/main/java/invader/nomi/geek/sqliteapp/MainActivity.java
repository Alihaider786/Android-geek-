package invader.nomi.geek.sqliteapp;

import android.content.Context;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements  InsertInterface,FetchDataBaseInterface, UpdateInterface{

    DataBaseHelper dbHelper;
    Cursor dataCursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // call DataBaseInsertTask for inserting data into SQLite database because inserting into database through background thread is safe because it is time taking process.
        DataBaseInsertTask insertTask = new DataBaseInsertTask(MainActivity.this);
        insertTask.execute();



        // call FetchDataBaseTask for fetching data from SQLite database because fetching same as inserting into database through background thread is safe because it is time taking process.
        FetchDataBaseTask fetchTask = new FetchDataBaseTask(MainActivity.this);
        fetchTask.execute();

        updateTask updateTask = new updateTask(MainActivity.this);
        updateTask.execute();

        }




    // method of insertInterface to get the result of insertion in database
    @Override
    public void getResponse(boolean result) {
        if(result){

            Toast.makeText(MainActivity.this, "Inserted", Toast.LENGTH_SHORT).show();
        }
    }

    // method of fetchingInterface to get the result of fetching from database
    @Override
    public void getFetchingResponse(Cursor cursor,boolean success) {
        dataCursor = cursor;
        if(cursor.getCount()>0){
            Toast.makeText(MainActivity.this, cursor.getCount() +" total rows were inserted", Toast.LENGTH_SHORT).show();
        } else{
            Toast.makeText(MainActivity.this, "No Row inserted Yet", Toast.LENGTH_SHORT).show();

        }
    }

    @Override
    public void onUpdateResponce(long responce) {
        Toast.makeText(this, String.valueOf(responce), Toast.LENGTH_SHORT).show();
    }


    public class DataBaseInsertTask extends AsyncTask<Void,Void,Boolean>{

        InsertInterface callBack;

        public DataBaseInsertTask(Context context){
            dbHelper = new DataBaseHelper(context);
            callBack = (InsertInterface) context;
        }

        @Override
        protected Boolean doInBackground(Void... voids) {
            boolean result = dbHelper.insertUsers("Saad","saad@gmail.com","Male");
            return result;
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            callBack.getResponse(aBoolean);
            super.onPostExecute(aBoolean);
        }
    }

    public class FetchDataBaseTask extends AsyncTask<Void,Void,Cursor>{
        FetchDataBaseInterface callBack;

        public FetchDataBaseTask(Context context){
            dbHelper = new DataBaseHelper(context);
            callBack = (FetchDataBaseInterface) context;
        }

        @Override
        protected Cursor doInBackground(Void... voids) {
            Cursor cursor = dbHelper.getAllUsers();
            return cursor;
        }

        @Override
        protected void onPostExecute(Cursor cursor) {
            callBack.getFetchingResponse(cursor,true);
            super.onPostExecute(cursor);
        }
    }

    public  class updateTask extends AsyncTask<Void, Void, Long>
    {       UpdateInterface updateInterface;



        public  updateTask(Context context)
{
    dbHelper = new DataBaseHelper(context);
    updateInterface = (UpdateInterface)context;
}

        @Override
        protected Long doInBackground(Void... params) {
            long rowId = dbHelper.updateRow("Ali", "new email", "male");
            return rowId;
        }

        @Override
        protected void onPostExecute(Long aLong) {
           updateInterface.onUpdateResponce(aLong);
            super.onPostExecute(aLong);
        }
    }

}
