package com.huawei.hms.scankit.p;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class i3 {

    /* renamed from: h, reason: collision with root package name */
    private static boolean f34398h;

    /* renamed from: i, reason: collision with root package name */
    private static boolean f34399i;

    /* renamed from: a, reason: collision with root package name */
    private final s f34401a;

    /* renamed from: e, reason: collision with root package name */
    private final v6 f34405e;

    /* renamed from: f, reason: collision with root package name */
    private static final int[] f34396f = {1, 3, 1, 1};

    /* renamed from: g, reason: collision with root package name */
    private static final int[] f34397g = {1, 1, 3, 1};

    /* renamed from: j, reason: collision with root package name */
    private static final d f34400j = new d(null);

    /* renamed from: b, reason: collision with root package name */
    private final List<e3> f34402b = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    private final int[] f34404d = new int[5];

    /* renamed from: c, reason: collision with root package name */
    private final List<e3> f34403c = new ArrayList();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static /* synthetic */ class a {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class b implements Comparator<e3>, Serializable {

        /* renamed from: a, reason: collision with root package name */
        private final float f34406a;

        /* synthetic */ b(float f6, a aVar) {
            this(f6);
        }

        private b(float f6) {
            this.f34406a = f6;
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(e3 e3Var, e3 e3Var2) {
            int compare = Integer.compare(e3Var2.a(), e3Var.a());
            if (compare == 0) {
                return Float.compare(Math.abs(e3Var.e() - this.f34406a), Math.abs(e3Var2.e() - this.f34406a));
            }
            return compare;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class c implements Comparator<e3>, Serializable {
        private c() {
        }

        /* synthetic */ c(a aVar) {
            this();
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(e3 e3Var, e3 e3Var2) {
            return Integer.compare(e3Var2.a(), e3Var.a());
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class d implements Comparator<e3>, Serializable {
        private d() {
        }

        /* synthetic */ d(a aVar) {
            this();
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(e3 e3Var, e3 e3Var2) {
            return Float.compare(e3Var.e(), e3Var2.e());
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class e implements Comparator<e3>, Serializable {

        /* renamed from: a, reason: collision with root package name */
        private final float f34407a;

        /* synthetic */ e(float f6, a aVar) {
            this(f6);
        }

        private e(float f6) {
            this.f34407a = f6;
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(e3 e3Var, e3 e3Var2) {
            return Float.compare(Math.abs(e3Var2.e() - this.f34407a), Math.abs(e3Var.e() - this.f34407a));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class f implements Comparator<e3>, Serializable {
        private f() {
        }

        /* synthetic */ f(a aVar) {
            this();
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(e3 e3Var, e3 e3Var2) {
            return Float.compare(e3Var.b(), e3Var2.b());
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class g implements Comparator<e3>, Serializable {
        private g() {
        }

        /* synthetic */ g(a aVar) {
            this();
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(e3 e3Var, e3 e3Var2) {
            return Float.compare(e3Var.c(), e3Var2.c());
        }
    }

    protected static float a(int[] iArr, int[] iArr2, float f6) {
        int length = iArr.length;
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < length; i8++) {
            i6 += iArr[i8];
            i7 += iArr2[i8];
        }
        if (i6 < i7) {
            return Float.POSITIVE_INFINITY;
        }
        float f7 = i6;
        float f8 = f7 / i7;
        float f9 = f6 * f8;
        float f10 = 0.0f;
        for (int i9 = 0; i9 < length; i9++) {
            float f11 = iArr2[i9] * f8;
            float f12 = iArr[i9];
            float f13 = f12 > f11 ? f12 - f11 : f11 - f12;
            if (f13 > f9) {
                return Float.POSITIVE_INFINITY;
            }
            f10 += f13;
        }
        return f10 / f7;
    }

    private e3[] c() throws com.huawei.hms.scankit.p.a {
        if (this.f34402b.size() > 2) {
            try {
                return f();
            } catch (com.huawei.hms.scankit.p.a unused) {
                if (this.f34403c.size() <= 0) {
                    throw com.huawei.hms.scankit.p.a.a();
                }
                Collections.sort(this.f34403c, new c(null));
                int min = Math.min(3, this.f34403c.size());
                for (int i6 = 0; i6 < min; i6++) {
                    e3 e3Var = this.f34403c.get(i6);
                    float e6 = e3Var.e();
                    float c6 = e3Var.c();
                    float b6 = e3Var.b();
                    int i7 = 0;
                    while (true) {
                        if (i7 >= this.f34402b.size()) {
                            this.f34402b.add(e3Var);
                            break;
                        }
                        e3 e3Var2 = this.f34402b.get(i7);
                        if (e3Var2.b(e6, c6, b6)) {
                            this.f34402b.set(i7, e3Var2.a(c6, b6, e6, false));
                            break;
                        }
                        i7++;
                    }
                }
                return f();
            }
        }
        if (this.f34402b.size() == 2) {
            int i8 = this.f34402b.get(0).e() > this.f34402b.get(1).e() ? 0 : 1;
            if (Math.max(this.f34402b.get(0).e(), this.f34402b.get(1).e()) / Math.min(this.f34402b.get(0).e(), this.f34402b.get(1).e()) > 1.5d) {
                e3 e3Var3 = this.f34402b.get(i8);
                this.f34402b.clear();
                this.f34402b.add(e3Var3);
            }
        }
        if (this.f34402b.size() <= 1 && this.f34403c.size() >= 1) {
            for (int i9 = 0; i9 < this.f34402b.size(); i9++) {
                e3 e3Var4 = this.f34402b.get(i9);
                float e7 = e3Var4.e();
                float c7 = e3Var4.c();
                float b7 = e3Var4.b();
                int i10 = 0;
                while (true) {
                    if (i10 >= this.f34403c.size()) {
                        this.f34403c.add(e3Var4);
                        break;
                    }
                    e3 e3Var5 = this.f34403c.get(i10);
                    if (e3Var5.b(e7, c7, b7)) {
                        this.f34403c.set(i10, e3Var4.a(e3Var5.c(), e3Var5.b(), e3Var5.e(), false));
                        break;
                    }
                    i10++;
                }
            }
            this.f34402b.clear();
            this.f34402b.addAll(this.f34403c);
            this.f34403c.clear();
        }
        if (this.f34402b.size() == 2) {
            try {
                return g();
            } catch (com.huawei.hms.scankit.p.a unused2) {
                return a();
            }
        }
        if (this.f34402b.size() > 1) {
            return f();
        }
        throw com.huawei.hms.scankit.p.a.a();
    }

    private int[] d() {
        a(this.f34404d);
        return this.f34404d;
    }

    private static void e() {
        f34398h = false;
        f34399i = false;
    }

    final k3 b() throws com.huawei.hms.scankit.p.a {
        int c6 = this.f34401a.c();
        int e6 = this.f34401a.e();
        int i6 = (c6 * 3) / MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_INIT_RTT;
        if (i6 < 3) {
            i6 = 3;
        }
        if (r3.f34743n) {
            i6 = 2;
        }
        a(i6, c6, e6);
        e3[] c7 = c();
        if (c7 == null) {
            throw com.huawei.hms.scankit.p.a.a();
        }
        u6.a(c7);
        if ((this.f34401a.c() * this.f34401a.e()) / (Math.sqrt(a(c7[0], c7[1])) * Math.sqrt(a(c7[1], c7[2]))) <= 900.0d) {
            return new k3(c7);
        }
        throw com.huawei.hms.scankit.p.a.a();
    }

    private e3[] f() throws com.huawei.hms.scankit.p.a {
        int size = this.f34402b.size();
        if (size < 3) {
            throw com.huawei.hms.scankit.p.a.a();
        }
        e3[] e3VarArr = new e3[3];
        if (size == 3) {
            e3VarArr[0] = this.f34402b.get(0);
            e3VarArr[1] = this.f34402b.get(1);
            e3 e3Var = this.f34402b.get(2);
            e3VarArr[2] = e3Var;
            if (!b(e3VarArr[0], e3VarArr[1], e3Var, new float[3])) {
                throw com.huawei.hms.scankit.p.a.a();
            }
        } else {
            a aVar = null;
            Collections.sort(this.f34402b, new c(aVar));
            if (this.f34402b.get(2).a() - this.f34402b.get(3).a() > 1 && this.f34402b.get(2).a() > 1) {
                e3VarArr[0] = this.f34402b.get(0);
                e3VarArr[1] = this.f34402b.get(1);
                e3VarArr[2] = this.f34402b.get(2);
                return e3VarArr;
            }
            float f6 = 0.0f;
            if (this.f34402b.get(3).a() > 1) {
                float f7 = 0.0f;
                for (int i6 = 0; i6 < 4; i6++) {
                    f7 += this.f34402b.get(i6).e();
                }
                float f8 = f7 / 4.0f;
                int i7 = 0;
                for (int i8 = 0; i8 < 4; i8++) {
                    float abs = Math.abs(this.f34402b.get(i8).e() - f8);
                    if (abs > f6) {
                        i7 = i8;
                        f6 = abs;
                    }
                }
                if (i7 == 0) {
                    e3VarArr[0] = this.f34402b.get(1);
                    e3VarArr[1] = this.f34402b.get(2);
                    e3VarArr[2] = this.f34402b.get(3);
                } else if (i7 == 1) {
                    e3VarArr[0] = this.f34402b.get(0);
                    e3VarArr[1] = this.f34402b.get(2);
                    e3VarArr[2] = this.f34402b.get(3);
                } else if (i7 != 2) {
                    e3VarArr[0] = this.f34402b.get(0);
                    e3VarArr[1] = this.f34402b.get(1);
                    e3VarArr[2] = this.f34402b.get(2);
                } else {
                    e3VarArr[0] = this.f34402b.get(0);
                    e3VarArr[1] = this.f34402b.get(1);
                    e3VarArr[2] = this.f34402b.get(3);
                }
                if (!b(e3VarArr[0], e3VarArr[1], e3VarArr[2], new float[3])) {
                    throw com.huawei.hms.scankit.p.a.a();
                }
            } else {
                if (this.f34402b.get(1).a() > 1 && this.f34402b.get(2).a() == 1) {
                    ArrayList arrayList = new ArrayList();
                    float e6 = (this.f34402b.get(0).e() + this.f34402b.get(1).e()) / 2.0f;
                    for (int i9 = 2; i9 < size; i9++) {
                        if (Math.abs(this.f34402b.get(i9).e() - e6) < e6 * 0.5d) {
                            arrayList.add(this.f34402b.get(i9));
                        }
                    }
                    int i10 = 0;
                    for (int i11 = 0; i11 < arrayList.size(); i11++) {
                        float[] fArr = new float[3];
                        if (b(this.f34402b.get(0), this.f34402b.get(1), (e3) arrayList.get(i11), fArr)) {
                            float f9 = fArr[0];
                            if (f9 >= f6) {
                                i10 = i11;
                                f6 = f9;
                            }
                        }
                    }
                    e3VarArr[0] = this.f34402b.get(0);
                    e3VarArr[1] = this.f34402b.get(1);
                    if (i10 >= arrayList.size()) {
                        throw com.huawei.hms.scankit.p.a.a();
                    }
                    e3VarArr[2] = (e3) arrayList.get(i10);
                    return e3VarArr;
                }
                if (size > 3) {
                    float f10 = 0.0f;
                    float f11 = 0.0f;
                    for (int i12 = 0; i12 < size; i12++) {
                        float e7 = this.f34402b.get(i12).e();
                        f10 += e7;
                        f11 += e7 * e7;
                    }
                    float f12 = f10 / size;
                    float sqrt = (float) Math.sqrt((f11 / r1) - (f12 * f12));
                    Collections.sort(this.f34402b, new e(f12, aVar));
                    float max = Math.max(0.5f * f12, sqrt);
                    int i13 = 0;
                    while (i13 < this.f34402b.size() && this.f34402b.size() > 3) {
                        if (Math.abs(this.f34402b.get(i13).e() - f12) > max) {
                            this.f34402b.remove(i13);
                            i13--;
                        }
                        i13++;
                    }
                }
                if (this.f34402b.size() > 15) {
                    Collections.sort(this.f34402b, new c(aVar));
                    List<e3> list = this.f34402b;
                    list.subList(15, list.size()).clear();
                } else if (this.f34402b.size() > 12) {
                    Collections.sort(this.f34402b, new c(aVar));
                    List<e3> list2 = this.f34402b;
                    list2.subList(12, list2.size()).clear();
                }
                if (this.f34402b.size() >= 6) {
                    Collections.sort(this.f34402b, new f(aVar));
                    List<e3> list3 = this.f34402b;
                    list3.subList(4, list3.size() - 2).clear();
                    Collections.sort(this.f34402b, new g(aVar));
                    this.f34402b.subList(1, 3).clear();
                    Collections.sort(this.f34402b, new g(aVar));
                    List<e3> list4 = this.f34402b;
                    list4.subList(list4.size() - 1, this.f34402b.size()).clear();
                } else if (this.f34402b.size() > 3) {
                    for (int i14 = 0; i14 < this.f34402b.size(); i14++) {
                        f6 += this.f34402b.get(i14).e();
                    }
                    Collections.sort(this.f34402b, new b(f6 / this.f34402b.size(), aVar));
                    List<e3> list5 = this.f34402b;
                    list5.subList(3, list5.size()).clear();
                }
                e3VarArr[0] = this.f34402b.get(0);
                e3VarArr[1] = this.f34402b.get(1);
                e3 e3Var2 = this.f34402b.get(2);
                e3VarArr[2] = e3Var2;
                if (!b(e3VarArr[0], e3VarArr[1], e3Var2, new float[3])) {
                    throw com.huawei.hms.scankit.p.a.a();
                }
            }
        }
        return e3VarArr;
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x01b6, code lost:
    
        if (r14 == false) goto L56;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.huawei.hms.scankit.p.e3[] g() throws com.huawei.hms.scankit.p.a {
        /*
            Method dump skipped, instructions count: 526
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.i3.g():com.huawei.hms.scankit.p.e3[]");
    }

    public i3(s sVar, v6 v6Var) {
        this.f34401a = sVar;
        this.f34405e = v6Var;
    }

    protected final void d(int[] iArr) {
        iArr[0] = iArr[2];
        iArr[1] = iArr[3];
        iArr[2] = iArr[4];
        iArr[3] = 1;
        iArr[4] = 0;
    }

    /*  JADX ERROR: JadxOverflowException in pass: LoopRegionVisitor
        jadx.core.utils.exceptions.JadxOverflowException: LoopRegionVisitor.assignOnlyInLoop endless recursion
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private void a(int r11, int r12, int r13) {
        /*
            r10 = this;
            r0 = 5
            int[] r1 = new int[r0]
            int r2 = r11 + (-1)
        L5:
            if (r2 >= r12) goto L5e
            r10.a(r1)
            int[] r3 = new int[r0]
            r4 = 0
            r3[r4] = r4
            r5 = 1
            r3[r5] = r2
            r6 = 2
            r3[r6] = r4
            r7 = 3
            r3[r7] = r13
            r7 = 4
            r3[r7] = r11
            r8 = 0
        L1c:
            if (r8 >= r13) goto L39
            r3[r6] = r8
            com.huawei.hms.scankit.p.s r9 = r10.f34401a
            boolean r9 = r9.b(r8, r2)
            if (r9 == 0) goto L2c
            r10.a(r1, r3)
            goto L33
        L2c:
            boolean r9 = r10.b(r1, r3)
            if (r9 == 0) goto L33
            goto L37
        L33:
            r8 = r3[r6]
            r11 = r3[r7]
        L37:
            int r8 = r8 + r5
            goto L1c
        L39:
            boolean r5 = b(r1)
            if (r5 == 0) goto L4e
            r3 = r3[r4]
            r5 = r13
        L42:
            if (r3 <= r6) goto L4a
            r7 = r1[r3]
            int r5 = r5 - r7
            int r3 = r3 + (-1)
            goto L42
        L4a:
            r10.b(r1, r2, r5)
            goto L4f
        L4e:
            r5 = r13
        L4f:
            boolean r3 = a(r1, r4)
            if (r3 == 0) goto L5c
            boolean r3 = r10.a(r1, r2, r5, r4)
            if (r3 == 0) goto L5c
            r11 = 2
        L5c:
            int r2 = r2 + r11
            goto L5
        L5e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.i3.a(int, int, int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0036, code lost:
    
        if (r8[2] <= r7) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0039, code lost:
    
        if (r5 < 0) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x003f, code lost:
    
        if (r0.b(r6, r5) != false) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0041, code lost:
    
        r1 = r8[1];
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0043, code lost:
    
        if (r1 > r7) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0045, code lost:
    
        r8[1] = r1 + 1;
        r5 = r5 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x004c, code lost:
    
        if (r5 < 0) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0050, code lost:
    
        if (r8[1] <= r7) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0054, code lost:
    
        if (r5 < 0) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x005a, code lost:
    
        if (r0.b(r6, r5) == false) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x005c, code lost:
    
        r3 = r8[0];
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x005e, code lost:
    
        if (r3 > r7) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0060, code lost:
    
        r8[0] = r3 + 1;
        r5 = r5 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0069, code lost:
    
        if (r8[0] <= r7) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x006b, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x006c, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean d(int r5, int r6, int r7, int[] r8) {
        /*
            r4 = this;
            com.huawei.hms.scankit.p.s r0 = r4.f34401a
        L2:
            r1 = 3
            if (r5 < 0) goto L16
            boolean r2 = r0.b(r6, r5)
            if (r2 != 0) goto L16
            r2 = r8[r1]
            if (r2 > r7) goto L16
            int r2 = r2 + 1
            r8[r1] = r2
            int r5 = r5 + (-1)
            goto L2
        L16:
            r2 = 1
            if (r5 < 0) goto L6d
            r1 = r8[r1]
            if (r1 <= r7) goto L1e
            goto L6d
        L1e:
            r1 = 2
            if (r5 < 0) goto L32
            boolean r3 = r0.b(r6, r5)
            if (r3 == 0) goto L32
            r3 = r8[r1]
            if (r3 > r7) goto L32
            int r3 = r3 + 1
            r8[r1] = r3
            int r5 = r5 + (-1)
            goto L1e
        L32:
            if (r5 < 0) goto L6d
            r1 = r8[r1]
            if (r1 <= r7) goto L39
            goto L6d
        L39:
            if (r5 < 0) goto L4c
            boolean r1 = r0.b(r6, r5)
            if (r1 != 0) goto L4c
            r1 = r8[r2]
            if (r1 > r7) goto L4c
            int r1 = r1 + 1
            r8[r2] = r1
            int r5 = r5 + (-1)
            goto L39
        L4c:
            if (r5 < 0) goto L6d
            r1 = r8[r2]
            if (r1 <= r7) goto L53
            goto L6d
        L53:
            r1 = 0
            if (r5 < 0) goto L67
            boolean r3 = r0.b(r6, r5)
            if (r3 == 0) goto L67
            r3 = r8[r1]
            if (r3 > r7) goto L67
            int r3 = r3 + 1
            r8[r1] = r3
            int r5 = r5 + (-1)
            goto L53
        L67:
            r5 = r8[r1]
            if (r5 <= r7) goto L6c
            return r2
        L6c:
            return r1
        L6d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.i3.d(int, int, int, int[]):boolean");
    }

    private boolean b(int[] iArr, int[] iArr2) {
        int i6 = iArr2[0];
        if ((i6 & 1) != 0) {
            iArr[i6] = iArr[i6] + 1;
        } else if (i6 == 4) {
            if (a(iArr, false)) {
                boolean a6 = a(iArr, iArr2[1], iArr2[2], false);
                if (a6) {
                    iArr2[4] = 2;
                }
                if (!a6) {
                    a6 = a(iArr, iArr2[1], iArr2[2]);
                }
                if (a6) {
                    iArr2[0] = 0;
                    a(iArr);
                    return true;
                }
            }
            if (b(iArr)) {
                int i7 = iArr2[2];
                for (int i8 = iArr2[0]; i8 > 2; i8--) {
                    i7 -= iArr[i8];
                }
                if (b(iArr, iArr2[1], i7)) {
                    d(iArr);
                    iArr2[0] = 3;
                    return true;
                }
            }
            if (r3.f34737h && a(iArr, true) && a(iArr, iArr2[1], iArr2[2], true)) {
                iArr2[0] = 0;
                a(iArr);
                return true;
            }
            d(iArr);
            iArr2[0] = 3;
        } else {
            int i9 = i6 + 1;
            iArr2[0] = i9;
            iArr[i9] = iArr[i9] + 1;
        }
        return false;
    }

    private void a(int[] iArr, int[] iArr2) {
        int i6 = iArr2[0];
        if ((i6 & 1) == 1) {
            iArr2[0] = i6 + 1;
        }
        int i7 = iArr2[0];
        if (i7 >= 0 && i7 < iArr.length) {
            iArr[i7] = iArr[i7] + 1;
        }
        if (iArr2[2] == iArr2[3] - 1 && iArr2[0] == 4) {
            if (a(iArr, false)) {
                boolean a6 = a(iArr, iArr2[1], iArr2[2], false);
                if (a6) {
                    iArr2[4] = 2;
                }
                if (!a6) {
                    a6 = a(iArr, iArr2[1], iArr2[2]);
                }
                if (a6) {
                    iArr2[0] = 0;
                    a(iArr);
                    while (iArr2[2] < this.f34401a.e() && !this.f34401a.b(iArr2[2], iArr2[1])) {
                        iArr2[2] = iArr2[2] + 1;
                    }
                }
            }
            if (r3.f34737h && a(iArr, true) && a(iArr, iArr2[1], iArr2[2], true)) {
                iArr2[0] = 0;
                a(iArr);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0041, code lost:
    
        if (r2[3] < r12) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0045, code lost:
    
        if (r10 >= r1) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x004b, code lost:
    
        if (r0.b(r11, r10) == false) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x004d, code lost:
    
        r8 = r2[4];
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x004f, code lost:
    
        if (r8 >= r12) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0051, code lost:
    
        r2[4] = r8 + 1;
        r10 = r10 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x005c, code lost:
    
        if (a(r2, r14) != false) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x005e, code lost:
    
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x005f, code lost:
    
        r11 = (((r2[0] + r2[1]) + r2[2]) + r2[3]) + r2[4];
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x006e, code lost:
    
        if (r14 == false) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0079, code lost:
    
        if ((java.lang.Math.abs(r11 - r13) * 5) < (r13 * 3)) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x007d, code lost:
    
        if (com.huawei.hms.scankit.p.i3.f34399i != false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0081, code lost:
    
        if (com.huawei.hms.scankit.p.i3.f34398h != false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0083, code lost:
    
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0091, code lost:
    
        return a(r2, r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0086, code lost:
    
        if (r11 >= (r13 * 3)) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x008a, code lost:
    
        if ((r11 * 3) > r13) goto L48;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private float b(int r10, int r11, int r12, int r13, boolean r14) {
        /*
            r9 = this;
            com.huawei.hms.scankit.p.s r0 = r9.f34401a
            int r1 = r0.c()
            int[] r2 = r9.d()
            boolean r3 = r9.b(r10, r11, r12, r2)
            r4 = 2143289344(0x7fc00000, float:NaN)
            if (r3 == 0) goto L13
            return r4
        L13:
            r3 = 1
            int r10 = r10 + r3
        L15:
            r5 = 2
            if (r10 >= r1) goto L26
            boolean r6 = r0.b(r11, r10)
            if (r6 == 0) goto L26
            r6 = r2[r5]
            int r6 = r6 + r3
            r2[r5] = r6
            int r10 = r10 + 1
            goto L15
        L26:
            if (r10 != r1) goto L29
            return r4
        L29:
            r6 = 3
            if (r10 >= r1) goto L3d
            boolean r7 = r0.b(r11, r10)
            if (r7 != 0) goto L3d
            r7 = r2[r6]
            if (r7 >= r12) goto L3d
            int r7 = r7 + 1
            r2[r6] = r7
            int r10 = r10 + 1
            goto L29
        L3d:
            if (r10 == r1) goto L92
            r7 = r2[r6]
            if (r7 < r12) goto L44
            goto L92
        L44:
            r7 = 4
            if (r10 >= r1) goto L58
            boolean r8 = r0.b(r11, r10)
            if (r8 == 0) goto L58
            r8 = r2[r7]
            if (r8 >= r12) goto L58
            int r8 = r8 + 1
            r2[r7] = r8
            int r10 = r10 + 1
            goto L44
        L58:
            boolean r11 = a(r2, r14)
            if (r11 != 0) goto L5f
            return r4
        L5f:
            r11 = 0
            r11 = r2[r11]
            r12 = r2[r3]
            int r11 = r11 + r12
            r12 = r2[r5]
            int r11 = r11 + r12
            r12 = r2[r6]
            int r11 = r11 + r12
            r12 = r2[r7]
            int r11 = r11 + r12
            if (r14 == 0) goto L84
            int r11 = r11 - r13
            int r11 = java.lang.Math.abs(r11)
            int r11 = r11 * 5
            int r13 = r13 * 3
            if (r11 < r13) goto L8d
            boolean r11 = com.huawei.hms.scankit.p.i3.f34399i
            if (r11 != 0) goto L8d
            boolean r11 = com.huawei.hms.scankit.p.i3.f34398h
            if (r11 != 0) goto L8d
            return r4
        L84:
            int r12 = r13 * 3
            if (r11 >= r12) goto L92
            int r11 = r11 * 3
            if (r11 > r13) goto L8d
            goto L92
        L8d:
            float r10 = a(r2, r10)
            return r10
        L92:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.i3.b(int, int, int, int, boolean):float");
    }

    private static float a(int[] iArr, int i6) {
        return ((i6 - iArr[4]) - iArr[3]) - (iArr[2] / 2.0f);
    }

    protected static boolean a(int[] iArr, boolean z5) {
        float f6;
        float f7;
        e();
        int i6 = 0;
        for (int i7 = 0; i7 < 5; i7++) {
            int i8 = iArr[i7];
            if (i8 == 0) {
                return false;
            }
            i6 += i8;
        }
        if (i6 < 7) {
            return false;
        }
        if (z5 && r3.f34737h) {
            f6 = 0.75f;
            f7 = 1.0f;
        } else {
            f6 = 0.5f;
            f7 = 3.0f;
        }
        float f8 = i6 / 7.0f;
        float f9 = f6 * f8;
        if (Math.abs(f8 - iArr[0]) < f9 && Math.abs(f8 - iArr[1]) < f9 && Math.abs((3.0f * f8) - iArr[2]) < f7 * f9 && Math.abs(f8 - iArr[3]) < f9 && Math.abs(f8 - iArr[4]) < f9) {
            return true;
        }
        if (!z5) {
            return false;
        }
        int[] iArr2 = new int[iArr.length - 1];
        int i9 = 0;
        while (i9 < iArr.length - 1) {
            int i10 = i9 + 1;
            iArr2[i9] = iArr[i10];
            i9 = i10;
        }
        int[] iArr3 = new int[iArr.length - 1];
        for (int i11 = 0; i11 < iArr.length - 1; i11++) {
            iArr3[i11] = iArr[i11];
        }
        float a6 = a(iArr2, f34396f, 0.5f);
        float a7 = a(iArr3, f34397g, 0.5f);
        boolean z6 = a6 < 0.3f;
        f34398h = z6;
        boolean z7 = a7 < 0.3f;
        f34399i = z7;
        return z6 || z7;
    }

    protected static boolean c(int[] iArr) {
        int i6 = 0;
        for (int i7 = 0; i7 < 5; i7++) {
            int i8 = iArr[i7];
            if (i8 == 0) {
                return false;
            }
            i6 += i8;
        }
        if (i6 < 7) {
            return false;
        }
        float f6 = i6 / 7.0f;
        float f7 = 0.75f * f6;
        return Math.abs(f6 - ((float) iArr[0])) < f7 && Math.abs(f6 - ((float) iArr[1])) < f7 && Math.abs((f6 * 3.0f) - ((float) iArr[2])) < 3.0f * f7 && Math.abs(f6 - ((float) iArr[3])) < f7 && Math.abs(f6 - ((float) iArr[4])) < f7;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001a, code lost:
    
        if (r8[1] <= r7) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x001e, code lost:
    
        if (r5 < 0) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0024, code lost:
    
        if (r0.b(r6, r5) == false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0026, code lost:
    
        r3 = r8[0];
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0028, code lost:
    
        if (r3 > r7) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x002a, code lost:
    
        r8[0] = r3 + 1;
        r5 = r5 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0033, code lost:
    
        if (r8[0] <= r7) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0035, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0036, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean c(int r5, int r6, int r7, int[] r8) {
        /*
            r4 = this;
            com.huawei.hms.scankit.p.s r0 = r4.f34401a
        L2:
            r1 = 1
            if (r5 < 0) goto L16
            boolean r2 = r0.b(r6, r5)
            if (r2 != 0) goto L16
            r2 = r8[r1]
            if (r2 > r7) goto L16
            int r2 = r2 + 1
            r8[r1] = r2
            int r5 = r5 + (-1)
            goto L2
        L16:
            if (r5 < 0) goto L37
            r2 = r8[r1]
            if (r2 <= r7) goto L1d
            goto L37
        L1d:
            r2 = 0
            if (r5 < 0) goto L31
            boolean r3 = r0.b(r6, r5)
            if (r3 == 0) goto L31
            r3 = r8[r2]
            if (r3 > r7) goto L31
            int r3 = r3 + 1
            r8[r2] = r3
            int r5 = r5 + (-1)
            goto L1d
        L31:
            r5 = r8[r2]
            if (r5 <= r7) goto L36
            return r1
        L36:
            return r2
        L37:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.i3.c(int, int, int, int[]):boolean");
    }

    private boolean b(int i6, int i7, int i8, int[] iArr) {
        boolean z5;
        int i9;
        s sVar = this.f34401a;
        while (true) {
            z5 = true;
            if (i6 < 0 || !sVar.b(i7, i6)) {
                break;
            }
            iArr[2] = iArr[2] + 1;
            i6--;
        }
        if (i6 < 0) {
            return true;
        }
        while (i6 >= 0 && !sVar.b(i7, i6)) {
            int i10 = iArr[1];
            if (i10 > i8) {
                break;
            }
            iArr[1] = i10 + 1;
            i6--;
        }
        if (i6 >= 0 && iArr[1] <= i8) {
            while (true) {
                z5 = false;
                if (i6 < 0 || !sVar.b(i7, i6) || (i9 = iArr[0]) > i8) {
                    break;
                }
                iArr[0] = i9 + 1;
                i6--;
            }
        }
        return z5;
    }

    protected final void a(int[] iArr) {
        for (int i6 = 0; i6 < iArr.length; i6++) {
            iArr[i6] = 0;
        }
    }

    private boolean a(int i6, int i7) {
        int i8;
        int i9;
        int i10;
        int[] d6 = d();
        int i11 = 0;
        while (i6 >= i11 && i7 >= i11 && this.f34401a.b(i7 - i11, i6 - i11)) {
            d6[2] = d6[2] + 1;
            i11++;
        }
        if (d6[2] == 0) {
            return false;
        }
        while (i6 >= i11 && i7 >= i11 && !this.f34401a.b(i7 - i11, i6 - i11)) {
            d6[1] = d6[1] + 1;
            i11++;
        }
        if (d6[1] == 0) {
            return false;
        }
        while (i6 >= i11 && i7 >= i11 && this.f34401a.b(i7 - i11, i6 - i11)) {
            d6[0] = d6[0] + 1;
            i11++;
        }
        if (d6[0] == 0) {
            return false;
        }
        int c6 = this.f34401a.c();
        int e6 = this.f34401a.e();
        int i12 = 1;
        while (true) {
            int i13 = i6 + i12;
            if (i13 >= c6 || (i10 = i7 + i12) >= e6 || !this.f34401a.b(i10, i13)) {
                break;
            }
            d6[2] = d6[2] + 1;
            i12++;
        }
        while (true) {
            int i14 = i6 + i12;
            if (i14 >= c6 || (i9 = i7 + i12) >= e6 || this.f34401a.b(i9, i14)) {
                break;
            }
            d6[3] = d6[3] + 1;
            i12++;
        }
        if (d6[3] == 0) {
            return false;
        }
        while (true) {
            int i15 = i6 + i12;
            if (i15 >= c6 || (i8 = i7 + i12) >= e6 || !this.f34401a.b(i8, i15)) {
                break;
            }
            d6[4] = d6[4] + 1;
            i12++;
        }
        if (d6[4] == 0) {
            return false;
        }
        return c(d6);
    }

    private static boolean b(e3 e3Var, e3 e3Var2, e3 e3Var3, float[] fArr) {
        a(e3Var, e3Var2, e3Var3, fArr);
        float sqrt = (float) Math.sqrt(fArr[1]);
        float sqrt2 = (float) Math.sqrt(fArr[2]);
        float sqrt3 = (float) Math.sqrt(fArr[0]);
        if (Math.min(Math.min(sqrt, sqrt2), sqrt3) <= Math.max(Math.max(e3Var.e(), e3Var2.e()), e3Var3.e()) * 7.0f) {
            return false;
        }
        float f6 = fArr[1];
        float f7 = fArr[2];
        float f8 = fArr[0];
        float f9 = ((f6 + f7) - f8) / ((sqrt * 2.0f) * sqrt2);
        float f10 = sqrt3 * 2.0f;
        float f11 = ((f8 + f6) - f7) / (sqrt * f10);
        float f12 = ((f8 + f7) - f6) / (f10 * sqrt2);
        return Math.abs(f9) <= 0.45f && f11 >= 0.2588f && f11 <= 0.94f && f12 >= 0.2588f && f12 <= 0.94f;
    }

    protected static boolean b(int[] iArr) {
        int i6 = 0;
        for (int i7 = 0; i7 < 3; i7++) {
            int i8 = iArr[i7];
            if (i8 == 0) {
                return false;
            }
            i6 += i8;
        }
        if (i6 < 7) {
            return false;
        }
        float f6 = i6 / 7.0f;
        float f7 = 0.5f * f6;
        return Math.abs(f6 - ((float) iArr[0])) < f7 && Math.abs((5.0f * f6) - ((float) iArr[1])) < f7 && Math.abs(f6 - ((float) iArr[2])) < f7;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x002d, code lost:
    
        if (r2[3] <= r11) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0031, code lost:
    
        if (r9 >= r1) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0037, code lost:
    
        if (r0.b(r10, r9) == false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0039, code lost:
    
        r2[4] = r2[4] + 1;
        r9 = r9 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0041, code lost:
    
        r10 = r2[4];
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0043, code lost:
    
        if (r10 <= r11) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0045, code lost:
    
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x005d, code lost:
    
        if ((java.lang.Math.abs(((((r2[0] + r2[1]) + r2[2]) + r2[3]) + r10) - r12) * 5) < (r12 * 2)) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x005f, code lost:
    
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0064, code lost:
    
        if (a(r2, true) == false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x006a, code lost:
    
        return a(r2, r9);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private float b(int r9, int r10, int r11, int r12) {
        /*
            r8 = this;
            com.huawei.hms.scankit.p.s r0 = r8.f34401a
            int r1 = r0.c()
            int[] r2 = r8.d()
            boolean r3 = r8.d(r9, r10, r11, r2)
            r4 = 2143289344(0x7fc00000, float:NaN)
            if (r3 == 0) goto L13
            return r4
        L13:
            r3 = 1
            int r9 = r9 + r3
        L15:
            r5 = 3
            if (r9 >= r1) goto L29
            boolean r6 = r0.b(r10, r9)
            if (r6 != 0) goto L29
            r6 = r2[r5]
            if (r6 > r11) goto L29
            int r6 = r6 + 1
            r2[r5] = r6
            int r9 = r9 + 1
            goto L15
        L29:
            if (r9 < 0) goto L6b
            r6 = r2[r5]
            if (r6 <= r11) goto L30
            goto L6b
        L30:
            r6 = 4
            if (r9 >= r1) goto L41
            boolean r7 = r0.b(r10, r9)
            if (r7 == 0) goto L41
            r7 = r2[r6]
            int r7 = r7 + r3
            r2[r6] = r7
            int r9 = r9 + 1
            goto L30
        L41:
            r10 = r2[r6]
            if (r10 <= r11) goto L46
            return r4
        L46:
            r11 = 0
            r11 = r2[r11]
            r0 = r2[r3]
            int r11 = r11 + r0
            r0 = 2
            r1 = r2[r0]
            int r11 = r11 + r1
            r1 = r2[r5]
            int r11 = r11 + r1
            int r11 = r11 + r10
            int r11 = r11 - r12
            int r10 = java.lang.Math.abs(r11)
            int r10 = r10 * 5
            int r12 = r12 * 2
            if (r10 < r12) goto L60
            return r4
        L60:
            boolean r10 = a(r2, r3)
            if (r10 == 0) goto L6b
            float r9 = a(r2, r9)
            return r9
        L6b:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.i3.b(int, int, int, int):float");
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0041, code lost:
    
        if (r2[3] < r12) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0045, code lost:
    
        if (r10 >= r1) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x004b, code lost:
    
        if (r0.b(r10, r11) == false) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x004d, code lost:
    
        r8 = r2[4];
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x004f, code lost:
    
        if (r8 >= r12) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0051, code lost:
    
        r2[4] = r8 + 1;
        r10 = r10 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x005c, code lost:
    
        if (a(r2, r14) != false) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x005e, code lost:
    
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0075, code lost:
    
        if ((java.lang.Math.abs(((((r2[0] + r2[1]) + r2[2]) + r2[3]) + r2[4]) - r13) * 5) < r13) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0079, code lost:
    
        if (com.huawei.hms.scankit.p.i3.f34399i != false) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x007d, code lost:
    
        if (com.huawei.hms.scankit.p.i3.f34398h != false) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x007f, code lost:
    
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0084, code lost:
    
        return a(r2, r10);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private float a(int r10, int r11, int r12, int r13, boolean r14) {
        /*
            r9 = this;
            com.huawei.hms.scankit.p.s r0 = r9.f34401a
            int r1 = r0.e()
            int[] r2 = r9.d()
            boolean r3 = r9.a(r10, r11, r12, r2)
            r4 = 2143289344(0x7fc00000, float:NaN)
            if (r3 == 0) goto L13
            return r4
        L13:
            r3 = 1
            int r10 = r10 + r3
        L15:
            r5 = 2
            if (r10 >= r1) goto L26
            boolean r6 = r0.b(r10, r11)
            if (r6 == 0) goto L26
            r6 = r2[r5]
            int r6 = r6 + r3
            r2[r5] = r6
            int r10 = r10 + 1
            goto L15
        L26:
            if (r10 != r1) goto L29
            return r4
        L29:
            r6 = 3
            if (r10 >= r1) goto L3d
            boolean r7 = r0.b(r10, r11)
            if (r7 != 0) goto L3d
            r7 = r2[r6]
            if (r7 >= r12) goto L3d
            int r7 = r7 + 1
            r2[r6] = r7
            int r10 = r10 + 1
            goto L29
        L3d:
            if (r10 == r1) goto L85
            r7 = r2[r6]
            if (r7 < r12) goto L44
            goto L85
        L44:
            r7 = 4
            if (r10 >= r1) goto L58
            boolean r8 = r0.b(r10, r11)
            if (r8 == 0) goto L58
            r8 = r2[r7]
            if (r8 >= r12) goto L58
            int r8 = r8 + 1
            r2[r7] = r8
            int r10 = r10 + 1
            goto L44
        L58:
            boolean r11 = a(r2, r14)
            if (r11 != 0) goto L5f
            return r4
        L5f:
            r11 = 0
            r11 = r2[r11]
            r12 = r2[r3]
            int r11 = r11 + r12
            r12 = r2[r5]
            int r11 = r11 + r12
            r12 = r2[r6]
            int r11 = r11 + r12
            r12 = r2[r7]
            int r11 = r11 + r12
            int r11 = r11 - r13
            int r11 = java.lang.Math.abs(r11)
            int r11 = r11 * 5
            if (r11 < r13) goto L80
            boolean r11 = com.huawei.hms.scankit.p.i3.f34399i
            if (r11 != 0) goto L80
            boolean r11 = com.huawei.hms.scankit.p.i3.f34398h
            if (r11 != 0) goto L80
            return r4
        L80:
            float r10 = a(r2, r10)
            return r10
        L85:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.i3.a(int, int, int, int, boolean):float");
    }

    protected final boolean b(int[] iArr, int i6, int i7) {
        int i8 = iArr[0];
        int i9 = iArr[1];
        int i10 = i8 + i9 + iArr[2];
        float f6 = i7 - (i10 / 2);
        int i11 = (int) f6;
        float a6 = a(i6, i11, i9, i10);
        if (Float.isNaN(a6)) {
            a6 = a(i6, (int) (f6 - ((r9 * 2) / 5)), (int) (((r9 * 2) / 5) + f6), iArr[1], i10);
            if (Float.isNaN(a6) && r3.f34737h) {
                a6 = b(i6, i11, iArr[1], i10);
            }
        }
        if (Float.isNaN(a6)) {
            return false;
        }
        return a(false, a6, f6, i10 / 7.0f);
    }

    private boolean a(int i6, int i7, int i8, int[] iArr) {
        boolean z5;
        int i9;
        s sVar = this.f34401a;
        while (true) {
            z5 = true;
            if (i6 < 0 || !sVar.b(i6, i7)) {
                break;
            }
            iArr[2] = iArr[2] + 1;
            i6--;
        }
        if (i6 < 0) {
            return true;
        }
        while (i6 >= 0 && !sVar.b(i6, i7)) {
            int i10 = iArr[1];
            if (i10 > i8) {
                break;
            }
            iArr[1] = i10 + 1;
            i6--;
        }
        if (i6 >= 0 && iArr[1] <= i8) {
            while (true) {
                z5 = false;
                if (i6 < 0 || !sVar.b(i6, i7) || (i9 = iArr[0]) > i8) {
                    break;
                }
                iArr[0] = i9 + 1;
                i6--;
            }
        }
        return z5;
    }

    protected final boolean a(int[] iArr, int i6, int i7, boolean z5) {
        int i8 = 0;
        int i9 = iArr[0];
        int i10 = iArr[1];
        int i11 = iArr[2];
        int i12 = iArr[3];
        int i13 = iArr[4];
        int i14 = i9 + i10 + i11 + i12 + i13;
        boolean z6 = f34398h;
        boolean z7 = f34399i;
        if (z6) {
            i14 = i10 + i10 + i11 + i12 + i13;
        } else if (z7) {
            i14 = i9 + i10 + i11 + i12 + i12;
        }
        int i15 = i14;
        int a6 = (int) a(iArr, i7);
        float b6 = b(i6, a6, iArr[2], i15, z5);
        boolean z8 = f34398h;
        boolean z9 = f34399i;
        if (!Float.isNaN(b6)) {
            float f6 = i15 / 7.0f;
            int i16 = (int) b6;
            float a7 = a(a6, i16, iArr[2], i15, z5);
            if (!Float.isNaN(a7) && (a(i16, (int) a7) || (z5 && (z6 || z7 || z8 || z9)))) {
                if (z5) {
                    return a(false, b6, a7, f6);
                }
                while (true) {
                    if (i8 < this.f34402b.size()) {
                        e3 e3Var = this.f34402b.get(i8);
                        if (e3Var.b(f6, b6, a7)) {
                            this.f34402b.set(i8, e3Var.a(b6, a7, f6, true));
                            break;
                        }
                        i8++;
                    } else {
                        e3 e3Var2 = new e3(a7, b6, f6, true);
                        this.f34402b.add(e3Var2);
                        v6 v6Var = this.f34405e;
                        if (v6Var != null) {
                            v6Var.a(e3Var2);
                        }
                    }
                }
                return true;
            }
        }
        return false;
    }

    private static double a(e3 e3Var, e3 e3Var2) {
        double b6 = e3Var.b() - e3Var2.b();
        double c6 = e3Var.c() - e3Var2.c();
        return (b6 * b6) + (c6 * c6);
    }

    private static void a(e3 e3Var, e3 e3Var2, e3 e3Var3, float[] fArr) {
        float b6 = e3Var.b() - e3Var2.b();
        float c6 = e3Var.c() - e3Var2.c();
        float f6 = (b6 * b6) + (c6 * c6);
        float b7 = e3Var.b() - e3Var3.b();
        float c7 = e3Var.c() - e3Var3.c();
        float f7 = (b7 * b7) + (c7 * c7);
        float b8 = e3Var2.b() - e3Var3.b();
        float c8 = e3Var2.c() - e3Var3.c();
        float f8 = (b8 * b8) + (c8 * c8);
        if (f6 > f8 && f6 > f7) {
            fArr[0] = f6;
            fArr[1] = f7;
            fArr[2] = f8;
        } else if (f8 > f6 && f8 > f7) {
            fArr[0] = f8;
            fArr[1] = f6;
            fArr[2] = f7;
        } else {
            fArr[0] = f7;
            fArr[1] = f6;
            fArr[2] = f8;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x005c, code lost:
    
        if (r2[3] < r12) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0060, code lost:
    
        if (r10 >= r1) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0066, code lost:
    
        if (r0.b(r11, r10) == false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0068, code lost:
    
        r8 = r2[4];
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x006a, code lost:
    
        if (r8 >= r12) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x006c, code lost:
    
        r2[4] = r8 + 1;
        r10 = r10 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0073, code lost:
    
        r11 = r2[4];
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0075, code lost:
    
        if (r11 < r12) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0077, code lost:
    
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x008e, code lost:
    
        if ((java.lang.Math.abs(((((r2[0] + r2[1]) + r2[2]) + r2[3]) + r11) - r13) * 5) < (r13 * 2)) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0090, code lost:
    
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0093, code lost:
    
        if (com.huawei.hms.scankit.p.r3.f34737h == false) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0099, code lost:
    
        if (a(r2, true) == false) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x009f, code lost:
    
        return a(r2, r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00a0, code lost:
    
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00a5, code lost:
    
        if (a(r2, false) == false) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00ab, code lost:
    
        return a(r2, r10);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private float a(int r10, int r11, int r12, int r13) {
        /*
            r9 = this;
            com.huawei.hms.scankit.p.s r0 = r9.f34401a
            int r1 = r0.c()
            int[] r2 = r9.d()
            boolean r3 = r9.c(r10, r11, r12, r2)
            r4 = 2143289344(0x7fc00000, float:NaN)
            if (r3 == 0) goto L13
            return r4
        L13:
            r3 = 1
            int r10 = r10 + r3
        L15:
            if (r10 >= r1) goto L28
            boolean r5 = r0.b(r11, r10)
            if (r5 != 0) goto L28
            r5 = r2[r3]
            if (r5 > r12) goto L28
            int r5 = r5 + 1
            r2[r3] = r5
            int r10 = r10 + 1
            goto L15
        L28:
            if (r10 < 0) goto Lac
            r5 = r2[r3]
            if (r5 <= r12) goto L30
            goto Lac
        L30:
            r5 = 2
            if (r10 >= r1) goto L41
            boolean r6 = r0.b(r11, r10)
            if (r6 == 0) goto L41
            r6 = r2[r5]
            int r6 = r6 + r3
            r2[r5] = r6
            int r10 = r10 + 1
            goto L30
        L41:
            if (r10 != r1) goto L44
            return r4
        L44:
            r6 = 3
            if (r10 >= r1) goto L58
            boolean r7 = r0.b(r11, r10)
            if (r7 != 0) goto L58
            r7 = r2[r6]
            if (r7 >= r12) goto L58
            int r7 = r7 + 1
            r2[r6] = r7
            int r10 = r10 + 1
            goto L44
        L58:
            if (r10 == r1) goto Lac
            r7 = r2[r6]
            if (r7 < r12) goto L5f
            goto Lac
        L5f:
            r7 = 4
            if (r10 >= r1) goto L73
            boolean r8 = r0.b(r11, r10)
            if (r8 == 0) goto L73
            r8 = r2[r7]
            if (r8 >= r12) goto L73
            int r8 = r8 + 1
            r2[r7] = r8
            int r10 = r10 + 1
            goto L5f
        L73:
            r11 = r2[r7]
            if (r11 < r12) goto L78
            return r4
        L78:
            r12 = 0
            r0 = r2[r12]
            r1 = r2[r3]
            int r0 = r0 + r1
            r1 = r2[r5]
            int r0 = r0 + r1
            r1 = r2[r6]
            int r0 = r0 + r1
            int r0 = r0 + r11
            int r0 = r0 - r13
            int r11 = java.lang.Math.abs(r0)
            int r11 = r11 * 5
            int r13 = r13 * 2
            if (r11 < r13) goto L91
            return r4
        L91:
            boolean r11 = com.huawei.hms.scankit.p.r3.f34737h
            if (r11 == 0) goto La1
            boolean r11 = a(r2, r3)
            if (r11 == 0) goto La0
            float r10 = a(r2, r10)
            return r10
        La0:
            return r4
        La1:
            boolean r11 = a(r2, r12)
            if (r11 == 0) goto Lac
            float r10 = a(r2, r10)
            return r10
        Lac:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.i3.a(int, int, int, int):float");
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0029, code lost:
    
        r10 = r18 * 1.5d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0033, code lost:
    
        if (r5[1] <= r10) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0038, code lost:
    
        if (r6 < 0) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x003e, code lost:
    
        if (r2.b(r4, r6) == false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0040, code lost:
    
        r9 = r5[0];
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0042, code lost:
    
        if (r9 > r18) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0044, code lost:
    
        r5[0] = r9 + 1;
        r6 = r6 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004f, code lost:
    
        if (r5[0] <= (r18 / 2)) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0052, code lost:
    
        r6 = r15 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0054, code lost:
    
        if (r6 >= r3) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x005a, code lost:
    
        if (r2.b(r4, r6) != false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x005c, code lost:
    
        r9 = r5[1];
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x005e, code lost:
    
        if (r9 > r18) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0060, code lost:
    
        r5[1] = r9 + 1;
        r6 = r6 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0067, code lost:
    
        if (r6 < 0) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x006e, code lost:
    
        if (r5[1] <= r10) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0072, code lost:
    
        if (r6 >= r3) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0078, code lost:
    
        if (r2.b(r4, r6) == false) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x007a, code lost:
    
        r5[2] = r5[2] + 1;
        r6 = r6 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0094, code lost:
    
        if ((java.lang.Math.abs(((r5[0] + r5[1]) + r5[2]) - r19) * 5) < (r19 * 2)) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x009b, code lost:
    
        if (b(r5) == false) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00a5, code lost:
    
        return (r6 - (r5[1] / 2)) - r5[2];
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00a6, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00a6, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00a6, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00a6, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00a6, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private float a(int r15, int r16, int r17, int r18, int r19) {
        /*
            r14 = this;
            r0 = r17
            r1 = r18
            com.huawei.hms.scankit.p.s r2 = r14.f34401a
            int r3 = r2.c()
            r4 = r16
        Lc:
            if (r4 > r0) goto Lab
            int[] r5 = r14.d()
            r6 = r15
        L13:
            r7 = 1
            if (r6 < 0) goto L27
            boolean r8 = r2.b(r4, r6)
            if (r8 != 0) goto L27
            r8 = r5[r7]
            if (r8 > r1) goto L27
            int r8 = r8 + 1
            r5[r7] = r8
            int r6 = r6 + (-1)
            goto L13
        L27:
            if (r6 < 0) goto La6
            r8 = r5[r7]
            double r8 = (double) r8
            double r10 = (double) r1
            r12 = 4609434218613702656(0x3ff8000000000000, double:1.5)
            double r10 = r10 * r12
            int r12 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r12 <= 0) goto L37
            goto La6
        L37:
            r8 = 0
            if (r6 < 0) goto L4b
            boolean r9 = r2.b(r4, r6)
            if (r9 == 0) goto L4b
            r9 = r5[r8]
            if (r9 > r1) goto L4b
            int r9 = r9 + 1
            r5[r8] = r9
            int r6 = r6 + (-1)
            goto L37
        L4b:
            r6 = r5[r8]
            int r9 = r1 / 2
            if (r6 <= r9) goto L52
            goto La6
        L52:
            int r6 = r15 + 1
        L54:
            if (r6 >= r3) goto L67
            boolean r9 = r2.b(r4, r6)
            if (r9 != 0) goto L67
            r9 = r5[r7]
            if (r9 > r1) goto L67
            int r9 = r9 + 1
            r5[r7] = r9
            int r6 = r6 + 1
            goto L54
        L67:
            if (r6 < 0) goto La6
            r9 = r5[r7]
            double r12 = (double) r9
            int r9 = (r12 > r10 ? 1 : (r12 == r10 ? 0 : -1))
            if (r9 <= 0) goto L71
            goto La6
        L71:
            r9 = 2
            if (r6 >= r3) goto L82
            boolean r10 = r2.b(r4, r6)
            if (r10 == 0) goto L82
            r10 = r5[r9]
            int r10 = r10 + r7
            r5[r9] = r10
            int r6 = r6 + 1
            goto L71
        L82:
            r8 = r5[r8]
            r10 = r5[r7]
            int r8 = r8 + r10
            r10 = r5[r9]
            int r8 = r8 + r10
            int r8 = r8 - r19
            int r8 = java.lang.Math.abs(r8)
            int r8 = r8 * 5
            int r10 = r19 * 2
            if (r8 < r10) goto L97
            goto La6
        L97:
            boolean r8 = b(r5)
            if (r8 == 0) goto La6
            r15 = r5[r7]
            int r15 = r15 / r9
            int r6 = r6 - r15
            r15 = r5[r9]
            int r6 = r6 - r15
            float r15 = (float) r6
            return r15
        La6:
            int r5 = r0 - r16
            int r4 = r4 + r5
            goto Lc
        Lab:
            r15 = 2143289344(0x7fc00000, float:NaN)
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.i3.a(int, int, int, int, int):float");
    }

    protected final boolean a(int[] iArr, int i6, int i7) {
        int i8 = iArr[0] + iArr[1] + iArr[2] + iArr[3] + iArr[4];
        float a6 = a(iArr, i7);
        float b6 = b(i6, (int) a6, iArr[2], i8, false);
        if (Float.isNaN(b6)) {
            int i9 = iArr[2];
            int i10 = iArr[1];
            b6 = a(i6, (int) ((a6 - (i9 / 2)) - (i10 / 2)), (int) ((i9 / 2) + a6 + (r13 / 2)), i10 + i9 + iArr[3], i8);
            i8 = i8;
        }
        if (Float.isNaN(b6)) {
            return false;
        }
        return a(false, b6, a6, i8 / 7.0f);
    }

    private boolean a(boolean z5, float f6, float f7, float f8) {
        int i6 = 0;
        while (true) {
            if (i6 >= this.f34403c.size()) {
                break;
            }
            e3 e3Var = this.f34403c.get(i6);
            if (e3Var.b(f8, f6, f7)) {
                this.f34403c.set(i6, e3Var.a(f6, f7, f8, false));
                z5 = true;
                break;
            }
            i6++;
        }
        if (!z5) {
            e3 e3Var2 = new e3(f7, f6, f8, false);
            this.f34403c.add(e3Var2);
            v6 v6Var = this.f34405e;
            if (v6Var != null) {
                v6Var.a(e3Var2);
            }
        }
        return true;
    }

    private e3[] a() throws com.huawei.hms.scankit.p.a {
        e3 e3Var = this.f34402b.get(0);
        e3 e3Var2 = this.f34402b.get(1);
        float[] fArr = e3Var.b() < e3Var2.b() ? new float[]{e3Var.b(), e3Var2.b()} : new float[]{e3Var2.b(), e3Var.b()};
        float[] fArr2 = e3Var.b() < e3Var2.b() ? new float[]{e3Var.c(), e3Var2.c()} : new float[]{e3Var2.c(), e3Var.c()};
        float e6 = (e3Var.e() + e3Var2.e()) / 2.0f;
        float e7 = ((e3Var.e() + e3Var2.e()) * 7.0f) / 1.5f;
        if (Math.abs(fArr[0] - fArr[1]) > e7 && Math.abs(fArr2[0] - fArr2[1]) <= e7) {
            float f6 = fArr[0];
            float f7 = fArr2[0];
            this.f34402b.add(new e3((f6 + f7) - fArr2[1], (f7 + fArr[1]) - f6, e6, false, 0));
        } else if (Math.abs(fArr[0] - fArr[1]) <= e7 && Math.abs(fArr2[0] - fArr2[1]) > e7) {
            float f8 = fArr[0];
            float f9 = fArr[1];
            if (f8 < f9) {
                float f10 = fArr2[0] + f9;
                float f11 = fArr2[1];
                this.f34402b.add(new e3(f10 - f11, (f11 + f9) - f8, e6, false, 0));
            } else {
                float f12 = fArr2[1] + f8;
                float f13 = fArr2[0];
                this.f34402b.add(new e3(f12 - f13, (f13 + f8) - f9, e6, false, 0));
            }
        } else if (Math.abs(fArr[0] - fArr[1]) > e7 && Math.abs(fArr2[0] - fArr2[1]) > e7) {
            float f14 = fArr[0];
            float f15 = fArr[1];
            float f16 = fArr2[1];
            float f17 = fArr2[0];
            this.f34402b.add(new e3((((f14 + f15) + f16) - f17) / 2.0f, (((f17 + f16) + f14) - f15) / 2.0f, e6, false, 0));
        }
        if (this.f34402b.size() == 3) {
            return new e3[]{this.f34402b.get(0), this.f34402b.get(1), this.f34402b.get(2)};
        }
        throw com.huawei.hms.scankit.p.a.a();
    }
}
