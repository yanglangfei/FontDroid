![1] FontDroid
==============

FontDroid is a small library that gives the ability to use custom fonts in your Android application, you can use any font with extension `.TTF` or `.OTF`.

Supported widgets:

* [AutoCompleteTextView](http://developer.android.com/reference/android/widget/AutoCompleteTextView.html)
* [Button](http://developer.android.com/reference/android/widget/Button.html)
* [CheckBox](http://developer.android.com/guide/topics/ui/controls/checkbox.html)
* [CheckedTextView](http://developer.android.com/reference/android/widget/CheckedTextView.html)
* [Chronometer](http://developer.android.com/reference/android/widget/Chronometer.html)
* [DigitalClock](http://developer.android.com/reference/android/widget/DigitalClock.html)
* [EditText](http://developer.android.com/reference/android/widget/EditText.html)
* [MultiAutoCompleteTextView](http://developer.android.com/reference/android/widget/MultiAutoCompleteTextView.html)
* [RadioButton](http://developer.android.com/guide/topics/ui/controls/radiobutton.html)
* [Switch](http://developer.android.com/reference/android/widget/Switch.html)
* [TextClock](http://developer.android.com/reference/android/widget/TextClock.html)
* [TextView](http://developer.android.com/reference/android/widget/TextView.html)
* [ToggleButton](http://developer.android.com/reference/android/widget/ToggleButton.html)


Example
-------

The custom font can be set to a widget in various ways, all examples below are using a plain `TextView`, but all widgets have the same usage.

##### In XML

All supported widgets can be found in graphical layout tab, you can drag and drop as usually.

![2]

These widgets have the following custom attributes:

```xml
<attr name="typefaceAssetPath" format="string" />
<attr name="typefaceFilePath" format="string" />
<attr name="typefaceCache" format="boolean" />
```

I think the attributes names are self explanatory, but let me say:

* TypefaceAssetPath - Typeface path from the specified asset folder
* TypefaceFilePath - Typeface path from the specified file
* TypefaceCache - Load typeface from cache, default value is true

###### 1. Set in a single widget

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

###### 2. Set to the entire application

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

This isn't the best way, but sometimes you will need to set by code.

###### 1. Extends abstract widgets

All widgets have an abstract class(ex: `AbstractTextView`), you can extends and implement an abstract method `getTypefaceAssetPath()` in your subclass.

```java
/**
 * Get {@code Typeface} path from the specified asset folder.
 *
 * @return The {@code Typeface} path from the specified asset folder.
 */
protected String getTypefaceAssetPath() {
    return "fonts/LeviBrush.ttf";
}
```

###### 2. Use the custom widget classes

Like a normal way, but you have a few new methods.

```java
TextView textView = (TextView) findViewById(R.id.text_view);
textView.setTypeface("fonts/LeviBrush.ttf", PathType.ASSET);
```

or

```java
TextView textView = new TextView(this);
textView.setTypeface("fonts/LeviBrush.ttf", PathType.ASSET);
```

Pay attention on import

```java
import com.hollowsoft.library.fontdroid.TextView;
```

You can also look at sample application for more detailed information.


Thanks
------

Fonts used in sample application:

* [Bombing](http://qkila.com)
* [Dark Net Warrior](http://www.imagex-fonts.com)
* [Jenna Sue](http://www.jennasuedesign.com)
* [Levi Brush](http://loremipsum.ro)
* [Orange Juice](http://brittneymurphydesign.com)

Awesome tools for code quality improvement:

* [Android Lint](http://developer.android.com/tools/help/lint.html)
* [Checkstyle](http://checkstyle.sourceforge.net)
* [FindBugs](http://findbugs.sourceforge.net)
* [PMD](http://pmd.sourceforge.net)


Contact
-------

[My HomePage](http://igormorais.com) :)


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
