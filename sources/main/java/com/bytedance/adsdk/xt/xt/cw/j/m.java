package com.bytedance.adsdk.xt.xt.cw.j;

import com.alibaba.fastjson.parser.JSONLexer;
import java.util.Deque;

/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class m {
    protected int getIdentifier(int i6, String str) {
        int i7 = 0;
        while (true) {
            int i8 = i7 + i6;
            char j6 = j(i8, str);
            if (!com.bytedance.adsdk.xt.xt.up.j.xt(j6) && !com.bytedance.adsdk.xt.xt.up.j.cw(j6)) {
                return i8;
            }
            i7++;
        }
    }

    protected char j(int i6, String str) {
        return i6 >= str.length() ? JSONLexer.EOI : str.charAt(i6);
    }

    public abstract int j(String str, int i6, Deque<com.bytedance.adsdk.xt.xt.xt.j> deque, com.bytedance.adsdk.xt.xt.cw.j jVar);

    protected int xt(int i6, String str) {
        while (com.bytedance.adsdk.xt.xt.up.j.j(j(i6, str))) {
            i6++;
        }
        return i6;
    }
}
