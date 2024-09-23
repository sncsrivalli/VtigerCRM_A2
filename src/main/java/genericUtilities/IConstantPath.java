package genericUtilities;

/**
 * This interface contains the external file paths
 * @author Srivalli
 */
public interface IConstantPath {

	String PROPERTIES_PATH = System.getProperty("user.dir") + "/src/test/resources/VtigerCRM_commonData.properties";
	String EXCEL_PATH = System.getProperty("user.dir") + "/src/test/resources/VtigerCRM_TestData.xlsx";
	String JDBC_URL = "jdbc:mysql://localhost:3306/advsel_a2";
}
