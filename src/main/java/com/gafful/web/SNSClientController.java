package com.gafful.web;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.gafful.SNSMobilePush;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;

/**
 * Created by dreamadmin on 2/18/15.
 */
@Controller
public class SNSClientController {



    @RequestMapping("/test/url")
    @ResponseBody
    public String sendPushNotification(HttpServletRequest httpServletRequest,HttpServletResponse servletResponse){
        try {

            InputStream inputStream = SNSMobilePush.class.getResourceAsStream("AwsCredentials.properties");

//            ClassLoader cl = InputStream.class.getClassLoader();
//            String name = "AwsCredentials.properties";
//            resName = name.
//            URL url = ClassLoader.getSystemResource("AwsCredentials.properties");
//            URL url2 = cl.getResource("AwsCredentials.properties");

//            AmazonSNS sns = new AmazonSNSClient(new PropertiesCredentials(
//                    SNSMobilePush.class
//                            .getResourceAsStream("/home/dreamadmin/IdeaProjects/Android/snspushs/src/main/java/com/gafful/web/AwsCredentials.properties")));

            AWSCredentials cred=new BasicAWSCredentials("AKIAJWI2M4VALBVWT75Q","soS8pOijtnutIoSNOnWCMYR6uSlLahzbG6IB1Dpq");
            AmazonSNSClient sns=new AmazonSNSClient(cred);
            sns.setEndpoint("https://sns.us-east-1.amazonaws.com");
            System.out.println("===========================================\n");
            System.out.println("Getting Started with Amazon SNS");
            System.out.println("===========================================\n");

            SNSMobilePush sample = new SNSMobilePush(sns);
			/* TODO: Uncomment the services you wish to use. */
            sample.demoAndroidAppNotification();
            // sample.demoKindleAppNotification();
            // sample.demoAppleAppNotification();
            // sample.demoAppleSandboxAppNotification();
            // sample.demoBaiduAppNotification();
            // sample.demoWNSAppNotification();
            // sample.demoMPNSAppNotification();
        } catch (AmazonServiceException ase) {
            System.out
                    .println("Caught an AmazonServiceException, which means your request made it "
                            + "to Amazon SNS, but was rejected with an error response for some reason.");
            System.out.println("Error Message:    " + ase.getMessage());
            System.out.println("HTTP Status Code: " + ase.getStatusCode());
            System.out.println("AWS Error Code:   " + ase.getErrorCode());
            System.out.println("Error Type:       " + ase.getErrorType());
            System.out.println("Request ID:       " + ase.getRequestId());
        } catch (AmazonClientException ace) {
            System.out
                    .println("Caught an AmazonClientException, which means the client encountered "
                            + "a serious internal problem while trying to communicate with SNS, such as not "
                            + "being able to access the network.");
            System.out.println("Error Message: " + ace.getMessage());
        }



        return "it works :) ";
    }
}
