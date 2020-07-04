package framework;

public interface SearchUserPageRepository {
	
	
	String FH_USER_DATA_PATH = "C:\\Users\\akumsrivasta\\Desktop\\Roche\\AppiumDemo\\src\\main\\resources\\testdata\\FHTestData.xls";
	String VIEW_USER = "//android.widget.Button[@text='VIEW USERS']";
	String SEARCH_BAR = "//android.widget.EditText[@resource-id='com.example.roche:id/searchview']";
	String USER_ICON_PHOTO = "//android.widget.ImageView[@resource-id='com.example.roche:id/user_photo']";
	String USER_ID = "//android.widget.EditText[@resource-id='com.example.roche:id/useridedit']";
	String USER_NAME = "//android.widget.EditText[@resource-id='com.example.roche:id/usernameedit']";
	String EMAIL_ID = "//android.widget.EditText[@resource-id='com.example.roche:id/userEmailedit']";
	String DATE_OF_BIRTH = "//android.widget.EditText[@resource-id='com.example.roche:id/userDateofbirthedit']";

}
