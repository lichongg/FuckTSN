package com.kwad.sdk.crash.message;

import com.ksad.json.annotation.KsJson;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KsJson
/* loaded from: D:\Downloads\app\classes6.dex */
public final class NativeBackTraceElement extends BackTraceElement {
    private static final long serialVersionUID = 8646793782725084250L;
    public String mBuildId;
    public String mPc;

    public final String getBuildId() {
        return this.mBuildId;
    }

    public final String getPc() {
        return this.mPc;
    }

    public final void setBuildId(String str) {
        this.mBuildId = str;
    }

    public final void setPc(String str) {
        this.mPc = str;
    }

    public NativeBackTraceElement(String str, int i6) {
        super(str, i6);
        this.mBuildId = "";
        this.mPc = "";
    }
}
