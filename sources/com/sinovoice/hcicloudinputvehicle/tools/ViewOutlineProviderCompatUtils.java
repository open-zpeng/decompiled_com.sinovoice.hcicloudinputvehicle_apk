package com.sinovoice.hcicloudinputvehicle.tools;

import android.inputmethodservice.InputMethodService;
import android.view.View;
/* loaded from: classes.dex */
public class ViewOutlineProviderCompatUtils {

    /* renamed from: a  reason: collision with root package name */
    private static final InsetsUpdater f228a = new a();

    /* loaded from: classes.dex */
    public interface InsetsUpdater {
        void setInsets(InputMethodService.Insets insets);
    }

    /* loaded from: classes.dex */
    class a implements InsetsUpdater {
        a() {
        }

        @Override // com.sinovoice.hcicloudinputvehicle.tools.ViewOutlineProviderCompatUtils.InsetsUpdater
        public void setInsets(InputMethodService.Insets insets) {
        }
    }

    public static InsetsUpdater a(View view) {
        if (com.sinovoice.hcicloudinputvehicle.tools.a.f230b < 21) {
            return f228a;
        }
        return i.a(view);
    }
}
