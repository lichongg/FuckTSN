package com.bytedance.sdk.openadsdk.jy.j;

import android.content.Context;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.baidu.mobads.sdk.internal.a;
import com.bytedance.sdk.component.utils.up;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.component.xt.j.av;
import com.bytedance.sdk.component.xt.j.az;
import com.bytedance.sdk.component.xt.j.oq;
import com.bytedance.sdk.component.xt.j.ws;
import com.bytedance.sdk.openadsdk.core.kt.ws;
import com.bytedance.sdk.openadsdk.core.v;
import com.bytedance.sdk.openadsdk.jy.j.j;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import master.flame.danmaku.danmaku.parser.b;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt extends j {
    private static final ConcurrentLinkedDeque<String> tl = new ConcurrentLinkedDeque<>();

    /* renamed from: g, reason: collision with root package name */
    private long f31533g;
    private final String oq;
    private String qv;

    private boolean xt(String str, String str2) {
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            com.bytedance.sdk.openadsdk.jy.xt.xt.j(str, str2);
            return true;
        } catch (Throwable th) {
            vl.j(th);
            return false;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.jy.j.j
    public void j(String str) {
    }

    public boolean r() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.jy.j.j
    public void cw() {
        if (tl.contains(this.xt)) {
            this.f31529j.j(new Runnable() { // from class: com.bytedance.sdk.openadsdk.jy.j.xt.3
                @Override // java.lang.Runnable
                public void run() {
                    xt.this.j(null, com.bytedance.sdk.openadsdk.jy.r.xt(v.getContext()), v.getContext(), -1L, -1L);
                }
            });
        } else if (this.f31531r.compareAndSet(false, true)) {
            this.f31529j.j(new Runnable() { // from class: com.bytedance.sdk.openadsdk.jy.j.xt.4
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        xt.this.up.set(true);
                        xt.this.up();
                        xt.this.f31531r.set(false);
                    } catch (Throwable th) {
                        vl.j(th);
                    }
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:74:0x01a0 A[Catch: Exception -> 0x0197, LOOP:0: B:74:0x01a0->B:76:0x01a8, LOOP_START, TryCatch #3 {Exception -> 0x0197, blocks: (B:69:0x019c, B:74:0x01a0, B:76:0x01a8, B:78:0x01ac, B:80:0x01b4), top: B:68:0x019c }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void up() {
        /*
            Method dump skipped, instructions count: 446
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.jy.j.xt.up():void");
    }

    public xt(com.bytedance.sdk.openadsdk.jy.j jVar, String str, String str2, JSONObject jSONObject, String str3, String str4) {
        super(jVar, str, str2, jSONObject, str3, str4);
        this.oq = "index_censorship.json";
    }

    @Override // com.bytedance.sdk.openadsdk.jy.j.j
    public void j(final String str, final String str2) {
        ws.j().xt(new com.bytedance.sdk.openadsdk.vl.j.j() { // from class: com.bytedance.sdk.openadsdk.jy.j.xt.1
            @Override // com.bytedance.sdk.openadsdk.vl.j.j
            public com.bytedance.sdk.openadsdk.core.kt.j.j j() throws Exception {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("cid", str);
                    jSONObject.put("req_id", str2);
                } catch (Exception e6) {
                    vl.j(e6);
                }
                return com.bytedance.sdk.openadsdk.core.kt.j.xt.xt().j("web_upload_start").xt(jSONObject.toString());
            }
        }, "web_upload_start");
    }

    public void j(final String str, final String str2, final long j6, final String str3, final long j7, final long j8) {
        ws.j().xt(new com.bytedance.sdk.openadsdk.vl.j.j() { // from class: com.bytedance.sdk.openadsdk.jy.j.xt.2
            @Override // com.bytedance.sdk.openadsdk.vl.j.j
            public com.bytedance.sdk.openadsdk.core.kt.j.j j() throws Exception {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("cid", str);
                    jSONObject.put("req_id", str2);
                    jSONObject.put("duration", System.currentTimeMillis() - j6);
                    jSONObject.put("weburl", str3);
                    jSONObject.put("size", j7);
                    jSONObject.put("avail_mem", j8);
                } catch (Exception e6) {
                    vl.j(e6);
                }
                return com.bytedance.sdk.openadsdk.core.kt.j.xt.xt().j("web_upload_finish").xt(jSONObject.toString());
            }
        }, "web_upload_finish");
    }

    @Override // com.bytedance.sdk.openadsdk.jy.j.j
    public void xt(Context context, String str, com.bytedance.sdk.openadsdk.jy.xt xtVar, WebResourceResponse webResourceResponse, oq oqVar, Map<String, Object> map) {
        try {
            if (com.bytedance.sdk.openadsdk.jy.r.cw()) {
                String j6 = j(context);
                String uri = xtVar.j().toString();
                String xt = oqVar.xt();
                if (TextUtils.equals(xt.toLowerCase(), "javascript")) {
                    xt = "js";
                }
                File file = new File(j6);
                if (!file.exists()) {
                    file.mkdirs();
                }
                String str2 = up.xt(uri) + "." + xt;
                File file2 = new File(j6, str2);
                if (file2.exists()) {
                    file2.delete();
                    file2.createNewFile();
                }
                file2.getAbsolutePath();
                v.xt().hh();
                if (com.bytedance.sdk.openadsdk.jy.xt.j.j(webResourceResponse.getData(), j6, str2, v.xt().hh())) {
                    j(this.f31530m, str, oqVar, str2, uri, xtVar.cw(), map);
                }
            }
        } catch (Exception e6) {
            vl.j(e6);
            e6.getMessage();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.jy.j.j
    public boolean j(WebView webView) {
        if (webView == null || tl.contains(this.xt)) {
            return true;
        }
        AtomicBoolean atomicBoolean = this.up;
        return (atomicBoolean != null && atomicBoolean.get()) || this.f31529j.xt().get() > 0;
    }

    @Override // com.bytedance.sdk.openadsdk.jy.j.j
    public void j(Context context, String str, com.bytedance.sdk.openadsdk.jy.xt xtVar, WebResourceResponse webResourceResponse, oq oqVar, Map<String, Object> map) {
        int i6;
        if (com.bytedance.sdk.openadsdk.jy.r.cw()) {
            String uri = xtVar.j().toString();
            String xt = oqVar.xt();
            if (TextUtils.equals(xt.toLowerCase(), "javascript")) {
                xt = "js";
            }
            String str2 = up.xt(uri) + "." + xt;
            if (TextUtils.isEmpty(xt)) {
                return;
            }
            HashMap<String, byte[]> hashMap = this.f31529j.j().get(xt);
            if (hashMap == null) {
                hashMap = new HashMap<>();
                this.f31529j.j().put(xt, hashMap);
            }
            ArrayList arrayList = new ArrayList();
            byte[] bArr = new byte[1024];
            InputStream data = webResourceResponse.getData();
            while (true) {
                try {
                    try {
                        try {
                            i6 = 0;
                            if (data.read(bArr) == -1) {
                                break;
                            }
                            while (i6 < 1024) {
                                arrayList.add(Byte.valueOf(bArr[i6]));
                                i6++;
                            }
                        } finally {
                        }
                    } catch (Exception e6) {
                        vl.j(e6);
                        if (data != null) {
                            data.close();
                            return;
                        }
                        return;
                    }
                } catch (IOException e7) {
                    vl.j(e7);
                    return;
                }
            }
            byte[] bArr2 = new byte[arrayList.size()];
            while (i6 < arrayList.size()) {
                bArr2[i6] = ((Byte) arrayList.get(i6)).byteValue();
                i6++;
            }
            if (arrayList.size() <= v.xt().hh() * PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) {
                hashMap.put(str2, bArr2);
                j(this.f31530m, str, oqVar, str2, uri, xtVar.cw(), map);
            }
            data.close();
        }
    }

    private int xt(byte[] bArr, int i6, File file) {
        if (i6 <= 0) {
            return -1;
        }
        return j(bArr, i6 - 1, file);
    }

    @Override // com.bytedance.sdk.openadsdk.jy.j.j
    protected void j(JSONObject jSONObject, String str, oq oqVar, String str2, String str3, Map<String, String> map, Map<String, Object> map2) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.putOpt(CommonNetImpl.NAME, str2);
            jSONObject2.putOpt("url", str3);
            if (map != null) {
                jSONObject2.putOpt("request_headers", new JSONObject(map));
            }
            if (oqVar != null) {
                String lowerCase = oqVar.toString().toLowerCase();
                if (lowerCase.contains(SocializeProtocolConstants.IMAGE)) {
                    j(jSONObject2, jSONObject, "sub_pic");
                    return;
                }
                if (!lowerCase.contains("js") && !lowerCase.contains("javascript")) {
                    if (lowerCase.contains("css")) {
                        j(jSONObject2, jSONObject, "css");
                        return;
                    } else {
                        if (lowerCase.contains(a.f10505f)) {
                            j(jSONObject2, jSONObject, a.f10505f);
                            return;
                        }
                        return;
                    }
                }
                j(jSONObject2, jSONObject, "js");
                return;
            }
            j(jSONObject2, jSONObject, "other");
        } catch (JSONException e6) {
            vl.j(e6);
        }
    }

    private void j(JSONObject jSONObject, JSONObject jSONObject2, String str) {
        try {
            JSONArray optJSONArray = jSONObject2.optJSONArray(str);
            if (optJSONArray == null) {
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(jSONObject);
                this.f31530m.putOpt(str, jSONArray);
            } else {
                optJSONArray.put(jSONObject);
                this.f31530m.putOpt(str, optJSONArray);
            }
        } catch (JSONException e6) {
            vl.j(e6);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.jy.j.j
    public void j() {
        try {
            this.f31530m.putOpt(a.f10505f, new JSONArray());
            this.f31530m.putOpt("js", new JSONArray());
            this.f31530m.putOpt("css", new JSONArray());
            this.f31530m.putOpt("sub_pic", new JSONArray());
        } catch (JSONException e6) {
            vl.j(e6);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.jy.j.j
    public boolean j(oq oqVar) {
        try {
            Set<String> rh = v.xt().rh();
            String str = oqVar.j().trim().toLowerCase() + "/" + oqVar.xt().trim().toLowerCase();
            Objects.toString(rh);
            return rh.contains(str);
        } catch (Exception e6) {
            vl.j(e6);
            return false;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.jy.j.j
    public void j(com.bytedance.sdk.openadsdk.jy.xt xtVar, WebResourceResponse webResourceResponse, oq oqVar, j.InterfaceC0502j interfaceC0502j) {
        interfaceC0502j.j(true, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(File file, String str, Context context, long j6, long j7) {
        try {
            com.bytedance.sdk.openadsdk.jy.xt.j.xt(str);
            if (file != null && file.exists()) {
                file.delete();
            }
            AtomicInteger atomicInteger = com.bytedance.sdk.openadsdk.jy.r.f31540j;
            int i6 = atomicInteger.get();
            if (i6 > 0) {
                atomicInteger.decrementAndGet();
            }
            if (i6 == 0) {
                com.bytedance.sdk.openadsdk.jy.xt.j.xt(com.bytedance.sdk.openadsdk.jy.r.xt(context));
            }
            j(this.xt, this.cw, this.f31533g, this.ae, j6, j7);
        } catch (Exception e6) {
            vl.j(e6);
        }
    }

    private byte[] j(byte[] bArr, int i6) {
        return com.bytedance.sdk.openadsdk.l.xt.j(bArr, i6);
    }

    private String j(Context context) {
        String str = this.qv;
        if (str != null) {
            return str;
        }
        try {
            String str2 = com.bytedance.sdk.openadsdk.jy.r.xt(context) + File.separator + this.xt;
            this.qv = str2;
            return str2;
        } catch (Exception e6) {
            vl.j(e6);
            StringBuilder sb = new StringBuilder();
            String str3 = File.separator;
            sb.append(str3);
            sb.append(".lp_cache");
            sb.append(str3);
            sb.append(this.xt);
            return sb.toString();
        }
    }

    private int j(byte[] bArr, int i6, File file) {
        try {
            com.bytedance.sdk.component.xt.j.vl m6 = com.bytedance.sdk.openadsdk.core.v.up.j().xt().m();
            az j6 = az.j(oq.j("multipart/form-data"), bArr, b.f50156c, file.getName());
            String e6 = v.xt().e();
            String str = "?aid=" + com.bytedance.sdk.openadsdk.core.oq.i().f() + "&device_platform=android&device_type=android&source_type=union";
            av j7 = m6.j(new ws.j().j(e6 + str).j(j6).xt()).j();
            if (j7.cw() == 200) {
                JSONObject jSONObject = new JSONObject(j7.m().xt());
                int optInt = jSONObject.optInt("code");
                String optString = jSONObject.optString("msg");
                if (optInt == 0 && TextUtils.equals("success", optString)) {
                    return 200;
                }
                return xt(bArr, i6, file);
            }
            return xt(bArr, i6, file);
        } catch (Throwable th) {
            vl.j(th);
            th.getMessage();
            return xt(bArr, i6, file);
        }
    }
}
