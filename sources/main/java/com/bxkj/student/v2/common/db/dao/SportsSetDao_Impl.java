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
public final class SportsSetDao_Impl implements q0 {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f20722c = new a(null);

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final RoomDatabase f20723a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final EntityInsertAdapter<m0.e> f20724b;

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

    public SportsSetDao_Impl(@NotNull RoomDatabase __db) {
        kotlin.jvm.internal.g0.p(__db, "__db");
        this.f20723a = __db;
        this.f20724b = new EntityInsertAdapter<m0.e>() { // from class: com.bxkj.student.v2.common.db.dao.SportsSetDao_Impl.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertAdapter
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void bind(SQLiteStatement statement, m0.e entity) {
                kotlin.jvm.internal.g0.p(statement, "statement");
                kotlin.jvm.internal.g0.p(entity, "entity");
                statement.mo40bindText(1, entity.g());
                statement.mo40bindText(2, entity.getType());
                statement.mo40bindText(3, entity.f());
            }

            @Override // androidx.room.EntityInsertAdapter
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `sports_set` (`userId`,`type`,`content`) VALUES (?,?,?)";
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List e(String str, String str2, String str3, SQLiteConnection _connection) {
        kotlin.jvm.internal.g0.p(_connection, "_connection");
        SQLiteStatement prepare = _connection.prepare(str);
        try {
            prepare.mo40bindText(1, str2);
            prepare.mo40bindText(2, str3);
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "userId");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "type");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "content");
            ArrayList arrayList = new ArrayList();
            while (prepare.step()) {
                arrayList.add(new m0.e(prepare.getText(columnIndexOrThrow), prepare.getText(columnIndexOrThrow2), prepare.getText(columnIndexOrThrow3)));
            }
            return arrayList;
        } finally {
            prepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 f(SportsSetDao_Impl sportsSetDao_Impl, m0.e eVar, SQLiteConnection _connection) {
        kotlin.jvm.internal.g0.p(_connection, "_connection");
        sportsSetDao_Impl.f20724b.insert(_connection, (SQLiteConnection) eVar);
        return n1.f44123a;
    }

    @Override // com.bxkj.student.v2.common.db.dao.q0
    @Nullable
    public Object a(@NotNull final String str, @NotNull final String str2, @NotNull kotlin.coroutines.e<? super List<m0.e>> eVar) {
        final String str3 = "SELECT * FROM sports_set WHERE userId = ? AND type =?";
        return DBUtil.performSuspending(this.f20723a, true, false, new Function1() { // from class: com.bxkj.student.v2.common.db.dao.r0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                List e6;
                e6 = SportsSetDao_Impl.e(str3, str, str2, (SQLiteConnection) obj);
                return e6;
            }
        }, eVar);
    }

    @Override // com.bxkj.student.v2.common.db.dao.q0
    @Nullable
    public Object insert(@NotNull final m0.e eVar, @NotNull kotlin.coroutines.e<? super n1> eVar2) {
        Object performSuspending = DBUtil.performSuspending(this.f20723a, false, true, new Function1() { // from class: com.bxkj.student.v2.common.db.dao.s0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 f6;
                f6 = SportsSetDao_Impl.f(SportsSetDao_Impl.this, eVar, (SQLiteConnection) obj);
                return f6;
            }
        }, eVar2);
        return performSuspending == kotlin.coroutines.intrinsics.a.l() ? performSuspending : n1.f44123a;
    }

    @Override // com.bxkj.student.v2.common.db.dao.q0
    @Nullable
    public Object b(@NotNull String str, @NotNull kotlin.coroutines.e<? super String> eVar) {
        return p0.a(this, str, eVar);
    }
}
