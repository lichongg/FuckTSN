package com.kwad.framework.filedownloader.f;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class a {
    private static void b(String str, Object... objArr) {
        d.d(a.class, str + ", but the download service isn't connected yet.\nYou can use FileDownloader#isServiceConnected() to check whether the service has been connected, \nbesides you can use following functions easier to control your requestHttpCode invoke after the service has been connected: \n1. FileDownloader#bindService(Runnable)\n2. FileDownloader#insureServiceBind()\n3. FileDownloader#insureServiceBindAsync()", objArr);
    }

    public static boolean bw(int i6) {
        b("request pause the task[%d] in the download service", Integer.valueOf(i6));
        return false;
    }

    public static byte bx(int i6) {
        b("request get the status for the task[%d] in the download service", Integer.valueOf(i6));
        return (byte) 0;
    }

    public static boolean by(int i6) {
        b("request clear the task[%d] data in the database", Integer.valueOf(i6));
        return false;
    }

    public static boolean h(String str, String str2, boolean z5) {
        b("request start the task([%s], [%s], [%B]) in the download service", str, str2, Boolean.valueOf(z5));
        return false;
    }
}
