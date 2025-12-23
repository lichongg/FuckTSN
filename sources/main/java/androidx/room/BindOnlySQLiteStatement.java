package androidx.room;

import androidx.annotation.IntRange;
import androidx.sqlite.SQLiteStatement;
import java.util.List;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
final class BindOnlySQLiteStatement implements SQLiteStatement {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final String ONLY_BIND_CALLS_ALLOWED_ERROR = "Only bind*() calls are allowed on the RoomRawQuery received statement.";
    private final /* synthetic */ SQLiteStatement $$delegate_0;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.v vVar) {
            this();
        }

        private Companion() {
        }
    }

    public BindOnlySQLiteStatement(@NotNull SQLiteStatement delegate) {
        g0.p(delegate, "delegate");
        this.$$delegate_0 = delegate;
    }

    @Override // androidx.sqlite.SQLiteStatement
    public void bindBoolean(@IntRange(from = 1) int i6, boolean z5) {
        this.$$delegate_0.bindBoolean(i6, z5);
    }

    @Override // androidx.sqlite.SQLiteStatement
    /* renamed from: bindDouble */
    public void mo37bindDouble(@IntRange(from = 1) int i6, double d6) {
        this.$$delegate_0.mo37bindDouble(i6, d6);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public void bindFloat(@IntRange(from = 1) int i6, float f6) {
        this.$$delegate_0.bindFloat(i6, f6);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public void bindInt(@IntRange(from = 1) int i6, int i7) {
        this.$$delegate_0.bindInt(i6, i7);
    }

    @Override // androidx.sqlite.SQLiteStatement
    /* renamed from: bindLong */
    public void mo38bindLong(@IntRange(from = 1) int i6, long j6) {
        this.$$delegate_0.mo38bindLong(i6, j6);
    }

    @Override // androidx.sqlite.SQLiteStatement
    /* renamed from: bindNull */
    public void mo39bindNull(@IntRange(from = 1) int i6) {
        this.$$delegate_0.mo39bindNull(i6);
    }

    @Override // androidx.sqlite.SQLiteStatement
    /* renamed from: clearBindings */
    public void mo41clearBindings() {
        this.$$delegate_0.mo41clearBindings();
    }

    @Override // androidx.sqlite.SQLiteStatement, java.lang.AutoCloseable
    public void close() {
        throw new IllegalStateException(ONLY_BIND_CALLS_ALLOWED_ERROR);
    }

    @Override // androidx.sqlite.SQLiteStatement
    @NotNull
    public byte[] getBlob(int i6) {
        throw new IllegalStateException(ONLY_BIND_CALLS_ALLOWED_ERROR);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public boolean getBoolean(@IntRange(from = 0) int i6) {
        return this.$$delegate_0.getBoolean(i6);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public int getColumnCount() {
        throw new IllegalStateException(ONLY_BIND_CALLS_ALLOWED_ERROR);
    }

    @Override // androidx.sqlite.SQLiteStatement
    @NotNull
    public String getColumnName(int i6) {
        throw new IllegalStateException(ONLY_BIND_CALLS_ALLOWED_ERROR);
    }

    @Override // androidx.sqlite.SQLiteStatement
    @NotNull
    public List<String> getColumnNames() {
        return this.$$delegate_0.getColumnNames();
    }

    @Override // androidx.sqlite.SQLiteStatement
    public int getColumnType(int i6) {
        throw new IllegalStateException(ONLY_BIND_CALLS_ALLOWED_ERROR);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public double getDouble(int i6) {
        throw new IllegalStateException(ONLY_BIND_CALLS_ALLOWED_ERROR);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public float getFloat(@IntRange(from = 0) int i6) {
        return this.$$delegate_0.getFloat(i6);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public int getInt(@IntRange(from = 0) int i6) {
        return this.$$delegate_0.getInt(i6);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public long getLong(int i6) {
        throw new IllegalStateException(ONLY_BIND_CALLS_ALLOWED_ERROR);
    }

    @Override // androidx.sqlite.SQLiteStatement
    @NotNull
    public String getText(int i6) {
        throw new IllegalStateException(ONLY_BIND_CALLS_ALLOWED_ERROR);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public boolean isNull(int i6) {
        throw new IllegalStateException(ONLY_BIND_CALLS_ALLOWED_ERROR);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public void reset() {
        throw new IllegalStateException(ONLY_BIND_CALLS_ALLOWED_ERROR);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public boolean step() {
        throw new IllegalStateException(ONLY_BIND_CALLS_ALLOWED_ERROR);
    }

    @Override // androidx.sqlite.SQLiteStatement
    /* renamed from: bindBlob */
    public void mo36bindBlob(@IntRange(from = 1) int i6, @NotNull byte[] value) {
        g0.p(value, "value");
        this.$$delegate_0.mo36bindBlob(i6, value);
    }

    @Override // androidx.sqlite.SQLiteStatement
    /* renamed from: bindText */
    public void mo40bindText(@IntRange(from = 1) int i6, @NotNull String value) {
        g0.p(value, "value");
        this.$$delegate_0.mo40bindText(i6, value);
    }
}
