package id.kuduiso.fplistfootball.ui;

import java.util.List;

import id.kuduiso.fplistfootball.model.TeamsItem;

public interface MainContract {
    interface View{
        void showProgress();
        void hideProgress();
        void showDataList(List<TeamsItem> teamsItemList);
        void showFailureMessage(String msg);
    }

    interface Presenter{
        void getDataListTeams();
    }
}
