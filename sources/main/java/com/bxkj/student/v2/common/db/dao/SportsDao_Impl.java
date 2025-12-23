package com.bxkj.student.v2.common.db.dao;

import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import com.umeng.analytics.AnalyticsConfig;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class SportsDao_Impl implements x {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f20719c = new a(null);

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final RoomDatabase f20720a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final EntityInsertAdapter<m0.d> f20721b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.v vVar) {
            this();
        }

        private a() {
        }

        @NotNull
        public final List<kotlin.reflect.d<?>> a() {
            return kotlin.collections.f0.J();
        }
    }

    @Override // com.bxkj.student.v2.common.db.dao.x
    @Nullable
    public Object j(@NotNull final String str, @NotNull final String str2, @NotNull final String str3, @NotNull final String str4, @NotNull final String str5, @NotNull final String str6, @NotNull final String str7, @NotNull final String str8, @NotNull final String str9, @NotNull final String str10, @NotNull final String str11, @NotNull final String str12, @NotNull kotlin.coroutines.e<? super n1> eVar) {
        final String str13 = "UPDATE sports SET countTime=?,distance=? ,gpsDistance=?,latLngList=? ,stepList=?,passLatLngList=?,isFaceOut=? ,faceDetectCount=? ,faceCheckingDistance=?,pauseLatLng=? ,isOpenDevelop=? WHERE identify=?";
        Object performSuspending = DBUtil.performSuspending(this.f20720a, false, true, new Function1() { // from class: com.bxkj.student.v2.common.db.dao.m0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 Q;
                Q = SportsDao_Impl.Q(str13, str, str2, str3, str4, str5, str6, str7, str8, str10, str11, str12, str9, (SQLiteConnection) obj);
                return Q;
            }
        }, eVar);
        return performSuspending == kotlin.coroutines.intrinsics.a.l() ? performSuspending : n1.f44123a;
    }

    public SportsDao_Impl(@NotNull RoomDatabase __db) {
        kotlin.jvm.internal.g0.p(__db, "__db");
        this.f20720a = __db;
        this.f20721b = new EntityInsertAdapter<m0.d>() { // from class: com.bxkj.student.v2.common.db.dao.SportsDao_Impl.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertAdapter
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void bind(SQLiteStatement statement, m0.d entity) {
                kotlin.jvm.internal.g0.p(statement, "statement");
                kotlin.jvm.internal.g0.p(entity, "entity");
                statement.mo40bindText(1, entity.I());
                statement.mo40bindText(2, entity.T());
                statement.mo40bindText(3, entity.O());
                statement.mo40bindText(4, entity.N());
                statement.mo40bindText(5, entity.Q());
                statement.mo40bindText(6, entity.E());
                statement.mo40bindText(7, entity.B());
                statement.mo40bindText(8, entity.C());
                statement.mo40bindText(9, entity.H());
                statement.mo40bindText(10, entity.J());
                statement.mo40bindText(11, entity.R());
                statement.mo40bindText(12, entity.L());
                statement.mo40bindText(13, entity.V());
                statement.mo40bindText(14, entity.G());
                statement.mo40bindText(15, entity.S());
                statement.mo40bindText(16, entity.U());
                statement.mo40bindText(17, entity.P());
                statement.mo40bindText(18, entity.K());
                statement.mo40bindText(19, entity.D());
                statement.mo40bindText(20, entity.X());
                statement.mo40bindText(21, entity.F());
                statement.mo40bindText(22, entity.M());
                statement.mo40bindText(23, entity.W());
                statement.mo38bindLong(24, entity.A());
            }

            @Override // androidx.room.EntityInsertAdapter
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `sports` (`identify`,`userNumber`,`sportsType`,`sportsSet`,`startTime`,`endTime`,`countTime`,`distance`,`gpsDistance`,`latLngList`,`stepList`,`passLatLngList`,`isFaceOut`,`faceDetectCount`,`uploadType`,`isException`,`startFace`,`midFace`,`endFace`,`isValid`,`faceCheckingDistance`,`pauseLatLng`,`isOpenDevelop`,`confirmCount`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 F(String str, String str2, SQLiteConnection _connection) {
        kotlin.jvm.internal.g0.p(_connection, "_connection");
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
    public static final List G(String str, String str2, SQLiteConnection _connection) {
        kotlin.jvm.internal.g0.p(_connection, "_connection");
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
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "gpsDistance");
            int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "latLngList");
            int columnIndexOrThrow11 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "stepList");
            int columnIndexOrThrow12 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "passLatLngList");
            int columnIndexOrThrow13 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "isFaceOut");
            int columnIndexOrThrow14 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "faceDetectCount");
            int columnIndexOrThrow15 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "uploadType");
            int columnIndexOrThrow16 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "isException");
            int columnIndexOrThrow17 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "startFace");
            int columnIndexOrThrow18 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "midFace");
            int columnIndexOrThrow19 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "endFace");
            int columnIndexOrThrow20 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "isValid");
            int columnIndexOrThrow21 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "faceCheckingDistance");
            int columnIndexOrThrow22 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "pauseLatLng");
            int columnIndexOrThrow23 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "isOpenDevelop");
            int columnIndexOrThrow24 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "confirmCount");
            ArrayList arrayList = new ArrayList();
            while (prepare.step()) {
                String text = prepare.getText(columnIndexOrThrow);
                String text2 = prepare.getText(columnIndexOrThrow2);
                String text3 = prepare.getText(columnIndexOrThrow3);
                String text4 = prepare.getText(columnIndexOrThrow4);
                String text5 = prepare.getText(columnIndexOrThrow5);
                String text6 = prepare.getText(columnIndexOrThrow6);
                String text7 = prepare.getText(columnIndexOrThrow7);
                String text8 = prepare.getText(columnIndexOrThrow8);
                String text9 = prepare.getText(columnIndexOrThrow9);
                String text10 = prepare.getText(columnIndexOrThrow10);
                String text11 = prepare.getText(columnIndexOrThrow11);
                String text12 = prepare.getText(columnIndexOrThrow12);
                String text13 = prepare.getText(columnIndexOrThrow13);
                String text14 = prepare.getText(columnIndexOrThrow14);
                int i6 = columnIndexOrThrow;
                int i7 = columnIndexOrThrow15;
                String text15 = prepare.getText(i7);
                columnIndexOrThrow15 = i7;
                int i8 = columnIndexOrThrow16;
                String text16 = prepare.getText(i8);
                columnIndexOrThrow16 = i8;
                int i9 = columnIndexOrThrow17;
                String text17 = prepare.getText(i9);
                columnIndexOrThrow17 = i9;
                int i10 = columnIndexOrThrow18;
                String text18 = prepare.getText(i10);
                columnIndexOrThrow18 = i10;
                int i11 = columnIndexOrThrow19;
                String text19 = prepare.getText(i11);
                columnIndexOrThrow19 = i11;
                int i12 = columnIndexOrThrow20;
                String text20 = prepare.getText(i12);
                columnIndexOrThrow20 = i12;
                int i13 = columnIndexOrThrow21;
                String text21 = prepare.getText(i13);
                columnIndexOrThrow21 = i13;
                int i14 = columnIndexOrThrow22;
                String text22 = prepare.getText(i14);
                columnIndexOrThrow22 = i14;
                int i15 = columnIndexOrThrow23;
                String text23 = prepare.getText(i15);
                columnIndexOrThrow23 = i15;
                int i16 = columnIndexOrThrow3;
                int i17 = columnIndexOrThrow24;
                int i18 = columnIndexOrThrow2;
                arrayList.add(new m0.d(text, text2, text3, text4, text5, text6, text7, text8, text9, text10, text11, text12, text13, text14, text15, text16, text17, text18, text19, text20, text21, text22, text23, (int) prepare.getLong(i17)));
                columnIndexOrThrow2 = i18;
                columnIndexOrThrow3 = i16;
                columnIndexOrThrow24 = i17;
                columnIndexOrThrow = i6;
            }
            return arrayList;
        } finally {
            prepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List H(String str, String str2, SQLiteConnection _connection) {
        kotlin.jvm.internal.g0.p(_connection, "_connection");
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
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "gpsDistance");
            int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "latLngList");
            int columnIndexOrThrow11 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "stepList");
            int columnIndexOrThrow12 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "passLatLngList");
            int columnIndexOrThrow13 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "isFaceOut");
            int columnIndexOrThrow14 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "faceDetectCount");
            int columnIndexOrThrow15 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "uploadType");
            int columnIndexOrThrow16 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "isException");
            int columnIndexOrThrow17 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "startFace");
            int columnIndexOrThrow18 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "midFace");
            int columnIndexOrThrow19 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "endFace");
            int columnIndexOrThrow20 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "isValid");
            int columnIndexOrThrow21 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "faceCheckingDistance");
            int columnIndexOrThrow22 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "pauseLatLng");
            int columnIndexOrThrow23 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "isOpenDevelop");
            int columnIndexOrThrow24 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "confirmCount");
            ArrayList arrayList = new ArrayList();
            while (prepare.step()) {
                String text = prepare.getText(columnIndexOrThrow);
                String text2 = prepare.getText(columnIndexOrThrow2);
                String text3 = prepare.getText(columnIndexOrThrow3);
                String text4 = prepare.getText(columnIndexOrThrow4);
                String text5 = prepare.getText(columnIndexOrThrow5);
                String text6 = prepare.getText(columnIndexOrThrow6);
                String text7 = prepare.getText(columnIndexOrThrow7);
                String text8 = prepare.getText(columnIndexOrThrow8);
                String text9 = prepare.getText(columnIndexOrThrow9);
                String text10 = prepare.getText(columnIndexOrThrow10);
                String text11 = prepare.getText(columnIndexOrThrow11);
                String text12 = prepare.getText(columnIndexOrThrow12);
                String text13 = prepare.getText(columnIndexOrThrow13);
                String text14 = prepare.getText(columnIndexOrThrow14);
                int i6 = columnIndexOrThrow;
                int i7 = columnIndexOrThrow15;
                String text15 = prepare.getText(i7);
                columnIndexOrThrow15 = i7;
                int i8 = columnIndexOrThrow16;
                String text16 = prepare.getText(i8);
                columnIndexOrThrow16 = i8;
                int i9 = columnIndexOrThrow17;
                String text17 = prepare.getText(i9);
                columnIndexOrThrow17 = i9;
                int i10 = columnIndexOrThrow18;
                String text18 = prepare.getText(i10);
                columnIndexOrThrow18 = i10;
                int i11 = columnIndexOrThrow19;
                String text19 = prepare.getText(i11);
                columnIndexOrThrow19 = i11;
                int i12 = columnIndexOrThrow20;
                String text20 = prepare.getText(i12);
                columnIndexOrThrow20 = i12;
                int i13 = columnIndexOrThrow21;
                String text21 = prepare.getText(i13);
                columnIndexOrThrow21 = i13;
                int i14 = columnIndexOrThrow22;
                String text22 = prepare.getText(i14);
                columnIndexOrThrow22 = i14;
                int i15 = columnIndexOrThrow23;
                String text23 = prepare.getText(i15);
                columnIndexOrThrow23 = i15;
                int i16 = columnIndexOrThrow3;
                int i17 = columnIndexOrThrow24;
                int i18 = columnIndexOrThrow2;
                arrayList.add(new m0.d(text, text2, text3, text4, text5, text6, text7, text8, text9, text10, text11, text12, text13, text14, text15, text16, text17, text18, text19, text20, text21, text22, text23, (int) prepare.getLong(i17)));
                columnIndexOrThrow2 = i18;
                columnIndexOrThrow3 = i16;
                columnIndexOrThrow24 = i17;
                columnIndexOrThrow = i6;
            }
            return arrayList;
        } finally {
            prepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List I(String str, String str2, SQLiteConnection _connection) {
        kotlin.jvm.internal.g0.p(_connection, "_connection");
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
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "gpsDistance");
            int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "latLngList");
            int columnIndexOrThrow11 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "stepList");
            int columnIndexOrThrow12 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "passLatLngList");
            int columnIndexOrThrow13 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "isFaceOut");
            int columnIndexOrThrow14 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "faceDetectCount");
            int columnIndexOrThrow15 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "uploadType");
            int columnIndexOrThrow16 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "isException");
            int columnIndexOrThrow17 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "startFace");
            int columnIndexOrThrow18 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "midFace");
            int columnIndexOrThrow19 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "endFace");
            int columnIndexOrThrow20 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "isValid");
            int columnIndexOrThrow21 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "faceCheckingDistance");
            int columnIndexOrThrow22 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "pauseLatLng");
            int columnIndexOrThrow23 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "isOpenDevelop");
            int columnIndexOrThrow24 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "confirmCount");
            ArrayList arrayList = new ArrayList();
            while (prepare.step()) {
                String text = prepare.getText(columnIndexOrThrow);
                String text2 = prepare.getText(columnIndexOrThrow2);
                String text3 = prepare.getText(columnIndexOrThrow3);
                String text4 = prepare.getText(columnIndexOrThrow4);
                String text5 = prepare.getText(columnIndexOrThrow5);
                String text6 = prepare.getText(columnIndexOrThrow6);
                String text7 = prepare.getText(columnIndexOrThrow7);
                String text8 = prepare.getText(columnIndexOrThrow8);
                String text9 = prepare.getText(columnIndexOrThrow9);
                String text10 = prepare.getText(columnIndexOrThrow10);
                String text11 = prepare.getText(columnIndexOrThrow11);
                String text12 = prepare.getText(columnIndexOrThrow12);
                String text13 = prepare.getText(columnIndexOrThrow13);
                String text14 = prepare.getText(columnIndexOrThrow14);
                int i6 = columnIndexOrThrow;
                int i7 = columnIndexOrThrow15;
                String text15 = prepare.getText(i7);
                columnIndexOrThrow15 = i7;
                int i8 = columnIndexOrThrow16;
                String text16 = prepare.getText(i8);
                columnIndexOrThrow16 = i8;
                int i9 = columnIndexOrThrow17;
                String text17 = prepare.getText(i9);
                columnIndexOrThrow17 = i9;
                int i10 = columnIndexOrThrow18;
                String text18 = prepare.getText(i10);
                columnIndexOrThrow18 = i10;
                int i11 = columnIndexOrThrow19;
                String text19 = prepare.getText(i11);
                columnIndexOrThrow19 = i11;
                int i12 = columnIndexOrThrow20;
                String text20 = prepare.getText(i12);
                columnIndexOrThrow20 = i12;
                int i13 = columnIndexOrThrow21;
                String text21 = prepare.getText(i13);
                columnIndexOrThrow21 = i13;
                int i14 = columnIndexOrThrow22;
                String text22 = prepare.getText(i14);
                columnIndexOrThrow22 = i14;
                int i15 = columnIndexOrThrow23;
                String text23 = prepare.getText(i15);
                columnIndexOrThrow23 = i15;
                int i16 = columnIndexOrThrow3;
                int i17 = columnIndexOrThrow24;
                int i18 = columnIndexOrThrow2;
                arrayList.add(new m0.d(text, text2, text3, text4, text5, text6, text7, text8, text9, text10, text11, text12, text13, text14, text15, text16, text17, text18, text19, text20, text21, text22, text23, (int) prepare.getLong(i17)));
                columnIndexOrThrow2 = i18;
                columnIndexOrThrow3 = i16;
                columnIndexOrThrow24 = i17;
                columnIndexOrThrow = i6;
            }
            return arrayList;
        } finally {
            prepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List J(String str, String str2, long j6, long j7, SQLiteConnection _connection) {
        kotlin.jvm.internal.g0.p(_connection, "_connection");
        SQLiteStatement prepare = _connection.prepare(str);
        try {
            prepare.mo40bindText(1, str2);
            prepare.mo38bindLong(2, j6);
            prepare.mo38bindLong(3, j7);
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "identify");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "userNumber");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "sportsType");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "sportsSet");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, AnalyticsConfig.RTD_START_TIME);
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "endTime");
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "countTime");
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "distance");
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "gpsDistance");
            int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "latLngList");
            int columnIndexOrThrow11 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "stepList");
            int columnIndexOrThrow12 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "passLatLngList");
            int columnIndexOrThrow13 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "isFaceOut");
            int columnIndexOrThrow14 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "faceDetectCount");
            int columnIndexOrThrow15 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "uploadType");
            int columnIndexOrThrow16 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "isException");
            int columnIndexOrThrow17 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "startFace");
            int columnIndexOrThrow18 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "midFace");
            int columnIndexOrThrow19 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "endFace");
            int columnIndexOrThrow20 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "isValid");
            int columnIndexOrThrow21 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "faceCheckingDistance");
            int columnIndexOrThrow22 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "pauseLatLng");
            int columnIndexOrThrow23 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "isOpenDevelop");
            int columnIndexOrThrow24 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "confirmCount");
            ArrayList arrayList = new ArrayList();
            while (prepare.step()) {
                String text = prepare.getText(columnIndexOrThrow);
                String text2 = prepare.getText(columnIndexOrThrow2);
                String text3 = prepare.getText(columnIndexOrThrow3);
                String text4 = prepare.getText(columnIndexOrThrow4);
                String text5 = prepare.getText(columnIndexOrThrow5);
                String text6 = prepare.getText(columnIndexOrThrow6);
                String text7 = prepare.getText(columnIndexOrThrow7);
                String text8 = prepare.getText(columnIndexOrThrow8);
                String text9 = prepare.getText(columnIndexOrThrow9);
                String text10 = prepare.getText(columnIndexOrThrow10);
                String text11 = prepare.getText(columnIndexOrThrow11);
                String text12 = prepare.getText(columnIndexOrThrow12);
                String text13 = prepare.getText(columnIndexOrThrow13);
                String text14 = prepare.getText(columnIndexOrThrow14);
                int i6 = columnIndexOrThrow;
                int i7 = columnIndexOrThrow15;
                String text15 = prepare.getText(i7);
                columnIndexOrThrow15 = i7;
                int i8 = columnIndexOrThrow16;
                String text16 = prepare.getText(i8);
                columnIndexOrThrow16 = i8;
                int i9 = columnIndexOrThrow17;
                String text17 = prepare.getText(i9);
                columnIndexOrThrow17 = i9;
                int i10 = columnIndexOrThrow18;
                String text18 = prepare.getText(i10);
                columnIndexOrThrow18 = i10;
                int i11 = columnIndexOrThrow19;
                String text19 = prepare.getText(i11);
                columnIndexOrThrow19 = i11;
                int i12 = columnIndexOrThrow20;
                String text20 = prepare.getText(i12);
                columnIndexOrThrow20 = i12;
                int i13 = columnIndexOrThrow21;
                String text21 = prepare.getText(i13);
                columnIndexOrThrow21 = i13;
                int i14 = columnIndexOrThrow22;
                String text22 = prepare.getText(i14);
                columnIndexOrThrow22 = i14;
                int i15 = columnIndexOrThrow23;
                String text23 = prepare.getText(i15);
                columnIndexOrThrow23 = i15;
                int i16 = columnIndexOrThrow3;
                int i17 = columnIndexOrThrow24;
                int i18 = columnIndexOrThrow2;
                arrayList.add(new m0.d(text, text2, text3, text4, text5, text6, text7, text8, text9, text10, text11, text12, text13, text14, text15, text16, text17, text18, text19, text20, text21, text22, text23, (int) prepare.getLong(i17)));
                columnIndexOrThrow2 = i18;
                columnIndexOrThrow3 = i16;
                columnIndexOrThrow24 = i17;
                columnIndexOrThrow = i6;
            }
            return arrayList;
        } finally {
            prepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List K(String str, String str2, long j6, long j7, SQLiteConnection _connection) {
        kotlin.jvm.internal.g0.p(_connection, "_connection");
        SQLiteStatement prepare = _connection.prepare(str);
        try {
            prepare.mo40bindText(1, str2);
            prepare.mo38bindLong(2, j6);
            prepare.mo38bindLong(3, j7);
            ArrayList arrayList = new ArrayList();
            while (prepare.step()) {
                arrayList.add(new l0.a(prepare.getLong(0), prepare.getLong(1), prepare.getLong(2)));
            }
            return arrayList;
        } finally {
            prepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List L(String str, String str2, SQLiteConnection _connection) {
        kotlin.jvm.internal.g0.p(_connection, "_connection");
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
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "gpsDistance");
            int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "latLngList");
            int columnIndexOrThrow11 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "stepList");
            int columnIndexOrThrow12 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "passLatLngList");
            int columnIndexOrThrow13 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "isFaceOut");
            int columnIndexOrThrow14 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "faceDetectCount");
            int columnIndexOrThrow15 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "uploadType");
            int columnIndexOrThrow16 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "isException");
            int columnIndexOrThrow17 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "startFace");
            int columnIndexOrThrow18 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "midFace");
            int columnIndexOrThrow19 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "endFace");
            int columnIndexOrThrow20 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "isValid");
            int columnIndexOrThrow21 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "faceCheckingDistance");
            int columnIndexOrThrow22 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "pauseLatLng");
            int columnIndexOrThrow23 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "isOpenDevelop");
            int columnIndexOrThrow24 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "confirmCount");
            ArrayList arrayList = new ArrayList();
            while (prepare.step()) {
                String text = prepare.getText(columnIndexOrThrow);
                String text2 = prepare.getText(columnIndexOrThrow2);
                String text3 = prepare.getText(columnIndexOrThrow3);
                String text4 = prepare.getText(columnIndexOrThrow4);
                String text5 = prepare.getText(columnIndexOrThrow5);
                String text6 = prepare.getText(columnIndexOrThrow6);
                String text7 = prepare.getText(columnIndexOrThrow7);
                String text8 = prepare.getText(columnIndexOrThrow8);
                String text9 = prepare.getText(columnIndexOrThrow9);
                String text10 = prepare.getText(columnIndexOrThrow10);
                String text11 = prepare.getText(columnIndexOrThrow11);
                String text12 = prepare.getText(columnIndexOrThrow12);
                String text13 = prepare.getText(columnIndexOrThrow13);
                String text14 = prepare.getText(columnIndexOrThrow14);
                int i6 = columnIndexOrThrow;
                int i7 = columnIndexOrThrow15;
                String text15 = prepare.getText(i7);
                columnIndexOrThrow15 = i7;
                int i8 = columnIndexOrThrow16;
                String text16 = prepare.getText(i8);
                columnIndexOrThrow16 = i8;
                int i9 = columnIndexOrThrow17;
                String text17 = prepare.getText(i9);
                columnIndexOrThrow17 = i9;
                int i10 = columnIndexOrThrow18;
                String text18 = prepare.getText(i10);
                columnIndexOrThrow18 = i10;
                int i11 = columnIndexOrThrow19;
                String text19 = prepare.getText(i11);
                columnIndexOrThrow19 = i11;
                int i12 = columnIndexOrThrow20;
                String text20 = prepare.getText(i12);
                columnIndexOrThrow20 = i12;
                int i13 = columnIndexOrThrow21;
                String text21 = prepare.getText(i13);
                columnIndexOrThrow21 = i13;
                int i14 = columnIndexOrThrow22;
                String text22 = prepare.getText(i14);
                columnIndexOrThrow22 = i14;
                int i15 = columnIndexOrThrow23;
                String text23 = prepare.getText(i15);
                columnIndexOrThrow23 = i15;
                int i16 = columnIndexOrThrow3;
                int i17 = columnIndexOrThrow24;
                int i18 = columnIndexOrThrow2;
                arrayList.add(new m0.d(text, text2, text3, text4, text5, text6, text7, text8, text9, text10, text11, text12, text13, text14, text15, text16, text17, text18, text19, text20, text21, text22, text23, (int) prepare.getLong(i17)));
                columnIndexOrThrow2 = i18;
                columnIndexOrThrow3 = i16;
                columnIndexOrThrow24 = i17;
                columnIndexOrThrow = i6;
            }
            return arrayList;
        } finally {
            prepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 M(SportsDao_Impl sportsDao_Impl, m0.d[] dVarArr, SQLiteConnection _connection) {
        kotlin.jvm.internal.g0.p(_connection, "_connection");
        sportsDao_Impl.f20721b.insert(_connection, dVarArr);
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 N(String str, String str2, String str3, String str4, String str5, SQLiteConnection _connection) {
        kotlin.jvm.internal.g0.p(_connection, "_connection");
        SQLiteStatement prepare = _connection.prepare(str);
        try {
            prepare.mo40bindText(1, str2);
            prepare.mo40bindText(2, str3);
            prepare.mo40bindText(3, str4);
            prepare.mo40bindText(4, str5);
            prepare.step();
            prepare.close();
            return n1.f44123a;
        } catch (Throwable th) {
            prepare.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 O(String str, String str2, SQLiteConnection _connection) {
        kotlin.jvm.internal.g0.p(_connection, "_connection");
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
    public static final n1 P(String str, String str2, String str3, SQLiteConnection _connection) {
        kotlin.jvm.internal.g0.p(_connection, "_connection");
        SQLiteStatement prepare = _connection.prepare(str);
        try {
            prepare.mo40bindText(1, str2);
            prepare.mo40bindText(2, str3);
            prepare.step();
            prepare.close();
            return n1.f44123a;
        } catch (Throwable th) {
            prepare.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 Q(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, SQLiteConnection _connection) {
        kotlin.jvm.internal.g0.p(_connection, "_connection");
        SQLiteStatement prepare = _connection.prepare(str);
        try {
            prepare.mo40bindText(1, str2);
            prepare.mo40bindText(2, str3);
            prepare.mo40bindText(3, str4);
            prepare.mo40bindText(4, str5);
            prepare.mo40bindText(5, str6);
            prepare.mo40bindText(6, str7);
            prepare.mo40bindText(7, str8);
            prepare.mo40bindText(8, str9);
            prepare.mo40bindText(9, str10);
            prepare.mo40bindText(10, str11);
            prepare.mo40bindText(11, str12);
            prepare.mo40bindText(12, str13);
            prepare.step();
            prepare.close();
            return n1.f44123a;
        } catch (Throwable th) {
            prepare.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 R(String str, String str2, String str3, SQLiteConnection _connection) {
        kotlin.jvm.internal.g0.p(_connection, "_connection");
        SQLiteStatement prepare = _connection.prepare(str);
        try {
            prepare.mo40bindText(1, str2);
            prepare.mo40bindText(2, str3);
            prepare.step();
            prepare.close();
            return n1.f44123a;
        } catch (Throwable th) {
            prepare.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 S(String str, String str2, String str3, SQLiteConnection _connection) {
        kotlin.jvm.internal.g0.p(_connection, "_connection");
        SQLiteStatement prepare = _connection.prepare(str);
        try {
            prepare.mo40bindText(1, str2);
            prepare.mo40bindText(2, str3);
            prepare.step();
            prepare.close();
            return n1.f44123a;
        } catch (Throwable th) {
            prepare.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 T(String str, String str2, String str3, SQLiteConnection _connection) {
        kotlin.jvm.internal.g0.p(_connection, "_connection");
        SQLiteStatement prepare = _connection.prepare(str);
        try {
            prepare.mo40bindText(1, str2);
            prepare.mo40bindText(2, str3);
            prepare.step();
            prepare.close();
            return n1.f44123a;
        } catch (Throwable th) {
            prepare.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 U(String str, String str2, SQLiteConnection _connection) {
        kotlin.jvm.internal.g0.p(_connection, "_connection");
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
    public static final n1 V(String str, String str2, String str3, SQLiteConnection _connection) {
        kotlin.jvm.internal.g0.p(_connection, "_connection");
        SQLiteStatement prepare = _connection.prepare(str);
        try {
            prepare.mo40bindText(1, str2);
            prepare.mo40bindText(2, str3);
            prepare.step();
            prepare.close();
            return n1.f44123a;
        } catch (Throwable th) {
            prepare.close();
            throw th;
        }
    }

    @Override // com.bxkj.student.v2.common.db.dao.x
    @Nullable
    public Object a(@NotNull final String str, @NotNull final String str2, @NotNull kotlin.coroutines.e<? super n1> eVar) {
        final String str3 = "UPDATE sports SET isValid=? WHERE identify=?";
        Object performSuspending = DBUtil.performSuspending(this.f20720a, false, true, new Function1() { // from class: com.bxkj.student.v2.common.db.dao.g0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 T;
                T = SportsDao_Impl.T(str3, str, str2, (SQLiteConnection) obj);
                return T;
            }
        }, eVar);
        return performSuspending == kotlin.coroutines.intrinsics.a.l() ? performSuspending : n1.f44123a;
    }

    @Override // com.bxkj.student.v2.common.db.dao.x
    @Nullable
    public Object b(@NotNull final String str, @NotNull kotlin.coroutines.e<? super n1> eVar) {
        final String str2 = "UPDATE sports SET confirmCount=confirmCount+1 WHERE identify=?";
        Object performSuspending = DBUtil.performSuspending(this.f20720a, false, true, new Function1() { // from class: com.bxkj.student.v2.common.db.dao.e0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 O;
                O = SportsDao_Impl.O(str2, str, (SQLiteConnection) obj);
                return O;
            }
        }, eVar);
        return performSuspending == kotlin.coroutines.intrinsics.a.l() ? performSuspending : n1.f44123a;
    }

    @Override // com.bxkj.student.v2.common.db.dao.x
    @Nullable
    public Object c(@NotNull final String str, @NotNull final String str2, @NotNull kotlin.coroutines.e<? super n1> eVar) {
        final String str3 = "UPDATE sports SET isFaceOut=? WHERE identify=?";
        Object performSuspending = DBUtil.performSuspending(this.f20720a, false, true, new Function1() { // from class: com.bxkj.student.v2.common.db.dao.a0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 P;
                P = SportsDao_Impl.P(str3, str, str2, (SQLiteConnection) obj);
                return P;
            }
        }, eVar);
        return performSuspending == kotlin.coroutines.intrinsics.a.l() ? performSuspending : n1.f44123a;
    }

    @Override // com.bxkj.student.v2.common.db.dao.x
    @Nullable
    public Object d(@NotNull final String str, final long j6, final long j7, @NotNull kotlin.coroutines.e<? super List<m0.d>> eVar) {
        final String str2 = "SELECT * FROM sports WHERE userNumber = ? AND endTime !='' AND confirmCount==0 AND startTime BETWEEN ? And ?";
        return DBUtil.performSuspending(this.f20720a, true, false, new Function1() { // from class: com.bxkj.student.v2.common.db.dao.f0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                List J;
                J = SportsDao_Impl.J(str2, str, j6, j7, (SQLiteConnection) obj);
                return J;
            }
        }, eVar);
    }

    @Override // com.bxkj.student.v2.common.db.dao.x
    @Nullable
    public Object deleteByIdentify(@NotNull final String str, @NotNull kotlin.coroutines.e<? super n1> eVar) {
        final String str2 = "DELETE FROM sports WHERE identify=?";
        Object performSuspending = DBUtil.performSuspending(this.f20720a, false, true, new Function1() { // from class: com.bxkj.student.v2.common.db.dao.n0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 F;
                F = SportsDao_Impl.F(str2, str, (SQLiteConnection) obj);
                return F;
            }
        }, eVar);
        return performSuspending == kotlin.coroutines.intrinsics.a.l() ? performSuspending : n1.f44123a;
    }

    @Override // com.bxkj.student.v2.common.db.dao.x
    @Nullable
    public Object e(@NotNull final String str, @NotNull final String str2, @NotNull kotlin.coroutines.e<? super n1> eVar) {
        final String str3 = "UPDATE sports SET sportsSet=? WHERE identify=?";
        Object performSuspending = DBUtil.performSuspending(this.f20720a, false, true, new Function1() { // from class: com.bxkj.student.v2.common.db.dao.b0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 R;
                R = SportsDao_Impl.R(str3, str, str2, (SQLiteConnection) obj);
                return R;
            }
        }, eVar);
        return performSuspending == kotlin.coroutines.intrinsics.a.l() ? performSuspending : n1.f44123a;
    }

    @Override // com.bxkj.student.v2.common.db.dao.x
    @Nullable
    public Object f(@NotNull final String str, @NotNull kotlin.coroutines.e<? super List<m0.d>> eVar) {
        final String str2 = "SELECT * FROM sports WHERE userNumber = ? AND endTime !='' AND confirmCount==0";
        return DBUtil.performSuspending(this.f20720a, true, false, new Function1() { // from class: com.bxkj.student.v2.common.db.dao.d0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                List I;
                I = SportsDao_Impl.I(str2, str, (SQLiteConnection) obj);
                return I;
            }
        }, eVar);
    }

    @Override // com.bxkj.student.v2.common.db.dao.x
    @Nullable
    public Object g(@NotNull final String str, @NotNull final String str2, @NotNull final String str3, @NotNull final String str4, @NotNull kotlin.coroutines.e<? super n1> eVar) {
        final String str5 = "UPDATE sports SET isException=?,isValid=?, endTime=? WHERE identify=?";
        Object performSuspending = DBUtil.performSuspending(this.f20720a, false, true, new Function1() { // from class: com.bxkj.student.v2.common.db.dao.o0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 N;
                N = SportsDao_Impl.N(str5, str, str2, str3, str4, (SQLiteConnection) obj);
                return N;
            }
        }, eVar);
        return performSuspending == kotlin.coroutines.intrinsics.a.l() ? performSuspending : n1.f44123a;
    }

    @Override // com.bxkj.student.v2.common.db.dao.x
    @Nullable
    public Object getExceptionSports(@NotNull final String str, @NotNull kotlin.coroutines.e<? super List<m0.d>> eVar) {
        final String str2 = "SELECT * FROM sports WHERE userNumber = ? AND endTime ==''";
        return DBUtil.performSuspending(this.f20720a, true, false, new Function1() { // from class: com.bxkj.student.v2.common.db.dao.j0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                List G;
                G = SportsDao_Impl.G(str2, str, (SQLiteConnection) obj);
                return G;
            }
        }, eVar);
    }

    @Override // com.bxkj.student.v2.common.db.dao.x
    @Nullable
    public Object getLocalRecordById(@NotNull final String str, @NotNull kotlin.coroutines.e<? super List<m0.d>> eVar) {
        final String str2 = "SELECT * FROM sports WHERE identify = ?";
        return DBUtil.performSuspending(this.f20720a, true, false, new Function1() { // from class: com.bxkj.student.v2.common.db.dao.k0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                List H;
                H = SportsDao_Impl.H(str2, str, (SQLiteConnection) obj);
                return H;
            }
        }, eVar);
    }

    @Override // com.bxkj.student.v2.common.db.dao.x
    @Nullable
    public Object h(@NotNull final String str, @NotNull kotlin.coroutines.e<? super n1> eVar) {
        final String str2 = "UPDATE sports SET confirmCount=1 WHERE identify=?";
        Object performSuspending = DBUtil.performSuspending(this.f20720a, false, true, new Function1() { // from class: com.bxkj.student.v2.common.db.dao.i0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 U;
                U = SportsDao_Impl.U(str2, str, (SQLiteConnection) obj);
                return U;
            }
        }, eVar);
        return performSuspending == kotlin.coroutines.intrinsics.a.l() ? performSuspending : n1.f44123a;
    }

    @Override // com.bxkj.student.v2.common.db.dao.x
    @Nullable
    public Object i(@NotNull final m0.d[] dVarArr, @NotNull kotlin.coroutines.e<? super n1> eVar) {
        Object performSuspending = DBUtil.performSuspending(this.f20720a, false, true, new Function1() { // from class: com.bxkj.student.v2.common.db.dao.h0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 M;
                M = SportsDao_Impl.M(SportsDao_Impl.this, dVarArr, (SQLiteConnection) obj);
                return M;
            }
        }, eVar);
        return performSuspending == kotlin.coroutines.intrinsics.a.l() ? performSuspending : n1.f44123a;
    }

    @Override // com.bxkj.student.v2.common.db.dao.x
    @Nullable
    public Object k(@NotNull final String str, @NotNull final String str2, @NotNull kotlin.coroutines.e<? super n1> eVar) {
        final String str3 = "UPDATE sports SET endTime=? WHERE identify=?";
        Object performSuspending = DBUtil.performSuspending(this.f20720a, false, true, new Function1() { // from class: com.bxkj.student.v2.common.db.dao.z
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 V;
                V = SportsDao_Impl.V(str3, str2, str, (SQLiteConnection) obj);
                return V;
            }
        }, eVar);
        return performSuspending == kotlin.coroutines.intrinsics.a.l() ? performSuspending : n1.f44123a;
    }

    @Override // com.bxkj.student.v2.common.db.dao.x
    @Nullable
    public Object l(@NotNull final String str, @NotNull kotlin.coroutines.e<? super List<m0.d>> eVar) {
        final String str2 = "SELECT * FROM sports WHERE userNumber = ? AND  confirmCount > 0";
        return DBUtil.performSuspending(this.f20720a, true, false, new Function1() { // from class: com.bxkj.student.v2.common.db.dao.l0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                List L;
                L = SportsDao_Impl.L(str2, str, (SQLiteConnection) obj);
                return L;
            }
        }, eVar);
    }

    @Override // com.bxkj.student.v2.common.db.dao.x
    @Nullable
    public Object m(@NotNull final String str, final long j6, final long j7, @NotNull kotlin.coroutines.e<? super List<l0.a>> eVar) {
        final String str2 = "SELECT COUNT(identify) as count, sum(distance) AS distance,sum(countTime) AS time FROM sports WHERE userNumber = ? AND endTime !='' AND confirmCount==0 AND startTime BETWEEN ? And ?";
        return DBUtil.performSuspending(this.f20720a, true, false, new Function1() { // from class: com.bxkj.student.v2.common.db.dao.y
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                List K;
                K = SportsDao_Impl.K(str2, str, j6, j7, (SQLiteConnection) obj);
                return K;
            }
        }, eVar);
    }

    @Override // com.bxkj.student.v2.common.db.dao.x
    @Nullable
    public Object n(@NotNull final String str, @NotNull final String str2, @NotNull kotlin.coroutines.e<? super n1> eVar) {
        final String str3 = "UPDATE sports SET uploadType=? WHERE identify=?";
        Object performSuspending = DBUtil.performSuspending(this.f20720a, false, true, new Function1() { // from class: com.bxkj.student.v2.common.db.dao.c0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 S;
                S = SportsDao_Impl.S(str3, str, str2, (SQLiteConnection) obj);
                return S;
            }
        }, eVar);
        return performSuspending == kotlin.coroutines.intrinsics.a.l() ? performSuspending : n1.f44123a;
    }
}
