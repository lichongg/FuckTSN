package com.kwad.components.core.c;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class h implements i, Comparable<h> {
    private final String NF;
    private final String NN;
    private final String NO;
    private final String NP;
    private final long NQ;
    private final long createTime;
    private final int ecpm;

    public static List<h> a(e eVar, AdResultData adResultData) {
        List<AdTemplate> proceedTemplateList = adResultData.getProceedTemplateList();
        int size = proceedTemplateList.size();
        long currentTimeMillis = System.currentTimeMillis();
        long oj = (currentTimeMillis / 1000) + eVar.oj();
        ArrayList arrayList = new ArrayList();
        SceneImpl defaultAdScene = adResultData.getDefaultAdScene();
        for (AdTemplate adTemplate : proceedTemplateList) {
            long j6 = currentTimeMillis;
            arrayList.add(new h(String.valueOf(com.kwad.sdk.core.response.b.e.ev(adTemplate)), String.valueOf(adResultData.getPosId()), new AdResultData(adResultData, defaultAdScene, Collections.singletonList(adTemplate)).getResponseJson(), com.kwad.sdk.core.response.b.e.ez(adTemplate), adResultData.getDefaultAdScene().toJson().toString(), j6 + size, oj));
            size--;
            currentTimeMillis = j6;
        }
        return arrayList;
    }

    @SuppressLint({"Range"})
    private static synchronized h c(@NonNull Cursor cursor) {
        h hVar;
        synchronized (h.class) {
            hVar = new h(cursor.getString(cursor.getColumnIndex("creativeId")), cursor.getString(cursor.getColumnIndex("posId")), cursor.getString(cursor.getColumnIndex("adJson")), cursor.getInt(cursor.getColumnIndex("ecpm")), cursor.getString(cursor.getColumnIndex("adSenseJson")), cursor.getLong(cursor.getColumnIndex("createTime")), cursor.getLong(cursor.getColumnIndex("expireTime")));
        }
        return hVar;
    }

    public static AdResultData k(List<h> list) {
        ArrayList arrayList = new ArrayList();
        AdResultData adResultData = null;
        if (list == null || list.size() == 0) {
            return null;
        }
        Iterator<h> it = list.iterator();
        SceneImpl sceneImpl = null;
        while (it.hasNext()) {
            adResultData = c(it.next());
            if (adResultData != null) {
                if (sceneImpl == null) {
                    sceneImpl = adResultData.getDefaultAdScene();
                }
                arrayList.addAll(adResultData.getProceedTemplateList());
            }
        }
        AdResultData adResultData2 = new AdResultData(adResultData, sceneImpl, arrayList);
        adResultData2.setAdSource("cache");
        return adResultData2;
    }

    private String on() {
        return this.NO;
    }

    private int oo() {
        return this.ecpm;
    }

    private long op() {
        return this.createTime;
    }

    private String or() {
        return this.NP;
    }

    public final String og() {
        return this.NF;
    }

    @Override // com.kwad.components.core.c.i
    public final ContentValues ok() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("creativeId", this.NN);
        contentValues.put("posId", this.NF);
        contentValues.put("adJson", this.NO);
        contentValues.put("ecpm", Integer.valueOf(this.ecpm));
        contentValues.put("adSenseJson", this.NP);
        contentValues.put("createTime", Long.valueOf(this.createTime));
        contentValues.put("expireTime", Long.valueOf(this.NQ));
        contentValues.put("playAgainJson", (String) null);
        return contentValues;
    }

    public final long oq() {
        return this.NQ;
    }

    public final String os() {
        return this.NN;
    }

    private h(String str, String str2, String str3, int i6, String str4, long j6, long j7) {
        this.NN = str;
        this.NF = str2;
        this.NO = str3;
        this.ecpm = i6;
        this.NP = str4;
        this.createTime = j6;
        this.NQ = j7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public int compareTo(h hVar) {
        if (hVar.oo() == oo()) {
            return (int) (hVar.op() - op());
        }
        return hVar.oo() - oo();
    }

    @Nullable
    private static AdResultData c(h hVar) {
        if (hVar == null) {
            return null;
        }
        if (hVar.on() != null && hVar.or() != null) {
            try {
                String or = hVar.or();
                SceneImpl sceneImpl = new SceneImpl();
                sceneImpl.parseJson(new JSONObject(or));
                AdResultData createFromResponseJson = AdResultData.createFromResponseJson(hVar.on(), sceneImpl);
                Iterator<AdTemplate> it = createFromResponseJson.getProceedTemplateList().iterator();
                while (it.hasNext()) {
                    it.next().fromCache = true;
                }
                return createFromResponseJson;
            } catch (JSONException e6) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(e6);
                return null;
            }
        }
        com.kwad.sdk.core.d.c.w("CachedAd", "createAdResultData cachedAd data illegal");
        return null;
    }

    public static List<h> a(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            try {
                arrayList.add(c(cursor));
            } catch (Exception e6) {
                com.kwad.sdk.core.d.c.printStackTrace(e6);
            }
        }
        return arrayList;
    }
}
