package id.sch.smktelkom_mlg.privateassignment.xirpl229.moview.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.privateassignment.xirpl229.moview.R;
import id.sch.smktelkom_mlg.privateassignment.xirpl229.moview.database.Barang;
import id.sch.smktelkom_mlg.privateassignment.xirpl229.moview.database.DBDataSource;

/**
 * A simple {@link Fragment} subclass.
 */
public class HistoryFragment extends Fragment {
    private ArrayAdapter<Barang> listAdapter;
    private DBDataSource dataSource;

    private ArrayList<Barang> values;
    private Button editButton;
    private Button delButton;

    public HistoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_history, container, false);
        dataSource = new DBDataSource(this.getActivity());
        dataSource.open();
        values = dataSource.getAllBarang();
        ListView listview = (ListView) rootView.findViewById(R.id.iis);

        ArrayAdapter<Barang> adapter = new ArrayAdapter<Barang>(this.getActivity(), android.R.layout.simple_list_item_1, values);
        listview.setAdapter(adapter);
        return rootView;
    }

}
