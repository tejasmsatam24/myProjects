package z1828205.cs.niu.Assignment05;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import java.util.ArrayList;

public class DeleteActivity extends AppCompatActivity {

    private DatabaseManager databaseManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        databaseManager = new DatabaseManager(this);
        updateView();
    }
    public void updateView()
    {
        ArrayList<Item> items = databaseManager.selectAll();

        //Create the Layout
        RelativeLayout layout = new RelativeLayout(this);
        ScrollView scrollView = new ScrollView(this);
        RadioGroup radioGroup = new RadioGroup(this);

        for(Item item : items)
        {
            RadioButton radioButton = new RadioButton(this);

            radioButton.setId(item.getId());
            radioButton.setText(item.listToString());

            //add the radioButton to the radioGroup
            radioGroup.addView(radioButton);
        }

        RadioButtonHandler handler = new RadioButtonHandler();
        radioGroup.setOnCheckedChangeListener(handler);

        Button backBtn = new Button(this);
        backBtn.setText("Back");
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        scrollView.addView(radioGroup);
        layout.addView(scrollView);

        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);

        params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        params.addRule(RelativeLayout.CENTER_HORIZONTAL);
        params.setMargins(0,0,0,60);

        layout.addView(backBtn,params);
        layout.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.index));
        setContentView(layout);
    }
    private  class  RadioButtonHandler implements  RadioGroup.OnCheckedChangeListener
    {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            databaseManager.deleteByID(checkedId);
            Toast.makeText(DeleteActivity.this,"Item Deleted",Toast.LENGTH_SHORT).show();
            updateView();
        }
    }
}
