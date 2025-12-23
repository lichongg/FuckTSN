package com.beizi.fusion.e;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.tool.aa;
import com.beizi.fusion.tool.ao;
import com.beizi.fusion.tool.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import xyz.adscope.amps.common.AMPSConstants;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class b {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static List<AdSpacesBean.ForwardBean> a(AdSpacesBean.ComponentBean componentBean, List<AdSpacesBean.BuyerBean> list, String str) {
        String content;
        ArrayList arrayList = new ArrayList();
        if (componentBean != null && list != null && list.size() != 0 && (content = componentBean.getContent()) != null) {
            switch (content) {
                case "random":
                    a(componentBean, arrayList);
                    break;
                case "fail":
                    a(componentBean, list, str, arrayList, "280.500");
                    return arrayList;
                case "show":
                    a(componentBean, list, str, arrayList, "280.300");
                    return arrayList;
                case "click":
                    a(componentBean, list, str, arrayList, "290.300");
                    return arrayList;
                case "request":
                    a(componentBean, list, str, arrayList, "200.000");
                    return arrayList;
            }
        }
        return arrayList;
    }

    private static boolean b(List<AdSpacesBean.RulesBean> list, int i6) {
        boolean z5;
        if (list == null) {
            return false;
        }
        if (list.size() == 0) {
            aa.c("BeiZis", "enter rulesBeanList.size() == 0");
            z5 = true;
        } else {
            z5 = false;
        }
        for (int i7 = 0; i7 < list.size(); i7++) {
            if (a(list.get(i7), i6)) {
                return true;
            }
        }
        return z5;
    }

    private static String c(String str) {
        aa.a("BeiZis", "enter convertSelfChannel buyerId = " + str);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return ao.b().equals(str) ? "BEIZI" : str;
    }

    public static String b(String str) {
        if (str == null) {
            return null;
        }
        if (!ao.b().equalsIgnoreCase(str) && !"BEIZI".equalsIgnoreCase(str)) {
            if (str.equals("ADSCOPE")) {
                return AMPSConstants.ChannelName.CHANNEL_NAME_ASNP;
            }
            return null;
        }
        return "6666";
    }

    private static void a(AdSpacesBean.ComponentBean componentBean, List<AdSpacesBean.BuyerBean> list, String str, List<AdSpacesBean.ForwardBean> list2, String str2) {
        aa.c("BeiZis", "enter handleSpaceStrategyByEvent eventCode = " + str2);
        List<AdSpacesBean.ForwardBean> forward = componentBean.getForward();
        if (forward == null || forward.size() <= 0) {
            return;
        }
        int a6 = s.a(str, str2);
        if (!str2.equalsIgnoreCase("200.000")) {
            a6++;
        }
        for (int i6 = 0; i6 < forward.size(); i6++) {
            AdSpacesBean.ForwardBean forwardBean = forward.get(i6);
            for (int i7 = 0; i7 < list.size(); i7++) {
                AdSpacesBean.BuyerBean buyerBean = list.get(i7);
                if (buyerBean.getId() != null && buyerBean.getId().equalsIgnoreCase(forwardBean.getBuyerId()) && buyerBean.getBuyerSpaceUuId() != null && buyerBean.getBuyerSpaceUuId().equalsIgnoreCase(forwardBean.getBuyerSpaceUuId())) {
                    aa.c("BeiZis", forwardBean.getBuyerId() + " handleSpaceRequestStrategy buyerBean match");
                    if (b(forwardBean.getRules(), a6)) {
                        aa.c("BeiZis", forwardBean.getBuyerId() + " enter rulesMatch");
                        list2.add(forwardBean);
                    }
                }
            }
        }
    }

    protected static void a(AdSpacesBean.ComponentBean componentBean, List<AdSpacesBean.ForwardBean> list) {
        List<AdSpacesBean.ForwardBean> forward = componentBean.getForward();
        int random = (int) ((Math.random() * 100.0d) + 1.0d);
        aa.a("BeiZis", "AdForward random:" + random);
        if (forward == null || forward.size() <= 0) {
            return;
        }
        int size = forward.size();
        for (int i6 = 0; i6 < size; i6++) {
            AdSpacesBean.ForwardBean forwardBean = forward.get(i6);
            List<AdSpacesBean.RulesBean> rules = forwardBean.getRules();
            if (rules != null && rules.size() > 0) {
                int size2 = rules.size();
                for (int i7 = 0; i7 < size2; i7++) {
                    Integer[] results = rules.get(i7).getResults();
                    if (results != null && results.length >= 2) {
                        int intValue = results[0].intValue();
                        int intValue2 = results[1].intValue();
                        if (intValue <= random && random <= intValue2) {
                            list.add(forwardBean);
                        }
                    }
                }
            }
        }
    }

    private static boolean a(AdSpacesBean.RulesBean rulesBean, int i6) {
        boolean z5 = false;
        if (rulesBean == null) {
            return false;
        }
        try {
            String replace = rulesBean.getFormula().replace("x", i6 + "");
            int a6 = c.a(replace);
            Integer[] results = rulesBean.getResults();
            aa.c("BeiZis", "formulaOrig = " + replace + ",isOneRuleMatch holderNum = " + i6);
            if (results != null && results.length >= 2) {
                aa.c("BeiZis", "formulaResult = " + a6 + ",results[0] = " + results[0] + ",results[1] = " + results[1]);
                if (a6 >= results[0].intValue() && a6 <= results[1].intValue()) {
                    z5 = true;
                }
            }
            return rulesBean.getRules() != null ? b(rulesBean.getRules(), i6) & z5 : z5;
        } catch (Exception unused) {
            aa.c("BeiZis", "execute formula error!");
            return z5;
        }
    }

    public static void a(Context context, long j6, AdSpacesBean.FilterBean filterBean, com.beizi.fusion.events.b bVar, String str, String str2, String str3, com.beizi.fusion.c.a aVar) {
        boolean z5;
        boolean z6;
        boolean z7;
        if (bVar != null) {
            aa.a("BeiZis", "channel = " + str2 + ",observer.mPlatformFilterStatus.getStatus() = " + bVar.f13488c.a() + ",observer.mChannelFilterStatus.getStatus(channelId) = " + bVar.f13490e.a(str2));
        }
        boolean isEmpty = TextUtils.isEmpty(str2);
        if (bVar != null) {
            boolean z8 = true;
            if (bVar.f13488c.a() == 1 || bVar.f13490e.a(str2) == 2) {
                if (filterBean != null) {
                    List<String> privilege = filterBean.getPrivilege();
                    boolean a6 = (privilege == null || privilege.size() <= 0) ? true : a(context, privilege);
                    z7 = false;
                    z6 = j6 > ((long) filterBean.getMinAdLoadTime());
                    try {
                        z8 = s.a(filterBean.getFrequency(), str, c(str2), str3);
                    } catch (Exception e6) {
                        e6.printStackTrace();
                    }
                    boolean z9 = z8;
                    z8 = a6;
                    z5 = z9;
                } else {
                    if (!isEmpty) {
                        bVar.f13490e.a(str2, 3);
                    } else {
                        bVar.f13488c.a(2);
                    }
                    z5 = true;
                    z6 = true;
                    z7 = true;
                }
                if (!z8) {
                    if (!isEmpty) {
                        bVar.f13490e.a(str2, 5);
                    } else {
                        bVar.f13488c.a(4);
                    }
                }
                if (!z6) {
                    if (!isEmpty) {
                        bVar.f13490e.a(str2, 6);
                    } else {
                        bVar.f13488c.a(5);
                    }
                }
                if (!z5) {
                    if (!isEmpty) {
                        bVar.f13490e.a(str2, 7);
                    } else {
                        bVar.f13488c.a(6);
                    }
                }
                if (!z7 && z8 && z6 && z5) {
                    if (!isEmpty) {
                        bVar.f13490e.a(str2, 3);
                        return;
                    } else {
                        bVar.f13488c.a(2);
                        return;
                    }
                }
                return;
            }
        }
        if (bVar != null) {
            if (!isEmpty) {
                bVar.f13490e.a(str2, -2);
                return;
            } else {
                bVar.f13488c.a(-2);
                return;
            }
        }
        if (aVar == null || !isEmpty) {
            return;
        }
        aVar.a("status not PlatformFilterStatus.kPlatformFilterStatusBegin");
    }

    public static int a(String str) {
        String b6;
        if (str == null || (b6 = b(str)) == null) {
            return -1;
        }
        return Integer.parseInt(b6);
    }

    private static boolean a(Context context, List<String> list) {
        PackageManager packageManager = context.getPackageManager();
        String packageName = context.getPackageName();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (-1 == packageManager.checkPermission(it.next(), packageName)) {
                return false;
            }
        }
        return true;
    }

    public static AdSpacesBean.BuyerBean a(String str, List<AdSpacesBean.BuyerBean> list, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append("buyerBeans != null ? ");
        sb.append(list != null);
        aa.c("BeiZis", sb.toString());
        if (list != null) {
            aa.c("BeiZis", "buyerBeans.size() = " + list.size());
        }
        if (list == null || list.size() <= 0) {
            return null;
        }
        for (int i6 = 0; i6 < list.size(); i6++) {
            AdSpacesBean.BuyerBean buyerBean = list.get(i6);
            aa.c("BeiZis", "AdBuyer buyerBean.getUuid() = " + buyerBean.getBuyerSpaceUuId());
            if (buyerBean.getId() != null && buyerBean.getId().equals(str) && str2 != null && str2.equalsIgnoreCase(buyerBean.getBuyerSpaceUuId())) {
                return buyerBean;
            }
        }
        return null;
    }

    public static String a(List<AdSpacesBean.BuyerBean.RenderRulesBean> list, int i6) {
        Integer[] results;
        if (list == null) {
            return null;
        }
        try {
            if (list.size() == 0) {
                return null;
            }
            for (int i7 = 0; i7 < list.size(); i7++) {
                AdSpacesBean.BuyerBean.RenderRulesBean renderRulesBean = list.get(i7);
                if (renderRulesBean != null && (results = renderRulesBean.getResults()) != null && results.length >= 2 && i6 >= results[0].intValue() && i6 <= results[1].intValue()) {
                    String type = renderRulesBean.getType();
                    aa.c("BeiZis", "type = " + type + ";holderNum:" + i6);
                    return type;
                }
            }
            return null;
        } catch (Exception e6) {
            e6.printStackTrace();
            return null;
        }
    }
}
