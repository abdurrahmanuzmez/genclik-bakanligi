package tr.gov.gsb.bakanlik.hackathon;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SolManuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sol_manu);

    }

    public void startMainAct(View view){
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }

    public void startCalendar(View view){
        Intent intent = new Intent(getApplicationContext(), LeagueActivity.class);
        startActivity(intent);
    }

    public void startReportAct(View view) {
        Intent intent = new Intent(getApplicationContext(), ReportActivity.class);
        startActivity(intent);}
    public void startEventsActivity(View view) {
        Intent intent = new Intent(getApplicationContext(), FavoritesActivity.class);
        startActivity(intent);
    }public void startGiftActivity(View view) {
        Intent intent = new Intent(getApplicationContext(), HediyeActivity.class);
        startActivity(intent);
    }
}
