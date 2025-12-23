package androidx.work.impl.model;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.concurrent.Callable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class PreferenceDao_Impl implements PreferenceDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<Preference> __insertionAdapterOfPreference;

    @Override // androidx.work.impl.model.PreferenceDao
    public Long getLongValue(final String key) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT long_value FROM Preference where `key`=?", 1);
        if (key == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, key);
        }
        this.__db.assertNotSuspendingTransaction();
        Long l6 = null;
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            if (query.moveToFirst() && !query.isNull(0)) {
                l6 = Long.valueOf(query.getLong(0));
            }
            return l6;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // androidx.work.impl.model.PreferenceDao
    public LiveData<Long> getObservableLongValue(final String key) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT long_value FROM Preference where `key`=?", 1);
        if (key == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, key);
        }
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"Preference"}, false, (Callable) new Callable<Long>() { // from class: androidx.work.impl.model.PreferenceDao_Impl.2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public Long call() throws Exception {
                Long l6 = null;
                Cursor query = DBUtil.query(PreferenceDao_Impl.this.__db, acquire, false, null);
                try {
                    if (query.moveToFirst() && !query.isNull(0)) {
                        l6 = Long.valueOf(query.getLong(0));
                    }
                    return l6;
                } finally {
                    query.close();
                }
            }

            protected void finalize() {
                acquire.release();
            }
        });
    }

    @Override // androidx.work.impl.model.PreferenceDao
    public void insertPreference(final Preference preference) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfPreference.insert((EntityInsertionAdapter<Preference>) preference);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    public PreferenceDao_Impl(RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfPreference = new EntityInsertionAdapter<Preference>(__db) { // from class: androidx.work.impl.model.PreferenceDao_Impl.1
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement stmt, Preference value) {
                String str = value.mKey;
                if (str == null) {
                    stmt.bindNull(1);
                } else {
                    stmt.bindString(1, str);
                }
                Long l6 = value.mValue;
                if (l6 == null) {
                    stmt.bindNull(2);
                } else {
                    stmt.bindLong(2, l6.longValue());
                }
            }

            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR REPLACE INTO `Preference` (`key`,`long_value`) VALUES (?,?)";
            }
        };
    }
}
