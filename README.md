![1] FontDroid
==============


Example
-------

The font can be set to a widget in various ways.

##### In XML

All supported widgets can be found in graphical layout tab, you can drag and drop as usually.

![2]

The widgets have the following custom attributes:

```xml
<attr name="typefaceAssetPath" format="string" />
<attr name="typefaceFilePath" format="string" />
<attr name="typefaceCache" format="boolean" />
```

I think the attributes names are self explanatory, but let me say:

* TypefaceAssetPath - Set font from the specified font data
* TypefaceFilePath - Set font from the specified font file.
* TypefaceCache - Load font from cache, default value is true.

###### 1. Set in a single widget.

```xml
<com.hollowsoft.library.fontdroid.TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Font Droid"
        android:textSize="50sp"
        app:typefaceAssetPath="fonts/LeviBrush.ttf" />
```

Also you need put this tag in your root element, that is necessary for Android when working with custom views.

```xml
xmlns:app="http://schemas.android.com/apk/res-auto"
```

Now let me show you the full sample.

```xml
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent" >

    <com.hollowsoft.library.fontdroid.TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_centerInParent="true"
        android:text="Font Droid"
        android:textSize="50sp"
        app:typefaceAssetPath="fonts/LeviBrush.ttf" />

</RelativeLayout>
```

###### 2. Set to the entire application.

Here you still need to use the custom widgets, but you can set the custom font in a style,
the style must have the name `TextAppearance.Hollow`.

```xml
<style name="TextAppearance.Hollow" parent="@android:style/TextAppearance.Holo">
    <item name="typefaceAssetPath">fonts/LeviBrush.ttf</item>
</style>
```

You can use this style normally like `textAppearance` atribute.

```xml
<style name="Theme.Example" parent="@android:style/Theme.Holo.Light.DarkActionBar">
    <item name="android:textAppearance">@style/TextAppearance.Hollow</item>
</style>
```

##### In Java


Thanks
------

Fonts used in sample application:

* [Bombing](http://qkila.com)
* [Dark Net Warrior](http://www.imagex-fonts.com)
* [Jenna Sue](http://www.jennasuedesign.com)
* [Levi Brush](http://loremipsum.ro)
* [Orange Juice](http://brittneymurphydesign.com)


License
-------

```
    Copyright (c) 2014 HollowSoft @IgorMorais
    
    Licensed under the Apache License, Version 2.0 (the “License”);
    you may not use this file except in compliance with the License.
    
         You may obtain a copy of the License at
         http://www.apache.org/licenses/LICENSE-2.0
         
    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an “AS IS” BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
```


[1]: https://raw.githubusercontent.com/MoraisIgor/FontDroid/master/raw/android.png
[2]: https://raw.githubusercontent.com/MoraisIgor/FontDroid/master/raw/widget.png
