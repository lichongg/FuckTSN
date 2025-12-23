package com.bytedance.sdk.openadsdk;

/* loaded from: D:\Downloads\app\classes4.dex */
public interface TTAdDislike {

    public interface DislikeInteractionCallback {
        void onCancel();

        void onSelected(int i6, String str, boolean z5);

        void onShow();
    }

    boolean isShow();

    void resetDislikeStatus();

    void setDislikeInteractionCallback(DislikeInteractionCallback dislikeInteractionCallback);

    void setDislikeSource(String str);

    void showDislikeDialog();
}
