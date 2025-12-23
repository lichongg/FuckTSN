package com.bytedance.adsdk.lottie.model;

import android.util.Pair;
import com.bytedance.component.sdk.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: D:\Downloads\app\classes3.dex */
public class ae<T> {

    /* renamed from: j, reason: collision with root package name */
    T f23353j;
    T xt;

    private static boolean xt(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        return xt(pair.first, this.f23353j) && xt(pair.second, this.xt);
    }

    public int hashCode() {
        T t5 = this.f23353j;
        int hashCode = t5 == null ? 0 : t5.hashCode();
        T t6 = this.xt;
        return hashCode ^ (t6 != null ? t6.hashCode() : 0);
    }

    public void j(T t5, T t6) {
        this.f23353j = t5;
        this.xt = t6;
    }

    public String toString() {
        return "Pair{" + this.f23353j + " " + this.xt + "}";
    }
}
