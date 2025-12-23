package com.bytedance.android.live.base.api.push;

/* loaded from: D:\Downloads\app\classes3.dex */
public interface PushInterceptor {

    public static class InterceptResult {
        public boolean intercept;
        public String interceptReason;

        public InterceptResult() {
        }

        public InterceptResult(boolean z5) {
            this(z5, "");
        }

        public InterceptResult(boolean z5, String str) {
            this.intercept = z5;
            this.interceptReason = "";
        }
    }

    InterceptResult intercept();
}
