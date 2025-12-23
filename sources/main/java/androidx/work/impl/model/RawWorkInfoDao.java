package androidx.work.impl.model;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.RawQuery;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.work.impl.model.WorkSpec;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Dao
/* loaded from: D:\Downloads\app\classes.dex */
public interface RawWorkInfoDao {
    @NonNull
    @RawQuery(observedEntities = {WorkSpec.class})
    List<WorkSpec.WorkInfoPojo> getWorkInfoPojos(@NonNull SupportSQLiteQuery query);

    @NonNull
    @RawQuery(observedEntities = {WorkSpec.class})
    LiveData<List<WorkSpec.WorkInfoPojo>> getWorkInfoPojosLiveData(@NonNull SupportSQLiteQuery query);
}
