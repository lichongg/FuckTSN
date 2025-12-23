package com.bxkj.student.v2.common.db.dao;

import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteConnectionUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class MenuDao_Impl implements l {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f20716c = new a(null);

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final RoomDatabase f20717a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final EntityInsertAdapter<m0.c> f20718b;

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

    public MenuDao_Impl(@NotNull RoomDatabase __db) {
        kotlin.jvm.internal.g0.p(__db, "__db");
        this.f20717a = __db;
        this.f20718b = new EntityInsertAdapter<m0.c>() { // from class: com.bxkj.student.v2.common.db.dao.MenuDao_Impl.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertAdapter
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void bind(SQLiteStatement statement, m0.c entity) {
                kotlin.jvm.internal.g0.p(statement, "statement");
                kotlin.jvm.internal.g0.p(entity, "entity");
                statement.mo40bindText(1, entity.v());
                statement.mo40bindText(2, entity.w());
                statement.mo40bindText(3, entity.r());
                statement.mo40bindText(4, entity.s());
                statement.mo40bindText(5, entity.A());
                statement.mo40bindText(6, entity.y());
                statement.mo38bindLong(7, entity.z());
                statement.mo40bindText(8, entity.u());
                statement.mo40bindText(9, entity.getType());
                statement.mo40bindText(10, entity.t());
                statement.mo40bindText(11, entity.x());
                statement.mo40bindText(12, entity.C());
                statement.mo40bindText(13, entity.q());
                statement.mo40bindText(14, entity.B());
            }

            @Override // androidx.room.EntityInsertAdapter
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `menu` (`mkey`,`name`,`icon`,`iconS`,`isShow`,`isEnabled`,`isLogin`,`linkUrl`,`type`,`lastUploadTime`,`sort`,`isShowIndex`,`homeSort`,`isShowH5Title`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List A(String str, SQLiteConnection _connection) {
        kotlin.jvm.internal.g0.p(_connection, "_connection");
        SQLiteStatement prepare = _connection.prepare(str);
        try {
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "mkey");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, CommonNetImpl.NAME);
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "icon");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "iconS");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "isShow");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "isEnabled");
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "isLogin");
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "linkUrl");
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "type");
            int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "lastUploadTime");
            int columnIndexOrThrow11 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "sort");
            int columnIndexOrThrow12 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "isShowIndex");
            int columnIndexOrThrow13 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "homeSort");
            int columnIndexOrThrow14 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "isShowH5Title");
            ArrayList arrayList = new ArrayList();
            while (prepare.step()) {
                int i6 = columnIndexOrThrow2;
                int i7 = columnIndexOrThrow3;
                arrayList.add(new m0.c(prepare.getText(columnIndexOrThrow), prepare.getText(columnIndexOrThrow2), prepare.getText(columnIndexOrThrow3), prepare.getText(columnIndexOrThrow4), prepare.getText(columnIndexOrThrow5), prepare.getText(columnIndexOrThrow6), (int) prepare.getLong(columnIndexOrThrow7), prepare.getText(columnIndexOrThrow8), prepare.getText(columnIndexOrThrow9), prepare.getText(columnIndexOrThrow10), prepare.getText(columnIndexOrThrow11), prepare.getText(columnIndexOrThrow12), prepare.getText(columnIndexOrThrow13), prepare.getText(columnIndexOrThrow14)));
                columnIndexOrThrow2 = i6;
                columnIndexOrThrow3 = i7;
            }
            return arrayList;
        } finally {
            prepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List B(String str, String str2, SQLiteConnection _connection) {
        kotlin.jvm.internal.g0.p(_connection, "_connection");
        SQLiteStatement prepare = _connection.prepare(str);
        try {
            prepare.mo40bindText(1, str2);
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "mkey");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, CommonNetImpl.NAME);
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "icon");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "iconS");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "isShow");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "isEnabled");
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "isLogin");
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "linkUrl");
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "type");
            int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "lastUploadTime");
            int columnIndexOrThrow11 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "sort");
            int columnIndexOrThrow12 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "isShowIndex");
            int columnIndexOrThrow13 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "homeSort");
            int columnIndexOrThrow14 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "isShowH5Title");
            ArrayList arrayList = new ArrayList();
            while (prepare.step()) {
                int i6 = columnIndexOrThrow2;
                int i7 = columnIndexOrThrow3;
                arrayList.add(new m0.c(prepare.getText(columnIndexOrThrow), prepare.getText(columnIndexOrThrow2), prepare.getText(columnIndexOrThrow3), prepare.getText(columnIndexOrThrow4), prepare.getText(columnIndexOrThrow5), prepare.getText(columnIndexOrThrow6), (int) prepare.getLong(columnIndexOrThrow7), prepare.getText(columnIndexOrThrow8), prepare.getText(columnIndexOrThrow9), prepare.getText(columnIndexOrThrow10), prepare.getText(columnIndexOrThrow11), prepare.getText(columnIndexOrThrow12), prepare.getText(columnIndexOrThrow13), prepare.getText(columnIndexOrThrow14)));
                columnIndexOrThrow2 = i6;
                columnIndexOrThrow3 = i7;
            }
            return arrayList;
        } finally {
            prepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List C(String str, String str2, SQLiteConnection _connection) {
        kotlin.jvm.internal.g0.p(_connection, "_connection");
        SQLiteStatement prepare = _connection.prepare(str);
        try {
            prepare.mo40bindText(1, str2);
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "mkey");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, CommonNetImpl.NAME);
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "icon");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "iconS");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "isShow");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "isEnabled");
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "isLogin");
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "linkUrl");
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "type");
            int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "lastUploadTime");
            int columnIndexOrThrow11 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "sort");
            int columnIndexOrThrow12 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "isShowIndex");
            int columnIndexOrThrow13 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "homeSort");
            int columnIndexOrThrow14 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "isShowH5Title");
            ArrayList arrayList = new ArrayList();
            while (prepare.step()) {
                int i6 = columnIndexOrThrow2;
                int i7 = columnIndexOrThrow3;
                arrayList.add(new m0.c(prepare.getText(columnIndexOrThrow), prepare.getText(columnIndexOrThrow2), prepare.getText(columnIndexOrThrow3), prepare.getText(columnIndexOrThrow4), prepare.getText(columnIndexOrThrow5), prepare.getText(columnIndexOrThrow6), (int) prepare.getLong(columnIndexOrThrow7), prepare.getText(columnIndexOrThrow8), prepare.getText(columnIndexOrThrow9), prepare.getText(columnIndexOrThrow10), prepare.getText(columnIndexOrThrow11), prepare.getText(columnIndexOrThrow12), prepare.getText(columnIndexOrThrow13), prepare.getText(columnIndexOrThrow14)));
                columnIndexOrThrow2 = i6;
                columnIndexOrThrow3 = i7;
            }
            return arrayList;
        } finally {
            prepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 D(MenuDao_Impl menuDao_Impl, m0.c[] cVarArr, SQLiteConnection _connection) {
        kotlin.jvm.internal.g0.p(_connection, "_connection");
        menuDao_Impl.f20718b.insert(_connection, cVarArr);
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 E(String str, String str2, String str3, SQLiteConnection _connection) {
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
    public static final n1 F(String str, String str2, String str3, SQLiteConnection _connection) {
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
    public static final n1 G(String str, String str2, String str3, SQLiteConnection _connection) {
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
    public static final n1 w(String str, SQLiteConnection _connection) {
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
    public static final n1 x(String str, String str2, SQLiteConnection _connection) {
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
    public static final int y(String str, int i6, SQLiteConnection _connection) {
        kotlin.jvm.internal.g0.p(_connection, "_connection");
        SQLiteStatement prepare = _connection.prepare(str);
        try {
            prepare.mo38bindLong(1, i6);
            prepare.step();
            return SQLiteConnectionUtil.getTotalChangedRows(_connection);
        } finally {
            prepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List z(String str, SQLiteConnection _connection) {
        kotlin.jvm.internal.g0.p(_connection, "_connection");
        SQLiteStatement prepare = _connection.prepare(str);
        try {
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "mkey");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, CommonNetImpl.NAME);
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "icon");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "iconS");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "isShow");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "isEnabled");
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "isLogin");
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "linkUrl");
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "type");
            int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "lastUploadTime");
            int columnIndexOrThrow11 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "sort");
            int columnIndexOrThrow12 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "isShowIndex");
            int columnIndexOrThrow13 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "homeSort");
            int columnIndexOrThrow14 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "isShowH5Title");
            ArrayList arrayList = new ArrayList();
            while (prepare.step()) {
                int i6 = columnIndexOrThrow2;
                int i7 = columnIndexOrThrow3;
                arrayList.add(new m0.c(prepare.getText(columnIndexOrThrow), prepare.getText(columnIndexOrThrow2), prepare.getText(columnIndexOrThrow3), prepare.getText(columnIndexOrThrow4), prepare.getText(columnIndexOrThrow5), prepare.getText(columnIndexOrThrow6), (int) prepare.getLong(columnIndexOrThrow7), prepare.getText(columnIndexOrThrow8), prepare.getText(columnIndexOrThrow9), prepare.getText(columnIndexOrThrow10), prepare.getText(columnIndexOrThrow11), prepare.getText(columnIndexOrThrow12), prepare.getText(columnIndexOrThrow13), prepare.getText(columnIndexOrThrow14)));
                columnIndexOrThrow2 = i6;
                columnIndexOrThrow3 = i7;
            }
            return arrayList;
        } finally {
            prepare.close();
        }
    }

    @Override // com.bxkj.student.v2.common.db.dao.l
    @Nullable
    public Object a(@NotNull kotlin.coroutines.e<? super n1> eVar) {
        final String str = "DELETE FROM menu";
        Object performSuspending = DBUtil.performSuspending(this.f20717a, false, true, new Function1() { // from class: com.bxkj.student.v2.common.db.dao.s
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 w5;
                w5 = MenuDao_Impl.w(str, (SQLiteConnection) obj);
                return w5;
            }
        }, eVar);
        return performSuspending == kotlin.coroutines.intrinsics.a.l() ? performSuspending : n1.f44123a;
    }

    @Override // com.bxkj.student.v2.common.db.dao.l
    @Nullable
    public Object b(@NotNull final String str, @NotNull final String str2, @NotNull kotlin.coroutines.e<? super n1> eVar) {
        final String str3 = "UPDATE menu SET iconS=? WHERE mkey=?";
        Object performSuspending = DBUtil.performSuspending(this.f20717a, false, true, new Function1() { // from class: com.bxkj.student.v2.common.db.dao.o
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 F;
                F = MenuDao_Impl.F(str3, str, str2, (SQLiteConnection) obj);
                return F;
            }
        }, eVar);
        return performSuspending == kotlin.coroutines.intrinsics.a.l() ? performSuspending : n1.f44123a;
    }

    @Override // com.bxkj.student.v2.common.db.dao.l
    @Nullable
    public Object c(@NotNull final String str, @NotNull final String str2, @NotNull kotlin.coroutines.e<? super n1> eVar) {
        final String str3 = "UPDATE menu SET type=? WHERE mkey=?";
        Object performSuspending = DBUtil.performSuspending(this.f20717a, false, true, new Function1() { // from class: com.bxkj.student.v2.common.db.dao.r
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 G;
                G = MenuDao_Impl.G(str3, str, str2, (SQLiteConnection) obj);
                return G;
            }
        }, eVar);
        return performSuspending == kotlin.coroutines.intrinsics.a.l() ? performSuspending : n1.f44123a;
    }

    @Override // com.bxkj.student.v2.common.db.dao.l
    @Nullable
    public Object d(final int i6, @NotNull kotlin.coroutines.e<? super Integer> eVar) {
        final String str = "DELETE  FROM menu WHERE type=?";
        return DBUtil.performSuspending(this.f20717a, false, true, new Function1() { // from class: com.bxkj.student.v2.common.db.dao.u
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                int y5;
                y5 = MenuDao_Impl.y(str, i6, (SQLiteConnection) obj);
                return Integer.valueOf(y5);
            }
        }, eVar);
    }

    @Override // com.bxkj.student.v2.common.db.dao.l
    @Nullable
    public Object e(@NotNull kotlin.coroutines.e<? super List<m0.c>> eVar) {
        final String str = "SELECT * FROM menu WHERE isShowIndex='1' Order By cast(homeSort as INTEGER)";
        return DBUtil.performSuspending(this.f20717a, true, false, new Function1() { // from class: com.bxkj.student.v2.common.db.dao.p
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                List A;
                A = MenuDao_Impl.A(str, (SQLiteConnection) obj);
                return A;
            }
        }, eVar);
    }

    @Override // com.bxkj.student.v2.common.db.dao.l
    @Nullable
    public Object f(@NotNull kotlin.coroutines.e<? super List<m0.c>> eVar) {
        final String str = "SELECT * FROM menu";
        return DBUtil.performSuspending(this.f20717a, true, false, new Function1() { // from class: com.bxkj.student.v2.common.db.dao.q
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                List z5;
                z5 = MenuDao_Impl.z(str, (SQLiteConnection) obj);
                return z5;
            }
        }, eVar);
    }

    @Override // com.bxkj.student.v2.common.db.dao.l
    @Nullable
    public Object g(@NotNull final String str, @NotNull kotlin.coroutines.e<? super n1> eVar) {
        final String str2 = "DELETE FROM menu WHERE mkey=?";
        Object performSuspending = DBUtil.performSuspending(this.f20717a, false, true, new Function1() { // from class: com.bxkj.student.v2.common.db.dao.n
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 x5;
                x5 = MenuDao_Impl.x(str2, str, (SQLiteConnection) obj);
                return x5;
            }
        }, eVar);
        return performSuspending == kotlin.coroutines.intrinsics.a.l() ? performSuspending : n1.f44123a;
    }

    @Override // com.bxkj.student.v2.common.db.dao.l
    @Nullable
    public Object h(@NotNull final String str, @NotNull kotlin.coroutines.e<? super List<m0.c>> eVar) {
        final String str2 = "SELECT * FROM menu WHERE mkey=?";
        return DBUtil.performSuspending(this.f20717a, true, false, new Function1() { // from class: com.bxkj.student.v2.common.db.dao.t
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                List B;
                B = MenuDao_Impl.B(str2, str, (SQLiteConnection) obj);
                return B;
            }
        }, eVar);
    }

    @Override // com.bxkj.student.v2.common.db.dao.l
    @Nullable
    public Object i(@NotNull final String str, @NotNull final String str2, @NotNull kotlin.coroutines.e<? super n1> eVar) {
        final String str3 = "UPDATE menu SET icon=? WHERE mkey=?";
        Object performSuspending = DBUtil.performSuspending(this.f20717a, false, true, new Function1() { // from class: com.bxkj.student.v2.common.db.dao.m
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 E;
                E = MenuDao_Impl.E(str3, str, str2, (SQLiteConnection) obj);
                return E;
            }
        }, eVar);
        return performSuspending == kotlin.coroutines.intrinsics.a.l() ? performSuspending : n1.f44123a;
    }

    @Override // com.bxkj.student.v2.common.db.dao.l
    @Nullable
    public Object j(@NotNull final String str, @NotNull kotlin.coroutines.e<? super List<m0.c>> eVar) {
        final String str2 = "SELECT * FROM menu WHERE type=? Order By cast(sort as INTEGER)";
        return DBUtil.performSuspending(this.f20717a, true, false, new Function1() { // from class: com.bxkj.student.v2.common.db.dao.w
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                List C;
                C = MenuDao_Impl.C(str2, str, (SQLiteConnection) obj);
                return C;
            }
        }, eVar);
    }

    @Override // com.bxkj.student.v2.common.db.dao.l
    @Nullable
    public Object k(@NotNull final m0.c[] cVarArr, @NotNull kotlin.coroutines.e<? super n1> eVar) {
        Object performSuspending = DBUtil.performSuspending(this.f20717a, false, true, new Function1() { // from class: com.bxkj.student.v2.common.db.dao.v
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 D;
                D = MenuDao_Impl.D(MenuDao_Impl.this, cVarArr, (SQLiteConnection) obj);
                return D;
            }
        }, eVar);
        return performSuspending == kotlin.coroutines.intrinsics.a.l() ? performSuspending : n1.f44123a;
    }
}
