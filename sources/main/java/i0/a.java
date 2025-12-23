package i0;

import com.bxkj.student.run.app.offline.RunDatabase;
import com.bxkj.student.run.app.offline.dao.RunDao;
import com.bxkj.student.run.app.offline.table.RunDb;
import java.util.List;
import kotlin.coroutines.e;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class a {
    @Nullable
    public final Object a(@NotNull String str, @NotNull e<? super n1> eVar) {
        RunDao runDao = RunDatabase.Companion.getInstance().runDao();
        if (runDao == null) {
            return null;
        }
        Object deleteByIdentify = runDao.deleteByIdentify(str, eVar);
        return deleteByIdentify == kotlin.coroutines.intrinsics.a.l() ? deleteByIdentify : n1.f44123a;
    }

    @Nullable
    public final Object b(@NotNull String str, @NotNull e<? super List<RunDb>> eVar) {
        RunDao runDao = RunDatabase.Companion.getInstance().runDao();
        if (runDao != null) {
            return runDao.getExceptionSports(str, eVar);
        }
        return null;
    }

    @Nullable
    public final Object c(@NotNull String str, @NotNull e<? super List<RunDb>> eVar) {
        RunDao runDao = RunDatabase.Companion.getInstance().runDao();
        if (runDao != null) {
            return runDao.getLocalRecordById(str, eVar);
        }
        return null;
    }

    @Nullable
    public final Object d(@NotNull String str, @NotNull e<? super List<RunDb>> eVar) {
        RunDao runDao = RunDatabase.Companion.getInstance().runDao();
        if (runDao != null) {
            return runDao.getUploadFailSports(str, eVar);
        }
        return null;
    }

    @Nullable
    public final Object e(@NotNull String str, int i6, @NotNull e<? super List<RunDb>> eVar) {
        RunDao runDao = RunDatabase.Companion.getInstance().runDao();
        if (runDao != null) {
            return runDao.getUploadFailSportsByType(str, i6, eVar);
        }
        return null;
    }

    @Nullable
    public final Object f(@NotNull RunDb runDb, @NotNull e<? super n1> eVar) {
        RunDao runDao = RunDatabase.Companion.getInstance().runDao();
        if (runDao == null) {
            return null;
        }
        Object insertRun = runDao.insertRun(new RunDb[]{runDb}, eVar);
        return insertRun == kotlin.coroutines.intrinsics.a.l() ? insertRun : n1.f44123a;
    }

    @Nullable
    public final Object g(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull e<? super n1> eVar) {
        RunDao runDao = RunDatabase.Companion.getInstance().runDao();
        if (runDao == null) {
            return null;
        }
        Object updateSports = runDao.updateSports(str, str2, str3, eVar);
        return updateSports == kotlin.coroutines.intrinsics.a.l() ? updateSports : n1.f44123a;
    }
}
