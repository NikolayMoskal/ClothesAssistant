package by.grsu.neon.clothesassistant;

import android.content.Context;
import android.content.res.Resources;

public final class Config {
    public final String APP_ID;
    public final String APP_KEY;
    public final String API_URL;
    public final String AIRPORT_URL;
    public final String FS_URL;
    public final String FS_TYPE;
    private final Resources resources;

    public Config(Context context) {
        resources = context.getResources();
        APP_ID = resources.getString(R.string.appId);
        APP_KEY = resources.getString(R.string.appKey);
        API_URL = resources.getString(R.string.api_url);
        AIRPORT_URL = resources.getString(R.string.airport_url);
        FS_URL = resources.getString(R.string.flight_status_url);
        FS_TYPE = resources.getString(R.string.flight_type);
    }
}
