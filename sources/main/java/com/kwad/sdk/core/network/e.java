package com.kwad.sdk.core.network;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class e {
    public final int errorCode;
    public final String msg;
    public static e aEl = new e(-1, "请求超时事件");
    public static e aEm = new e(-2, "请求异常");
    public static e aEn = new e(-1000, "该业务组件未加载");
    public static e aEo = new e(40001, "网络错误");
    public static e aEp = new e(40002, "数据解析错误");
    public static e aEq = new e(40003, "数据为空");
    public static e aEr = new e(40004, "视频资源缓存失败");
    public static e aEs = new e(40005, "网络超时");
    public static e aEt = new e(40007, "图片下载失败");
    public static e aEu = new e(40008, "广告场景不匹配");
    public static e aEv = new e(40009, "广告加载异常");
    public static e aEw = new e(40010, "activity场景不匹配");
    public static e aEx = new e(40011, "sdk初始化失败");
    public static e aEy = new e(40012, "权限未开启");
    public static e aEz = new e(40013, "SDK未调用start方法");
    public static e aEA = new e(100006, "更多视频请前往快手App查看");
    public static e aEB = new e(100007, "复制链接失败，请稍后重试");
    public static e aEC = new e(100008, "内容有点敏感，不可以发送哦");
    public static e aED = new e(130001, "数据不存在");
    public static e aEE = new e(0, "网络超时");

    private e(int i6, String str) {
        this.errorCode = i6;
        this.msg = str;
    }
}
