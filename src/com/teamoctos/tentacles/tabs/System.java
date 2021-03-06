/*
 * Copyright (C) 2016 Team-OctOS
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.teamoctos.tentacles.tabs;

import android.content.Context;
import android.content.ContentResolver;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.UserHandle;
import android.preference.ListPreference;
import android.preference.SwitchPreference;
import android.preference.Preference;
import android.preference.PreferenceCategory;
import android.preference.PreferenceScreen;
import android.preference.Preference.OnPreferenceChangeListener;
import android.provider.Settings;

import com.android.settings.R;
import com.android.settings.SettingsPreferenceFragment;
import com.android.internal.logging.MetricsProto.MetricsEvent;
import com.android.settings.Utils;

public class System extends SettingsPreferenceFragment implements
        Preference.OnPreferenceChangeListener {
    private static final String TAG = "System";
    private static final String KERNELADIUTOR_APP_PACKAGE = "com.grarak.kerneladiutor";
    private static final String KERNELADIUTOR_MOD_APP_PACKAGE = "com.kerneladiutor.mod";
    private static final String SUPERSU_APP_PACKAGE = "eu.chainfire.supersu";
    private static final String SUBSTRATUM_APP_PACKAGE = "projekt.substratum";
    private static final String OCTOTA_APP_PACKAGE = "com.fusionjack.octota";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.system);

        ContentResolver resolver = getActivity().getContentResolver();

        if (!Utils.isPackageInstalled(getActivity(), SUPERSU_APP_PACKAGE)) {
            getPreferenceScreen().removePreference(findPreference("supersu_settings"));
        }

        if (!Utils.isPackageInstalled(getActivity(), KERNELADIUTOR_APP_PACKAGE)) {
            getPreferenceScreen().removePreference(findPreference("kerneladiutor_settings"));
        }

        if (!Utils.isPackageInstalled(getActivity(), KERNELADIUTOR_MOD_APP_PACKAGE)) {
            getPreferenceScreen().removePreference(findPreference("kerneladiutor_mod_settings"));
        }

        if (!Utils.isPackageInstalled(getActivity(), SUBSTRATUM_APP_PACKAGE)) {
            getPreferenceScreen().removePreference(findPreference("substratum_settings"));
        }

        if (!Utils.isPackageInstalled(getActivity(), OCTOTA_APP_PACKAGE)) {
            getPreferenceScreen().removePreference(findPreference("octota_settings"));
        }
    }

    @Override
    protected int getMetricsCategory() {
        return MetricsEvent.TENTACLES;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    public boolean onPreferenceChange(Preference preference, Object objValue) {
        final String key = preference.getKey();
        return true;
    }

}
