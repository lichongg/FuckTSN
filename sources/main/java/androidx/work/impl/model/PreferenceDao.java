package androidx.work.impl.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Dao
/* loaded from: D:\Downloads\app\classes.dex */
public interface PreferenceDao {
    @Nullable
    @Query("SELECT long_value FROM Preference where `key`=:key")
    Long getLongValue(@NonNull String key);

    @NonNull
    @Query("SELECT long_value FROM Preference where `key`=:key")
    LiveData<Long> getObservableLongValue(@NonNull String key);

    @Insert(onConflict = 1)
    void insertPreference(@NonNull Preference preference);
}
