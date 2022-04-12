package Utils;
import org.apache.pdfbox.pdmodel.graphics.shading.AxialShadingContext;
import org.testng.Assert;
public class Assertion {
    public static String validation(String expected,String Actual){
        try {
            Assert.assertEquals(expected, Actual);
            return "Pass";
        }catch(AssertionError e){
            return "fail";
        }
    }
}
