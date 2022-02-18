/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.CRUD;

//import java utiliti
import java.io.IOException;
import java.util.Scanner;

//import CRUD.fungtion
import com.CRUD.fungtion.*;

public class main {
    public static void main(String[] args)throws IOException{
        Scanner InputConsole = new Scanner(System.in);
        boolean isLanjutkan = true;
        
        while(isLanjutkan){
            utiliti.clearScreen();
            System.out.println("Data Base Perpustakaan");
            System.out.println("");
            System.out.println("1.Menu List Koleksi Buku");
            System.out.println("2.Menu Cari Data Buku");
            System.out.println("3.Menu Tambah Data Buku");
            System.out.println("4.Menu Ubah Data Buku");
            System.out.println("5.Menu Hapus Data Buku");

            System.out.println("");
            System.out.print("masukan pilihan anda ");
            String pilihanUser = InputConsole.next();

            switch(pilihanUser){
                case "1":
                    //masuk menu list koleksi buku
                    System.out.println("=================");
                    System.out.println("LIST KOLEKSI BUKU");
                    System.out.println("=================");
                    operasi.tampilData();
                    break;
                case "2":
                    //masuk menu pencarian buku
                    System.out.println("==============");
                    System.out.println("CARI DATA BUKU");
                    System.out.println("==============");
                    operasi.cariData();
                    break;
                case "3":
                    //masuk menu tambah buku
                    System.out.println("================");
                    System.out.println("TAMBAH DATA BUKU");
                    System.out.println("================");
                    operasi.tambahData();
                    operasi.tampilData();
                    break;
                case "4":
                    //masuk menu ubah data buku
                    System.out.println("==============");
                    System.out.println("UBAH DATA BUKU");
                    System.out.println("==============");
                    operasi.updateData();
                    break;
                case "5":
                    //masuk menu hapus buku
                    System.out.println("===============");
                    System.out.println("HAPUS DATA BUKU");
                    System.out.println("===============");
                    operasi.hapuData();
                    break;
                default:
                    System.err.println("\nMasukan Anda tidak valid mohon masukan angka [1-5}");
            }
            isLanjutkan = utiliti.getYesOrNo("\nApakah anda ingin melanjutkan?");
        }
    }
    
    
    
   
   
    
    
}
