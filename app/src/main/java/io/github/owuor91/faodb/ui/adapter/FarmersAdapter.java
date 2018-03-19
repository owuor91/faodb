package io.github.owuor91.faodb.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import io.github.owuor91.faodb.R;
import io.github.owuor91.faodb.sql.Farmer;
import java.util.List;

/**
 * Created by johnowuor on 19/03/2018.
 */

public class FarmersAdapter extends RecyclerView.Adapter<FarmersAdapter.ViewHolder>{
  private Context context;
  private List<Farmer> farmerList;

  public FarmersAdapter(List<Farmer> farmerList) {
    this.farmerList = farmerList;
  }

  public static class ViewHolder extends RecyclerView.ViewHolder{
    public ViewHolder(View itemView) {
      super(itemView);
    }
  }

  @Override public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.farmers_list_item, parent, false);
    FarmersAdapter.ViewHolder viewHolder = new FarmersAdapter.ViewHolder(view);

    return viewHolder;
  }

  @Override public void onBindViewHolder(ViewHolder holder, int position) {
Farmer farmer = farmerList.get(position);
  }

  @Override public int getItemCount() {
    return 0;
  }
}
