package com.bytedance.adsdk.xt.xt.cw.j;

import com.bytedance.adsdk.xt.xt.xt.j.av;
import java.util.Deque;

/* loaded from: D:\Downloads\app\classes3.dex */
public class tl extends m {
    @Override // com.bytedance.adsdk.xt.xt.cw.j.m
    public int j(String str, int i6, Deque<com.bytedance.adsdk.xt.xt.xt.j> deque, com.bytedance.adsdk.xt.xt.cw.j jVar) {
        if (!com.bytedance.adsdk.xt.xt.up.j.r(j(i6, str))) {
            return jVar.j(str, i6, deque);
        }
        int i7 = i6 + 1;
        String str2 = new String(new char[]{j(i6, str), j(i7, str)});
        if (com.bytedance.adsdk.xt.xt.r.cw.j(str2) != null) {
            deque.push(new av(com.bytedance.adsdk.xt.xt.r.cw.j(str2)));
            return i6 + 2;
        }
        String valueOf = String.valueOf(j(i6, str));
        if (com.bytedance.adsdk.xt.xt.r.cw.j(valueOf) != null) {
            deque.push(new av(com.bytedance.adsdk.xt.xt.r.cw.j(valueOf)));
            return i7;
        }
        throw new IllegalArgumentException("Unrecognized:" + valueOf + "examine:" + str.substring(0, i6));
    }
}
