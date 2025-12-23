package com.bytedance.sdk.openadsdk.core.tj;

import android.util.SparseArray;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.xt.r;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\Downloads\app\classes4.dex */
public class qv {
    private boolean az;

    /* renamed from: f, reason: collision with root package name */
    private String f30403f;

    /* renamed from: i, reason: collision with root package name */
    private String f30405i;
    private View jy;
    private String mi;

    /* renamed from: v, reason: collision with root package name */
    private int f30409v;
    private View ws;

    /* renamed from: j, reason: collision with root package name */
    private float f30406j = -1.0f;
    private float xt = -1.0f;
    private float cw = -1.0f;

    /* renamed from: r, reason: collision with root package name */
    private float f30408r = -1.0f;
    private long up = -1;

    /* renamed from: m, reason: collision with root package name */
    private long f30407m = -1;
    private int ae = -1;
    private int tl = -1;

    /* renamed from: g, reason: collision with root package name */
    private int f30404g = -1024;
    private boolean oq = true;
    private int qv = 0;
    private int vl = 0;
    private boolean av = false;

    /* renamed from: w, reason: collision with root package name */
    private int f30410w = -1;
    private SparseArray<r.j> kt = new SparseArray<>();
    private List<Integer> tj = new ArrayList();

    public View ae() {
        return this.ws;
    }

    public int cw() {
        return this.tl;
    }

    public boolean j() {
        return this.f30409v == 2;
    }

    public View m() {
        return this.jy;
    }

    public int r() {
        return this.f30404g;
    }

    public boolean up() {
        return this.oq;
    }

    public int xt() {
        return this.ae;
    }

    public void ae(int i6) {
        this.f30410w = i6;
    }

    public float av() {
        return this.cw;
    }

    public float az() {
        return this.xt;
    }

    public void cw(int i6) {
        this.tl = i6;
    }

    public int g() {
        return this.vl;
    }

    public float i() {
        return this.f30408r;
    }

    public void j(int i6) {
        this.f30409v = i6;
    }

    public long jy() {
        return this.f30407m;
    }

    public String kt() {
        return this.mi;
    }

    public void m(int i6) {
        this.vl = i6;
    }

    public int mi() {
        return this.f30410w;
    }

    public SparseArray<r.j> oq() {
        return this.kt;
    }

    public List<Integer> qv() {
        return this.tj;
    }

    public void r(int i6) {
        this.f30404g = i6;
    }

    public String tj() {
        return this.f30403f;
    }

    public int tl() {
        return this.qv;
    }

    public void up(int i6) {
        this.qv = i6;
    }

    public long vl() {
        return this.up;
    }

    public String w() {
        return this.f30405i;
    }

    public float ws() {
        return this.f30406j;
    }

    public void xt(int i6) {
        this.ae = i6;
    }

    public void cw(float f6) {
        this.cw = f6;
    }

    public void j(boolean z5) {
        this.oq = z5;
    }

    public void r(float f6) {
        this.f30408r = f6;
    }

    public void xt(View view) {
        this.ws = (View) new WeakReference(view).get();
    }

    public void cw(boolean z5) {
        this.av = z5;
    }

    public void j(View view) {
        this.jy = (View) new WeakReference(view).get();
    }

    public void xt(long j6) {
        this.f30407m = j6;
    }

    public void cw(String str) {
        this.f30403f = str;
    }

    public void j(SparseArray<r.j> sparseArray) {
        this.kt = sparseArray;
    }

    public void xt(float f6) {
        this.xt = f6;
    }

    public void j(long j6) {
        this.up = j6;
    }

    public void xt(boolean z5) {
        this.az = z5;
    }

    public void j(float f6) {
        this.f30406j = f6;
    }

    public void xt(String str) {
        this.mi = str;
    }

    public void j(String str) {
        this.f30405i = str;
    }
}
