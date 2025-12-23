package net.sqlcipher;

import android.content.ContentValues;
import android.content.OperationApplicationException;
import android.os.Parcel;
import android.text.TextUtils;
import com.snail.antifake.deviceid.e;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.text.Collator;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import net.sqlcipher.database.SQLiteAbortException;
import net.sqlcipher.database.SQLiteConstraintException;
import net.sqlcipher.database.SQLiteDatabase;
import net.sqlcipher.database.SQLiteDatabaseCorruptException;
import net.sqlcipher.database.SQLiteDiskIOException;
import net.sqlcipher.database.SQLiteException;
import net.sqlcipher.database.SQLiteFullException;
import net.sqlcipher.database.SQLiteProgram;
import net.sqlcipher.database.SQLiteStatement;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class DatabaseUtils {
    private static final boolean DEBUG = false;
    private static final boolean LOCAL_LOGV = false;
    private static final String TAG = "DatabaseUtils";
    private static final String[] countProjection = {"count(*)"};
    private static final char[] HEX_DIGITS_LOWER = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static Collator mColl = null;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class InsertHelper {
        public static final int TABLE_INFO_PRAGMA_COLUMNNAME_INDEX = 1;
        public static final int TABLE_INFO_PRAGMA_DEFAULT_INDEX = 4;
        private HashMap<String, Integer> mColumns;
        private final SQLiteDatabase mDb;
        private final String mTableName;
        private String mInsertSQL = null;
        private SQLiteStatement mInsertStatement = null;
        private SQLiteStatement mReplaceStatement = null;
        private SQLiteStatement mPreparedStatement = null;

        private synchronized long insertInternal(ContentValues contentValues, boolean z5) {
            SQLiteStatement statement;
            try {
                try {
                    statement = getStatement(z5);
                    statement.clearBindings();
                    for (Map.Entry<String, Object> entry : contentValues.valueSet()) {
                        DatabaseUtils.bindObjectToProgram(statement, getColumnIndex(entry.getKey()), entry.getValue());
                    }
                } catch (SQLException unused) {
                    Objects.toString(contentValues);
                    return -1L;
                }
            } catch (Throwable th) {
                throw th;
            }
            return statement.executeInsert();
        }

        public void bind(int i6, double d6) {
            this.mPreparedStatement.bindDouble(i6, d6);
        }

        public int getColumnIndex(String str) {
            getStatement(false);
            Integer num = this.mColumns.get(str);
            if (num != null) {
                return num.intValue();
            }
            throw new IllegalArgumentException("column '" + str + "' is invalid");
        }

        public long insert(ContentValues contentValues) {
            return insertInternal(contentValues, false);
        }

        public void prepareForInsert() {
            SQLiteStatement statement = getStatement(false);
            this.mPreparedStatement = statement;
            statement.clearBindings();
        }

        public void prepareForReplace() {
            SQLiteStatement statement = getStatement(true);
            this.mPreparedStatement = statement;
            statement.clearBindings();
        }

        public long replace(ContentValues contentValues) {
            return insertInternal(contentValues, true);
        }

        private void buildSQL() throws SQLException {
            StringBuilder sb = new StringBuilder(128);
            sb.append("INSERT INTO ");
            sb.append(this.mTableName);
            sb.append(" (");
            StringBuilder sb2 = new StringBuilder(128);
            sb2.append("VALUES (");
            Cursor cursor = null;
            try {
                cursor = this.mDb.rawQuery("PRAGMA table_info(" + this.mTableName + ")", (String[]) null);
                this.mColumns = new HashMap<>(cursor.getCount());
                int i6 = 1;
                while (cursor.moveToNext()) {
                    String string = cursor.getString(1);
                    String string2 = cursor.getString(4);
                    this.mColumns.put(string, Integer.valueOf(i6));
                    sb.append("'");
                    sb.append(string);
                    sb.append("'");
                    if (string2 == null) {
                        sb2.append("?");
                    } else {
                        sb2.append("COALESCE(?, ");
                        sb2.append(string2);
                        sb2.append(")");
                    }
                    sb.append(i6 == cursor.getCount() ? ") " : ", ");
                    sb2.append(i6 == cursor.getCount() ? ");" : ", ");
                    i6++;
                }
                cursor.close();
                sb.append((CharSequence) sb2);
                this.mInsertSQL = sb.toString();
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        }

        private SQLiteStatement getStatement(boolean z5) throws SQLException {
            if (!z5) {
                if (this.mInsertStatement == null) {
                    if (this.mInsertSQL == null) {
                        buildSQL();
                    }
                    this.mInsertStatement = this.mDb.compileStatement(this.mInsertSQL);
                }
                return this.mInsertStatement;
            }
            if (this.mReplaceStatement == null) {
                if (this.mInsertSQL == null) {
                    buildSQL();
                }
                this.mReplaceStatement = this.mDb.compileStatement("INSERT OR REPLACE" + this.mInsertSQL.substring(6));
            }
            return this.mReplaceStatement;
        }

        public void bind(int i6, float f6) {
            this.mPreparedStatement.bindDouble(i6, f6);
        }

        public void bindNull(int i6) {
            this.mPreparedStatement.bindNull(i6);
        }

        public void close() {
            SQLiteStatement sQLiteStatement = this.mInsertStatement;
            if (sQLiteStatement != null) {
                sQLiteStatement.close();
                this.mInsertStatement = null;
            }
            SQLiteStatement sQLiteStatement2 = this.mReplaceStatement;
            if (sQLiteStatement2 != null) {
                sQLiteStatement2.close();
                this.mReplaceStatement = null;
            }
            this.mInsertSQL = null;
            this.mColumns = null;
        }

        public long execute() {
            SQLiteStatement sQLiteStatement = this.mPreparedStatement;
            if (sQLiteStatement == null) {
                throw new IllegalStateException("you must prepare this inserter before calling execute");
            }
            try {
                long executeInsert = sQLiteStatement.executeInsert();
                this.mPreparedStatement = null;
                return executeInsert;
            } catch (SQLException unused) {
                this.mPreparedStatement = null;
                return -1L;
            } catch (Throwable th) {
                this.mPreparedStatement = null;
                throw th;
            }
        }

        public InsertHelper(SQLiteDatabase sQLiteDatabase, String str) {
            this.mDb = sQLiteDatabase;
            this.mTableName = str;
        }

        public void bind(int i6, long j6) {
            this.mPreparedStatement.bindLong(i6, j6);
        }

        public void bind(int i6, int i7) {
            this.mPreparedStatement.bindLong(i6, i7);
        }

        public void bind(int i6, boolean z5) {
            this.mPreparedStatement.bindLong(i6, z5 ? 1L : 0L);
        }

        public void bind(int i6, byte[] bArr) {
            if (bArr == null) {
                this.mPreparedStatement.bindNull(i6);
            } else {
                this.mPreparedStatement.bindBlob(i6, bArr);
            }
        }

        public void bind(int i6, String str) {
            if (str == null) {
                this.mPreparedStatement.bindNull(i6);
            } else {
                this.mPreparedStatement.bindString(i6, str);
            }
        }
    }

    public static void cursorIntToContentValues(Cursor cursor, String str, ContentValues contentValues) {
        cursorIntToContentValues(cursor, str, contentValues, str);
    }

    public static void cursorLongToContentValues(Cursor cursor, String str, ContentValues contentValues) {
        cursorLongToContentValues(cursor, str, contentValues, str);
    }

    public static void cursorStringToContentValues(Cursor cursor, String str, ContentValues contentValues) {
        cursorStringToContentValues(cursor, str, contentValues, str);
    }

    public static void dumpCurrentRow(Cursor cursor) {
        dumpCurrentRow(cursor, System.out);
    }

    public static void dumpCursor(Cursor cursor) {
        dumpCursor(cursor, System.out);
    }

    private static char[] encodeHex(byte[] bArr, char[] cArr) {
        char[] cArr2 = new char[bArr.length << 1];
        int i6 = 0;
        for (byte b6 : bArr) {
            int i7 = i6 + 1;
            cArr2[i6] = cArr[(b6 & 240) >>> 4];
            i6 += 2;
            cArr2[i7] = cArr[b6 & 15];
        }
        return cArr2;
    }

    private static int getKeyLen(byte[] bArr) {
        return bArr[bArr.length + (-1)] != 0 ? bArr.length : bArr.length - 1;
    }

    public static long longForQuery(SQLiteDatabase sQLiteDatabase, String str, String[] strArr) {
        SQLiteStatement compileStatement = sQLiteDatabase.compileStatement(str);
        try {
            return longForQuery(compileStatement, strArr);
        } finally {
            compileStatement.close();
        }
    }

    public static final void readExceptionFromParcel(Parcel parcel) {
        int readInt = parcel.readInt();
        if (readInt == 0) {
            return;
        }
        readExceptionFromParcel(parcel, parcel.readString(), readInt);
    }

    public static String stringForQuery(SQLiteDatabase sQLiteDatabase, String str, String[] strArr) {
        SQLiteStatement compileStatement = sQLiteDatabase.compileStatement(str);
        try {
            return stringForQuery(compileStatement, strArr);
        } finally {
            compileStatement.close();
        }
    }

    public static void appendEscapedSQLString(StringBuilder sb, String str) {
        sb.append('\'');
        if (str.indexOf(39) != -1) {
            int length = str.length();
            for (int i6 = 0; i6 < length; i6++) {
                char charAt = str.charAt(i6);
                if (charAt == '\'') {
                    sb.append('\'');
                }
                sb.append(charAt);
            }
        } else {
            sb.append(str);
        }
        sb.append('\'');
    }

    public static final void appendValueToSql(StringBuilder sb, Object obj) {
        if (obj == null) {
            sb.append("NULL");
            return;
        }
        if (!(obj instanceof Boolean)) {
            appendEscapedSQLString(sb, obj.toString());
        } else if (((Boolean) obj).booleanValue()) {
            sb.append('1');
        } else {
            sb.append('0');
        }
    }

    public static void bindObjectToProgram(SQLiteProgram sQLiteProgram, int i6, Object obj) {
        if (obj == null) {
            sQLiteProgram.bindNull(i6);
            return;
        }
        if ((obj instanceof Double) || (obj instanceof Float)) {
            sQLiteProgram.bindDouble(i6, ((Number) obj).doubleValue());
            return;
        }
        if (obj instanceof Number) {
            sQLiteProgram.bindLong(i6, ((Number) obj).longValue());
            return;
        }
        if (obj instanceof Boolean) {
            if (((Boolean) obj).booleanValue()) {
                sQLiteProgram.bindLong(i6, 1L);
                return;
            } else {
                sQLiteProgram.bindLong(i6, 0L);
                return;
            }
        }
        if (obj instanceof byte[]) {
            sQLiteProgram.bindBlob(i6, (byte[]) obj);
        } else {
            sQLiteProgram.bindString(i6, obj.toString());
        }
    }

    public static void cursorFillWindow(Cursor cursor, int i6, android.database.CursorWindow cursorWindow) {
        boolean putNull;
        if (i6 < 0 || i6 >= cursor.getCount()) {
            return;
        }
        int position = cursor.getPosition();
        int columnCount = cursor.getColumnCount();
        cursorWindow.clear();
        cursorWindow.setStartPosition(i6);
        cursorWindow.setNumColumns(columnCount);
        if (cursor.moveToPosition(i6)) {
            while (cursorWindow.allocRow()) {
                int i7 = 0;
                while (true) {
                    if (i7 >= columnCount) {
                        break;
                    }
                    int type = cursor.getType(i7);
                    if (type == 0) {
                        putNull = cursorWindow.putNull(i6, i7);
                    } else if (type == 1) {
                        putNull = cursorWindow.putLong(cursor.getLong(i7), i6, i7);
                    } else if (type == 2) {
                        putNull = cursorWindow.putDouble(cursor.getDouble(i7), i6, i7);
                    } else if (type != 4) {
                        String string = cursor.getString(i7);
                        putNull = string != null ? cursorWindow.putString(string, i6, i7) : cursorWindow.putNull(i6, i7);
                    } else {
                        byte[] blob = cursor.getBlob(i7);
                        putNull = blob != null ? cursorWindow.putBlob(blob, i6, i7) : cursorWindow.putNull(i6, i7);
                    }
                    if (!putNull) {
                        cursorWindow.freeLastRow();
                        break;
                    }
                    i7++;
                }
                i6++;
                if (!cursor.moveToNext()) {
                    break;
                }
            }
        }
        cursor.moveToPosition(position);
    }

    public static void cursorIntToContentValues(Cursor cursor, String str, ContentValues contentValues, String str2) {
        int columnIndex = cursor.getColumnIndex(str);
        if (cursor.isNull(columnIndex)) {
            contentValues.put(str2, (Integer) null);
        } else {
            contentValues.put(str2, Integer.valueOf(cursor.getInt(columnIndex)));
        }
    }

    public static void cursorLongToContentValues(Cursor cursor, String str, ContentValues contentValues, String str2) {
        int columnIndex = cursor.getColumnIndex(str);
        if (cursor.isNull(columnIndex)) {
            contentValues.put(str2, (Long) null);
        } else {
            contentValues.put(str2, Long.valueOf(cursor.getLong(columnIndex)));
        }
    }

    public static void cursorRowToContentValues(Cursor cursor, ContentValues contentValues) {
        AbstractWindowedCursor abstractWindowedCursor = cursor instanceof AbstractWindowedCursor ? (AbstractWindowedCursor) cursor : null;
        String[] columnNames = cursor.getColumnNames();
        int length = columnNames.length;
        for (int i6 = 0; i6 < length; i6++) {
            if (abstractWindowedCursor == null || !abstractWindowedCursor.isBlob(i6)) {
                contentValues.put(columnNames[i6], cursor.getString(i6));
            } else {
                contentValues.put(columnNames[i6], cursor.getBlob(i6));
            }
        }
    }

    public static void cursorStringToContentValues(Cursor cursor, String str, ContentValues contentValues, String str2) {
        contentValues.put(str2, cursor.getString(cursor.getColumnIndexOrThrow(str)));
    }

    public static void dumpCurrentRow(Cursor cursor, PrintStream printStream) {
        String[] columnNames = cursor.getColumnNames();
        cursor.getPosition();
        printStream.getClass();
        int length = columnNames.length;
        for (int i6 = 0; i6 < length; i6++) {
            try {
                cursor.getString(i6);
            } catch (SQLiteException unused) {
            }
            String str = columnNames[i6];
        }
    }

    public static String dumpCurrentRowToString(Cursor cursor) {
        StringBuilder sb = new StringBuilder();
        dumpCurrentRow(cursor, sb);
        return sb.toString();
    }

    public static void dumpCursor(Cursor cursor, PrintStream printStream) {
        Objects.toString(cursor);
        printStream.getClass();
        if (cursor != null) {
            int position = cursor.getPosition();
            cursor.moveToPosition(-1);
            while (cursor.moveToNext()) {
                dumpCurrentRow(cursor, printStream);
            }
            cursor.moveToPosition(position);
        }
    }

    public static String dumpCursorToString(Cursor cursor) {
        StringBuilder sb = new StringBuilder();
        dumpCursor(cursor, sb);
        return sb.toString();
    }

    private static byte[] getCollationKeyInBytes(String str) {
        if (mColl == null) {
            Collator collator = Collator.getInstance();
            mColl = collator;
            collator.setStrength(0);
        }
        return mColl.getCollationKey(str).toByteArray();
    }

    public static int getTypeOfObject(Object obj) {
        if (obj == null) {
            return 0;
        }
        if (obj instanceof byte[]) {
            return 4;
        }
        if ((obj instanceof Float) || (obj instanceof Double)) {
            return 2;
        }
        return ((obj instanceof Long) || (obj instanceof Integer)) ? 1 : 3;
    }

    public static long queryNumEntries(SQLiteDatabase sQLiteDatabase, String str) {
        Cursor query = sQLiteDatabase.query(str, countProjection, null, null, null, null, null);
        try {
            query.moveToFirst();
            return query.getLong(0);
        } finally {
            query.close();
        }
    }

    public static String sqlEscapeString(String str) {
        StringBuilder sb = new StringBuilder();
        appendEscapedSQLString(sb, str);
        return sb.toString();
    }

    public static final void writeExceptionToParcel(Parcel parcel, Exception exc) {
        int i6;
        if (exc instanceof FileNotFoundException) {
            i6 = 1;
        } else if (exc instanceof IllegalArgumentException) {
            i6 = 2;
        } else if (exc instanceof UnsupportedOperationException) {
            i6 = 3;
        } else if (exc instanceof SQLiteAbortException) {
            i6 = 4;
        } else if (exc instanceof SQLiteConstraintException) {
            i6 = 5;
        } else if (exc instanceof SQLiteDatabaseCorruptException) {
            i6 = 6;
        } else if (exc instanceof SQLiteFullException) {
            i6 = 7;
        } else if (exc instanceof SQLiteDiskIOException) {
            i6 = 8;
        } else if (exc instanceof SQLiteException) {
            i6 = 9;
        } else {
            if (!(exc instanceof OperationApplicationException)) {
                parcel.writeException(exc);
                return;
            }
            i6 = 10;
        }
        parcel.writeInt(i6);
        parcel.writeString(exc.getMessage());
    }

    public static String concatenateWhere(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        if (TextUtils.isEmpty(str2)) {
            return str;
        }
        return "(" + str + ") AND (" + str2 + ")";
    }

    public static void cursorDoubleToContentValues(Cursor cursor, String str, ContentValues contentValues, String str2) {
        int columnIndex = cursor.getColumnIndex(str);
        if (!cursor.isNull(columnIndex)) {
            contentValues.put(str2, Double.valueOf(cursor.getDouble(columnIndex)));
        } else {
            contentValues.put(str2, (Double) null);
        }
    }

    public static void cursorDoubleToContentValuesIfPresent(Cursor cursor, ContentValues contentValues, String str) {
        int columnIndexOrThrow = cursor.getColumnIndexOrThrow(str);
        if (!cursor.isNull(columnIndexOrThrow)) {
            contentValues.put(str, Double.valueOf(cursor.getDouble(columnIndexOrThrow)));
        }
    }

    public static void cursorDoubleToCursorValues(Cursor cursor, String str, ContentValues contentValues) {
        cursorDoubleToContentValues(cursor, str, contentValues, str);
    }

    public static void cursorFloatToContentValuesIfPresent(Cursor cursor, ContentValues contentValues, String str) {
        int columnIndexOrThrow = cursor.getColumnIndexOrThrow(str);
        if (!cursor.isNull(columnIndexOrThrow)) {
            contentValues.put(str, Float.valueOf(cursor.getFloat(columnIndexOrThrow)));
        }
    }

    public static void cursorIntToContentValuesIfPresent(Cursor cursor, ContentValues contentValues, String str) {
        int columnIndexOrThrow = cursor.getColumnIndexOrThrow(str);
        if (!cursor.isNull(columnIndexOrThrow)) {
            contentValues.put(str, Integer.valueOf(cursor.getInt(columnIndexOrThrow)));
        }
    }

    public static void cursorLongToContentValuesIfPresent(Cursor cursor, ContentValues contentValues, String str) {
        int columnIndexOrThrow = cursor.getColumnIndexOrThrow(str);
        if (!cursor.isNull(columnIndexOrThrow)) {
            contentValues.put(str, Long.valueOf(cursor.getLong(columnIndexOrThrow)));
        }
    }

    public static void cursorShortToContentValuesIfPresent(Cursor cursor, ContentValues contentValues, String str) {
        int columnIndexOrThrow = cursor.getColumnIndexOrThrow(str);
        if (!cursor.isNull(columnIndexOrThrow)) {
            contentValues.put(str, Short.valueOf(cursor.getShort(columnIndexOrThrow)));
        }
    }

    public static void cursorStringToContentValuesIfPresent(Cursor cursor, ContentValues contentValues, String str) {
        int columnIndexOrThrow = cursor.getColumnIndexOrThrow(str);
        if (!cursor.isNull(columnIndexOrThrow)) {
            contentValues.put(str, cursor.getString(columnIndexOrThrow));
        }
    }

    public static void cursorStringToInsertHelper(Cursor cursor, String str, InsertHelper insertHelper, int i6) {
        insertHelper.bind(i6, cursor.getString(cursor.getColumnIndexOrThrow(str)));
    }

    public static String getCollationKey(String str) {
        byte[] collationKeyInBytes = getCollationKeyInBytes(str);
        try {
            return new String(collationKeyInBytes, 0, getKeyLen(collationKeyInBytes), "ISO8859_1");
        } catch (Exception unused) {
            return "";
        }
    }

    public static String getHexCollationKey(String str) {
        byte[] collationKeyInBytes = getCollationKeyInBytes(str);
        return new String(encodeHex(collationKeyInBytes, HEX_DIGITS_LOWER), 0, getKeyLen(collationKeyInBytes) * 2);
    }

    public static void readExceptionWithFileNotFoundExceptionFromParcel(Parcel parcel) throws FileNotFoundException {
        int readInt = parcel.readInt();
        if (readInt == 0) {
            return;
        }
        String readString = parcel.readString();
        if (readInt != 1) {
            readExceptionFromParcel(parcel, readString, readInt);
            return;
        }
        throw new FileNotFoundException(readString);
    }

    public static void readExceptionWithOperationApplicationExceptionFromParcel(Parcel parcel) throws OperationApplicationException {
        int readInt = parcel.readInt();
        if (readInt == 0) {
            return;
        }
        String readString = parcel.readString();
        if (readInt != 10) {
            readExceptionFromParcel(parcel, readString, readInt);
            return;
        }
        throw new OperationApplicationException(readString);
    }

    private static final void readExceptionFromParcel(Parcel parcel, String str, int i6) {
        switch (i6) {
            case 2:
                throw new IllegalArgumentException(str);
            case 3:
                throw new UnsupportedOperationException(str);
            case 4:
                throw new SQLiteAbortException(str);
            case 5:
                throw new SQLiteConstraintException(str);
            case 6:
                throw new SQLiteDatabaseCorruptException(str);
            case 7:
                throw new SQLiteFullException(str);
            case 8:
                throw new SQLiteDiskIOException(str);
            case 9:
                throw new SQLiteException(str);
            default:
                parcel.readException(i6, str);
                return;
        }
    }

    public static long longForQuery(SQLiteStatement sQLiteStatement, String[] strArr) {
        if (strArr != null) {
            int length = strArr.length;
            int i6 = 0;
            while (i6 < length) {
                int i7 = i6 + 1;
                bindObjectToProgram(sQLiteStatement, i7, strArr[i6]);
                i6 = i7;
            }
        }
        return sQLiteStatement.simpleQueryForLong();
    }

    public static String stringForQuery(SQLiteStatement sQLiteStatement, String[] strArr) {
        if (strArr != null) {
            int length = strArr.length;
            int i6 = 0;
            while (i6 < length) {
                int i7 = i6 + 1;
                bindObjectToProgram(sQLiteStatement, i7, strArr[i6]);
                i6 = i7;
            }
        }
        return sQLiteStatement.simpleQueryForString();
    }

    public static void dumpCurrentRow(Cursor cursor, StringBuilder sb) {
        String str;
        String[] columnNames = cursor.getColumnNames();
        sb.append("" + cursor.getPosition() + " {\n");
        int length = columnNames.length;
        for (int i6 = 0; i6 < length; i6++) {
            try {
                str = cursor.getString(i6);
            } catch (SQLiteException unused) {
                str = "<unprintable>";
            }
            sb.append("   " + columnNames[i6] + '=' + str + e.f37542d);
        }
        sb.append("}\n");
    }

    public static void dumpCursor(Cursor cursor, StringBuilder sb) {
        sb.append(">>>>> Dumping cursor " + cursor + e.f37542d);
        if (cursor != null) {
            int position = cursor.getPosition();
            cursor.moveToPosition(-1);
            while (cursor.moveToNext()) {
                dumpCurrentRow(cursor, sb);
            }
            cursor.moveToPosition(position);
        }
        sb.append("<<<<<\n");
    }
}
