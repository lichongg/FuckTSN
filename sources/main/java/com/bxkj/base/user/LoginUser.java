package com.bxkj.base.user;

import android.graphics.Bitmap;
import cn.bluemobi.dylan.base.utils.r;
import cn.jpush.android.api.JThirdPlatFormInterface;
import cn.jpush.android.local.JPushConstants;
import com.bxkj.base.BaseApp;
import com.umeng.socialize.common.SocializeConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class LoginUser {
    private static LoginUser loginUser = new LoginUser();
    private String QR_Code;
    private String accessToken;
    private String account;
    private String achieveTime;
    private String address;
    private boolean agreement;
    private String appId;
    private String birthday;
    private String city_id;
    private String clearDataPassword;
    private String currentCity;
    private String email;
    private String energy_QTY;
    private int frequency;
    private String gender;
    private String gold;
    private String headImageUrl;
    private String idcard;
    private boolean isCheckIgnoreRunSet;
    private String isOpenEncry;
    private int isOpenKeep;
    private int isOpenLive;
    private boolean isOpenModel;
    private String is_sign;
    private String is_verify;
    private String keepToken;
    private long lastHeartCallBackTime;
    private String levels;
    private String location;
    private String marryDate;
    private String nickName;
    private String oldToNewH5;
    private String openId;
    private String password;
    private String phone;
    private String planWalk_QTY;
    private String point;
    private String province_id;
    private String realName;
    private String region_id;
    private String remind;
    private String roleName;
    private String schoolCode;
    private String schoolId;
    private String schoolName;
    private String serverUrl;
    private String sex;
    private String sumEnergy_QTY;
    private String synTime;
    private int sysType;
    private String tempUserId;
    private String tempUserName;
    private String tempUserNumber;
    private String tempUserPhone;
    private String token;
    private String uploadTime;
    private String userId;
    private int userPreferenceMode;
    private int userType;
    private String user_specialty;
    private String usersignature;
    private boolean voiceOpen;
    private String wallet;
    private int nfcCardType = 0;
    private List<Bitmap> bitmapList = new ArrayList();
    private String msg_QTY = "0";
    private boolean isFirst = true;
    private int lastVersionCode = 0;
    private long lastLoginTime = 0;
    private boolean isFirstUserSQJL = true;
    private boolean noPrompt = false;
    private r sp = new r(BaseApp.c());
    private boolean isAuthorizationInMall = false;
    private boolean isAuthorizationInLost = false;
    private boolean isAuthorizationInSecondHand = false;
    private boolean isAuthorizationInJob = false;
    private boolean isAuthorizationInRuner = false;
    private boolean isAuthorizationDonation = false;
    private boolean isLogin = false;
    private List<LoginListener> loginListenerList = new ArrayList();
    private boolean chatConnectStatus = false;
    private List<ChatConnectListener> chatConnectListenerList = new ArrayList();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface ChatConnectListener {
        void connectStatusChange(boolean z5);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface LoginListener {
        void loginStatusChange(boolean z5);
    }

    public void setUserType(int i6) {
        if (i6 == 1) {
            this.sp.d("userType", "1");
        } else {
            this.sp.d("userType", "2");
        }
        this.userType = i6;
    }

    public static LoginUser getLoginUser() {
        return loginUser;
    }

    public void addChatConnectListener(ChatConnectListener chatConnectListener) {
        this.chatConnectListenerList.add(chatConnectListener);
    }

    public void addLoginListener(LoginListener loginListener) {
        this.loginListenerList.add(loginListener);
    }

    public String getAccessToken() {
        String str = (String) this.sp.b("accessToken", "e34e6ce9-d599-4d2c-8f15-d475849d3e4d");
        this.accessToken = str;
        return str;
    }

    public String getAccount() {
        String str = (String) this.sp.b("account", "");
        this.account = str;
        return str;
    }

    public String getAchieveTime() {
        String str = (String) this.sp.b("achieveTime", "21:00");
        this.achieveTime = str;
        return str;
    }

    public String getAddress() {
        return this.address;
    }

    public String getAppId() {
        String str = (String) this.sp.b("appId", "move");
        this.appId = str;
        return str;
    }

    public String getBirthday() {
        String str = (String) this.sp.b("birthday", "");
        this.birthday = str;
        return str;
    }

    public List<Bitmap> getBitmapList() {
        return this.bitmapList;
    }

    public String getCity_id() {
        return this.city_id;
    }

    public String getClearDataPassword() {
        String str = (String) this.sp.b("clearDataPassword", "");
        this.clearDataPassword = str;
        return str;
    }

    public String getCurrentCity() {
        return this.currentCity;
    }

    public String getEmail() {
        String str = (String) this.sp.b("email", "");
        this.email = str;
        return str;
    }

    public String getEnergy_QTY() {
        String str = (String) this.sp.b("energy_QTY", "0");
        this.energy_QTY = str;
        return str;
    }

    public int getFrequency() {
        int intValue = ((Integer) this.sp.b("frequency", 0)).intValue();
        this.frequency = intValue;
        return intValue;
    }

    public String getGender() {
        String str = (String) this.sp.b("gender", "");
        this.gender = str;
        return str;
    }

    public String getGold() {
        return this.gold;
    }

    public String getHeadImageUrl() {
        String str = (String) this.sp.b("headImageUrl", "");
        this.headImageUrl = str;
        return str;
    }

    public String getIdcard() {
        String str = (String) this.sp.b("idcard", "");
        this.idcard = str;
        return str;
    }

    public boolean getIsFirst() {
        boolean booleanValue = ((Boolean) this.sp.b("QR_Code", Boolean.TRUE)).booleanValue();
        this.isFirst = booleanValue;
        return booleanValue;
    }

    public String getIsOpenEncry() {
        String str = (String) this.sp.b("isOpenEncry", "0");
        this.isOpenEncry = str;
        return str;
    }

    public int getIsOpenKeep() {
        int intValue = ((Integer) this.sp.b("isOpenKeep", 0)).intValue();
        this.isOpenKeep = intValue;
        return intValue;
    }

    public int getIsOpenLive() {
        int intValue = ((Integer) this.sp.b("isOpenLive", 1)).intValue();
        this.isOpenLive = intValue;
        return intValue;
    }

    public String getIs_sign() {
        return this.is_sign;
    }

    public String getIs_verify() {
        return this.is_verify;
    }

    public String getKeepToken() {
        String str = (String) this.sp.b("keepToken", "");
        this.keepToken = str;
        return str;
    }

    public long getLastHeartCallBackTime() {
        return this.lastHeartCallBackTime;
    }

    public long getLastLoginTime() {
        long longValue = ((Long) this.sp.b("lastLoginTime", 0L)).longValue();
        this.lastLoginTime = longValue;
        return longValue;
    }

    public int getLastVersionCode() {
        int intValue = ((Integer) this.sp.b("lastVersionCode", 0)).intValue();
        this.lastVersionCode = intValue;
        return intValue;
    }

    public String getLevels() {
        String str = (String) this.sp.b("levels", "");
        this.levels = str;
        return str;
    }

    public String getLocation() {
        String str = (String) this.sp.b(SocializeConstants.KEY_LOCATION, "");
        this.location = str;
        return str;
    }

    public String getMarryDate() {
        String str = (String) this.sp.b("marryDate", "");
        this.marryDate = str;
        return str;
    }

    public String getMsg_QTY() {
        return this.msg_QTY;
    }

    public int getNfcCardType() {
        int intValue = ((Integer) this.sp.b("nfcCardType", 0)).intValue();
        this.nfcCardType = intValue;
        return intValue;
    }

    public String getNickName() {
        String str = (String) this.sp.b("nickName", "");
        this.nickName = str;
        return str;
    }

    public String getOldToNewH5() {
        String str = (String) this.sp.b("oldToNewH5", "");
        this.oldToNewH5 = str;
        return str;
    }

    public String getOpenId() {
        this.openId = (String) this.sp.b("openId", "");
        String str = getLoginUser().getSchoolId() + "_" + getLoginUser().getUserId();
        this.openId = str;
        return str;
    }

    public String getPassword() {
        String str = (String) this.sp.b("password", "");
        this.password = str;
        return str;
    }

    public String getPhone() {
        String str = (String) this.sp.b("phone", "");
        this.phone = str;
        return str;
    }

    public String getPlanWalk_QTY() {
        String str = (String) this.sp.b("planWalk_QTY", "7000");
        this.planWalk_QTY = str;
        return str;
    }

    public String getPoint() {
        return this.point;
    }

    public String getProvince_id() {
        return this.province_id;
    }

    public String getQR_Code() {
        String str = (String) this.sp.b("QR_Code", "");
        this.QR_Code = str;
        return str;
    }

    public String getRealName() {
        String str = (String) this.sp.b("realName", "");
        this.realName = str;
        return str;
    }

    public String getRegion_id() {
        return this.region_id;
    }

    public String getRemind() {
        String str = (String) this.sp.b("remind", "1");
        this.remind = str;
        return str;
    }

    public String getRoleName() {
        return this.roleName;
    }

    public String getSchoolCode() {
        String str = (String) this.sp.b("schoolCode", "");
        this.schoolCode = str;
        return str;
    }

    public String getSchoolId() {
        String str = (String) this.sp.b("schoolId", "");
        this.schoolId = str;
        return str;
    }

    public String getSchoolName() {
        String str = (String) this.sp.b("schoolName", "");
        this.schoolName = str;
        return str;
    }

    public String getServerUrl() {
        String str = (String) this.sp.b("serverUrl", "https://m.boxkj.com/");
        this.serverUrl = str;
        if (!str.startsWith(JPushConstants.HTTP_PRE) && !this.serverUrl.startsWith(JPushConstants.HTTPS_PRE)) {
            this.serverUrl = "https://tsncs.boxkj.com/";
        }
        if (!this.serverUrl.endsWith("/")) {
            this.serverUrl += "/";
        }
        return this.serverUrl;
    }

    public String getSex() {
        String str = (String) this.sp.b("sex", "");
        this.sex = str;
        return str;
    }

    public String getSumEnergy_QTY() {
        String str = (String) this.sp.b("sumEnergy_QTY", "0");
        this.sumEnergy_QTY = str;
        return str;
    }

    public String getSynTime() {
        String str = (String) this.sp.b("synTime", "");
        this.synTime = str;
        return str;
    }

    public int getSysType() {
        int intValue = ((Integer) this.sp.b("sysType", 1)).intValue();
        this.sysType = intValue;
        return intValue;
    }

    public String getTempUserId() {
        String str = (String) this.sp.b("tempUserId", "");
        this.tempUserId = str;
        return str;
    }

    public String getTempUserName() {
        String str = (String) this.sp.b("tempUserName", "");
        this.tempUserName = str;
        return str;
    }

    public String getTempUserNumber() {
        String str = (String) this.sp.b("tempUserNumber", "");
        this.tempUserNumber = str;
        return str;
    }

    public String getTempUserPhone() {
        String str = (String) this.sp.b("tempUserPhone", "");
        this.tempUserPhone = str;
        return str;
    }

    public String getToken() {
        String str = (String) this.sp.b(JThirdPlatFormInterface.KEY_TOKEN, "");
        this.token = str;
        return str;
    }

    public String getUploadTime() {
        String str = (String) this.sp.b("uploadTime", "");
        this.uploadTime = str;
        return str;
    }

    public String getUserId() {
        String str = (String) this.sp.b("userId", "");
        this.userId = str;
        return str;
    }

    public int getUserPreferenceMode() {
        int intValue = ((Integer) this.sp.b("userPreferenceMode", 1)).intValue();
        this.userPreferenceMode = intValue;
        return intValue;
    }

    public int getUserType() {
        String str = (String) this.sp.b("userType", "");
        if (str.trim().isEmpty()) {
            this.userType = 1;
        } else if ("1".equals(str)) {
            this.userType = 1;
        } else {
            this.userType = 2;
        }
        return this.userType;
    }

    public String getUser_specialty() {
        return this.user_specialty;
    }

    public String getUsersignature() {
        return this.usersignature;
    }

    public String getWallet() {
        return this.wallet;
    }

    public boolean isAgreement() {
        boolean booleanValue = ((Boolean) this.sp.b("agreement", Boolean.FALSE)).booleanValue();
        this.agreement = booleanValue;
        return booleanValue;
    }

    public boolean isAuthorizationDonation() {
        return this.isAuthorizationDonation;
    }

    public boolean isAuthorizationInJob() {
        return this.isAuthorizationInJob;
    }

    public boolean isAuthorizationInLost() {
        return this.isAuthorizationInLost;
    }

    public boolean isAuthorizationInMall() {
        return this.isAuthorizationInMall;
    }

    public boolean isAuthorizationInRuner() {
        return this.isAuthorizationInRuner;
    }

    public boolean isAuthorizationInSecondHand() {
        return this.isAuthorizationInSecondHand;
    }

    public boolean isChatConnectStatus() {
        return this.chatConnectStatus;
    }

    public boolean isCheckIgnoreRunSet() {
        boolean booleanValue = ((Boolean) this.sp.b("isCheckIgnoreRunSet", Boolean.FALSE)).booleanValue();
        this.isCheckIgnoreRunSet = booleanValue;
        return booleanValue;
    }

    public boolean isFirstUserSQJL() {
        boolean booleanValue = ((Boolean) this.sp.b("isFirstUserSQJL", Boolean.TRUE)).booleanValue();
        this.isFirstUserSQJL = booleanValue;
        return booleanValue;
    }

    public boolean isLogin() {
        boolean booleanValue = ((Boolean) this.sp.b("login", Boolean.FALSE)).booleanValue();
        this.isLogin = booleanValue;
        return booleanValue;
    }

    public boolean isNoPrompt() {
        boolean booleanValue = ((Boolean) this.sp.b("noPrompt", Boolean.FALSE)).booleanValue();
        this.noPrompt = booleanValue;
        return booleanValue;
    }

    public boolean isOpenModel() {
        boolean booleanValue = ((Boolean) this.sp.b("openModel", Boolean.FALSE)).booleanValue();
        this.isOpenModel = booleanValue;
        return booleanValue;
    }

    public boolean isVoiceOpen() {
        boolean booleanValue = ((Boolean) this.sp.b("voiceOpen", Boolean.FALSE)).booleanValue();
        this.voiceOpen = booleanValue;
        return booleanValue;
    }

    public LoginUser setAccessToken(String str) {
        this.sp.d("accessToken", str);
        this.accessToken = str;
        return this;
    }

    public void setAccount(String str) {
        this.sp.d("account", str);
        this.account = str;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public LoginUser setAgreement(boolean z5) {
        this.sp.d("agreement", Boolean.valueOf(z5));
        this.agreement = z5;
        return this;
    }

    public void setAppId(String str) {
        this.sp.d("appId", str);
        this.appId = str;
    }

    public LoginUser setAuthorizationDonation(boolean z5) {
        this.isAuthorizationDonation = z5;
        return this;
    }

    public LoginUser setAuthorizationInJob(boolean z5) {
        this.isAuthorizationInJob = z5;
        return this;
    }

    public LoginUser setAuthorizationInLost(boolean z5) {
        this.isAuthorizationInLost = z5;
        return this;
    }

    public LoginUser setAuthorizationInMall(boolean z5) {
        this.isAuthorizationInMall = z5;
        return this;
    }

    public LoginUser setAuthorizationInRuner(boolean z5) {
        this.isAuthorizationInRuner = z5;
        return this;
    }

    public LoginUser setAuthorizationInSecondHand(boolean z5) {
        this.isAuthorizationInSecondHand = z5;
        return this;
    }

    public void setBirthday(String str) {
        this.sp.d("birthday", str);
        this.birthday = str;
    }

    public LoginUser setBitmapList(List<Bitmap> list) {
        this.bitmapList = list;
        return this;
    }

    public void setChatConnectStatus(boolean z5) {
        this.chatConnectStatus = z5;
        List<ChatConnectListener> list = this.chatConnectListenerList;
        if (list != null) {
            Iterator<ChatConnectListener> it = list.iterator();
            while (it.hasNext()) {
                it.next().connectStatusChange(z5);
            }
        }
    }

    public void setCheckIgnoreRunSet(boolean z5) {
        this.sp.d("isCheckIgnoreRunSet", Boolean.valueOf(z5));
        this.isCheckIgnoreRunSet = z5;
    }

    public void setCity_id(String str) {
        this.city_id = str;
    }

    public LoginUser setClearDataPassword(String str) {
        this.sp.d("clearDataPassword", str);
        this.clearDataPassword = str;
        return this;
    }

    public void setCurrentCity(String str) {
        this.currentCity = str;
    }

    public void setEmail(String str) {
        this.sp.d("email", str);
        this.email = str;
    }

    public void setEnergy_QTY(String str) {
        this.sp.d("energy_QTY", str);
        this.energy_QTY = str;
    }

    public LoginUser setFirstUserSQJL(boolean z5) {
        this.sp.d("isFirstUserSQJL", Boolean.valueOf(z5));
        this.isFirstUserSQJL = z5;
        return this;
    }

    public LoginUser setFrequency(int i6) {
        this.sp.d("frequency", Integer.valueOf(i6));
        this.frequency = i6;
        return this;
    }

    public void setGender(String str) {
        this.sp.d("gender", str);
        this.gender = str;
    }

    public void setGold(String str) {
        this.gold = str;
    }

    public void setHeadImageUrl(String str) {
        this.sp.d("headImageUrl", str);
        this.headImageUrl = str;
    }

    public void setIdcard(String str) {
        this.sp.d("idcard", str);
        this.idcard = str;
    }

    public void setIsFirst(boolean z5) {
        this.sp.d("isFirst", Boolean.valueOf(z5));
        this.isFirst = z5;
    }

    public LoginUser setIsOpenEncry(String str) {
        this.sp.d("isOpenEncry", str);
        this.isOpenEncry = str;
        return this;
    }

    public LoginUser setIsOpenKeep(int i6) {
        this.sp.d("isOpenKeep", Integer.valueOf(i6));
        this.isOpenKeep = i6;
        return this;
    }

    public LoginUser setIsOpenLive(int i6) {
        this.sp.d("isOpenLive", Integer.valueOf(i6));
        this.isOpenLive = i6;
        return this;
    }

    public void setIs_sign(String str) {
        this.is_sign = str;
    }

    public void setIs_verify(String str) {
        this.is_verify = str;
    }

    public LoginUser setKeepToken(String str) {
        this.sp.d("keepToken", str);
        this.keepToken = str;
        return this;
    }

    public void setLastHeartCallBackTime(long j6) {
        this.lastHeartCallBackTime = j6;
    }

    public void setLastLoginTime(long j6) {
        this.sp.d("lastLoginTime", Long.valueOf(j6));
        this.lastLoginTime = j6;
    }

    public void setLastVersionCode(int i6) {
        this.sp.d("lastVersionCode", Integer.valueOf(i6));
        this.lastVersionCode = i6;
    }

    public void setLevels(String str) {
        this.sp.d("levels", str);
        this.levels = str;
    }

    public void setLocation(String str) {
        this.sp.d(SocializeConstants.KEY_LOCATION, str);
        this.location = str;
    }

    public LoginUser setLogin(boolean z5) {
        this.sp.d("login", Boolean.valueOf(z5));
        this.isLogin = z5;
        List<LoginListener> list = this.loginListenerList;
        if (list != null) {
            Iterator<LoginListener> it = list.iterator();
            while (it.hasNext()) {
                it.next().loginStatusChange(this.isLogin);
            }
        }
        return this;
    }

    public void setMarryDate(String str) {
        this.sp.d("marryDate", str);
        this.marryDate = str;
    }

    public void setMsg_QTY(String str) {
        this.msg_QTY = str;
    }

    public LoginUser setNfcCardType(int i6) {
        this.sp.d("nfcCardType", Integer.valueOf(i6));
        this.nfcCardType = i6;
        return this;
    }

    public void setNickName(String str) {
        this.sp.d("nickName", str);
        this.nickName = str;
    }

    public LoginUser setNoPrompt(boolean z5) {
        this.sp.d("noPrompt", Boolean.valueOf(z5));
        this.noPrompt = z5;
        return this;
    }

    public LoginUser setOldToNewH5(String str) {
        this.sp.d("oldToNewH5", str);
        this.oldToNewH5 = str;
        return this;
    }

    public void setOpen(String str) {
        this.sp.d("openId", str);
        this.openId = str;
    }

    public LoginUser setOpenModel(boolean z5) {
        this.sp.d("openModel", Boolean.valueOf(z5));
        this.isOpenModel = z5;
        return this;
    }

    public void setPassword(String str) {
        this.sp.d("password", str);
        this.password = str;
    }

    public void setPhone(String str) {
        this.sp.d("phone", str);
        this.phone = str;
    }

    public void setPoint(String str) {
        this.point = str;
    }

    public void setProvince_id(String str) {
        this.province_id = str;
    }

    public void setQR_Code(String str) {
        this.sp.d("QR_Code", str);
        this.QR_Code = str;
    }

    public void setRealName(String str) {
        this.sp.d("realName", str);
        this.realName = str;
    }

    public void setRegion_id(String str) {
        this.region_id = str;
    }

    public void setRemind(String str) {
        this.sp.d("remind", str);
        this.remind = str;
    }

    public LoginUser setRoleName(String str) {
        this.roleName = str;
        return this;
    }

    public void setSchoolCode(String str) {
        this.sp.d("schoolCode", str);
        this.schoolCode = str;
    }

    public void setSchoolId(String str) {
        this.sp.d("schoolId", str);
        this.schoolId = str;
    }

    public void setSchoolName(String str) {
        this.sp.d("schoolName", str);
        this.schoolName = str;
    }

    public void setServerUrl(String str) {
        this.sp.d("serverUrl", str);
        this.serverUrl = str;
    }

    public void setSex(String str) {
        this.sp.d("sex", str);
        this.sex = str;
    }

    public void setSumEnergy_QTY(String str) {
        this.sp.d("sumEnergy_QTY", str);
        this.sumEnergy_QTY = str;
    }

    public void setSynTime(String str) {
        this.sp.d("synTime", str);
        this.synTime = str;
    }

    public LoginUser setSysType(int i6) {
        this.sp.d("sysType", Integer.valueOf(i6));
        this.sysType = i6;
        return this;
    }

    public void setTempUserId(String str) {
        this.sp.d("tempUserId", str);
        this.tempUserId = str;
    }

    public void setTempUserName(String str) {
        this.sp.d("tempUserName", str);
        this.tempUserName = str;
    }

    public void setTempUserNumber(String str) {
        this.sp.d("tempUserNumber", str);
        this.tempUserNumber = str;
    }

    public void setTempUserPhone(String str) {
        this.sp.d("tempUserPhone", str);
        this.tempUserPhone = str;
    }

    public void setToken(String str) {
        this.sp.d(JThirdPlatFormInterface.KEY_TOKEN, str);
        this.token = str;
    }

    public void setUploadTime(String str) {
        this.sp.d("uploadTime", str);
        this.uploadTime = str;
    }

    public void setUserId(String str) {
        this.sp.d("userId", str);
        this.userId = str;
    }

    public void setUserPreferenceMode(int i6) {
        this.sp.d("userPreferenceMode", Integer.valueOf(i6));
        this.userPreferenceMode = i6;
    }

    public void setUser_specialty(String str) {
        this.user_specialty = str;
    }

    public void setUsersignature(String str) {
        this.usersignature = str;
    }

    public LoginUser setVoiceOpen(boolean z5) {
        this.sp.d("voiceOpen", Boolean.valueOf(z5));
        this.voiceOpen = z5;
        return this;
    }

    public void setWallet(String str) {
        this.wallet = str;
    }

    private LoginUser() {
    }

    public String getViewAfterLabelName() {
        if (getSchoolName().equals("西安电子科技大学")) {
            return "俱乐部";
        }
        return "选课";
    }

    public String getXuanAfterLabelName() {
        if (getSchoolName().equals("西安电子科技大学")) {
            return "俱乐部";
        }
        return "课";
    }

    public String getXuanZeAfterLabelName() {
        if (getSchoolName().equals("西安电子科技大学")) {
            return "俱乐部";
        }
        return "课程";
    }

    public void setAchieveTime(String str) {
        if (str.isEmpty()) {
            this.sp.d("achieveTime", "21:00");
            this.achieveTime = "21:00";
        } else {
            this.sp.d("achieveTime", str);
            this.achieveTime = str;
        }
    }

    public void setPlanWalk_QTY(String str) {
        if (!str.isEmpty() && !"0".equals(str)) {
            this.sp.d("planWalk_QTY", str);
        } else {
            this.sp.d("planWalk_QTY", "7000");
        }
        this.planWalk_QTY = str;
    }
}
