package com.bytedance.adsdk.xt.xt.cw.j;

import com.bytedance.adsdk.xt.xt.xt.j.tj;
import java.util.Deque;

/* loaded from: D:\Downloads\app\classes3.dex */
public class r extends m {
    @Override // com.bytedance.adsdk.xt.xt.cw.j.m
    public int j(String str, int i6, Deque<com.bytedance.adsdk.xt.xt.xt.j> deque, com.bytedance.adsdk.xt.xt.cw.j jVar) {
        if ('(' != j(i6, str)) {
            return jVar.j(str, i6, deque);
        }
        deque.push(new tj(com.bytedance.adsdk.xt.xt.r.r.LEFT_PAREN));
        return i6 + 1;
    }
}
