package com.amap.api.maps.model.particle;

import android.text.TextUtils;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import com.amap.api.maps.model.BaseOverlay;
import java.lang.ref.WeakReference;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class ParticleOverlay extends BaseOverlay {
    private WeakReference<IGlOverlayLayer> glOverlayLayerRef;
    private ParticleOverlayOptions options;

    public int getCurrentParticleNum() {
        try {
            IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
            if (iGlOverlayLayer != null) {
                return iGlOverlayLayer.getCurrentParticleNum(this.overlayName);
            }
            return 0;
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    private void a() {
        IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
        if (TextUtils.isEmpty(this.overlayName) || iGlOverlayLayer == null) {
            return;
        }
        iGlOverlayLayer.updateOption(this.overlayName, this.options);
    }

    public void destroy() {
        try {
            IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
            if (iGlOverlayLayer != null) {
                iGlOverlayLayer.removeOverlay(this.overlayName);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setDuration(long j6) {
        try {
            ParticleOverlayOptions particleOverlayOptions = this.options;
            if (particleOverlayOptions != null) {
                particleOverlayOptions.setDuration(j6);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setLoop(boolean z5) {
        try {
            ParticleOverlayOptions particleOverlayOptions = this.options;
            if (particleOverlayOptions != null) {
                particleOverlayOptions.setLoop(z5);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setMaxParticles(int i6) {
        try {
            ParticleOverlayOptions particleOverlayOptions = this.options;
            if (particleOverlayOptions != null) {
                particleOverlayOptions.setMaxParticles(i6);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setParticleEmission(ParticleEmissionModule particleEmissionModule) {
        try {
            ParticleOverlayOptions particleOverlayOptions = this.options;
            if (particleOverlayOptions != null) {
                particleOverlayOptions.setParticleEmissionModule(particleEmissionModule);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setParticleLifeTime(long j6) {
        try {
            ParticleOverlayOptions particleOverlayOptions = this.options;
            if (particleOverlayOptions != null) {
                particleOverlayOptions.setParticleLifeTime(j6);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setParticleOverLifeModule(ParticleOverLifeModule particleOverLifeModule) {
        try {
            ParticleOverlayOptions particleOverlayOptions = this.options;
            if (particleOverlayOptions != null) {
                particleOverlayOptions.setParticleOverLifeModule(particleOverLifeModule);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setParticleShapeModule(ParticleShapeModule particleShapeModule) {
        try {
            ParticleOverlayOptions particleOverlayOptions = this.options;
            if (particleOverlayOptions != null) {
                particleOverlayOptions.setParticleShapeModule(particleShapeModule);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setParticleStartSpeed(VelocityGenerate velocityGenerate) {
        try {
            ParticleOverlayOptions particleOverlayOptions = this.options;
            if (particleOverlayOptions != null) {
                particleOverlayOptions.setParticleStartSpeed(velocityGenerate);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setStartColor(ColorGenerate colorGenerate) {
        try {
            ParticleOverlayOptions particleOverlayOptions = this.options;
            if (particleOverlayOptions != null) {
                particleOverlayOptions.setParticleStartColor(colorGenerate);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setStartParticleSize(int i6, int i7) {
        try {
            ParticleOverlayOptions particleOverlayOptions = this.options;
            if (particleOverlayOptions != null) {
                particleOverlayOptions.setStartParticleSize(i6, i7);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setVisible(boolean z5) {
        try {
            ParticleOverlayOptions particleOverlayOptions = this.options;
            if (particleOverlayOptions != null) {
                particleOverlayOptions.setVisible(z5);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public ParticleOverlay(IGlOverlayLayer iGlOverlayLayer, ParticleOverlayOptions particleOverlayOptions, String str) {
        super(str);
        this.glOverlayLayerRef = new WeakReference<>(iGlOverlayLayer);
        this.options = particleOverlayOptions;
    }
}
