package com.tencent.open.log;

import com.baidu.mobads.sdk.internal.bn;
import com.tencent.connect.common.Constants;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.io.File;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static int f40605a = 60;

    /* renamed from: b, reason: collision with root package name */
    public static int f40606b = 60;

    /* renamed from: c, reason: collision with root package name */
    public static String f40607c = "OpenSDK.Client.File.Tracer";

    /* renamed from: d, reason: collision with root package name */
    public static String f40608d;

    /* renamed from: e, reason: collision with root package name */
    public static String f40609e;

    /* renamed from: f, reason: collision with root package name */
    public static long f40610f;

    /* renamed from: g, reason: collision with root package name */
    public static int f40611g;

    /* renamed from: h, reason: collision with root package name */
    public static int f40612h;

    /* renamed from: i, reason: collision with root package name */
    public static int f40613i;

    /* renamed from: j, reason: collision with root package name */
    public static String f40614j;

    /* renamed from: k, reason: collision with root package name */
    public static String f40615k;

    /* renamed from: l, reason: collision with root package name */
    public static String f40616l;

    /* renamed from: m, reason: collision with root package name */
    public static int f40617m;

    /* renamed from: n, reason: collision with root package name */
    public static long f40618n;

    /* renamed from: o, reason: collision with root package name */
    public static String f40619o;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append("Tencent");
        String str = File.separator;
        sb.append(str);
        sb.append("msflogs");
        sb.append(str);
        sb.append("com");
        sb.append(str);
        sb.append(SocializeProtocolConstants.PROTOCOL_KEY_TENCENT);
        sb.append(str);
        sb.append("mobileqq");
        sb.append(str);
        f40608d = sb.toString();
        f40609e = ".log";
        f40610f = 8388608L;
        f40611g = 262144;
        f40612h = 1024;
        f40613i = 10000;
        f40614j = "debug.file.blockcount";
        f40615k = "debug.file.keepperiod";
        f40616l = "debug.file.tracelevel";
        f40617m = 24;
        f40618n = bn.f10748d;
        f40619o = Constants.APP_SPECIFIC_ROOT + str + "logs";
    }
}
