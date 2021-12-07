package edu.ritindia.student.ebook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import edu.ritindia.student.R;

public class ebookAdapter extends RecyclerView.Adapter<ebookAdapter.EbookViewHolder>{

    private Context context;
    private List<ebookdata> list;

    public ebookAdapter(Context context, List<ebookdata> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public EbookViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.activity_ebook_item_layout,parent,false);
        return new EbookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EbookViewHolder holder, int position) {
        //holder.ebookname.setText(list.get(position).getName());

        ebookdata data = list.get(position);
        String name = data.getName();
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,list.get(position).getName(),Toast.LENGTH_SHORT).show();
            }
        });

        holder.ebookdownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, name, Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class EbookViewHolder extends RecyclerView.ViewHolder {

        private TextView ebookname;
        private ImageView ebookdownload;

        public EbookViewHolder(@NonNull View itemView) {
            super(itemView);

            ebookname =itemView.findViewById(R.id.ebookname);
            ebookdownload =itemView.findViewById(R.id.ebookdownload);

        }
    }
}
