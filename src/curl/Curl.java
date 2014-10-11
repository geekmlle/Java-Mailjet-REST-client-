package curl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

public class Curl {
 public static void main(String[] args) throws ClientProtocolException, IOException {
  HttpClient client = new DefaultHttpClient();
  HttpPost post = 
          new HttpPost("https://public:private@api.mailjet.com/v3/send/message");
  
  List nameValuePairs = new ArrayList(1);
  nameValuePairs.add(new BasicNameValuePair("from", "email@gmail.com")); 
  nameValuePairs.add(new BasicNameValuePair("to", "email@gmail.com")); 
  nameValuePairs.add(new BasicNameValuePair("subject", "Sup? 2")); 
  nameValuePairs.add(new BasicNameValuePair("html","<b><font color=\"blue\">Good job! Recycling a single aluminium can saves enough energy to power your television for three hours or to run a 100-watt light bulb for almost four hours.</font></b>")); 
    //you can as many name value pair as you want in the list.
  post.setEntity(new UrlEncodedFormEntity(nameValuePairs));
  HttpResponse response = client.execute(post);
  int statusCode = response.getStatusLine().getStatusCode();
  System.out.println(statusCode);
 }
}

//http://harryjoy.com/2012/09/08/simple-rest-client-in-java/