package com.bxkj.student.v2.common.db.dao;

import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class FaceDao_Impl implements g {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f20713c = new a(null);

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final RoomDatabase f20714a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final EntityInsertAdapter<m0.b> f20715b;

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

    public FaceDao_Impl(@NotNull RoomDatabase __db) {
        kotlin.jvm.internal.g0.p(__db, "__db");
        this.f20714a = __db;
        this.f20715b = new EntityInsertAdapter<m0.b>() { // from class: com.bxkj.student.v2.common.db.dao.FaceDao_Impl.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertAdapter
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void bind(SQLiteStatement statement, m0.b entity) {
                kotlin.jvm.internal.g0.p(statement, "statement");
                kotlin.jvm.internal.g0.p(entity, "entity");
                statement.mo38bindLong(1, entity.k());
                statement.mo40bindText(2, entity.l());
                statement.mo40bindText(3, entity.getType());
                statement.mo40bindText(4, entity.j());
                String i6 = entity.i();
                if (i6 == null) {
                    statement.mo39bindNull(5);
                } else {
                    statement.mo40bindText(5, i6);
                }
                String m6 = entity.m();
                if (m6 == null) {
                    statement.mo39bindNull(6);
                } else {
                    statement.mo40bindText(6, m6);
                }
            }

            @Override // androidx.room.EntityInsertAdapter
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `face` (`id`,`identify`,`type`,`facePath`,`coordinates`,`timeStamp`) VALUES (nullif(?, 0),?,?,?,?,?)";
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 g(String str, SQLiteConnection _connection) {
        kotlin.jvm.internal.g0.p(_connection, "_connection");
        SQLiteStatement prepare = _connection.prepare(str);
        try {
            prepare.step();
            prepare.close();
            return n1.f44123a;
        } catch (Throwable th) {
            prepare.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 h(String str, String str2, SQLiteConnection _connection) {
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
    public static final List i(String str, String str2, SQLiteConnection _connection) {
        kotlin.jvm.internal.g0.p(_connection, "_connection");
        SQLiteStatement prepare = _connection.prepare(str);
        try {
            prepare.mo40bindText(1, str2);
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "id");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "identify");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "type");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "facePath");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "coordinates");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "timeStamp");
            ArrayList arrayList = new ArrayList();
            while (prepare.step()) {
                arrayList.add(new m0.b(prepare.getLong(columnIndexOrThrow), prepare.getText(columnIndexOrThrow2), prepare.getText(columnIndexOrThrow3), prepare.getText(columnIndexOrThrow4), prepare.isNull(columnIndexOrThrow5) ? null : prepare.getText(columnIndexOrThrow5), prepare.isNull(columnIndexOrThrow6) ? null : prepare.getText(columnIndexOrThrow6)));
            }
            return arrayList;
        } finally {
            prepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 j(FaceDao_Impl faceDao_Impl, m0.b bVar, SQLiteConnection _connection) {
        kotlin.jvm.internal.g0.p(_connection, "_connection");
        faceDao_Impl.f20715b.insert(_connection, (SQLiteConnection) bVar);
        return n1.f44123a;
    }

    @Override // com.bxkj.student.v2.common.db.dao.g
    @Nullable
    public Object a(@NotNull kotlin.coroutines.e<? super n1> eVar) {
        final String str = "DELETE FROM face";
        Object performSuspending = DBUtil.performSuspending(this.f20714a, false, true, new Function1() { // from class: com.bxkj.student.v2.common.db.dao.i
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 g6;
                g6 = FaceDao_Impl.g(str, (SQLiteConnection) obj);
                return g6;
            }
        }, eVar);
        return performSuspending == kotlin.coroutines.intrinsics.a.l() ? performSuspending : n1.f44123a;
    }

    @Override // com.bxkj.student.v2.common.db.dao.g
    @Nullable
    public Object b(@NotNull final String str, @NotNull kotlin.coroutines.e<? super List<m0.b>> eVar) {
        final String str2 = "SELECT * FROM face WHERE identify=?";
        return DBUtil.performSuspending(this.f20714a, true, false, new Function1() { // from class: com.bxkj.student.v2.common.db.dao.h
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                List i6;
                i6 = FaceDao_Impl.i(str2, str, (SQLiteConnection) obj);
                return i6;
            }
        }, eVar);
    }

    @Override // com.bxkj.student.v2.common.db.dao.g
    @Nullable
    public Object deleteByIdentify(@NotNull final String str, @NotNull kotlin.coroutines.e<? super n1> eVar) {
        final String str2 = "DELETE FROM face WHERE identify=?";
        Object performSuspending = DBUtil.performSuspending(this.f20714a, false, true, new Function1() { // from class: com.bxkj.student.v2.common.db.dao.j
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 h6;
                h6 = FaceDao_Impl.h(str2, str, (SQLiteConnection) obj);
                return h6;
            }
        }, eVar);
        return performSuspending == kotlin.coroutines.intrinsics.a.l() ? performSuspending : n1.f44123a;
    }

    @Override // com.bxkj.student.v2.common.db.dao.g
    @Nullable
    public Object insert(@NotNull final m0.b bVar, @NotNull kotlin.coroutines.e<? super n1> eVar) {
        Object performSuspending = DBUtil.performSuspending(this.f20714a, false, true, new Function1() { // from class: com.bxkj.student.v2.common.db.dao.k
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 j6;
                j6 = FaceDao_Impl.j(FaceDao_Impl.this, bVar, (SQLiteConnection) obj);
                return j6;
            }
        }, eVar);
        return performSuspending == kotlin.coroutines.intrinsics.a.l() ? performSuspending : n1.f44123a;
    }
}
