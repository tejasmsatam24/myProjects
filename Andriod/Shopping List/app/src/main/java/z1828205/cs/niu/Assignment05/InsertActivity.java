package z1828205.cs.niu.Assignment05;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class InsertActivity extends Activity {

    private DatabaseManager databaseManager;
    private TextView DatatextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        databaseManager = new DatabaseManager(this);
        DatatextView = findViewById(R.id.DataTV);
        getData();
    }
    public void getData() {
        Cursor res = databaseManager.getAllData();
        if(res.getCount()==0)
        {
            Toast.makeText(this,"no data",Toast.LENGTH_SHORT).show();

        }
        else {
            StringBuffer buffer = new StringBuffer();
            while (res.moveToNext()) {
                StringBuffer sol = buffer.append(res.getString(0) + " " + res.getString(1)+"\n");
                showMessage(sol);
            }
        }
    }
    public  void onAdd(View view)
    {
        EditText listET = findViewById(R.id.ListET);
        String listStr = listET.getText().toString();
        try
        {
            Item item = new Item(0,listStr);

            databaseManager.insert(item);
            Toast.makeText(this,"Item" + listStr +" added to DataBase",Toast.LENGTH_SHORT).show();
             getData();



        }
        catch (NumberFormatException nfe)
        {
            Toast.makeText(this,"some error ocurred",Toast.LENGTH_SHORT).show();


        }
        listET.setText("");
    }

    public void showMessage(StringBuffer sol)
    {

        DatatextView.setText("Item " + "\n" + sol);
    }

    public void onBack(View view)
    {
        finish();
    }

}
