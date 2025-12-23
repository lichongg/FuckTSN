package com.kwad.sdk.utils;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.text.TextUtils;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class o {
    public static boolean a(Context context, CharSequence charSequence, CharSequence charSequence2) {
        if (context != null) {
            try {
                if (!TextUtils.isEmpty(charSequence) && !TextUtils.isEmpty(charSequence2)) {
                    ((ClipboardManager) context.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(charSequence, charSequence2));
                    return true;
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }
}
