package com.sinovoice.hcicloudinputvehicle.engine.keyboard;

import android.content.Context;
import com.sinovoice.hcicloudsdk.api.kb.HciCloudKb;
import com.sinovoice.hcicloudsdk.common.ApiInitParam;
import com.sinovoice.hcicloudsdk.common.kb.KbInitParam;
/* compiled from: KBInputEngineInstance.java */
/* loaded from: classes.dex */
public class b implements KBInputEngine {

    /* renamed from: a  reason: collision with root package name */
    private static final String f168a = "b";

    /* renamed from: b  reason: collision with root package name */
    private static b f169b;
    private InputSDKWrapper c = new c();
    private InputSDKWrapper d = new a();

    private b() {
    }

    public static b a() {
        if (f169b == null) {
            f169b = new b();
        }
        return f169b;
    }

    private void b() {
        KbInitParam kbInitParam = new KbInitParam();
        kbInitParam.addParam(ApiInitParam.PARAM_KEY_DATA_PATH, com.sinovoice.hcicloudinputvehicle.a.a.a());
        kbInitParam.addParam(ApiInitParam.PARAM_KEY_FILE_FLAG, "android_so");
        kbInitParam.addParam(ApiInitParam.PARAM_KEY_INIT_CAP_KEYS, "kb.local.recog");
        int hciKbInit = HciCloudKb.hciKbInit(kbInitParam.getStringConfig());
        String str = f168a;
        b.b.a.b.a.c(str, "Kb checkAndInit result: " + hciKbInit);
    }

    private void c() {
        int hciKbRelease = HciCloudKb.hciKbRelease();
        String str = f168a;
        b.b.a.b.a.c(str, "hciKbrelease return: " + hciKbRelease);
    }

    @Override // com.sinovoice.hcicloudinputvehicle.engine.keyboard.KBInputEngine
    public d getMoreEnglish() {
        return this.d.getMore();
    }

    @Override // com.sinovoice.hcicloudinputvehicle.engine.keyboard.KBInputEngine
    public d getMorePinYin() {
        return this.c.getMore();
    }

    @Override // com.sinovoice.hcicloudinputvehicle.engine.keyboard.KBInputEngine
    public void init(Context context) {
        b();
    }

    @Override // com.sinovoice.hcicloudinputvehicle.engine.keyboard.KBInputEngine
    public d queryEnglish(String str) {
        return this.d.query(str);
    }

    @Override // com.sinovoice.hcicloudinputvehicle.engine.keyboard.KBInputEngine
    public d queryPinYin(String str) {
        return this.c.query(str);
    }

    @Override // com.sinovoice.hcicloudinputvehicle.engine.keyboard.KBInputEngine
    public void release() {
        c();
    }

    @Override // com.sinovoice.hcicloudinputvehicle.engine.keyboard.KBInputEngine
    public void setPinYinFuzzy(boolean z) {
        this.c.setFuzzyOn(z);
    }

    @Override // com.sinovoice.hcicloudinputvehicle.engine.keyboard.KBInputEngine
    public void startKBSession() {
        this.d.init();
        this.c.init();
    }

    @Override // com.sinovoice.hcicloudinputvehicle.engine.keyboard.KBInputEngine
    public void stopKBSession() {
        this.c.release();
        this.d.release();
    }

    @Override // com.sinovoice.hcicloudinputvehicle.engine.keyboard.KBInputEngine
    public void submitChineseUDB(String str, String str2) {
        this.c.submitUDB(str, str2);
    }
}
