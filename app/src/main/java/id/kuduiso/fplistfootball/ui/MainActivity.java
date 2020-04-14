package id.kuduiso.fplistfootball.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import id.kuduiso.fplistfootball.R;
import id.kuduiso.fplistfootball.model.TeamsItem;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainContract.View {
    RecyclerView rvTeam;
    SwipeRefreshLayout swipeRefresh;
    private ProgressBar progressBar;
    private final MainPresenter mainPresenter = new MainPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvTeam = findViewById(R.id.recycler_main);
        swipeRefresh = findViewById(R.id.swipe_main);
        progressBar = findViewById(R.id.pb_main);
       mainPresenter.getDataListTeams();

        swipeRefresh.setOnRefreshListener(()->{
            swipeRefresh.setRefreshing(false);
            mainPresenter.getDataListTeams();
        });

    }

    @Override
    public void showProgress() {
        rvTeam.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        rvTeam.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showDataList(List<TeamsItem> teamsItemList) {
        rvTeam.setLayoutManager(new LinearLayoutManager(this));
        rvTeam.setAdapter(new MainAdapter(this, teamsItemList));
    }

    @Override
    public void showFailureMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
