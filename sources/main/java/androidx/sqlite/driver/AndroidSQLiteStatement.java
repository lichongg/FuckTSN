package androidx.sqlite.driver;

import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteProgram;
import android.database.sqlite.SQLiteQuery;
import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteStatement;
import androidx.sqlite.driver.AndroidSQLiteStatement;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import kotlin.KotlinNothingValueException;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import kotlin.text.u;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public abstract class AndroidSQLiteStatement implements SQLiteStatement {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private final SQLiteDatabase db;
    private boolean isClosed;

    @NotNull
    private final String sql;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Companion {
        public /* synthetic */ Companion(v vVar) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final AndroidSQLiteStatement create(@NotNull SQLiteDatabase db, @NotNull String sql) {
            g0.p(db, "db");
            g0.p(sql, "sql");
            return isRowStatement(sql) ? new SelectAndroidSQLiteStatement(db, sql) : new OtherAndroidSQLiteStatement(db, sql);
        }

        private final boolean isRowStatement(String str) {
            String obj = u.Z5(str).toString();
            if (obj.length() < 3) {
                return false;
            }
            String substring = obj.substring(0, 3);
            g0.o(substring, "substring(...)");
            String upperCase = substring.toUpperCase(Locale.ROOT);
            g0.o(upperCase, "toUpperCase(...)");
            int hashCode = upperCase.hashCode();
            if (hashCode != 79487) {
                if (hashCode != 81978) {
                    if (hashCode == 85954 && upperCase.equals("WIT")) {
                        return true;
                    }
                } else if (upperCase.equals("SEL")) {
                    return true;
                }
            } else if (upperCase.equals("PRA")) {
                return true;
            }
            return false;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class OtherAndroidSQLiteStatement extends AndroidSQLiteStatement {

        @NotNull
        private final android.database.sqlite.SQLiteStatement delegate;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OtherAndroidSQLiteStatement(@NotNull SQLiteDatabase db, @NotNull String sql) {
            super(db, sql, null);
            g0.p(db, "db");
            g0.p(sql, "sql");
            android.database.sqlite.SQLiteStatement compileStatement = db.compileStatement(sql);
            g0.o(compileStatement, "compileStatement(...)");
            this.delegate = compileStatement;
        }

        @Override // androidx.sqlite.SQLiteStatement, java.lang.AutoCloseable
        public void close() {
            this.delegate.close();
            setClosed(true);
        }

        @Override // androidx.sqlite.SQLiteStatement
        /* renamed from: bindBlob */
        public void mo36bindBlob(int i6, @NotNull byte[] value) {
            g0.p(value, "value");
            throwIfClosed();
            this.delegate.bindBlob(i6, value);
        }

        @Override // androidx.sqlite.SQLiteStatement
        /* renamed from: bindDouble */
        public void mo37bindDouble(int i6, double d6) {
            throwIfClosed();
            this.delegate.bindDouble(i6, d6);
        }

        @Override // androidx.sqlite.SQLiteStatement
        /* renamed from: bindLong */
        public void mo38bindLong(int i6, long j6) {
            throwIfClosed();
            this.delegate.bindLong(i6, j6);
        }

        @Override // androidx.sqlite.SQLiteStatement
        /* renamed from: bindNull */
        public void mo39bindNull(int i6) {
            throwIfClosed();
            this.delegate.bindNull(i6);
        }

        @Override // androidx.sqlite.SQLiteStatement
        /* renamed from: bindText */
        public void mo40bindText(int i6, @NotNull String value) {
            g0.p(value, "value");
            throwIfClosed();
            this.delegate.bindString(i6, value);
        }

        @Override // androidx.sqlite.SQLiteStatement
        /* renamed from: clearBindings */
        public void mo41clearBindings() {
            throwIfClosed();
            this.delegate.clearBindings();
        }

        @Override // androidx.sqlite.SQLiteStatement
        @NotNull
        public byte[] getBlob(int i6) {
            throwIfClosed();
            SQLite.throwSQLiteException(21, "no row");
            throw new KotlinNothingValueException();
        }

        @Override // androidx.sqlite.SQLiteStatement
        public int getColumnCount() {
            throwIfClosed();
            return 0;
        }

        @Override // androidx.sqlite.SQLiteStatement
        @NotNull
        public String getColumnName(int i6) {
            throwIfClosed();
            SQLite.throwSQLiteException(21, "no row");
            throw new KotlinNothingValueException();
        }

        @Override // androidx.sqlite.SQLiteStatement
        public int getColumnType(int i6) {
            throwIfClosed();
            SQLite.throwSQLiteException(21, "no row");
            throw new KotlinNothingValueException();
        }

        @Override // androidx.sqlite.SQLiteStatement
        public double getDouble(int i6) {
            throwIfClosed();
            SQLite.throwSQLiteException(21, "no row");
            throw new KotlinNothingValueException();
        }

        @Override // androidx.sqlite.SQLiteStatement
        public long getLong(int i6) {
            throwIfClosed();
            SQLite.throwSQLiteException(21, "no row");
            throw new KotlinNothingValueException();
        }

        @Override // androidx.sqlite.SQLiteStatement
        @NotNull
        public String getText(int i6) {
            throwIfClosed();
            SQLite.throwSQLiteException(21, "no row");
            throw new KotlinNothingValueException();
        }

        @Override // androidx.sqlite.SQLiteStatement
        public boolean isNull(int i6) {
            throwIfClosed();
            SQLite.throwSQLiteException(21, "no row");
            throw new KotlinNothingValueException();
        }

        @Override // androidx.sqlite.SQLiteStatement
        public boolean step() {
            throwIfClosed();
            this.delegate.execute();
            return false;
        }

        @Override // androidx.sqlite.SQLiteStatement
        public void reset() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class SelectAndroidSQLiteStatement extends AndroidSQLiteStatement {

        @NotNull
        public static final Companion Companion = new Companion(null);

        @NotNull
        private int[] bindingTypes;

        @NotNull
        private byte[][] blobBindings;

        @Nullable
        private Cursor cursor;

        @NotNull
        private double[] doubleBindings;

        @NotNull
        private long[] longBindings;

        @NotNull
        private String[] stringBindings;

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

        private final void ensureCapacity(int i6, int i7) {
            int i8 = i7 + 1;
            int[] iArr = this.bindingTypes;
            if (iArr.length < i8) {
                int[] copyOf = Arrays.copyOf(iArr, i8);
                g0.o(copyOf, "copyOf(...)");
                this.bindingTypes = copyOf;
            }
            if (i6 == 1) {
                long[] jArr = this.longBindings;
                if (jArr.length < i8) {
                    long[] copyOf2 = Arrays.copyOf(jArr, i8);
                    g0.o(copyOf2, "copyOf(...)");
                    this.longBindings = copyOf2;
                    return;
                }
                return;
            }
            if (i6 == 2) {
                double[] dArr = this.doubleBindings;
                if (dArr.length < i8) {
                    double[] copyOf3 = Arrays.copyOf(dArr, i8);
                    g0.o(copyOf3, "copyOf(...)");
                    this.doubleBindings = copyOf3;
                    return;
                }
                return;
            }
            if (i6 == 3) {
                String[] strArr = this.stringBindings;
                if (strArr.length < i8) {
                    Object[] copyOf4 = Arrays.copyOf(strArr, i8);
                    g0.o(copyOf4, "copyOf(...)");
                    this.stringBindings = (String[]) copyOf4;
                    return;
                }
                return;
            }
            if (i6 != 4) {
                return;
            }
            byte[][] bArr = this.blobBindings;
            if (bArr.length < i8) {
                Object[] copyOf5 = Arrays.copyOf(bArr, i8);
                g0.o(copyOf5, "copyOf(...)");
                this.blobBindings = (byte[][]) copyOf5;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SelectAndroidSQLiteStatement(@NotNull SQLiteDatabase db, @NotNull String sql) {
            super(db, sql, null);
            g0.p(db, "db");
            g0.p(sql, "sql");
            this.bindingTypes = new int[0];
            this.longBindings = new long[0];
            this.doubleBindings = new double[0];
            this.stringBindings = new String[0];
            this.blobBindings = new byte[0][];
        }

        private final void bindTo(SQLiteProgram sQLiteProgram) {
            int length = this.bindingTypes.length;
            for (int i6 = 1; i6 < length; i6++) {
                int i7 = this.bindingTypes[i6];
                if (i7 == 1) {
                    sQLiteProgram.bindLong(i6, this.longBindings[i6]);
                } else if (i7 == 2) {
                    sQLiteProgram.bindDouble(i6, this.doubleBindings[i6]);
                } else if (i7 == 3) {
                    sQLiteProgram.bindString(i6, this.stringBindings[i6]);
                } else if (i7 == 4) {
                    sQLiteProgram.bindBlob(i6, this.blobBindings[i6]);
                } else if (i7 == 5) {
                    sQLiteProgram.bindNull(i6);
                }
            }
        }

        private final void ensureCursor() {
            if (this.cursor == null) {
                this.cursor = getDb().rawQueryWithFactory(new SQLiteDatabase.CursorFactory() { // from class: androidx.sqlite.driver.a
                    @Override // android.database.sqlite.SQLiteDatabase.CursorFactory
                    public final Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
                        Cursor ensureCursor$lambda$0;
                        ensureCursor$lambda$0 = AndroidSQLiteStatement.SelectAndroidSQLiteStatement.ensureCursor$lambda$0(AndroidSQLiteStatement.SelectAndroidSQLiteStatement.this, sQLiteDatabase, sQLiteCursorDriver, str, sQLiteQuery);
                        return ensureCursor$lambda$0;
                    }
                }, getSql(), new String[0], null);
            }
        }

        private final void throwIfInvalidColumn(Cursor cursor, int i6) {
            if (i6 < 0 || i6 >= cursor.getColumnCount()) {
                SQLite.throwSQLiteException(25, "column index out of range");
                throw new KotlinNothingValueException();
            }
        }

        private final Cursor throwIfNoRow() {
            Cursor cursor = this.cursor;
            if (cursor != null) {
                return cursor;
            }
            SQLite.throwSQLiteException(21, "no row");
            throw new KotlinNothingValueException();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Cursor ensureCursor$lambda$0(SelectAndroidSQLiteStatement selectAndroidSQLiteStatement, SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
            g0.m(sQLiteQuery);
            selectAndroidSQLiteStatement.bindTo(sQLiteQuery);
            return new SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
        }

        @Override // androidx.sqlite.SQLiteStatement
        /* renamed from: bindBlob */
        public void mo36bindBlob(int i6, @NotNull byte[] value) {
            g0.p(value, "value");
            throwIfClosed();
            ensureCapacity(4, i6);
            this.bindingTypes[i6] = 4;
            this.blobBindings[i6] = value;
        }

        @Override // androidx.sqlite.SQLiteStatement
        /* renamed from: bindDouble */
        public void mo37bindDouble(int i6, double d6) {
            throwIfClosed();
            ensureCapacity(2, i6);
            this.bindingTypes[i6] = 2;
            this.doubleBindings[i6] = d6;
        }

        @Override // androidx.sqlite.SQLiteStatement
        /* renamed from: bindLong */
        public void mo38bindLong(int i6, long j6) {
            throwIfClosed();
            ensureCapacity(1, i6);
            this.bindingTypes[i6] = 1;
            this.longBindings[i6] = j6;
        }

        @Override // androidx.sqlite.SQLiteStatement
        /* renamed from: bindNull */
        public void mo39bindNull(int i6) {
            throwIfClosed();
            ensureCapacity(5, i6);
            this.bindingTypes[i6] = 5;
        }

        @Override // androidx.sqlite.SQLiteStatement
        /* renamed from: bindText */
        public void mo40bindText(int i6, @NotNull String value) {
            g0.p(value, "value");
            throwIfClosed();
            ensureCapacity(3, i6);
            this.bindingTypes[i6] = 3;
            this.stringBindings[i6] = value;
        }

        @Override // androidx.sqlite.SQLiteStatement
        /* renamed from: clearBindings */
        public void mo41clearBindings() {
            throwIfClosed();
            this.bindingTypes = new int[0];
            this.longBindings = new long[0];
            this.doubleBindings = new double[0];
            this.stringBindings = new String[0];
            this.blobBindings = new byte[0][];
        }

        @Override // androidx.sqlite.SQLiteStatement, java.lang.AutoCloseable
        public void close() {
            if (!isClosed()) {
                reset();
            }
            setClosed(true);
        }

        @Override // androidx.sqlite.SQLiteStatement
        @NotNull
        public byte[] getBlob(int i6) {
            throwIfClosed();
            Cursor throwIfNoRow = throwIfNoRow();
            throwIfInvalidColumn(throwIfNoRow, i6);
            byte[] blob = throwIfNoRow.getBlob(i6);
            g0.o(blob, "getBlob(...)");
            return blob;
        }

        @Override // androidx.sqlite.SQLiteStatement
        public int getColumnCount() {
            throwIfClosed();
            ensureCursor();
            Cursor cursor = this.cursor;
            if (cursor != null) {
                return cursor.getColumnCount();
            }
            return 0;
        }

        @Override // androidx.sqlite.SQLiteStatement
        @NotNull
        public String getColumnName(int i6) {
            throwIfClosed();
            ensureCursor();
            Cursor cursor = this.cursor;
            if (cursor != null) {
                throwIfInvalidColumn(cursor, i6);
                String columnName = cursor.getColumnName(i6);
                g0.o(columnName, "getColumnName(...)");
                return columnName;
            }
            throw new IllegalStateException("Required value was null.");
        }

        @Override // androidx.sqlite.SQLiteStatement
        public int getColumnType(int i6) {
            throwIfClosed();
            ensureCursor();
            Cursor cursor = this.cursor;
            if (cursor != null) {
                throwIfInvalidColumn(cursor, i6);
                return Companion.getDataType(cursor, i6);
            }
            throw new IllegalStateException("Required value was null.");
        }

        @Override // androidx.sqlite.SQLiteStatement
        public double getDouble(int i6) {
            throwIfClosed();
            Cursor throwIfNoRow = throwIfNoRow();
            throwIfInvalidColumn(throwIfNoRow, i6);
            return throwIfNoRow.getDouble(i6);
        }

        @Override // androidx.sqlite.SQLiteStatement
        public long getLong(int i6) {
            throwIfClosed();
            Cursor throwIfNoRow = throwIfNoRow();
            throwIfInvalidColumn(throwIfNoRow, i6);
            return throwIfNoRow.getLong(i6);
        }

        @Override // androidx.sqlite.SQLiteStatement
        @NotNull
        public String getText(int i6) {
            throwIfClosed();
            Cursor throwIfNoRow = throwIfNoRow();
            throwIfInvalidColumn(throwIfNoRow, i6);
            String string = throwIfNoRow.getString(i6);
            g0.o(string, "getString(...)");
            return string;
        }

        @Override // androidx.sqlite.SQLiteStatement
        public boolean isNull(int i6) {
            throwIfClosed();
            Cursor throwIfNoRow = throwIfNoRow();
            throwIfInvalidColumn(throwIfNoRow, i6);
            return throwIfNoRow.isNull(i6);
        }

        @Override // androidx.sqlite.SQLiteStatement
        public void reset() {
            throwIfClosed();
            Cursor cursor = this.cursor;
            if (cursor != null) {
                cursor.close();
            }
            this.cursor = null;
        }

        @Override // androidx.sqlite.SQLiteStatement
        public boolean step() {
            throwIfClosed();
            ensureCursor();
            Cursor cursor = this.cursor;
            if (cursor != null) {
                return cursor.moveToNext();
            }
            throw new IllegalStateException("Required value was null.");
        }
    }

    public /* synthetic */ AndroidSQLiteStatement(SQLiteDatabase sQLiteDatabase, String str, v vVar) {
        this(sQLiteDatabase, str);
    }

    private AndroidSQLiteStatement(SQLiteDatabase sQLiteDatabase, String str) {
        this.db = sQLiteDatabase;
        this.sql = str;
    }

    @NotNull
    protected final SQLiteDatabase getDb() {
        return this.db;
    }

    @NotNull
    protected final String getSql() {
        return this.sql;
    }

    protected final boolean isClosed() {
        return this.isClosed;
    }

    protected final void setClosed(boolean z5) {
        this.isClosed = z5;
    }

    protected final void throwIfClosed() {
        if (this.isClosed) {
            SQLite.throwSQLiteException(21, "statement is closed");
            throw new KotlinNothingValueException();
        }
    }

    @Override // androidx.sqlite.SQLiteStatement
    public /* synthetic */ void bindBoolean(int i6, boolean z5) {
        f.a.a(this, i6, z5);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public /* synthetic */ void bindFloat(int i6, float f6) {
        f.a.b(this, i6, f6);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public /* synthetic */ void bindInt(int i6, int i7) {
        f.a.c(this, i6, i7);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public /* synthetic */ boolean getBoolean(int i6) {
        return f.a.d(this, i6);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public /* synthetic */ List getColumnNames() {
        return f.a.e(this);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public /* synthetic */ float getFloat(int i6) {
        return f.a.f(this, i6);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public /* synthetic */ int getInt(int i6) {
        return f.a.g(this, i6);
    }
}
