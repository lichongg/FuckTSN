package com.kwad.sdk.crash.message;

import com.ksad.json.annotation.KsJson;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KsJson
/* loaded from: D:\Downloads\app\classes6.dex */
public final class JavaBackTraceElement extends BackTraceElement {
    private static final long serialVersionUID = 2317636129771661110L;
    public String mDeclaringClass;
    public boolean mIsCausedBy;
    public boolean mIsNative;
    public boolean mIsTitle;

    public final String getDeclaringClass() {
        return this.mDeclaringClass;
    }

    public final boolean isCausedBy() {
        return this.mIsCausedBy;
    }

    public final boolean isNative() {
        return this.mIsNative;
    }

    public final boolean isTitle() {
        return this.mIsTitle;
    }

    public final void setDeclaringClass(String str) {
        this.mDeclaringClass = str;
    }

    public final void setIsCausedBy(boolean z5) {
        this.mIsCausedBy = z5;
    }

    public final void setIsNative(boolean z5) {
        this.mIsNative = z5;
    }

    public final void setIsTitle(boolean z5) {
        this.mIsTitle = z5;
    }

    public JavaBackTraceElement(String str, int i6) {
        super(str, i6);
        this.mDeclaringClass = "";
        this.mIsTitle = false;
        this.mIsCausedBy = false;
        this.mIsNative = false;
    }
}
