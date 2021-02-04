import java.util.*;

public class newblock {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите номер задания: ");
        String zadanie = scan.nextLine();
        switch (zadanie)
        {
            case "1" :
                n1(scan);
                break;
            case "2" :
                n2(scan);
                break;
            case "3" :
                n3(scan);
                break;
            case "4":
                n4(scan);
                break;
            case "5":
                n5(scan);
                break;
        }
        scan.close();
    }

    public static void n1(Scanner scan)
    {
        System.out.println("Введите первую строку: ");
        String str1 = scan.nextLine();
        str1 = str1.toLowerCase();
        
        System.out.println("Введите вторую строку: ");
        String str2 = scan.nextLine();
        str2 = str2.toLowerCase();
        
        boolean flag = false;
        
        char[] sort2 = str2.toCharArray();
        java.util.Arrays.sort(sort2);
        String newstr2 = new String(sort2);
        
        for (int i = 0; i < str1.length(); i++)
        {
            String s = str1.substring(i, i + str2.length());
            char[] sort = s.toCharArray();
            java.util.Arrays.sort(sort);
            String newstr1 = new String(sort);
            if (newstr2.equals(newstr1))
            {
               System.out.println(s);
               flag = true;
               break;
            }
        }
        
        if (!flag)
        {
            System.out.println("noutfond");
        }
    }

    public static void n2(Scanner scan)
    {
        System.out.println("Введите строку: ");
        String str = scan.nextLine();
        
        System.out.println("Введите число: ");
        int num = scan.nextInt();
        
        System.out.println(str);
        
        int length = str.length() / num;
        String[] result  = new String[length];
        for (int i = 0; i < length; i++)
        {
            result[i] = str.substring(i * num, i * num + num);
        }
        
        Arrays.sort(result);
        
        for (int i = 0; i < length; i++)
        {
            System.out.println(result[i]);
        }
    }
    
    public static void n3(Scanner scan)
    {
        System.out.println("Введите строку: ");
        String str = scan.nextLine();
        
        System.out.println("Введите ключ: ");
        String key = scan.nextLine();
        
        int c = 0;
        int strk = str.length() / key.length() + 2;
        int stol = key.length();
        char[] keynum = new char[key.length()];
        char[][] darr = new char[strk][stol];
        char[][] farr = new char[strk][stol];
        
        for (int i = 0; i < key.length(); i++)
        {
            int asc = (char) key.charAt(i);
            for (int j = 0; j < key.length(); j++)
            {
                int dopasc = (char) key.charAt(j);
                if (dopasc <= asc)
                {
                    c++;
                }
            }
            keynum[i] = (char) (c + 48);
            c = 0;
        }
        for (int i = 0; i < key.length(); i++)
        {
            darr[0][i] = keynum[i];
            
        }
        int st = 1;
        int k = 0;
        for (int i = 0; i < stol; i++)
        {
            if (k < str.length())
            {
                darr[st][i] = str.charAt(k);
                k++;
            }
            else
            {
                while(i < stol)
                {
                    darr[st][i] = ' ';
                    i++;
                }
                break;
            }
            if (i + 1 == stol)
            {
                st++;
                i = -1;
            }
        }
        
        System.out.println("Получившийся массив:");
        System.out.print("\n");
        
        st = 0;
        for (int i = 0; i < stol; i++)
        {
            System.out.print(darr[st][i] + " ");
            if (i + 1 == stol)
            {
                st++;
                if (st > strk - 1)
                {
                    break;
                }
                i = -1;
                System.out.print("\n");
            }
        }
        System.out.print("\n");
        System.out.print("\n");
        System.out.println("Массив после преобразований:");
        System.out.print("\n");
        
        int n = 1;
        int r = 0;
        for (int i = 0; i < stol; i++)
        {
            int asc = (char) darr[0][i] - 48;
            if (asc == n)
            {
                for (int j = 0; j < strk; j++)
                {
                    farr[j][r] = darr[j][i];
                }
                r++;
                i = -1;
                n++;
            }
        }
        
        st = 0;
        for (int i = 0; i < stol; i++)
        {
            System.out.print(farr[st][i] + " ");
            if (i + 1 == stol)
            {
                st++;
                if (st > strk - 1)
                {
                    break;
                }
                i = -1;
                System.out.print("\n");
            }
        }
        
        System.out.print("\n");
        System.out.print("\n");
        System.out.println("Ответ:");
        
        for (int i = 1; i < strk; i++)
        {
            for (int j = 0; j < stol; j++)
            {
                System.out.print(farr[i][j]);
            }
        }
        
    }
    
    public static void n4(Scanner scan)
    {
        System.out.println("Введите количество элементов массива:");
        int n = scan.nextInt();
        int[] arr = new int[n];
        System.out.println("Введите массив:");
        for (int i = 0; i < n; i++)
        {
            arr[i] = scan.nextInt();
        }
        System.out.println("Введите число:");
        int num = scan.nextInt();
        int[] res = new int[2];
        for (int i = 1; i < n; i++)
        {
            for (int j = 0; j < i; j++)
            {
                if (arr[i] * arr[j] == num)
                {
                    res[0] = arr[i];
                    res[1] = arr[j];
                    for (int k = 0; k < 2; k++)
                    {
                       System.out.println(res[k]); 
                    }
                    break;
                }
            }
        }
    }
    
    public static void n5(Scanner scan)
    {
        System.out.println("Введите число:");
        int num = scan.nextInt();
        int tek = 1;
        int c = 1;
        int[] res = new int[2];
        while (tek < num)
        {
            tek = tek * c;
            if (tek == num)
            {
                res[0] = num;
                res[1] = c;
                for (int k = 0; k < 2; k++)
                {
                   System.out.println(res[k]); 
                }
            }
            c++;
        }
    }
}