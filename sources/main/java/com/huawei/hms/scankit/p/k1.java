package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import java.util.Collection;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class k1 {

    /* renamed from: a, reason: collision with root package name */
    public static final Set<BarcodeFormat> f34482a;

    /* renamed from: b, reason: collision with root package name */
    public static final Set<BarcodeFormat> f34483b;

    /* renamed from: c, reason: collision with root package name */
    public static final Set<BarcodeFormat> f34484c;

    /* renamed from: d, reason: collision with root package name */
    public static final Set<BarcodeFormat> f34485d;

    /* renamed from: e, reason: collision with root package name */
    public static final Set<BarcodeFormat> f34486e;

    /* renamed from: f, reason: collision with root package name */
    public static final Set<BarcodeFormat> f34487f;

    /* renamed from: g, reason: collision with root package name */
    public static final Set<BarcodeFormat> f34488g;

    /* renamed from: h, reason: collision with root package name */
    private static final Map<String, Set<BarcodeFormat>> f34489h;

    static {
        EnumSet of = EnumSet.of(BarcodeFormat.QR_CODE);
        f34485d = of;
        EnumSet of2 = EnumSet.of(BarcodeFormat.AZTEC);
        f34486e = of2;
        EnumSet of3 = EnumSet.of(BarcodeFormat.DATA_MATRIX);
        f34487f = of3;
        EnumSet of4 = EnumSet.of(BarcodeFormat.PDF_417);
        f34488g = of4;
        EnumSet of5 = EnumSet.of(BarcodeFormat.CODE_39, BarcodeFormat.CODE_93, BarcodeFormat.CODE_128, BarcodeFormat.ITF, BarcodeFormat.CODABAR);
        f34484c = of5;
        EnumSet of6 = EnumSet.of(BarcodeFormat.UPC_A, BarcodeFormat.UPC_E, BarcodeFormat.EAN_13, BarcodeFormat.EAN_8);
        f34482a = of6;
        EnumSet copyOf = EnumSet.copyOf((Collection) of6);
        f34483b = copyOf;
        copyOf.addAll(of5);
        HashMap hashMap = new HashMap();
        f34489h = hashMap;
        hashMap.put("ONE_D_MODE", copyOf);
        hashMap.put("QR_CODE_MODE", of);
        hashMap.put("PRODUCT_MODE", of6);
        hashMap.put("AZTEC_MODE", of2);
        hashMap.put("DATA_MATRIX_MODE", of3);
        hashMap.put("PDF417_MODE", of4);
    }
}
