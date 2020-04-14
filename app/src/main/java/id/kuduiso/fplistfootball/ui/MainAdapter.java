package id.kuduiso.fplistfootball.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import id.kuduiso.fplistfootball.R;
import id.kuduiso.fplistfootball.model.TeamsItem;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {
    private final Context context;
    private final List<TeamsItem> dataTeamList;
    private Bundle bundle;

    public MainAdapter(Context context, List<TeamsItem> dataTeamList){
        this.context = context;
        this.dataTeamList = dataTeamList;
    }

    @NonNull
    @Override
    public MainAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_teams, parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MainAdapter.ViewHolder holder, int position) {
        final TeamsItem teamData = dataTeamList.get(position);
        holder.txtNameTeam.setText(teamData.getStrTeam());
        Glide.with(context).load(teamData.getStrTeamBadge()).into(holder.imgLogoTeam);

        holder.itemView.setOnClickListener(v -> {
            bundle = new Bundle();
            bundle.putInt("idTeam", dataTeamList.get(position).getIdTeam());
            bundle.putString("nameTeam", dataTeamList.get(position).getStrTeam());
            bundle.putString("nameStadium", dataTeamList.get(position).getStrStadium());
            bundle.putString("logoTeam", dataTeamList.get(position).getStrTeamBadge());
            context.startActivity(new Intent(context, DetailActivity.class).putExtras(bundle));
        });
    }

    @Override
    public int getItemCount() {
        return dataTeamList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtNameTeam;
        ImageView imgLogoTeam;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNameTeam = itemView.findViewById(R.id.text_name_team);
            imgLogoTeam = itemView.findViewById(R.id.img_team);
        }
    }
}
