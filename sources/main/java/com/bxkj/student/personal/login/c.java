package com.bxkj.student.personal.login;

import android.app.Activity;
import android.content.Intent;
import cn.bluemobi.dylan.http.JsonParse;
import cn.jpush.android.api.JThirdPlatFormInterface;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.MainActivity;
import com.bxkj.student.main.MyFragment;
import com.umeng.analytics.MobclickAgent;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class c {
    public static void c() {
        com.bxkj.student.common.jpush.a.f17746a.d(LoginUser.getLoginUser().getSchoolId() + "_" + LoginUser.getLoginUser().getUserId(), false);
        LoginUser.getLoginUser().setLogin(false);
        LoginUser.getLoginUser().setAuthorizationInMall(false);
        LoginUser.getLoginUser().setAuthorizationInLost(false);
        LoginUser.getLoginUser().setAuthorizationInSecondHand(false);
        LoginUser.getLoginUser().setAuthorizationInJob(false);
        LoginUser.getLoginUser().setHeadImageUrl("");
        LoginUser.getLoginUser().setUserId("");
        LoginUser.getLoginUser().setToken("");
        LoginUser.getLoginUser().setTempUserId("");
        LoginUser.getLoginUser().setTempUserNumber("");
        LoginUser.getLoginUser().setTempUserName("");
        LoginUser.getLoginUser().setTempUserPhone("");
        LoginUser.getLoginUser().setHeadImageUrl("");
        LoginUser.getLoginUser().setKeepToken("");
        cn.bluemobi.dylan.base.utils.a.n().l();
    }

    public static void a() {
        LoginUser.getLoginUser().getOpenId();
    }

    public static void b(Activity mActivity, Map<String, Object> data) {
        LoginUser.getLoginUser().setTempUserId("");
        LoginUser.getLoginUser().setTempUserNumber("");
        LoginUser.getLoginUser().setTempUserName("");
        LoginUser.getLoginUser().setTempUserPhone("");
        LoginUser.getLoginUser().setLastLoginTime(System.currentTimeMillis());
        LoginUser.getLoginUser().setUserId(JsonParse.getString(data, "id"));
        LoginUser.getLoginUser().setRealName(JsonParse.getString(data, CommonNetImpl.NAME).trim());
        LoginUser.getLoginUser().setAccount(JsonParse.getString(data, "userNum"));
        LoginUser.getLoginUser().setPhone(JsonParse.getString(data, "phone"));
        LoginUser.getLoginUser().setSex(JsonParse.getString(data, "sex"));
        LoginUser.getLoginUser().setToken(JsonParse.getString(data, JThirdPlatFormInterface.KEY_TOKEN));
        LoginUser.getLoginUser().setLogin(true);
        com.bxkj.student.common.jpush.a.f17746a.d(LoginUser.getLoginUser().getSchoolId() + "_" + LoginUser.getLoginUser().getUserId(), true);
        MobclickAgent.onProfileSignIn(LoginUser.getLoginUser().getUserId());
        mActivity.startActivity(new Intent(mActivity, (Class<?>) MainActivity.class));
        MainActivity mainActivity = (MainActivity) cn.bluemobi.dylan.base.utils.a.n().getActivity(MainActivity.class);
        if (mainActivity != null) {
            mainActivity.v0();
            mainActivity.z0();
            MyFragment myFragment = (MyFragment) cn.bluemobi.dylan.base.utils.a.n().o(MyFragment.class);
            if (myFragment != null) {
                myFragment.Z();
                myFragment.a0();
            }
        }
        a();
        mActivity.finish();
    }
}
