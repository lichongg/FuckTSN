package com.bykv.vk.openvk.component.video.j.xt;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

/* loaded from: D:\Downloads\app\classes3.dex */
public class vl {

    /* renamed from: j, reason: collision with root package name */
    private static final Set<String> f23111j = new HashSet();
    private static final Set<String> xt = new HashSet();
    private final int ae;
    private final ArrayList<j> cw;

    /* renamed from: m, reason: collision with root package name */
    private int f23112m;

    /* renamed from: r, reason: collision with root package name */
    private final int f23113r;
    private int up = -1;

    public class j {

        /* renamed from: j, reason: collision with root package name */
        final String f23114j;
        int xt;

        j(String str) {
            this.f23114j = str;
        }

        public String toString() {
            return this.f23114j;
        }

        void j() {
            vl.f23111j.add(this.f23114j);
        }

        void xt() {
            vl.xt.add(this.f23114j);
        }
    }

    vl(List<String> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("urls can't be empty");
        }
        int size = list.size();
        this.f23113r = size;
        this.cw = new ArrayList<>(size);
        ArrayList arrayList = null;
        ArrayList arrayList2 = null;
        for (String str : list) {
            j jVar = new j(str);
            if (f23111j.contains(str)) {
                arrayList2 = arrayList2 == null ? new ArrayList() : arrayList2;
                arrayList2.add(jVar);
            } else if (xt.contains(str)) {
                arrayList = arrayList == null ? new ArrayList() : arrayList;
                arrayList.add(jVar);
            } else {
                this.cw.add(jVar);
            }
        }
        if (arrayList != null) {
            this.cw.addAll(arrayList);
        }
        if (arrayList2 != null) {
            this.cw.addAll(arrayList2);
        }
        Integer num = up.f23102g;
        this.ae = (num == null || num.intValue() <= 0) ? this.f23113r >= 2 ? 1 : 2 : num.intValue();
    }

    boolean j() {
        return this.f23112m < this.ae;
    }

    j xt() {
        if (j()) {
            int i6 = this.up + 1;
            if (i6 >= this.f23113r - 1) {
                this.up = -1;
                this.f23112m++;
            } else {
                this.up = i6;
            }
            j jVar = this.cw.get(i6);
            jVar.xt = (this.f23112m * this.f23113r) + this.up;
            return jVar;
        }
        throw new NoSuchElementException();
    }

    vl(String str) {
        ArrayList<j> arrayList = new ArrayList<>(1);
        this.cw = arrayList;
        arrayList.add(new j(str));
        this.f23113r = 1;
        this.ae = 1;
    }
}
