package com.kwad.sdk.core;

import android.util.Pair;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import com.kwad.sdk.service.ServiceProvider;
import io.netty.util.internal.StringUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class e {
    private static final b awK = new b(100);
    private static final a awL = new a(10, 0);
    private static List<c> awM = new ArrayList(50);
    private static final List<List<c>> awN = new ArrayList();
    private static final List<Map<String, Double>> awO = new ArrayList();
    private static c awP;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class a extends b {
        /* synthetic */ a(int i6, byte b6) {
            this(10);
        }

        private a(int i6) {
            super(i6);
        }

        @Override // com.kwad.sdk.core.e.b
        public final char Es() {
            return StringUtil.COMMA;
        }

        public final List<String> Et() {
            return new ArrayList(this.awR);
        }

        @Override // com.kwad.sdk.core.e.b
        public final boolean k(Object obj) {
            if (!(obj instanceof String)) {
                return false;
            }
            if (this.awR.size() >= this.awQ) {
                this.awR.poll();
            }
            return this.awR.offer((String) obj);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class b {
        public final int awQ;
        public final Queue<String> awR = new LinkedList();

        public char Es() {
            return '|';
        }

        public final void clear() {
            this.awR.clear();
        }

        public boolean k(Object obj) {
            if (!(obj instanceof c)) {
                return false;
            }
            if (this.awR.size() >= this.awQ) {
                this.awR.poll();
            }
            HashMap hashMap = new HashMap();
            c cVar = (c) obj;
            double Eu = cVar.Eu();
            double Ev = cVar.Ev();
            hashMap.put("x", Double.valueOf(Eu));
            hashMap.put("y", Double.valueOf(Ev));
            e.awO.add(hashMap);
            return this.awR.offer(Eu + "_" + Ev);
        }

        @NonNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = this.awR.iterator();
            while (it.hasNext()) {
                sb.append(it.next());
                sb.append(Es());
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
            return sb.toString();
        }

        public b(int i6) {
            this.awQ = i6;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class c {
        private int action;

        /* renamed from: x, reason: collision with root package name */
        private double f36345x;

        /* renamed from: y, reason: collision with root package name */
        private double f36346y;

        private int getAction() {
            return this.action;
        }

        public final double Eu() {
            return this.f36345x;
        }

        public final double Ev() {
            return this.f36346y;
        }

        public final boolean a(c cVar) {
            return this.f36345x == cVar.Eu() && this.f36346y == cVar.Ev() && this.action == cVar.getAction();
        }

        public c(MotionEvent motionEvent) {
            this.f36345x = motionEvent.getX();
            this.f36346y = motionEvent.getY();
            this.action = motionEvent.getAction();
        }
    }

    private static void a(MotionEvent motionEvent, boolean z5) {
        c cVar = new c(motionEvent);
        c cVar2 = awP;
        if (cVar2 == null || !cVar2.a(cVar)) {
            awM.add(cVar);
            awP = cVar;
            if (z5) {
                if (awM.size() > 3 && awM.size() < 100) {
                    awN.add(awM);
                }
                awM = new ArrayList(50);
                awP = null;
            }
        }
    }

    public static Pair<List<String>, Double> Eo() {
        Iterator<List<c>> it = awN.iterator();
        double d6 = 0.0d;
        while (it.hasNext()) {
            Iterator<c> it2 = it.next().iterator();
            while (it2.hasNext()) {
                awK.k(it2.next());
            }
            List<Map<String, Double>> list = awO;
            double y5 = y(list);
            if (y5 > d6) {
                d6 = y5;
            }
            list.clear();
            a aVar = awL;
            b bVar = awK;
            aVar.k(bVar.toString());
            bVar.clear();
        }
        return new Pair<>(Ep(), Double.valueOf(d6));
    }

    private static List<String> Ep() {
        List<String> Et = awL.Et();
        Er();
        Eq();
        return Et;
    }

    private static void Eq() {
        awO.clear();
        awN.clear();
        awM.clear();
    }

    private static void Er() {
        awL.clear();
        awK.clear();
    }

    private static double y(List<Map<String, Double>> list) {
        double d6 = 0.0d;
        try {
            ArrayList arrayList = new ArrayList(list.size());
            ArrayList arrayList2 = new ArrayList(list.size());
            ArrayList arrayList3 = new ArrayList(list.size());
            ArrayList arrayList4 = new ArrayList(list.size());
            a(list, arrayList, arrayList2, arrayList3, arrayList4);
            int i6 = 1;
            for (int i7 = 1; i6 < list.size() - i7; i7 = 1) {
                int i8 = i6;
                double abs = Math.abs((((Double) arrayList.get(i6)).doubleValue() * ((Double) arrayList4.get(i6)).doubleValue()) - (((Double) arrayList2.get(i6)).doubleValue() * ((Double) arrayList3.get(i6)).doubleValue())) / Math.pow(Math.pow(((Double) arrayList.get(i6)).doubleValue(), 2.0d) + Math.pow(((Double) arrayList2.get(i6)).doubleValue(), 2.0d), 1.5d);
                if (abs > d6) {
                    d6 = abs;
                }
                i6 = i8 + 1;
            }
            return d6;
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
            return d6;
        }
    }

    public static void e(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action != 3 && action != 4) {
                        return;
                    }
                }
            }
            a(motionEvent, true);
            return;
        }
        a(motionEvent, false);
    }

    private static void a(List<Map<String, Double>> list, List<Double> list2, List<Double> list3, List<Double> list4, List<Double> list5) {
        Double valueOf = Double.valueOf(0.0d);
        int size = list.size();
        for (int i6 = 0; i6 < size; i6++) {
            list2.add(valueOf);
            list3.add(valueOf);
            list4.add(valueOf);
            list5.add(valueOf);
        }
        int i7 = 1;
        while (i7 < size - 1) {
            int i8 = i7 + 1;
            double doubleValue = list.get(i8).get("x").doubleValue();
            int i9 = i7 - 1;
            double doubleValue2 = list.get(i9).get("x").doubleValue();
            double doubleValue3 = list.get(i8).get("y").doubleValue();
            double doubleValue4 = list.get(i9).get("y").doubleValue();
            double doubleValue5 = list.get(i7).get("x").doubleValue();
            double doubleValue6 = list.get(i7).get("y").doubleValue();
            list2.set(i7, Double.valueOf((doubleValue - doubleValue2) / 2.0d));
            list3.set(i7, Double.valueOf((doubleValue3 - doubleValue4) / 2.0d));
            list4.set(i7, Double.valueOf((doubleValue - (doubleValue5 * 2.0d)) + doubleValue2));
            list5.set(i7, Double.valueOf((doubleValue3 - (doubleValue6 * 2.0d)) + doubleValue4));
            i7 = i8;
        }
    }
}
