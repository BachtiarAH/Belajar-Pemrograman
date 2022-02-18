/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.CRUD.fungtion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author user
 */
public class operasi {
    //mengupdate/menghapus data
    public static void updateData()throws IOException{
        //mengambil data base original
        File DataBase = new File("data base/koleksi buku.txt");
        FileReader InputFile = new FileReader(DataBase);
        BufferedReader BufferedInputFile = new BufferedReader(InputFile);
        
        //membuat data base sementara
        File tempDB = new File("data base/tempDB");
        FileWriter OutputFile = new FileWriter(tempDB);
        BufferedWriter BufferedOutputFile = new BufferedWriter(OutputFile);
                       
        //tampilkan data base original
        System.out.println("\nList Buku : \n");
        tampilData();
        
        //mengambil user input
        System.out.print("masukan nomer data yang akan anda edit : ");
        Scanner inputTerminal = new Scanner(System.in);
        long updateNum =inputTerminal.nextLong();
        
        //menampilkan data yang akan di update
        long numEntry = 0;
        String data = BufferedInputFile.readLine();
        
        
        while(data != null){
            StringTokenizer nt = new StringTokenizer(data,",");
            numEntry++;
            
            //menampilkan data dengan nomer referensi yang sudah dipilih user
            if(updateNum==numEntry){
                System.out.println("\ndata yang akan diedit adalah sebagai berikut : ");
                System.out.println("----------------------------------------------");
                System.out.println("Primary Key   :"+nt.nextToken());
                System.out.println("Tahun         :"+nt.nextToken());
                System.out.println("Pengarang     :"+nt.nextToken());
                System.out.println("Penerbit      :"+nt.nextToken());
                System.out.println("Judul Buku    :"+nt.nextToken());
                
                //edit data
                
                nt = new StringTokenizer(data, ",");
                
                String[] fieldData = {"tahun","penulis","penerbit","judul"};
                String[] tempData = new String[4];
                String dataOri =nt.nextToken();
                
                for(int i=0;i<fieldData.length;i++){
                    boolean isEdited = utiliti.getYesOrNo("ingni mengedit data "+fieldData[i]+" baru : ");
                    
                    dataOri = nt.nextToken();
                    if (isEdited) {
                        inputTerminal = new Scanner(System.in);
                        System.out.print("\nmasukan data "+fieldData[i]+" baru ");
                        tempData[i] = inputTerminal.nextLine();
                    }else{
                        
                        tempData[i] = dataOri;
                    }
                        
                }
                
                //menampilkan perubahan data
                
                nt = new StringTokenizer(data,",");
                nt.nextToken();
                String tahun = tempData[0];
                String penulis = tempData[1];
                String penerbit = tempData[2];
                String judul = tempData[3];
                
                System.out.println("\nperubahan data adalah sebagai berikut : ");
                System.out.println("----------------------------------------------");
                System.out.println("Tahun         :"+nt.nextToken() + " ---> " + tahun);
                System.out.println("Pengarang     :"+nt.nextToken() + " ---> " + penulis);
                System.out.println("Penerbit      :"+nt.nextToken() + " ---> " + penerbit);
                System.out.println("Judul Buku    :"+nt.nextToken() + " ---> " + judul);
                       
                boolean isUpdate = utiliti.getYesOrNo("apakah anda yakin dengan perubahan tersebut?");
                

                
                if (isUpdate) {
                    //System.out.println(keywordCekData);
                    boolean isAxist = utiliti.cekDataBase(tempData, false);
                    
                    if (isAxist) {
                        System.err.println("data yang anda masukan tidak memiliki perubahan");
                    }else{
                        //format data
                        long Entrypertahun = utiliti.getEntryPerTahun(penulis, tahun);
                        String PrimaryKey = penulis + "_" + tahun + "_" + Entrypertahun;
                        String DataToPost = PrimaryKey+","+tempData[0]+","+tempData[1]+","+tempData[2]+","+tempData[3];
                        
                        //tulis ke database sementara
                        BufferedOutputFile.write(DataToPost);

                    }
                    
                }else{
                    BufferedOutputFile.write(data);

                }
                
            }else{
                BufferedOutputFile.write(data);

            }
            BufferedOutputFile.newLine();
            BufferedOutputFile.flush();
            
            data = BufferedInputFile.readLine();
        }
                
        //menutup input bufferedd
        BufferedInputFile.close();
        InputFile.close();
        BufferedOutputFile.close();
        OutputFile.close();
        
        System.gc();
        
        //menghapus database lama
        if(DataBase.delete()){
        System.out.println("\ndatabase dihapus");
        }else if(!DataBase.delete()){
            System.out.println("\ndatabase gagal diapus");
        }
        
//mengubah nama databse sementara menjadi database
        if(tempDB.renameTo(DataBase)){
        System.out.println("\ndatabase diperbarui");
        }else if(!tempDB.renameTo(DataBase)){
            System.out.println("\ndatabase gagal diperbarui");
        }
    }
    
    //menghapus data di database
    public static void hapuData()throws IOException{
        //mengambil database original
        File dataBase = new File("data base/koleksi buku.txt");
        FileReader FileInput = new FileReader(dataBase);
        BufferedReader bufferedFile = new BufferedReader(FileInput);
        
        
        //buat database sementara
        File tempDB = new File("data base/tempDB.txt");
        FileWriter fileOutput = new FileWriter(tempDB);
        BufferedWriter BufferedOutput = new BufferedWriter(fileOutput);
        
        //lihat database original
        System.out.println("\nlist buku: ");
        tampilData();
        
        //ambil input database yang akan dihapus
        Scanner inputTerminal = new Scanner(System.in);
        System.out.print("masukan nomor buku yang akan dihapus: ");
        long deletnum = inputTerminal.nextLong();
        
        //copy database original ke database sementara kecuali database yang diinputkan
        long entrynum = 0;
        boolean isFound = false;
        String data = bufferedFile.readLine();
        
        
        while(data != null){
            isFound = false;
            boolean isDelete = false;
            entrynum++;
            
            if (entrynum == deletnum) {
                StringTokenizer St = new StringTokenizer(data,",");
                System.out.println("\ndata yang akan didelet adalah berikut");
                System.out.println("--------------------------------------");
                System.out.println("no referensi    : "+St.nextToken());
                System.out.println("Tahun           : "+St.nextToken());
                System.out.println("Penulis         : "+St.nextToken());
                System.out.println("Penerbit        : "+St.nextToken());
                System.out.println("Judul           : "+St.nextToken());
                
                isDelete = utiliti.getYesOrNo("apakah anda yakin akan menghapus data diatas?");
                isFound = true;
            }
            if (isDelete) {
                //mengcopy kecuali data
                System.out.println("data terhapus");
            }else{
                
                //mengcopy tanpa terkecuali
                BufferedOutput.write(data);
                BufferedOutput.newLine();
            }
            data = bufferedFile.readLine();
        }
        
        if (isFound) {
            System.out.println("database not found");
        }
        
        //menulis database sementara
        BufferedOutput.flush();
        System.out.println("\nperbaruan disimpan");
        
        //menutup input bufferedd
        bufferedFile.close();
        FileInput.close();
        BufferedOutput.close();
        fileOutput.close();
        
        System.gc();
        
        //menghapus database lama
        if(dataBase.delete()){
        System.out.println("\ndatabase dihapus");
        }else if(!dataBase.delete()){
            System.out.println("\ndatabase gagal diapus");
        }
        
//mengubah nama databse sementara menjadi database
        if(tempDB.renameTo(dataBase)){
        System.out.println("\ndatabase diperbarui");
        }else if(!tempDB.renameTo(dataBase)){
            System.out.println("\ndatabase gagal diperbarui");
        }
    }
    
    //menambah kan data buku kedalam database
    public static void tambahData()throws IOException{
        FileWriter fileDatabase = new FileWriter("data base/koleksi buku.txt",true);
        BufferedWriter bufferedData = new BufferedWriter(fileDatabase);
        
        //menginput data 
        Scanner inputTerminal = new Scanner(System.in);
        String pengarang, judulBuku, tahun, penerbit;
        
        System.out.print("masukan nama pengarang : ");
        pengarang = inputTerminal.nextLine();
        System.out.print("masukan judul buku : ");
        judulBuku = inputTerminal.nextLine();
        System.out.print("masukan penerbit buku : ");
        penerbit = inputTerminal.nextLine();
        System.out.print("masukan tahun buku : ");
        tahun = utiliti.ambilTahun();
        
        //cek apakah ada data yang sama
        //2019,bakti,ababil,bakti ganteng
        String[] keyword = {tahun+","+pengarang+","+penerbit+","+judulBuku};
        
        boolean isAxist = utiliti.cekDataBase(keyword, false);
        
        //mencatatkan data ke database
        if(!isAxist){
            
            System.out.println("cekaxist");
            long inidexBukuPenulis = utiliti.getEntryPerTahun(pengarang, tahun);
           // System.out.println("entry = "+inidexBukuPenulis);
            String namaTanpaSpasi = pengarang.replaceAll(" ", "");
            
            String PrimaryKey = namaTanpaSpasi+"_"+tahun+"_"+inidexBukuPenulis;
            
            
            
            
            System.out.println("\ndata yang anda masukan adalah");
            System.out.println("Primary Key : "+PrimaryKey);
            System.out.println("Tahun       : "+tahun);
            System.out.println("Penulis     : "+pengarang);
            System.out.println("Penerbit    : "+penerbit);
            System.out.println("Judul Buku  : "+judulBuku);
            
            String bufferInput = PrimaryKey+","+tahun+","+pengarang+","+penerbit+","+judulBuku;
            boolean dataBenar = utiliti.getYesOrNo("\napakah anda memasukan data diatas?");
            if(dataBenar){
                
                bufferedData.write(bufferInput);
                bufferedData.newLine();
                bufferedData.flush();
            }
            
        }else{
            System.out.println("\nData yang anda masukan sudah ada di dalam database");
            utiliti.cekDataBase(keyword, true);
        }
        bufferedData.close();
        fileDatabase.close(); 
    }
    
    //menampilkan data perpustakaan
    public static void tampilData()throws IOException{
        String data;
        FileReader fileInput;
        BufferedReader bufferedInput;
        
        try{
        fileInput = new FileReader("data base/koleksi buku.txt");
        bufferedInput = new BufferedReader(fileInput);
        }catch(Exception e){
            System.err.println("database tidak ditemukan\n"+e.getMessage());
            System.err.println("tolong buat data base terlebih dahulu");
            tambahData();
            return;
        }
        
        
        System.out.println("| no |\ttahun |\tpenulis              |\tPenerbit             |\tJudul Buku");
        System.out.println("---------------------------------------------------------------------------");

        data = bufferedInput.readLine();
        int nomorData = 0;
        
        while (data != null) {
        
            StringTokenizer stringToken = new StringTokenizer(data,",");
            stringToken.nextToken();
            nomorData++;

            System.out.printf("| %2d ",nomorData);
            System.out.printf("|\t%4s  ",stringToken.nextToken());
            System.out.printf("|\t%-20s ",stringToken.nextToken());
            System.out.printf("|\t%-20s ",stringToken.nextToken());
            System.out.printf("|\t%s ",stringToken.nextToken());
            System.out.print("\n");

            data = bufferedInput.readLine();
        }
        System.out.println("---------------------------------------------------------------------------");
    }
    
    //mengecek apakah database ada dan mencari buku dengan menggunakan keyword
    public static void cariData()throws IOException{
        try{
            File fileInput = new File("data base/koleksi buku.txt");
        }catch(Exception e){
            System.err.println("database tidak ditemukan\n"+e.getMessage());
            return;
        }
        
        Scanner inputTerminal = new Scanner(System.in);
        System.out.print("Silahkan masukan keyword ");
        String keywordCari = inputTerminal.nextLine();
        
        String[] keywordSplit = keywordCari.split("\\s");
        utiliti.cekDataBase(keywordSplit,true);
    }
}
