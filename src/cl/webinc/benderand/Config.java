package cl.webinc.benderand;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;

/**
 * Created by FelipeBarrera on 14-07-2015. actividad de preferencias
 */
public class Config extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getFragmentManager().beginTransaction().replace(android.R.id.content, new MyPreferenceFragment()).commit();
    }

    public static class MyPreferenceFragment extends PreferenceFragment
    {
        @Override
        public void onCreate(final Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.preferencias);
            SharedPreferences SP = PreferenceManager.getDefaultSharedPreferences(getActivity().getBaseContext());
            String strUserName = SP.getString("username", "NA");
            boolean bAppUpdates = SP.getBoolean("applicationUpdates",false);
            String downloadType = SP.getString("downloadType","1");
        }
    }

}