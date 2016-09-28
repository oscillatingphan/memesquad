import java.io.InputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import java.util.Scanner;

/**
   This program demonstrates how to use an URL connection 
   to communicate with a web server.
   RK Modified from Horstmann: Big Java 2001
*/
public class StatExplorer
{
  public static void main(String[] args) throws IOException
  {
    String url = "";
    Scanner userInput = new Scanner(System.in);

    System.out.println("What website do you want to examine?");
    url += userInput.nextLine();
    
    if (!url.contains("http"))
    {
      url = "http://" + url;
    }
        
    URL u = new URL(url);
    URLConnection connection = u.openConnection();

    // check if response code is HTTP_OK (200)
    HttpURLConnection httpConnection = (HttpURLConnection) connection;
    int code = httpConnection.getResponseCode();
    if (code != HttpURLConnection.HTTP_OK)
    {
       String message = httpConnection.getResponseMessage(); 
       System.out.println(code + " " + message);
       return;
    }
    InputStream in = connection.getInputStream();
    Scanner sc = new Scanner(in);
    String entirePage = "";
    String line;
    int counter = 0;
    int counterPepe = 0;
    int counterDoge = 0;
    int counterHarambe = 0;
    int counterTrump = 0;
    
    
    while (sc.hasNextLine())
    {
      line = sc.nextLine();
      entirePage += line + "\n";
      counter += countImages(line);
      counterPepe+=countPepe(line);
      counterDoge+=countDoge(line);
      counterHarambe+=countHarambe(line);
      counterTrump+=countTrump(line);
    }
    System.out.println("Let's see what is the most popular meme on " + url); 
    System.out.println("There are " + counterPepe + " instances of Pepe.");
    System.out.println("There are " + counterDoge + " instances of Doge.");
    System.out.println("There are " + counterHarmabe + " instances of Harambe.");
    System.out.println("There are " + counterTrump + " instances of Donnie Trump.");
  }
  public static int countImages(String line)
  {
    int spot = -1;
    int counter = 0;
    boolean hasMoreImages = true;
    while (hasMoreImages)
    {
      spot = line.indexOf("<img ", spot+1);
      if (spot > -1)
        counter++;
      else
        hasMoreImages = false;
    }
    return counter;   
  } 
   public static int countDoge(String line)
  {
    int spot = -1;
    int counter = 0;
    boolean hasMoreDoge = true;
    while (hasMoreDoge)
    {
      spot = line.indexOfIgnoreCase("doge ", spot+1);
      if (spot > -1)
        counter++;
      else
        hasMoreDoge = false;
    }
    return counter;   
  } 
   public static int countHarambe(String line)
  {
    int spot = -1;
    int counter = 0;
    boolean hasMoreHarambe = true;
    while (hasMoreHarambe)
    {
      spot = line.indexOfIgnoreCase("harambe ", spot+1);
      if (spot > -1)
        counter++;
      else
        hasMoreHarambe = false;
    }
    return counter;   
  } 
   public static int countTrump(String line)
  {
    int spot = -1;
    int counter = 0;
    boolean hasMoreTrump = true;
    while (hasMoreTrump)
    {
      spot = line.indexOfIgnoreCase("trump ", spot+1);
      if (spot > -1)
        counter++;
      else
        hasMoreTrump = false;
    }
    return counter;   
  } 
  public static int countPepe(String line)
  {
    int spot = -1;
    int counter = 0;
    boolean hasMorePepe = true;
    while (hasMorePepe)
    {
      spot = line.indexOfIgnoreCase("pepe ", spot+1);
      if (spot > -1)
        counter++;
      else
        hasMorePepe = false;
    }
    return counter;   
  } 
}
