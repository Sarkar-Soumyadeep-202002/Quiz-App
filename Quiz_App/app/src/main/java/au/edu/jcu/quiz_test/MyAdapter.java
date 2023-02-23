package au.edu.jcu.quiz_test;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private Context context;
    private ArrayList scoreText;

    public MyAdapter(Context context, ArrayList scoreText) {
        this.context = context;
        this.scoreText = scoreText;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.user_entry, parent, false); // Instantiate the layout used for the high scores screen.
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.scoreText.setText(String.valueOf(scoreText.get(position))); // Display the score.

    }

    @Override
    public int getItemCount() {
        return scoreText.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView scoreText;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            scoreText = itemView.findViewById(R.id.set_scoreText); // Locate the score text field.

        }
    }

}
