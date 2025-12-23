package com.bytedance.sdk.openadsdk.core.az.j;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import com.bytedance.sdk.component.oq.ae;
import com.bytedance.sdk.component.oq.g;
import com.bytedance.sdk.openadsdk.core.kt.ws;
import com.bytedance.sdk.openadsdk.core.m.xt;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.v;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j {

    /* renamed from: j, reason: collision with root package name */
    private JSONObject f27968j;

    public boolean j() {
        JSONObject jSONObject = this.f27968j;
        if (jSONObject != null && jSONObject.optInt("type") > 0) {
            return xt.j((float) this.f27968j.optDouble("rate"), false);
        }
        return false;
    }

    public String toString() {
        JSONObject jSONObject = this.f27968j;
        return jSONObject == null ? "" : jSONObject.toString();
    }

    public static j j(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return j(new JSONObject(str));
        } catch (JSONException unused) {
            return null;
        }
    }

    public static j j(JSONObject jSONObject) {
        j jVar = new j();
        jVar.f27968j = jSONObject;
        return jVar;
    }

    public void j(WebView webView, final n nVar) {
        View view;
        if (j() && webView != null) {
            try {
                System.currentTimeMillis();
                if (Build.VERSION.SDK_INT >= 28 && webView.getLayerType() == 2 && (view = (View) webView.getParent()) != null) {
                    int measuredWidth = (int) (view.getMeasuredWidth() * 0.6d);
                    int measuredHeight = (int) (view.getMeasuredHeight() * 0.6d);
                    if (j(v.getContext(), measuredWidth, measuredHeight)) {
                        final Bitmap createBitmap = Bitmap.createBitmap(measuredWidth, measuredHeight, Bitmap.Config.RGB_565);
                        view.draw(new Canvas(createBitmap));
                        System.currentTimeMillis();
                        ae.xt(new g("") { // from class: com.bytedance.sdk.openadsdk.core.az.j.j.1
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    try {
                                        System.currentTimeMillis();
                                        j.this.j(createBitmap, nVar);
                                        System.currentTimeMillis();
                                    } catch (Throwable th) {
                                        try {
                                            th.getMessage();
                                            if (!createBitmap.isRecycled()) {
                                                createBitmap.recycle();
                                            }
                                        } finally {
                                            try {
                                                if (!createBitmap.isRecycled()) {
                                                    createBitmap.recycle();
                                                }
                                            } catch (Throwable unused) {
                                            }
                                        }
                                    }
                                } catch (Throwable unused2) {
                                }
                            }
                        });
                    }
                }
            } catch (Throwable th) {
                th.getMessage();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(Bitmap bitmap, n nVar) throws JSONException {
        Matrix matrix = new Matrix();
        matrix.setScale(0.4f, 0.4f);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        try {
            bitmap.recycle();
        } catch (Throwable th) {
            th.getMessage();
        }
        float width = createBitmap.getWidth() * createBitmap.getHeight();
        float f6 = 0.0f;
        for (int i6 = 0; i6 < createBitmap.getWidth(); i6++) {
            for (int i7 = 0; i7 < createBitmap.getHeight(); i7++) {
                if (createBitmap.getPixel(i6, i7) == -1) {
                    f6 += 1.0f;
                }
            }
        }
        try {
            createBitmap.recycle();
        } catch (Throwable th2) {
            th2.getMessage();
        }
        if ((f6 / width) * 100.0f > 95.0d) {
            JSONObject jSONObject = new JSONObject();
            if (nVar != null) {
                jSONObject.put("url", nVar.yb());
                jSONObject.put(MediationConstant.EXTRA_ADID, nVar.so());
                jSONObject.put("cid", nVar.fs());
            }
            ws.j().m(jSONObject);
        }
    }

    public boolean j(Context context, int i6, int i7) {
        ActivityManager.MemoryInfo memoryInfo;
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
            memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
        } catch (Exception unused) {
        }
        if (memoryInfo.lowMemory) {
            return false;
        }
        return memoryInfo.availMem > Math.max((long) Math.max(((double) memoryInfo.totalMem) * 0.02d, 5.24288E7d), (long) (((float) ((i6 * i7) * 2)) * 2.0f));
    }
}
