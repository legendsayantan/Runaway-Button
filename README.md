# Runaway-Button
an Android button that... can Run Away!

#### Runaway-Button moves away when the user should not click the button... so disable the button to see its Runaway Animations in Action. It behaves as a normal button when in enabled state.

[Demo Apk](https://github.com/legendsayantan/Runaway-Button/raw/master/app/release/app-release.apk)
[Demo Usage](https://github.com/legendsayantan/Runaway-Button/blob/master/app/src/main/java/com/legendsayantan/runawaybuttonshowcase/MainActivity.java)

Or, feel free to clone this repo in Android Studio and build the demo apk yourself.

## Add to your project

#### Step 1. Add the JitPack repository to your build file

**Gradle:**
Add it in your root build.gradle at the end of repositories:

(or , in settings.gradle inside `dependencyResolutionManagement` repositories) 


```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

**Maven:**
```
	<repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>
  ```
  
  #### Step 2. Add the Dependency
  
  **Gradle:**
  
 ```
  dependencies {
		implementation 'com.github.legendsayantan:Runaway-Button:1.1'
	}
```

**Maven:**

```
	<dependency>
	    <groupId>com.github.legendsayantan</groupId>
	    <artifactId>Runaway-Button</artifactId>
	    <version>1.1</version>
	</dependency>
  ```
  
  
  ## How to use
  
  ### activity.xml:
  
```
    <com.legendsayantan.runawaybutton.RunawayButton
        android:id="@+id/runawayButton"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Submit"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" 
        //...any other properties of AppCompatButton
        />
```

### activity.java:
#### Import library-
```
import com.legendsayantan.runawaybutton.RunawayButton;
```

#### Create a `RunawayButton`-
```
RunawayButton runawayButton = findViewById(R.id.runawayButton);
```

#### `RunawayButton` will only **Run Away** when its disabled-
```
runawayButton.setEnabled(false);
```

#### Customise the Button-

- set duration of runaway animation in ms
```
runawayButton.setAnimationTime(150); 
```
- Which direction(s) to run away

Possible values: `MOVE_ALL_DIRECTION` , `MOVE_HORIZONTAL` , `MOVE_VERTICAL` , `MOVE_LEFT` , `MOVE_RIGHT` , `MOVE_UP` , `MOVE_DOWN`
```
runawayButton.setAnimationDirection(RunawayButton.MOVE_ALL_DIRECTION); 
//Note: It is recommended to keep some empty space in the direction of animation, So the button can move around freely.
```
- Register Animation Adapter for callbacks
```
runawayButton.setAnimationListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationCancel(Animator animation) {
                super.onAnimationCancel(animation);
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                super.onAnimationRepeat(animation);
            }

            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
            }

            @Override
            public void onAnimationPause(Animator animation) {
                super.onAnimationPause(animation);
            }

            @Override
            public void onAnimationResume(Animator animation) {
                super.onAnimationResume(animation);
            }
        });
```
- Reveal a warning text (or image) everytime the button runs away:
```
TextView warning = new TextView(getApplicationContext());
warning.setText("this is a warning");
runawayButton.setWarningView(warning,findViewById(R.id.parentView)); 
//parentView should be the parent viewgroup (or layout) of the RunawayButton.
```
- Remove the warning View:
```
runawayButton.setWarningView(null,findViewById(R.id.parentView));
```
- Text displayed on RunawayButton
```
runawayButton.setText("Button"); 
```
- Set OnClickListener on RunawayButton

onClickListener will only be triggered if the `RunawayButton` is enabled and it **did not run away**.
```
runawayButton.setOnClickListener(v -> Toast.makeText(getApplicationContext(),"Runaway Button Clicked",Toast.LENGTH_LONG).show());
```

...and any other AppCompatButton property can be customised.

## Contribute
Any improvements are welcome. Contribute by creating an Issue or Pull Request.

## License

MIT License

Copyright (c) 2022 Sayantan Paul

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
