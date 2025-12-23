package com.bytedance.adsdk.ugeno.flexbox;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.bytedance.adsdk.ugeno.m.m;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: D:\Downloads\app\classes3.dex */
class r {
    static final /* synthetic */ boolean cw = true;

    /* renamed from: j, reason: collision with root package name */
    int[] f23658j;

    /* renamed from: m, reason: collision with root package name */
    private long[] f23659m;

    /* renamed from: r, reason: collision with root package name */
    private final com.bytedance.adsdk.ugeno.flexbox.j f23660r;
    private boolean[] up;
    long[] xt;

    /* renamed from: com.bytedance.adsdk.ugeno.flexbox.r$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class xt implements Comparable<xt> {

        /* renamed from: j, reason: collision with root package name */
        int f23662j;
        int xt;

        private xt() {
        }

        /* synthetic */ xt(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // java.lang.Comparable
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public int compareTo(xt xtVar) {
            int i6 = this.xt;
            int i7 = xtVar.xt;
            return i6 != i7 ? i6 - i7 : this.f23662j - xtVar.f23662j;
        }

        public String toString() {
            return "Order{order=" + this.xt + ", index=" + this.f23662j + '}';
        }
    }

    private int cw(boolean z5) {
        return z5 ? this.f23660r.getPaddingTop() : this.f23660r.getPaddingStart();
    }

    private int r(boolean z5) {
        return z5 ? this.f23660r.getPaddingBottom() : this.f23660r.getPaddingEnd();
    }

    int j(long j6) {
        return (int) j6;
    }

    int xt(long j6) {
        return (int) (j6 >> 32);
    }

    static class j {

        /* renamed from: j, reason: collision with root package name */
        List<cw> f23661j;
        int xt;

        void j() {
            this.f23661j = null;
            this.xt = 0;
        }

        j() {
        }
    }

    private int m(com.bytedance.adsdk.ugeno.flexbox.xt xtVar, boolean z5) {
        return z5 ? xtVar.av() : xtVar.az();
    }

    private int up(com.bytedance.adsdk.ugeno.flexbox.xt xtVar, boolean z5) {
        return z5 ? xtVar.ws() : xtVar.jy();
    }

    /* JADX WARN: Multi-variable type inference failed */
    int[] j(View view, int i6, ViewGroup.LayoutParams layoutParams, SparseIntArray sparseIntArray) {
        int flexItemCount = this.f23660r.getFlexItemCount();
        List<xt> xt2 = xt(flexItemCount);
        xt xtVar = new xt(null);
        if (view == null || !(layoutParams instanceof com.bytedance.adsdk.ugeno.flexbox.xt)) {
            xtVar.xt = 1;
        } else {
            xtVar.xt = ((com.bytedance.adsdk.ugeno.flexbox.xt) layoutParams).cw();
        }
        if (i6 == -1 || i6 == flexItemCount) {
            xtVar.f23662j = flexItemCount;
        } else if (i6 < this.f23660r.getFlexItemCount()) {
            xtVar.f23662j = i6;
            while (i6 < flexItemCount) {
                xt2.get(i6).f23662j++;
                i6++;
            }
        } else {
            xtVar.f23662j = flexItemCount;
        }
        xt2.add(xtVar);
        return j(flexItemCount + 1, xt2, sparseIntArray);
    }

    long xt(int i6, int i7) {
        return (i6 & 4294967295L) | (i7 << 32);
    }

    r(com.bytedance.adsdk.ugeno.flexbox.j jVar) {
        this.f23660r = jVar;
    }

    private int cw(com.bytedance.adsdk.ugeno.flexbox.xt xtVar, boolean z5) {
        if (z5) {
            return xtVar.jy();
        }
        return xtVar.ws();
    }

    private int r(com.bytedance.adsdk.ugeno.flexbox.xt xtVar, boolean z5) {
        if (z5) {
            return xtVar.az();
        }
        return xtVar.av();
    }

    private List<xt> xt(int i6) {
        ArrayList arrayList = new ArrayList(i6);
        for (int i7 = 0; i7 < i6; i7++) {
            com.bytedance.adsdk.ugeno.flexbox.xt xtVar = (com.bytedance.adsdk.ugeno.flexbox.xt) this.f23660r.j(i7).getLayoutParams();
            xt xtVar2 = new xt(null);
            xtVar2.xt = xtVar.cw();
            xtVar2.f23662j = i7;
            arrayList.add(xtVar2);
        }
        return arrayList;
    }

    private void cw(int i6) {
        boolean[] zArr = this.up;
        if (zArr == null) {
            this.up = new boolean[Math.max(i6, 10)];
        } else if (zArr.length < i6) {
            this.up = new boolean[Math.max(zArr.length * 2, i6)];
        } else {
            Arrays.fill(zArr, false);
        }
    }

    boolean xt(SparseIntArray sparseIntArray) {
        int flexItemCount = this.f23660r.getFlexItemCount();
        if (sparseIntArray.size() != flexItemCount) {
            return true;
        }
        for (int i6 = 0; i6 < flexItemCount; i6++) {
            View j6 = this.f23660r.j(i6);
            if (j6 != null && ((com.bytedance.adsdk.ugeno.flexbox.xt) j6.getLayoutParams()).cw() != sparseIntArray.get(i6)) {
                return true;
            }
        }
        return false;
    }

    void xt(j jVar, int i6, int i7) {
        j(jVar, i7, i6, Integer.MAX_VALUE, 0, -1, (List<cw>) null);
    }

    private int xt(boolean z5) {
        if (z5) {
            return this.f23660r.getPaddingEnd();
        }
        return this.f23660r.getPaddingBottom();
    }

    int[] j(SparseIntArray sparseIntArray) {
        int flexItemCount = this.f23660r.getFlexItemCount();
        return j(flexItemCount, xt(flexItemCount), sparseIntArray);
    }

    private int xt(View view, boolean z5) {
        if (z5) {
            return view.getMeasuredHeight();
        }
        return view.getMeasuredWidth();
    }

    private int[] j(int i6, List<xt> list, SparseIntArray sparseIntArray) {
        Collections.sort(list);
        sparseIntArray.clear();
        int[] iArr = new int[i6];
        int i7 = 0;
        for (xt xtVar : list) {
            int i8 = xtVar.f23662j;
            iArr[i7] = i8;
            sparseIntArray.append(i8, xtVar.xt);
            i7++;
        }
        return iArr;
    }

    private int xt(com.bytedance.adsdk.ugeno.flexbox.xt xtVar, boolean z5) {
        if (z5) {
            return xtVar.xt();
        }
        return xtVar.j();
    }

    private void xt(int i6, int i7, cw cwVar, int i8, int i9, boolean z5) {
        float f6;
        int i10;
        int i11;
        int i12 = cwVar.up;
        float f7 = cwVar.qv;
        if (f7 <= 0.0f || i8 > i12) {
            return;
        }
        float f8 = (i12 - i8) / f7;
        cwVar.up = i9 + cwVar.f23655m;
        if (!z5) {
            cwVar.ae = Integer.MIN_VALUE;
        }
        int i13 = 0;
        boolean z6 = false;
        int i14 = 0;
        float f9 = 0.0f;
        while (i13 < cwVar.tl) {
            int i15 = cwVar.az + i13;
            View xt2 = this.f23660r.xt(i15);
            if (xt2 == null || xt2.getVisibility() == 8) {
                f6 = f8;
            } else {
                com.bytedance.adsdk.ugeno.flexbox.xt xtVar = (com.bytedance.adsdk.ugeno.flexbox.xt) xt2.getLayoutParams();
                int flexDirection = this.f23660r.getFlexDirection();
                if (flexDirection != 0 && flexDirection != 1) {
                    int measuredHeight = xt2.getMeasuredHeight();
                    long[] jArr = this.f23659m;
                    if (jArr != null) {
                        measuredHeight = xt(jArr[i15]);
                    }
                    int measuredWidth = xt2.getMeasuredWidth();
                    long[] jArr2 = this.f23659m;
                    if (jArr2 != null) {
                        measuredWidth = j(jArr2[i15]);
                    }
                    if (!this.up[i15] && xtVar.up() > 0.0f) {
                        float up = measuredHeight - (xtVar.up() * f8);
                        if (i13 == cwVar.tl - 1) {
                            up += f9;
                            f9 = 0.0f;
                        }
                        int round = Math.round(up);
                        if (round < xtVar.tl()) {
                            round = xtVar.tl();
                            this.up[i15] = true;
                            cwVar.qv -= xtVar.up();
                            z6 = true;
                        } else {
                            f9 += up - round;
                            double d6 = f9;
                            if (d6 > 1.0d) {
                                round++;
                                f9 -= 1.0f;
                            } else if (d6 < -1.0d) {
                                round--;
                                f9 += 1.0f;
                            }
                        }
                        int j6 = j(i6, xtVar, cwVar.jy);
                        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(round, 1073741824);
                        xt2.measure(j6, makeMeasureSpec);
                        int measuredWidth2 = xt2.getMeasuredWidth();
                        int measuredHeight2 = xt2.getMeasuredHeight();
                        j(i15, j6, makeMeasureSpec, xt2);
                        measuredWidth = measuredWidth2;
                        measuredHeight = measuredHeight2;
                    }
                    i10 = Math.max(i14, measuredWidth + xtVar.jy() + xtVar.az() + this.f23660r.j(xt2));
                    cwVar.up += measuredHeight + xtVar.ws() + xtVar.av();
                    f6 = f8;
                } else {
                    int measuredWidth3 = xt2.getMeasuredWidth();
                    long[] jArr3 = this.f23659m;
                    if (jArr3 != null) {
                        measuredWidth3 = j(jArr3[i15]);
                    }
                    int measuredHeight3 = xt2.getMeasuredHeight();
                    long[] jArr4 = this.f23659m;
                    f6 = f8;
                    if (jArr4 != null) {
                        measuredHeight3 = xt(jArr4[i15]);
                    }
                    if (!this.up[i15] && xtVar.up() > 0.0f) {
                        float up2 = measuredWidth3 - (f6 * xtVar.up());
                        if (i13 == cwVar.tl - 1) {
                            up2 += f9;
                            f9 = 0.0f;
                        }
                        int round2 = Math.round(up2);
                        if (round2 < xtVar.ae()) {
                            i11 = xtVar.ae();
                            this.up[i15] = true;
                            cwVar.qv -= xtVar.up();
                            z6 = true;
                        } else {
                            f9 += up2 - round2;
                            double d7 = f9;
                            if (d7 > 1.0d) {
                                i11 = round2 + 1;
                                f9 -= 1.0f;
                            } else if (d7 < -1.0d) {
                                i11 = round2 - 1;
                                f9 += 1.0f;
                            } else {
                                i11 = round2;
                            }
                        }
                        int xt3 = xt(i7, xtVar, cwVar.jy);
                        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i11, 1073741824);
                        xt2.measure(makeMeasureSpec2, xt3);
                        int measuredWidth4 = xt2.getMeasuredWidth();
                        int measuredHeight4 = xt2.getMeasuredHeight();
                        j(i15, makeMeasureSpec2, xt3, xt2);
                        measuredWidth3 = measuredWidth4;
                        measuredHeight3 = measuredHeight4;
                    }
                    int max = Math.max(i14, measuredHeight3 + xtVar.ws() + xtVar.av() + this.f23660r.j(xt2));
                    cwVar.up += measuredWidth3 + xtVar.jy() + xtVar.az();
                    i10 = max;
                }
                cwVar.ae = Math.max(cwVar.ae, i10);
                i14 = i10;
            }
            i13++;
            f8 = f6;
        }
        if (!z6 || i12 == cwVar.up) {
            return;
        }
        xt(i6, i7, cwVar, i8, i9, true);
    }

    void j(j jVar, int i6, int i7) {
        j(jVar, i6, i7, Integer.MAX_VALUE, 0, -1, (List<cw>) null);
    }

    void j(j jVar, int i6, int i7, int i8, int i9, int i10, List<cw> list) {
        int i11;
        j jVar2;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        cw cwVar;
        int i20;
        int i21;
        boolean z5;
        int i22;
        boolean z6;
        int i23;
        int i24 = i6;
        boolean j6 = this.f23660r.j();
        int mode = View.MeasureSpec.getMode(i24);
        int size = View.MeasureSpec.getSize(i24);
        List<cw> arrayList = list == null ? new ArrayList() : list;
        jVar.f23661j = arrayList;
        boolean z7 = i10 == -1;
        int j7 = j(j6);
        int xt2 = xt(j6);
        int cw2 = cw(j6);
        int r5 = r(j6);
        cw cwVar2 = new cw();
        int i25 = i9;
        cwVar2.az = i25;
        int i26 = j7 + xt2;
        cwVar2.up = i26;
        int flexItemCount = this.f23660r.getFlexItemCount();
        boolean z8 = z7;
        cw cwVar3 = cwVar2;
        int i27 = 0;
        int i28 = 0;
        int i29 = 0;
        int i30 = Integer.MIN_VALUE;
        while (true) {
            if (i25 >= flexItemCount) {
                i11 = i28;
                jVar2 = jVar;
                break;
            }
            View xt3 = this.f23660r.xt(i25);
            if (xt3 == null) {
                if (j(i25, flexItemCount, cwVar3)) {
                    j(arrayList, cwVar3, i25, i27);
                }
                i12 = i26;
            } else {
                i12 = i26;
                if (xt3.getVisibility() == 8) {
                    cwVar3.f23652g++;
                    cwVar3.tl++;
                    if (j(i25, flexItemCount, cwVar3)) {
                        j(arrayList, cwVar3, i25, i27);
                    }
                } else {
                    if (xt3 instanceof CompoundButton) {
                        j((CompoundButton) xt3);
                    }
                    com.bytedance.adsdk.ugeno.flexbox.xt xtVar = (com.bytedance.adsdk.ugeno.flexbox.xt) xt3.getLayoutParams();
                    int i31 = flexItemCount;
                    if (xtVar.m() == 4) {
                        cwVar3.ws.add(Integer.valueOf(i25));
                    }
                    int j8 = j(xtVar, j6);
                    if (xtVar.vl() != -1.0f && mode == 1073741824) {
                        j8 = Math.round(size * xtVar.vl());
                    }
                    if (j6) {
                        i13 = mode;
                        i16 = this.f23660r.j(i24, i12 + cw(xtVar, true) + r(xtVar, true), j8);
                        i14 = size;
                        i15 = i27;
                        int xt4 = this.f23660r.xt(i7, cw2 + r5 + up(xtVar, true) + m(xtVar, true) + i27, xt(xtVar, true));
                        xt3.measure(i16, xt4);
                        j(i25, i16, xt4, xt3);
                    } else {
                        i13 = mode;
                        i14 = size;
                        i15 = i27;
                        int j9 = this.f23660r.j(i7, cw2 + r5 + up(xtVar, false) + m(xtVar, false) + i15, xt(xtVar, false));
                        int xt5 = this.f23660r.xt(i24, i12 + cw(xtVar, false) + r(xtVar, false), j8);
                        xt3.measure(j9, xt5);
                        j(i25, j9, xt5, xt3);
                        i16 = xt5;
                    }
                    j(xt3, i25);
                    i28 = View.combineMeasuredStates(i28, xt3.getMeasuredState());
                    i17 = i25;
                    int i32 = i16;
                    cw cwVar4 = cwVar3;
                    int i33 = i29;
                    i18 = i12;
                    i19 = i15;
                    boolean z9 = j6;
                    size = i14;
                    if (j(xt3, i13, size, cwVar3.up, j(xt3, j6) + cw(xtVar, j6) + r(xtVar, j6), xtVar, i17, i33, arrayList.size())) {
                        if (cwVar4.xt() > 0) {
                            j(arrayList, cwVar4, i17 > 0 ? i17 - 1 : 0, i19);
                            i23 = i19 + cwVar4.ae;
                        } else {
                            i23 = i19;
                        }
                        if (z9) {
                            if (xtVar.xt() == -1) {
                                com.bytedance.adsdk.ugeno.flexbox.j jVar3 = this.f23660r;
                                xt3.measure(i32, jVar3.xt(i7, jVar3.getPaddingTop() + this.f23660r.getPaddingBottom() + xtVar.ws() + xtVar.av() + i23, xtVar.xt()));
                                j(xt3, i17);
                            }
                        } else if (xtVar.j() == -1) {
                            com.bytedance.adsdk.ugeno.flexbox.j jVar4 = this.f23660r;
                            xt3.measure(jVar4.j(i7, jVar4.getPaddingLeft() + this.f23660r.getPaddingRight() + xtVar.jy() + xtVar.az() + i23, xtVar.j()), i32);
                            j(xt3, i17);
                        }
                        cw cwVar5 = new cw();
                        cwVar5.tl = 1;
                        cwVar5.up = i18;
                        cwVar5.az = i17;
                        i19 = i23;
                        i20 = 0;
                        cwVar = cwVar5;
                        i21 = Integer.MIN_VALUE;
                    } else {
                        cwVar = cwVar4;
                        cwVar.tl++;
                        i20 = i33 + 1;
                        i21 = i30;
                    }
                    cwVar.f23653i |= xtVar.r() != 0.0f;
                    cwVar.f23657w |= xtVar.up() != 0.0f;
                    int[] iArr = this.f23658j;
                    if (iArr != null) {
                        iArr[i17] = arrayList.size();
                    }
                    z5 = z9;
                    cwVar.up += j(xt3, z5) + cw(xtVar, z5) + r(xtVar, z5);
                    cwVar.oq += xtVar.r();
                    cwVar.qv += xtVar.up();
                    this.f23660r.j(xt3, i17, i20, cwVar);
                    int max = Math.max(i21, xt(xt3, z5) + up(xtVar, z5) + m(xtVar, z5) + this.f23660r.j(xt3));
                    cwVar.ae = Math.max(cwVar.ae, max);
                    if (z5) {
                        if (this.f23660r.getFlexWrap() != 2) {
                            cwVar.vl = Math.max(cwVar.vl, xt3.getBaseline() + xtVar.ws());
                        } else {
                            cwVar.vl = Math.max(cwVar.vl, (xt3.getMeasuredHeight() - xt3.getBaseline()) + xtVar.av());
                        }
                    }
                    i22 = i31;
                    if (j(i17, i22, cwVar)) {
                        j(arrayList, cwVar, i17, i19);
                        i19 += cwVar.ae;
                    }
                    if (i10 != -1 && arrayList.size() > 0) {
                        if (arrayList.get(arrayList.size() - 1).av >= i10 && i17 >= i10 && !z8) {
                            i19 = -cwVar.j();
                            z6 = true;
                            if (i19 <= i8 && z6) {
                                jVar2 = jVar;
                                i11 = i28;
                                break;
                            }
                            i30 = max;
                            z8 = z6;
                            i29 = i20;
                            int i34 = i17 + 1;
                            j6 = z5;
                            cwVar3 = cwVar;
                            i26 = i18;
                            i27 = i19;
                            i24 = i6;
                            flexItemCount = i22;
                            i25 = i34;
                            mode = i13;
                        }
                    }
                    z6 = z8;
                    if (i19 <= i8) {
                    }
                    i30 = max;
                    z8 = z6;
                    i29 = i20;
                    int i342 = i17 + 1;
                    j6 = z5;
                    cwVar3 = cwVar;
                    i26 = i18;
                    i27 = i19;
                    i24 = i6;
                    flexItemCount = i22;
                    i25 = i342;
                    mode = i13;
                }
            }
            i17 = i25;
            i13 = mode;
            i22 = flexItemCount;
            i19 = i27;
            z5 = j6;
            i18 = i12;
            cwVar = cwVar3;
            int i3422 = i17 + 1;
            j6 = z5;
            cwVar3 = cwVar;
            i26 = i18;
            i27 = i19;
            i24 = i6;
            flexItemCount = i22;
            i25 = i3422;
            mode = i13;
        }
        jVar2.xt = i11;
    }

    private int xt(int i6, com.bytedance.adsdk.ugeno.flexbox.xt xtVar, int i7) {
        com.bytedance.adsdk.ugeno.flexbox.j jVar = this.f23660r;
        int xt2 = jVar.xt(i6, jVar.getPaddingTop() + this.f23660r.getPaddingBottom() + xtVar.ws() + xtVar.av() + i7, xtVar.xt());
        int size = View.MeasureSpec.getSize(xt2);
        if (size > xtVar.oq()) {
            return View.MeasureSpec.makeMeasureSpec(xtVar.oq(), View.MeasureSpec.getMode(xt2));
        }
        return size < xtVar.tl() ? View.MeasureSpec.makeMeasureSpec(xtVar.tl(), View.MeasureSpec.getMode(xt2)) : xt2;
    }

    void xt(int i6, int i7, int i8) {
        int i9;
        int i10;
        int flexDirection = this.f23660r.getFlexDirection();
        if (flexDirection != 0 && flexDirection != 1) {
            if (flexDirection != 2 && flexDirection != 3) {
                throw new IllegalArgumentException("Invalid flex direction: ".concat(String.valueOf(flexDirection)));
            }
            i9 = View.MeasureSpec.getMode(i6);
            i10 = View.MeasureSpec.getSize(i6);
        } else {
            int mode = View.MeasureSpec.getMode(i7);
            int size = View.MeasureSpec.getSize(i7);
            i9 = mode;
            i10 = size;
        }
        List<cw> flexLinesInternal = this.f23660r.getFlexLinesInternal();
        if (i9 == 1073741824) {
            int sumOfCrossSize = this.f23660r.getSumOfCrossSize() + i8;
            int i11 = 0;
            if (flexLinesInternal.size() == 1) {
                flexLinesInternal.get(0).ae = i10 - i8;
                return;
            }
            if (flexLinesInternal.size() >= 2) {
                int alignContent = this.f23660r.getAlignContent();
                if (alignContent == 1) {
                    int i12 = i10 - sumOfCrossSize;
                    cw cwVar = new cw();
                    cwVar.ae = i12;
                    flexLinesInternal.add(0, cwVar);
                    return;
                }
                if (alignContent == 2) {
                    this.f23660r.setFlexLines(j(flexLinesInternal, i10, sumOfCrossSize));
                    return;
                }
                if (alignContent == 3) {
                    if (sumOfCrossSize < i10) {
                        float size2 = (i10 - sumOfCrossSize) / (flexLinesInternal.size() - 1);
                        ArrayList arrayList = new ArrayList();
                        int size3 = flexLinesInternal.size();
                        float f6 = 0.0f;
                        while (i11 < size3) {
                            arrayList.add(flexLinesInternal.get(i11));
                            if (i11 != flexLinesInternal.size() - 1) {
                                cw cwVar2 = new cw();
                                if (i11 == flexLinesInternal.size() - 2) {
                                    cwVar2.ae = Math.round(f6 + size2);
                                    f6 = 0.0f;
                                } else {
                                    cwVar2.ae = Math.round(size2);
                                }
                                int i13 = cwVar2.ae;
                                f6 += size2 - i13;
                                if (f6 > 1.0f) {
                                    cwVar2.ae = i13 + 1;
                                    f6 -= 1.0f;
                                } else if (f6 < -1.0f) {
                                    cwVar2.ae = i13 - 1;
                                    f6 += 1.0f;
                                }
                                arrayList.add(cwVar2);
                            }
                            i11++;
                        }
                        this.f23660r.setFlexLines(arrayList);
                        return;
                    }
                    return;
                }
                if (alignContent == 4) {
                    if (sumOfCrossSize >= i10) {
                        this.f23660r.setFlexLines(j(flexLinesInternal, i10, sumOfCrossSize));
                        return;
                    }
                    int size4 = (i10 - sumOfCrossSize) / (flexLinesInternal.size() * 2);
                    ArrayList arrayList2 = new ArrayList();
                    cw cwVar3 = new cw();
                    cwVar3.ae = size4;
                    for (cw cwVar4 : flexLinesInternal) {
                        arrayList2.add(cwVar3);
                        arrayList2.add(cwVar4);
                        arrayList2.add(cwVar3);
                    }
                    this.f23660r.setFlexLines(arrayList2);
                    return;
                }
                if (alignContent == 5 && sumOfCrossSize < i10) {
                    float size5 = (i10 - sumOfCrossSize) / flexLinesInternal.size();
                    int size6 = flexLinesInternal.size();
                    float f7 = 0.0f;
                    while (i11 < size6) {
                        cw cwVar5 = flexLinesInternal.get(i11);
                        float f8 = cwVar5.ae + size5;
                        if (i11 == flexLinesInternal.size() - 1) {
                            f8 += f7;
                            f7 = 0.0f;
                        }
                        int round = Math.round(f8);
                        f7 += f8 - round;
                        if (f7 > 1.0f) {
                            round++;
                            f7 -= 1.0f;
                        } else if (f7 < -1.0f) {
                            round--;
                            f7 += 1.0f;
                        }
                        cwVar5.ae = round;
                        i11++;
                    }
                }
            }
        }
    }

    private void j(CompoundButton compoundButton) {
        com.bytedance.adsdk.ugeno.flexbox.xt xtVar = (com.bytedance.adsdk.ugeno.flexbox.xt) compoundButton.getLayoutParams();
        int ae = xtVar.ae();
        int tl = xtVar.tl();
        Drawable j6 = com.bytedance.adsdk.ugeno.m.up.j(compoundButton);
        int minimumWidth = j6 == null ? 0 : j6.getMinimumWidth();
        int minimumHeight = j6 != null ? j6.getMinimumHeight() : 0;
        if (ae == -1) {
            ae = minimumWidth;
        }
        xtVar.j(ae);
        if (tl == -1) {
            tl = minimumHeight;
        }
        xtVar.xt(tl);
    }

    private int j(boolean z5) {
        if (z5) {
            return this.f23660r.getPaddingStart();
        }
        return this.f23660r.getPaddingTop();
    }

    private int j(View view, boolean z5) {
        if (z5) {
            return view.getMeasuredWidth();
        }
        return view.getMeasuredHeight();
    }

    private void xt(View view, int i6, int i7) {
        int measuredHeight;
        com.bytedance.adsdk.ugeno.flexbox.xt xtVar = (com.bytedance.adsdk.ugeno.flexbox.xt) view.getLayoutParams();
        int min = Math.min(Math.max(((i6 - xtVar.jy()) - xtVar.az()) - this.f23660r.j(view), xtVar.ae()), xtVar.g());
        long[] jArr = this.f23659m;
        if (jArr != null) {
            measuredHeight = xt(jArr[i7]);
        } else {
            measuredHeight = view.getMeasuredHeight();
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(min, 1073741824);
        view.measure(makeMeasureSpec2, makeMeasureSpec);
        j(i7, makeMeasureSpec2, makeMeasureSpec, view);
    }

    private int j(com.bytedance.adsdk.ugeno.flexbox.xt xtVar, boolean z5) {
        if (z5) {
            return xtVar.j();
        }
        return xtVar.xt();
    }

    private boolean j(View view, int i6, int i7, int i8, int i9, com.bytedance.adsdk.ugeno.flexbox.xt xtVar, int i10, int i11, int i12) {
        if (this.f23660r.getFlexWrap() == 0) {
            return false;
        }
        if (xtVar.qv()) {
            return true;
        }
        if (i6 == 0) {
            return false;
        }
        int maxLine = this.f23660r.getMaxLine();
        if (maxLine != -1 && maxLine <= i12 + 1) {
            return false;
        }
        int j6 = this.f23660r.j(view, i10, i11);
        if (j6 > 0) {
            i9 += j6;
        }
        return i7 < i8 + i9;
    }

    private boolean j(int i6, int i7, cw cwVar) {
        return i6 == i7 - 1 && cwVar.xt() != 0;
    }

    private void j(List<cw> list, cw cwVar, int i6, int i7) {
        cwVar.jy = i7;
        this.f23660r.j(cwVar);
        cwVar.av = i6;
        list.add(cwVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void j(android.view.View r7, int r8) {
        /*
            r6 = this;
            android.view.ViewGroup$LayoutParams r0 = r7.getLayoutParams()
            com.bytedance.adsdk.ugeno.flexbox.xt r0 = (com.bytedance.adsdk.ugeno.flexbox.xt) r0
            int r1 = r7.getMeasuredWidth()
            int r2 = r7.getMeasuredHeight()
            int r3 = r0.ae()
            r4 = 1
            if (r1 >= r3) goto L1b
            int r1 = r0.ae()
        L19:
            r3 = 1
            goto L27
        L1b:
            int r3 = r0.g()
            if (r1 <= r3) goto L26
            int r1 = r0.g()
            goto L19
        L26:
            r3 = 0
        L27:
            int r5 = r0.tl()
            if (r2 >= r5) goto L32
            int r2 = r0.tl()
            goto L3e
        L32:
            int r5 = r0.oq()
            if (r2 <= r5) goto L3d
            int r2 = r0.oq()
            goto L3e
        L3d:
            r4 = r3
        L3e:
            if (r4 == 0) goto L50
            r0 = 1073741824(0x40000000, float:2.0)
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r0)
            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r0)
            r7.measure(r1, r0)
            r6.j(r8, r1, r0, r7)
        L50:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.ugeno.flexbox.r.j(android.view.View, int):void");
    }

    void j(int i6, int i7) {
        j(i6, i7, 0);
    }

    void j(int i6, int i7, int i8) {
        int size;
        int paddingLeft;
        int paddingRight;
        int i9;
        int i10;
        cw(this.f23660r.getFlexItemCount());
        if (i8 >= this.f23660r.getFlexItemCount()) {
            return;
        }
        int flexDirection = this.f23660r.getFlexDirection();
        int flexDirection2 = this.f23660r.getFlexDirection();
        if (flexDirection2 == 0 || flexDirection2 == 1) {
            int mode = View.MeasureSpec.getMode(i6);
            size = View.MeasureSpec.getSize(i6);
            int largestMainSize = this.f23660r.getLargestMainSize();
            if (mode != 1073741824) {
                size = Math.min(largestMainSize, size);
            }
            paddingLeft = this.f23660r.getPaddingLeft();
            paddingRight = this.f23660r.getPaddingRight();
        } else {
            if (flexDirection2 != 2 && flexDirection2 != 3) {
                throw new IllegalArgumentException("Invalid flex direction: ".concat(String.valueOf(flexDirection)));
            }
            int mode2 = View.MeasureSpec.getMode(i7);
            size = View.MeasureSpec.getSize(i7);
            if (mode2 != 1073741824) {
                size = this.f23660r.getLargestMainSize();
            }
            paddingLeft = this.f23660r.getPaddingTop();
            paddingRight = this.f23660r.getPaddingBottom();
        }
        int i11 = paddingLeft + paddingRight;
        int i12 = size;
        int[] iArr = this.f23658j;
        int i13 = iArr != null ? iArr[i8] : 0;
        List<cw> flexLinesInternal = this.f23660r.getFlexLinesInternal();
        int size2 = flexLinesInternal.size();
        while (i13 < size2) {
            cw cwVar = flexLinesInternal.get(i13);
            int i14 = cwVar.up;
            if (i14 < i12 && cwVar.f23653i) {
                i9 = i6;
                i10 = i7;
                j(i9, i10, cwVar, i12, i11, false);
            } else {
                i9 = i6;
                i10 = i7;
                if (i14 > i12 && cwVar.f23657w) {
                    xt(i9, i10, cwVar, i12, i11, false);
                }
            }
            i13++;
            i6 = i9;
            i7 = i10;
        }
    }

    private void j(int i6, int i7, cw cwVar, int i8, int i9, boolean z5) {
        int i10;
        float f6;
        int i11;
        double d6;
        double d7;
        float f7 = cwVar.oq;
        if (f7 <= 0.0f || i8 < (i10 = cwVar.up)) {
            return;
        }
        float f8 = (i8 - i10) / f7;
        cwVar.up = i9 + cwVar.f23655m;
        if (!z5) {
            cwVar.ae = Integer.MIN_VALUE;
        }
        int i12 = 0;
        boolean z6 = false;
        int i13 = 0;
        float f9 = 0.0f;
        while (i12 < cwVar.tl) {
            int i14 = cwVar.az + i12;
            View xt2 = this.f23660r.xt(i14);
            if (xt2 == null || xt2.getVisibility() == 8) {
                f6 = f8;
                z6 = z6;
            } else {
                com.bytedance.adsdk.ugeno.flexbox.xt xtVar = (com.bytedance.adsdk.ugeno.flexbox.xt) xt2.getLayoutParams();
                int flexDirection = this.f23660r.getFlexDirection();
                if (flexDirection != 0 && flexDirection != 1) {
                    int measuredHeight = xt2.getMeasuredHeight();
                    long[] jArr = this.f23659m;
                    if (jArr != null) {
                        measuredHeight = xt(jArr[i14]);
                    }
                    int measuredWidth = xt2.getMeasuredWidth();
                    long[] jArr2 = this.f23659m;
                    f6 = f8;
                    boolean z7 = z6;
                    if (jArr2 != null) {
                        measuredWidth = j(jArr2[i14]);
                    }
                    if (this.up[i14] || xtVar.r() <= 0.0f) {
                        z6 = z7;
                    } else {
                        float r5 = measuredHeight + (xtVar.r() * f6);
                        if (i12 == cwVar.tl - 1) {
                            r5 += f9;
                            f9 = 0.0f;
                        }
                        int round = Math.round(r5);
                        if (round > xtVar.oq()) {
                            round = xtVar.oq();
                            this.up[i14] = true;
                            cwVar.oq -= xtVar.r();
                            z6 = true;
                        } else {
                            f9 += r5 - round;
                            double d8 = f9;
                            if (d8 > 1.0d) {
                                round++;
                                d7 = d8 - 1.0d;
                            } else {
                                if (d8 < -1.0d) {
                                    round--;
                                    d7 = d8 + 1.0d;
                                }
                                z6 = z7;
                            }
                            f9 = (float) d7;
                            z6 = z7;
                        }
                        int j6 = j(i6, xtVar, cwVar.jy);
                        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(round, 1073741824);
                        xt2.measure(j6, makeMeasureSpec);
                        int measuredWidth2 = xt2.getMeasuredWidth();
                        int measuredHeight2 = xt2.getMeasuredHeight();
                        j(i14, j6, makeMeasureSpec, xt2);
                        measuredWidth = measuredWidth2;
                        measuredHeight = measuredHeight2;
                    }
                    i11 = Math.max(i13, measuredWidth + xtVar.jy() + xtVar.az() + this.f23660r.j(xt2));
                    cwVar.up += measuredHeight + xtVar.ws() + xtVar.av();
                } else {
                    f6 = f8;
                    boolean z8 = z6;
                    int measuredWidth3 = xt2.getMeasuredWidth();
                    long[] jArr3 = this.f23659m;
                    if (jArr3 != null) {
                        measuredWidth3 = j(jArr3[i14]);
                    }
                    int measuredHeight3 = xt2.getMeasuredHeight();
                    long[] jArr4 = this.f23659m;
                    if (jArr4 != null) {
                        measuredHeight3 = xt(jArr4[i14]);
                    }
                    if (this.up[i14] || xtVar.r() <= 0.0f) {
                        z6 = z8;
                    } else {
                        float r6 = measuredWidth3 + (xtVar.r() * f6);
                        if (i12 == cwVar.tl - 1) {
                            r6 += f9;
                            f9 = 0.0f;
                        }
                        int round2 = Math.round(r6);
                        if (round2 > xtVar.g()) {
                            round2 = xtVar.g();
                            this.up[i14] = true;
                            cwVar.oq -= xtVar.r();
                            z6 = true;
                        } else {
                            f9 += r6 - round2;
                            double d9 = f9;
                            if (d9 > 1.0d) {
                                round2++;
                                d6 = d9 - 1.0d;
                            } else {
                                if (d9 < -1.0d) {
                                    round2--;
                                    d6 = d9 + 1.0d;
                                }
                                z6 = z8;
                            }
                            f9 = (float) d6;
                            z6 = z8;
                        }
                        int xt3 = xt(i7, xtVar, cwVar.jy);
                        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(round2, 1073741824);
                        xt2.measure(makeMeasureSpec2, xt3);
                        int measuredWidth4 = xt2.getMeasuredWidth();
                        int measuredHeight4 = xt2.getMeasuredHeight();
                        j(i14, makeMeasureSpec2, xt3, xt2);
                        measuredWidth3 = measuredWidth4;
                        measuredHeight3 = measuredHeight4;
                    }
                    int max = Math.max(i13, measuredHeight3 + xtVar.ws() + xtVar.av() + this.f23660r.j(xt2));
                    cwVar.up += measuredWidth3 + xtVar.jy() + xtVar.az();
                    i11 = max;
                }
                cwVar.ae = Math.max(cwVar.ae, i11);
                i13 = i11;
            }
            i12++;
            f8 = f6;
        }
        if (!z6 || i10 == cwVar.up) {
            return;
        }
        j(i6, i7, cwVar, i8, i9, true);
    }

    private int j(int i6, com.bytedance.adsdk.ugeno.flexbox.xt xtVar, int i7) {
        com.bytedance.adsdk.ugeno.flexbox.j jVar = this.f23660r;
        int j6 = jVar.j(i6, jVar.getPaddingLeft() + this.f23660r.getPaddingRight() + xtVar.jy() + xtVar.az() + i7, xtVar.j());
        int size = View.MeasureSpec.getSize(j6);
        if (size > xtVar.g()) {
            return View.MeasureSpec.makeMeasureSpec(xtVar.g(), View.MeasureSpec.getMode(j6));
        }
        return size < xtVar.ae() ? View.MeasureSpec.makeMeasureSpec(xtVar.ae(), View.MeasureSpec.getMode(j6)) : j6;
    }

    private List<cw> j(List<cw> list, int i6, int i7) {
        int i8 = (i6 - i7) / 2;
        ArrayList arrayList = new ArrayList();
        cw cwVar = new cw();
        cwVar.ae = i8;
        int size = list.size();
        for (int i9 = 0; i9 < size; i9++) {
            if (i9 == 0) {
                arrayList.add(cwVar);
            }
            arrayList.add(list.get(i9));
            if (i9 == list.size() - 1) {
                arrayList.add(cwVar);
            }
        }
        return arrayList;
    }

    void j() {
        j(0);
    }

    void j(int i6) {
        View xt2;
        if (i6 >= this.f23660r.getFlexItemCount()) {
            return;
        }
        int flexDirection = this.f23660r.getFlexDirection();
        if (this.f23660r.getAlignItems() == 4) {
            int[] iArr = this.f23658j;
            List<cw> flexLinesInternal = this.f23660r.getFlexLinesInternal();
            int size = flexLinesInternal.size();
            for (int i7 = iArr != null ? iArr[i6] : 0; i7 < size; i7++) {
                cw cwVar = flexLinesInternal.get(i7);
                int i8 = cwVar.tl;
                for (int i9 = 0; i9 < i8; i9++) {
                    int i10 = cwVar.az + i9;
                    if (i9 < this.f23660r.getFlexItemCount() && (xt2 = this.f23660r.xt(i10)) != null && xt2.getVisibility() != 8) {
                        com.bytedance.adsdk.ugeno.flexbox.xt xtVar = (com.bytedance.adsdk.ugeno.flexbox.xt) xt2.getLayoutParams();
                        if (xtVar.m() == -1 || xtVar.m() == 4) {
                            if (flexDirection != 0 && flexDirection != 1) {
                                if (flexDirection != 2 && flexDirection != 3) {
                                    throw new IllegalArgumentException("Invalid flex direction: ".concat(String.valueOf(flexDirection)));
                                }
                                xt(xt2, cwVar.ae, i10);
                            } else {
                                j(xt2, cwVar.ae, i10);
                            }
                        }
                    }
                }
            }
            return;
        }
        for (cw cwVar2 : this.f23660r.getFlexLinesInternal()) {
            for (Integer num : cwVar2.ws) {
                View xt3 = this.f23660r.xt(num.intValue());
                if (flexDirection != 0 && flexDirection != 1) {
                    if (flexDirection != 2 && flexDirection != 3) {
                        throw new IllegalArgumentException("Invalid flex direction: ".concat(String.valueOf(flexDirection)));
                    }
                    xt(xt3, cwVar2.ae, num.intValue());
                } else {
                    j(xt3, cwVar2.ae, num.intValue());
                }
            }
        }
    }

    private void j(View view, int i6, int i7) {
        int measuredWidth;
        com.bytedance.adsdk.ugeno.flexbox.xt xtVar = (com.bytedance.adsdk.ugeno.flexbox.xt) view.getLayoutParams();
        int min = Math.min(Math.max(((i6 - xtVar.ws()) - xtVar.av()) - this.f23660r.j(view), xtVar.tl()), xtVar.oq());
        long[] jArr = this.f23659m;
        if (jArr != null) {
            measuredWidth = j(jArr[i7]);
        } else {
            measuredWidth = view.getMeasuredWidth();
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(min, 1073741824);
        view.measure(makeMeasureSpec, makeMeasureSpec2);
        j(i7, makeMeasureSpec, makeMeasureSpec2, view);
    }

    void j(View view, cw cwVar, int i6, int i7, int i8, int i9) {
        com.bytedance.adsdk.ugeno.flexbox.xt xtVar = (com.bytedance.adsdk.ugeno.flexbox.xt) view.getLayoutParams();
        int alignItems = this.f23660r.getAlignItems();
        if (xtVar.m() != -1) {
            alignItems = xtVar.m();
        }
        int i10 = cwVar.ae;
        if (alignItems != 0) {
            if (alignItems == 1) {
                if (this.f23660r.getFlexWrap() != 2) {
                    int i11 = i7 + i10;
                    view.layout(i6, (i11 - view.getMeasuredHeight()) - xtVar.av(), i8, i11 - xtVar.av());
                    return;
                } else {
                    view.layout(i6, (i7 - i10) + view.getMeasuredHeight() + xtVar.ws(), i8, (i9 - i10) + view.getMeasuredHeight() + xtVar.ws());
                    return;
                }
            }
            if (alignItems == 2) {
                int measuredHeight = (((i10 - view.getMeasuredHeight()) + xtVar.ws()) - xtVar.av()) / 2;
                if (this.f23660r.getFlexWrap() != 2) {
                    int i12 = i7 + measuredHeight;
                    view.layout(i6, i12, i8, view.getMeasuredHeight() + i12);
                    return;
                } else {
                    int i13 = i7 - measuredHeight;
                    view.layout(i6, i13, i8, view.getMeasuredHeight() + i13);
                    return;
                }
            }
            if (alignItems == 3) {
                if (this.f23660r.getFlexWrap() != 2) {
                    int max = Math.max(cwVar.vl - view.getBaseline(), xtVar.ws());
                    view.layout(i6, i7 + max, i8, i9 + max);
                    return;
                } else {
                    int max2 = Math.max((cwVar.vl - view.getMeasuredHeight()) + view.getBaseline(), xtVar.av());
                    view.layout(i6, i7 - max2, i8, i9 - max2);
                    return;
                }
            }
            if (alignItems != 4) {
                return;
            }
        }
        if (this.f23660r.getFlexWrap() != 2) {
            view.layout(i6, i7 + xtVar.ws(), i8, i9 + xtVar.ws());
        } else {
            view.layout(i6, i7 - xtVar.av(), i8, i9 - xtVar.av());
        }
    }

    void j(View view, cw cwVar, boolean z5, int i6, int i7, int i8, int i9) {
        com.bytedance.adsdk.ugeno.flexbox.xt xtVar = (com.bytedance.adsdk.ugeno.flexbox.xt) view.getLayoutParams();
        int alignItems = this.f23660r.getAlignItems();
        if (xtVar.m() != -1) {
            alignItems = xtVar.m();
        }
        int i10 = cwVar.ae;
        if (alignItems != 0) {
            if (alignItems == 1) {
                if (!z5) {
                    view.layout(((i6 + i10) - view.getMeasuredWidth()) - xtVar.az(), i7, ((i8 + i10) - view.getMeasuredWidth()) - xtVar.az(), i9);
                    return;
                } else {
                    view.layout((i6 - i10) + view.getMeasuredWidth() + xtVar.jy(), i7, (i8 - i10) + view.getMeasuredWidth() + xtVar.jy(), i9);
                    return;
                }
            }
            if (alignItems == 2) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                int measuredWidth = (((i10 - view.getMeasuredWidth()) + m.j(marginLayoutParams)) - m.xt(marginLayoutParams)) / 2;
                if (!z5) {
                    view.layout(i6 + measuredWidth, i7, i8 + measuredWidth, i9);
                    return;
                } else {
                    view.layout(i6 - measuredWidth, i7, i8 - measuredWidth, i9);
                    return;
                }
            }
            if (alignItems != 3 && alignItems != 4) {
                return;
            }
        }
        if (!z5) {
            view.layout(i6 + xtVar.jy(), i7, i8 + xtVar.jy(), i9);
        } else {
            view.layout(i6 - xtVar.az(), i7, i8 - xtVar.az(), i9);
        }
    }

    private void j(int i6, int i7, int i8, View view) {
        long[] jArr = this.xt;
        if (jArr != null) {
            jArr[i6] = xt(i7, i8);
        }
        long[] jArr2 = this.f23659m;
        if (jArr2 != null) {
            jArr2[i6] = xt(view.getMeasuredWidth(), view.getMeasuredHeight());
        }
    }
}
