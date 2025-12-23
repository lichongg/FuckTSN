package com.ss.android.j.j.j;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import w2.n;
import w2.t;

/* loaded from: D:\Downloads\app\classes6.dex */
public class b implements n {

    /* renamed from: a, reason: collision with root package name */
    private t f38246a;

    @Override // w2.n
    public void j(@NonNull Activity activity, @NonNull String[] strArr, t tVar) {
        if (Build.VERSION.SDK_INT >= 23) {
            this.f38246a = tVar;
            activity.requestPermissions(strArr, 1);
        } else if (tVar != null) {
            tVar.j();
        }
    }

    @Override // w2.n
    public boolean j(@Nullable Context context, @NonNull String str) {
        return (context == null || str == null || context.checkPermission(str, Process.myPid(), Process.myUid()) != 0) ? false : true;
    }

    @Override // w2.n
    public void j(@NonNull Activity activity, int i6, @NonNull String[] strArr, @NonNull int[] iArr) {
        t tVar;
        if (iArr.length <= 0 || (tVar = this.f38246a) == null) {
            return;
        }
        int i7 = iArr[0];
        if (i7 == -1) {
            tVar.j(strArr[0]);
        } else if (i7 == 0) {
            tVar.j();
        }
    }
}
