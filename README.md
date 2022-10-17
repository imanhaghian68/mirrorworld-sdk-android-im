# Mirror World Android SDK

Mirror World's Official Android SDK

## Getting started

Create a developer account on the [Developer dashboard](https://app.mirrorworld.fun). Create project and create an API Key.

## Import SDK

*Notice:
The minimum version that SDK requires is Android 4.4.*

1.  Download and uncompress [Mirror World Android SDK](https://github.com/mirrorworld-universe/mirrorworld-sdk-android/releases/tag/v1.1.0).
2.  Put the mirrorsdk.aar under folder 'libs'.If there is no libs folder,you may create one.
    <img src="https://market-assets.mirrorworld.fun/docs/build.png" width="30%" height="30%" />
3.  Add configeration to build.gradle:

```java
dependencies {
    implementation fileTree(dir: 'libs', include: ['*.jar','*.aar'])
}
```

## Usage

1.  Initialization
    We can init Mirror World SDK with the following code:

```java
Activity activity = this;
String apiKey = "your api key";
boolean useDebugMode = true;

MirrorSDK.getInstance().SetApiKey(apiKey);
MirrorSDK.getInstance().SetDebug(useDebugMode);
MirrorSDK.getInstance().InitSDK(activity,MirrorEnv.DevNet);
```

1.  Guide user to login
    When user open your app, you may want to know whether this user needs to login, you can call the following code to know that.

```java
MirrorSDK.getInstance().CheckAuthenticated(emailAddr, new BoolListener() {
    @Override
    public void onBool(boolean boolValue) {
        Log.i("Mirror","This user's login state is:" + boolean);
    }
});
```

If you want him to login(or again), you can use the following code:

```java
MirrorSDK.getInstance().StartLogin(new LoginListener() {
    @Override
    public void onLoginSuccess() {
        Log.i("Mirror","User login success!");
    }

    @Override
    public void onLoginFail() {
        Log.i("Mirror","User login failed!");
    }
});
```

## Full API Documentation

You can view the documentation for Mirror World SDK for Mobile on [our Official Documentation Site](https://docs.mirrorworld.fun/android/android-APIReference)
