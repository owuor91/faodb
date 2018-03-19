package io.github.owuor91.faodb.ui;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import io.github.owuor91.faodb.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FarmersListFragment extends Fragment {
  RecyclerView farmersRecylerView;

  public FarmersListFragment() {
    // Required empty public constructor
  }

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View view =  inflater.inflate(R.layout.fragment_farmers_list, container, false);
    farmersRecylerView = (RecyclerView) view.findViewById(R.id.farmersRecyclerView);
    return view;
  }


}
