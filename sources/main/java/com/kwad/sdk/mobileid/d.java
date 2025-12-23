package com.kwad.sdk.mobileid;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class d {
    private String aTj;
    private String errorReason;
    private boolean success;

    public final String NA() {
        return this.aTj;
    }

    public final String Nz() {
        return this.errorReason;
    }

    public final void gn(String str) {
        this.aTj = str;
    }

    public final boolean isSuccess() {
        return this.success;
    }

    public final String toString() {
        return "UaidErrorReason{success=" + this.success + ", errorReason='" + this.errorReason + "', extraErrorMsg='" + this.aTj + "'}";
    }

    public d(boolean z5, String str) {
        this.success = z5;
        this.errorReason = str;
    }
}
