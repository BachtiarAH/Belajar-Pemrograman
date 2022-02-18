/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.CRUD.fungtion;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Year;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author user
 */
public class utiliti {
    protected static long getEntryPerTahun(String nama, String tahun)throws IOException{
        FileReader FileInput = new FileReader("data base/koleksi buku.txt");
        BufferedReader bufferedFile = new BufferedReader(FileInput);
        
        String Data = bufferedFile.readLine();
        Scanner DataScanner;
        String PrimaryKey;
        nama.replaceAll(" ", "");
        long entry=1;
        
        while (Data != null) { 
            DataScanner = new Scanner(Data);
            DataScanner.useDelimiter(",");
            PrimaryKey = DataScanner.next();
            DataScanner = new Scanner(PrimaryKey);
            DataScanner.useDelimiter("_");
            if(DataScanner.next().equalsIgnoreCase(nama) && DataScanner.next().equalsIgnoreCase(tahun)){
                entry = DataScanner.nextLong();
                entry++;
                //System.out.println("entry = " + entry);
                
            }
            Data = bufferedFile.readLine();
        }
        return entry;
        
                
        
    }
    
    protected static String ambilTahun(){
        boolean isValid = false;
        Scanner inputTerminal = new Scanner(System.in);
        String tahun = inputTerminal.nextLine();
        
        while (!isValid) {           
            try{
                Year.parse(tahun);
                isValid = true;
            }catch(Exception e){
                System.err.println("format tahun yang anda masukan salah, format tahun = (yyyy)");
                System.out.print("masukan tahun buku : ");
                isValid = false;
                tahun = inputTerminal.nextLine();
            }
        }
        
        return tahun;
    }
    
    //mcek apakah keyword ada
    protected static boolean cekDataBase(String[] keywords,boolean display)throws IOException{
        FileReader FileReaded = new FileReader("data base/koleksi buku.txt");
        BufferedReader bufferedFile = new BufferedReader(FileReaded);
        
        String data = bufferedFile.readLine();
        int nomorData = 0;
        
        boolean isExist = false;
        if(display){
        System.out.println("| no |\ttahun |\tpenulis              |\tPenerbit             |\tJudul Buku");
        System.out.println("---------------------------------------------------------------------------");
        }
        while (data != null) {            
            isExist = true;
            for (String keyword : keywords) {
                isExist &=data.toLowerCase().contains(keyword.toLowerCase());
            }
                if (isExist) {
                    StringTokenizer stringToken = new StringTokenizer(data,",");
                    stringToken.nextToken();
                    nomorData++;

                    if(display){
                    System.out.printf("| %2d ",nomorData);
                    System.out.printf("|\t%4s  ",stringToken.nextToken());
                    System.out.printf("|\t%-20s ",stringToken.nextToken());
                    System.out.printf("|\t%-20s ",stringToken.nextToken());
                    System.out.printf("|\t%s ",stringToken.nextToken());
                    System.out.print("\n");
                    }
                    if(!display)
                    break;
                    //return isExist;
                }
            data = bufferedFile.readLine();
        }
        if(display){
        System.out.println("---------------------------------------------------------------------------");
        }
            return isExist;    
    }
      
    //get Yes Or NO From massage Question
    public static boolean getYesOrNo(String massage){
        Scanner inpuTerminal = new Scanner(System.in);
        String bufferInput;
        System.out.print(massage + "[y/n]");
        bufferInput = inpuTerminal.next();
        
        while (!bufferInput.equalsIgnoreCase("y")&&!bufferInput.equalsIgnoreCase("n")) {            
            System.err.println("yang anda msukan bukan y ataupun n");
            System.out.print(massage + "[y/n]");
            bufferInput = inpuTerminal.next();
        }
        
        return bufferInput.equalsIgnoreCase("y");
    }
    
    //cls command promt for windows or clear for unix
    public static void clearScreen(){
        try{
        if(System.getProperty("os.name").contains("Windows")){
            new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
        }else{
            System.out.print("\033\143");
        }
        }catch(Exception ex){
                System.out.println("tidak bisa membersihkan layar");
        }
    }
}
