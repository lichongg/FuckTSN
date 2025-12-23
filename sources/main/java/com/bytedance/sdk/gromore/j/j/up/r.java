package com.bytedance.sdk.gromore.j.j.up;

/* loaded from: D:\Downloads\app\classes4.dex */
public class r {
    public static void j(com.bytedance.msdk.api.cw.j jVar, String str) {
        com.bytedance.msdk.j.up.cw.xt("TMe_reward", "RewardUtils  ".concat(String.valueOf(str)));
        if (jVar == null) {
            com.bytedance.msdk.j.up.cw.xt("TMe_reward", "rewardItem is null ");
            return;
        }
        com.bytedance.msdk.j.up.cw.xt("TMe_reward", "rewardItem.getRewardName " + jVar.cw());
        com.bytedance.msdk.j.up.cw.xt("TMe_reward", "rewardItem.getAmount " + jVar.xt());
        com.bytedance.msdk.j.up.cw.xt("TMe_reward", "rewardItem.getCustomData() " + jVar.r());
        com.bytedance.msdk.j.up.cw.xt("TMe_reward", "rewardItem.rewardVerify() " + jVar.j());
    }
}
