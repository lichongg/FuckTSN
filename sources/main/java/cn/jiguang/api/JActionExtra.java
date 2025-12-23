package cn.jiguang.api;

import android.content.Context;

/* loaded from: D:\Downloads\app\classes2.dex */
public abstract class JActionExtra {
    public Object beforLogin(Context context, int i6, String str) {
        return null;
    }

    public Object beforRegister(Context context, int i6, String str) {
        return null;
    }

    public boolean checkAction(int i6) {
        return true;
    }

    public Object onSendData(Context context, long j6, long j7, int i6, int i7) {
        return null;
    }
}
