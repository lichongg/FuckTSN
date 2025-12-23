package com.bytedance.sdk.openadsdk.g;

import com.bytedance.sdk.component.m.g;
import com.bytedance.sdk.component.m.kt;
import com.bytedance.sdk.openadsdk.ats.ATSMethod;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw implements kt {

    /* renamed from: j, reason: collision with root package name */
    private static int f31375j;
    private long cw;

    /* renamed from: r, reason: collision with root package name */
    private boolean f31376r;
    private String up;
    private long xt = 0;

    private String cw(String str, g gVar) {
        com.bytedance.sdk.component.m.cw.j mi;
        if (str == null) {
            return str;
        }
        switch (str) {
            case "success":
                return "成功";
            case "raw_cache":
                return "查询RAW内存缓存";
            case "image_type":
                return "判断图片类型：";
            case "disk_cache":
                return "查询文件缓存";
            case "decode":
                return "解码";
            case "failed":
                if (!(gVar instanceof com.bytedance.sdk.component.m.cw.cw) || (mi = ((com.bytedance.sdk.component.m.cw.cw) gVar).mi()) == null) {
                    return "失败";
                }
                Throwable cw = mi.cw();
                StringBuilder sb = new StringBuilder("失败：code:");
                sb.append(mi.j());
                sb.append(", msg:");
                sb.append(mi.xt());
                sb.append(", exception:");
                sb.append(cw != null ? cw.getMessage() : "null \r\n");
                return sb.toString();
            case "check_duplicate":
                return "检查重复请求";
            case "memory_cache":
                return "查询Bitmap内存缓存";
            case "net_request":
                return "请求网络";
            case "generate_key":
                return "生成KEY:" + gVar.ae();
            case "cache_policy":
                return "查询缓存策略";
            default:
                return str;
        }
    }

    @Override // com.bytedance.sdk.component.m.kt
    @ATSMethod(1)
    public void j(String str, g gVar) {
        if (!this.f31376r) {
            gVar.xt();
            gVar.cw();
            gVar.r();
            this.f31376r = true;
        }
        this.xt = System.currentTimeMillis();
        cw(str, gVar);
    }

    public cw() {
        f31375j++;
        this.up = "image_request_" + f31375j;
    }

    @Override // com.bytedance.sdk.component.m.kt
    @ATSMethod(2)
    public void xt(String str, g gVar) {
        this.cw += System.currentTimeMillis() - this.xt;
        cw(str, gVar);
    }
}
