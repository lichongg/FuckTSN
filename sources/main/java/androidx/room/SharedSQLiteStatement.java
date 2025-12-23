package androidx.room;

import androidx.annotation.RestrictTo;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: D:\Downloads\app\classes.dex */
public abstract class SharedSQLiteStatement {

    @NotNull
    private final RoomDatabase database;

    @NotNull
    private final AtomicBoolean lock;

    @NotNull
    private final kotlin.s stmt$delegate;

    private final SupportSQLiteStatement getStmt() {
        return (SupportSQLiteStatement) this.stmt$delegate.getValue();
    }

    @NotNull
    protected abstract String createQuery();

    public SharedSQLiteStatement(@NotNull RoomDatabase database) {
        g0.p(database, "database");
        this.database = database;
        this.lock = new AtomicBoolean(false);
        this.stmt$delegate = kotlin.t.c(new Function0() { // from class: androidx.room.u
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                SupportSQLiteStatement createNewStatement;
                createNewStatement = SharedSQLiteStatement.this.createNewStatement();
                return createNewStatement;
            }
        });
    }

    private final SupportSQLiteStatement getStmt(boolean z5) {
        return z5 ? getStmt() : createNewStatement();
    }

    protected void assertNotMainThread() {
        this.database.assertNotMainThread();
    }

    public void release(@NotNull SupportSQLiteStatement statement) {
        g0.p(statement, "statement");
        if (statement == getStmt()) {
            this.lock.set(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SupportSQLiteStatement createNewStatement() {
        return this.database.compileStatement(createQuery());
    }

    @NotNull
    public SupportSQLiteStatement acquire() {
        assertNotMainThread();
        return getStmt(this.lock.compareAndSet(false, true));
    }
}
