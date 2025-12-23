package com.beizi.ad.internal.animation;

import java.util.ArrayList;
import java.util.Collections;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class a {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.beizi.ad.internal.animation.a$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f11645a;

        static {
            int[] iArr = new int[h.values().length];
            f11645a = iArr;
            try {
                iArr[h.FADE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f11645a[h.PUSH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f11645a[h.MOVEIN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f11645a[h.REVEAL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static f a(h hVar, long j6, g gVar) {
        h hVar2 = h.RANDOM;
        if (hVar == hVar2) {
            ArrayList arrayList = new ArrayList();
            Collections.addAll(arrayList, h.values());
            arrayList.remove(h.NONE);
            arrayList.remove(hVar2);
            Collections.shuffle(arrayList);
            hVar = (h) arrayList.get(0);
        }
        int i6 = AnonymousClass1.f11645a[hVar.ordinal()];
        if (i6 == 1) {
            return new b(j6);
        }
        if (i6 == 2) {
            return new d(j6, gVar);
        }
        if (i6 == 3) {
            return new c(j6, gVar);
        }
        if (i6 != 4) {
            return null;
        }
        return new e(j6, gVar);
    }
}
