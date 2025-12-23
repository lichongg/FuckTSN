package xyz.adscope.common.v2.persistent.db;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import xyz.adscope.common.v2.log.SDKLog;
import xyz.adscope.common.v2.model.IDatabaseModel;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public abstract class IBaseDbHelper implements IBaseDBOperator {
    protected static final String CONDITION_EQUALS = " = ";
    protected static final String CONDITION_GREATER_THEN = " > ";
    public static final String CONDITION_IN = " IN ";
    protected static final String CONDITION_LESS_THEN = " < ";
    private static final String DB_SUFFIX = ".db";
    protected static final int DEFAULT_DB_VERSION = 1;
    public static final String PLACE_HOLDER_TABLE_NAME = "TABLE_NAME";
    private static final String TABLE_NAME_FORMAT = "t_%s_%s";
    private static final String TAG = "IBaseDbHelper";
    private static final String WHERE_CUSTOM_FORMAT = " %s %s ? ";
    private final List<Class<? extends IDatabaseModel>> mAcceptModel;
    private final String mFinalDbName = parseFinalDbName();
    private final DbOpenHelper mOpenHelper;
    private final Map<Class<? extends IDatabaseModel>, String> mTableNameMapping;
    private final SQLiteDatabase mWriteAble;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: xyz.adscope.common.v2.persistent.db.IBaseDbHelper$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class DbOpenHelper extends SQLiteOpenHelper {
        /* synthetic */ DbOpenHelper(IBaseDbHelper iBaseDbHelper, Context context, AnonymousClass1 anonymousClass1) {
            this(context);
        }

        private DbOpenHelper(Context context) {
            super(context, IBaseDbHelper.this.mFinalDbName, IBaseDbHelper.this.getFactory(), IBaseDbHelper.this.getDbVersion());
        }

        private void createTable(SQLiteDatabase sQLiteDatabase, Map<Class<? extends IDatabaseModel>, String> map) {
            if (map == null || map.isEmpty()) {
                return;
            }
            SDKLog.d(IBaseDbHelper.TAG, "建表..." + map.size());
            for (Map.Entry<Class<? extends IDatabaseModel>, String> entry : map.entrySet()) {
                try {
                    IDatabaseModel newInstance = entry.getKey().newInstance();
                    if (newInstance.getColumns() != null) {
                        IBaseDbHelper.this.createTableByModel(sQLiteDatabase, entry.getValue(), newInstance.getColumns());
                    }
                } catch (IllegalAccessException | InstantiationException e6) {
                    SDKLog.stack(e6);
                }
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            SDKLog.d(IBaseDbHelper.TAG, "数据库创建...");
            createTable(sQLiteDatabase, IBaseDbHelper.this.mTableNameMapping);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i6, int i7) {
            IBaseDbHelper.this.upgrade(sQLiteDatabase, i6, i7);
            SDKLog.d(IBaseDbHelper.TAG, "数据库更新... old " + i6 + " new " + i7);
            if (i6 < i7) {
                createTable(sQLiteDatabase, IBaseDbHelper.this.mTableNameMapping);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean isAcceptModel(IDatabaseModel iDatabaseModel) {
        if (iDatabaseModel != null) {
            return isAcceptModel((Class<? extends IDatabaseModel>) iDatabaseModel.getClass());
        }
        return false;
    }

    protected abstract List<Class<? extends IDatabaseModel>> acceptTable();

    protected abstract String createDBNameWithoutSuffix();

    @Override // xyz.adscope.common.v2.persistent.db.IBaseDBOperator
    public synchronized int delete(Class<? extends IDatabaseModel> cls, String str, String[] strArr) {
        if (!isAcceptModel(cls)) {
            return -1;
        }
        return this.mWriteAble.delete(this.mTableNameMapping.get(cls), str, strArr);
    }

    @Override // xyz.adscope.common.v2.persistent.db.IBaseDBOperator
    public synchronized int deleteBetweenPrimaryKey(Class<? extends IDatabaseModel> cls, long[] jArr) {
        if (jArr == null) {
            return -1;
        }
        if (jArr.length < 2) {
            return deleteInPrimaryKey(cls, jArr);
        }
        Arrays.sort(jArr);
        return delete(cls, whereBetweenAnd("id"), new String[]{String.valueOf(jArr[0]), String.valueOf(jArr[jArr.length - 1])});
    }

    @Override // xyz.adscope.common.v2.persistent.db.IBaseDBOperator
    public synchronized int deleteByPrimaryKey(Class<? extends IDatabaseModel> cls, long j6) {
        return delete(cls, whereEquals("id"), new String[]{String.valueOf(j6)});
    }

    @Override // xyz.adscope.common.v2.persistent.db.IBaseDBOperator
    public synchronized int deleteInPrimaryKey(Class<? extends IDatabaseModel> cls, long[] jArr) {
        if (jArr != null) {
            try {
                if (jArr.length > 0) {
                    String[] strArr = new String[jArr.length];
                    for (int i6 = 0; i6 < jArr.length; i6++) {
                        strArr[i6] = String.valueOf(jArr[i6]);
                    }
                    return delete(cls, whereIn("id", jArr.length), strArr);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return -1;
    }

    @Override // xyz.adscope.common.v2.persistent.db.IBaseDBOperator
    public synchronized boolean execSQL(String str) {
        SQLiteDatabase sQLiteDatabase;
        if (!TextUtils.isEmpty(str) && (sQLiteDatabase = this.mWriteAble) != null) {
            try {
                sQLiteDatabase.execSQL(str);
                return true;
            } catch (SQLException e6) {
                SDKLog.stack(e6);
            }
        }
        return false;
    }

    protected int getDbVersion() {
        return 2;
    }

    protected SQLiteDatabase.CursorFactory getFactory() {
        return null;
    }

    @Override // xyz.adscope.common.v2.persistent.db.IBaseDBOperator
    public synchronized long insert(IDatabaseModel iDatabaseModel) {
        if (!isAcceptModel(iDatabaseModel) || !isContentValuesValid(iDatabaseModel)) {
            return -1L;
        }
        return this.mWriteAble.insert(this.mTableNameMapping.get(iDatabaseModel.getClass()), null, iDatabaseModel.getContentValuesStruct());
    }

    @Override // xyz.adscope.common.v2.persistent.db.IBaseDBOperator
    public synchronized <E extends IDatabaseModel> List<E> query(Class<E> cls, String str) {
        return query(cls, null, null, null, str, -1);
    }

    @Override // xyz.adscope.common.v2.persistent.db.IBaseDBOperator
    public synchronized <E extends IDatabaseModel> int queryNumEntries(Class<E> cls) {
        if (isAcceptModel((Class<? extends IDatabaseModel>) cls)) {
            try {
                Cursor query = this.mWriteAble.query(this.mTableNameMapping.get(cls), new String[]{"id"}, null, null, null, null, null, null);
                if (query != null) {
                    try {
                        int count = query.getCount();
                        query.close();
                        return count;
                    } finally {
                    }
                } else if (query != null) {
                    query.close();
                }
            } catch (SQLException unused) {
            }
        }
        return 0;
    }

    @Override // xyz.adscope.common.v2.persistent.db.IBaseDBOperator
    public synchronized <E extends IDatabaseModel> long[] queryPrimerByDeleteCount(Class<E> cls, int i6) {
        if (isAcceptModel((Class<? extends IDatabaseModel>) cls)) {
            try {
                Cursor query = this.mWriteAble.query(this.mTableNameMapping.get(cls), new String[]{"id"}, null, null, null, null, null, String.valueOf(i6));
                if (query != null) {
                    try {
                        long[] jArr = new long[query.getCount()];
                        int i7 = 0;
                        while (query.moveToNext()) {
                            int i8 = i7 + 1;
                            jArr[i7] = query.getLong(0);
                            i7 = i8;
                        }
                        query.close();
                        return jArr;
                    } finally {
                    }
                } else if (query != null) {
                    query.close();
                }
            } catch (SQLException unused) {
            }
        }
        return null;
    }

    @Override // xyz.adscope.common.v2.persistent.db.IBaseDBOperator
    public synchronized int update(IDatabaseModel iDatabaseModel, String str, String[] strArr) {
        if (!isAcceptModel(iDatabaseModel) || !isContentValuesValid(iDatabaseModel)) {
            return 0;
        }
        return this.mWriteAble.update(this.mTableNameMapping.get(iDatabaseModel.getClass()), iDatabaseModel.getContentValuesStruct(), str, strArr);
    }

    @Override // xyz.adscope.common.v2.persistent.db.IBaseDBOperator
    public synchronized int updateByPrimaryKey(IDatabaseModel iDatabaseModel, long j6) {
        return updateSignalCondition(iDatabaseModel, "id", CONDITION_EQUALS, new String[]{String.valueOf(j6)});
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x007f A[Catch: all -> 0x0024, TRY_LEAVE, TryCatch #0 {all -> 0x0024, blocks: (B:3:0x0001, B:5:0x0007, B:7:0x000d, B:9:0x001b, B:12:0x0026, B:22:0x0079, B:24:0x007f, B:29:0x003f, B:32:0x0048, B:33:0x004e, B:36:0x0057, B:37:0x005c, B:40:0x0065, B:41:0x006a, B:43:0x0075), top: B:2:0x0001 }] */
    @Override // xyz.adscope.common.v2.persistent.db.IBaseDBOperator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized int updateSignalCondition(xyz.adscope.common.v2.model.IDatabaseModel r3, java.lang.String r4, java.lang.String r5, java.lang.String[] r6) {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.isAcceptModel(r3)     // Catch: java.lang.Throwable -> L24
            if (r0 == 0) goto L85
            boolean r0 = r2.isContentValuesValid(r3)     // Catch: java.lang.Throwable -> L24
            if (r0 == 0) goto L85
            android.content.ContentValues r0 = r3.getContentValuesStruct()     // Catch: java.lang.Throwable -> L24
            java.util.Set r0 = r0.keySet()     // Catch: java.lang.Throwable -> L24
            boolean r0 = r0.contains(r4)     // Catch: java.lang.Throwable -> L24
            if (r0 != 0) goto L26
            java.lang.String r0 = "id"
            boolean r0 = r4.equals(r0)     // Catch: java.lang.Throwable -> L24
            if (r0 == 0) goto L85
            goto L26
        L24:
            r3 = move-exception
            goto L88
        L26:
            r5.getClass()     // Catch: java.lang.Throwable -> L24
            int r0 = r5.hashCode()     // Catch: java.lang.Throwable -> L24
            r1 = 32644(0x7f84, float:4.5744E-41)
            if (r0 == r1) goto L6a
            r1 = 32675(0x7fa3, float:4.5787E-41)
            if (r0 == r1) goto L5c
            r1 = 32706(0x7fc2, float:4.5831E-41)
            if (r0 == r1) goto L4e
            r1 = 1025915(0xfa77b, float:1.437613E-39)
            if (r0 == r1) goto L3f
            goto L72
        L3f:
            java.lang.String r0 = " IN "
            boolean r5 = r5.equals(r0)     // Catch: java.lang.Throwable -> L24
            if (r5 != 0) goto L48
            goto L72
        L48:
            int r5 = r6.length     // Catch: java.lang.Throwable -> L24
            java.lang.String r4 = r2.whereIn(r4, r5)     // Catch: java.lang.Throwable -> L24
            goto L79
        L4e:
            java.lang.String r0 = " > "
            boolean r5 = r5.equals(r0)     // Catch: java.lang.Throwable -> L24
            if (r5 != 0) goto L57
            goto L72
        L57:
            java.lang.String r4 = r2.whereGreaterThen(r4)     // Catch: java.lang.Throwable -> L24
            goto L79
        L5c:
            java.lang.String r0 = " = "
            boolean r5 = r5.equals(r0)     // Catch: java.lang.Throwable -> L24
            if (r5 != 0) goto L65
            goto L72
        L65:
            java.lang.String r4 = r2.whereEquals(r4)     // Catch: java.lang.Throwable -> L24
            goto L79
        L6a:
            java.lang.String r0 = " < "
            boolean r5 = r5.equals(r0)     // Catch: java.lang.Throwable -> L24
            if (r5 != 0) goto L75
        L72:
            java.lang.String r4 = ""
            goto L79
        L75:
            java.lang.String r4 = r2.whereLessThan(r4)     // Catch: java.lang.Throwable -> L24
        L79:
            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch: java.lang.Throwable -> L24
            if (r5 != 0) goto L85
            int r3 = r2.update(r3, r4, r6)     // Catch: java.lang.Throwable -> L24
            monitor-exit(r2)
            return r3
        L85:
            monitor-exit(r2)
            r3 = 0
            return r3
        L88:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L24
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: xyz.adscope.common.v2.persistent.db.IBaseDbHelper.updateSignalCondition(xyz.adscope.common.v2.model.IDatabaseModel, java.lang.String, java.lang.String, java.lang.String[]):int");
    }

    public String whereBetweenAnd(String str) {
        return String.format("%s BETWEEN ? AND ? ", str);
    }

    public String whereEquals(String str) {
        return String.format(WHERE_CUSTOM_FORMAT, str, CONDITION_EQUALS);
    }

    public String whereGreaterThen(String str) {
        return String.format(WHERE_CUSTOM_FORMAT, str, CONDITION_GREATER_THEN);
    }

    public String whereLessThan(String str) {
        return String.format(WHERE_CUSTOM_FORMAT, str, CONDITION_LESS_THEN);
    }

    private Map<Class<? extends IDatabaseModel>, String> createMappingByModel(List<Class<? extends IDatabaseModel>> list) {
        SDKLog.d(TAG, "创建数据库映射..." + list.size());
        if (list.isEmpty()) {
            return new HashMap();
        }
        HashMap hashMap = new HashMap();
        for (Class<? extends IDatabaseModel> cls : list) {
            hashMap.put(cls, parseTableName(cls));
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createTableByModel(SQLiteDatabase sQLiteDatabase, String str, String[] strArr) {
        if (sQLiteDatabase == null || strArr == null || strArr.length <= 0) {
            return;
        }
        try {
            sQLiteDatabase.beginTransaction();
            StringBuilder sb = new StringBuilder();
            sb.append("create table ");
            sb.append(str);
            sb.append("(");
            sb.append("id");
            sb.append(" integer primary key autoincrement, ");
            for (String str2 : strArr) {
                sb.append(" ");
                sb.append(str2);
                sb.append(" nvarchar, ");
            }
            sb.setCharAt(sb.lastIndexOf(","), ')');
            sQLiteDatabase.execSQL(sb.toString());
            sQLiteDatabase.setTransactionSuccessful();
        } catch (Throwable th) {
            try {
                SDKLog.stack(th);
            } finally {
                sQLiteDatabase.endTransaction();
            }
        }
    }

    private boolean isContentValuesValid(IDatabaseModel iDatabaseModel) {
        return (iDatabaseModel == null || iDatabaseModel.getContentValuesStruct() == null || iDatabaseModel.getContentValuesStruct().size() <= 0) ? false : true;
    }

    private String parseFinalDbName() {
        StringBuilder sb = new StringBuilder();
        String createDBNameWithoutSuffix = createDBNameWithoutSuffix();
        if (!TextUtils.isEmpty(createDBNameWithoutSuffix) && createDBNameWithoutSuffix.lastIndexOf(".") > 0) {
            createDBNameWithoutSuffix = createDBNameWithoutSuffix.substring(createDBNameWithoutSuffix.lastIndexOf(".") + 1);
        }
        sb.append("scope_");
        sb.append(createDBNameWithoutSuffix);
        sb.append("_");
        sb.append(".db");
        return sb.toString();
    }

    @Override // xyz.adscope.common.v2.persistent.db.IBaseDBOperator
    public String getOrderByAsc(String str) {
        return str + " " + IBaseDBOperator.ORDER_BY_ASC;
    }

    @Override // xyz.adscope.common.v2.persistent.db.IBaseDBOperator
    public String getOrderByDesc(String str) {
        return str + " desc";
    }

    @Override // xyz.adscope.common.v2.persistent.db.IBaseDBOperator
    public synchronized <E extends IDatabaseModel> List<E> query(Class<E> cls, String str, String[] strArr, String str2, int i6) {
        return query(cls, null, str, strArr, str2, i6);
    }

    @Override // xyz.adscope.common.v2.persistent.db.IBaseDBOperator
    public String whereBuild(String[] strArr, String[] strArr2) {
        StringBuilder sb = new StringBuilder();
        if (strArr != null && strArr2 != null && strArr.length == strArr2.length) {
            for (int i6 = 0; i6 < strArr.length; i6++) {
                if (i6 > 0) {
                    sb.append(" and ");
                }
                sb.append(String.format(WHERE_CUSTOM_FORMAT, strArr[i6], strArr2[i6]));
            }
        }
        return sb.toString();
    }

    public String whereIn(String str, int i6) {
        StringBuilder sb = new StringBuilder(str + CONDITION_IN);
        sb.append("(");
        for (int i7 = 0; i7 < i6; i7++) {
            sb.append("?");
            if (i7 < i6 - 1) {
                sb.append(",");
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public IBaseDbHelper(Context context) {
        Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        List<Class<? extends IDatabaseModel>> acceptTable = acceptTable();
        this.mAcceptModel = acceptTable;
        this.mTableNameMapping = createMappingByModel(acceptTable);
        DbOpenHelper dbOpenHelper = new DbOpenHelper(this, origApplicationContext, null);
        this.mOpenHelper = dbOpenHelper;
        this.mWriteAble = dbOpenHelper.getWritableDatabase();
    }

    private boolean isAcceptModel(Class<? extends IDatabaseModel> cls) {
        List<Class<? extends IDatabaseModel>> list;
        return (this.mWriteAble == null || (list = this.mAcceptModel) == null || !list.contains(cls)) ? false : true;
    }

    private String parseTableName(Class<? extends IDatabaseModel> cls) {
        return String.format(TABLE_NAME_FORMAT, createDBNameWithoutSuffix(), cls.getSimpleName());
    }

    @Override // xyz.adscope.common.v2.persistent.db.IBaseDBOperator
    public int deleteEqualWhere(Class<? extends IDatabaseModel> cls, String str, String str2) {
        if (isAcceptModel(cls)) {
            return this.mWriteAble.delete(this.mTableNameMapping.get(cls), whereEquals(str), new String[]{str2});
        }
        return -1;
    }

    @Override // xyz.adscope.common.v2.persistent.db.IBaseDBOperator
    public int deleteGreaterThenWhere(Class<? extends IDatabaseModel> cls, String str, String str2) {
        if (isAcceptModel(cls)) {
            return this.mWriteAble.delete(this.mTableNameMapping.get(cls), whereGreaterThen(str), new String[]{str2});
        }
        return -1;
    }

    @Override // xyz.adscope.common.v2.persistent.db.IBaseDBOperator
    public int deleteLessThenWhere(Class<? extends IDatabaseModel> cls, String str, String str2) {
        if (isAcceptModel(cls)) {
            return this.mWriteAble.delete(this.mTableNameMapping.get(cls), whereGreaterThen(str), new String[]{str2});
        }
        return -1;
    }

    @Override // xyz.adscope.common.v2.persistent.db.IBaseDBOperator
    public synchronized <E extends IDatabaseModel> List<E> query(Class<E> cls, String[] strArr, String str, String[] strArr2, String str2, int i6) {
        return query(cls, strArr, str, strArr2, null, str2, null, i6);
    }

    @Override // xyz.adscope.common.v2.persistent.db.IBaseDBOperator
    public synchronized boolean execSQL(Class<? extends IDatabaseModel> cls, String str) {
        Map<Class<? extends IDatabaseModel>, String> map;
        if (!TextUtils.isEmpty(str) && this.mWriteAble != null && str.contains(PLACE_HOLDER_TABLE_NAME) && (map = this.mTableNameMapping) != null) {
            String str2 = map.get(cls);
            if (!TextUtils.isEmpty(str2)) {
                try {
                    this.mWriteAble.execSQL(str.replaceAll(PLACE_HOLDER_TABLE_NAME, str2));
                    return true;
                } catch (SQLException e6) {
                    SDKLog.stack(e6);
                }
            }
        }
        return false;
    }

    @Override // xyz.adscope.common.v2.persistent.db.IBaseDBOperator
    public synchronized <E extends IDatabaseModel> List<E> query(Class<E> cls, String[] strArr, String str, String[] strArr2, String str2, String str3, String str4, int i6) {
        if (isAcceptModel((Class<? extends IDatabaseModel>) cls)) {
            try {
                Cursor query = this.mWriteAble.query(this.mTableNameMapping.get(cls), strArr, str, strArr2, str2, str4, str3, i6 > 0 ? String.valueOf(i6) : null);
                if (query != null) {
                    try {
                        ArrayList arrayList = new ArrayList();
                        while (query.moveToNext()) {
                            try {
                                E newInstance = cls.newInstance();
                                newInstance.parseFromDb(query);
                                arrayList.add(newInstance);
                            } catch (IllegalAccessException | InstantiationException e6) {
                                SDKLog.stack(e6);
                            }
                        }
                        query.close();
                        return arrayList;
                    } finally {
                    }
                } else if (query != null) {
                    query.close();
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    protected void upgrade(SQLiteDatabase sQLiteDatabase, int i6, int i7) {
    }
}
