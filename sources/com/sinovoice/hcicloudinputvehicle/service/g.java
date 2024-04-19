package com.sinovoice.hcicloudinputvehicle.service;

import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.sinovoice.hcicloudinputvehicle.R;
/* compiled from: SettingsFragment.java */
/* loaded from: classes.dex */
public final class g extends PreferenceFragment {

    /* renamed from: a  reason: collision with root package name */
    private static Preference.OnPreferenceChangeListener f225a = new a();

    /* compiled from: SettingsFragment.java */
    /* loaded from: classes.dex */
    class a implements Preference.OnPreferenceChangeListener {
        a() {
        }

        @Override // android.preference.Preference.OnPreferenceChangeListener
        public boolean onPreferenceChange(Preference preference, Object obj) {
            String obj2 = obj.toString();
            if (preference instanceof ListPreference) {
                ListPreference listPreference = (ListPreference) preference;
                int findIndexOfValue = listPreference.findIndexOfValue(obj2);
                preference.setSummary(findIndexOfValue >= 0 ? listPreference.getEntries()[findIndexOfValue] : null);
                return true;
            }
            return true;
        }
    }

    private static void a(Preference preference) {
        preference.setOnPreferenceChangeListener(f225a);
        f225a.onPreferenceChange(preference, PreferenceManager.getDefaultSharedPreferences(preference.getContext()).getString(preference.getKey(), ""));
    }

    @Override // android.preference.PreferenceFragment, android.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @Override // android.preference.PreferenceFragment, android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
        addPreferencesFromResource(R.xml.preferences);
        getPreferenceScreen().setTitle(R.string.setting);
        a(findPreference(getResources().getString(R.string.setting_split_mode_key)));
    }

    @Override // android.preference.PreferenceFragment, android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // android.preference.PreferenceFragment, android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.preference.PreferenceFragment, android.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
    }
}
