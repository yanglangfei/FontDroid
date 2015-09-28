package hollowsoft.fontdroid;

import android.content.res.AssetManager;
import android.graphics.Typeface;

import java.util.HashMap;
import java.util.Map;

public final class FontCache implements IFontCache {

    private final Map<String, Typeface> fontMap = new HashMap<>();

    private static class LazyLoader {
        private static final FontCache INSTANCE = new FontCache();
    }

    private FontCache() {

    }

    public static FontCache with() {
        return LazyLoader.INSTANCE;
    }

    @Override
    public Typeface get(final String path) {
        return fontMap.get(path);
    }

    @Override
    public Typeface put(final String path, final AssetManager assetManager) {

        if (path == null) {
            throw new IllegalArgumentException("The path cannot be null.");
        }

        if (assetManager == null) {
            throw new IllegalArgumentException("The assetManager cannot be null.");
        }

        if (fontMap.containsKey(path)) {
            return get(path);
        }

        final Typeface typeface = Typeface.createFromAsset(assetManager, path);

        return fontMap.put(path, typeface);
    }

    @Override
    public Typeface remove(final String path) {
        return fontMap.remove(path);
    }

    @Override
    public void clear() {
        fontMap.clear();
    }
}
