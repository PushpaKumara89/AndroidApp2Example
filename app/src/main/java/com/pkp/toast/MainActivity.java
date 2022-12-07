package com.pkp.toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.shashank.sony.fancytoastlib.FancyToast;

/*Complex ListView
-Steps 1
* 01) Create string resources
* 02) Create single item row design
* 03) Create a class and extend ArrayAdapter<String>
* 04) Create a constructor and override method

-Steps
* 01) Override getView method
* 02) Inflate the single row design
* 03) Get reference to the item in single row and return the view
* 04) Create ListView in activity and reference to that ListView
* 05) Create object of Adapter
* 06) Set adapter to the listView
*/

public class MainActivity extends AppCompatActivity {
    ListView listView;

    String title[] = {"Elon Mack", "Sahan Pasindu", "John Done", "Alexa Redolf", "Thomas Mishel",
            "John Bosco", "Lary Roy", "Code Camp SL"};

    String description[] = {"071 0014445", "+881 151815", "6884 4545454", "+871 5485118", "+554 7871565",
            "214 7525666", "354 81164848", "458 45256323"};


    int image[] = {
            R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d, R.drawable.e, R.drawable.f,
            R.drawable.g, R.drawable.i };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        CustomAdapter customAdapter = new CustomAdapter(this, title, description, image);

        listView.setAdapter(customAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String name = String.valueOf(adapterView.getItemAtPosition(i));
                FancyToast.makeText(getApplicationContext(), "This is : "+name, FancyToast.LENGTH_LONG,FancyToast.INFO, true).show();
            }
        });
    }
}

class CustomAdapter extends ArrayAdapter<String>{
    Context context;
    int[] images;
    String[] title;
    String[] des;
    public CustomAdapter(Context context, String[] title, String[] des, int[] images) {
        super(context, R.layout.single_row, R.id.title, title);
        this.context = context;
        this.images = images;
        this.title=title;
        this.des = des;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.single_row, parent, false);
        ImageView imageView = row.findViewById(R.id.imageView);
        TextView title = row.findViewById(R.id.title);
        TextView description = row.findViewById(R.id.description);

        imageView.setImageResource(images[position]);
        title.setText(this.title[position]);
        description.setText(des[position]);

        return row;
    }
}