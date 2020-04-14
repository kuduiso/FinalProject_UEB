package id.kuduiso.fplistfootball.ui;

import id.kuduiso.fplistfootball.data.remote.ApiClient;
import id.kuduiso.fplistfootball.data.remote.ApiInterface;
import id.kuduiso.fplistfootball.model.ResponseTeams;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter implements MainContract.Presenter {
    private final MainContract.View view;
    private ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);

    public MainPresenter(MainContract.View view){this.view = view;}

    @Override
    public void getDataListTeams() {
        view.showProgress();

        Call<ResponseTeams> call =apiInterface.getAllTeam("Soccer","Indonesia");
        call.enqueue(new Callback<ResponseTeams>() {
            @Override
            public void onResponse(Call<ResponseTeams> call, Response<ResponseTeams> response) {
                view.hideProgress();
                if (response.body() != null){
                    view.showDataList(response.body().getTeams());
                }
            }

            @Override
            public void onFailure(Call<ResponseTeams> call, Throwable t) {
                view.hideProgress();
                view.showFailureMessage(t.getMessage());
            }
        });
    }
}
