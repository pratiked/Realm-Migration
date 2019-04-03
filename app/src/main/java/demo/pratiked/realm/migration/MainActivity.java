package demo.pratiked.realm.migration;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.Sort;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txtOutput = findViewById(R.id.txt_output);

        RealmResults<User> realmResultsUsers = RealmUtils.getInstance().getRealm().where(User.class).findAll()
                .sort("uid", Sort.ASCENDING);

        StringBuilder names = new StringBuilder();

        for (User user : realmResultsUsers){

            names.append(user.getFirstName()).append("\n");
        }
        txtOutput.setText(names.toString());

        RealmUtils.getInstance().getRealm().executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {

                User user = new User();
                user.setUid(String.valueOf(System.currentTimeMillis()/1000));
                user.setFirstName("Pratik" + System.currentTimeMillis()%1000);

                realm.insertOrUpdate(user);
            }
        });
    }
}
