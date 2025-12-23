package com.bytedance.adsdk.xt.xt.cw.j;

import java.util.Deque;

/* loaded from: D:\Downloads\app\classes3.dex */
public class up extends m {
    @Override // com.bytedance.adsdk.xt.xt.cw.j.m
    public int j(String str, int i6, Deque<com.bytedance.adsdk.xt.xt.xt.j> deque, com.bytedance.adsdk.xt.xt.cw.j jVar) {
        char j6;
        int i7 = i6;
        while (true) {
            j6 = j(i7, str);
            if (!com.bytedance.adsdk.xt.xt.up.j.xt(j6) && !com.bytedance.adsdk.xt.xt.up.j.cw(j6)) {
                break;
            }
            i7++;
        }
        if (j6 != '(') {
            return jVar.j(str, i6, deque);
        }
        deque.push(new com.bytedance.adsdk.xt.xt.xt.j.oq(str.substring(i6, i7)));
        return i7 + 1;
    }
}
