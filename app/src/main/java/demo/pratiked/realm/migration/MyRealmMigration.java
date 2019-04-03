package demo.pratiked.realm.migration;

import android.util.Log;

import io.realm.DynamicRealm;
import io.realm.RealmMigration;
import io.realm.RealmObjectSchema;
import io.realm.RealmSchema;

public class MyRealmMigration implements RealmMigration {

    private static final String TAG = "MyRealmMigration";

    @Override
    public void migrate(DynamicRealm realm, long oldVersion, long newVersion) {

        Log.i(TAG, "Migrate: from " + String.valueOf(oldVersion) + " to " + String.valueOf(newVersion));

        RealmSchema realmSchema = realm.getSchema();

        if (oldVersion == 0){

            Log.i(TAG, "migrate: 0 --> 1");

            RealmObjectSchema userSchema = realmSchema.get("User");
            if (userSchema != null) {
                userSchema.addField("lastName", String.class);
            }
            oldVersion++;
        }

        if (oldVersion == 1){

            Log.i(TAG, "migrate: 1 --> 2");

            RealmObjectSchema userSchema = realmSchema.get("User");
            if (userSchema != null) {
                userSchema.addField("city", String.class);
            }

            oldVersion++;
        }

        if (oldVersion == 2){

            Log.i(TAG, "migrate: 2 --> 3");

            RealmObjectSchema userSchema = realmSchema.get("User");
            if (userSchema != null) {
                //int - non-nullable
                //Integer - nullable
                userSchema.addField("gender", int.class);
            }

            oldVersion++;
        }

        if (oldVersion == 3){

            Log.i(TAG, "migrate: 3 --> 4");

            RealmObjectSchema userSchema = realmSchema.get("User");
            if (userSchema != null) {
                userSchema.addField("birthday", String.class);
            }

            oldVersion++;
        }
    }
}
