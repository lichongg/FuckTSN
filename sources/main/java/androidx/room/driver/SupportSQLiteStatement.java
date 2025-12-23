package androidx.room.driver;

import android.database.Cursor;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.room.driver.SupportSQLiteStatement;
import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteStatement;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteProgram;
import androidx.sqlite.db.SupportSQLiteQuery;
import f.a;
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
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: D:\Downloads\app\classes.dex */
public abstract class SupportSQLiteStatement implements SQLiteStatement {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private final SupportSQLiteDatabase db;
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
        public final SupportSQLiteStatement create(@NotNull SupportSQLiteDatabase db, @NotNull String sql) {
            g0.p(db, "db");
            g0.p(sql, "sql");
            String upperCase = u.Z5(sql).toString().toUpperCase(Locale.ROOT);
            g0.o(upperCase, "toUpperCase(...)");
            String statementPrefix$room_runtime_release = getStatementPrefix$room_runtime_release(upperCase);
            return statementPrefix$room_runtime_release == null ? new SupportOtherAndroidSQLiteStatement(db, sql) : isRowStatement(statementPrefix$room_runtime_release) ? new SupportAndroidSQLiteStatement(db, sql) : new SupportOtherAndroidSQLiteStatement(db, sql);
        }

        @VisibleForTesting
        @Nullable
        public final String getStatementPrefix$room_runtime_release(@NotNull String sql) {
            g0.p(sql, "sql");
            int statementPrefixIndex = getStatementPrefixIndex(sql);
            if (statementPrefixIndex < 0 || statementPrefixIndex > sql.length()) {
                return null;
            }
            String substring = sql.substring(statementPrefixIndex, Math.min(statementPrefixIndex + 3, sql.length()));
            g0.o(substring, "substring(...)");
            return substring;
        }

        private final int getStatementPrefixIndex(String str) {
            String str2;
            int i6;
            int length = str.length() - 2;
            if (length < 0) {
                return -1;
            }
            int i7 = 0;
            while (i7 < length) {
                char charAt = str.charAt(i7);
                if (g0.t(charAt, 32) <= 0) {
                    i7++;
                } else if (charAt == '-') {
                    if (str.charAt(i7 + 1) == '-') {
                        str2 = str;
                        int G3 = u.G3(str2, '\n', i7 + 2, false, 4, null);
                        if (G3 < 0) {
                            return -1;
                        }
                        i7 = G3 + 1;
                        str = str2;
                    } else {
                        return i7;
                    }
                } else {
                    str2 = str;
                    if (charAt == '/') {
                        int i8 = i7 + 1;
                        if (str2.charAt(i8) == '*') {
                            do {
                                String str3 = str2;
                                i8 = u.G3(str3, '*', i8 + 1, false, 4, null);
                                str2 = str3;
                                if (i8 < 0) {
                                    return -1;
                                }
                                i6 = i8 + 1;
                                if (i6 >= length) {
                                    break;
                                }
                            } while (str2.charAt(i6) != '/');
                            i7 = i8 + 2;
                            str = str2;
                        }
                    }
                    return i7;
                }
            }
            return -1;
        }

        private final boolean isRowStatement(String str) {
            int hashCode = str.hashCode();
            if (hashCode != 79487) {
                if (hashCode != 81978) {
                    if (hashCode == 85954 && str.equals("WIT")) {
                        return true;
                    }
                    return false;
                }
                if (str.equals("SEL")) {
                    return true;
                }
                return false;
            }
            if (str.equals("PRA")) {
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class SupportAndroidSQLiteStatement extends SupportSQLiteStatement {

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
        public SupportAndroidSQLiteStatement(@NotNull SupportSQLiteDatabase db, @NotNull String sql) {
            super(db, sql, null);
            g0.p(db, "db");
            g0.p(sql, "sql");
            this.bindingTypes = new int[0];
            this.longBindings = new long[0];
            this.doubleBindings = new double[0];
            this.stringBindings = new String[0];
            this.blobBindings = new byte[0][];
        }

        private final void ensureCursor() {
            if (this.cursor == null) {
                this.cursor = getDb().query(new SupportSQLiteQuery() { // from class: androidx.room.driver.SupportSQLiteStatement$SupportAndroidSQLiteStatement$ensureCursor$1
                    @Override // androidx.sqlite.db.SupportSQLiteQuery
                    public void bindTo(SupportSQLiteProgram statement) {
                        int[] iArr;
                        int[] iArr2;
                        long[] jArr;
                        double[] dArr;
                        String[] strArr;
                        byte[][] bArr;
                        g0.p(statement, "statement");
                        iArr = SupportSQLiteStatement.SupportAndroidSQLiteStatement.this.bindingTypes;
                        int length = iArr.length;
                        for (int i6 = 1; i6 < length; i6++) {
                            iArr2 = SupportSQLiteStatement.SupportAndroidSQLiteStatement.this.bindingTypes;
                            int i7 = iArr2[i6];
                            if (i7 == 1) {
                                jArr = SupportSQLiteStatement.SupportAndroidSQLiteStatement.this.longBindings;
                                statement.bindLong(i6, jArr[i6]);
                            } else if (i7 == 2) {
                                dArr = SupportSQLiteStatement.SupportAndroidSQLiteStatement.this.doubleBindings;
                                statement.bindDouble(i6, dArr[i6]);
                            } else if (i7 == 3) {
                                strArr = SupportSQLiteStatement.SupportAndroidSQLiteStatement.this.stringBindings;
                                String str = strArr[i6];
                                g0.m(str);
                                statement.bindString(i6, str);
                            } else if (i7 == 4) {
                                bArr = SupportSQLiteStatement.SupportAndroidSQLiteStatement.this.blobBindings;
                                byte[] bArr2 = bArr[i6];
                                g0.m(bArr2);
                                statement.bindBlob(i6, bArr2);
                            } else if (i7 == 5) {
                                statement.bindNull(i6);
                            }
                        }
                    }

                    @Override // androidx.sqlite.db.SupportSQLiteQuery
                    public int getArgCount() {
                        int[] iArr;
                        iArr = SupportSQLiteStatement.SupportAndroidSQLiteStatement.this.bindingTypes;
                        return iArr.length;
                    }

                    @Override // androidx.sqlite.db.SupportSQLiteQuery
                    public String getSql() {
                        return SupportSQLiteStatement.SupportAndroidSQLiteStatement.this.getSql();
                    }
                });
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
                mo41clearBindings();
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

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class SupportOtherAndroidSQLiteStatement extends SupportSQLiteStatement {

        @NotNull
        private final androidx.sqlite.db.SupportSQLiteStatement delegate;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SupportOtherAndroidSQLiteStatement(@NotNull SupportSQLiteDatabase db, @NotNull String sql) {
            super(db, sql, null);
            g0.p(db, "db");
            g0.p(sql, "sql");
            this.delegate = db.compileStatement(sql);
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

    public /* synthetic */ SupportSQLiteStatement(SupportSQLiteDatabase supportSQLiteDatabase, String str, v vVar) {
        this(supportSQLiteDatabase, str);
    }

    private SupportSQLiteStatement(SupportSQLiteDatabase supportSQLiteDatabase, String str) {
        this.db = supportSQLiteDatabase;
        this.sql = str;
    }

    @NotNull
    protected final SupportSQLiteDatabase getDb() {
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
