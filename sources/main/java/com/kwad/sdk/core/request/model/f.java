package com.kwad.sdk.core.request.model;

import com.ksad.json.annotation.KsJson;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KsJson
/* loaded from: D:\Downloads\app\classes6.dex */
public class f extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b {
    public long aIK;
    public int adStyle;
    public int count;
    public int taskType;

    public f() {
    }

    public f(int i6, int i7, int i8, long j6) {
        this.adStyle = i6;
        this.taskType = i7;
        this.count = 1;
        this.aIK = j6;
    }

    public final void aG(long j6) {
        this.aIK = j6;
    }
}
