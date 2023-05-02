import java.io.File;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;


public class WordCount
{

    public static String inputFile;
    public static int char1;
    public static int word1;
    public static int line1;
    public static boolean need1;
    public static boolean need2;
    public static void main(String[] args)
    {


        inputFile="";
        for(int i=0;i<args.length;i++)//Java�����в���ƥ��
        {

            if ("-c".equals(args[i])) {
                need1 = true;
            } else if ("-w".equals(args[i])) {
                need2 = true;
            } else {
                if (!args[i - 1].equals("-e") && !args[i - 1].equals("-o")) {

                    inputFile = args[i];
                }
            }

        }
        String outputStr="";
            String fileShortName=inputFile.substring(inputFile.lastIndexOf("\\")+1);
            if(need1||need2)
            {

                getBasicInfo(inputFile);


                if(need1)
                {

                    outputStr+=fileShortName;
                    outputStr+=", char: ";
                    outputStr+=char1;
                    System.out.println(outputStr);
                }
                if(need2)
                {

                    outputStr+=fileShortName;
                    outputStr+=", word: ";
                    outputStr+=word1;
                    System.out.println(outputStr);
                }
            }

        }



    public static void getBasicInfo(String fileName)
    {
        char1=0;
        word1=0;
        line1=0;
        char charNow;
        try
        {
            File filename = new File(fileName);
            InputStreamReader reader = new InputStreamReader(
                    new FileInputStream(filename));
            BufferedReader br = new BufferedReader(reader);//����һ��������
            String line ;
            line = br.readLine();//һ��һ�еĶ�ȡ
            while (line != null)
            {
                char1+=line.length();
                line1++;
                boolean partition = true;

                for(int i=0;i<line.length();i++)
                {
                    charNow=line.charAt(i);
                    if(charNow != ' ' && charNow != '\t' && charNow != ',' && charNow != '.')
                    {

                    }
                    else {
                        word1++;
                    }

                }
                line = br.readLine();
                if(line  != null){
                    word1++;//�������һ�У�������һ�����һ������
                }
            }
            char1+=line1-1;//����ǰ�漸�еĻ��з���
            word1+=1;//�������һ��δ��ͳ�Ƶĵ��ʡ�
            br.close();
        }

        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}