package androidx.room.paging;

import android.database.Cursor;
import androidx.annotation.RestrictTo;
import androidx.sqlite.SQLiteStatement;
import f.a;
import java.util.List;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: D:\Downloads\app\classes.dex */
public final class CursorSQLiteStatement implements SQLiteStatement {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private final Cursor cursor;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Companion {
        public /* synthetic */ Companion(v vVar) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int getDataType(Cursor cursor, int i6) {
            int type = cursor.getType(i6);
            int type2 = cursor.getType(i6);
            if (type2 != 0) {
                int i7 = 1;
                if (type2 != 1) {
                    i7 = 2;
                    if (type2 != 2) {
                        i7 = 3;
                        if (type2 != 3) {
                            if (type2 == 4) {
                                return 4;
                            }
                            throw new IllegalStateException(("Unknown field type: " + type).toString());
                        }
                    }
                }
                return i7;
            }
            return 5;
        }
    }

    public CursorSQLiteStatement(@NotNull Cursor cursor) {
        g0.p(cursor, "cursor");
        this.cursor = cursor;
    }

    @Override // androidx.sqlite.SQLiteStatement
    @NotNull
    /* renamed from: bindBlob, reason: merged with bridge method [inline-methods] */
    public Void mo36bindBlob(int i6, @NotNull byte[] value) {
        g0.p(value, "value");
        throw new IllegalStateException("Only get*() calls are allowed on a Cursor backed SQLiteStatement");
    }

    @Override // androidx.sqlite.SQLiteStatement
    @NotNull
    /* renamed from: bindDouble, reason: merged with bridge method [inline-methods] */
    public Void mo37bindDouble(int i6, double d6) {
        throw new IllegalStateException("Only get*() calls are allowed on a Cursor backed SQLiteStatement");
    }

    @Override // androidx.sqlite.SQLiteStatement
    @NotNull
    /* renamed from: bindLong, reason: merged with bridge method [inline-methods] */
    public Void mo38bindLong(int i6, long j6) {
        throw new IllegalStateException("Only get*() calls are allowed on a Cursor backed SQLiteStatement");
    }

    @Override // androidx.sqlite.SQLiteStatement
    @NotNull
    /* renamed from: bindNull, reason: merged with bridge method [inline-methods] */
    public Void mo39bindNull(int i6) {
        throw new IllegalStateException("Only get*() calls are allowed on a Cursor backed SQLiteStatement");
    }

    @Override // androidx.sqlite.SQLiteStatement
    @NotNull
    /* renamed from: bindText, reason: merged with bridge method [inline-methods] */
    public Void mo40bindText(int i6, @NotNull String value) {
        g0.p(value, "value");
        throw new IllegalStateException("Only get*() calls are allowed on a Cursor backed SQLiteStatement");
    }

    @Override // androidx.sqlite.SQLiteStatement
    @NotNull
    /* renamed from: clearBindings, reason: merged with bridge method [inline-methods] */
    public Void mo41clearBindings() {
        throw new IllegalStateException("Only get*() calls are allowed on a Cursor backed SQLiteStatement");
    }

    @Override // androidx.sqlite.SQLiteStatement, java.lang.AutoCloseable
    public void close() {
        this.cursor.close();
    }

    @Override // androidx.sqlite.SQLiteStatement
    @NotNull
    public byte[] getBlob(int i6) {
        byte[] blob = this.cursor.getBlob(i6);
        g0.o(blob, "getBlob(...)");
        return blob;
    }

    @Override // androidx.sqlite.SQLiteStatement
    public int getColumnCount() {
        return this.cursor.getColumnCount();
    }

    @Override // androidx.sqlite.SQLiteStatement
    @NotNull
    public String getColumnName(int i6) {
        String columnName = this.cursor.getColumnName(i6);
        g0.o(columnName, "getColumnName(...)");
        return columnName;
    }

    @Override // androidx.sqlite.SQLiteStatement
    public int getColumnType(int i6) {
        return Companion.getDataType(this.cursor, i6);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public double getDouble(int i6) {
        return this.cursor.getDouble(i6);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public long getLong(int i6) {
        return this.cursor.getLong(i6);
    }

    @Override // androidx.sqlite.SQLiteStatement
    @NotNull
    public String getText(int i6) {
        String string = this.cursor.getString(i6);
        g0.o(string, "getString(...)");
        return string;
    }

    @Override // androidx.sqlite.SQLiteStatement
    public boolean isNull(int i6) {
        return this.cursor.isNull(i6);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public void reset() {
        this.cursor.moveToPosition(-1);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public boolean step() {
        return this.cursor.moveToNext();
    }

    @Override // androidx.sqlite.SQLiteStatement
    public /* synthetic */ void bindBoolean(int i6, boolean z5) {
        a.a(this, i6, z5);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public /* synthetic */ void bindFloat(int i6, float f6) {
        a.b(this, i6, f6);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public /* synthetic */ void bindInt(int i6, int i7) {
        a.c(this, i6, i7);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public /* synthetic */ boolean getBoolean(int i6) {
        return a.d(this, i6);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public /* synthetic */ List getColumnNames() {
        return a.e(this);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public /* synthetic */ float getFloat(int i6) {
        return a.f(this, i6);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public /* synthetic */ int getInt(int i6) {
        return a.g(this, i6);
    }
}
