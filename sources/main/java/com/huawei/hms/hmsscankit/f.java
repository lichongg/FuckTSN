package com.huawei.hms.hmsscankit;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.os.RemoteException;
import com.huawei.hms.feature.DynamicModuleInitializer;
import com.huawei.hms.feature.dynamic.ObjectWrapper;
import com.huawei.hms.framework.common.hianalytics.WiseOpenHianalyticsData;
import com.huawei.hms.hmsscankit.api.IRemoteCreator;
import com.huawei.hms.hmsscankit.api.IRemoteDecoderDelegate;
import com.huawei.hms.hmsscankit.api.IRemoteFrameDecoderDelegate;
import com.huawei.hms.ml.scan.HmsBuildBitmapOption;
import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.ml.scan.HmsScanAnalyzerOptions;
import com.huawei.hms.ml.scan.HmsScanResult;
import com.huawei.hms.scankit.p.o4;
import com.huawei.hms.scankit.p.s6;
import com.huawei.hms.scankit.p.u6;
import com.huawei.hms.scankit.p.w3;
import com.huawei.hms.scankit.p.x3;
import com.huawei.hms.scankit.p.y3;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.TimeZone;
import java.util.UUID;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private static volatile x3 f33748a;

    /* renamed from: b, reason: collision with root package name */
    private static volatile IRemoteDecoderDelegate f33749b;

    /* renamed from: c, reason: collision with root package name */
    private static volatile w3 f33750c;

    /* renamed from: d, reason: collision with root package name */
    private static volatile IRemoteFrameDecoderDelegate f33751d;

    static HmsScan[] a(Context context, Bitmap bitmap, HmsScanAnalyzerOptions hmsScanAnalyzerOptions) {
        return a(context, bitmap, hmsScanAnalyzerOptions, hmsScanAnalyzerOptions.mode);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends SimpleDateFormat {
        a(String str) {
            super(str);
            setTimeZone(TimeZone.getTimeZone("UTC"));
        }
    }

    static HmsScan[] a(Context context, Bitmap bitmap, HmsScanAnalyzerOptions hmsScanAnalyzerOptions, int i6) {
        HmsScan[] hmsScanArr = new HmsScan[0];
        if (f33749b == null) {
            IRemoteCreator c6 = g.c(context);
            if (c6 != null) {
                try {
                    f33749b = c6.newRemoteDecoderDelegate();
                } catch (RemoteException unused) {
                    o4.b("ScankitRemoteDecoder", "RemoteException");
                }
            }
            return hmsScanArr;
        }
        if (f33749b == null) {
            return hmsScanArr;
        }
        try {
            Bundle bundle = new Bundle();
            if (hmsScanAnalyzerOptions != null) {
                bundle.putInt(DetailRect.FORMAT_FLAG, i6);
                bundle.putBoolean(DetailRect.PHOTO_MODE, hmsScanAnalyzerOptions.photoMode);
                bundle.putBoolean(DetailRect.PARSE_RESULT, hmsScanAnalyzerOptions.parseResult);
            }
            bundle.putInt(DetailRect.TYPE_TRANS, 3);
            bundle.putString(DetailRect.CP_PACKAGE, y3.b(context));
            bundle.putBoolean(DetailRect.SUPPORT_ROLLBACK, g.f33754c);
            bundle.putBoolean(DetailRect.USE_APK, g.f33752a);
            bundle.putAll(y3.a(context));
            HmsScan[] decodeWithBitmap = f33749b.decodeWithBitmap(ObjectWrapper.wrap(bitmap), ObjectWrapper.wrap(bundle));
            a(decodeWithBitmap);
            if (g.a()) {
                o4.d("ScankitRemoteDecoder", "iRemoteDecoderDelegate decodeWithBitmap rollback");
                IRemoteCreator c7 = g.c(context);
                if (c7 != null) {
                    try {
                        f33749b = c7.newRemoteDecoderDelegate();
                    } catch (RemoteException unused2) {
                        o4.b("ScankitRemoteDecoder", "RemoteException");
                    }
                    decodeWithBitmap = f33749b.decodeWithBitmap(ObjectWrapper.wrap(bitmap), ObjectWrapper.wrap(bundle));
                }
                return hmsScanArr;
            }
            return decodeWithBitmap != null ? decodeWithBitmap : hmsScanArr;
        } catch (RemoteException unused3) {
            o4.b("ScankitRemoteDecoder", "RemoteException");
            return hmsScanArr;
        }
    }

    public static void a(HmsScan[] hmsScanArr) {
        if (hmsScanArr.length == 1 && a(hmsScanArr[0].getCornerPoints())) {
            g.f33753b = true;
        } else {
            g.f33753b = false;
        }
    }

    public static void a(s6[] s6VarArr) {
        if (s6VarArr.length == 1 && a(s6VarArr[0].j())) {
            g.f33753b = true;
        } else {
            g.f33753b = false;
        }
    }

    private static boolean a(Point[] pointArr) {
        if (pointArr == null || pointArr.length == 0) {
            return false;
        }
        for (Point point : pointArr) {
            if (point.x != -2 && point.y != -2) {
                return false;
            }
        }
        return true;
    }

    private static boolean a(u6[] u6VarArr) {
        if (u6VarArr == null || u6VarArr.length == 0) {
            return false;
        }
        for (u6 u6Var : u6VarArr) {
            if (u6Var.b() - (-2.0f) > 1.0E-4d && u6Var.c() - (-2.0f) > 1.0E-4d) {
                return false;
            }
        }
        return true;
    }

    static HmsScanResult a(Context context, byte[] bArr, int i6, int i7, HmsScanAnalyzerOptions hmsScanAnalyzerOptions) {
        HmsScanResult hmsScanResult = new HmsScanResult(4096, new HmsScan[0]);
        if (f33749b == null) {
            IRemoteCreator c6 = g.c(context);
            if (c6 != null) {
                try {
                    f33749b = c6.newRemoteDecoderDelegate();
                } catch (RemoteException unused) {
                    o4.b("ScankitRemoteDecoder", "RemoteException");
                }
            }
            return hmsScanResult;
        }
        if (f33749b == null) {
            return hmsScanResult;
        }
        try {
            Bundle bundle = new Bundle();
            if (hmsScanAnalyzerOptions != null) {
                bundle.putInt(DetailRect.FORMAT_FLAG, hmsScanAnalyzerOptions.mode);
                bundle.putBoolean(DetailRect.PHOTO_MODE, hmsScanAnalyzerOptions.photoMode);
                bundle.putBoolean(DetailRect.PARSE_RESULT, hmsScanAnalyzerOptions.parseResult);
            }
            bundle.putBoolean(DetailRect.SUPPORT_ROLLBACK, g.f33754c);
            bundle.putBoolean(DetailRect.USE_APK, g.f33752a);
            bundle.putInt(DetailRect.TYPE_TRANS, 3);
            bundle.putString(DetailRect.CP_PACKAGE, y3.b(context));
            bundle.putAll(y3.a(context));
            HmsScanResult decodeWithBuffer = f33749b.decodeWithBuffer(bArr, i6, i7, ObjectWrapper.wrap(bundle));
            if (decodeWithBuffer != null && decodeWithBuffer.getHmsScans() != null) {
                a(decodeWithBuffer.getHmsScans());
                if (g.a()) {
                    o4.d("ScankitRemoteDecoder", "iRemoteDecoderDelegate decodeWithBuffer rollback");
                    IRemoteCreator c7 = g.c(context);
                    if (c7 != null) {
                        try {
                            f33749b = c7.newRemoteDecoderDelegate();
                        } catch (RemoteException unused2) {
                            o4.b("ScankitRemoteDecoder", "RemoteException");
                        }
                        decodeWithBuffer = f33749b.decodeWithBuffer(bArr, i6, i7, ObjectWrapper.wrap(bundle));
                    }
                    return hmsScanResult;
                }
            }
            return decodeWithBuffer != null ? decodeWithBuffer : hmsScanResult;
        } catch (RemoteException unused3) {
            o4.b("ScankitRemoteDecoder", "RemoteException");
            return hmsScanResult;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0081 A[Catch: RemoteException -> 0x0106, TryCatch #2 {RemoteException -> 0x0106, blocks: (B:10:0x0015, B:15:0x0081, B:16:0x008d, B:18:0x00b1, B:19:0x00d4, B:21:0x00dc, B:22:0x00e1, B:24:0x00e4, B:26:0x00e8, B:28:0x00ee, B:30:0x00fa, B:32:0x0100, B:39:0x0073, B:38:0x0079, B:36:0x0052), top: B:9:0x0015, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00b1 A[Catch: RemoteException -> 0x0106, TryCatch #2 {RemoteException -> 0x0106, blocks: (B:10:0x0015, B:15:0x0081, B:16:0x008d, B:18:0x00b1, B:19:0x00d4, B:21:0x00dc, B:22:0x00e1, B:24:0x00e4, B:26:0x00e8, B:28:0x00ee, B:30:0x00fa, B:32:0x0100, B:39:0x0073, B:38:0x0079, B:36:0x0052), top: B:9:0x0015, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00dc A[Catch: RemoteException -> 0x0106, TryCatch #2 {RemoteException -> 0x0106, blocks: (B:10:0x0015, B:15:0x0081, B:16:0x008d, B:18:0x00b1, B:19:0x00d4, B:21:0x00dc, B:22:0x00e1, B:24:0x00e4, B:26:0x00e8, B:28:0x00ee, B:30:0x00fa, B:32:0x0100, B:39:0x0073, B:38:0x0079, B:36:0x0052), top: B:9:0x0015, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0089  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static com.huawei.hms.ml.scan.HmsScanResult a(android.content.Context r12, com.huawei.hms.ml.scan.HmsScanFrame r13, com.huawei.hms.ml.scan.HmsScanAnalyzerOptions r14) {
        /*
            Method dump skipped, instructions count: 270
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.hmsscankit.f.a(android.content.Context, com.huawei.hms.ml.scan.HmsScanFrame, com.huawei.hms.ml.scan.HmsScanAnalyzerOptions):com.huawei.hms.ml.scan.HmsScanResult");
    }

    private static void a(Bundle bundle) {
        if (DynamicModuleInitializer.getContext() == null) {
            try {
                g.b(com.huawei.agconnect.d.b().getContext());
            } catch (ClassNotFoundException unused) {
                o4.b("ScankitRemoteDecoder", "buildBitmapLog ClassNotFoundException");
            } catch (IllegalAccessException unused2) {
                o4.b("ScankitRemoteDecoder", "buildBitmapLog IllegalAccessException");
            } catch (NoClassDefFoundError unused3) {
                o4.b("ScankitRemoteDecoder", "buildBitmapLog NoClassDefFoundError");
                return;
            } catch (NoSuchMethodException unused4) {
                o4.b("ScankitRemoteDecoder", "buildBitmapLog NoSuchMethodException");
            } catch (InvocationTargetException unused5) {
                o4.b("ScankitRemoteDecoder", "buildBitmapLog InvocationTargetException");
            } catch (Exception unused6) {
                o4.b("ScankitRemoteDecoder", "buildBitmapLog Exception");
            }
        }
        if (f33748a == null) {
            try {
                f33748a = new x3();
                f33748a.c(bundle);
            } catch (RuntimeException unused7) {
                o4.b("ScankitRemoteDecoder", "buildBitmapLog RuntimeException");
            } catch (Exception unused8) {
                o4.b("ScankitRemoteDecoder", "buildBitmapLog Exception");
            }
        }
    }

    public static Bundle a(String str, int i6, int i7, int i8, HmsBuildBitmapOption hmsBuildBitmapOption) {
        Bundle bundle = new Bundle();
        bundle.putInt("contentLength", str == null ? -1 : str.length());
        bundle.putInt("scanType", i6);
        bundle.putInt("reqWidth", i7);
        bundle.putInt("reqHeight", i8);
        bundle.putString("buildBitmapOption", hmsBuildBitmapOption == null ? "null" : hmsBuildBitmapOption.toString());
        bundle.putString(WiseOpenHianalyticsData.UNION_API_NAME, "BuildBitmap");
        bundle.putLong(WiseOpenHianalyticsData.UNION_CALLTIME, System.currentTimeMillis());
        bundle.putString("transId", UUID.randomUUID().toString());
        return bundle;
    }

    public static void a(int i6, Bitmap bitmap, Bundle bundle) {
        if (bundle != null) {
            bundle.putInt("result", i6);
            bundle.putInt("outputWidth", bitmap == null ? -1 : bitmap.getWidth());
            bundle.putInt("outputHeight", bitmap != null ? bitmap.getHeight() : -1);
            long j6 = bundle.getLong(WiseOpenHianalyticsData.UNION_CALLTIME);
            bundle.putLong(WiseOpenHianalyticsData.UNION_COSTTIME, System.currentTimeMillis() - j6);
            bundle.putString(WiseOpenHianalyticsData.UNION_CALLTIME, new a("yyyyMMddHHmmss.SSS").format(Long.valueOf(j6)));
            a(bundle);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static void a(android.content.Context r3) {
        /*
            java.lang.String r0 = "ScankitRemoteDecoder"
            android.content.Context r3 = com.huawei.hms.hmsscankit.g.e(r3)     // Catch: java.lang.Throwable -> L6 java.lang.InstantiationException -> L1e java.lang.ClassNotFoundException -> L24 java.lang.IllegalAccessException -> L2a
        L6:
            java.lang.ClassLoader r1 = r3.getClassLoader()     // Catch: java.lang.InstantiationException -> L1e java.lang.ClassNotFoundException -> L24 java.lang.IllegalAccessException -> L2a
            java.lang.String r2 = "com.huawei.hms.scankit.DecoderCreator"
            java.lang.Class r1 = r1.loadClass(r2)     // Catch: java.lang.InstantiationException -> L1e java.lang.ClassNotFoundException -> L24 java.lang.IllegalAccessException -> L2a
            java.lang.ClassLoader r3 = r3.getClassLoader()     // Catch: java.lang.InstantiationException -> L1e java.lang.ClassNotFoundException -> L24 java.lang.IllegalAccessException -> L2a
            java.lang.String r2 = "com.huawei.hms.scankit.aiscan.common.BarcodeFormat"
            r3.loadClass(r2)     // Catch: java.lang.InstantiationException -> L1e java.lang.ClassNotFoundException -> L24 java.lang.IllegalAccessException -> L2a
            java.lang.Object r3 = r1.newInstance()     // Catch: java.lang.InstantiationException -> L1e java.lang.ClassNotFoundException -> L24 java.lang.IllegalAccessException -> L2a
            goto L30
        L1e:
            java.lang.String r3 = "InstantiationException"
            com.huawei.hms.scankit.p.o4.a(r0, r3)
            goto L2f
        L24:
            java.lang.String r3 = "ClassNotFoundException"
            com.huawei.hms.scankit.p.o4.a(r0, r3)
            goto L2f
        L2a:
            java.lang.String r3 = "IllegalAccessException"
            com.huawei.hms.scankit.p.o4.a(r0, r3)
        L2f:
            r3 = 0
        L30:
            boolean r1 = r3 instanceof android.os.IBinder
            if (r1 == 0) goto L46
            android.os.IBinder r3 = (android.os.IBinder) r3
            com.huawei.hms.hmsscankit.api.IRemoteDecoderCreator r3 = com.huawei.hms.hmsscankit.api.IRemoteDecoderCreator.Stub.asInterface(r3)
            com.huawei.hms.hmsscankit.api.IRemoteFrameDecoderDelegate r3 = r3.newRemoteFrameDecoderDelegate()     // Catch: java.lang.Exception -> L41
            com.huawei.hms.hmsscankit.f.f33751d = r3     // Catch: java.lang.Exception -> L41
            goto L46
        L41:
            java.lang.String r3 = "remoteception"
            com.huawei.hms.scankit.p.o4.a(r0, r3)
        L46:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.hmsscankit.f.a(android.content.Context):void");
    }
}
