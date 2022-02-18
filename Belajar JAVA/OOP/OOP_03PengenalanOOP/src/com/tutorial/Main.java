package com.tutorial;

class mahasiswa{
    String nama;
    String nim;
    String jurusan;
    float ipk;
    int umur;
}

public class Main{
    public static void main(String[] args) {
        mahasiswa mahasiswa1 = new mahasiswa();
        mahasiswa1.nama = "bachtiar";
        mahasiswa1.nim = "E41211696";
        mahasiswa1.jurusan = "Teknologi Informasi";
        mahasiswa1.ipk = 3.55f;
        mahasiswa1.umur = 19;
        System.out.println(mahasiswa1.nama);
        System.out.println(mahasiswa1.nim);
        System.out.println(mahasiswa1.jurusan);
        System.out.println(mahasiswa1.ipk);
        System.out.println(mahasiswa1.umur);

        
        mahasiswa mahasiswa2 = new mahasiswa();
        mahasiswa2.nama = "bachtiar";
        mahasiswa2.nim = "E41211696";
        mahasiswa2.jurusan = "Teknologi Informasi";
        mahasiswa2.ipk = 3.55f;
        mahasiswa2.umur = 19;
        System.out.println(mahasiswa2.nama);
        System.out.println(mahasiswa2.nim);
        System.out.println(mahasiswa2.jurusan);
        System.out.println(mahasiswa2.ipk);
        System.out.println(mahasiswa2.umur);
    }
}