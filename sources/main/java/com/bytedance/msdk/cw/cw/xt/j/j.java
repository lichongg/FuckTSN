package com.bytedance.msdk.cw.cw.xt.j;

import a1.a;
import a1.b;
import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bykv.j.j.j.j.e;
import com.bykv.j.j.j.j.f;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.msdk.core.j.j.up;
import com.bytedance.msdk.core.oq.oq;
import com.bytedance.msdk.cw.j.ae;
import com.bytedance.msdk.cw.j.g;
import com.bytedance.msdk.cw.j.m;
import com.bytedance.msdk.cw.j.tl;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes3.dex */
public class j implements Function<SparseArray<Object>, Object> {
    private oq ae;
    private int cw;

    /* renamed from: j, reason: collision with root package name */
    private cw f24865j;

    /* renamed from: m, reason: collision with root package name */
    private com.bytedance.msdk.api.j.xt f24866m;

    /* renamed from: r, reason: collision with root package name */
    private Function<SparseArray<Object>, Object> f24867r;
    private com.bytedance.msdk.cw.m.xt.xt up;
    private int xt;

    public String j(Context context, String str, Object obj) {
        Object apply;
        if (this.f24867r != null) {
            apply = this.f24867r.apply(com.bytedance.sdk.openadsdk.i.r.j().j(8139).j(AVMDLDataLoader.KeyIsLiveWaitP2pReadyThreshold, context).j(AVMDLDataLoader.KeyIsLiveCacheThresholdP2pToHttp, str).j(8044, obj).j(String.class).xt());
            if (apply instanceof String) {
                return apply.toString();
            }
        }
        return null;
    }

    public j(com.bytedance.msdk.api.j.xt xtVar, com.bytedance.msdk.cw.m.xt.xt xtVar2, cw cwVar) {
        this.xt = xtVar.f();
        this.f24866m = xtVar;
        this.cw = xtVar2.az();
        this.up = xtVar2;
        this.f24865j = cwVar;
        this.ae = xtVar2.tl();
    }

    @Override // java.util.function.Function
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        Object apply;
        Object apply2;
        if (sparseArray == null) {
            return null;
        }
        PluginValueSet k6 = e.i(sparseArray).k();
        int intValue = k6.intValue(-99999987);
        Class cls = (Class) k6.objectValue(-99999985, Class.class);
        if (intValue == 8108) {
            this.f24865j.j(new com.bytedance.msdk.api.j(k6.intValue(8014), k6.stringValue(8015)));
        } else if (intValue == 8112) {
            Function a6 = b.a(k6.objectValue(8303, a.a()));
            int intValue2 = k6.intValue(8014);
            String stringValue = k6.stringValue(8015);
            ArrayList arrayList = new ArrayList(1);
            if (a6 instanceof com.bytedance.msdk.xt.cw) {
                arrayList.add((com.bytedance.msdk.xt.cw) a6);
            } else if (f.a(a6)) {
                apply2 = a6.apply(com.bytedance.sdk.openadsdk.i.r.j().j(-99999977).xt());
                if (apply2 instanceof com.bytedance.msdk.xt.cw) {
                    arrayList.add((com.bytedance.msdk.xt.cw) apply2);
                }
            }
            this.f24865j.j(arrayList, new com.bytedance.msdk.api.j(intValue2, stringValue));
        } else if (intValue == 8107) {
            List list = (List) k6.objectValue(8303, List.class);
            ArrayList arrayList2 = new ArrayList();
            if (list != null && !list.isEmpty()) {
                for (Object obj : list) {
                    if (obj instanceof com.bytedance.msdk.xt.cw) {
                        arrayList2.add((com.bytedance.msdk.xt.cw) obj);
                    } else if (f.a(obj)) {
                        apply = b.a(obj).apply(com.bytedance.sdk.openadsdk.i.r.j().j(-99999977).xt());
                        if (apply instanceof com.bytedance.msdk.xt.cw) {
                            arrayList2.add((com.bytedance.msdk.xt.cw) apply);
                        }
                    }
                }
            }
            this.f24865j.j(arrayList2);
        } else {
            if (intValue == 8127) {
                return j();
            }
            if (intValue == 8110) {
                return Boolean.valueOf(this.up.j());
            }
            if (intValue == 8136) {
                return Boolean.valueOf(this.up.v());
            }
            if (intValue == 8141) {
                return Boolean.valueOf(this.up.x());
            }
            if (intValue == 8137) {
                return this.up.ch();
            }
            if (intValue == 8226) {
                return Integer.valueOf(this.up.mi());
            }
            if (intValue == 8138) {
                this.f24867r = b.a(k6.objectValue(8043, a.a()));
            } else {
                if (intValue == 8210) {
                    return Boolean.valueOf(this.f24865j.j());
                }
                if (intValue == 20000) {
                    Function<SparseArray<Object>, Object> a7 = b.a(k6.objectValue(10010, a.a()));
                    String str = (String) k6.objectValue(10011, String.class);
                    Context context = (Context) k6.objectValue(10000, Context.class);
                    if (a7 != null && !TextUtils.isEmpty(str) && this.f24866m != null && this.ae != null) {
                        com.bytedance.msdk.core.j.j.j.j xt = up.xt(str, this.xt, this.cw);
                        if (xt != null) {
                            up.j(this.f24866m);
                            xt.j(context, a7, this.f24866m, this.ae, new com.bytedance.msdk.core.j.j.j.xt() { // from class: com.bytedance.msdk.cw.cw.xt.j.j.1
                                @Override // com.bytedance.msdk.core.j.j.j.xt
                                public void j(List<com.bytedance.msdk.xt.cw> list2) {
                                    if (j.this.f24865j != null) {
                                        j.this.f24865j.j(list2);
                                    }
                                }

                                @Override // com.bytedance.msdk.core.j.j.j.xt
                                public void j(com.bytedance.msdk.xt.cw cwVar, com.bytedance.msdk.api.j jVar) {
                                    if (j.this.f24865j != null) {
                                        j.this.f24865j.j(cwVar, jVar);
                                    }
                                }

                                @Override // com.bytedance.msdk.core.j.j.j.xt
                                public void j(int i6, String str2) {
                                    if (j.this.f24865j != null) {
                                        j.this.f24865j.j(new com.bytedance.msdk.api.j(i6, str2));
                                    }
                                }
                            });
                        } else {
                            up.xt(this.f24866m);
                        }
                    } else {
                        up.xt(this.f24866m);
                    }
                }
            }
        }
        return com.bytedance.msdk.core.av.j.j(cls);
    }

    private com.bytedance.msdk.xt.cw j() {
        switch (this.xt) {
            case 1:
                return new com.bytedance.msdk.cw.j.cw(this.up);
            case 2:
                return new m(this.up);
            case 3:
                return new g(this.up);
            case 4:
            case 6:
            default:
                return null;
            case 5:
                int i6 = this.cw;
                if (i6 == 4) {
                    return new ae(this.up, this.f24865j);
                }
                if (i6 == 3) {
                    return new com.bytedance.msdk.cw.j.cw(this.up);
                }
                if (i6 == 5) {
                    return new ae(this.up, this.f24865j);
                }
                return new ae(this.up, this.f24865j);
            case 7:
                int i7 = this.cw;
                if (i7 == 6) {
                    return new tl(this.up);
                }
                if (i7 == 7) {
                    return new com.bytedance.msdk.cw.j.up(this.up);
                }
                return new tl(this.up);
            case 8:
                return new com.bytedance.msdk.cw.j.up(this.up);
            case 9:
                return new ae(this.up, this.f24865j);
            case 10:
                int i8 = this.cw;
                if (i8 == 1) {
                    return new m(this.up);
                }
                if (i8 == 2) {
                    return new com.bytedance.msdk.cw.j.up(this.up);
                }
                return null;
        }
    }
}
