package ecospy.server.BusinessLogic;

import ecospy.server.BusinessLogic.TAG.TAGController;
import ecospy.server.Utility.IntStringWrapper;
import ecospy.server.Utility.ResponseCodeInterpreter;
import ecospy.server.Utility.UtilityTools;

import java.io.InputStream;

public class MainExecutor {
	TAGController ocr;

	public MainExecutor(){
		this.ocr = new TAGController();
	}
	IntStringWrapper resolveImage(InputStream is){
		System.out.println("Resolve Image Begin @ "+UtilityTools.getCurrentTime());

		//Get the image in byte[] from InputSream of HttpExchange
		byte[] img = TAGController.InputStream2Img(is);

		//Get the result of Oxford TAG, info contains result JSON or error message;
		//depending on the response code.
		IntStringWrapper result = ocr.getOCRResult(img);
		System.out.println("Resolve Image End @ "+UtilityTools.getCurrentTime());
		System.out.println("Oxford-TAG response code is : "+result.getCode());
		

		if(result.getCode()!=200){
			System.out.println("ERROR: TAG can't do, response "+result.getCode());
			return new IntStringWrapper(result.getCode(),ResponseCodeInterpreter.getExplain(result.getCode()));
		}

        return result;
		

	}
}
