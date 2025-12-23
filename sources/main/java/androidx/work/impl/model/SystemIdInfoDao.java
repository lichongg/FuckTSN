package androidx.work.impl.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Dao
/* loaded from: D:\Downloads\app\classes.dex */
public interface SystemIdInfoDao {
    @Nullable
    @Query("SELECT * FROM SystemIdInfo WHERE work_spec_id=:workSpecId")
    SystemIdInfo getSystemIdInfo(@NonNull String workSpecId);

    @NonNull
    @Query("SELECT DISTINCT work_spec_id FROM SystemIdInfo")
    List<String> getWorkSpecIds();

    @Insert(onConflict = 1)
    void insertSystemIdInfo(@NonNull SystemIdInfo systemIdInfo);

    @Query("DELETE FROM SystemIdInfo where work_spec_id=:workSpecId")
    void removeSystemIdInfo(@NonNull String workSpecId);
}
