package com.bxkj.student.v2.common.db.dao;

import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteConnectionUtil;
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
public final class EnvironmentDao_Impl implements b {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f20710c = new a(null);

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final RoomDatabase f20711a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final EntityInsertAdapter<m0.a> f20712b;

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

    public EnvironmentDao_Impl(@NotNull RoomDatabase __db) {
        kotlin.jvm.internal.g0.p(__db, "__db");
        this.f20711a = __db;
        this.f20712b = new EntityInsertAdapter<m0.a>() { // from class: com.bxkj.student.v2.common.db.dao.EnvironmentDao_Impl.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertAdapter
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void bind(SQLiteStatement statement, m0.a entity) {
                kotlin.jvm.internal.g0.p(statement, "statement");
                kotlin.jvm.internal.g0.p(entity, "entity");
                statement.mo40bindText(1, entity.f());
                String h6 = entity.h();
                if (h6 == null) {
                    statement.mo39bindNull(2);
                } else {
                    statement.mo40bindText(2, h6);
                }
                String g6 = entity.g();
                if (g6 == null) {
                    statement.mo39bindNull(3);
                } else {
                    statement.mo40bindText(3, g6);
                }
            }

            @Override // androidx.room.EntityInsertAdapter
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `environment` (`deviceId`,`safe`,`oppo`) VALUES (?,?,?)";
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List k(String str, String str2, SQLiteConnection _connection) {
        kotlin.jvm.internal.g0.p(_connection, "_connection");
        SQLiteStatement prepare = _connection.prepare(str);
        try {
            prepare.mo40bindText(1, str2);
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "deviceId");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "safe");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "oppo");
            ArrayList arrayList = new ArrayList();
            while (prepare.step()) {
                String text = prepare.getText(columnIndexOrThrow);
                String str3 = null;
                String text2 = prepare.isNull(columnIndexOrThrow2) ? null : prepare.getText(columnIndexOrThrow2);
                if (!prepare.isNull(columnIndexOrThrow3)) {
                    str3 = prepare.getText(columnIndexOrThrow3);
                }
                arrayList.add(new m0.a(text, text2, str3));
            }
            return arrayList;
        } finally {
            prepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 l(EnvironmentDao_Impl environmentDao_Impl, m0.a aVar, SQLiteConnection _connection) {
        kotlin.jvm.internal.g0.p(_connection, "_connection");
        environmentDao_Impl.f20712b.insert(_connection, (SQLiteConnection) aVar);
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int m(String str, String str2, String str3, SQLiteConnection _connection) {
        kotlin.jvm.internal.g0.p(_connection, "_connection");
        SQLiteStatement prepare = _connection.prepare(str);
        try {
            prepare.mo40bindText(1, str2);
            prepare.mo40bindText(2, str3);
            prepare.step();
            return SQLiteConnectionUtil.getTotalChangedRows(_connection);
        } finally {
            prepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int n(String str, String str2, String str3, SQLiteConnection _connection) {
        kotlin.jvm.internal.g0.p(_connection, "_connection");
        SQLiteStatement prepare = _connection.prepare(str);
        try {
            prepare.mo40bindText(1, str2);
            prepare.mo40bindText(2, str3);
            prepare.step();
            return SQLiteConnectionUtil.getTotalChangedRows(_connection);
        } finally {
            prepare.close();
        }
    }

    @Override // com.bxkj.student.v2.common.db.dao.b
    @Nullable
    public Object b(@NotNull final String str, @NotNull kotlin.coroutines.e<? super List<m0.a>> eVar) {
        final String str2 = "SELECT * FROM environment WHERE deviceId = ? ";
        return DBUtil.performSuspending(this.f20711a, true, false, new Function1() { // from class: com.bxkj.student.v2.common.db.dao.d
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                List k6;
                k6 = EnvironmentDao_Impl.k(str2, str, (SQLiteConnection) obj);
                return k6;
            }
        }, eVar);
    }

    @Override // com.bxkj.student.v2.common.db.dao.b
    @Nullable
    public Object c(@NotNull final String str, @NotNull final String str2, @NotNull kotlin.coroutines.e<? super Integer> eVar) {
        final String str3 = "UPDATE environment SET oppo = ? WHERE deviceId = ?";
        return DBUtil.performSuspending(this.f20711a, false, true, new Function1() { // from class: com.bxkj.student.v2.common.db.dao.e
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                int m6;
                m6 = EnvironmentDao_Impl.m(str3, str2, str, (SQLiteConnection) obj);
                return Integer.valueOf(m6);
            }
        }, eVar);
    }

    @Override // com.bxkj.student.v2.common.db.dao.b
    @Nullable
    public Object d(@NotNull final String str, @NotNull final String str2, @NotNull kotlin.coroutines.e<? super Integer> eVar) {
        final String str3 = "UPDATE environment SET safe = ? WHERE deviceId = ?";
        return DBUtil.performSuspending(this.f20711a, false, true, new Function1() { // from class: com.bxkj.student.v2.common.db.dao.f
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                int n6;
                n6 = EnvironmentDao_Impl.n(str3, str2, str, (SQLiteConnection) obj);
                return Integer.valueOf(n6);
            }
        }, eVar);
    }

    @Override // com.bxkj.student.v2.common.db.dao.b
    @Nullable
    public Object insert(@NotNull final m0.a aVar, @NotNull kotlin.coroutines.e<? super n1> eVar) {
        Object performSuspending = DBUtil.performSuspending(this.f20711a, false, true, new Function1() { // from class: com.bxkj.student.v2.common.db.dao.c
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 l6;
                l6 = EnvironmentDao_Impl.l(EnvironmentDao_Impl.this, aVar, (SQLiteConnection) obj);
                return l6;
            }
        }, eVar);
        return performSuspending == kotlin.coroutines.intrinsics.a.l() ? performSuspending : n1.f44123a;
    }

    @Override // com.bxkj.student.v2.common.db.dao.b
    @Nullable
    public Object a(@NotNull String str, @NotNull kotlin.coroutines.e<? super n1> eVar) {
        return com.bxkj.student.v2.common.db.dao.a.b(this, str, eVar);
    }

    @Override // com.bxkj.student.v2.common.db.dao.b
    @Nullable
    public Object e(@NotNull String str, @NotNull kotlin.coroutines.e<? super n1> eVar) {
        return com.bxkj.student.v2.common.db.dao.a.c(this, str, eVar);
    }

    @Override // com.bxkj.student.v2.common.db.dao.b
    @Nullable
    public Object f(@NotNull kotlin.coroutines.e<? super m0.a> eVar) {
        return com.bxkj.student.v2.common.db.dao.a.a(this, eVar);
    }
}
