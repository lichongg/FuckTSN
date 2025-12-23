package xyz.adscope.common.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import xyz.adscope.common.constants.CommonConstants;
import xyz.adscope.common.tool.LogUtil;
import xyz.adscope.common.tool.security.Base64Util;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class CommonDataBase {
    private void a(Map<String, Object> map, StringBuilder sb, String[] strArr, String str) {
        int i6 = 0;
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value != null) {
                if (value instanceof String) {
                    strArr[i6] = Base64Util.encode(String.valueOf(value));
                } else {
                    strArr[i6] = String.valueOf(value);
                }
            }
            if (i6 > 0) {
                sb.append(" and ");
            }
            sb.append(key);
            sb.append(str);
            i6++;
            LogUtil.i(CommonConstants.TAG, "for循环执行了这个逻辑 + flag " + i6);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0108, code lost:
    
        if (r7.inTransaction() != false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x012b, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0127, code lost:
    
        r7.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0125, code lost:
    
        if (r7.inTransaction() == false) goto L43;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized <T> void createTable(android.database.sqlite.SQLiteDatabase r7, java.lang.String r8, java.lang.Class<T> r9, java.util.List<java.lang.String> r10) {
        /*
            Method dump skipped, instructions count: 312
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: xyz.adscope.common.db.CommonDataBase.createTable(android.database.sqlite.SQLiteDatabase, java.lang.String, java.lang.Class, java.util.List):void");
    }

    public <T> List<T> cursorToList(Cursor cursor, Class<T> cls) {
        ArrayList arrayList = new ArrayList();
        String[] columnNames = cursor.getColumnNames();
        while (cursor.moveToNext()) {
            try {
                T newInstance = cls.newInstance();
                for (String str : columnNames) {
                    int columnIndex = cursor.getColumnIndex(str);
                    if (!"id".equals(str)) {
                        Field declaredField = cls.getDeclaredField(str);
                        declaredField.setAccessible(true);
                        if (declaredField.getType() != Integer.TYPE && declaredField.getType() != Integer.class) {
                            if (declaredField.getType() != Long.TYPE && declaredField.getType() != Long.class) {
                                if (declaredField.getType() != Float.TYPE && declaredField.getType() != Float.class) {
                                    if (declaredField.getType() != Double.TYPE && declaredField.getType() != Double.class) {
                                        if (declaredField.getType() != String.class) {
                                            throw new IllegalArgumentException("Unsupported field type: " + declaredField.getType());
                                        }
                                        declaredField.set(newInstance, Base64Util.decode(cursor.getString(columnIndex)));
                                    }
                                    declaredField.set(newInstance, Double.valueOf(cursor.getDouble(columnIndex)));
                                }
                                declaredField.set(newInstance, Float.valueOf(cursor.getFloat(columnIndex)));
                            }
                            declaredField.set(newInstance, Long.valueOf(cursor.getLong(columnIndex)));
                        }
                        declaredField.set(newInstance, Integer.valueOf(cursor.getInt(columnIndex)));
                    }
                }
                arrayList.add(newInstance);
            } catch (Exception e6) {
                LogUtil.e(CommonConstants.TAG, "e : " + e6);
            }
        }
        return arrayList;
    }

    public synchronized int deleteTable(SQLiteDatabase sQLiteDatabase, String str, String str2, Object obj) {
        if (sQLiteDatabase == null) {
            return 0;
        }
        try {
            try {
                Map<String, Object> a6 = obj instanceof Map ? (Map) obj : a(obj);
                StringBuilder sb = new StringBuilder();
                String[] strArr = new String[a6.size()];
                a(a6, sb, strArr, str2);
                int delete = sQLiteDatabase.delete(str, sb.toString(), strArr);
                LogUtil.i(CommonConstants.TAG, "deleteResult : " + delete);
                return delete;
            } catch (Exception e6) {
                LogUtil.e(CommonConstants.TAG, "e : " + e6);
                return 0;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized long insertTable(SQLiteDatabase sQLiteDatabase, String str, Object obj) {
        try {
            if (sQLiteDatabase == null) {
                return 0L;
            }
            try {
                Map<String, Object> a6 = obj instanceof Map ? (Map) obj : a(obj);
                ContentValues contentValues = new ContentValues();
                for (Map.Entry<String, Object> entry : a6.entrySet()) {
                    String key = entry.getKey();
                    Object value = entry.getValue();
                    if (value != null) {
                        if (value instanceof Integer) {
                            contentValues.put(key, Integer.valueOf(Integer.parseInt(String.valueOf(value))));
                        } else if (value instanceof Long) {
                            contentValues.put(key, Long.valueOf(Long.parseLong(String.valueOf(value))));
                        } else if (value instanceof Float) {
                            contentValues.put(key, Float.valueOf(Float.parseFloat(String.valueOf(value))));
                        } else if (value instanceof Double) {
                            contentValues.put(key, Double.valueOf(Double.parseDouble(String.valueOf(value))));
                        } else {
                            if (!(value instanceof String)) {
                                throw new IllegalArgumentException("Unsupported value type: " + value);
                            }
                            contentValues.put(key, Base64Util.encode(String.valueOf(value)));
                        }
                    }
                }
                LogUtil.i(CommonConstants.TAG, "contentValues : " + contentValues);
                long insert = sQLiteDatabase.insert(str, null, contentValues);
                LogUtil.i(CommonConstants.TAG, "insertResult : " + insert);
                return insert;
            } catch (Exception e6) {
                LogUtil.e(CommonConstants.TAG, "e : " + e6);
                return 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public boolean isTableExists(SQLiteDatabase sQLiteDatabase, String str) {
        if (str != null && sQLiteDatabase != null) {
            try {
                if (sQLiteDatabase.isOpen()) {
                    Cursor query = sQLiteDatabase.query("sqlite_master", new String[]{CommonNetImpl.NAME}, "type = ? AND name = ?", new String[]{"table", str}, null, null, null);
                    if (query == null) {
                        return false;
                    }
                    boolean z5 = query.getCount() > 0;
                    query.close();
                    return z5;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return false;
    }

    public synchronized String querySingleData(SQLiteDatabase sQLiteDatabase, String str, Object obj, String[] strArr, String str2, String str3, String str4) {
        if (sQLiteDatabase == null) {
            return null;
        }
        try {
            try {
                Map<String, Object> a6 = obj instanceof Map ? (Map) obj : a(obj);
                StringBuilder sb = new StringBuilder();
                String[] strArr2 = new String[a6.size()];
                a(a6, sb, strArr2, str2);
                LogUtil.i(CommonConstants.TAG, "selectionStr : " + ((Object) sb) + " , selectionArgs : " + strArr2);
                Cursor query = sQLiteDatabase.query(str, strArr, sb.toString(), strArr2, null, null, str3, str4);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("queryCursor : ");
                sb2.append(query);
                LogUtil.i(CommonConstants.TAG, sb2.toString());
                String decode = query.moveToFirst() ? Base64Util.decode(query.getString(query.getColumnIndex(strArr[0]))) : "";
                LogUtil.i(CommonConstants.TAG, "result : " + decode);
                return decode;
            } catch (Exception e6) {
                LogUtil.e(CommonConstants.TAG, "e : " + e6);
                return null;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized <T> List<T> querySingleTable(SQLiteDatabase sQLiteDatabase, String str, Class<T> cls, Object obj, String str2, String str3, String str4) {
        if (sQLiteDatabase == null) {
            return null;
        }
        try {
            try {
                Map<String, Object> a6 = obj instanceof Map ? (Map) obj : a(obj);
                StringBuilder sb = new StringBuilder();
                String[] strArr = new String[a6.size()];
                a(a6, sb, strArr, str2);
                LogUtil.i(CommonConstants.TAG, "selectionStr : " + ((Object) sb) + " , selectionArgs : " + strArr);
                Cursor query = sQLiteDatabase.query(str, null, sb.toString(), strArr, null, null, str3, str4);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("queryCursor : ");
                sb2.append(query);
                LogUtil.i(CommonConstants.TAG, sb2.toString());
                List<T> cursorToList = cursorToList(query, cls);
                LogUtil.i(CommonConstants.TAG, "mapResult : " + cursorToList);
                return cursorToList;
            } catch (Exception e6) {
                LogUtil.e(CommonConstants.TAG, "e : " + e6);
                return null;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized <T> List<T> queryTable(SQLiteDatabase sQLiteDatabase, String str, Class<T> cls, Object obj, String str2) {
        Cursor query;
        if (sQLiteDatabase == null) {
            return null;
        }
        try {
            try {
                if (obj != null) {
                    Map<String, Object> a6 = obj instanceof Map ? (Map) obj : a(obj);
                    StringBuilder sb = new StringBuilder();
                    String[] strArr = new String[a6.size()];
                    a(a6, sb, strArr, str2);
                    LogUtil.i(CommonConstants.TAG, "selectionStr : " + ((Object) sb) + " , selectionArgs : " + strArr);
                    query = sQLiteDatabase.query(str, null, sb.toString(), strArr, null, null, null);
                } else {
                    query = sQLiteDatabase.query(str, null, null, null, null, null, null);
                }
                LogUtil.i(CommonConstants.TAG, "queryCursor : " + query);
                List<T> cursorToList = cursorToList(query, cls);
                LogUtil.i(CommonConstants.TAG, "mapResult : " + cursorToList);
                return cursorToList;
            } catch (Exception e6) {
                LogUtil.e(CommonConstants.TAG, "e : " + e6);
                return null;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized int updateTable(SQLiteDatabase sQLiteDatabase, String str, ContentValues contentValues, String str2, Object obj) {
        if (sQLiteDatabase == null) {
            return 0;
        }
        try {
            try {
                Map<String, Object> a6 = obj instanceof Map ? (Map) obj : a(obj);
                StringBuilder sb = new StringBuilder();
                String[] strArr = new String[a6.size()];
                a(a6, sb, strArr, str2);
                int update = sQLiteDatabase.update(str, contentValues, sb.toString(), strArr);
                LogUtil.i(CommonConstants.TAG, "updateResult : " + update);
                return update;
            } catch (Exception e6) {
                LogUtil.e(CommonConstants.TAG, "e : " + e6);
                return 0;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private Map<String, String> a(Class<?> cls) {
        HashMap hashMap = new HashMap();
        for (Field field : cls.getDeclaredFields()) {
            hashMap.put(field.getName(), "nvarchar");
        }
        return hashMap;
    }

    public synchronized <T> List<T> queryTable(SQLiteDatabase sQLiteDatabase, String str, Class<T> cls, String str2, String str3, String str4, String str5) {
        if (sQLiteDatabase == null) {
            return null;
        }
        try {
            Cursor query = sQLiteDatabase.query(str, null, null, null, str2, str3, str4, str5);
            LogUtil.i(CommonConstants.TAG, "queryCursor : " + query);
            List<T> cursorToList = cursorToList(query, cls);
            LogUtil.i(CommonConstants.TAG, "mapResult : " + cursorToList);
            return cursorToList;
        } catch (Exception e6) {
            LogUtil.e(CommonConstants.TAG, "e : " + e6);
            return null;
        }
    }

    private Map<String, Object> a(Object obj) {
        HashMap hashMap = new HashMap();
        for (Field field : obj.getClass().getDeclaredFields()) {
            String name = field.getName();
            try {
                field.setAccessible(true);
                Object obj2 = field.get(obj);
                if (obj2 != null) {
                    hashMap.put(name, obj2);
                }
            } catch (IllegalAccessException e6) {
                e6.printStackTrace();
            }
        }
        return hashMap;
    }
}
