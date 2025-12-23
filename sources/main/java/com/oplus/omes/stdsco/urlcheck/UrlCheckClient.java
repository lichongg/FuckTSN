package com.oplus.omes.stdsco.urlcheck;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.oplus.omes.stdsco.urlcheck.UrlCheckClient;
import com.umeng.socialize.net.dplus.db.DBConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import k2.a;
import k2.b;
import k2.c;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class UrlCheckClient {

    /* renamed from: c, reason: collision with root package name */
    private static volatile UrlCheckClient f36456c;

    /* renamed from: a, reason: collision with root package name */
    private final ExecutorService f36457a = Executors.newSingleThreadExecutor();

    /* renamed from: b, reason: collision with root package name */
    private final a f36458b;

    public static native String nativeUrlsCheck(String content);

    public static /* synthetic */ void a(b bVar) {
        if (bVar != null) {
            bVar.onFailure(-3);
        }
    }

    public static /* synthetic */ void b(b bVar, List list) {
        if (bVar != null) {
            bVar.a(list);
        }
    }

    public static /* synthetic */ void c(b bVar, List list) {
        if (bVar != null) {
            bVar.a(list);
        }
    }

    public static UrlCheckClient f(Context context) {
        if (f36456c == null) {
            synchronized (UrlCheckClient.class) {
                try {
                    if (f36456c == null) {
                        f36456c = new UrlCheckClient(context);
                    }
                } finally {
                }
            }
        }
        return f36456c;
    }

    public void e(List<String> urls, final b listener) {
        if (urls == null) {
            if (listener != null) {
                listener.onFailure(-1);
            }
        } else if (urls.size() <= 20) {
            final ArrayList arrayList = new ArrayList(urls);
            this.f36457a.execute(new Runnable() { // from class: k2.g
                @Override // java.lang.Runnable
                public final void run() {
                    UrlCheckClient.d(UrlCheckClient.this, arrayList, listener);
                }
            });
        } else if (listener != null) {
            listener.onFailure(-2);
        }
    }

    private UrlCheckClient(Context context) {
        this.f36458b = new a(context, "stdscourlcheck");
    }

    public static /* synthetic */ void d(UrlCheckClient urlCheckClient, List list, final b bVar) {
        urlCheckClient.getClass();
        final ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            c d6 = urlCheckClient.f36458b.d((String) it.next());
            if (d6 != null) {
                arrayList.add(d6);
                it.remove();
            }
        }
        if (list.isEmpty()) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: k2.d
                @Override // java.lang.Runnable
                public final void run() {
                    UrlCheckClient.b(b.this, arrayList);
                }
            });
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            for (int i6 = 0; i6 < list.size(); i6++) {
                String str = (String) list.get(i6);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("id", i6);
                jSONObject2.put("url", str);
                jSONObject2.put("deviceid", (Math.abs(a.h(str).hashCode()) % 10) + "");
                jSONArray.put(i6, jSONObject2);
            }
            jSONObject.put("urls", jSONArray);
            String nativeUrlsCheck = nativeUrlsCheck(jSONObject.toString());
            if (!TextUtils.isEmpty(nativeUrlsCheck)) {
                JSONArray jSONArray2 = new JSONObject(nativeUrlsCheck).getJSONArray("result");
                for (int i7 = 0; i7 < jSONArray2.length(); i7++) {
                    JSONObject jSONObject3 = (JSONObject) jSONArray2.get(i7);
                    c cVar = new c();
                    cVar.g(jSONObject3.getInt(DBConfig.ID));
                    cVar.i(jSONObject3.getString("Url"));
                    cVar.j(jSONObject3.getInt("Urltype"));
                    cVar.f(jSONObject3.getInt("Evilclass"));
                    cVar.h(System.currentTimeMillis());
                    urlCheckClient.f36458b.i(cVar);
                    arrayList.add(cVar);
                }
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: k2.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        UrlCheckClient.c(b.this, arrayList);
                    }
                });
            }
        } catch (JSONException e6) {
            e6.printStackTrace();
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: k2.f
                @Override // java.lang.Runnable
                public final void run() {
                    UrlCheckClient.a(b.this);
                }
            });
        }
    }
}
