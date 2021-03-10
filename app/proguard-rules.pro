# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

-ignorewarnings
-optimizationpasses 5
-dontusemixedcaseclassnames

-dontpreverify
-verbose
-repackageclasses ''
-allowaccessmodification
-optimizations !code/simplification/arithmetic,!field/*,!class/merging/*
-libraryjars C:/svn/smf-player-android/4.2.0/libsjava/digipass_pref3.jar
-libraryjars C:/svn/smf-player-android/4.2.0/libsjava/sesclient.jar
-libraryjars C:/svn/smf-player-android/4.2.0/libsjava/FlurryAgent.jar
-libraryjars C:/svn/smf-player-android/4.2.0/libsjava4plugins/commons-lang3-3.1.jar
-libraryjars C:/svn/smf-player-android/4.2.0/libsjava4plugins/DSAPP_Client.jar
-libraryjars C:/svn/smf-player-android/4.2.0/libsjava4plugins/kfxengines.jar
-libraryjars C:/svn/smf-player-android/4.2.0/libsjava4plugins/kfxuicontrols.jar
-libraryjars C:/svn/smf-player-android/4.2.0/libsjava4plugins/kfxutilities.jar
-libraryjars C:/svn/smf-player-android/4.2.0/libsjava4plugins/kofax.isg.android.sol.isg_mobile.jar
-libraryjars C:/svn/smf-player-android/4.2.0/libsjava4plugins/ksoap2-android-assembly-2.6.2-CUSTOM-jar-with-dependencies.jar
-libraryjars C:/svn/smf-player-android/4.2.0/libsjava4plugins/SecureStorageSDK.jar
-libraryjars C:/svn/smf-player-android/4.2.0/libsjava4plugins/UtilitiesSDK.jar
-libraryjars C:/svn/smf-player-android/4.2.0/libsjava4plugins/astsdk-debug.jar

-keep class a{*;}
-keep class a$a{*;}
-keep class aa{*;}
-keep class ab{*;}
-keep class ac{*;}
-keep class ad{*;}
-keep class ae{*;}
-keep class af{*;}
-keep class ag{*;}
-keep class ah{*;}
-keep class ai{*;}
-keep class aj{*;}
-keep class ak{*;}
-keep class al{*;}
-keep class am{*;}
-keep class an{*;}
-keep class ao{*;}
-keep class ap{*;}
-keep class aq{*;}
-keep class ar{*;}
-keep class as{*;}
-keep class at{*;}
-keep class au{*;}
-keep class av{*;}
-keep class aw{*;}
-keep class aw$1{*;}
-keep class ax{*;}
-keep class ay{*;}
-keep class az{*;}
-keep class b{*;}
-keep class b$1{*;}
-keep class ba{*;}
-keep class bb{*;}
-keep class bc{*;}
-keep class bd{*;}
-keep class be{*;}
-keep class bf{*;}
-keep class bg{*;}
-keep class bh{*;}
-keep class bi{*;}
-keep class bj{*;}
-keep class bk{*;}
-keep class bl{*;}
-keep class bm{*;}
-keep class bn{*;}
-keep class bo{*;}
-keep class bp{*;}
-keep class bq{*;}
-keep class br{*;}
-keep class bs{*;}
-keep class bt{*;}
-keep class bu{*;}
-keep class bv{*;}
-keep class bw{*;}
-keep class bx{*;}
-keep class by{*;}
-keep class bz{*;}
-keep class c{*;}
-keep class ca{*;}
-keep class cb{*;}
-keep class cc{*;}
-keep class cd{*;}
-keep class ce{*;}
-keep class cf{*;}
-keep class cg{*;}
-keep class ch{*;}
-keep class ci{*;}
-keep class cj{*;}
-keep class ck{*;}
-keep class cl{*;}
-keep class cm{*;}
-keep class cn{*;}
-keep class co{*;}
-keep class cp{*;}
-keep class cq{*;}
-keep class cq$a{*;}
-keep class cq$b{*;}
-keep class cr{*;}
-keep class cs{*;}
-keep class ct{*;}
-keep class ct$a{*;}
-keep class cu{*;}
-keep class cv{*;}
-keep class cw{*;}
-keep class cx{*;}
-keep class cy{*;}
-keep class cz{*;}
-keep class d{*;}
-keep class da{*;}
-keep class db{*;}
-keep class dc{*;}
-keep class dd{*;}
-keep class de{*;}
-keep class de$1{*;}
-keep class df{*;}
-keep class dg{*;}
-keep class dh{*;}
-keep class di{*;}
-keep class dj{*;}
-keep class dk{*;}
-keep class dk$1{*;}
-keep class dl{*;}
-keep class dl$a{*;}
-keep class dm{*;}
-keep class dm$1{*;}
-keep class dm$a{*;}
-keep class dm$b{*;}
-keep class dn{*;}
-keep class do{*;}
-keep class dp{*;}
-keep class dq{*;}
-keep class dr{*;}
-keep class ds{*;}
-keep class dt{*;}
-keep class du{*;}
-keep class dv{*;}
-keep class dw{*;}
-keep class dx{*;}
-keep class dy{*;}
-keep class dz{*;}
-keep class dz$1{*;}
-keep class dz$a{*;}
-keep class dz$b{*;}
-keep class e{*;}
-keep class e$1{*;}
-keep class e$a{*;}
-keep class ea{*;}
-keep class eb{*;}
-keep class eb$a{*;}
-keep class eb$b{*;}
-keep class ec{*;}
-keep class ec$1{*;}
-keep class ed{*;}
-keep class ee{*;}
-keep class ef{*;}
-keep class eg{*;}
-keep class eg$a{*;}
-keep class eg$b{*;}
-keep class eg$c{*;}
-keep class eg$d{*;}
-keep class eg$e{*;}
-keep class eg$f{*;}
-keep class eg$g{*;}
-keep class eg$h{*;}
-keep class eg$i{*;}
-keep class eh{*;}
-keep class ei{*;}
-keep class ei$a{*;}
-keep class ej{*;}
-keep class ej$a{*;}
-keep class ej$b{*;}
-keep class ek{*;}
-keep class el{*;}
-keep class em{*;}
-keep class en{*;}
-keep class eo{*;}
-keep class ep{*;}
-keep class eq{*;}
-keep class er{*;}
-keep class er$1{*;}
-keep class er$a{*;}
-keep class er$b{*;}
-keep class er$c{*;}
-keep class er$d{*;}
-keep class es{*;}
-keep class es$1{*;}
-keep class es$a{*;}
-keep class et{*;}
-keep class et$1{*;}
-keep class eu{*;}
-keep class eu$a{*;}
-keep class ev{*;}
-keep class ew{*;}
-keep class ew$a{*;}
-keep class ex{*;}
-keep class ey{*;}
-keep class ez{*;}
-keep class f{*;}
-keep class fa{*;}
-keep class fb{*;}
-keep class fc{*;}
-keep class fd{*;}
-keep class fe{*;}
-keep class ff{*;}
-keep class fg{*;}
-keep class fh{*;}
-keep class fi{*;}
-keep class fj{*;}
-keep class fk{*;}
-keep class fl{*;}
-keep class fm{*;}
-keep class fn{*;}
-keep class fo{*;}
-keep class fp{*;}
-keep class fq{*;}
-keep class g{*;}
-keep class h{*;}
-keep class i{*;}
-keep class j{*;}
-keep class j$1{*;}
-keep class k{*;}
-keep class l{*;}
-keep class m{*;}
-keep class n{*;}
-keep class n$1{*;}
-keep class o{*;}
-keep class p{*;}
-keep class q{*;}
-keep class r{*;}
-keep class s{*;}
-keep class s$1{*;}
-keep class s$a{*;}
-keep class t{*;}
-keep class u{*;}
-keep class v{*;}
-keep class w{*;}
-keep class x{*;}
-keep class y{*;}
-keep class z{*;}
-keepattributes *Annotation*
-keepattributes Signature


-keep public class * extends android.app.Activity
-keep public class * extends android.app.Application
-keep public class * extends android.app.Service
-keep public class * extends android.content.BroadcastReceiver
-keep public class * extends android.content.ContentProvider
-keep public class io.smartface.*
-keep public class io.smartface.SmartfaceDemo.R*
-keep public class io.smartface.SmartfaceDemo.R$*
-keep public class io.smartface.android.AndroidUI$*
-keep public class io.smartface.android.AndroidUI
-keep public class io.smartface.android.SpRepeatBoxNew
-keep public class io.smartface.android.SpMapViewV2
-keep public class io.smartface.android.SpDatePicker
-keep public class io.smartface.android.SpCodeReader
-keep public class io.smartface.android.SpAnimationRenderer
-keep public class io.smartface.android.SpBitmapRef
-keep public class io.smartface.android.DebugClient
-keep public class io.smartface.android.SpActionBar
-keep public class io.smartface.android.SpActionMenuItem
-keep public class io.smartface.android.SpCanvas
-keep public class io.smartface.android.SpEditText
-keep public class io.smartface.android.SpPicture
-keep public class io.smartface.android.SpratAndroidActivity
-keep public class io.smartface.android.SpScrollView
-keep public class io.smartface.android.SpSlider
-keep public class io.smartface.android.SpWebView

-keep class com.google.zxing.**{
	*;
}


-keep class io.smartface.android.SpWebView$*{
	*;
}



-keep public class io.smartface.android.bitmaps.JniBitmapHolder
-keep public class com.facebook.android.smartfaceplugin.PluginImp {
    ... *(...);
}
-keep public class com.facebook.android.smartfaceplugin.PickFriendsActivity {
    ... *(...);
}
-keep public class com.google.analytic.smartfaceplugin.PluginImp {
    ... *(...);
}
-keep class com.kofax.smartfaceplugin.PluginImp {
    *;
}
-keep public class com.kofax.smartfaceplugin.CaptureActivity {
    ... *(...);
}
-keep public class com.vasco.digipass.sdk.smartfaceplugin.PluginImp {
    ... *(...);
}
-keep public class com.kobil.ast.smartfaceplugin.PluginImp {
    ... *(...);
}
-keep public class com.kobil.ast.smartfaceplugin.KobilAstSdk {
    ... *(...);
}
-keep public class com.kobil.ast.smartfaceplugin.KobilEnums {
    ... *(...);
}
-keep class com.facebook.** {
    *;
}
-keep class com.manateeworks.**{
	*;
}

-keep class com.google.android.gms.analytics.**{
	*;
}

-keep public class io.smartface.android.ui.AssetVideoProvider
-keep public class com.google.**
-keep public class android.support.**
-keep class org.apache.commons.lang3.** {
	*;
}
-keep public class com.vasco.dsapp.client.**
-keep class com.kofax.** {
	*;
}
-keep class com.matateeworks.** {
	*;
}
-keep public class com.vasco.digipass.sdk.**
-keep class bc.java.** {
	*;
}
-keep class bc.org.bouncycastle.** {
	*;
}
-keep class org.kobjects.** {
	*;
}
-keep class org.ksoap2.** {
	*;
}
-keep class org.kxml2.** {
	*;
}
-keep class org.xmlpull.** {
	*;
}
-keep class org.spongycastle.** {
	*;
}
-keep class com.kobil.midapp.** {
	*;
}




-keepclasseswithmembernames public class com.facebook.android.smartfaceplugin.** {
	*;
}
-keepclasseswithmembernames public class com.google.analytic.smartfaceplugin.** {
	*;
}
-keepclasseswithmembernames public class com.kofax.smartfaceplugin.** {
	*;
}
-keepclasseswithmembernames public class com.vasco.digipass.sdk.smartfaceplugin.** {
	*;
}
-keepclasseswithmembernames public class com.facebook.android.*
-keepclasseswithmembernames public class com.flurry.android.*
-keepclasseswithmembernames public class com.google.**{
	*;
}
-keepclasseswithmembernames public class android.support.** {
	*;
}
-keepclasseswithmembernames public class org.apache.commons.lang3.**{
	*;
}
-keepclasseswithmembernames public class com.vasco.dsapp.client.**{
	*;
}
-keepclasseswithmembernames public class com.kofax.**{
	*;
}
-keepclasseswithmembernames public class com.manateeworks.**{
	*;
}
-keepclasseswithmembernames public class com.vasco.digipass.sdk.**{
	*;
}
-keepclasseswithmembernames public class bc.java.**{
	*;
}
-keepclasseswithmembernames public class bc.org.bouncycastle.**{
	*;
}
-keepclasseswithmembernames public class org.kobjects.**{
	*;
}
-keepclasseswithmembernames public class org.ksoap2.**{
	*;
}
-keepclasseswithmembernames public class org.kxml2.**{
	*;
}
-keepclasseswithmembernames public class org.xmlpull.**{
	*;
}

-keepclassmembers public class com.facebook.android.smartfaceplugin.PluginImp
-keepclassmembers public class com.facebook.android.smartfaceplugin.PickFriendsActivity
-keepclassmembers public class com.google.analytic.smartfaceplugin.PluginImp
-keepclassmembers public class com.kofax.smartfaceplugin.PluginImp
-keepclassmembers public class com.kofax.smartfaceplugin.CaptureActivity
-keepclassmembers public class com.vasco.digipass.sdk.smartfaceplugin.PluginImp


-keepclassmembers class * {
    ... *__N(...);
    native <methods>;
    int errorCode__N;
    byte[] staticVectorData__N;
    byte[] dynamicVectorData__N;
    int resultCode__N;
}



-keepclassmembers class * implements android.os.Parcelable {
    static android.os.Parcelable$Creator CREATOR;
}

-keepclassmembers class io.smartface.SmartfaceDemo.R$* {
    public static <fields>;
}