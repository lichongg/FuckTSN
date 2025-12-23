package com.bytedance.adsdk.xt.xt.cw.j;

import com.bytedance.adsdk.xt.xt.xt.j.f;
import java.util.Deque;

/* loaded from: D:\Downloads\app\classes3.dex */
public class cw extends m {
    @Override // com.bytedance.adsdk.xt.xt.cw.j.m
    public int j(String str, int i6, Deque<com.bytedance.adsdk.xt.xt.xt.j> deque, com.bytedance.adsdk.xt.xt.cw.j jVar) {
        char j6 = j(i6, str);
        return (com.bytedance.adsdk.xt.xt.up.j.xt(j6) || j6 == '$') ? j(str, i6, deque) : jVar.j(str, i6, deque);
    }

    private int j(String str, int i6, Deque<com.bytedance.adsdk.xt.xt.xt.j> deque) {
        int i7;
        int i8 = 0;
        while (true) {
            i7 = i8 + i6;
            char j6 = j(i7, str);
            if (!com.bytedance.adsdk.xt.xt.up.j.xt(j6) && !com.bytedance.adsdk.xt.xt.up.j.cw(j6) && '.' != j6 && '[' != j6 && ']' != j6 && '_' != j6 && '-' != j6 && '$' != j6) {
                break;
            }
            i8++;
        }
        String substring = str.substring(i6, i7);
        if (com.bytedance.adsdk.xt.xt.r.j.j(substring) != null) {
            deque.push(new com.bytedance.adsdk.xt.xt.xt.j.ae(substring));
            return i7;
        }
        deque.push(new f(substring));
        return i7;
    }
}
