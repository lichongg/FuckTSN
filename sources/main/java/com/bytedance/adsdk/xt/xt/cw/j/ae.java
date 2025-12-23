package com.bytedance.adsdk.xt.xt.cw.j;

import com.bytedance.adsdk.xt.xt.xt.j.az;
import java.util.Deque;

/* loaded from: D:\Downloads\app\classes3.dex */
public class ae extends m {
    private boolean j(String str, int i6, Deque<com.bytedance.adsdk.xt.xt.xt.j> deque) {
        if ('-' != j(i6, str)) {
            return com.bytedance.adsdk.xt.xt.up.j.cw(j(i6, str));
        }
        if (deque.peek() != null && !com.bytedance.adsdk.xt.xt.r.cw.j(deque.peek().j())) {
            return false;
        }
        if (com.bytedance.adsdk.xt.xt.up.j.cw(j(i6 + 1, str))) {
            return true;
        }
        throw new IllegalArgumentException("Unrecognized - symbol, not a negative number or operator, problem range:" + str.substring(0, i6));
    }

    @Override // com.bytedance.adsdk.xt.xt.cw.j.m
    public int j(String str, int i6, Deque<com.bytedance.adsdk.xt.xt.xt.j> deque, com.bytedance.adsdk.xt.xt.cw.j jVar) {
        char j6;
        if (!j(str, i6, deque)) {
            return jVar.j(str, i6, deque);
        }
        int i7 = j(i6, str) == '-' ? i6 + 1 : i6;
        boolean z5 = false;
        while (true) {
            j6 = j(i7, str);
            if (com.bytedance.adsdk.xt.xt.up.j.cw(j6) || (!z5 && j6 == '.')) {
                i7++;
                if (j6 == '.') {
                    z5 = true;
                }
            }
        }
        if (j6 != '.') {
            deque.push(new az(str.substring(i6, i7)));
            return i7;
        }
        throw new IllegalArgumentException("Illegal negative number format, problem interval:" + str.substring(i6, i7));
    }
}
