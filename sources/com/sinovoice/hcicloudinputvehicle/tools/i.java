package com.sinovoice.hcicloudinputvehicle.tools;

import android.annotation.TargetApi;
import android.graphics.Outline;
import android.inputmethodservice.InputMethodService;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.sinovoice.hcicloudinputvehicle.tools.ViewOutlineProviderCompatUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ViewOutlineProviderCompatUtilsLXX.java */
@TargetApi(21)
/* loaded from: classes.dex */
public class i {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ViewOutlineProviderCompatUtilsLXX.java */
    /* loaded from: classes.dex */
    public static class a extends ViewOutlineProvider implements ViewOutlineProviderCompatUtils.InsetsUpdater {

        /* renamed from: a  reason: collision with root package name */
        private final View f235a;

        /* renamed from: b  reason: collision with root package name */
        private int f236b = -1;

        public a(View view) {
            this.f235a = view;
            view.setOutlineProvider(this);
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            if (this.f236b == -1) {
                ViewOutlineProvider.BACKGROUND.getOutline(view, outline);
            } else {
                outline.setRect(view.getLeft(), this.f236b, view.getRight(), view.getBottom());
            }
        }

        @Override // com.sinovoice.hcicloudinputvehicle.tools.ViewOutlineProviderCompatUtils.InsetsUpdater
        public void setInsets(InputMethodService.Insets insets) {
            int i = insets.visibleTopInsets;
            if (this.f236b != i) {
                this.f236b = i;
                this.f235a.invalidateOutline();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ViewOutlineProviderCompatUtils.InsetsUpdater a(View view) {
        a aVar = new a(view);
        view.setOutlineProvider(aVar);
        return aVar;
    }
}
