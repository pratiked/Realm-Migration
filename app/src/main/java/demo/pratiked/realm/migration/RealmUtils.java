package demo.pratiked.realm.migration;

import io.realm.Realm;

public class RealmUtils {

    private static RealmUtils instance;
    private final Realm realm;

    public RealmUtils() {
        realm = Realm.getDefaultInstance();
    }

    public static RealmUtils getInstance(){
        if (instance == null) {
            instance = new RealmUtils();
        }
        return instance;
    }


    public Realm getRealm() {
        return realm;
    }
}
