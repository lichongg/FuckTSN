package com.umeng.socialize.net.dplus.cache1;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import com.umeng.socialize.c.b.a;
import com.umeng.socialize.common.SocializeConstants;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import com.umeng.socialize.net.dplus.db.DBConfig;
import com.umeng.socialize.net.dplus.db.DBManager;
import com.umeng.socialize.utils.ContextUtil;
import java.io.File;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class DplusCacheApi {

    /* renamed from: a, reason: collision with root package name */
    private static final String f42447a = "DplusCacheApi";

    /* renamed from: b, reason: collision with root package name */
    private HandlerThread f42448b;

    /* renamed from: c, reason: collision with root package name */
    private Handler f42449c;

    /* renamed from: d, reason: collision with root package name */
    private final int f42450d;

    /* renamed from: e, reason: collision with root package name */
    private ArrayList<Integer> f42451e;

    /* renamed from: f, reason: collision with root package name */
    private ArrayList<Integer> f42452f;

    /* renamed from: g, reason: collision with root package name */
    private ArrayList<Integer> f42453g;

    /* renamed from: h, reason: collision with root package name */
    private ArrayList<Integer> f42454h;

    /* renamed from: i, reason: collision with root package name */
    private ArrayList<Integer> f42455i;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class SingletonHolder {

        /* renamed from: a, reason: collision with root package name */
        private static final DplusCacheApi f42472a = new DplusCacheApi();

        private SingletonHolder() {
        }
    }

    private DplusCacheApi() {
        this.f42450d = 1048576;
        this.f42451e = new ArrayList<>();
        this.f42452f = new ArrayList<>();
        this.f42453g = new ArrayList<>();
        this.f42454h = new ArrayList<>();
        this.f42455i = new ArrayList<>();
        HandlerThread handlerThread = new HandlerThread(f42447a, 10);
        this.f42448b = handlerThread;
        handlerThread.start();
        this.f42449c = new Handler(this.f42448b.getLooper());
    }

    private static JSONObject a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("s_sdk_v", "7.3.2");
        jSONObject.put(CommonNetImpl.PCV, SocializeConstants.PROTOCOL_VERSON);
        return jSONObject;
    }

    public static double checkFile() {
        File dataFile = ContextUtil.getDataFile(DBConfig.DB_NAME);
        if (dataFile == null || !dataFile.exists()) {
            return 0.0d;
        }
        return dataFile.length();
    }

    public void cleanCache(final Context context) {
        this.f42449c.post(new Runnable() { // from class: com.umeng.socialize.net.dplus.cache1.DplusCacheApi.2
            @Override // java.lang.Runnable
            public void run() {
                a.a(context);
            }
        });
    }

    public void closeDBConnection(final Context context) {
        this.f42449c.post(new Runnable() { // from class: com.umeng.socialize.net.dplus.cache1.DplusCacheApi.1
            @Override // java.lang.Runnable
            public void run() {
                DBManager.get(context).closeDatabase();
            }
        });
    }

    public void deleteAll(Context context) {
        this.f42449c.post(new Runnable() { // from class: com.umeng.socialize.net.dplus.cache1.DplusCacheApi.6
            @Override // java.lang.Runnable
            public void run() {
                DBManager.get(ContextUtil.getContext()).deleteTable("stats");
            }
        });
    }

    public void deleteFile(final Context context) {
        this.f42449c.post(new Runnable() { // from class: com.umeng.socialize.net.dplus.cache1.DplusCacheApi.5
            @Override // java.lang.Runnable
            public void run() {
                if (DplusCacheApi.this.f42451e.size() > 0) {
                    DBManager.get(context).delete(DplusCacheApi.this.f42451e, "s_e");
                    DplusCacheApi.this.f42451e.clear();
                }
                if (DplusCacheApi.this.f42452f.size() > 0) {
                    DBManager.get(context).delete(DplusCacheApi.this.f42452f, "auth");
                    DplusCacheApi.this.f42452f.clear();
                }
                if (DplusCacheApi.this.f42454h.size() > 0) {
                    DBManager.get(context).delete(DplusCacheApi.this.f42454h, "dau");
                    DplusCacheApi.this.f42454h.clear();
                }
                if (DplusCacheApi.this.f42453g.size() > 0) {
                    DBManager.get(context).delete(DplusCacheApi.this.f42453g, "userinfo");
                    DplusCacheApi.this.f42453g.clear();
                }
                if (DplusCacheApi.this.f42455i.size() > 0) {
                    DBManager.get(context).delete(DplusCacheApi.this.f42455i, "stats");
                    DplusCacheApi.this.f42455i.clear();
                }
            }
        });
    }

    public void deleteFileAsnc(Context context) {
        if (this.f42451e.size() > 0) {
            DBManager.get(context).delete(this.f42451e, "s_e");
            this.f42451e.clear();
        }
        if (this.f42452f.size() > 0) {
            DBManager.get(context).delete(this.f42452f, "auth");
            this.f42452f.clear();
        }
        if (this.f42454h.size() > 0) {
            DBManager.get(context).delete(this.f42454h, "dau");
            this.f42454h.clear();
        }
        if (this.f42453g.size() > 0) {
            DBManager.get(context).delete(this.f42453g, "userinfo");
            this.f42453g.clear();
        }
        if (this.f42455i.size() > 0) {
            DBManager.get(context).delete(this.f42455i, "stats");
            this.f42455i.clear();
        }
    }

    public void readFile(final Context context, final int i6, final DplusCacheListener dplusCacheListener) {
        this.f42449c.post(new Runnable() { // from class: com.umeng.socialize.net.dplus.cache1.DplusCacheApi.4
            /* JADX WARN: Removed duplicated region for block: B:42:0x016c  */
            /* JADX WARN: Removed duplicated region for block: B:45:0x0175  */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void run() {
                /*
                    Method dump skipped, instructions count: 398
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.umeng.socialize.net.dplus.cache1.DplusCacheApi.AnonymousClass4.run():void");
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0157  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public org.json.JSONObject readFileAsnc(android.content.Context r22, int r23) {
        /*
            Method dump skipped, instructions count: 359
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.socialize.net.dplus.cache1.DplusCacheApi.readFileAsnc(android.content.Context, int):org.json.JSONObject");
    }

    public void saveFile(final Context context, final JSONObject jSONObject, final int i6, final DplusCacheListener dplusCacheListener) {
        this.f42449c.post(new Runnable() { // from class: com.umeng.socialize.net.dplus.cache1.DplusCacheApi.3
            @Override // java.lang.Runnable
            public void run() {
                switch (i6) {
                    case SocializeConstants.DAU_EVENT /* 24577 */:
                        DBManager.get(context).insertDau(jSONObject);
                        break;
                    case SocializeConstants.SHARE_EVENT /* 24578 */:
                        DBManager.get(context).insertS_E(jSONObject);
                        break;
                    case SocializeConstants.AUTH_EVENT /* 24579 */:
                        DBManager.get(context).insertAuth(jSONObject);
                        break;
                    case SocializeConstants.GET_EVENT /* 24580 */:
                        DBManager.get(context).insertUserInfo(jSONObject);
                        break;
                    case SocializeConstants.SAVE_STATS_EVENT /* 24581 */:
                    case SocializeConstants.SEND_DAU_STATS_EVENT /* 24583 */:
                        DBManager.get(context).insertStats(jSONObject);
                        break;
                    case SocializeConstants.CHECK_STATS_EVENT /* 24582 */:
                    default:
                        DBManager.get(context).insertStats(jSONObject);
                        break;
                }
                dplusCacheListener.onResult(null);
            }
        });
    }

    public static final DplusCacheApi getInstance() {
        return SingletonHolder.f42472a;
    }

    public void deleteAllAsnc(Context context) {
        DBManager.get(ContextUtil.getContext()).deleteTable("stats");
    }
}
