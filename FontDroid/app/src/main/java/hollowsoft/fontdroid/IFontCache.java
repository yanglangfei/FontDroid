package hollowsoft.fontdroid;

import android.content.res.AssetManager;
import android.graphics.Typeface;

public interface IFontCache {

    Typeface get(String path);

    Typeface put(String path, AssetManager assetManager);

    Typeface remove(String path);

    void clear();
}
