/*
 * Copyright (c) 2014 HollowSoft @IgorMorais
 *
 * Licensed under the Apache License, Version 2.0 (the “License”);
 * you may not use this file except in compliance with the License.
 *
 *          You may obtain a copy of the License at
 *          http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an “AS IS” BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.hollowsoft.library.fontdroid;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import android.content.Context;
import android.graphics.Typeface;

/**
 * @author Igor Morais
 * @author mor41s.1gor@gmail.com
 */
public final class TypefaceCache {

    /**
     *
     */
    private static final String SEPARATOR = "/";

    /**
     *
     */
    private static final String DOT = ".";

    /**
     *
     */
    private final Map<String, Typeface> typefaceMap = new HashMap<String, Typeface>();

    /**
     * Default private constructor.
     */
    private TypefaceCache() {

    }

    /**
     * @author Igor Morais
     * @author Mor41s.1gor@gmail.com
     */
    public enum PathType {
        ASSET, FILE;
    }

    /**
     * @author Igor Morais
     * @author Mor41s.1gor@gmail.com
     */
    static final class LazyLoader {
        static final TypefaceCache INSTANCE = new TypefaceCache();
    }

    /**
     *
     * @return
     */
    public static TypefaceCache getInstance() {
        return LazyLoader.INSTANCE;
    }

    /**
     *
     * @param typefacePath
     * @return
     */
    public static String getTypefaceName(final String typefacePath) {
        if (typefacePath == null || typefacePath.isEmpty()) {
            throw new IllegalArgumentException("The typefacePath cannot be null or empty.");
        }

        if (!typefacePath.contains(DOT)) {
            throw new IllegalArgumentException("The typefacePath is invalid.");
        }

        final String[] typefacePathArray = typefacePath.split(SEPARATOR);

        final String typefaceName = typefacePathArray[typefacePathArray.length - 1];

        return typefaceName.substring(0, typefaceName.indexOf(DOT)).toLowerCase(Locale.getDefault());
    }

    /**
     *
     * @param typefaceName
     * @return
     */
    public Typeface get(final String typefaceName) {
        if (typefaceName == null || typefaceName.isEmpty()) {
            throw new IllegalArgumentException("The typefaceName cannot be null or empty.");
        }

        return typefaceMap.get(typefaceName.toLowerCase(Locale.getDefault()));
    }

    /**
     *
     * @param context
     * @param typefacePath
     * @param pathType
     * @return
     */
    public Typeface get(final Context context, final String typefacePath, final PathType pathType) {
        if (context == null) {
            throw new IllegalArgumentException("The context cannot be null.");
        }

        if (typefacePath == null || typefacePath.isEmpty()) {
            throw new IllegalArgumentException("The typefacePath cannot be null or empty.");
        }

        if (!typefacePath.contains(DOT)) {
            throw new IllegalArgumentException("The typefacePath is invalid.");
        }

        if (pathType == null) {
            throw new IllegalArgumentException("The pathType cannot be null.");
        }

        Typeface typeface;

        final String typefaceName = getTypefaceName(typefacePath);

        if (typefaceMap.containsKey(typefaceName)) {
            typeface = typefaceMap.get(typefaceName);

        } else {

            typeface = pathType == PathType.ASSET ? Typeface.createFromAsset(context.getAssets(), typefacePath)
                    : Typeface.createFromFile(typefacePath);

            if (typeface == null) {
                throw new TypefaceException("The typeface cannot be created.");
            }

            typefaceMap.put(typefaceName, typeface);
        }

        return typeface;
    }

    /**
     *
     * @param context
     * @param typefacePath
     * @param pathType
     * @return
     */
    public Typeface add(final Context context, final String typefacePath, final PathType pathType) {
        if (context == null) {
            throw new IllegalArgumentException("The context cannot be null.");
        }

        if (typefacePath == null || typefacePath.isEmpty()) {
            throw new IllegalArgumentException("The typefacePath cannot be null or empty.");
        }

        if (!typefacePath.contains(DOT)) {
            throw new IllegalArgumentException("The typefacePath is invalid.");
        }

        if (pathType == null) {
            throw new IllegalArgumentException("The pathType cannot be null.");
        }

        final Typeface typeface = pathType == PathType.ASSET ? Typeface.createFromAsset(context.getAssets(),
                typefacePath) : Typeface.createFromFile(typefacePath);

        if (typeface == null) {
            throw new TypefaceException("The typeface cannot be created.");
        }

        typefaceMap.put(getTypefaceName(typefacePath), typeface);

        return typeface;
    }

    /**
     *
     * @param typefaceName
     * @return
     */
    public Typeface remove(final String typefaceName) {
        if (typefaceName == null || typefaceName.isEmpty()) {
            throw new IllegalArgumentException("The typefaceName cannot be null or empty.");
        }

        return typefaceMap.remove(typefaceName.toLowerCase(Locale.getDefault()));
    }

    /**
     *
     */
    public void removeAll() {
        typefaceMap.clear();
    }
}
