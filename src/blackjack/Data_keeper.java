package blackjack;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author mahmo
 */
public class Data_keeper {
    private String path;

    Data_keeper() {
        String userDirectory = System.getProperty("user.home");
        path = userDirectory+"\\Documents\\game_data.txt";
    }
    public boolean file_exist()
    {
        return new File(path).exists();
    }
    public void Change_Path(String path)
    {
        this.path = path;
    }
    public void Write_encrypted(String data)
    {
        try {
            PrintWriter out = new PrintWriter(new FileWriter(path));
            int size = data.length();
            String temp = encrypt_string(data);
            out.println(temp);
            out.close();
        } catch (IOException ex) {}
    }
    public String Read_encrypted_next()
    {
        String temp = null;
        try {
            Scanner in =new Scanner(new File(path));
            temp = decrypt_string(in.next());
            in.close();
        } catch (FileNotFoundException ex) {}
        return temp;
    }
    public String Read_encrypted_nextline()
    {
        String temp = null;
        try {
            Scanner in =new Scanner(new File(path));
            temp = decrypt_string(in.nextLine());
            in.close();
        } catch (FileNotFoundException ex) {}
        return temp;
    }
    private char encrypt_char(char c)
    {
        return (char)(c^111);
    }
    private String encrypt_string(String w)
    {
        int size = w.length();
        String temp = "";
        for(int counter = 0;counter<size;counter++)
        {
            temp += (char)(w.charAt(counter)^111);
        }
        return temp;
    }
    private char decrypt_char(char c)
    {
        return (char)(c^111);
    }
    private String decrypt_string(String w)
    {
        int size = w.length();
        String temp = "";
        for(int counter = 0;counter<size;counter++)
        {
            temp += (char)(w.charAt(counter)^111);
        }
        return temp;
    }
}
