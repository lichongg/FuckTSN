package com.bytedance.adsdk.xt.xt.cw.j;

import com.bytedance.adsdk.xt.xt.xt.j.kt;
import java.util.Deque;

/* loaded from: D:\Downloads\app\classes3.dex */
public class xt extends m {
    @Override // com.bytedance.adsdk.xt.xt.cw.j.m
    public int j(String str, int i6, Deque<com.bytedance.adsdk.xt.xt.xt.j> deque, com.bytedance.adsdk.xt.xt.cw.j jVar) {
        if ('\'' != j(i6, str)) {
            return jVar.j(str, i6, deque);
        }
        int i7 = i6 + 1;
        int length = str.length();
        int i8 = i7;
        while (i8 < length && j(i8, str) != '\'') {
            i8++;
        }
        if (j(i8, str) == '\'') {
            deque.push(new kt(str.substring(i7, i8)));
            return i8 + 1;
        }
        throw new com.bytedance.adsdk.xt.j.j("String expression not surrounded by '", str.substring(i6));
    }
}
