package com.umeng.socialize.net.base;

import com.umeng.socialize.common.SocializeConstants;
import com.umeng.socialize.net.utils.UClient;
import com.umeng.socialize.net.utils.URequest;
import com.umeng.socialize.utils.SLog;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class SocializeClient extends UClient {
    public SocializeReseponse execute(URequest uRequest) {
        if (SocializeConstants.DEBUG_MODE) {
            try {
                Thread.sleep(3000L);
            } catch (InterruptedException e6) {
                SLog.error(e6);
            }
        }
        return (SocializeReseponse) super.execute(uRequest, uRequest.mResponseClz);
    }
}
