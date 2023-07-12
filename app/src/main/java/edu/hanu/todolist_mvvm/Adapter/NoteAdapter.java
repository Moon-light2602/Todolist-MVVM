package edu.hanu.todolist_mvvm.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import edu.hanu.todolist_mvvm.Entity.Note;
import edu.hanu.todolist_mvvm.R;
import edu.hanu.todolist_mvvm.onItemClickListener;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteHolder> {
    private List<Note> notes = new ArrayList<>();
    private onItemClickListener listener;

    public NoteAdapter (onItemClickListener listener) {
        this.listener = listener;
    }
    public void setNotes(List<Note> notes) {
        this.notes = notes;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public NoteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_item, parent, false);
        return new NoteHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteHolder holder, int position) {
        Note note = notes.get(position);
        holder.bind(note);
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    public Note getNoteAt(int position) {
        return notes.get(position);
    }

    public class NoteHolder extends RecyclerView.ViewHolder {
        TextView tvTitle, tvDescription, tvPriority;

        public NoteHolder(@NonNull View itemView) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.note_item_title);
            tvDescription = itemView.findViewById(R.id.note_item_description);
            tvPriority = itemView.findViewById(R.id.note_item_priority);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    if(listener != null && position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(getNoteAt(position));
                    }
                }
            });
        }

        private void bind(Note note) {
            tvTitle.setText(note.getTitle());
            tvDescription.setText(note.getDescription());
            tvPriority.setText(String.valueOf(note.getPriority()));
        }
    }
}
