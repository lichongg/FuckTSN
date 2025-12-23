package com.umeng.analytics.process;

import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.umeng.analytics.process.DBFileTraversalUtil;
import com.umeng.analytics.process.a;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.utils.FileLockCallback;
import com.umeng.commonsdk.utils.FileLockUtil;
import com.umeng.commonsdk.utils.UMUtils;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class UMProcessDBHelper {
    private static UMProcessDBHelper mInstance;
    private Context mContext;
    private FileLockUtil mFileLock = new FileLockUtil();
    private InsertEventCallback ekvCallBack = new InsertEventCallback();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class InsertEventCallback implements FileLockCallback {
        private InsertEventCallback() {
        }

        @Override // com.umeng.commonsdk.utils.FileLockCallback
        public boolean onFileLock(File file, int i6) {
            return false;
        }

        @Override // com.umeng.commonsdk.utils.FileLockCallback
        public boolean onFileLock(String str) {
            return false;
        }

        @Override // com.umeng.commonsdk.utils.FileLockCallback
        public boolean onFileLock(String str, Object obj) {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            String str2 = com.umeng.analytics.process.a.f41502c;
            if (str.startsWith(str2)) {
                str = str.replaceFirst(str2, "");
            }
            UMProcessDBHelper.this.insertEvents(str.replace(com.umeng.analytics.process.a.f41503d, ""), (JSONArray) obj);
            return true;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class ProcessToMainCallback implements FileLockCallback {
        private ProcessToMainCallback() {
        }

        @Override // com.umeng.commonsdk.utils.FileLockCallback
        public boolean onFileLock(File file, int i6) {
            return false;
        }

        @Override // com.umeng.commonsdk.utils.FileLockCallback
        public boolean onFileLock(String str, Object obj) {
            return false;
        }

        @Override // com.umeng.commonsdk.utils.FileLockCallback
        public boolean onFileLock(String str) {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            String str2 = com.umeng.analytics.process.a.f41502c;
            if (str.startsWith(str2)) {
                str = str.replaceFirst(str2, "");
            }
            UMProcessDBHelper.this.processToMain(str.replace(com.umeng.analytics.process.a.f41503d, ""));
            return true;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class a implements Serializable {

        /* renamed from: a, reason: collision with root package name */
        int f41491a;

        /* renamed from: b, reason: collision with root package name */
        String f41492b;

        /* renamed from: c, reason: collision with root package name */
        String f41493c;

        /* renamed from: d, reason: collision with root package name */
        String f41494d;

        /* renamed from: e, reason: collision with root package name */
        int f41495e;

        /* renamed from: f, reason: collision with root package name */
        String f41496f;

        /* renamed from: g, reason: collision with root package name */
        String f41497g;

        /* renamed from: h, reason: collision with root package name */
        String f41498h;

        private a() {
        }
    }

    private UMProcessDBHelper() {
    }

    private int getDataSource() {
        return 0;
    }

    private List<a> datasAdapter(String str, JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            for (int i6 = 0; i6 < jSONArray.length(); i6++) {
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i6);
                    a aVar = new a();
                    aVar.f41493c = jSONObject.optString("id");
                    aVar.f41497g = UMUtils.getAppVersionName(this.mContext);
                    aVar.f41498h = UMUtils.getAppVersionCode(this.mContext);
                    aVar.f41492b = jSONObject.optString("__i");
                    aVar.f41495e = jSONObject.optInt("__t");
                    aVar.f41496f = str;
                    if (jSONObject.has("ds")) {
                        jSONObject.remove("ds");
                    }
                    jSONObject.put("ds", getDataSource());
                    jSONObject.remove("__i");
                    jSONObject.remove("__t");
                    aVar.f41494d = com.umeng.common.a.a().a(jSONObject.toString());
                    jSONObject.remove("ds");
                    arrayList.add(aVar);
                } catch (Exception unused) {
                }
            }
        }
        return arrayList;
    }

    private boolean dbIsExists(String str) {
        try {
            return new File(b.b(this.mContext, str)).exists();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static UMProcessDBHelper getInstance(Context context) {
        if (mInstance == null) {
            synchronized (UMProcessDBHelper.class) {
                try {
                    if (mInstance == null) {
                        mInstance = new UMProcessDBHelper(context);
                    }
                } finally {
                }
            }
        }
        UMProcessDBHelper uMProcessDBHelper = mInstance;
        uMProcessDBHelper.mContext = context;
        return uMProcessDBHelper;
    }

    private boolean processIsService(Context context) {
        return context.getPackageManager().getServiceInfo(new ComponentName(context, this.mContext.getClass()), 0) != null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x00b4, code lost:
    
        if (r3 != null) goto L16;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.umeng.analytics.process.UMProcessDBHelper$1] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v2, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r2v3, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.util.List<com.umeng.analytics.process.UMProcessDBHelper.a> readEventByProcess(java.lang.String r12) {
        /*
            r11 = this;
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r2 = 0
            android.content.Context r0 = r11.mContext     // Catch: java.lang.Throwable -> La7 java.lang.Exception -> Laa
            com.umeng.analytics.process.c r0 = com.umeng.analytics.process.c.a(r0)     // Catch: java.lang.Throwable -> La7 java.lang.Exception -> Laa
            android.database.sqlite.SQLiteDatabase r3 = r0.a(r12)     // Catch: java.lang.Throwable -> La7 java.lang.Exception -> Laa
            r3.beginTransaction()     // Catch: java.lang.Throwable -> La3 java.lang.Exception -> La5
            java.lang.String r4 = "__et_p"
            r9 = 0
            r10 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r4 = r3.query(r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> La3 java.lang.Exception -> La5
            if (r4 == 0) goto L91
        L21:
            boolean r0 = r4.moveToNext()     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L8e
            if (r0 == 0) goto L91
            com.umeng.analytics.process.UMProcessDBHelper$a r0 = new com.umeng.analytics.process.UMProcessDBHelper$a     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L8e
            r0.<init>()     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L8e
            r5 = 0
            int r5 = r4.getInt(r5)     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L8e
            r0.f41491a = r5     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L8e
            java.lang.String r5 = "__i"
            int r5 = r4.getColumnIndex(r5)     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L8e
            java.lang.String r5 = r4.getString(r5)     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L8e
            r0.f41492b = r5     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L8e
            java.lang.String r5 = "__e"
            int r5 = r4.getColumnIndex(r5)     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L8e
            java.lang.String r5 = r4.getString(r5)     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L8e
            r0.f41493c = r5     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L8e
            java.lang.String r5 = "__s"
            int r5 = r4.getColumnIndex(r5)     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L8e
            java.lang.String r5 = r4.getString(r5)     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L8e
            r0.f41494d = r5     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L8e
            java.lang.String r5 = "__t"
            int r5 = r4.getColumnIndex(r5)     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L8e
            int r5 = r4.getInt(r5)     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L8e
            r0.f41495e = r5     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L8e
            java.lang.String r5 = "__pn"
            int r5 = r4.getColumnIndex(r5)     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L8e
            java.lang.String r5 = r4.getString(r5)     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L8e
            r0.f41496f = r5     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L8e
            java.lang.String r5 = "__av"
            int r5 = r4.getColumnIndex(r5)     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L8e
            java.lang.String r5 = r4.getString(r5)     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L8e
            r0.f41497g = r5     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L8e
            java.lang.String r5 = "__vc"
            int r5 = r4.getColumnIndex(r5)     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L8e
            java.lang.String r5 = r4.getString(r5)     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L8e
            r0.f41498h = r5     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L8e
            r1.add(r0)     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L8e
            goto L21
        L8b:
            r0 = move-exception
            r2 = r4
            goto Lb8
        L8e:
            r0 = move-exception
            r2 = r4
            goto Lac
        L91:
            if (r4 == 0) goto L96
            r4.close()     // Catch: java.lang.Exception -> L99
        L96:
            r3.endTransaction()     // Catch: java.lang.Exception -> L99
        L99:
            android.content.Context r0 = r11.mContext
            com.umeng.analytics.process.c r0 = com.umeng.analytics.process.c.a(r0)
            r0.b(r12)
            goto Lb7
        La3:
            r0 = move-exception
            goto Lb8
        La5:
            r0 = move-exception
            goto Lac
        La7:
            r0 = move-exception
            r3 = r2
            goto Lb8
        Laa:
            r0 = move-exception
            r3 = r2
        Lac:
            r0.printStackTrace()     // Catch: java.lang.Throwable -> La3
            if (r2 == 0) goto Lb4
            r2.close()     // Catch: java.lang.Exception -> L99
        Lb4:
            if (r3 == 0) goto L99
            goto L96
        Lb7:
            return r1
        Lb8:
            if (r2 == 0) goto Lbd
            r2.close()     // Catch: java.lang.Exception -> Lc2
        Lbd:
            if (r3 == 0) goto Lc2
            r3.endTransaction()     // Catch: java.lang.Exception -> Lc2
        Lc2:
            android.content.Context r1 = r11.mContext
            com.umeng.analytics.process.c r1 = com.umeng.analytics.process.c.a(r1)
            r1.b(r12)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.process.UMProcessDBHelper.readEventByProcess(java.lang.String):java.util.List");
    }

    public void createDBByProcess(String str) {
        try {
            c.a(this.mContext).a(str);
            c.a(this.mContext).b(str);
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0053, code lost:
    
        if (r1 == null) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void deleteMainProcessEventDatasByIds(java.util.List<java.lang.Integer> r6) {
        /*
            r5 = this;
            java.lang.String r0 = "_main_"
            r1 = 0
            android.content.Context r2 = r5.mContext     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L32
            com.umeng.analytics.process.c r2 = com.umeng.analytics.process.c.a(r2)     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L32
            android.database.sqlite.SQLiteDatabase r1 = r2.a(r0)     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L32
            r1.beginTransaction()     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L32
            java.util.Iterator r6 = r6.iterator()     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L32
        L14:
            boolean r2 = r6.hasNext()     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L32
            if (r2 == 0) goto L34
            java.lang.Object r2 = r6.next()     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L32
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L32
            java.lang.String r3 = "__et_p"
            java.lang.String r4 = "id=?"
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L32
            java.lang.String[] r2 = new java.lang.String[]{r2}     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L32
            r1.delete(r3, r4, r2)     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L32
            goto L14
        L30:
            r6 = move-exception
            goto L44
        L32:
            goto L53
        L34:
            r1.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L32
        L37:
            r1.endTransaction()
        L3a:
            android.content.Context r6 = r5.mContext
            com.umeng.analytics.process.c r6 = com.umeng.analytics.process.c.a(r6)
            r6.b(r0)
            return
        L44:
            if (r1 == 0) goto L49
            r1.endTransaction()
        L49:
            android.content.Context r1 = r5.mContext
            com.umeng.analytics.process.c r1 = com.umeng.analytics.process.c.a(r1)
            r1.b(r0)
            throw r6
        L53:
            if (r1 == 0) goto L3a
            goto L37
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.process.UMProcessDBHelper.deleteMainProcessEventDatasByIds(java.util.List):void");
    }

    public void insertEvents(String str, JSONArray jSONArray) {
        if (AnalyticsConstants.SUB_PROCESS_EVENT && !TextUtils.isEmpty(str)) {
            insertEvents_(str, datasAdapter(str, jSONArray));
        }
    }

    public void insertEventsInSubProcess(String str, JSONArray jSONArray) {
        if (AnalyticsConstants.SUB_PROCESS_EVENT && !TextUtils.isEmpty(str)) {
            File file = new File(b.b(this.mContext, str));
            if (file.exists()) {
                this.mFileLock.doFileOperateion(file, this.ekvCallBack, jSONArray);
            } else {
                insertEvents(str, jSONArray);
            }
        }
    }

    public void processDBToMain() {
        try {
            DBFileTraversalUtil.traverseDBFiles(b.a(this.mContext), new ProcessToMainCallback(), new DBFileTraversalUtil.a() { // from class: com.umeng.analytics.process.UMProcessDBHelper.1
                @Override // com.umeng.analytics.process.DBFileTraversalUtil.a
                public void a() {
                    if (AnalyticsConstants.SUB_PROCESS_EVENT) {
                        UMWorkDispatch.sendEvent(UMProcessDBHelper.this.mContext, UMProcessDBDatasSender.UM_PROCESS_CONSTRUCTMESSAGE, UMProcessDBDatasSender.getInstance(UMProcessDBHelper.this.mContext), null);
                    }
                }
            });
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00d2 A[Catch: all -> 0x00a8, Exception -> 0x00ab, TryCatch #6 {Exception -> 0x00ab, all -> 0x00a8, blocks: (B:6:0x0016, B:8:0x0027, B:10:0x002e, B:12:0x0034, B:15:0x0077, B:18:0x007e, B:27:0x0088, B:29:0x009f, B:32:0x00cc, B:34:0x00d2, B:35:0x00dc, B:37:0x00eb, B:39:0x00f2, B:61:0x00d7, B:62:0x00af, B:43:0x0107, B:45:0x010d, B:46:0x0116, B:48:0x011c, B:51:0x0139, B:56:0x013d, B:58:0x0143, B:68:0x0148), top: B:5:0x0016 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00d7 A[Catch: all -> 0x00a8, Exception -> 0x00ab, TryCatch #6 {Exception -> 0x00ab, all -> 0x00a8, blocks: (B:6:0x0016, B:8:0x0027, B:10:0x002e, B:12:0x0034, B:15:0x0077, B:18:0x007e, B:27:0x0088, B:29:0x009f, B:32:0x00cc, B:34:0x00d2, B:35:0x00dc, B:37:0x00eb, B:39:0x00f2, B:61:0x00d7, B:62:0x00af, B:43:0x0107, B:45:0x010d, B:46:0x0116, B:48:0x011c, B:51:0x0139, B:56:0x013d, B:58:0x0143, B:68:0x0148), top: B:5:0x0016 }] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0184 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public org.json.JSONObject readMainEvents(long r19, java.util.List<java.lang.Integer> r21) {
        /*
            Method dump skipped, instructions count: 401
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.process.UMProcessDBHelper.readMainEvents(long, java.util.List):org.json.JSONObject");
    }

    public JSONObject readVersionInfoFromColumId(Integer num) {
        SQLiteDatabase sQLiteDatabase;
        JSONObject jSONObject;
        Cursor cursor = null;
        r3 = null;
        JSONObject jSONObject2 = null;
        cursor = null;
        cursor = null;
        cursor = null;
        try {
            sQLiteDatabase = c.a(this.mContext).a(com.umeng.analytics.process.a.f41507h);
            try {
                try {
                    sQLiteDatabase.beginTransaction();
                    Cursor query = sQLiteDatabase.query(a.InterfaceC0824a.f41508a, null, "rowid=?", new String[]{String.valueOf(num)}, null, null, null);
                    if (query != null) {
                        try {
                            try {
                                if (query.moveToNext()) {
                                    jSONObject = new JSONObject();
                                    try {
                                        String string = query.getString(query.getColumnIndex("__av"));
                                        String string2 = query.getString(query.getColumnIndex("__vc"));
                                        if (!TextUtils.isEmpty(string)) {
                                            jSONObject.put("__av", string);
                                        }
                                        if (!TextUtils.isEmpty(string2)) {
                                            jSONObject.put("__vc", string2);
                                        }
                                        jSONObject2 = jSONObject;
                                    } catch (Exception e6) {
                                        e = e6;
                                        cursor = query;
                                        e.printStackTrace();
                                        if (cursor != null) {
                                            try {
                                                cursor.close();
                                            } catch (Exception unused) {
                                                c.a(this.mContext).b(com.umeng.analytics.process.a.f41507h);
                                                return jSONObject;
                                            }
                                        }
                                        if (sQLiteDatabase != null) {
                                            sQLiteDatabase.endTransaction();
                                        }
                                        c.a(this.mContext).b(com.umeng.analytics.process.a.f41507h);
                                        return jSONObject;
                                    }
                                }
                            } catch (Throwable th) {
                                th = th;
                                cursor = query;
                                if (cursor != null) {
                                    try {
                                        cursor.close();
                                    } catch (Exception unused2) {
                                        c.a(this.mContext).b(com.umeng.analytics.process.a.f41507h);
                                        throw th;
                                    }
                                }
                                if (sQLiteDatabase != null) {
                                    sQLiteDatabase.endTransaction();
                                }
                                c.a(this.mContext).b(com.umeng.analytics.process.a.f41507h);
                                throw th;
                            }
                        } catch (Exception e7) {
                            e = e7;
                            jSONObject = null;
                        }
                    }
                    if (query != null) {
                        try {
                            query.close();
                        } catch (Exception unused3) {
                        }
                    }
                    sQLiteDatabase.endTransaction();
                    c.a(this.mContext).b(com.umeng.analytics.process.a.f41507h);
                    return jSONObject2;
                } catch (Exception e8) {
                    e = e8;
                    jSONObject = null;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e9) {
            e = e9;
            jSONObject = null;
            sQLiteDatabase = null;
        } catch (Throwable th3) {
            th = th3;
            sQLiteDatabase = null;
        }
    }

    private boolean insertEvents_(String str, List<a> list) {
        SQLiteDatabase a6;
        if (TextUtils.isEmpty(str) || list == null || list.isEmpty()) {
            return true;
        }
        SQLiteDatabase sQLiteDatabase = null;
        try {
            a6 = c.a(this.mContext).a(str);
        } catch (Exception unused) {
        } catch (Throwable th) {
            th = th;
        }
        try {
            try {
                a6.beginTransaction();
                for (a aVar : list) {
                    try {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("__i", aVar.f41492b);
                        contentValues.put("__e", aVar.f41493c);
                        contentValues.put("__t", Integer.valueOf(aVar.f41495e));
                        contentValues.put(a.InterfaceC0824a.f41513f, aVar.f41496f);
                        contentValues.put("__av", aVar.f41497g);
                        contentValues.put("__vc", aVar.f41498h);
                        contentValues.put("__s", aVar.f41494d);
                        a6.insert(a.InterfaceC0824a.f41508a, null, contentValues);
                    } catch (Exception unused2) {
                    }
                }
                a6.setTransactionSuccessful();
                try {
                    a6.endTransaction();
                } catch (Throwable unused3) {
                }
                c.a(this.mContext).b(str);
                return true;
            } catch (Throwable th2) {
                th = th2;
                sQLiteDatabase = a6;
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (Throwable unused4) {
                    }
                }
                c.a(this.mContext).b(str);
                throw th;
            }
        } catch (Exception unused5) {
            sQLiteDatabase = a6;
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Throwable unused6) {
                }
            }
            c.a(this.mContext).b(str);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processToMain(String str) {
        if (dbIsExists(str)) {
            List<a> readEventByProcess = readEventByProcess(str);
            if (!readEventByProcess.isEmpty() && insertEvents_(com.umeng.analytics.process.a.f41507h, readEventByProcess)) {
                deleteEventDatas(str, null, readEventByProcess);
            }
        }
    }

    public void deleteEventDatas(String str, String str2, List<a> list) {
        SQLiteDatabase sQLiteDatabase;
        Throwable th;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        SQLiteDatabase sQLiteDatabase2 = null;
        try {
            sQLiteDatabase = c.a(this.mContext).a(str);
        } catch (Exception unused) {
        } catch (Throwable th2) {
            sQLiteDatabase = null;
            th = th2;
        }
        try {
            sQLiteDatabase.beginTransaction();
            int size = list.size();
            if (size > 0) {
                for (int i6 = 0; i6 < size; i6++) {
                    sQLiteDatabase.execSQL("delete from __et_p where rowid=" + list.get(i6).f41491a);
                }
            } else {
                sQLiteDatabase.delete(a.InterfaceC0824a.f41508a, null, null);
            }
            sQLiteDatabase.setTransactionSuccessful();
            sQLiteDatabase.endTransaction();
        } catch (Exception unused2) {
            sQLiteDatabase2 = sQLiteDatabase;
            if (sQLiteDatabase2 != null) {
                sQLiteDatabase2.endTransaction();
            }
            c.a(this.mContext).b(str);
        } catch (Throwable th3) {
            th = th3;
            if (sQLiteDatabase != null) {
                sQLiteDatabase.endTransaction();
            }
            c.a(this.mContext).b(str);
            throw th;
        }
        c.a(this.mContext).b(str);
    }

    private UMProcessDBHelper(Context context) {
        com.umeng.common.a.a().a(context);
    }
}
