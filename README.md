# Runaway-Button
an Android button that... can Run Away!

#### Runaway-Button moves away when the user should not click the button... so disable the button to see its Runaway Animations in Action. It behaves as a normal button when in enabled state.
Feel free to clone this repo in Android Studio and build demo apk , or you can also download demo apk from releases.
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
//parentView should be the parent view (or viewgroup) of the RunawayButton.
```
- Remove the warning View:
```
runawayButton.setWarningView(null,findViewById(R.id.parentView));
```
- Text displayed on RunawayButton
```
runawayButton.setText("Button"); 
```
- ...and any other AppCompatButton properties


