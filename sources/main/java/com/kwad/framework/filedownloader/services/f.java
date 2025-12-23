package com.kwad.framework.filedownloader.services;

import android.content.Intent;
import com.baidu.mobads.sdk.internal.bn;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class f {
    public static void f(com.kwad.framework.filedownloader.d.c cVar) {
        if (cVar == null) {
            throw new IllegalArgumentException();
        }
        if (cVar.wJ() != -3) {
            throw new IllegalStateException();
        }
        Intent intent = new Intent("filedownloader.intent.action.completed");
        intent.putExtra(bn.f10753i, cVar);
        com.kwad.framework.filedownloader.f.c.zz().sendBroadcast(intent);
    }
}
