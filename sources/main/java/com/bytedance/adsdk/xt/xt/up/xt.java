package com.bytedance.adsdk.xt.xt.up;

import com.bytedance.adsdk.xt.xt.r.cw;
import com.bytedance.adsdk.xt.xt.r.r;
import com.bytedance.adsdk.xt.xt.xt.j.g;
import com.bytedance.adsdk.xt.xt.xt.j.i;
import com.bytedance.adsdk.xt.xt.xt.j.jy;
import com.bytedance.adsdk.xt.xt.xt.j.m;
import com.bytedance.adsdk.xt.xt.xt.j.mi;
import com.bytedance.adsdk.xt.xt.xt.j.qv;
import com.bytedance.adsdk.xt.xt.xt.j.tl;
import com.bytedance.adsdk.xt.xt.xt.j.up;
import com.bytedance.adsdk.xt.xt.xt.j.vl;
import com.bytedance.adsdk.xt.xt.xt.j.w;
import com.bytedance.adsdk.xt.xt.xt.j.ws;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: D:\Downloads\app\classes3.dex */
public class xt {
    public static com.bytedance.adsdk.xt.xt.xt.j j(List<com.bytedance.adsdk.xt.xt.xt.j> list, String str, int i6) {
        cw(list, str, i6);
        Deque<com.bytedance.adsdk.xt.xt.xt.j> j6 = j(xt(list, str, i6));
        if (j6.size() == 1) {
            return j6.getFirst();
        }
        throw new IllegalStateException();
    }

    /* renamed from: com.bytedance.adsdk.xt.xt.up.xt$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: j, reason: collision with root package name */
        static final /* synthetic */ int[] f23966j;

        static {
            int[] iArr = new int[cw.values().length];
            f23966j = iArr;
            try {
                iArr[cw.MINUS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f23966j[cw.PLUS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f23966j[cw.DIVISION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f23966j[cw.MULTI.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f23966j[cw.MOD.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f23966j[cw.EQ.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f23966j[cw.NOT_EQ.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f23966j[cw.GT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f23966j[cw.LT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f23966j[cw.GT_EQ.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f23966j[cw.LT_EQ.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f23966j[cw.DOUBLE_AMP.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f23966j[cw.DOUBLE_BAR.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

    private static Deque<com.bytedance.adsdk.xt.xt.xt.j> xt(List<com.bytedance.adsdk.xt.xt.xt.j> list, String str, int i6) {
        LinkedList<com.bytedance.adsdk.xt.xt.xt.j> linkedList = new LinkedList(list);
        int i7 = 5;
        while (i7 > 0) {
            LinkedList linkedList2 = new LinkedList();
            for (com.bytedance.adsdk.xt.xt.xt.j jVar : linkedList) {
                if (!linkedList2.isEmpty() && cw.j(((com.bytedance.adsdk.xt.xt.xt.j) linkedList2.peekLast()).j()) && ((cw) ((com.bytedance.adsdk.xt.xt.xt.j) linkedList2.peekLast()).j()).xt() == i7) {
                    com.bytedance.adsdk.xt.xt.xt.j jVar2 = (com.bytedance.adsdk.xt.xt.xt.j) linkedList2.pollLast();
                    com.bytedance.adsdk.xt.xt.xt.j jVar3 = (com.bytedance.adsdk.xt.xt.xt.j) linkedList2.pollLast();
                    if (cw.j(jVar3.j()) || cw.j(jVar.j())) {
                        throw new IllegalArgumentException(str.substring(0, i6));
                    }
                    linkedList2.addLast(j(jVar3, jVar2, jVar));
                } else {
                    linkedList2.addLast(jVar);
                }
            }
            i7--;
            linkedList = linkedList2;
        }
        return linkedList;
    }

    private static void cw(List<com.bytedance.adsdk.xt.xt.xt.j> list, String str, int i6) {
        Iterator<com.bytedance.adsdk.xt.xt.xt.j> it = list.iterator();
        while (it.hasNext()) {
            if (r.j(it.next().j())) {
                throw new IllegalArgumentException(str.substring(0, i6));
            }
        }
    }

    private static Deque<com.bytedance.adsdk.xt.xt.xt.j> j(Deque<com.bytedance.adsdk.xt.xt.xt.j> deque) {
        LinkedList linkedList = new LinkedList();
        for (com.bytedance.adsdk.xt.xt.xt.j jVar : deque) {
            if (!linkedList.isEmpty() && ((com.bytedance.adsdk.xt.xt.xt.j) linkedList.peekLast()).j() == cw.COLON) {
                linkedList.pollLast();
                com.bytedance.adsdk.xt.xt.xt.j jVar2 = (com.bytedance.adsdk.xt.xt.xt.j) linkedList.pollLast();
                if (((com.bytedance.adsdk.xt.xt.xt.j) linkedList.pollLast()).j() == cw.QUESTION) {
                    com.bytedance.adsdk.xt.xt.xt.j jVar3 = (com.bytedance.adsdk.xt.xt.xt.j) linkedList.pollLast();
                    mi miVar = new mi();
                    miVar.j(jVar3);
                    miVar.xt(jVar2);
                    miVar.cw(jVar);
                    linkedList.addLast(miVar);
                } else {
                    throw new IllegalStateException();
                }
            } else {
                linkedList.addLast(jVar);
            }
        }
        return linkedList;
    }

    private static com.bytedance.adsdk.xt.xt.xt.j j(com.bytedance.adsdk.xt.xt.xt.j jVar, com.bytedance.adsdk.xt.xt.xt.j jVar2, com.bytedance.adsdk.xt.xt.xt.j jVar3) {
        i qvVar;
        switch (AnonymousClass1.f23966j[((cw) jVar2.j()).ordinal()]) {
            case 1:
                qvVar = new qv();
                break;
            case 2:
                qvVar = new w();
                break;
            case 3:
                qvVar = new com.bytedance.adsdk.xt.xt.xt.j.j();
                break;
            case 4:
                qvVar = new jy();
                break;
            case 5:
                qvVar = new vl();
                break;
            case 6:
                qvVar = new com.bytedance.adsdk.xt.xt.xt.j.r();
                break;
            case 7:
                qvVar = new ws();
                break;
            case 8:
                qvVar = new m();
                break;
            case 9:
                qvVar = new g();
                break;
            case 10:
                qvVar = new up();
                break;
            case 11:
                qvVar = new tl();
                break;
            case 12:
                qvVar = new com.bytedance.adsdk.xt.xt.xt.j.xt();
                break;
            case 13:
                qvVar = new com.bytedance.adsdk.xt.xt.xt.j.cw();
                break;
            default:
                throw new UnsupportedOperationException(jVar2.j().toString());
        }
        qvVar.j(jVar);
        qvVar.xt(jVar3);
        return qvVar;
    }

    public static boolean j(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Boolean) || ((Boolean) obj).booleanValue()) {
            return !(obj instanceof Number) || ((Number) obj).floatValue() >= 0.0f;
        }
        return false;
    }
}
