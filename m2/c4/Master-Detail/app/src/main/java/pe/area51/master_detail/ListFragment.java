package pe.area51.master_detail;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListFragment extends Fragment {

    private final static String TAG = "ListFragment";
    private final static int TEST_NOTES_SIZE = 100;

    private ListView listView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_list, container, false);
        listView = (ListView) view.findViewById(R.id.listview_list);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        final NoteAdapter noteAdapter = new NoteAdapter(getContext(), generateTestNotes(TEST_NOTES_SIZE));
        listView.setAdapter(noteAdapter);
    }

    private ArrayList<Note> generateTestNotes(final int size) {
        final ArrayList<Note> notes = new ArrayList<>();
        for (int i = 1; i <= size; i++) {
            final Note note = new Note(i, "Title " + i, "Content of the note " + i);
            notes.add(note);
        }
        return notes;
    }

    public static class NoteAdapter extends ArrayAdapter<Note> {

        public NoteAdapter(final Context context, final ArrayList<Note> notes) {
            super(context, 0, notes);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            /*
            Podemos usar un "ViewHolder" para mejorar aún más el rendimiento:
            https://developer.android.com/training/improving-layouts/smooth-scrolling.html
            */
            Log.d(TAG, "getView() position: " + position);
            final View view;
            if (convertView == null) {
                final LayoutInflater layoutInflater = LayoutInflater.from(getContext());
                view = layoutInflater.inflate(R.layout.element_note, parent, false);
            } else {
                view = convertView;
            }
            final TextView textViewTitle = (TextView) view.findViewById(R.id.textview_title);
            final TextView textViewContent = (TextView) view.findViewById(R.id.textview_content);
            final Note note = getItem(position);
            textViewTitle.setText(note.getTitle());
            textViewContent.setText(note.getContent());
            return view;
        }
    }
}
