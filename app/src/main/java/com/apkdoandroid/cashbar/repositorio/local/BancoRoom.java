package com.apkdoandroid.cashbar.repositorio.local;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.apkdoandroid.cashbar.model.Produto;
import com.apkdoandroid.cashbar.repositorio.local.interfaces.ProdutoDao;


@Database(entities = {Produto.class},version = 1)
public abstract class BancoRoom extends RoomDatabase {
    public static BancoRoom INSTACE;

    public abstract ProdutoDao produtoDao();

    public static BancoRoom getInstance(Context context){
        if(INSTACE == null){
            INSTACE = Room.databaseBuilder(context,BancoRoom.class,"crashBar")
                    .allowMainThreadQueries()
                    .addCallback(new Callback() {
                        @Override
                        public void onCreate(@NonNull SupportSQLiteDatabase db) {
                            super.onCreate(db);
                        }
                    })
                    .addMigrations(MIGRATION_1_2)
                    .build();
        }
        return INSTACE;
    }

    private static Migration MIGRATION_1_2 = new Migration(1,2) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {

        }
    };
}
