package ali.android.geek.jsonobject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
/*<Summary>
          * JSONObject is a object from class of JSON which give you a JSON encoded data. We can
          * use json data in different application. The most famous use of json is when are sending
          * a request to sender with data.
          * We can also use JSON Object for decoding and parsing the json response which we receive from server.

</Summary>*/
public class MainActivity extends AppCompatActivity {
TextView tv;
    JSONObject myFirstObject;
     String studentName;
   TextView parse;
   int class_int;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv= (TextView)findViewById(R.id.textView);
        parse = (TextView)findViewById(R.id.parse);
        //Creating a json object from exact vlaues
        JSONObject student_1 = new JSONObject();
        try {

            student_1.put("Name", "Ali Haider");
            student_1.put("Roll","385-BSCS-13");
            student_1.put("Class",10);
            student_1.put("Department", "Computer Scince");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //The second way is create a hashmap first.
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("Name", "Nouman Jamil");
        map.put("Roll","365-BSCS-13");
        map.put("Class", "BSCS");

        map.put("Department", "Computer Scince");
        //then create a json object through this hashmap
        JSONObject jsonMapObject = new JSONObject(map);
        //You can create an array of different object.
        JSONArray myArray = new JSONArray();
        myArray.put(student_1);
        myArray.put(jsonMapObject);
        tv.setText(myArray.toString());
//Now we will parse the created JSON array and Json Object as well
        //So now we have a JSON Array
        //So get JSON Object from this Array
        try {
         myFirstObject = myArray.getJSONObject(0);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //Now we have out first object of json name as *myFirstObject*
        //Try to parse this object
        //Extract the valyue from this JSON Object
        try {
             studentName = myFirstObject.getString("Name");
            class_int = myFirstObject.getInt("Class");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        parse.setText(String.valueOf(class_int));
        //You can Extract other type of data from a json object just in a simple way.
    }
}