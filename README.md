# Mirror World Android SDK

Mirror World's Official Android SDK

## Getting started

Create a developer account on the [Developer dashboard](https://app.mirrorworld.fun). Create project and create an API Key.

## Import SDK


> **Notice:**
>
> *The minimum version that SDK requires is Android 4.4.*

1.  Download and uncompress [Mirror World Android SDK](https://github.com/mirrorworld-universe/mirrorworld-sdk-android/releases/latest).
2.  Put the `mirrorsdk.aar` under the 'libs' folder. You may create a 'libs' folder if it doesn't exist
    <img src="https://market-assets.mirrorworld.fun/docs/build.png" width="30%" height="30%" />

3.  Add configeration to build.gradle:

```java
dependencies {
        implementation fileTree(dir: 'libs', include: ['*.jar','*.aar'])
        }
```

4. Config CustomTab!
   If you want to use CustomTab to show content to users (Recommended), you need to configure the following on your AndroidManifest.xml:

**Add permission for internet**
```xml
<uses-permission android:name="android.permission.INTERNET" />
```

**Register this activity**
```xml
<activity
    android:name="com.mirror.sdk.activities.RedirectActivity"
    android:exported="true">

    <intent-filter>
        <action android:name="android.intent.action.VIEW"/>
        <category android:name="android.intent.category.DEFAULT"/>
        <category android:name="android.intent.category.BROWSABLE"/>
        <data android:scheme="mwsdk"/>
    </intent-filter>
</activity>
```

The final file would look like this:
```xml
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    package="com.mirror.mirrorworld_sdk_android">

    <uses-permission android:name="android.permission.INTERNET" />

    <application
        android:allowBackup="true"
        android:dataExtractionRules="@xml/data_extraction_rules"
        android:fullBackupContent="@xml/backup_rules"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:networkSecurityConfig="@xml/network_security_config"

        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/Theme.Mirrorworldsdkandroid"
        tools:targetApi="31">
        <activity
            android:name=".MainActivity"
            android:launchMode="singleTask"
            android:exported="true">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />
                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>


        <activity
            android:name="com.mirror.sdk.activities.RedirectActivity"
            android:exported="true">

            <intent-filter>
                <action android:name="android.intent.action.VIEW"/>
                <category android:name="android.intent.category.DEFAULT"/>
                <category android:name="android.intent.category.BROWSABLE"/>
                <data android:scheme="mwsdk"/>
            </intent-filter>
        </activity>
    </application>

</manifest>
```

**Add dependency**
```xml
implementation 'androidx.browser:browser:1.4.0'
```

You should now see CustomTab when you try to open our prepared web page.


>*Tips: If you want your app to have only one task, you can set your own activity to SingTast:*
>```xml
>android:launchMode="singleTask"
>```
And finnaly,your activity config may like this:
```xml
<activity
    android:name=".MainActivity"
    android:launchMode="singleTask"
    android:exported="true">
    <intent-filter>
        <action android:name="android.intent.action.MAIN" />
        <category android:name="android.intent.category.LAUNCHER" />
    </intent-filter>
</activity>
```


## Usage
### Choose your chain
Developers must use specified classes to call APIs on specified chains.  
*For example, if they want to call init API on the BNB chain, they must call MWEVM.initSDK().*

>And this is their correspondence:
>- Solana:MWSolana
>- Ethereum:MWEVM
>- Polygon:MWEVM
>- BNB Chain:MWEVM

In the following documents, we will use solana chain to show how to use Mirror SDK.

### Initialization
We can initialize Mirror World SDK with the following code:

```java
Context context = this;
String apiKey = "your-api-key";
MirrorEnv env = MirrorEnv.DevNet;

MWSolana.initSDK(context,apiKey,env);
```

### Guide user to login
Users need to log in to use some MirrorSDK features (or APIs).
If you want them to login for the first time or once again, use the following code:

```java
MWSolana.startLogin(new LoginListener() {
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

But you may not want to let them login every time, so you can use CheckAuthenticated API to check if they have already logged in.
According the result, you can show them a login button or hide your login button and make them enter your dApp or game directly.

```java
MWSolana.isLoggedIn(new BoolListener() {
    @Override
    public void onBool(boolean boolValue) {
        Log.i("Mirror","This user's login state is:" + boolean);
    }
});
```

### Open wallet
Users may want to check their wallet in the app, you can use the `openWallet` API for this:

```java
MWSolana.openWallet();
```

### User get NFTs
Fetch a user's NFTs by calling `fetchNFTsByOwnerAddresses`

```java
List<String> owners = new ArrayList<>();
owners.add("owner_wallet_address_1");
owners.add("owner_wallet_address_2");
int limit = 1;
int offset = 1;

MWSolana.fetchNFTsByOwnerAddresses(owners, limit, offset, new FetchByOwnerListener() {
    @Override
    public void onFetchSuccess(MultipleNFTsResponse multipleNFTsResponse) {
        int count = multipleNFTsResponse.nfts.size();
        String countStr = "You have " + count + " NFTs";
        Log.d("MirrorSDK",countStr);
    }

    @Override
    public void onFetchFailed(long code, String message) {
        String errorString = "Fetch NFTs error, error code:" + code + " message:" + message;
        Log.d("MirrorSDK",errorString);
    }
});
```
>Or you can fetch NFTs by another parameter:
>- fetchNFTsByMintAddresses
>- fetchNFTsByOwnerAddresses
>- fetchNFTsByCreatorAddresses
>- fetchNFTsByUpdateAuthorities
>
>Refer to the documentation for the complete [API Reference](https://docs.mirrorworld.fun/android/android-APIReference).

### Transfer & List
#### Transfer NFT
You can transfer an NFT to another wallet:

```java
String mint_address = "nft mint address";
String to_wallet_address = "target wallet address";
Activity activity = this;
String confirmation = MirrorConfirmation.Default;

MWSolana.transferNFT(activity, mint_address, to_wallet_address, confirmation, new TransferNFTListener() {
    @Override
    public void onTransferSuccess(ListingResponse listingResponse) {
        Log.d("Transfer result","success");
    }
    
    @Override
    public void onTransferFailed(long code, String message) {
        String errorString = "Fetch NFTs error, error code:" + code + " message:" + message;
        Log.d("MirrorSDK",errorString);
    }
});
```

#### List
If you want to list an NFT on a marketplace,you may use these code:
```java
Activity activity = this;
String confirmation = MirrorConfirmation.Default;
String mint_address = "nft_mint_address";
Double price = 0.1;

MWSolana.listNFT(activity, mint_address, price, confirmation, new ListNFTListener() {
    @Override
    public void onListSuccess(ListingResponse listingResponse) {
        Log.d("ListNFT success","price is:"+listingResponse.price);
    }
    
    @Override
    public void onListFailed(long code, String message) {
        Log.d("ListNFT faild",message);
    }
});
```

## Full API Documentation

You can view the documentation for Mirror World SDK for Mobile on
[our Official Documentation Site](https://docs.mirrorworld.fun/android/android-api)
