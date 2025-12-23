package androidx.work.impl.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.work.Data;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Dao
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: D:\Downloads\app\classes.dex */
public interface WorkProgressDao {
    @Query("DELETE from WorkProgress where work_spec_id=:workSpecId")
    void delete(@NonNull String workSpecId);

    @Query("DELETE FROM WorkProgress")
    void deleteAll();

    @Nullable
    @Query("SELECT progress FROM WorkProgress WHERE work_spec_id=:workSpecId")
    Data getProgressForWorkSpecId(@NonNull String workSpecId);

    @NonNull
    @Query("SELECT progress FROM WorkProgress WHERE work_spec_id IN (:workSpecIds)")
    List<Data> getProgressForWorkSpecIds(@NonNull List<String> workSpecIds);

    @Insert(onConflict = 1)
    void insert(@NonNull WorkProgress progress);
}
