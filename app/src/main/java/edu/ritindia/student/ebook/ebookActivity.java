package edu.ritindia.student.ebook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import edu.ritindia.student.R;

public class ebookActivity extends AppCompatActivity {

    private RecyclerView ebookrecycler;
    private DatabaseReference reference;
    private List<ebookdata> list;
    private ebookAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ebook);

        ebookrecycler = findViewById(R.id.ebookrecycler);
        reference = FirebaseDatabase.getInstance().getReference().child("Study Material").child("7th std").child("B").child("Science");
        getData();
    }

    private void getData() {

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list = new ArrayList<>();

                for(DataSnapshot snapshot1 : snapshot.getChildren())
                {
                    ebookdata data = snapshot1.getValue(ebookdata.class);
                    list.add(data);
                }
                adapter = new ebookAdapter(ebookActivity.this, list);
                ebookrecycler.setLayoutManager(new LinearLayoutManager(ebookActivity.this));
                ebookrecycler.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(ebookActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}