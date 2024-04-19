package com.sinovoice.hcicloudinputvehicle.engine.handwrite;

import com.sinovoice.hcicloudsdk.api.hwr.HciCloudHwr;
import com.sinovoice.hcicloudsdk.common.ApiInitParam;
import com.sinovoice.hcicloudsdk.common.hwr.HwrInitParam;
import java.util.ArrayList;
/* compiled from: EngineInstance.java */
/* loaded from: classes.dex */
public class c implements Engine {

    /* renamed from: a  reason: collision with root package name */
    private static final String f160a = "c";

    /* renamed from: b  reason: collision with root package name */
    private static c f161b;
    private AssociateSDKWrapper c;
    private AssociateSDKWrapper d;
    private f e;
    private f f;

    private c() {
    }

    public static c a() {
        if (f161b == null) {
            f161b = new c();
        }
        return f161b;
    }

    private void b() {
        String a2 = com.sinovoice.hcicloudinputvehicle.a.a.a();
        HwrInitParam hwrInitParam = new HwrInitParam();
        hwrInitParam.addParam(ApiInitParam.PARAM_KEY_DATA_PATH, a2);
        hwrInitParam.addParam(ApiInitParam.PARAM_KEY_INIT_CAP_KEYS, "hwr.local.freestylus;hwr.local.freestylus.english");
        hwrInitParam.addParam(ApiInitParam.PARAM_KEY_FILE_FLAG, "android_so");
        int hciHwrInit = HciCloudHwr.hciHwrInit(hwrInitParam.getStringConfig());
        String str = f160a;
        b.b.a.b.a.c(str, "hwr checkAndInit result: " + hciHwrInit);
    }

    private void c() {
        int hciHwrRelease = HciCloudHwr.hciHwrRelease();
        String str = f160a;
        b.b.a.b.a.c(str, "hciHwrrelease return: " + hciHwrRelease);
    }

    @Override // com.sinovoice.hcicloudinputvehicle.engine.handwrite.Engine
    public ArrayList<String> associateChinese(String str) {
        return this.c.associate(str);
    }

    @Override // com.sinovoice.hcicloudinputvehicle.engine.handwrite.Engine
    public ArrayList<String> associateEnglish(String str) {
        return this.d.associate(str);
    }

    @Override // com.sinovoice.hcicloudinputvehicle.engine.handwrite.Engine
    public ArrayList<String> hwrRecogChinese(short[] sArr) {
        return this.e.b(sArr);
    }

    @Override // com.sinovoice.hcicloudinputvehicle.engine.handwrite.Engine
    public ArrayList<String> hwrRecogEnglish(short[] sArr) {
        return this.f.b(sArr);
    }

    @Override // com.sinovoice.hcicloudinputvehicle.engine.handwrite.Engine
    public void init() {
        b();
        this.c = new a();
        this.d = new d();
        this.e = new b();
        this.f = new e();
    }

    @Override // com.sinovoice.hcicloudinputvehicle.engine.handwrite.Engine
    public void raisePriorityChinese(String str) {
        this.c.raisePriority(str);
    }

    @Override // com.sinovoice.hcicloudinputvehicle.engine.handwrite.Engine
    public void raisePriorityEnglish(String str) {
        this.d.raisePriority(str);
    }

    @Override // com.sinovoice.hcicloudinputvehicle.engine.handwrite.Engine
    public void release() {
        c();
    }

    @Override // com.sinovoice.hcicloudinputvehicle.engine.handwrite.Engine
    public void startHwrAssSession() {
        this.c.init();
        this.d.init();
    }

    @Override // com.sinovoice.hcicloudinputvehicle.engine.handwrite.Engine
    public void startHwrSession() {
        this.e.a();
        this.f.a();
    }

    @Override // com.sinovoice.hcicloudinputvehicle.engine.handwrite.Engine
    public void stopHwrAssSession() {
        this.c.release();
        this.d.release();
    }

    @Override // com.sinovoice.hcicloudinputvehicle.engine.handwrite.Engine
    public void stopHwrSession() {
        this.f.e();
        this.e.e();
    }

    @Override // com.sinovoice.hcicloudinputvehicle.engine.handwrite.Engine
    public ArrayList<String> hwrRecogChinese(short[] sArr, int i) {
        return this.e.c(sArr, i);
    }

    @Override // com.sinovoice.hcicloudinputvehicle.engine.handwrite.Engine
    public ArrayList<String> hwrRecogChinese(short[] sArr, String str) {
        return this.e.d(sArr, str);
    }
}
