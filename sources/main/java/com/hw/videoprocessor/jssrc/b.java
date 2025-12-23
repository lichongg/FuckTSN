package com.hw.videoprocessor.jssrc;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Random;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class b {

    /* renamed from: q, reason: collision with root package name */
    private static final String f35414q = "1.30";

    /* renamed from: r, reason: collision with root package name */
    private static final int f35415r = 65536;

    /* renamed from: w, reason: collision with root package name */
    private static final int f35420w = 97;

    /* renamed from: y, reason: collision with root package name */
    static final /* synthetic */ boolean f35422y = false;

    /* renamed from: a, reason: collision with root package name */
    private ByteOrder f35423a;

    /* renamed from: b, reason: collision with root package name */
    private c f35424b;

    /* renamed from: c, reason: collision with root package name */
    private double f35425c;

    /* renamed from: d, reason: collision with root package name */
    private double f35426d;

    /* renamed from: e, reason: collision with root package name */
    private int f35427e;

    /* renamed from: f, reason: collision with root package name */
    private double[][] f35428f;

    /* renamed from: g, reason: collision with root package name */
    private int f35429g;

    /* renamed from: h, reason: collision with root package name */
    private int f35430h;

    /* renamed from: i, reason: collision with root package name */
    private int f35431i;

    /* renamed from: j, reason: collision with root package name */
    private int f35432j;

    /* renamed from: k, reason: collision with root package name */
    private double[] f35433k;

    /* renamed from: l, reason: collision with root package name */
    private int f35434l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f35435m;

    /* renamed from: n, reason: collision with root package name */
    private int f35436n;

    /* renamed from: o, reason: collision with root package name */
    private long f35437o;

    /* renamed from: p, reason: collision with root package name */
    private long f35438p;

    /* renamed from: s, reason: collision with root package name */
    private static final int[] f35416s = {0, 48000, 44100, 37800, 32000, 22050, 48000, 44100};

    /* renamed from: t, reason: collision with root package name */
    private static final int[] f35417t = {1, 16, 20, 16, 16, 15, 16, 15};

    /* renamed from: u, reason: collision with root package name */
    private static final int[] f35418u = {8, 18, 27, 8, 8, 8, 10, 9};

    /* renamed from: v, reason: collision with root package name */
    private static final double[][] f35419v = {new double[]{-1.0d}, new double[]{-2.87207293510437d, 5.041323184967041d, -6.244299411773682d, 5.848398685455322d, -3.706754207611084d, 1.0495119094848633d, 1.1830236911773682d, -2.1126792430877686d, 1.9094531536102295d, -0.9991308450698853d, 0.17090806365013123d, 0.32615602016448975d, -0.39127644896507263d, 0.2687646150588989d, -0.0976761057972908d, 0.023473845794796944d}, new double[]{-2.6773197650909424d, 4.830892562866211d, -6.570110321044922d, 7.4572014808654785d, -6.726327419281006d, 4.848165035247803d, -2.0412089824676514d, -0.7006359100341797d, 2.95375657081604d, -4.080038547515869d, 4.184521675109863d, -3.331181287765503d, 2.117992639541626d, -0.879302978515625d, 0.031759146600961685d, 0.4238278865814209d, -0.4788210391998291d, 0.35490813851356506d, -0.1749683916568756d, 0.06090816855430603d}, new double[]{-1.6335992813110352d, 2.261549234390259d, -2.407702922821045d, 2.634171724319458d, -2.144036293029785d, 1.8153258562088013d, -1.0816224813461304d, 0.703026533126831d, -0.15991993248462677d, -0.04154951870441437d, 0.2941657602787018d, -0.25183168053627014d, 0.27766478061676025d, -0.15785403549671173d, 0.10165894031524658d, -0.016833892092108727d}, new double[]{-0.8290129899978638d, 0.9892265796661377d, -0.5982571244239807d, 1.0028809309005737d, -0.5993821620941162d, 0.7950245141983032d, -0.42723315954208374d, 0.5449252724647522d, -0.3079260587692261d, 0.3687179982662201d, -0.187920480966568d, 0.2261127084493637d, -0.10573341697454453d, 0.11435490846633911d, -0.0388006791472435d, 0.040842197835445404d}, new double[]{-0.06522997468709946d, 0.5498126149177551d, 0.4027854800224304d, 0.3178376853466034d, 0.2820179760456085d, 0.16985194385051727d, 0.15433363616466522d, 0.12507140636444092d, 0.08903945237398148d, 0.06441012024879456d, 0.04714600369334221d, 0.03280523791909218d, 0.028495194390416145d, 0.011695005930960178d, 0.011831838637590408d}, new double[]{-2.3925774097442627d, 3.4350297451019287d, -3.185370922088623d, 1.8117271661758423d, 0.2012477070093155d, -1.4759907722473145d, 1.7210904359817505d, -0.9774670004844666d, 0.13790138065814972d, 0.38185903429985046d, -0.27421241998672485d, -0.06658421456813812d, 0.35223302245140076d, -0.37672343850135803d, 0.23964276909828186d, -0.06867482513189316d}, new double[]{-2.0833916664123535d, 3.0418450832366943d, -3.204789876937866d, 2.757192611694336d, -1.4978630542755127d, 0.34275946021080017d, 0.7173374891281128d, -1.073705792427063d, 1.0225815773010254d, -0.5664999485015869d, 0.20968692004680634d, 0.06537853181362152d, -0.10322438180446625d, 0.06744202226400375d, 0.00495197344571352d}};

    /* renamed from: x, reason: collision with root package name */
    private static final double[] f35421x = {0.7d, 0.9d, 0.18d};

    public b() {
        this.f35423a = ByteOrder.LITTLE_ENDIAN;
        this.f35424b = new c();
        this.f35425c = 170.0d;
        this.f35426d = 100.0d;
        this.f35427e = 65536;
        this.f35435m = false;
    }

    private int f(int i6, int i7) {
        while (true) {
            int i8 = i7;
            int i9 = i6;
            i6 = i8;
            if (i6 == 0) {
                return i9;
            }
            i7 = i9 % i6;
        }
    }

    public int c(double d6, double[] dArr, int i6, int i7) {
        int i8;
        double a6;
        if (i6 == 1) {
            double[] dArr2 = this.f35433k;
            int i9 = this.f35434l;
            this.f35434l = i9 + 1;
            double d7 = d6 + dArr2[i9 & 65535];
            int i10 = this.f35431i;
            if (d7 < i10) {
                double d8 = d7 / i10;
                double d9 = dArr[0];
                if (d9 >= d8) {
                    d8 = d9;
                }
                dArr[0] = d8;
                d7 = i10;
            }
            int i11 = this.f35432j;
            if (d7 > i11) {
                double d10 = d7 / i11;
                double d11 = dArr[0];
                if (d11 >= d10) {
                    d10 = d11;
                }
                dArr[0] = d10;
                d7 = i11;
            }
            return a(d7);
        }
        double d12 = 0.0d;
        int i12 = 0;
        while (true) {
            i8 = this.f35430h;
            if (i12 >= i8) {
                break;
            }
            d12 += f35419v[this.f35429g][i12] * this.f35428f[i7][i12];
            i12++;
        }
        double d13 = d6 + d12;
        double[] dArr3 = this.f35433k;
        int i13 = this.f35434l;
        this.f35434l = i13 + 1;
        double d14 = dArr3[65535 & i13] + d13;
        for (int i14 = i8 - 2; i14 >= 0; i14--) {
            double[] dArr4 = this.f35428f[i7];
            dArr4[i14 + 1] = dArr4[i14];
        }
        int i15 = this.f35431i;
        if (d14 < i15) {
            double d15 = d14 / i15;
            double d16 = dArr[0];
            if (d16 >= d15) {
                d15 = d16;
            }
            dArr[0] = d15;
            a6 = i15;
            double[] dArr5 = this.f35428f[i7];
            double d17 = a6 - d13;
            dArr5[0] = d17;
            if (d17 > 1.0d) {
                dArr5[0] = 1.0d;
            }
            if (dArr5[0] < -1.0d) {
                dArr5[0] = -1.0d;
            }
        } else {
            int i16 = this.f35432j;
            if (d14 > i16) {
                double d18 = d14 / i16;
                double d19 = dArr[0];
                if (d19 >= d18) {
                    d18 = d19;
                }
                dArr[0] = d18;
                a6 = i16;
                double[] dArr6 = this.f35428f[i7];
                double d20 = a6 - d13;
                dArr6[0] = d20;
                if (d20 > 1.0d) {
                    dArr6[0] = 1.0d;
                }
                if (dArr6[0] < -1.0d) {
                    dArr6[0] = -1.0d;
                }
            } else {
                a6 = a(d14);
                this.f35428f[i7][0] = a6 - d13;
            }
        }
        return (int) a6;
    }

    /* JADX WARN: Removed duplicated region for block: B:114:0x0717  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x07d0  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x07d4 A[LOOP:14: B:123:0x07d2->B:124:0x07d4, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:128:0x07ee A[LOOP:15: B:127:0x07ec->B:128:0x07ee, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:132:0x07ff  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0805 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0768  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public double d(java.io.InputStream r72, java.io.OutputStream r73, int r74, int r75, int r76, int r77, int r78, double r79, int r81, boolean r82, int r83) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 2170
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hw.videoprocessor.jssrc.b.d(java.io.InputStream, java.io.OutputStream, int, int, int, int, int, double, int, boolean, int):double");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x011e A[EDGE_INSN: B:58:0x011e->B:59:0x011e BREAK  A[LOOP:0: B:5:0x002b->B:31:0x023a], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public double k(java.io.InputStream r28, java.io.OutputStream r29, int r30, int r31, int r32, double r33, int r35, boolean r36, int r37) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 590
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hw.videoprocessor.jssrc.b.k(java.io.InputStream, java.io.OutputStream, int, int, int, double, int, boolean, int):double");
    }

    /* JADX WARN: Removed duplicated region for block: B:145:0x05c3  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x07c7  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x08b9  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x08c4  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x082a  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x05fb  */
    /* JADX WARN: Removed duplicated region for block: B:280:0x03c5  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x03b4 A[LOOP:7: B:78:0x03b0->B:80:0x03b4, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x03c2  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x03df  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public double p(java.io.InputStream r75, java.io.OutputStream r76, int r77, int r78, int r79, int r80, int r81, double r82, int r84, boolean r85, int r86) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 2368
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hw.videoprocessor.jssrc.b.p(java.io.InputStream, java.io.OutputStream, int, int, int, int, int, double, int, boolean, int):double");
    }

    private int a(double d6) {
        return (int) (d6 >= 0.0d ? d6 + 0.5d : d6 - 0.5d);
    }

    private double b(double d6) {
        if (d6 <= 21.0d) {
            return 0.0d;
        }
        if (d6 > 50.0d) {
            return (d6 - 8.7d) * 0.1102d;
        }
        double d7 = d6 - 21.0d;
        return (Math.pow(d7, 0.4d) * 0.5842d) + (d7 * 0.07886d);
    }

    private void e(int i6) {
        throw new IllegalStateException("unknown error " + i6);
    }

    private double h(int i6, double d6, double d7) {
        double d8 = 1.0d / d7;
        return d6 * 2.0d * d8 * o(i6 * 6.283185307179586d * d6 * d8);
    }

    public static void j(String[] strArr) throws Exception {
        new b(strArr);
    }

    private void n(double d6) {
        if (this.f35435m) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.f35437o;
        int i6 = d6 == 0.0d ? 0 : (int) ((currentTimeMillis * (1.0d - d6)) / d6);
        int i7 = (int) (d6 * 100.0d);
        if (i7 != this.f35436n || currentTimeMillis != this.f35438p) {
            System.err.printf(" %3d%% processed", Integer.valueOf(i7));
            this.f35436n = i7;
        }
        if (currentTimeMillis != this.f35438p) {
            System.err.printf(", ETA =%4dmsec", Integer.valueOf(i6));
            this.f35438p = currentTimeMillis;
        }
        System.err.printf("\r", new Object[0]);
        System.err.flush();
    }

    private double o(double d6) {
        if (d6 == 0.0d) {
            return 1.0d;
        }
        return Math.sin(d6) / d6;
    }

    private void q() {
        System.err.printf("http://shibatch.sourceforge.net/\n\n", new Object[0]);
        System.err.printf("usage: ssrc [<options>] <source wav file> <destination wav file>\n", new Object[0]);
        System.err.printf("options : --rate <sampling rate>     output sample rate\n", new Object[0]);
        System.err.printf("          --att <attenuation(dB)>    attenuate signal\n", new Object[0]);
        System.err.printf("          --bits <number of bits>    output quantization bit length\n", new Object[0]);
        System.err.printf("          --tmpfile <file name>      specify temporal file\n", new Object[0]);
        System.err.printf("          --twopass                  two pass processing to avoid clipping\n", new Object[0]);
        System.err.printf("          --normalize                normalize the wave file\n", new Object[0]);
        System.err.printf("          --quiet                    nothing displayed except error\n", new Object[0]);
        System.err.printf("          --dither [<type>]          dithering\n", new Object[0]);
        System.err.printf("                                       0 : no dither\n", new Object[0]);
        System.err.printf("                                       1 : no noise shaping\n", new Object[0]);
        System.err.printf("                                       2 : triangular spectral shape\n", new Object[0]);
        System.err.printf("                                       3 : ATH based noise shaping\n", new Object[0]);
        System.err.printf("                                       4 : less dither amplitude than type 3\n", new Object[0]);
        System.err.printf("          --pdf <type> [<amp>]       select p.d.f. of noise\n", new Object[0]);
        System.err.printf("                                       0 : rectangular\n", new Object[0]);
        System.err.printf("                                       1 : triangular\n", new Object[0]);
        System.err.printf("                                       2 : Gaussian\n", new Object[0]);
        System.err.printf("          --profile <type>           specify profile\n", new Object[0]);
        System.err.printf("                                       standard : the default quality\n", new Object[0]);
        System.err.printf("                                       fast     : fast, not so bad quality\n", new Object[0]);
    }

    private double r(double d6, int i6, double d7, double d8) {
        double d9 = 4.0d * d6 * d6;
        double d10 = i6 - 1.0d;
        return a.a(d7 * Math.sqrt(1.0d - (d9 / (d10 * d10)))) / d8;
    }

    public int i(int i6, int i7, int i8, int i9, int i10, int i11, double d6) {
        int i12;
        int i13 = 97;
        int[] iArr = new int[97];
        int i14 = 1;
        while (true) {
            if (i14 >= 6) {
                i12 = i6;
                break;
            }
            i12 = i6;
            if (i12 == f35416s[i14]) {
                break;
            }
            i14++;
        }
        if ((i10 == 3 || i10 == 4) && i14 == 6) {
            System.err.printf("Warning: ATH based noise shaping for destination frequency %dHz is not available, using triangular dither\n", Integer.valueOf(i12));
        }
        if (i10 == 2 || i14 == 6) {
            i14 = 0;
        }
        if (i10 == 4 && (i14 == 1 || i14 == 2)) {
            i14 += 5;
        }
        this.f35429g = i14;
        this.f35428f = new double[i7][];
        this.f35430h = f35417t[i14];
        for (int i15 = 0; i15 < i7; i15++) {
            this.f35428f[i15] = new double[this.f35430h];
        }
        this.f35431i = i8;
        this.f35432j = i9;
        this.f35433k = new double[65536];
        Random random = new Random(System.currentTimeMillis());
        for (int i16 = 0; i16 < 97; i16++) {
            iArr[i16] = random.nextInt();
        }
        if (i11 == 0) {
            for (int i17 = 0; i17 < 65536; i17++) {
                int nextInt = random.nextInt() % 97;
                int i18 = iArr[nextInt];
                iArr[nextInt] = random.nextInt();
                this.f35433k[i17] = ((i18 / 2.147483647E9d) - 0.5d) * d6;
            }
        } else if (i11 == 1) {
            for (int i19 = 0; i19 < 65536; i19++) {
                int nextInt2 = random.nextInt() % 97;
                int i20 = iArr[nextInt2];
                iArr[nextInt2] = random.nextInt();
                int nextInt3 = random.nextInt() % 97;
                int i21 = iArr[nextInt3];
                iArr[nextInt3] = random.nextInt();
                this.f35433k[i19] = ((i20 / 2.147483647E9d) - (i21 / 2.147483647E9d)) * d6;
            }
        } else if (i11 == 2) {
            int i22 = 0;
            boolean z5 = false;
            double d7 = 0.0d;
            double d8 = 0.0d;
            while (i22 < 65536) {
                if (z5) {
                    this.f35433k[i22] = d6 * d7 * Math.sin(d8);
                    z5 = false;
                } else {
                    double d9 = iArr[r13] / 2.147483647E9d;
                    iArr[random.nextInt() % i13] = random.nextInt();
                    if (d9 == 1.0d) {
                        d9 = 0.0d;
                    }
                    d7 = Math.sqrt(Math.log(1.0d - d9) * (-2.0d));
                    iArr[random.nextInt() % i13] = random.nextInt();
                    d8 = 6.283185307179586d * (iArr[r13] / 2.147483647E9d);
                    this.f35433k[i22] = d6 * d7 * Math.cos(d8);
                    z5 = true;
                }
                i22++;
                i13 = 97;
            }
        }
        this.f35434l = 0;
        if (i10 == 0 || i10 == 1) {
            return 1;
        }
        return f35418u[this.f35429g];
    }

    private void m() {
        this.f35437o = System.currentTimeMillis();
        this.f35438p = 0L;
        this.f35436n = -1;
    }

    protected byte[] g(ByteBuffer byteBuffer) {
        int limit = byteBuffer.limit() - byteBuffer.position();
        byte[] bArr = new byte[limit];
        byteBuffer.get(bArr, 0, limit);
        return bArr;
    }

    protected void s(OutputStream outputStream, ByteBuffer byteBuffer) {
        try {
            outputStream.write(g(byteBuffer));
        } catch (IOException unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:169:0x03be  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x03c1  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x03d3  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0501  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x054c  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x0793  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x088a  */
    /* JADX WARN: Removed duplicated region for block: B:280:0x089f  */
    /* JADX WARN: Removed duplicated region for block: B:283:0x0945  */
    /* JADX WARN: Removed duplicated region for block: B:285:0x094a  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x0895  */
    /* JADX WARN: Removed duplicated region for block: B:335:0x08bd  */
    /* JADX WARN: Removed duplicated region for block: B:341:0x093c  */
    /* JADX WARN: Removed duplicated region for block: B:348:0x0542  */
    /* JADX WARN: Removed duplicated region for block: B:353:0x0494  */
    /* JADX WARN: Removed duplicated region for block: B:356:0x03cc  */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.hw.videoprocessor.jssrc.b, java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    b(java.lang.String[] r50) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 2598
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hw.videoprocessor.jssrc.b.<init>(java.lang.String[]):void");
    }

    private void l(int i6) {
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0217  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0080  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public b(java.io.InputStream r25, java.io.OutputStream r26, int r27, int r28, int r29, int r30, int r31, int r32, double r33, int r35, boolean r36) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 607
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hw.videoprocessor.jssrc.b.<init>(java.io.InputStream, java.io.OutputStream, int, int, int, int, int, int, double, int, boolean):void");
    }
}
