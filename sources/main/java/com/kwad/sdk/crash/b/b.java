package com.kwad.sdk.crash.b;

import android.text.TextUtils;
import java.util.HashSet;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class b {
    private Set<String> aOX = new HashSet();
    private Set<String> aOY = new HashSet();

    public final synchronized String[] LE() {
        Set<String> set;
        set = this.aOX;
        return (String[]) set.toArray(new String[set.size()]);
    }

    public final synchronized String[] Lt() {
        Set<String> set;
        set = this.aOY;
        return (String[]) set.toArray(new String[set.size()]);
    }

    public final synchronized void a(String[] strArr, String[] strArr2) {
        if (strArr != null) {
            try {
                if (strArr.length > 0) {
                    for (String str : strArr) {
                        if (!TextUtils.isEmpty(str)) {
                            this.aOX.add(str);
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (strArr2 != null && strArr2.length > 0) {
            for (String str2 : strArr2) {
                if (!TextUtils.isEmpty(str2)) {
                    this.aOY.add(str2);
                }
            }
        }
    }
}
