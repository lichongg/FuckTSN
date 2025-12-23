package com.bytedance.msdk.core.g;

import android.text.TextUtils;
import com.bytedance.msdk.core.oq.oq;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\Downloads\app\classes3.dex */
public class cw {
    protected static List<oq> j(com.bytedance.msdk.core.oq.xt xtVar, String str) {
        return j(xtVar, str, 0.0d, 0.0d);
    }

    public static List<oq> j(com.bytedance.msdk.core.oq.xt xtVar, String str, double d6, double d7) {
        int i6;
        double d8;
        if (xtVar == null || TextUtils.isEmpty(str)) {
            return null;
        }
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        com.bytedance.msdk.core.oq.r up = com.bytedance.msdk.core.xt.xt().up(str);
        if (up != null) {
            double j6 = up.j();
            double xt = up.xt();
            int cw = up.cw();
            if (xtVar.m() == 3 || xtVar.m() == 4) {
                i6 = 1;
                double[] j7 = xt.r().j(xtVar.m(), d6, d7, xtVar.la(), str);
                d8 = j7[0];
                xtVar.up().put("price_from", Integer.valueOf((int) j7[1]));
            } else {
                d8 = xtVar.m() == 2 ? xt.r().j(3, str, cw) : 0.0d;
                i6 = 1;
            }
            if (!up.up() && d8 > 0.0d) {
                if (up.getType() == i6) {
                    xt(d8, j6, xt, xtVar, copyOnWriteArrayList);
                } else if (up.getType() == 2) {
                    j(d8, j6, xt, xtVar, copyOnWriteArrayList);
                }
                List<com.bytedance.msdk.core.oq.cw> m6 = com.bytedance.msdk.core.xt.xt().m(String.valueOf(xtVar.wq()));
                if (m6 != null) {
                    Iterator<com.bytedance.msdk.core.oq.cw> it = m6.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        com.bytedance.msdk.core.oq.cw next = it.next();
                        if (d8 > next.m() && d8 <= next.up()) {
                            xtVar.up().put("user_label_value", next);
                            break;
                        }
                    }
                }
            }
            xtVar.up().put("rule_id", up.r());
            xtVar.up().put("ecpm", Double.valueOf(d8));
            xtVar.up().put("rule_in_use", Integer.valueOf(copyOnWriteArrayList.size() == 0 ? 0 : 1));
            xtVar.up().put("group_type", Integer.valueOf(xtVar.m()));
        }
        if (com.bytedance.msdk.j.up.cw.xt()) {
            if (copyOnWriteArrayList.size() != 0) {
                for (int i7 = 0; i7 < copyOnWriteArrayList.size(); i7++) {
                    com.bytedance.msdk.j.up.cw.j("DynamicRuleCalculate", "rit：" + ((oq) copyOnWriteArrayList.get(i7)).w() + ",level：" + ((oq) copyOnWriteArrayList.get(i7)).x());
                }
            } else {
                com.bytedance.msdk.j.up.cw.j("DynamicRuleCalculate", "走原waterfall，inUse ： 不生效");
            }
        }
        return copyOnWriteArrayList.size() != 0 ? copyOnWriteArrayList : xtVar.ol();
    }

    private static void xt(double d6, double d7, double d8, com.bytedance.msdk.core.oq.xt xtVar, List<oq> list) {
        if (d7 < d8 || d7 <= 0.0d || d6 < xtVar.x()) {
            return;
        }
        if (d6 > xtVar.v() && d8 <= 0.0d) {
            list.addAll(xtVar.ol());
            return;
        }
        BigDecimal valueOf = BigDecimal.valueOf(d6 * d7);
        RoundingMode roundingMode = RoundingMode.HALF_UP;
        double doubleValue = valueOf.setScale(2, roundingMode).doubleValue();
        double doubleValue2 = BigDecimal.valueOf(d6 * d8).setScale(2, roundingMode).doubleValue();
        List<oq> ol = xtVar.ol();
        double d9 = -1.0d;
        double d10 = -1.0d;
        for (int i6 = 0; i6 < ol.size(); i6++) {
            oq oqVar = ol.get(i6);
            if (oqVar.mi() == 0) {
                double doubleValue3 = BigDecimal.valueOf(oqVar.v()).setScale(2, RoundingMode.HALF_UP).doubleValue();
                if (doubleValue3 <= doubleValue && doubleValue3 >= doubleValue2) {
                    if (d9 == -1.0d || d9 < oqVar.v()) {
                        d9 = oqVar.v();
                    }
                    if (d10 == -1.0d || d10 > oqVar.v()) {
                        d10 = oqVar.v();
                    }
                    list.add(oqVar);
                }
            } else {
                list.add(oqVar);
            }
        }
        xtVar.up().put("max_ecpm", Double.valueOf(d9));
        xtVar.up().put("min_ecpm", Double.valueOf(d10));
        xtVar.up().put("upper_cpm_x", Double.valueOf(doubleValue));
    }

    private static void j(double d6, double d7, double d8, com.bytedance.msdk.core.oq.xt xtVar, List<oq> list) {
        if (xtVar == null || d7 == 0.0d || d6 < xtVar.x()) {
            return;
        }
        if (d6 > xtVar.v() && d8 <= 0.0d) {
            list.addAll(xtVar.ol());
        } else {
            j(xtVar, d6, d7, d8, list);
        }
    }

    public static void j(com.bytedance.msdk.core.oq.xt xtVar, double d6, double d7, double d8, List<oq> list) {
        double d9;
        Map<Integer, List<oq>> rh = xtVar.rh();
        if (rh != null) {
            ArrayList arrayList = new ArrayList(rh.keySet());
            ArrayList arrayList2 = new ArrayList();
            int i6 = 0;
            for (int i7 = 0; i7 < arrayList.size(); i7++) {
                if (((Integer) arrayList.get(i7)).intValue() > 0) {
                    arrayList2.add(arrayList.get(i7));
                } else {
                    List<oq> list2 = rh.get(arrayList.get(i7));
                    if (list2 != null) {
                        list.addAll(list2);
                    }
                }
            }
            com.bytedance.msdk.core.ae.xt.j(arrayList2);
            int size = arrayList2.size();
            if (size <= 0) {
                return;
            }
            int i8 = -1;
            int i9 = size;
            for (int i10 = 0; i10 < arrayList2.size(); i10++) {
                double d10 = i10;
                List<oq> list3 = rh.get(arrayList2.get(i10));
                if (list3 != null) {
                    int i11 = 0;
                    while (true) {
                        if (i11 >= list3.size()) {
                            break;
                        }
                        oq oqVar = list3.get(i11);
                        if (oqVar != null && oqVar.mi() == 0) {
                            double doubleValue = BigDecimal.valueOf(oqVar.v()).setScale(2, RoundingMode.HALF_UP).doubleValue();
                            if (d6 == doubleValue) {
                                if (i8 < 0) {
                                    i8 = Math.max((int) (d10 - d7), 0);
                                }
                                if (i9 == size || d6 == doubleValue) {
                                    if (d8 > 0.0d) {
                                        i9 = Math.min((int) (d10 + d8), size - 1);
                                    }
                                }
                            } else if (d6 > doubleValue) {
                                if (i8 < 0) {
                                    d9 = 2.0d;
                                    i8 = Math.max((int) Math.ceil(((d10 + (d10 - 1.0d)) / 2.0d) - d7), 0);
                                } else {
                                    d9 = 2.0d;
                                }
                                if (i9 == size) {
                                    if (d8 > 0.0d) {
                                        i9 = Math.min((int) Math.floor(((d10 + (d10 - 1.0d)) / d9) + d8), size - 1);
                                    }
                                }
                            }
                        }
                        i11++;
                    }
                    i9 = size - 1;
                }
            }
            if (i8 < 0) {
                i8 = 0;
            }
            if (i9 >= size) {
                i9 = size - 1;
            }
            int i12 = i8;
            double d11 = -1.0d;
            double d12 = -1.0d;
            double d13 = -1.0d;
            while (i12 <= i9) {
                List<oq> list4 = rh.get(arrayList2.get(i12));
                if (list4 != null && list4.size() != 0) {
                    while (i6 < list4.size()) {
                        oq oqVar2 = list4.get(i6);
                        if (oqVar2 != null) {
                            if (d12 < oqVar2.v() || d12 == -1.0d) {
                                d12 = oqVar2.v();
                            }
                            if (d13 > oqVar2.v() || d13 == -1.0d) {
                                d13 = oqVar2.v();
                            }
                            list.add(oqVar2);
                            if (i12 == i8) {
                                d11 = d12;
                            }
                        }
                        i6++;
                    }
                }
                i12++;
                i6 = 0;
            }
            xtVar.up().put("upper_cpm_x", Double.valueOf(d11));
            xtVar.up().put("max_ecpm", Double.valueOf(d12));
            xtVar.up().put("min_ecpm", Double.valueOf(d13));
        }
    }
}
