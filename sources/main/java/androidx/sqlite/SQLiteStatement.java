package androidx.sqlite;

import androidx.annotation.IntRange;
import java.util.List;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nSQLiteStatement.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SQLiteStatement.kt\nandroidx/sqlite/SQLiteStatement\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,233:1\n1#2:234\n*E\n"})
/* loaded from: D:\Downloads\app\classes.dex */
public interface SQLiteStatement extends AutoCloseable {
    /* renamed from: bindBlob */
    void mo36bindBlob(@IntRange(from = 1) int i6, @NotNull byte[] bArr);

    void bindBoolean(@IntRange(from = 1) int i6, boolean z5);

    /* renamed from: bindDouble */
    void mo37bindDouble(@IntRange(from = 1) int i6, double d6);

    void bindFloat(@IntRange(from = 1) int i6, float f6);

    void bindInt(@IntRange(from = 1) int i6, int i7);

    /* renamed from: bindLong */
    void mo38bindLong(@IntRange(from = 1) int i6, long j6);

    /* renamed from: bindNull */
    void mo39bindNull(@IntRange(from = 1) int i6);

    /* renamed from: bindText */
    void mo40bindText(@IntRange(from = 1) int i6, @NotNull String str);

    /* renamed from: clearBindings */
    void mo41clearBindings();

    @Override // java.lang.AutoCloseable
    void close();

    @NotNull
    byte[] getBlob(@IntRange(from = 0) int i6);

    boolean getBoolean(@IntRange(from = 0) int i6);

    int getColumnCount();

    @NotNull
    String getColumnName(@IntRange(from = 0) int i6);

    @NotNull
    List<String> getColumnNames();

    int getColumnType(@IntRange(from = 0) int i6);

    double getDouble(@IntRange(from = 0) int i6);

    float getFloat(@IntRange(from = 0) int i6);

    int getInt(@IntRange(from = 0) int i6);

    long getLong(@IntRange(from = 0) int i6);

    @NotNull
    String getText(@IntRange(from = 0) int i6);

    boolean isNull(@IntRange(from = 0) int i6);

    void reset();

    boolean step();
}
