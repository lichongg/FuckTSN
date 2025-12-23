package com.bytedance.sdk.openadsdk;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.api.m;
import com.bytedance.sdk.openadsdk.dislike.TTDislikeListView;

/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class TTDislikeDialogAbstract extends Dialog {

    /* renamed from: j, reason: collision with root package name */
    private View f27515j;

    public TTDislikeDialogAbstract(Context context) {
        super(context);
    }

    public abstract int getLayoutId();

    public abstract ViewGroup.LayoutParams getLayoutParams();

    public abstract int[] getTTDislikeListViewIds();

    public TTDislikeDialogAbstract(Context context, int i6) {
        super(context, i6);
    }

    protected void j() {
        if (this.f27515j == null) {
            return;
        }
        int[] tTDislikeListViewIds = getTTDislikeListViewIds();
        if (tTDislikeListViewIds == null || tTDislikeListViewIds.length <= 0) {
            throw new IllegalArgumentException("dislike选项列表为空，请设置TTDislikeListView");
        }
        for (int i6 : tTDislikeListViewIds) {
            View findViewById = this.f27515j.findViewById(i6);
            if (findViewById == null) {
                throw new IllegalArgumentException("getTTDislikeListViewIds提供的id找不到view，请检查");
            }
            if (!(findViewById instanceof TTDislikeListView)) {
                throw new IllegalArgumentException("getTTDislikeListViewIds找到的view类型异常，请检查");
            }
        }
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            View inflate = LayoutInflater.from(getContext()).inflate(getLayoutId(), (ViewGroup) null);
            this.f27515j = inflate;
            if (inflate == null) {
                return;
            }
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            View view = this.f27515j;
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(-1, -1);
            }
            setContentView(view, layoutParams);
            j();
        } catch (Exception unused) {
            m.up("TTDislikeDialogAbstract", "getLayoutId布局文件id可能异常，请检查");
        }
    }

    @Deprecated
    public void startPersonalizePromptActivity() {
    }
}
