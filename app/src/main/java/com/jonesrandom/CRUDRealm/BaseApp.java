package com.jonesrandom.CRUDRealm;

import android.app.Application;

import io.realm.DynamicRealm;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmMigration;
import io.realm.RealmSchema;

public class BaseApp extends Application{

    @Override
    public void onCreate() {
        super.onCreate();

        RealmConfiguration configuration = new RealmConfiguration.Builder(this)
                .schemaVersion(0)
                .migration(new DataMigrasi())
                .build();

        Realm.setDefaultConfiguration(configuration);

    }

    private class DataMigrasi implements RealmMigration{

        @Override
        public void migrate(DynamicRealm realm, long oldVersion, long newVersion) {

            RealmSchema schema = realm.getSchema();

            if (oldVersion == 0) {
                schema.create("Daftar")
                        .addField("Id",int.class)
                        .addField("Nama", String.class)
                        .addField("Alamat", String.class);

                oldVersion++;
            }

        }
    }
}
