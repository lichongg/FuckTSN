package com.bxkj.student.v2.ai.fitness.data;

import com.baidu.mobads.sdk.api.PrerollVideoResponse;
import com.beizi.fusion.widget.ScrollClickView;
import com.bxkj.student.R;
import kotlin.enums.a;
import kotlin.enums.c;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class FitnessModelConfig {
    private static final /* synthetic */ a $ENTRIES;
    private static final /* synthetic */ FitnessModelConfig[] $VALUES;

    @NotNull
    private final FitnessModel fitnessModel;
    public static final FitnessModelConfig SQUAT = new FitnessModelConfig("SQUAT", 0, new FitnessModel("深蹲", R.mipmap.ai_squat_down, "squat_down", "pose/squat_csvs_out_basic.csv", false, 16, null));
    public static final FitnessModelConfig JUMP = new FitnessModelConfig("JUMP", 1, new FitnessModel("开合跳", R.mipmap.ai_jump_close, "jump_close", "pose/jump_csvs_out_basic.csv", false, 16, null));
    public static final FitnessModelConfig PULL_UP = new FitnessModelConfig("PULL_UP", 2, new FitnessModel("引体向上", R.mipmap.ai_pull_up, "up", "pose/yinti_csvs_out_basic.csv", false, 16, null));
    public static final FitnessModelConfig SHOULDER_PUSH_UP = new FitnessModelConfig("SHOULDER_PUSH_UP", 3, new FitnessModel("肩推", R.mipmap.ai_shoulder_push_up, "up", "pose/jiantui_csvs_out_basic.csv", false, 16, null));
    public static final FitnessModelConfig PUSH_UPS_UP = new FitnessModelConfig("PUSH_UPS_UP", 4, new FitnessModel("俯卧撑", R.mipmap.ai_push_ups_up, "pushups_down", "pose/pushups_up_out_basic.csv", false, 16, null));
    public static final FitnessModelConfig TIAO_SHENG = new FitnessModelConfig("TIAO_SHENG", 5, new FitnessModel("跳绳", R.mipmap.ai_tiaosheng, ScrollClickView.DIR_DOWN, "pose/tiaosheng_csvs_out.csv", false, 16, null));
    public static final FitnessModelConfig GAO_TAI_TUI = new FitnessModelConfig("GAO_TAI_TUI", 6, new FitnessModel("高抬腿", R.mipmap.ai_gaotaitui, "up", "pose/gaotaitui_csvs_out.csv", false, 16, null));
    public static final FitnessModelConfig DOWN_JUMP_CLOSE = new FitnessModelConfig("DOWN_JUMP_CLOSE", 7, new FitnessModel("下蹲开合跳", R.mipmap.ai_squat_down, "close", "pose/down_jump_close_csvs_out.csv", false, 16, null));
    public static final FitnessModelConfig SHUI_PING_KAI_HE_TIAO = new FitnessModelConfig("SHUI_PING_KAI_HE_TIAO", 8, new FitnessModel("水平开合跳", R.mipmap.ai_jump_close, "close", "pose/shuipingkaihetiao_csvs_out.csv", false, 16, null));
    public static final FitnessModelConfig ZHI_BI_KAI_HE_TIAO = new FitnessModelConfig("ZHI_BI_KAI_HE_TIAO", 9, new FitnessModel("直臂开合跳", R.mipmap.ai_shou_bi_hua_quan, "close", "pose/zhibikaihetiao_csvs_out.csv", false, 16, null));
    public static final FitnessModelConfig SHOU_BI_HUA_QUAN = new FitnessModelConfig("SHOU_BI_HUA_QUAN", 10, new FitnessModel("手臂前划圈", R.mipmap.ai_shou_bi_hua_quan, "up", "pose/shou_bi_hua_quan_csvs_out.csv", false, 16, null));
    public static final FitnessModelConfig SHOU_BI_HOU_HUA_QUAN = new FitnessModelConfig("SHOU_BI_HOU_HUA_QUAN", 11, new FitnessModel("手臂后划圈", R.mipmap.ai_shou_bi_hua_quan, "up", "pose/shou_bi_hua_quan_csvs_out.csv", false, 16, null));
    public static final FitnessModelConfig HOU_TI_TUI_TIAO = new FitnessModelConfig("HOU_TI_TUI_TIAO", 12, new FitnessModel("后踢腿跳", R.mipmap.ai_hout_ti_tui_tiao, "up", "pose/gaotaitui_csvs_out.csv", false, 16, null));
    public static final FitnessModelConfig YUAN_DI_MAN_PAO = new FitnessModelConfig("YUAN_DI_MAN_PAO", 13, new FitnessModel("原地慢跑", R.mipmap.ai_yuan_di_man_pao, ScrollClickView.DIR_LEFT, "pose/yuan_di_man_pao_csvs_out.csv", false, 16, null));
    public static final FitnessModelConfig DUN_MA_BU = new FitnessModelConfig("DUN_MA_BU", 14, new FitnessModel("蹲马步", R.mipmap.ai_zha_ma_bu, ScrollClickView.DIR_DOWN, "pose/zha_ma_bu_csvs_out.csv", false));
    public static final FitnessModelConfig PING_BAN_ZHI_CHENG = new FitnessModelConfig("PING_BAN_ZHI_CHENG", 15, new FitnessModel("平板支撑", R.mipmap.ai_push_ups_up, "pushups_up", "pose/pushups_up_out_basic.csv", false));
    public static final FitnessModelConfig ZUO_TI_CE = new FitnessModelConfig("ZUO_TI_CE", 16, new FitnessModel("左体侧运动", R.mipmap.ai_zuo_ti_ce, PrerollVideoResponse.NORMAL, "pose/zuo_ti_ce_csvs_out.csv", false, 16, null));
    public static final FitnessModelConfig YOU_TI_CE = new FitnessModelConfig("YOU_TI_CE", 17, new FitnessModel("右体侧运动", R.mipmap.ai_you_ti_ce, PrerollVideoResponse.NORMAL, "pose/you_ti_ce_csvs_out.csv", false, 16, null));
    public static final FitnessModelConfig KUO_XIONG = new FitnessModelConfig("KUO_XIONG", 18, new FitnessModel("扩胸运动", R.mipmap.ai_shou_bi_hua_quan, "close", "pose/kuo_xiong_csvs_out.csv", false, 16, null));
    public static final FitnessModelConfig SHEN_TO_CE_XIANG_SHEN_ZHAN = new FitnessModelConfig("SHEN_TO_CE_XIANG_SHEN_ZHAN", 19, new FitnessModel("身体侧向伸展", R.mipmap.ai_jump_close, PrerollVideoResponse.NORMAL, "pose/shen_to_ce_xiang_shen_zhan_csvs_out.csv", false, 16, null));

    private static final /* synthetic */ FitnessModelConfig[] $values() {
        return new FitnessModelConfig[]{SQUAT, JUMP, PULL_UP, SHOULDER_PUSH_UP, PUSH_UPS_UP, TIAO_SHENG, GAO_TAI_TUI, DOWN_JUMP_CLOSE, SHUI_PING_KAI_HE_TIAO, ZHI_BI_KAI_HE_TIAO, SHOU_BI_HUA_QUAN, SHOU_BI_HOU_HUA_QUAN, HOU_TI_TUI_TIAO, YUAN_DI_MAN_PAO, DUN_MA_BU, PING_BAN_ZHI_CHENG, ZUO_TI_CE, YOU_TI_CE, KUO_XIONG, SHEN_TO_CE_XIANG_SHEN_ZHAN};
    }

    static {
        FitnessModelConfig[] $values = $values();
        $VALUES = $values;
        $ENTRIES = c.c($values);
    }

    @NotNull
    public static a<FitnessModelConfig> getEntries() {
        return $ENTRIES;
    }

    public static FitnessModelConfig valueOf(String str) {
        return (FitnessModelConfig) Enum.valueOf(FitnessModelConfig.class, str);
    }

    public static FitnessModelConfig[] values() {
        return (FitnessModelConfig[]) $VALUES.clone();
    }

    @NotNull
    public final FitnessModel getFitnessModel() {
        return this.fitnessModel;
    }

    private FitnessModelConfig(String str, int i6, FitnessModel fitnessModel) {
        this.fitnessModel = fitnessModel;
    }
}
