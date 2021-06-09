package sg.edu.rp.c346.id20039202.demodynamiclistviewcolourlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText etElement, etIndexElement;
    Button btnAdd, btnRemove, btnUpdate;
    ListView lvColour;
    ArrayList<String> alColours;  //declare array
    ArrayAdapter<String> aaColour; //declare arrayAdapter of String

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etElement = findViewById(R.id.editTextColour);
        btnAdd = findViewById(R.id.buttonAddItem);
        lvColour = findViewById(R.id.listViewColour);
        etIndexElement = findViewById(R.id.editTextIndex);
        btnRemove = findViewById(R.id.buttonRemoveItem);
        btnUpdate = findViewById(R.id.buttonUpdateItem);

        alColours = new ArrayList<>(); // create arrayList
        alColours.add("Red");
        alColours.add("Orange");

        aaColour = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                alColours);     //aaColours adapter link to alColours arraylist
        lvColour.setAdapter(aaColour); //set Listview lvcolour to aaColour adapter

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newColour = etElement.getText().toString();
                int pos = Integer.parseInt(etIndexElement.getText().toString());
                alColours.add(pos, newColour);
                aaColour.notifyDataSetChanged();
                etElement.setText("");
            }
        });

        lvColour.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, alColours.get(position), Toast.LENGTH_LONG).show();
                etIndexElement.setText(""+position);
            }
        });

        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String removeColour = etElement.getText().toString();
                int pos = Integer.parseInt(etIndexElement.getText().toString());
                alColours.remove(pos);
                aaColour.notifyDataSetChanged();
                etIndexElement.setText(null);
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String UpdateColour = etElement.getText().toString();
                int pos = Integer.parseInt(etIndexElement.getText().toString());
                alColours.remove(pos);
                aaColour.notifyDataSetChanged();
                etIndexElement.setText(null);
            }
        });

    }
}