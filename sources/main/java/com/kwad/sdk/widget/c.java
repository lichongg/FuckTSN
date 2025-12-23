package com.kwad.sdk.widget;

import android.app.Dialog;
import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.o.m;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Deprecated
/* loaded from: D:\Downloads\app\classes6.dex */
public class c extends Dialog {
    public c(@NonNull Context context) {
        super(m.wrapContextIfNeed(context));
        requestWindowFeature(1);
    }
}
