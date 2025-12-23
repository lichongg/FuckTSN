package androidx.room.util;

import androidx.annotation.IntRange;
import androidx.sqlite.SQLiteStatement;
import java.util.List;
import java.util.Map;
import kotlin.collections.i1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nStatementUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StatementUtil.kt\nandroidx/room/util/MappedColumnsSQLiteStatementWrapper\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,112:1\n1#2:113\n13467#3,3:114\n*S KotlinDebug\n*F\n+ 1 StatementUtil.kt\nandroidx/room/util/MappedColumnsSQLiteStatementWrapper\n*L\n99#1:114,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes.dex */
public final class MappedColumnsSQLiteStatementWrapper implements SQLiteStatement {

    @NotNull
    private final Map<String, Integer> columnNameToIndexMap;

    @NotNull
    private final String[] columnNames;

    @NotNull
    private final SQLiteStatement delegate;

    @NotNull
    private final int[] mapping;

    public MappedColumnsSQLiteStatementWrapper(@NotNull SQLiteStatement delegate, @NotNull String[] columnNames, @NotNull int[] mapping) {
        g0.p(delegate, "delegate");
        g0.p(columnNames, "columnNames");
        g0.p(mapping, "mapping");
        this.delegate = delegate;
        this.columnNames = columnNames;
        this.mapping = mapping;
        if (columnNames.length != mapping.length) {
            throw new IllegalArgumentException("Expected columnNames.size == mapping.size");
        }
        Map g6 = i1.g();
        int length = columnNames.length;
        int i6 = 0;
        int i7 = 0;
        while (i6 < length) {
            g6.put(columnNames[i6], Integer.valueOf(this.mapping[i7]));
            i6++;
            i7++;
        }
        int columnCount = getColumnCount();
        for (int i8 = 0; i8 < columnCount; i8++) {
            if (!g6.containsKey(getColumnName(i8))) {
                g6.put(getColumnName(i8), Integer.valueOf(i8));
            }
        }
        this.columnNameToIndexMap = i1.d(g6);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public void bindBoolean(@IntRange(from = 1) int i6, boolean z5) {
        this.delegate.bindBoolean(i6, z5);
    }

    @Override // androidx.sqlite.SQLiteStatement
    /* renamed from: bindDouble */
    public void mo37bindDouble(@IntRange(from = 1) int i6, double d6) {
        this.delegate.mo37bindDouble(i6, d6);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public void bindFloat(@IntRange(from = 1) int i6, float f6) {
        this.delegate.bindFloat(i6, f6);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public void bindInt(@IntRange(from = 1) int i6, int i7) {
        this.delegate.bindInt(i6, i7);
    }

    @Override // androidx.sqlite.SQLiteStatement
    /* renamed from: bindLong */
    public void mo38bindLong(@IntRange(from = 1) int i6, long j6) {
        this.delegate.mo38bindLong(i6, j6);
    }

    @Override // androidx.sqlite.SQLiteStatement
    /* renamed from: bindNull */
    public void mo39bindNull(@IntRange(from = 1) int i6) {
        this.delegate.mo39bindNull(i6);
    }

    @Override // androidx.sqlite.SQLiteStatement
    /* renamed from: clearBindings */
    public void mo41clearBindings() {
        this.delegate.mo41clearBindings();
    }

    @Override // androidx.sqlite.SQLiteStatement, java.lang.AutoCloseable
    public void close() {
        this.delegate.close();
    }

    @Override // androidx.sqlite.SQLiteStatement
    @NotNull
    public byte[] getBlob(@IntRange(from = 0) int i6) {
        return this.delegate.getBlob(i6);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public boolean getBoolean(@IntRange(from = 0) int i6) {
        return this.delegate.getBoolean(i6);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public int getColumnCount() {
        return this.delegate.getColumnCount();
    }

    public final int getColumnIndex(@NotNull String name) {
        g0.p(name, "name");
        Integer num = this.columnNameToIndexMap.get(name);
        if (num != null) {
            return num.intValue();
        }
        return -1;
    }

    @Override // androidx.sqlite.SQLiteStatement
    @NotNull
    public String getColumnName(@IntRange(from = 0) int i6) {
        return this.delegate.getColumnName(i6);
    }

    @Override // androidx.sqlite.SQLiteStatement
    @NotNull
    public List<String> getColumnNames() {
        return this.delegate.getColumnNames();
    }

    @Override // androidx.sqlite.SQLiteStatement
    public int getColumnType(@IntRange(from = 0) int i6) {
        return this.delegate.getColumnType(i6);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public double getDouble(@IntRange(from = 0) int i6) {
        return this.delegate.getDouble(i6);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public float getFloat(@IntRange(from = 0) int i6) {
        return this.delegate.getFloat(i6);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public int getInt(@IntRange(from = 0) int i6) {
        return this.delegate.getInt(i6);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public long getLong(@IntRange(from = 0) int i6) {
        return this.delegate.getLong(i6);
    }

    @Override // androidx.sqlite.SQLiteStatement
    @NotNull
    public String getText(@IntRange(from = 0) int i6) {
        return this.delegate.getText(i6);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public boolean isNull(@IntRange(from = 0) int i6) {
        return this.delegate.isNull(i6);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public void reset() {
        this.delegate.reset();
    }

    @Override // androidx.sqlite.SQLiteStatement
    public boolean step() {
        return this.delegate.step();
    }

    @Override // androidx.sqlite.SQLiteStatement
    /* renamed from: bindBlob */
    public void mo36bindBlob(@IntRange(from = 1) int i6, @NotNull byte[] value) {
        g0.p(value, "value");
        this.delegate.mo36bindBlob(i6, value);
    }

    @Override // androidx.sqlite.SQLiteStatement
    /* renamed from: bindText */
    public void mo40bindText(@IntRange(from = 1) int i6, @NotNull String value) {
        g0.p(value, "value");
        this.delegate.mo40bindText(i6, value);
    }
}
