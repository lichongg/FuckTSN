package com.hp.hpl.sparta.xpath;

import com.huawei.hms.framework.common.ContainerUtils;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.io.IOException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class n {
    static k a(c0 c0Var, s sVar) throws XPathException, IOException {
        int parseInt;
        int parseInt2;
        int i6 = sVar.f32892a;
        if (i6 == -3) {
            if (!sVar.f32894c.equals(com.baidu.mobads.sdk.internal.a.f10501b)) {
                throw new XPathException(c0Var, "at beginning of expression", sVar, "text()");
            }
            if (sVar.a() != 40) {
                throw new XPathException(c0Var, "after text", sVar, "(");
            }
            if (sVar.a() != 41) {
                throw new XPathException(c0Var, "after text(", sVar, ")");
            }
            int a6 = sVar.a();
            if (a6 != 33) {
                if (a6 != 61) {
                    return w.f32906a;
                }
                sVar.a();
                int i7 = sVar.f32892a;
                if (i7 != 34 && i7 != 39) {
                    throw new XPathException(c0Var, "right hand side of equals", sVar, "quoted string");
                }
                String str = sVar.f32894c;
                sVar.a();
                return new v(str);
            }
            sVar.a();
            if (sVar.f32892a != 61) {
                throw new XPathException(c0Var, "after !", sVar, ContainerUtils.KEY_VALUE_DELIMITER);
            }
            sVar.a();
            int i8 = sVar.f32892a;
            if (i8 != 34 && i8 != 39) {
                throw new XPathException(c0Var, "right hand side of !=", sVar, "quoted string");
            }
            String str2 = sVar.f32894c;
            sVar.a();
            return new x(str2);
        }
        if (i6 == -2) {
            int i9 = sVar.f32893b;
            sVar.a();
            return new r(i9);
        }
        if (i6 != 64) {
            throw new XPathException(c0Var, "at beginning of expression", sVar, "@, number, or text()");
        }
        if (sVar.a() != -3) {
            throw new XPathException(c0Var, "after @", sVar, CommonNetImpl.NAME);
        }
        String str3 = sVar.f32894c;
        int a7 = sVar.a();
        if (a7 == 33) {
            sVar.a();
            if (sVar.f32892a != 61) {
                throw new XPathException(c0Var, "after !", sVar, ContainerUtils.KEY_VALUE_DELIMITER);
            }
            sVar.a();
            int i10 = sVar.f32892a;
            if (i10 != 34 && i10 != 39) {
                throw new XPathException(c0Var, "right hand side of !=", sVar, "quoted string");
            }
            String str4 = sVar.f32894c;
            sVar.a();
            return new h(str3, str4);
        }
        switch (a7) {
            case 60:
                sVar.a();
                int i11 = sVar.f32892a;
                if (i11 == 34 || i11 == 39) {
                    parseInt = Integer.parseInt(sVar.f32894c);
                } else {
                    if (i11 != -2) {
                        throw new XPathException(c0Var, "right hand side of less-than", sVar, "quoted string or number");
                    }
                    parseInt = sVar.f32893b;
                }
                sVar.a();
                return new g(str3, parseInt);
            case 61:
                sVar.a();
                int i12 = sVar.f32892a;
                if (i12 != 34 && i12 != 39) {
                    throw new XPathException(c0Var, "right hand side of equals", sVar, "quoted string");
                }
                String str5 = sVar.f32894c;
                sVar.a();
                return new c(str3, str5);
            case 62:
                sVar.a();
                int i13 = sVar.f32892a;
                if (i13 == 34 || i13 == 39) {
                    parseInt2 = Integer.parseInt(sVar.f32894c);
                } else {
                    if (i13 != -2) {
                        throw new XPathException(c0Var, "right hand side of greater-than", sVar, "quoted string or number");
                    }
                    parseInt2 = sVar.f32893b;
                }
                sVar.a();
                return new f(str3, parseInt2);
            default:
                return new d(str3);
        }
    }
}
