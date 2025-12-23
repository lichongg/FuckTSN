package com.bytedance.msdk.cw.j.j;

import a1.a;
import a1.b;
import android.app.Activity;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.bykv.j.j.j.j.f;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes3.dex */
public class r extends tl {
    @Override // com.bytedance.msdk.xt.cw
    public com.bytedance.sdk.openadsdk.i.cw.xt.ae j(Activity activity) {
        Object apply;
        if (((cw) this).oq == null) {
            return null;
        }
        apply = ((cw) this).oq.apply(com.bytedance.sdk.openadsdk.i.r.j().j(6072).j(Object.class).j(20033, activity).xt());
        if (apply == null) {
            return null;
        }
        final com.bytedance.sdk.openadsdk.mediation.xt.xt.m mVar = new com.bytedance.sdk.openadsdk.mediation.xt.xt.m(com.bytedance.sdk.openadsdk.p.cw.j(apply));
        return new com.bytedance.sdk.openadsdk.i.cw.xt.ae() { // from class: com.bytedance.msdk.cw.j.j.r.1
            @Override // com.bytedance.sdk.openadsdk.i.cw.xt.ae
            public boolean cw() {
                return false;
            }

            @Override // com.bytedance.sdk.openadsdk.i.cw.xt.ae
            public void j(String str) {
            }

            @Override // com.bytedance.sdk.openadsdk.i.cw.xt.ae
            public void j() {
                mVar.j();
            }

            @Override // com.bytedance.sdk.openadsdk.i.cw.xt.ae
            public void j(com.bytedance.sdk.openadsdk.kt.j.xt.j.j jVar) {
                mVar.j(new com.bytedance.msdk.j.r.j.j.xt(jVar));
            }

            @Override // com.bytedance.sdk.openadsdk.i.cw.xt.ae
            public void xt() {
            }
        };
    }

    @Override // com.bytedance.msdk.cw.j.j.cw, com.bytedance.msdk.xt.cw
    public Integer m() {
        Object apply;
        if (((cw) this).oq != null) {
            apply = ((cw) this).oq.apply(com.bytedance.sdk.openadsdk.i.r.j().j(8121).j(20068, 1).j(Object.class).xt());
            Integer j6 = com.bytedance.sdk.openadsdk.core.wq.j.j.j(apply);
            if (j6 != null) {
                return j6;
            }
        }
        return 1;
    }

    private void fz() {
        PluginValueSet xt = com.bytedance.sdk.openadsdk.i.cw.xt(((cw) this).oq);
        if (xt != null) {
            Map<String, Object> map = (Map) xt.objectValue(AVMDLDataLoader.KeyIsLiveCacheThresholdHttpToP2p, Map.class);
            String stringValue = xt.stringValue(8045);
            String stringValue2 = xt.stringValue(8046);
            String stringValue3 = xt.stringValue(8048);
            String stringValue4 = xt.stringValue(8049);
            String stringValue5 = xt.stringValue(8050);
            int intValue = xt.intValue(8051);
            int intValue2 = xt.intValue(8052);
            List<String> list = (List) xt.objectValue(8053, List.class);
            String stringValue6 = xt.stringValue(8054);
            double doubleValue = xt.doubleValue(8016);
            boolean booleanValue = xt.booleanValue(8033);
            int intValue3 = xt.intValue(8060);
            String stringValue7 = xt.stringValue(8061);
            double doubleValue2 = xt.doubleValue(8082);
            int intValue4 = xt.intValue(8420);
            int intValue5 = xt.intValue(8421);
            int intValue6 = xt.intValue(8059);
            Function a6 = b.a(xt.objectValue(8315, a.a()));
            if (doubleValue > 0.0d) {
                j(doubleValue);
            }
            cw(map);
            la(stringValue);
            gq(stringValue2);
            a(stringValue3);
            l(stringValue5);
            w(intValue2);
            mi(intValue);
            p(stringValue7);
            h(stringValue6);
            tj(intValue4);
            f(intValue5);
            r(doubleValue2);
            j(list);
            rn(stringValue4);
            ae(booleanValue);
            qv(intValue3);
            vl(intValue6);
            if (a6 != null) {
                com.bytedance.msdk.j.r.j.j.j jVar = new com.bytedance.msdk.j.r.j.j.j(a6);
                f(jVar.cw());
                v(jVar.r());
                xt(jVar.up());
                x(jVar.m());
                ch(jVar.tl());
                s(jVar.g());
                up(jVar.ae());
            }
        }
    }

    @Override // com.bytedance.msdk.xt.cw
    public String ae() {
        Object apply;
        if (((cw) this).oq == null) {
            return super.ae();
        }
        apply = ((cw) this).oq.apply(com.bytedance.sdk.openadsdk.i.r.j().j(8228).j(String.class).xt());
        if (apply instanceof String) {
            return apply.toString();
        }
        return null;
    }

    @Override // com.bytedance.msdk.xt.cw, com.bytedance.sdk.openadsdk.core.wq.r
    public <T> T applyFunction(int i6, PluginValueSet pluginValueSet, Class<T> cls) {
        if (i6 == 8134) {
            int intValue = pluginValueSet.intValue(8014);
            String stringValue = pluginValueSet.stringValue(8015);
            View view = (View) pluginValueSet.objectValue(8042, View.class);
            com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "Adn custom draw ad : callNativeRenderFail code:" + intValue + " msg:" + stringValue + " view" + view);
            j(view, stringValue, intValue);
        } else if (i6 == 8133) {
            float floatValue = pluginValueSet.floatValue(8040);
            float floatValue2 = pluginValueSet.floatValue(8041);
            com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "Adn custom draw ad : callNativeRenderSuccess width:" + floatValue + " height:" + floatValue2);
            j(floatValue, floatValue2);
        } else if (i6 == 8130) {
            com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "Adn custom draw ad : callNativeAdClick");
            m106if();
        } else if (i6 == 8113) {
            com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "Adn custom draw ad : callNativeAdShow");
            os();
        } else if (i6 == 8145) {
            com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "Adn custom draw ad : callNativeVideoStart");
            to();
        } else if (i6 == 8146) {
            com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "Adn custom draw ad : callNativeVideoPause");
            ej();
        } else if (i6 == 8150) {
            com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "Adn custom draw ad : callNativeVideoResume");
            so();
        } else if (i6 == 8118) {
            com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "Adn custom draw ad : callNativeVideoCompleted");
            ot();
        } else if (i6 == 8117) {
            int intValue2 = pluginValueSet.intValue(8014);
            String stringValue2 = pluginValueSet.stringValue(8015);
            com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "Adn custom draw ad : callNativeVideoError code:" + intValue2 + " msg:" + stringValue2);
            j(new com.bytedance.msdk.api.r.j.xt.j(intValue2, stringValue2));
        } else if (i6 == 8154) {
            long longValue = pluginValueSet.longValue(8072);
            long longValue2 = pluginValueSet.longValue(8073);
            com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "Adn custom draw ad : callNativeVideoError current:" + longValue + " duration:" + longValue2);
            j(longValue, longValue2);
        } else if (i6 == 8152) {
            com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "Adn custom draw ad : callNativeOnIdle");
            fk();
        } else if (i6 == 8187) {
            long longValue3 = pluginValueSet.longValue(8062);
            long longValue4 = pluginValueSet.longValue(8063);
            pluginValueSet.intValue(8064);
            pluginValueSet.intValue(8065);
            com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "Adn custom draw ad : callNativeOnDownloadActive totalBytes:" + longValue3 + " curlBytes:" + longValue4);
            j(longValue3, longValue4, "", "");
        } else if (i6 == 8158) {
            long longValue5 = pluginValueSet.longValue(8062);
            long longValue6 = pluginValueSet.longValue(8063);
            String stringValue3 = pluginValueSet.stringValue(8066);
            String stringValue4 = pluginValueSet.stringValue(8056);
            com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "Adn custom draw ad : callNativeOnDownloadPaused totalBytes:" + longValue5 + " curlBytes:" + longValue6 + " fileName:" + stringValue3 + " appName:" + stringValue4);
            xt(longValue5, longValue6, stringValue3, stringValue4);
        } else if (i6 == 8157) {
            long longValue7 = pluginValueSet.longValue(8062);
            long longValue8 = pluginValueSet.longValue(8063);
            String stringValue5 = pluginValueSet.stringValue(8066);
            String stringValue6 = pluginValueSet.stringValue(8056);
            com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "Adn custom draw ad : callNativeOnDownloadFailed totalBytes:" + longValue7 + " curlBytes:" + longValue8 + " fileName:" + stringValue5 + " appName:" + stringValue6);
            cw(longValue7, longValue8, stringValue5, stringValue6);
        } else if (i6 == 8155) {
            long longValue9 = pluginValueSet.longValue(8062);
            String stringValue7 = pluginValueSet.stringValue(8066);
            String stringValue8 = pluginValueSet.stringValue(8056);
            com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "Adn custom draw ad : callNativeOnDownloadFinished totalBytes:" + longValue9 + " fileName:" + stringValue7 + " appName:" + stringValue8);
            j(longValue9, stringValue7, stringValue8);
        } else if (i6 == 8156) {
            String stringValue9 = pluginValueSet.stringValue(8066);
            String stringValue10 = pluginValueSet.stringValue(8056);
            com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "Adn custom draw ad : callNativeOnDownloadFinished  fileName:" + stringValue9 + " appName:" + stringValue10);
            j(stringValue9, stringValue10);
        } else if (i6 == 8185) {
            com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "Adn custom draw ad : callNativeDislikeShow");
            ve();
        } else if (i6 == 8184) {
            com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "Adn custom draw ad : callNativeDislikeCancel");
            xj();
        } else if (i6 != 6085) {
            if (i6 == 8110) {
                boolean oy = oy();
                com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "Adn custom draw ad : isClientBiddingAd :".concat(String.valueOf(oy)));
                return (T) Boolean.valueOf(oy);
            }
            if (i6 == 8136) {
                boolean qo = qo();
                com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "Adn custom draw ad : isServerBiddingAd :".concat(String.valueOf(qo)));
                return (T) Boolean.valueOf(qo);
            }
            if (i6 == 8160) {
                boolean uf = uf();
                com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "Adn custom draw ad : isUseCustomVideo :".concat(String.valueOf(uf)));
                return (T) Boolean.valueOf(uf);
            }
            if (i6 == 8226) {
                int xw = xw();
                com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "Adn custom draw ad : getBiddingType :".concat(String.valueOf(xw)));
                return (T) Integer.valueOf(xw);
            }
            if (i6 == 8132) {
                int intValue3 = pluginValueSet.intValue(8038);
                String stringValue11 = pluginValueSet.stringValue(8039);
                com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "Adn custom draw ad : callNativeDislikeSelected postion:" + intValue3 + " value:" + stringValue11);
                j(intValue3, stringValue11);
            }
        }
        return (T) com.bytedance.msdk.core.av.j.j(cls);
    }

    @Override // com.bytedance.msdk.cw.j.j.cw, com.bytedance.msdk.xt.cw
    public void av() {
        if (((cw) this).oq != null) {
            ((cw) this).oq.apply(com.bytedance.sdk.openadsdk.i.r.j().j(8149).j(Void.class).xt());
        }
    }

    @Override // com.bytedance.msdk.xt.cw
    public View g() {
        Object apply;
        if (((cw) this).oq == null) {
            return super.g();
        }
        apply = ((cw) this).oq.apply(com.bytedance.sdk.openadsdk.i.r.j().j(6081).j(View.class).xt());
        if (apply instanceof View) {
            return (View) apply;
        }
        return null;
    }

    @Override // com.bytedance.msdk.cw.j.j.cw, com.bytedance.msdk.xt.cw
    public void i() {
        if (((cw) this).oq != null) {
            ((cw) this).oq.apply(com.bytedance.sdk.openadsdk.i.r.j().j(8148).j(Void.class).xt());
        }
    }

    /* renamed from: if, reason: not valid java name */
    public void m106if() {
        j(new j() { // from class: com.bytedance.msdk.cw.j.j.r.2
            @Override // com.bytedance.msdk.cw.j.j.j
            public void j() {
                if (r.this.az() != null) {
                    r.this.az().j(null);
                }
            }
        });
    }

    @Override // com.bytedance.msdk.xt.cw
    public boolean kt() {
        Object apply;
        if (((cw) this).oq == null) {
            return super.kt();
        }
        apply = ((cw) this).oq.apply(com.bytedance.sdk.openadsdk.i.r.j().j(8135).j(Boolean.class).xt());
        return (apply instanceof Boolean) && ((Boolean) apply).booleanValue();
    }

    public void os() {
        xt(new j() { // from class: com.bytedance.msdk.cw.j.j.r.3
            @Override // com.bytedance.msdk.cw.j.j.j
            public void j() {
                if (r.this.az() != null) {
                    r.this.az().j();
                }
            }
        });
    }

    @Override // com.bytedance.msdk.xt.cw
    public com.bytedance.msdk.api.r.j.ae.up tl() {
        Object apply;
        if (((cw) this).oq != null) {
            apply = ((cw) this).oq.apply(com.bytedance.sdk.openadsdk.i.r.j().j(8320).j(a.a()).xt());
            if (f.a(apply)) {
                return com.bytedance.msdk.core.j.j.j(b.a(apply));
            }
        }
        return super.tl();
    }

    @Override // com.bytedance.msdk.cw.j.j.cw, com.bytedance.msdk.xt.cw
    public void w() {
        if (((cw) this).oq != null) {
            ((cw) this).oq.apply(com.bytedance.sdk.openadsdk.i.r.j().j(8109).j(Void.class).xt());
        }
    }

    public r(com.bytedance.msdk.cw.cw.xt.j.j.xt xtVar, Function<SparseArray<Object>, Object> function) {
        super(xtVar, function);
        if (function != null) {
            function.apply(com.bytedance.sdk.openadsdk.i.r.j().j(8127).j(Void.class).j(8034, this).xt());
            fz();
        }
    }

    public void cw(long j6, long j7, String str, String str2) {
        if (ws() != null) {
            ws().xt(j6, j7, str, str2);
        }
    }

    public void ej() {
        if (jy() != null) {
            jy().cw();
        }
    }

    public void fk() {
        if (ws() != null) {
            ws().j();
        }
    }

    public void ot() {
        if (jy() != null) {
            jy().up();
        }
    }

    public void so() {
        if (jy() != null) {
            jy().r();
        }
    }

    public void to() {
        if (jy() != null) {
            jy().xt();
        }
    }

    public void ve() {
        if (mi() != null) {
            mi().j();
        }
    }

    public void xj() {
        if (mi() != null) {
            mi().xt();
        }
    }

    public void xt(long j6, long j7, String str, String str2) {
        if (ws() != null) {
            ws().j(j6, j7, str, str2);
        }
    }

    @Override // com.bytedance.msdk.cw.j.j.cw
    public void j(boolean z5, double d6, int i6, Map<String, Object> map) {
        super.j(z5, d6, i6, map);
        if (((cw) this).oq != null) {
            ((cw) this).oq.apply(com.bytedance.sdk.openadsdk.i.r.j().j(8225).j(Void.class).j(8406, Boolean.valueOf(z5)).j(8407, Double.valueOf(d6)).j(8408, Integer.valueOf(i6)).j(8075, map).xt());
        }
    }

    @Override // com.bytedance.msdk.cw.j.j.tl
    public void j(@NonNull Activity activity, @NonNull ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, com.bytedance.msdk.api.r.j.ae.oq oqVar) {
        if (((cw) this).oq != null) {
            ((cw) this).oq.apply(com.bytedance.sdk.openadsdk.i.r.j().j(8159).j(Void.class).j(20033, activity).j(8067, viewGroup).j(8068, list).j(8069, list2).j(8070, list3).j(8071, com.bytedance.msdk.api.r.j.ae.oq.j(oqVar)).xt());
        }
    }

    public void j(View view, String str, int i6) {
        if (az() instanceof com.bytedance.msdk.api.r.j.cw.r) {
            try {
                ((com.bytedance.msdk.api.r.j.cw.r) az()).j(view, str, i6);
            } catch (Exception e6) {
                vl.j(e6);
            }
        }
    }

    public void j(float f6, float f7) {
        if (az() instanceof com.bytedance.msdk.api.r.j.cw.r) {
            try {
                ((com.bytedance.msdk.api.r.j.cw.r) az()).j(f6, f7);
            } catch (Exception e6) {
                vl.j(e6);
            }
        }
    }

    public void j(com.bytedance.msdk.api.r.j.xt.j jVar) {
        if (jy() != null) {
            jy().j(new com.bytedance.msdk.api.j(49012, com.bytedance.msdk.api.j.j(49012), jVar == null ? -1 : jVar.j(), jVar == null ? "" : jVar.xt()));
        }
    }

    public void j(long j6, long j7) {
        if (jy() != null) {
            jy().j(j6, j7);
        }
    }

    public void j(long j6, long j7, String str, String str2) {
        if (ws() != null) {
            ws().j(j6, j7, -1, 1, str, str2);
        }
    }

    public void j(long j6, String str, String str2) {
        if (ws() != null) {
            ws().j(j6, str, str2);
        }
    }

    public void j(String str, String str2) {
        if (ws() != null) {
            ws().j(str, str2);
        }
    }

    public void j(int i6, String str) {
        com.bytedance.msdk.cw.cw.xt.j.j.xt xtVar = ((cw) this).f24993g;
        if (xtVar != null) {
            xtVar.j(this, str);
        }
        if (mi() != null) {
            mi().j(i6, str, false);
        }
    }
}
