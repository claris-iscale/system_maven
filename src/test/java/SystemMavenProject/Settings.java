package SystemMavenProject;

public class Settings {
	 public static final int LoginTest = 1;
	 public static final int FinanceTest = 2;
	 public static final int LoadFeesTest = 3;
	 //program
	 public static final int ProgramsTest = 4;
	 public static final int ProgramProductsTest = 5;
	 public static final int ProgramProductRefTest = 6;
	 public static final int ProgramCarrierTypeTest = 7;
	 public static final int ProgramDeliveryFeeTest = 8;
	 public static final int ProgramTariffTest= 9;
	 //users
	 public static final int UsersSystemUserTest= 10;
	 public static final int UsersProgramUserTest= 11;	 
	 public static final int IPWhitelistTest= 12;
	 //support
	 public static final int CardholderDetailsTest= 13;
	 //Settings
	 public static final int SettingsPrefundTest= 14;
	 public static final int SettingsDeliveryMethodTest= 15;
	 //Logs
	 public static final int LogsCardholders= 16;
	 public static final int LogsApi= 17;
	 
	 
	   
	   //testing setup
	   
	   public boolean skipTest(String testCase) {
		   boolean runTestCase = true;
		   switch (testCase) {
         case "LoginTest": runTestCase = true;//working - needs enhancement
      	   	break;
         case "FinanceTest": runTestCase = true;//working 
 	   			break;
         case "LoadFeesTest": runTestCase = true;// fixed - needs enhancement 
 	   			break;
         case "ProgramsTest": runTestCase = true; //fixed - passed at first run
         		break;
         case "ProgramProductsTest": runTestCase = true;    //fixed - passed at first run     
 	   			break;
         case "ProgramProductRefTest": runTestCase = true;//working             
 				break;
         case "ProgramCarrierTypeTest": runTestCase = true;//working     
 				break;
         case "ProgramDeliveryFeeTest": runTestCase = true;//working     
				break;
         case "ProgramTariffTest": runTestCase = true;//working        
				break;
         case "UsersSystemUserTest": runTestCase = true; // to fix  // fixed 10/17/18   
				break;
         case "UsersProgramUserTest": runTestCase = true; // to fix   // fixed 10/17/18   
				break;
         case "IPWhitelistTest": runTestCase = true;  //working     
				break;
         case "CardholderDetailsTest": runTestCase = true; // to fix  //fixed 10/17/18
			break;
         case "SettingsPrefundTest": runTestCase = true;         
			break;
         case "SettingsDeliveryMethodTest": runTestCase = true;         
			break;
         case "LogsCardholders": runTestCase = true;         
			break;
			//no script
         case "LogsApi": runTestCase = false;         
			break;
			
         default:  runTestCase = true;
                  break;
		   }
		   
		   return runTestCase;
		   
	   }
}
