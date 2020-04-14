package id.kuduiso.fplistfootball.ui;

import android.content.Context;
import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import id.kuduiso.fplistfootball.R;

public class DetailActivity extends AppCompatActivity {

    private ImageView imgLogoTeam;
    private TextView txtNameTeam;
    private TextView txtNameStadium;
    private Bundle bundle;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);

        imgLogoTeam = findViewById(R.id.img_team);
        txtNameTeam = findViewById(R.id.text_name_team);
        txtNameStadium = findViewById(R.id.text_name_stadium);
        bundle = getIntent().getExtras();
        detailActivity();
    }

    private void detailActivity() {
        //Mengambil data dari bundle
        int idTeam = bundle.getInt("idTeam");
        String sTeam = bundle.getString("nameTeam");
        String sStadium = bundle.getString("nameStadium");
        String sLogo = bundle.getString("logoTeam");

        //Menampilkan data
        Glide.with(this).load(sLogo).into(imgLogoTeam);
        txtNameTeam.setText(sTeam);
        txtNameStadium.setText(sStadium);
    }

}
