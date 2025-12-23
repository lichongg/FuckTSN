package com.kwad.framework.filedownloader;

import com.kwad.framework.filedownloader.x;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public interface a {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.kwad.framework.filedownloader.a$a, reason: collision with other inner class name */
    public interface InterfaceC0653a {
        boolean br(int i6);

        void free();

        boolean isOver();

        a wR();

        x.a wS();

        int wT();

        void wU();

        boolean wV();

        void wW();

        void wX();

        boolean wY();
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface b {
        int wZ();
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface c {
        void onBegin();

        void xa();
    }

    a a(i iVar);

    a bd(boolean z5);

    a be(boolean z5);

    a bf(boolean z5);

    a bk(String str);

    a bl(String str);

    a bq(int i6);

    a c(String str, boolean z5);

    boolean cancel();

    a f(Object obj);

    String getFilename();

    int getId();

    String getPath();

    int getSmallFileSoFarBytes();

    int getSmallFileTotalBytes();

    int getSpeed();

    long getStatusUpdateTime();

    Object getTag();

    String getTargetFilePath();

    String getUrl();

    boolean isRunning();

    boolean pause();

    int start();

    a u(String str, String str2);

    b wA();

    boolean wB();

    boolean wC();

    int wD();

    int wE();

    boolean wF();

    i wG();

    long wH();

    long wI();

    byte wJ();

    boolean wK();

    Throwable wL();

    int wM();

    int wN();

    boolean wO();

    boolean wP();

    boolean wQ();
}
