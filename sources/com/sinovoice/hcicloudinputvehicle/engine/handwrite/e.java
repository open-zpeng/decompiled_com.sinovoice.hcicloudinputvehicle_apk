package com.sinovoice.hcicloudinputvehicle.engine.handwrite;

import com.sinovoice.hcicloudsdk.api.hwr.HciCloudHwr;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EnglishHandWriteWrapper.java */
/* loaded from: classes.dex */
public class e extends f {
    private static final String d = "e";

    @Override // com.sinovoice.hcicloudinputvehicle.engine.handwrite.f
    public void a() {
        super.a();
        this.c.addParam("resPrefix", "en.");
        this.c.addParam("recogRange", "all");
        int hciHwrSessionStart = HciCloudHwr.hciHwrSessionStart(this.c.getStringConfig(), this.f165b);
        String str = d;
        b.b.a.b.a.c(str, "hciHWRSessionStart return: " + hciHwrSessionStart);
    }
}
