package smartface.com.nativetest.RootDetection;

import android.content.Context;
import android.content.pm.PackageManager;

import java.io.File;

public class RootDetection {
   public  static boolean checkAppPackages(String[] pNames, Context ctx){
       boolean packageFound = false;
       for(String pName : pNames){
           try {
               ctx.getPackageManager().getPackageInfo(pName, 0);
               packageFound = true;
               break;
           }catch (PackageManager.NameNotFoundException e){
               //ignore
           }
       }
       return packageFound;
   }

   public static boolean checkSuBinaryExistance(String[] suAbsBinaryPaths){
       boolean suFilesThere = false;
       for (String suAbsBinaryPath : suAbsBinaryPaths) {
           File suFile = new File(suAbsBinaryPath,"su");
           suFilesThere = suFile.exists();
           if(suFilesThere)
               break;
       }
       return  suFilesThere;
   }

   public  static boolean checkRootAccessGained(String[] systemPaths){
       boolean accessGained = false;
       for (String systemPath : systemPaths) {
           File sPath = new File(systemPath);
           String abs = sPath.getAbsolutePath();
           boolean exist = sPath.exists();
           if(accessGained = sPath.canRead())
               break;
       }
       return  accessGained;
   }
}
