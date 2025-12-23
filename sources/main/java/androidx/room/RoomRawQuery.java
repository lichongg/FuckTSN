package androidx.room;

import androidx.sqlite.SQLiteStatement;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.g0;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class RoomRawQuery {

    @NotNull
    private final Function1<SQLiteStatement, n1> bindingFunction;

    @NotNull
    private final String sql;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RoomRawQuery(@NotNull String sql) {
        this(sql, null, 2, 0 == true ? 1 : 0);
        g0.p(sql, "sql");
    }

    @JvmOverloads
    public RoomRawQuery(@NotNull String sql, @NotNull final Function1<? super SQLiteStatement, n1> onBindStatement) {
        g0.p(sql, "sql");
        g0.p(onBindStatement, "onBindStatement");
        this.sql = sql;
        this.bindingFunction = new Function1() { // from class: androidx.room.p
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 bindingFunction$lambda$1;
                bindingFunction$lambda$1 = RoomRawQuery.bindingFunction$lambda$1(Function1.this, (SQLiteStatement) obj);
                return bindingFunction$lambda$1;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 _init_$lambda$0(SQLiteStatement it) {
        g0.p(it, "it");
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 bindingFunction$lambda$1(Function1 function1, SQLiteStatement it) {
        g0.p(it, "it");
        function1.invoke(new BindOnlySQLiteStatement(it));
        return n1.f44123a;
    }

    @NotNull
    public final Function1<SQLiteStatement, n1> getBindingFunction() {
        return this.bindingFunction;
    }

    @NotNull
    public final String getSql() {
        return this.sql;
    }

    public /* synthetic */ RoomRawQuery(String str, Function1 function1, int i6, kotlin.jvm.internal.v vVar) {
        this(str, (i6 & 2) != 0 ? new Function1() { // from class: androidx.room.q
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 _init_$lambda$0;
                _init_$lambda$0 = RoomRawQuery._init_$lambda$0((SQLiteStatement) obj);
                return _init_$lambda$0;
            }
        } : function1);
    }
}
