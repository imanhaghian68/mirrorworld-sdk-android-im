# Mirror World Web Android SDK

Mirror World's Official TypeScript/JavaScript SDK

## Getting started
Create a developer account at https://app.mirrorworld.fun. Create project and create an API Key.

## Import SDK
*Notice:
The minimum version that SDK requires is Android 4.4.*

1. Download and uncompress [Mirror World Android SDK](http://games.mirrorworld.fun/market_sdk/mirrorsdk.aar).
2. Put the mirrorsdk.aar under folder 'libs'.If there is no libs folder,you may create one.
   ![image](https://internal-api-drive-stream.feishu.cn/space/api/box/stream/download/v2/cover/boxcnm7QhYooAjDdWrAZYp8zB2e/?fallback_source=1&height=1280&mount_node_token=doxcnIIeWAQW8ESeiGush255kXd&mount_point=docx_image&policy=equal&width=1280)
3. Add configeration to build.gradle:
```java
dependencies {
    implementation fileTree(dir: 'libs', include: ['*.jar','*.aar'])
}
```

## Usage
1. Initialization
   We can init Mirror World SDK with the following code:
```java
MirrorSDKJava.getInstance().SetApiKey("your api key");
MirrorSDKJava.getInstance().SetDebug(true);
MirrorSDKJava.getInstance().InitSDK();
```

2. Guild user to login
   When user open your app, you may want to know whether this user needs to login, you can call the following code to know that.
```java
MirrorSDKJava.getInstance().CheckAuthenticated(emailAddr, new MirrorCallback() {
    @Override
    public void callback(boolean isLogin) {
        Log.i("Mirror","This user's login state is:" + isLogin);
    }
});
```
If you want him to login(or again), you can use the following code:
```java
MirrorSDKJava.getInstance().StartLogin(new MirrorCallback() {
    @Override
    public void callback(String result) {
        Log.i("MyApp","Login successed!");
    }
});
```

## Full API Documentation
You can view the documentation for Mirror World SDK for Mobile on [our Official Documentation Site](https://docs.mirrorworld.fun/overview/introduction)
