package com.bxkj.student.run.app.offline.dao;

import androidx.room.EntityDeleteOrUpdateAdapter;
import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import com.bxkj.student.run.app.offline.table.RunDb;
import com.umeng.analytics.AnalyticsConfig;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.f0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class RunDao_Impl implements RunDao {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private final RoomDatabase __db;

    @NotNull
    private final EntityDeleteOrUpdateAdapter<RunDb> __deleteAdapterOfRunDb;

    @NotNull
    private final EntityInsertAdapter<RunDb> __insertAdapterOfRunDb;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Companion {
        public /* synthetic */ Companion(v vVar) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final List<kotlin.reflect.d<?>> getRequiredConverters() {
            return f0.J();
        }
    }

    public RunDao_Impl(@NotNull RoomDatabase __db) {
        g0.p(__db, "__db");
        this.__db = __db;
        this.__insertAdapterOfRunDb = new EntityInsertAdapter<RunDb>() { // from class: com.bxkj.student.run.app.offline.dao.RunDao_Impl.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertAdapter
            public void bind(SQLiteStatement statement, RunDb entity) {
                g0.p(statement, "statement");
                g0.p(entity, "entity");
                statement.mo40bindText(1, entity.getIdentify());
                statement.mo40bindText(2, entity.getUserNumber());
                statement.mo40bindText(3, entity.getSportsType());
                statement.mo40bindText(4, entity.getSportsSet());
                statement.mo40bindText(5, entity.getStartTime());
                statement.mo40bindText(6, entity.getEndTime());
                statement.mo40bindText(7, entity.getCountTime());
                statement.mo40bindText(8, entity.getDistance());
                statement.mo40bindText(9, entity.getLatLngList());
                statement.mo40bindText(10, entity.getStepList());
                statement.mo40bindText(11, entity.getPassLatLngList());
                statement.mo40bindText(12, entity.getUserPassPointList());
                statement.mo40bindText(13, entity.isFaceOut());
                statement.mo40bindText(14, entity.getFaceDetectCount());
                statement.mo40bindText(15, entity.getUploadType());
            }

            @Override // androidx.room.EntityInsertAdapter
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `runDb` (`identify`,`userNumber`,`sportsType`,`sportsSet`,`startTime`,`endTime`,`countTime`,`distance`,`latLngList`,`stepList`,`passLatLngList`,`points`,`isFaceOut`,`faceDetectCount`,`uploadType`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }
        };
        this.__deleteAdapterOfRunDb = new EntityDeleteOrUpdateAdapter<RunDb>() { // from class: com.bxkj.student.run.app.offline.dao.RunDao_Impl.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            public void bind(SQLiteStatement statement, RunDb entity) {
                g0.p(statement, "statement");
                g0.p(entity, "entity");
                statement.mo40bindText(1, entity.getIdentify());
            }

            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String createQuery() {
                return "DELETE FROM `runDb` WHERE `identify` = ?";
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 deleteByIdentify$lambda$6(String str, String str2, SQLiteConnection _connection) {
        g0.p(_connection, "_connection");
        SQLiteStatement prepare = _connection.prepare(str);
        try {
            prepare.mo40bindText(1, str2);
            prepare.step();
            prepare.close();
            return n1.f44123a;
        } catch (Throwable th) {
            prepare.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 deleteSports$lambda$1(RunDao_Impl runDao_Impl, RunDb runDb, SQLiteConnection _connection) {
        g0.p(_connection, "_connection");
        runDao_Impl.__deleteAdapterOfRunDb.handle(_connection, runDb);
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List getExceptionSports$lambda$3(String str, String str2, SQLiteConnection _connection) {
        g0.p(_connection, "_connection");
        SQLiteStatement prepare = _connection.prepare(str);
        try {
            prepare.mo40bindText(1, str2);
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "identify");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "userNumber");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "sportsType");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "sportsSet");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, AnalyticsConfig.RTD_START_TIME);
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "endTime");
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "countTime");
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "distance");
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "latLngList");
            int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "stepList");
            int columnIndexOrThrow11 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "passLatLngList");
            int columnIndexOrThrow12 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "points");
            int columnIndexOrThrow13 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "isFaceOut");
            int columnIndexOrThrow14 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "faceDetectCount");
            int columnIndexOrThrow15 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "uploadType");
            ArrayList arrayList = new ArrayList();
            while (prepare.step()) {
                int i6 = columnIndexOrThrow;
                int i7 = columnIndexOrThrow15;
                columnIndexOrThrow15 = i7;
                arrayList.add(new RunDb(prepare.getText(columnIndexOrThrow), prepare.getText(columnIndexOrThrow2), prepare.getText(columnIndexOrThrow3), prepare.getText(columnIndexOrThrow4), prepare.getText(columnIndexOrThrow5), prepare.getText(columnIndexOrThrow6), prepare.getText(columnIndexOrThrow7), prepare.getText(columnIndexOrThrow8), prepare.getText(columnIndexOrThrow9), prepare.getText(columnIndexOrThrow10), prepare.getText(columnIndexOrThrow11), prepare.getText(columnIndexOrThrow12), prepare.getText(columnIndexOrThrow13), prepare.getText(columnIndexOrThrow14), prepare.getText(i7)));
                columnIndexOrThrow = i6;
            }
            return arrayList;
        } finally {
            prepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List getLocalRecordById$lambda$2(String str, String str2, SQLiteConnection _connection) {
        g0.p(_connection, "_connection");
        SQLiteStatement prepare = _connection.prepare(str);
        try {
            prepare.mo40bindText(1, str2);
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "identify");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "userNumber");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "sportsType");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "sportsSet");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, AnalyticsConfig.RTD_START_TIME);
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "endTime");
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "countTime");
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "distance");
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "latLngList");
            int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "stepList");
            int columnIndexOrThrow11 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "passLatLngList");
            int columnIndexOrThrow12 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "points");
            int columnIndexOrThrow13 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "isFaceOut");
            int columnIndexOrThrow14 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "faceDetectCount");
            int columnIndexOrThrow15 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "uploadType");
            ArrayList arrayList = new ArrayList();
            while (prepare.step()) {
                int i6 = columnIndexOrThrow;
                int i7 = columnIndexOrThrow15;
                columnIndexOrThrow15 = i7;
                arrayList.add(new RunDb(prepare.getText(columnIndexOrThrow), prepare.getText(columnIndexOrThrow2), prepare.getText(columnIndexOrThrow3), prepare.getText(columnIndexOrThrow4), prepare.getText(columnIndexOrThrow5), prepare.getText(columnIndexOrThrow6), prepare.getText(columnIndexOrThrow7), prepare.getText(columnIndexOrThrow8), prepare.getText(columnIndexOrThrow9), prepare.getText(columnIndexOrThrow10), prepare.getText(columnIndexOrThrow11), prepare.getText(columnIndexOrThrow12), prepare.getText(columnIndexOrThrow13), prepare.getText(columnIndexOrThrow14), prepare.getText(i7)));
                columnIndexOrThrow = i6;
            }
            return arrayList;
        } finally {
            prepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List getUploadFailSports$lambda$4(String str, String str2, SQLiteConnection _connection) {
        g0.p(_connection, "_connection");
        SQLiteStatement prepare = _connection.prepare(str);
        try {
            prepare.mo40bindText(1, str2);
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "identify");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "userNumber");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "sportsType");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "sportsSet");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, AnalyticsConfig.RTD_START_TIME);
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "endTime");
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "countTime");
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "distance");
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "latLngList");
            int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "stepList");
            int columnIndexOrThrow11 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "passLatLngList");
            int columnIndexOrThrow12 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "points");
            int columnIndexOrThrow13 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "isFaceOut");
            int columnIndexOrThrow14 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "faceDetectCount");
            int columnIndexOrThrow15 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "uploadType");
            ArrayList arrayList = new ArrayList();
            while (prepare.step()) {
                int i6 = columnIndexOrThrow;
                int i7 = columnIndexOrThrow15;
                columnIndexOrThrow15 = i7;
                arrayList.add(new RunDb(prepare.getText(columnIndexOrThrow), prepare.getText(columnIndexOrThrow2), prepare.getText(columnIndexOrThrow3), prepare.getText(columnIndexOrThrow4), prepare.getText(columnIndexOrThrow5), prepare.getText(columnIndexOrThrow6), prepare.getText(columnIndexOrThrow7), prepare.getText(columnIndexOrThrow8), prepare.getText(columnIndexOrThrow9), prepare.getText(columnIndexOrThrow10), prepare.getText(columnIndexOrThrow11), prepare.getText(columnIndexOrThrow12), prepare.getText(columnIndexOrThrow13), prepare.getText(columnIndexOrThrow14), prepare.getText(i7)));
                columnIndexOrThrow = i6;
            }
            return arrayList;
        } finally {
            prepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List getUploadFailSportsByType$lambda$5(String str, String str2, int i6, SQLiteConnection _connection) {
        g0.p(_connection, "_connection");
        SQLiteStatement prepare = _connection.prepare(str);
        try {
            prepare.mo40bindText(1, str2);
            prepare.mo38bindLong(2, i6);
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "identify");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "userNumber");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "sportsType");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "sportsSet");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, AnalyticsConfig.RTD_START_TIME);
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "endTime");
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "countTime");
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "distance");
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "latLngList");
            int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "stepList");
            int columnIndexOrThrow11 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "passLatLngList");
            int columnIndexOrThrow12 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "points");
            int columnIndexOrThrow13 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "isFaceOut");
            int columnIndexOrThrow14 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "faceDetectCount");
            int columnIndexOrThrow15 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "uploadType");
            ArrayList arrayList = new ArrayList();
            while (prepare.step()) {
                int i7 = columnIndexOrThrow;
                int i8 = columnIndexOrThrow15;
                columnIndexOrThrow15 = i8;
                arrayList.add(new RunDb(prepare.getText(columnIndexOrThrow), prepare.getText(columnIndexOrThrow2), prepare.getText(columnIndexOrThrow3), prepare.getText(columnIndexOrThrow4), prepare.getText(columnIndexOrThrow5), prepare.getText(columnIndexOrThrow6), prepare.getText(columnIndexOrThrow7), prepare.getText(columnIndexOrThrow8), prepare.getText(columnIndexOrThrow9), prepare.getText(columnIndexOrThrow10), prepare.getText(columnIndexOrThrow11), prepare.getText(columnIndexOrThrow12), prepare.getText(columnIndexOrThrow13), prepare.getText(columnIndexOrThrow14), prepare.getText(i8)));
                columnIndexOrThrow = i7;
            }
            return arrayList;
        } finally {
            prepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 insertRun$lambda$0(RunDao_Impl runDao_Impl, RunDb[] runDbArr, SQLiteConnection _connection) {
        g0.p(_connection, "_connection");
        runDao_Impl.__insertAdapterOfRunDb.insert(_connection, runDbArr);
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 updateSports$lambda$7(String str, String str2, String str3, String str4, SQLiteConnection _connection) {
        g0.p(_connection, "_connection");
        SQLiteStatement prepare = _connection.prepare(str);
        try {
            prepare.mo40bindText(1, str2);
            prepare.mo40bindText(2, str3);
            prepare.mo40bindText(3, str4);
            prepare.step();
            prepare.close();
            return n1.f44123a;
        } catch (Throwable th) {
            prepare.close();
            throw th;
        }
    }

    @Override // com.bxkj.student.run.app.offline.dao.RunDao
    @Nullable
    public Object deleteByIdentify(@NotNull final String str, @NotNull kotlin.coroutines.e<? super n1> eVar) {
        final String str2 = "DELETE FROM runDb WHERE identify=?";
        Object performSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.bxkj.student.run.app.offline.dao.g
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 deleteByIdentify$lambda$6;
                deleteByIdentify$lambda$6 = RunDao_Impl.deleteByIdentify$lambda$6(str2, str, (SQLiteConnection) obj);
                return deleteByIdentify$lambda$6;
            }
        }, eVar);
        return performSuspending == kotlin.coroutines.intrinsics.a.l() ? performSuspending : n1.f44123a;
    }

    @Override // com.bxkj.student.run.app.offline.dao.RunDao
    @Nullable
    public Object deleteSports(@NotNull final RunDb runDb, @NotNull kotlin.coroutines.e<? super n1> eVar) {
        Object performSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.bxkj.student.run.app.offline.dao.a
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 deleteSports$lambda$1;
                deleteSports$lambda$1 = RunDao_Impl.deleteSports$lambda$1(RunDao_Impl.this, runDb, (SQLiteConnection) obj);
                return deleteSports$lambda$1;
            }
        }, eVar);
        return performSuspending == kotlin.coroutines.intrinsics.a.l() ? performSuspending : n1.f44123a;
    }

    @Override // com.bxkj.student.run.app.offline.dao.RunDao
    @Nullable
    public Object getExceptionSports(@NotNull final String str, @NotNull kotlin.coroutines.e<? super List<RunDb>> eVar) {
        final String str2 = "SELECT * FROM runDb WHERE userNumber = ? AND uploadType =='-1'";
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: com.bxkj.student.run.app.offline.dao.e
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                List exceptionSports$lambda$3;
                exceptionSports$lambda$3 = RunDao_Impl.getExceptionSports$lambda$3(str2, str, (SQLiteConnection) obj);
                return exceptionSports$lambda$3;
            }
        }, eVar);
    }

    @Override // com.bxkj.student.run.app.offline.dao.RunDao
    @Nullable
    public Object getLocalRecordById(@NotNull final String str, @NotNull kotlin.coroutines.e<? super List<RunDb>> eVar) {
        final String str2 = "SELECT * FROM runDb WHERE identify = ?";
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: com.bxkj.student.run.app.offline.dao.h
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                List localRecordById$lambda$2;
                localRecordById$lambda$2 = RunDao_Impl.getLocalRecordById$lambda$2(str2, str, (SQLiteConnection) obj);
                return localRecordById$lambda$2;
            }
        }, eVar);
    }

    @Override // com.bxkj.student.run.app.offline.dao.RunDao
    @Nullable
    public Object getUploadFailSports(@NotNull final String str, @NotNull kotlin.coroutines.e<? super List<RunDb>> eVar) {
        final String str2 = "SELECT * FROM runDb WHERE userNumber = ? AND uploadType !='-1'";
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: com.bxkj.student.run.app.offline.dao.c
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                List uploadFailSports$lambda$4;
                uploadFailSports$lambda$4 = RunDao_Impl.getUploadFailSports$lambda$4(str2, str, (SQLiteConnection) obj);
                return uploadFailSports$lambda$4;
            }
        }, eVar);
    }

    @Override // com.bxkj.student.run.app.offline.dao.RunDao
    @Nullable
    public Object getUploadFailSportsByType(@NotNull final String str, final int i6, @NotNull kotlin.coroutines.e<? super List<RunDb>> eVar) {
        final String str2 = "SELECT * FROM runDb WHERE userNumber = ? AND uploadType !='-1' AND sportsType=?";
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: com.bxkj.student.run.app.offline.dao.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                List uploadFailSportsByType$lambda$5;
                uploadFailSportsByType$lambda$5 = RunDao_Impl.getUploadFailSportsByType$lambda$5(str2, str, i6, (SQLiteConnection) obj);
                return uploadFailSportsByType$lambda$5;
            }
        }, eVar);
    }

    @Override // com.bxkj.student.run.app.offline.dao.RunDao
    @Nullable
    public Object insertRun(@NotNull final RunDb[] runDbArr, @NotNull kotlin.coroutines.e<? super n1> eVar) {
        Object performSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.bxkj.student.run.app.offline.dao.f
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 insertRun$lambda$0;
                insertRun$lambda$0 = RunDao_Impl.insertRun$lambda$0(RunDao_Impl.this, runDbArr, (SQLiteConnection) obj);
                return insertRun$lambda$0;
            }
        }, eVar);
        return performSuspending == kotlin.coroutines.intrinsics.a.l() ? performSuspending : n1.f44123a;
    }

    @Override // com.bxkj.student.run.app.offline.dao.RunDao
    @Nullable
    public Object updateSports(@NotNull final String str, @NotNull final String str2, @NotNull final String str3, @NotNull kotlin.coroutines.e<? super n1> eVar) {
        final String str4 = "UPDATE runDb SET endTime=?,uploadType=? WHERE identify=?";
        Object performSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.bxkj.student.run.app.offline.dao.d
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 updateSports$lambda$7;
                updateSports$lambda$7 = RunDao_Impl.updateSports$lambda$7(str4, str, str2, str3, (SQLiteConnection) obj);
                return updateSports$lambda$7;
            }
        }, eVar);
        return performSuspending == kotlin.coroutines.intrinsics.a.l() ? performSuspending : n1.f44123a;
    }
}
