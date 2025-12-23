package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.api.NativeResponse;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class r implements NativeResponse.CustomizeMediaPlayer {

    /* renamed from: a, reason: collision with root package name */
    private static final String f11080a = "vstart";

    /* renamed from: b, reason: collision with root package name */
    private static final String f11081b = "vrepeatedplay";

    /* renamed from: c, reason: collision with root package name */
    private static final String f11082c = "vclose";

    /* renamed from: d, reason: collision with root package name */
    private static final String f11083d = "vreadyplay";

    /* renamed from: e, reason: collision with root package name */
    private static final String f11084e = "vplayfail";

    /* renamed from: f, reason: collision with root package name */
    private static final String f11085f = "vmute";

    /* renamed from: g, reason: collision with root package name */
    private static final String f11086g = "vfrozen";

    /* renamed from: h, reason: collision with root package name */
    private static final String f11087h = "vshow";

    /* renamed from: i, reason: collision with root package name */
    private static final String f11088i = "curTimeSec";

    /* renamed from: j, reason: collision with root package name */
    private static final String f11089j = "startTimeSec";

    /* renamed from: k, reason: collision with root package name */
    private static final String f11090k = "autoPlay";

    /* renamed from: l, reason: collision with root package name */
    private static final String f11091l = "reasonValue";

    /* renamed from: m, reason: collision with root package name */
    private final df f11092m;

    /* renamed from: n, reason: collision with root package name */
    private final a f11093n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f11094o = false;

    /* renamed from: p, reason: collision with root package name */
    private int f11095p = 0;

    private void a(String str, JSONObject jSONObject) {
        a aVar;
        JSONObject U;
        if (this.f11092m == null || (aVar = this.f11093n) == null || (U = aVar.U()) == null) {
            return;
        }
        try {
            U.put("msg", "sendVideoThirdLog");
            U.put("trackType", str);
            U.put("trackInfo", jSONObject);
            this.f11092m.a(U);
        } catch (Throwable th) {
            bu.a().d(th.getMessage());
        }
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.CustomizeMediaPlayer
    public void reportPlayerReady() {
        a(f11083d, a(0, 0, false, 0));
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.CustomizeMediaPlayer
    public void reportVideoReplay() {
        this.f11095p = 0;
        a(f11081b, a(0, 0, this.f11094o, 0));
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.CustomizeMediaPlayer
    public void reportVideoShow() {
        a(f11087h, a(0, 0, false, 7));
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.CustomizeMediaPlayer
    public void reportVideoStart(boolean z5) {
        this.f11095p = 0;
        this.f11094o = z5;
        a(f11080a, a(0, 0, z5, 0));
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.CustomizeMediaPlayer
    public String getVideoUrl() {
        a aVar = this.f11093n;
        if (aVar != null) {
            return aVar.n();
        }
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.CustomizeMediaPlayer
    public void reportPlayError(int i6) {
        a(f11084e, a(this.f11095p, i6, this.f11094o, 0));
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.CustomizeMediaPlayer
    public void reportPlayFrozen(int i6) {
        a(f11086g, a(this.f11095p, i6, this.f11094o, 0));
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.CustomizeMediaPlayer
    public void reportVideoMuteChange(int i6, boolean z5) {
        a(f11085f, a(this.f11095p, i6, this.f11094o, z5 ? 2 : 1));
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.CustomizeMediaPlayer
    public void reportVideoPause(int i6, NativeResponse.VideoReason videoReason) {
        a(f11082c, a(this.f11095p, i6, this.f11094o, videoReason.getCode()));
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.CustomizeMediaPlayer
    public void reportVideoResume(int i6) {
        this.f11095p = i6;
        a(f11080a, a(i6, i6, this.f11094o, 0));
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.CustomizeMediaPlayer
    public void reportVideoStop(int i6, NativeResponse.VideoReason videoReason) {
        a(f11082c, a(this.f11095p, i6, this.f11094o, videoReason.getCode()));
    }

    public r(df dfVar, a aVar) {
        this.f11092m = dfVar;
        this.f11093n = aVar;
    }

    private JSONObject a(int i6, int i7, boolean z5, int i8) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(f11089j, i6 / 1000);
            jSONObject.put(f11088i, i7 / 1000);
            jSONObject.put(f11090k, z5);
            jSONObject.put(f11091l, i8);
            return jSONObject;
        } catch (Throwable th) {
            bu.a().d(th.getMessage());
            return jSONObject;
        }
    }
}
