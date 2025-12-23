package androidx.work.impl.model;

import androidx.annotation.NonNull;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Dao
/* loaded from: D:\Downloads\app\classes.dex */
public interface WorkNameDao {
    @NonNull
    @Query("SELECT name FROM workname WHERE work_spec_id=:workSpecId")
    List<String> getNamesForWorkSpecId(@NonNull String workSpecId);

    @Query("SELECT work_spec_id FROM workname WHERE name=:name")
    List<String> getWorkSpecIdsWithName(String name);

    @Insert(onConflict = 5)
    void insert(WorkName workName);
}
